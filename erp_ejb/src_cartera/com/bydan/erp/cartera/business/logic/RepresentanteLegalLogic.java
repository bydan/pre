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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.RepresentanteLegalConstantesFunciones;
import com.bydan.erp.cartera.util.RepresentanteLegalParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RepresentanteLegalParameterGeneral;
import com.bydan.erp.cartera.business.entity.RepresentanteLegal;
import com.bydan.erp.cartera.business.logic.RepresentanteLegalLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RepresentanteLegalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RepresentanteLegalLogic.class);
	
	protected RepresentanteLegalDataAccess representantelegalDataAccess; 	
	protected RepresentanteLegal representantelegal;
	protected List<RepresentanteLegal> representantelegals;
	protected Object representantelegalObject;	
	protected List<Object> representantelegalsObject;
	
	public static ClassValidator<RepresentanteLegal> representantelegalValidator = new ClassValidator<RepresentanteLegal>(RepresentanteLegal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RepresentanteLegalLogicAdditional representantelegalLogicAdditional=null;
	
	public RepresentanteLegalLogicAdditional getRepresentanteLegalLogicAdditional() {
		return this.representantelegalLogicAdditional;
	}
	
	public void setRepresentanteLegalLogicAdditional(RepresentanteLegalLogicAdditional representantelegalLogicAdditional) {
		try {
			this.representantelegalLogicAdditional=representantelegalLogicAdditional;
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
	
	
	
	
	public  RepresentanteLegalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.representantelegalDataAccess = new RepresentanteLegalDataAccess();
			
			this.representantelegals= new ArrayList<RepresentanteLegal>();
			this.representantelegal= new RepresentanteLegal();
			
			this.representantelegalObject=new Object();
			this.representantelegalsObject=new ArrayList<Object>();
				
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
			
			this.representantelegalDataAccess.setConnexionType(this.connexionType);
			this.representantelegalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RepresentanteLegalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.representantelegalDataAccess = new RepresentanteLegalDataAccess();
			this.representantelegals= new ArrayList<RepresentanteLegal>();
			this.representantelegal= new RepresentanteLegal();
			this.representantelegalObject=new Object();
			this.representantelegalsObject=new ArrayList<Object>();
			
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
			
			this.representantelegalDataAccess.setConnexionType(this.connexionType);
			this.representantelegalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RepresentanteLegal getRepresentanteLegal() throws Exception {	
		RepresentanteLegalLogicAdditional.checkRepresentanteLegalToGet(representantelegal,this.datosCliente,this.arrDatoGeneral);
		RepresentanteLegalLogicAdditional.updateRepresentanteLegalToGet(representantelegal,this.arrDatoGeneral);
		
		return representantelegal;
	}
		
	public void setRepresentanteLegal(RepresentanteLegal newRepresentanteLegal) {
		this.representantelegal = newRepresentanteLegal;
	}
	
	public RepresentanteLegalDataAccess getRepresentanteLegalDataAccess() {
		return representantelegalDataAccess;
	}
	
	public void setRepresentanteLegalDataAccess(RepresentanteLegalDataAccess newrepresentantelegalDataAccess) {
		this.representantelegalDataAccess = newrepresentantelegalDataAccess;
	}
	
	public List<RepresentanteLegal> getRepresentanteLegals() throws Exception {		
		this.quitarRepresentanteLegalsNulos();
		
		RepresentanteLegalLogicAdditional.checkRepresentanteLegalToGets(representantelegals,this.datosCliente,this.arrDatoGeneral);
		
		for (RepresentanteLegal representantelegalLocal: representantelegals ) {
			RepresentanteLegalLogicAdditional.updateRepresentanteLegalToGet(representantelegalLocal,this.arrDatoGeneral);
		}
		
		return representantelegals;
	}
	
	public void setRepresentanteLegals(List<RepresentanteLegal> newRepresentanteLegals) {
		this.representantelegals = newRepresentanteLegals;
	}
	
	public Object getRepresentanteLegalObject() {	
		this.representantelegalObject=this.representantelegalDataAccess.getEntityObject();
		return this.representantelegalObject;
	}
		
	public void setRepresentanteLegalObject(Object newRepresentanteLegalObject) {
		this.representantelegalObject = newRepresentanteLegalObject;
	}
	
	public List<Object> getRepresentanteLegalsObject() {		
		this.representantelegalsObject=this.representantelegalDataAccess.getEntitiesObject();
		return this.representantelegalsObject;
	}
		
	public void setRepresentanteLegalsObject(List<Object> newRepresentanteLegalsObject) {
		this.representantelegalsObject = newRepresentanteLegalsObject;
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
		
		if(this.representantelegalDataAccess!=null) {
			this.representantelegalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			representantelegalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			representantelegalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		representantelegal = new  RepresentanteLegal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			representantelegal=representantelegalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.representantelegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegal);
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
		representantelegal = new  RepresentanteLegal();
		  		  
        try {
			
			representantelegal=representantelegalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.representantelegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		representantelegal = new  RepresentanteLegal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			representantelegal=representantelegalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.representantelegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegal);
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
		representantelegal = new  RepresentanteLegal();
		  		  
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
		representantelegal = new  RepresentanteLegal();
		  		  
        try {
			
			representantelegal=representantelegalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.representantelegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		representantelegal = new  RepresentanteLegal();
		  		  
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
		representantelegal = new  RepresentanteLegal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =representantelegalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		representantelegal = new  RepresentanteLegal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=representantelegalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		representantelegal = new  RepresentanteLegal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =representantelegalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		representantelegal = new  RepresentanteLegal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=representantelegalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		representantelegal = new  RepresentanteLegal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =representantelegalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		representantelegal = new  RepresentanteLegal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=representantelegalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		representantelegals = new  ArrayList<RepresentanteLegal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegals=representantelegalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRepresentanteLegal(representantelegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
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
		representantelegals = new  ArrayList<RepresentanteLegal>();
		  		  
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
		representantelegals = new  ArrayList<RepresentanteLegal>();
		  		  
        try {			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegals=representantelegalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRepresentanteLegal(representantelegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		representantelegals = new  ArrayList<RepresentanteLegal>();
		  		  
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
		representantelegals = new  ArrayList<RepresentanteLegal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegals=representantelegalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRepresentanteLegal(representantelegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
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
		representantelegals = new  ArrayList<RepresentanteLegal>();
		  		  
        try {
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegals=representantelegalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRepresentanteLegal(representantelegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
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
		representantelegals = new  ArrayList<RepresentanteLegal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegals=representantelegalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRepresentanteLegal(representantelegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
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
		representantelegals = new  ArrayList<RepresentanteLegal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegals=representantelegalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRepresentanteLegal(representantelegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		representantelegal = new  RepresentanteLegal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegal=representantelegalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRepresentanteLegal(representantelegal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegal);
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
		representantelegal = new  RepresentanteLegal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegal=representantelegalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRepresentanteLegal(representantelegal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		representantelegals = new  ArrayList<RepresentanteLegal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegals=representantelegalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRepresentanteLegal(representantelegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
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
		representantelegals = new  ArrayList<RepresentanteLegal>();
		  		  
        try {
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegals=representantelegalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRepresentanteLegal(representantelegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRepresentanteLegalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		representantelegals = new  ArrayList<RepresentanteLegal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getTodosRepresentanteLegalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRepresentanteLegal(representantelegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
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
	
	public  void  getTodosRepresentanteLegals(String sFinalQuery,Pagination pagination)throws Exception {
		representantelegals = new  ArrayList<RepresentanteLegal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRepresentanteLegal(representantelegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRepresentanteLegal(RepresentanteLegal representantelegal) throws Exception {
		Boolean estaValidado=false;
		
		if(representantelegal.getIsNew() || representantelegal.getIsChanged()) { 
			this.invalidValues = representantelegalValidator.getInvalidValues(representantelegal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(representantelegal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRepresentanteLegal(List<RepresentanteLegal> RepresentanteLegals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RepresentanteLegal representantelegalLocal:representantelegals) {				
			estaValidadoObjeto=this.validarGuardarRepresentanteLegal(representantelegalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRepresentanteLegal(List<RepresentanteLegal> RepresentanteLegals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRepresentanteLegal(representantelegals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRepresentanteLegal(RepresentanteLegal RepresentanteLegal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRepresentanteLegal(representantelegal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RepresentanteLegal representantelegal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+representantelegal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RepresentanteLegalConstantesFunciones.getRepresentanteLegalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"representantelegal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RepresentanteLegalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RepresentanteLegalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRepresentanteLegalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-saveRepresentanteLegalWithConnection");connexion.begin();			
			
			RepresentanteLegalLogicAdditional.checkRepresentanteLegalToSave(this.representantelegal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RepresentanteLegalLogicAdditional.updateRepresentanteLegalToSave(this.representantelegal,this.arrDatoGeneral);
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.representantelegal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRepresentanteLegal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRepresentanteLegal(this.representantelegal)) {
				RepresentanteLegalDataAccess.save(this.representantelegal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.representantelegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RepresentanteLegalLogicAdditional.checkRepresentanteLegalToSaveAfter(this.representantelegal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRepresentanteLegal();
			
			connexion.commit();			
			
			if(this.representantelegal.getIsDeleted()) {
				this.representantelegal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRepresentanteLegal()throws Exception {	
		try {	
			
			RepresentanteLegalLogicAdditional.checkRepresentanteLegalToSave(this.representantelegal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RepresentanteLegalLogicAdditional.updateRepresentanteLegalToSave(this.representantelegal,this.arrDatoGeneral);
			
			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.representantelegal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRepresentanteLegal(this.representantelegal)) {			
				RepresentanteLegalDataAccess.save(this.representantelegal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.representantelegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RepresentanteLegalLogicAdditional.checkRepresentanteLegalToSaveAfter(this.representantelegal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.representantelegal.getIsDeleted()) {
				this.representantelegal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRepresentanteLegalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-saveRepresentanteLegalsWithConnection");connexion.begin();			
			
			RepresentanteLegalLogicAdditional.checkRepresentanteLegalToSaves(representantelegals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRepresentanteLegals();
			
			Boolean validadoTodosRepresentanteLegal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RepresentanteLegal representantelegalLocal:representantelegals) {		
				if(representantelegalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RepresentanteLegalLogicAdditional.updateRepresentanteLegalToSave(representantelegalLocal,this.arrDatoGeneral);
	        	
				RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),representantelegalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRepresentanteLegal(representantelegalLocal)) {
					RepresentanteLegalDataAccess.save(representantelegalLocal, connexion);				
				} else {
					validadoTodosRepresentanteLegal=false;
				}
			}
			
			if(!validadoTodosRepresentanteLegal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RepresentanteLegalLogicAdditional.checkRepresentanteLegalToSavesAfter(representantelegals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRepresentanteLegals();
			
			connexion.commit();		
			
			this.quitarRepresentanteLegalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRepresentanteLegals()throws Exception {				
		 try {	
			RepresentanteLegalLogicAdditional.checkRepresentanteLegalToSaves(representantelegals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRepresentanteLegal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RepresentanteLegal representantelegalLocal:representantelegals) {				
				if(representantelegalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RepresentanteLegalLogicAdditional.updateRepresentanteLegalToSave(representantelegalLocal,this.arrDatoGeneral);
	        	
				RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),representantelegalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRepresentanteLegal(representantelegalLocal)) {				
					RepresentanteLegalDataAccess.save(representantelegalLocal, connexion);				
				} else {
					validadoTodosRepresentanteLegal=false;
				}
			}
			
			if(!validadoTodosRepresentanteLegal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RepresentanteLegalLogicAdditional.checkRepresentanteLegalToSavesAfter(representantelegals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRepresentanteLegalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RepresentanteLegalParameterReturnGeneral procesarAccionRepresentanteLegals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RepresentanteLegal> representantelegals,RepresentanteLegalParameterReturnGeneral representantelegalParameterGeneral)throws Exception {
		 try {	
			RepresentanteLegalParameterReturnGeneral representantelegalReturnGeneral=new RepresentanteLegalParameterReturnGeneral();
	
			RepresentanteLegalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,representantelegals,representantelegalParameterGeneral,representantelegalReturnGeneral);
			
			return representantelegalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RepresentanteLegalParameterReturnGeneral procesarAccionRepresentanteLegalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RepresentanteLegal> representantelegals,RepresentanteLegalParameterReturnGeneral representantelegalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-procesarAccionRepresentanteLegalsWithConnection");connexion.begin();			
			
			RepresentanteLegalParameterReturnGeneral representantelegalReturnGeneral=new RepresentanteLegalParameterReturnGeneral();
	
			RepresentanteLegalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,representantelegals,representantelegalParameterGeneral,representantelegalReturnGeneral);
			
			this.connexion.commit();
			
			return representantelegalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RepresentanteLegalParameterReturnGeneral procesarEventosRepresentanteLegals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RepresentanteLegal> representantelegals,RepresentanteLegal representantelegal,RepresentanteLegalParameterReturnGeneral representantelegalParameterGeneral,Boolean isEsNuevoRepresentanteLegal,ArrayList<Classe> clases)throws Exception {
		 try {	
			RepresentanteLegalParameterReturnGeneral representantelegalReturnGeneral=new RepresentanteLegalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				representantelegalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RepresentanteLegalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,representantelegals,representantelegal,representantelegalParameterGeneral,representantelegalReturnGeneral,isEsNuevoRepresentanteLegal,clases);
			
			return representantelegalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RepresentanteLegalParameterReturnGeneral procesarEventosRepresentanteLegalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RepresentanteLegal> representantelegals,RepresentanteLegal representantelegal,RepresentanteLegalParameterReturnGeneral representantelegalParameterGeneral,Boolean isEsNuevoRepresentanteLegal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-procesarEventosRepresentanteLegalsWithConnection");connexion.begin();			
			
			RepresentanteLegalParameterReturnGeneral representantelegalReturnGeneral=new RepresentanteLegalParameterReturnGeneral();
	
			representantelegalReturnGeneral.setRepresentanteLegal(representantelegal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				representantelegalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RepresentanteLegalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,representantelegals,representantelegal,representantelegalParameterGeneral,representantelegalReturnGeneral,isEsNuevoRepresentanteLegal,clases);
			
			this.connexion.commit();
			
			return representantelegalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RepresentanteLegalParameterReturnGeneral procesarImportacionRepresentanteLegalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RepresentanteLegalParameterReturnGeneral representantelegalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-procesarImportacionRepresentanteLegalsWithConnection");connexion.begin();			
			
			RepresentanteLegalParameterReturnGeneral representantelegalReturnGeneral=new RepresentanteLegalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.representantelegals=new ArrayList<RepresentanteLegal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.representantelegal=new RepresentanteLegal();
				
				
				if(conColumnasBase) {this.representantelegal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.representantelegal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.representantelegal.setidentificacion(arrColumnas[iColumn++]);
				this.representantelegal.setapellidopaterno(arrColumnas[iColumn++]);
				this.representantelegal.setapellidomaterno(arrColumnas[iColumn++]);
				this.representantelegal.setprimernombre(arrColumnas[iColumn++]);
				this.representantelegal.setsegundonombre(arrColumnas[iColumn++]);
			this.representantelegal.setdireccion(arrColumnas[iColumn++]);
			this.representantelegal.settelefono(arrColumnas[iColumn++]);
				this.representantelegal.settelefonocodigoarea(arrColumnas[iColumn++]);
				this.representantelegal.setextension(arrColumnas[iColumn++]);
			this.representantelegal.settelefonomovil(arrColumnas[iColumn++]);
				this.representantelegal.setmontoaurorizado(Double.parseDouble(arrColumnas[iColumn++]));
			this.representantelegal.setemail(arrColumnas[iColumn++]);
				this.representantelegal.setestaactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.representantelegals.add(this.representantelegal);
			}
			
			this.saveRepresentanteLegals();
			
			this.connexion.commit();
			
			representantelegalReturnGeneral.setConRetornoEstaProcesado(true);
			representantelegalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return representantelegalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRepresentanteLegalsEliminados() throws Exception {				
		
		List<RepresentanteLegal> representantelegalsAux= new ArrayList<RepresentanteLegal>();
		
		for(RepresentanteLegal representantelegal:representantelegals) {
			if(!representantelegal.getIsDeleted()) {
				representantelegalsAux.add(representantelegal);
			}
		}
		
		representantelegals=representantelegalsAux;
	}
	
	public void quitarRepresentanteLegalsNulos() throws Exception {				
		
		List<RepresentanteLegal> representantelegalsAux= new ArrayList<RepresentanteLegal>();
		
		for(RepresentanteLegal representantelegal : this.representantelegals) {
			if(representantelegal==null) {
				representantelegalsAux.add(representantelegal);
			}
		}
		
		//this.representantelegals=representantelegalsAux;
		
		this.representantelegals.removeAll(representantelegalsAux);
	}
	
	public void getSetVersionRowRepresentanteLegalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(representantelegal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((representantelegal.getIsDeleted() || (representantelegal.getIsChanged()&&!representantelegal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=representantelegalDataAccess.getSetVersionRowRepresentanteLegal(connexion,representantelegal.getId());
				
				if(!representantelegal.getVersionRow().equals(timestamp)) {	
					representantelegal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				representantelegal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRepresentanteLegal()throws Exception {	
		
		if(representantelegal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((representantelegal.getIsDeleted() || (representantelegal.getIsChanged()&&!representantelegal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=representantelegalDataAccess.getSetVersionRowRepresentanteLegal(connexion,representantelegal.getId());
			
			try {							
				if(!representantelegal.getVersionRow().equals(timestamp)) {	
					representantelegal.setVersionRow(timestamp);
				}
				
				representantelegal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRepresentanteLegalsWithConnection()throws Exception {	
		if(representantelegals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RepresentanteLegal representantelegalAux:representantelegals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(representantelegalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(representantelegalAux.getIsDeleted() || (representantelegalAux.getIsChanged()&&!representantelegalAux.getIsNew())) {
						
						timestamp=representantelegalDataAccess.getSetVersionRowRepresentanteLegal(connexion,representantelegalAux.getId());
						
						if(!representantelegal.getVersionRow().equals(timestamp)) {	
							representantelegalAux.setVersionRow(timestamp);
						}
								
						representantelegalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRepresentanteLegals()throws Exception {	
		if(representantelegals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RepresentanteLegal representantelegalAux:representantelegals) {
					if(representantelegalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(representantelegalAux.getIsDeleted() || (representantelegalAux.getIsChanged()&&!representantelegalAux.getIsNew())) {
						
						timestamp=representantelegalDataAccess.getSetVersionRowRepresentanteLegal(connexion,representantelegalAux.getId());
						
						if(!representantelegalAux.getVersionRow().equals(timestamp)) {	
							representantelegalAux.setVersionRow(timestamp);
						}
						
													
						representantelegalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RepresentanteLegalParameterReturnGeneral cargarCombosLoteForeignKeyRepresentanteLegalWithConnection(String finalQueryGlobalCliente,String finalQueryGlobalTipoIdentificacion,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		RepresentanteLegalParameterReturnGeneral  representantelegalReturnGeneral =new RepresentanteLegalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-cargarCombosLoteForeignKeyRepresentanteLegalWithConnection");connexion.begin();
			
			representantelegalReturnGeneral =new RepresentanteLegalParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			representantelegalReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			representantelegalReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			representantelegalReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			representantelegalReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return representantelegalReturnGeneral;
	}
	
	public RepresentanteLegalParameterReturnGeneral cargarCombosLoteForeignKeyRepresentanteLegal(String finalQueryGlobalCliente,String finalQueryGlobalTipoIdentificacion,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		RepresentanteLegalParameterReturnGeneral  representantelegalReturnGeneral =new RepresentanteLegalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			representantelegalReturnGeneral =new RepresentanteLegalParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			representantelegalReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			representantelegalReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			representantelegalReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			representantelegalReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return representantelegalReturnGeneral;
	}
	
	
	public void deepLoad(RepresentanteLegal representantelegal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RepresentanteLegalLogicAdditional.updateRepresentanteLegalToGet(representantelegal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		representantelegal.setCliente(representantelegalDataAccess.getCliente(connexion,representantelegal));
		representantelegal.setTipoIdentificacion(representantelegalDataAccess.getTipoIdentificacion(connexion,representantelegal));
		representantelegal.setPais(representantelegalDataAccess.getPais(connexion,representantelegal));
		representantelegal.setCiudad(representantelegalDataAccess.getCiudad(connexion,representantelegal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				representantelegal.setCliente(representantelegalDataAccess.getCliente(connexion,representantelegal));
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				representantelegal.setTipoIdentificacion(representantelegalDataAccess.getTipoIdentificacion(connexion,representantelegal));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				representantelegal.setPais(representantelegalDataAccess.getPais(connexion,representantelegal));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				representantelegal.setCiudad(representantelegalDataAccess.getCiudad(connexion,representantelegal));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			representantelegal.setCliente(representantelegalDataAccess.getCliente(connexion,representantelegal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			representantelegal.setTipoIdentificacion(representantelegalDataAccess.getTipoIdentificacion(connexion,representantelegal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			representantelegal.setPais(representantelegalDataAccess.getPais(connexion,representantelegal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			representantelegal.setCiudad(representantelegalDataAccess.getCiudad(connexion,representantelegal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		representantelegal.setCliente(representantelegalDataAccess.getCliente(connexion,representantelegal));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(representantelegal.getCliente(),isDeep,deepLoadType,clases);
				
		representantelegal.setTipoIdentificacion(representantelegalDataAccess.getTipoIdentificacion(connexion,representantelegal));
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(representantelegal.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		representantelegal.setPais(representantelegalDataAccess.getPais(connexion,representantelegal));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(representantelegal.getPais(),isDeep,deepLoadType,clases);
				
		representantelegal.setCiudad(representantelegalDataAccess.getCiudad(connexion,representantelegal));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(representantelegal.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				representantelegal.setCliente(representantelegalDataAccess.getCliente(connexion,representantelegal));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(representantelegal.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				representantelegal.setTipoIdentificacion(representantelegalDataAccess.getTipoIdentificacion(connexion,representantelegal));
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepLoad(representantelegal.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				representantelegal.setPais(representantelegalDataAccess.getPais(connexion,representantelegal));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(representantelegal.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				representantelegal.setCiudad(representantelegalDataAccess.getCiudad(connexion,representantelegal));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(representantelegal.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			representantelegal.setCliente(representantelegalDataAccess.getCliente(connexion,representantelegal));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(representantelegal.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			representantelegal.setTipoIdentificacion(representantelegalDataAccess.getTipoIdentificacion(connexion,representantelegal));
			TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
			tipoidentificacionLogic.deepLoad(representantelegal.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			representantelegal.setPais(representantelegalDataAccess.getPais(connexion,representantelegal));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(representantelegal.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			representantelegal.setCiudad(representantelegalDataAccess.getCiudad(connexion,representantelegal));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(representantelegal.getCiudad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RepresentanteLegal representantelegal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RepresentanteLegalLogicAdditional.updateRepresentanteLegalToSave(representantelegal,this.arrDatoGeneral);
			
RepresentanteLegalDataAccess.save(representantelegal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(representantelegal.getCliente(),connexion);

		TipoIdentificacionDataAccess.save(representantelegal.getTipoIdentificacion(),connexion);

		PaisDataAccess.save(representantelegal.getPais(),connexion);

		CiudadDataAccess.save(representantelegal.getCiudad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(representantelegal.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(representantelegal.getTipoIdentificacion(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(representantelegal.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(representantelegal.getCiudad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(representantelegal.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(representantelegal.getCliente(),isDeep,deepLoadType,clases);
				

		TipoIdentificacionDataAccess.save(representantelegal.getTipoIdentificacion(),connexion);
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(representantelegal.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(representantelegal.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(representantelegal.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(representantelegal.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(representantelegal.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(representantelegal.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(representantelegal.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(representantelegal.getTipoIdentificacion(),connexion);
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepSave(representantelegal.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(representantelegal.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(representantelegal.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(representantelegal.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(representantelegal.getCiudad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RepresentanteLegal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(representantelegal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(representantelegal);
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
			this.deepLoad(this.representantelegal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RepresentanteLegal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(representantelegals!=null) {
				for(RepresentanteLegal representantelegal:representantelegals) {
					this.deepLoad(representantelegal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(representantelegals);
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
			if(representantelegals!=null) {
				for(RepresentanteLegal representantelegal:representantelegals) {
					this.deepLoad(representantelegal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(representantelegals);
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
			this.getNewConnexionToDeep(RepresentanteLegal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(representantelegal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RepresentanteLegal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(representantelegals!=null) {
				for(RepresentanteLegal representantelegal:representantelegals) {
					this.deepSave(representantelegal,isDeep,deepLoadType,clases);
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
			if(representantelegals!=null) {
				for(RepresentanteLegal representantelegal:representantelegals) {
					this.deepSave(representantelegal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRepresentanteLegalsFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long idciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,idciudad,RepresentanteLegalConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRepresentanteLegalsFK_IdCiudad(String sFinalQuery,Pagination pagination,Long idciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,idciudad,RepresentanteLegalConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRepresentanteLegalsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,RepresentanteLegalConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRepresentanteLegalsFK_IdCliente(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,RepresentanteLegalConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRepresentanteLegalsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,RepresentanteLegalConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRepresentanteLegalsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,RepresentanteLegalConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRepresentanteLegalsFK_IdValorClienteDocumentoWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclientedocumento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RepresentanteLegal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientedocumento,RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRepresentanteLegalsFK_IdValorClienteDocumento(String sFinalQuery,Pagination pagination,Long idvalorclientedocumento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientedocumento,RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			RepresentanteLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(this.representantelegals);
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
			if(RepresentanteLegalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RepresentanteLegalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RepresentanteLegal representantelegal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RepresentanteLegalConstantesFunciones.ISCONAUDITORIA) {
				if(representantelegal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RepresentanteLegalDataAccess.TABLENAME, representantelegal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RepresentanteLegalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RepresentanteLegalLogic.registrarAuditoriaDetallesRepresentanteLegal(connexion,representantelegal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(representantelegal.getIsDeleted()) {
					/*if(!representantelegal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RepresentanteLegalDataAccess.TABLENAME, representantelegal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RepresentanteLegalLogic.registrarAuditoriaDetallesRepresentanteLegal(connexion,representantelegal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RepresentanteLegalDataAccess.TABLENAME, representantelegal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(representantelegal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RepresentanteLegalDataAccess.TABLENAME, representantelegal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RepresentanteLegalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RepresentanteLegalLogic.registrarAuditoriaDetallesRepresentanteLegal(connexion,representantelegal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRepresentanteLegal(Connexion connexion,RepresentanteLegal representantelegal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(representantelegal.getIsNew()||!representantelegal.getidcliente().equals(representantelegal.getRepresentanteLegalOriginal().getidcliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getidcliente()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getidcliente().toString();
				}
				if(representantelegal.getidcliente()!=null)
				{
					strValorNuevo=representantelegal.getidcliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getidvalorclientedocumento().equals(representantelegal.getRepresentanteLegalOriginal().getidvalorclientedocumento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getidvalorclientedocumento()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getidvalorclientedocumento().toString();
				}
				if(representantelegal.getidvalorclientedocumento()!=null)
				{
					strValorNuevo=representantelegal.getidvalorclientedocumento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getid_pais().equals(representantelegal.getRepresentanteLegalOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getid_pais()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getid_pais().toString();
				}
				if(representantelegal.getid_pais()!=null)
				{
					strValorNuevo=representantelegal.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getidciudad().equals(representantelegal.getRepresentanteLegalOriginal().getidciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getidciudad()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getidciudad().toString();
				}
				if(representantelegal.getidciudad()!=null)
				{
					strValorNuevo=representantelegal.getidciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getidentificacion().equals(representantelegal.getRepresentanteLegalOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getidentificacion()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getidentificacion();
				}
				if(representantelegal.getidentificacion()!=null)
				{
					strValorNuevo=representantelegal.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getapellidopaterno().equals(representantelegal.getRepresentanteLegalOriginal().getapellidopaterno()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getapellidopaterno()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getapellidopaterno();
				}
				if(representantelegal.getapellidopaterno()!=null)
				{
					strValorNuevo=representantelegal.getapellidopaterno() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.APELLIDOPATERNO,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getapellidomaterno().equals(representantelegal.getRepresentanteLegalOriginal().getapellidomaterno()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getapellidomaterno()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getapellidomaterno();
				}
				if(representantelegal.getapellidomaterno()!=null)
				{
					strValorNuevo=representantelegal.getapellidomaterno() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.APELLIDOMATERNO,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getprimernombre().equals(representantelegal.getRepresentanteLegalOriginal().getprimernombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getprimernombre()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getprimernombre();
				}
				if(representantelegal.getprimernombre()!=null)
				{
					strValorNuevo=representantelegal.getprimernombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.PRIMERNOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getsegundonombre().equals(representantelegal.getRepresentanteLegalOriginal().getsegundonombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getsegundonombre()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getsegundonombre();
				}
				if(representantelegal.getsegundonombre()!=null)
				{
					strValorNuevo=representantelegal.getsegundonombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.SEGUNDONOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getdireccion().equals(representantelegal.getRepresentanteLegalOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getdireccion()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getdireccion();
				}
				if(representantelegal.getdireccion()!=null)
				{
					strValorNuevo=representantelegal.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.gettelefono().equals(representantelegal.getRepresentanteLegalOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().gettelefono()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().gettelefono();
				}
				if(representantelegal.gettelefono()!=null)
				{
					strValorNuevo=representantelegal.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.gettelefonocodigoarea().equals(representantelegal.getRepresentanteLegalOriginal().gettelefonocodigoarea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().gettelefonocodigoarea()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().gettelefonocodigoarea();
				}
				if(representantelegal.gettelefonocodigoarea()!=null)
				{
					strValorNuevo=representantelegal.gettelefonocodigoarea() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.TELEFONOCODIGOAREA,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getextension().equals(representantelegal.getRepresentanteLegalOriginal().getextension()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getextension()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getextension();
				}
				if(representantelegal.getextension()!=null)
				{
					strValorNuevo=representantelegal.getextension() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.EXTENSION,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.gettelefonomovil().equals(representantelegal.getRepresentanteLegalOriginal().gettelefonomovil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().gettelefonomovil()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().gettelefonomovil();
				}
				if(representantelegal.gettelefonomovil()!=null)
				{
					strValorNuevo=representantelegal.gettelefonomovil() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.TELEFONOMOVIL,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getmontoaurorizado().equals(representantelegal.getRepresentanteLegalOriginal().getmontoaurorizado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getmontoaurorizado()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getmontoaurorizado().toString();
				}
				if(representantelegal.getmontoaurorizado()!=null)
				{
					strValorNuevo=representantelegal.getmontoaurorizado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.MONTOAURORIZADO,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getemail().equals(representantelegal.getRepresentanteLegalOriginal().getemail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getemail()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getemail();
				}
				if(representantelegal.getemail()!=null)
				{
					strValorNuevo=representantelegal.getemail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.EMAIL,strValorActual,strValorNuevo);
			}	
			
			if(representantelegal.getIsNew()||!representantelegal.getestaactivo().equals(representantelegal.getRepresentanteLegalOriginal().getestaactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(representantelegal.getRepresentanteLegalOriginal().getestaactivo()!=null)
				{
					strValorActual=representantelegal.getRepresentanteLegalOriginal().getestaactivo().toString();
				}
				if(representantelegal.getestaactivo()!=null)
				{
					strValorNuevo=representantelegal.getestaactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RepresentanteLegalConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRepresentanteLegalRelacionesWithConnection(RepresentanteLegal representantelegal) throws Exception {

		if(!representantelegal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRepresentanteLegalRelacionesBase(representantelegal,true);
		}
	}

	public void saveRepresentanteLegalRelaciones(RepresentanteLegal representantelegal)throws Exception {

		if(!representantelegal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRepresentanteLegalRelacionesBase(representantelegal,false);
		}
	}

	public void saveRepresentanteLegalRelacionesBase(RepresentanteLegal representantelegal,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RepresentanteLegal-saveRelacionesWithConnection");}
	

			this.setRepresentanteLegal(representantelegal);

			if(RepresentanteLegalLogicAdditional.validarSaveRelaciones(representantelegal,this)) {

				RepresentanteLegalLogicAdditional.updateRelacionesToSave(representantelegal,this);

				if((representantelegal.getIsNew()||representantelegal.getIsChanged())&&!representantelegal.getIsDeleted()) {
					this.saveRepresentanteLegal();
					this.saveRepresentanteLegalRelacionesDetalles();

				} else if(representantelegal.getIsDeleted()) {
					this.saveRepresentanteLegalRelacionesDetalles();
					this.saveRepresentanteLegal();
				}

				RepresentanteLegalLogicAdditional.updateRelacionesToSaveAfter(representantelegal,this);

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
	
	
	private void saveRepresentanteLegalRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRepresentanteLegal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RepresentanteLegalConstantesFunciones.getClassesForeignKeysOfRepresentanteLegal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRepresentanteLegal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RepresentanteLegalConstantesFunciones.getClassesRelationshipsOfRepresentanteLegal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

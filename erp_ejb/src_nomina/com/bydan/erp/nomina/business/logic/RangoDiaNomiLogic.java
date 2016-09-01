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
import com.bydan.erp.nomina.util.RangoDiaNomiConstantesFunciones;
import com.bydan.erp.nomina.util.RangoDiaNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RangoDiaNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.RangoDiaNomi;
import com.bydan.erp.nomina.business.logic.RangoDiaNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RangoDiaNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RangoDiaNomiLogic.class);
	
	protected RangoDiaNomiDataAccess rangodianomiDataAccess; 	
	protected RangoDiaNomi rangodianomi;
	protected List<RangoDiaNomi> rangodianomis;
	protected Object rangodianomiObject;	
	protected List<Object> rangodianomisObject;
	
	public static ClassValidator<RangoDiaNomi> rangodianomiValidator = new ClassValidator<RangoDiaNomi>(RangoDiaNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RangoDiaNomiLogicAdditional rangodianomiLogicAdditional=null;
	
	public RangoDiaNomiLogicAdditional getRangoDiaNomiLogicAdditional() {
		return this.rangodianomiLogicAdditional;
	}
	
	public void setRangoDiaNomiLogicAdditional(RangoDiaNomiLogicAdditional rangodianomiLogicAdditional) {
		try {
			this.rangodianomiLogicAdditional=rangodianomiLogicAdditional;
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
	
	
	
	
	public  RangoDiaNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.rangodianomiDataAccess = new RangoDiaNomiDataAccess();
			
			this.rangodianomis= new ArrayList<RangoDiaNomi>();
			this.rangodianomi= new RangoDiaNomi();
			
			this.rangodianomiObject=new Object();
			this.rangodianomisObject=new ArrayList<Object>();
				
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
			
			this.rangodianomiDataAccess.setConnexionType(this.connexionType);
			this.rangodianomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RangoDiaNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.rangodianomiDataAccess = new RangoDiaNomiDataAccess();
			this.rangodianomis= new ArrayList<RangoDiaNomi>();
			this.rangodianomi= new RangoDiaNomi();
			this.rangodianomiObject=new Object();
			this.rangodianomisObject=new ArrayList<Object>();
			
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
			
			this.rangodianomiDataAccess.setConnexionType(this.connexionType);
			this.rangodianomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RangoDiaNomi getRangoDiaNomi() throws Exception {	
		RangoDiaNomiLogicAdditional.checkRangoDiaNomiToGet(rangodianomi,this.datosCliente,this.arrDatoGeneral);
		RangoDiaNomiLogicAdditional.updateRangoDiaNomiToGet(rangodianomi,this.arrDatoGeneral);
		
		return rangodianomi;
	}
		
	public void setRangoDiaNomi(RangoDiaNomi newRangoDiaNomi) {
		this.rangodianomi = newRangoDiaNomi;
	}
	
	public RangoDiaNomiDataAccess getRangoDiaNomiDataAccess() {
		return rangodianomiDataAccess;
	}
	
	public void setRangoDiaNomiDataAccess(RangoDiaNomiDataAccess newrangodianomiDataAccess) {
		this.rangodianomiDataAccess = newrangodianomiDataAccess;
	}
	
	public List<RangoDiaNomi> getRangoDiaNomis() throws Exception {		
		this.quitarRangoDiaNomisNulos();
		
		RangoDiaNomiLogicAdditional.checkRangoDiaNomiToGets(rangodianomis,this.datosCliente,this.arrDatoGeneral);
		
		for (RangoDiaNomi rangodianomiLocal: rangodianomis ) {
			RangoDiaNomiLogicAdditional.updateRangoDiaNomiToGet(rangodianomiLocal,this.arrDatoGeneral);
		}
		
		return rangodianomis;
	}
	
	public void setRangoDiaNomis(List<RangoDiaNomi> newRangoDiaNomis) {
		this.rangodianomis = newRangoDiaNomis;
	}
	
	public Object getRangoDiaNomiObject() {	
		this.rangodianomiObject=this.rangodianomiDataAccess.getEntityObject();
		return this.rangodianomiObject;
	}
		
	public void setRangoDiaNomiObject(Object newRangoDiaNomiObject) {
		this.rangodianomiObject = newRangoDiaNomiObject;
	}
	
	public List<Object> getRangoDiaNomisObject() {		
		this.rangodianomisObject=this.rangodianomiDataAccess.getEntitiesObject();
		return this.rangodianomisObject;
	}
		
	public void setRangoDiaNomisObject(List<Object> newRangoDiaNomisObject) {
		this.rangodianomisObject = newRangoDiaNomisObject;
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
		
		if(this.rangodianomiDataAccess!=null) {
			this.rangodianomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			rangodianomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			rangodianomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		rangodianomi = new  RangoDiaNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rangodianomi=rangodianomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rangodianomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomi);
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
		rangodianomi = new  RangoDiaNomi();
		  		  
        try {
			
			rangodianomi=rangodianomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rangodianomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		rangodianomi = new  RangoDiaNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rangodianomi=rangodianomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rangodianomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomi);
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
		rangodianomi = new  RangoDiaNomi();
		  		  
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
		rangodianomi = new  RangoDiaNomi();
		  		  
        try {
			
			rangodianomi=rangodianomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rangodianomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		rangodianomi = new  RangoDiaNomi();
		  		  
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
		rangodianomi = new  RangoDiaNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =rangodianomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rangodianomi = new  RangoDiaNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=rangodianomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rangodianomi = new  RangoDiaNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =rangodianomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rangodianomi = new  RangoDiaNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=rangodianomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rangodianomi = new  RangoDiaNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =rangodianomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rangodianomi = new  RangoDiaNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=rangodianomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomis=rangodianomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
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
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		  		  
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
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		  		  
        try {			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomis=rangodianomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRangoDiaNomi(rangodianomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		  		  
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
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomis=rangodianomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
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
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		  		  
        try {
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomis=rangodianomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
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
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomis=rangodianomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
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
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomis=rangodianomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		rangodianomi = new  RangoDiaNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomi=rangodianomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomi);
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
		rangodianomi = new  RangoDiaNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomi=rangodianomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomis=rangodianomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
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
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		  		  
        try {
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomis=rangodianomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRangoDiaNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getTodosRangoDiaNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomis=rangodianomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
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
	
	public  void  getTodosRangoDiaNomis(String sFinalQuery,Pagination pagination)throws Exception {
		rangodianomis = new  ArrayList<RangoDiaNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rangodianomis=rangodianomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRangoDiaNomi(rangodianomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRangoDiaNomi(RangoDiaNomi rangodianomi) throws Exception {
		Boolean estaValidado=false;
		
		if(rangodianomi.getIsNew() || rangodianomi.getIsChanged()) { 
			this.invalidValues = rangodianomiValidator.getInvalidValues(rangodianomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(rangodianomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRangoDiaNomi(List<RangoDiaNomi> RangoDiaNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RangoDiaNomi rangodianomiLocal:rangodianomis) {				
			estaValidadoObjeto=this.validarGuardarRangoDiaNomi(rangodianomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRangoDiaNomi(List<RangoDiaNomi> RangoDiaNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRangoDiaNomi(rangodianomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRangoDiaNomi(RangoDiaNomi RangoDiaNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRangoDiaNomi(rangodianomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RangoDiaNomi rangodianomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+rangodianomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RangoDiaNomiConstantesFunciones.getRangoDiaNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"rangodianomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RangoDiaNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RangoDiaNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRangoDiaNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-saveRangoDiaNomiWithConnection");connexion.begin();			
			
			RangoDiaNomiLogicAdditional.checkRangoDiaNomiToSave(this.rangodianomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RangoDiaNomiLogicAdditional.updateRangoDiaNomiToSave(this.rangodianomi,this.arrDatoGeneral);
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rangodianomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRangoDiaNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRangoDiaNomi(this.rangodianomi)) {
				RangoDiaNomiDataAccess.save(this.rangodianomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.rangodianomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RangoDiaNomiLogicAdditional.checkRangoDiaNomiToSaveAfter(this.rangodianomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRangoDiaNomi();
			
			connexion.commit();			
			
			if(this.rangodianomi.getIsDeleted()) {
				this.rangodianomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRangoDiaNomi()throws Exception {	
		try {	
			
			RangoDiaNomiLogicAdditional.checkRangoDiaNomiToSave(this.rangodianomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RangoDiaNomiLogicAdditional.updateRangoDiaNomiToSave(this.rangodianomi,this.arrDatoGeneral);
			
			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rangodianomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRangoDiaNomi(this.rangodianomi)) {			
				RangoDiaNomiDataAccess.save(this.rangodianomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.rangodianomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RangoDiaNomiLogicAdditional.checkRangoDiaNomiToSaveAfter(this.rangodianomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.rangodianomi.getIsDeleted()) {
				this.rangodianomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRangoDiaNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-saveRangoDiaNomisWithConnection");connexion.begin();			
			
			RangoDiaNomiLogicAdditional.checkRangoDiaNomiToSaves(rangodianomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRangoDiaNomis();
			
			Boolean validadoTodosRangoDiaNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RangoDiaNomi rangodianomiLocal:rangodianomis) {		
				if(rangodianomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RangoDiaNomiLogicAdditional.updateRangoDiaNomiToSave(rangodianomiLocal,this.arrDatoGeneral);
	        	
				RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rangodianomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRangoDiaNomi(rangodianomiLocal)) {
					RangoDiaNomiDataAccess.save(rangodianomiLocal, connexion);				
				} else {
					validadoTodosRangoDiaNomi=false;
				}
			}
			
			if(!validadoTodosRangoDiaNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RangoDiaNomiLogicAdditional.checkRangoDiaNomiToSavesAfter(rangodianomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRangoDiaNomis();
			
			connexion.commit();		
			
			this.quitarRangoDiaNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRangoDiaNomis()throws Exception {				
		 try {	
			RangoDiaNomiLogicAdditional.checkRangoDiaNomiToSaves(rangodianomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRangoDiaNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RangoDiaNomi rangodianomiLocal:rangodianomis) {				
				if(rangodianomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RangoDiaNomiLogicAdditional.updateRangoDiaNomiToSave(rangodianomiLocal,this.arrDatoGeneral);
	        	
				RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rangodianomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRangoDiaNomi(rangodianomiLocal)) {				
					RangoDiaNomiDataAccess.save(rangodianomiLocal, connexion);				
				} else {
					validadoTodosRangoDiaNomi=false;
				}
			}
			
			if(!validadoTodosRangoDiaNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RangoDiaNomiLogicAdditional.checkRangoDiaNomiToSavesAfter(rangodianomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRangoDiaNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RangoDiaNomiParameterReturnGeneral procesarAccionRangoDiaNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RangoDiaNomi> rangodianomis,RangoDiaNomiParameterReturnGeneral rangodianomiParameterGeneral)throws Exception {
		 try {	
			RangoDiaNomiParameterReturnGeneral rangodianomiReturnGeneral=new RangoDiaNomiParameterReturnGeneral();
	
			RangoDiaNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rangodianomis,rangodianomiParameterGeneral,rangodianomiReturnGeneral);
			
			return rangodianomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RangoDiaNomiParameterReturnGeneral procesarAccionRangoDiaNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RangoDiaNomi> rangodianomis,RangoDiaNomiParameterReturnGeneral rangodianomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-procesarAccionRangoDiaNomisWithConnection");connexion.begin();			
			
			RangoDiaNomiParameterReturnGeneral rangodianomiReturnGeneral=new RangoDiaNomiParameterReturnGeneral();
	
			RangoDiaNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rangodianomis,rangodianomiParameterGeneral,rangodianomiReturnGeneral);
			
			this.connexion.commit();
			
			return rangodianomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RangoDiaNomiParameterReturnGeneral procesarEventosRangoDiaNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RangoDiaNomi> rangodianomis,RangoDiaNomi rangodianomi,RangoDiaNomiParameterReturnGeneral rangodianomiParameterGeneral,Boolean isEsNuevoRangoDiaNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			RangoDiaNomiParameterReturnGeneral rangodianomiReturnGeneral=new RangoDiaNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rangodianomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RangoDiaNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rangodianomis,rangodianomi,rangodianomiParameterGeneral,rangodianomiReturnGeneral,isEsNuevoRangoDiaNomi,clases);
			
			return rangodianomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RangoDiaNomiParameterReturnGeneral procesarEventosRangoDiaNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RangoDiaNomi> rangodianomis,RangoDiaNomi rangodianomi,RangoDiaNomiParameterReturnGeneral rangodianomiParameterGeneral,Boolean isEsNuevoRangoDiaNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-procesarEventosRangoDiaNomisWithConnection");connexion.begin();			
			
			RangoDiaNomiParameterReturnGeneral rangodianomiReturnGeneral=new RangoDiaNomiParameterReturnGeneral();
	
			rangodianomiReturnGeneral.setRangoDiaNomi(rangodianomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rangodianomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RangoDiaNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rangodianomis,rangodianomi,rangodianomiParameterGeneral,rangodianomiReturnGeneral,isEsNuevoRangoDiaNomi,clases);
			
			this.connexion.commit();
			
			return rangodianomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RangoDiaNomiParameterReturnGeneral procesarImportacionRangoDiaNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RangoDiaNomiParameterReturnGeneral rangodianomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-procesarImportacionRangoDiaNomisWithConnection");connexion.begin();			
			
			RangoDiaNomiParameterReturnGeneral rangodianomiReturnGeneral=new RangoDiaNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.rangodianomis=new ArrayList<RangoDiaNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.rangodianomi=new RangoDiaNomi();
				
				
				if(conColumnasBase) {this.rangodianomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.rangodianomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.rangodianomi.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.rangodianomi.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.rangodianomi.setdescripcion(arrColumnas[iColumn++]);
				
				this.rangodianomis.add(this.rangodianomi);
			}
			
			this.saveRangoDiaNomis();
			
			this.connexion.commit();
			
			rangodianomiReturnGeneral.setConRetornoEstaProcesado(true);
			rangodianomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return rangodianomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRangoDiaNomisEliminados() throws Exception {				
		
		List<RangoDiaNomi> rangodianomisAux= new ArrayList<RangoDiaNomi>();
		
		for(RangoDiaNomi rangodianomi:rangodianomis) {
			if(!rangodianomi.getIsDeleted()) {
				rangodianomisAux.add(rangodianomi);
			}
		}
		
		rangodianomis=rangodianomisAux;
	}
	
	public void quitarRangoDiaNomisNulos() throws Exception {				
		
		List<RangoDiaNomi> rangodianomisAux= new ArrayList<RangoDiaNomi>();
		
		for(RangoDiaNomi rangodianomi : this.rangodianomis) {
			if(rangodianomi==null) {
				rangodianomisAux.add(rangodianomi);
			}
		}
		
		//this.rangodianomis=rangodianomisAux;
		
		this.rangodianomis.removeAll(rangodianomisAux);
	}
	
	public void getSetVersionRowRangoDiaNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(rangodianomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((rangodianomi.getIsDeleted() || (rangodianomi.getIsChanged()&&!rangodianomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=rangodianomiDataAccess.getSetVersionRowRangoDiaNomi(connexion,rangodianomi.getId());
				
				if(!rangodianomi.getVersionRow().equals(timestamp)) {	
					rangodianomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				rangodianomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRangoDiaNomi()throws Exception {	
		
		if(rangodianomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((rangodianomi.getIsDeleted() || (rangodianomi.getIsChanged()&&!rangodianomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=rangodianomiDataAccess.getSetVersionRowRangoDiaNomi(connexion,rangodianomi.getId());
			
			try {							
				if(!rangodianomi.getVersionRow().equals(timestamp)) {	
					rangodianomi.setVersionRow(timestamp);
				}
				
				rangodianomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRangoDiaNomisWithConnection()throws Exception {	
		if(rangodianomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RangoDiaNomi rangodianomiAux:rangodianomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(rangodianomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rangodianomiAux.getIsDeleted() || (rangodianomiAux.getIsChanged()&&!rangodianomiAux.getIsNew())) {
						
						timestamp=rangodianomiDataAccess.getSetVersionRowRangoDiaNomi(connexion,rangodianomiAux.getId());
						
						if(!rangodianomi.getVersionRow().equals(timestamp)) {	
							rangodianomiAux.setVersionRow(timestamp);
						}
								
						rangodianomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRangoDiaNomis()throws Exception {	
		if(rangodianomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RangoDiaNomi rangodianomiAux:rangodianomis) {
					if(rangodianomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rangodianomiAux.getIsDeleted() || (rangodianomiAux.getIsChanged()&&!rangodianomiAux.getIsNew())) {
						
						timestamp=rangodianomiDataAccess.getSetVersionRowRangoDiaNomi(connexion,rangodianomiAux.getId());
						
						if(!rangodianomiAux.getVersionRow().equals(timestamp)) {	
							rangodianomiAux.setVersionRow(timestamp);
						}
						
													
						rangodianomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RangoDiaNomiParameterReturnGeneral cargarCombosLoteForeignKeyRangoDiaNomiWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		RangoDiaNomiParameterReturnGeneral  rangodianomiReturnGeneral =new RangoDiaNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyRangoDiaNomiWithConnection");connexion.begin();
			
			rangodianomiReturnGeneral =new RangoDiaNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rangodianomiReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return rangodianomiReturnGeneral;
	}
	
	public RangoDiaNomiParameterReturnGeneral cargarCombosLoteForeignKeyRangoDiaNomi(String finalQueryGlobalEmpresa) throws Exception {
		RangoDiaNomiParameterReturnGeneral  rangodianomiReturnGeneral =new RangoDiaNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			rangodianomiReturnGeneral =new RangoDiaNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rangodianomiReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return rangodianomiReturnGeneral;
	}
	
	
	public void deepLoad(RangoDiaNomi rangodianomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RangoDiaNomiLogicAdditional.updateRangoDiaNomiToGet(rangodianomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rangodianomi.setEmpresa(rangodianomiDataAccess.getEmpresa(connexion,rangodianomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rangodianomi.setEmpresa(rangodianomiDataAccess.getEmpresa(connexion,rangodianomi));
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
			rangodianomi.setEmpresa(rangodianomiDataAccess.getEmpresa(connexion,rangodianomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rangodianomi.setEmpresa(rangodianomiDataAccess.getEmpresa(connexion,rangodianomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rangodianomi.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rangodianomi.setEmpresa(rangodianomiDataAccess.getEmpresa(connexion,rangodianomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(rangodianomi.getEmpresa(),isDeep,deepLoadType,clases);				
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
			rangodianomi.setEmpresa(rangodianomiDataAccess.getEmpresa(connexion,rangodianomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(rangodianomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RangoDiaNomi rangodianomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RangoDiaNomiLogicAdditional.updateRangoDiaNomiToSave(rangodianomi,this.arrDatoGeneral);
			
RangoDiaNomiDataAccess.save(rangodianomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rangodianomi.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rangodianomi.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rangodianomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rangodianomi.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rangodianomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(rangodianomi.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RangoDiaNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(rangodianomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(rangodianomi);
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
			this.deepLoad(this.rangodianomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RangoDiaNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(rangodianomis!=null) {
				for(RangoDiaNomi rangodianomi:rangodianomis) {
					this.deepLoad(rangodianomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(rangodianomis);
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
			if(rangodianomis!=null) {
				for(RangoDiaNomi rangodianomi:rangodianomis) {
					this.deepLoad(rangodianomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(rangodianomis);
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
			this.getNewConnexionToDeep(RangoDiaNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(rangodianomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RangoDiaNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(rangodianomis!=null) {
				for(RangoDiaNomi rangodianomi:rangodianomis) {
					this.deepSave(rangodianomi,isDeep,deepLoadType,clases);
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
			if(rangodianomis!=null) {
				for(RangoDiaNomi rangodianomi:rangodianomis) {
					this.deepSave(rangodianomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRangoDiaNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RangoDiaNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RangoDiaNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rangodianomis=rangodianomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRangoDiaNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RangoDiaNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RangoDiaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rangodianomis=rangodianomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RangoDiaNomiConstantesFunciones.refrescarForeignKeysDescripcionesRangoDiaNomi(this.rangodianomis);
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
			if(RangoDiaNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RangoDiaNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RangoDiaNomi rangodianomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RangoDiaNomiConstantesFunciones.ISCONAUDITORIA) {
				if(rangodianomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RangoDiaNomiDataAccess.TABLENAME, rangodianomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RangoDiaNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RangoDiaNomiLogic.registrarAuditoriaDetallesRangoDiaNomi(connexion,rangodianomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(rangodianomi.getIsDeleted()) {
					/*if(!rangodianomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RangoDiaNomiDataAccess.TABLENAME, rangodianomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RangoDiaNomiLogic.registrarAuditoriaDetallesRangoDiaNomi(connexion,rangodianomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RangoDiaNomiDataAccess.TABLENAME, rangodianomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(rangodianomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RangoDiaNomiDataAccess.TABLENAME, rangodianomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RangoDiaNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RangoDiaNomiLogic.registrarAuditoriaDetallesRangoDiaNomi(connexion,rangodianomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRangoDiaNomi(Connexion connexion,RangoDiaNomi rangodianomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(rangodianomi.getIsNew()||!rangodianomi.getid_empresa().equals(rangodianomi.getRangoDiaNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rangodianomi.getRangoDiaNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=rangodianomi.getRangoDiaNomiOriginal().getid_empresa().toString();
				}
				if(rangodianomi.getid_empresa()!=null)
				{
					strValorNuevo=rangodianomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RangoDiaNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(rangodianomi.getIsNew()||!rangodianomi.getfecha_inicio().equals(rangodianomi.getRangoDiaNomiOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rangodianomi.getRangoDiaNomiOriginal().getfecha_inicio()!=null)
				{
					strValorActual=rangodianomi.getRangoDiaNomiOriginal().getfecha_inicio().toString();
				}
				if(rangodianomi.getfecha_inicio()!=null)
				{
					strValorNuevo=rangodianomi.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RangoDiaNomiConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(rangodianomi.getIsNew()||!rangodianomi.getfecha_fin().equals(rangodianomi.getRangoDiaNomiOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rangodianomi.getRangoDiaNomiOriginal().getfecha_fin()!=null)
				{
					strValorActual=rangodianomi.getRangoDiaNomiOriginal().getfecha_fin().toString();
				}
				if(rangodianomi.getfecha_fin()!=null)
				{
					strValorNuevo=rangodianomi.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RangoDiaNomiConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(rangodianomi.getIsNew()||!rangodianomi.getdescripcion().equals(rangodianomi.getRangoDiaNomiOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rangodianomi.getRangoDiaNomiOriginal().getdescripcion()!=null)
				{
					strValorActual=rangodianomi.getRangoDiaNomiOriginal().getdescripcion();
				}
				if(rangodianomi.getdescripcion()!=null)
				{
					strValorNuevo=rangodianomi.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RangoDiaNomiConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRangoDiaNomiRelacionesWithConnection(RangoDiaNomi rangodianomi) throws Exception {

		if(!rangodianomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRangoDiaNomiRelacionesBase(rangodianomi,true);
		}
	}

	public void saveRangoDiaNomiRelaciones(RangoDiaNomi rangodianomi)throws Exception {

		if(!rangodianomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRangoDiaNomiRelacionesBase(rangodianomi,false);
		}
	}

	public void saveRangoDiaNomiRelacionesBase(RangoDiaNomi rangodianomi,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RangoDiaNomi-saveRelacionesWithConnection");}
	

			this.setRangoDiaNomi(rangodianomi);

			if(RangoDiaNomiLogicAdditional.validarSaveRelaciones(rangodianomi,this)) {

				RangoDiaNomiLogicAdditional.updateRelacionesToSave(rangodianomi,this);

				if((rangodianomi.getIsNew()||rangodianomi.getIsChanged())&&!rangodianomi.getIsDeleted()) {
					this.saveRangoDiaNomi();
					this.saveRangoDiaNomiRelacionesDetalles();

				} else if(rangodianomi.getIsDeleted()) {
					this.saveRangoDiaNomiRelacionesDetalles();
					this.saveRangoDiaNomi();
				}

				RangoDiaNomiLogicAdditional.updateRelacionesToSaveAfter(rangodianomi,this);

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
	
	
	private void saveRangoDiaNomiRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRangoDiaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RangoDiaNomiConstantesFunciones.getClassesForeignKeysOfRangoDiaNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRangoDiaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RangoDiaNomiConstantesFunciones.getClassesRelationshipsOfRangoDiaNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

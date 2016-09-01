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
import com.bydan.erp.nomina.util.HobbyConstantesFunciones;
import com.bydan.erp.nomina.util.HobbyParameterReturnGeneral;
//import com.bydan.erp.nomina.util.HobbyParameterGeneral;
import com.bydan.erp.nomina.business.entity.Hobby;
import com.bydan.erp.nomina.business.logic.HobbyLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class HobbyLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(HobbyLogic.class);
	
	protected HobbyDataAccess hobbyDataAccess; 	
	protected Hobby hobby;
	protected List<Hobby> hobbys;
	protected Object hobbyObject;	
	protected List<Object> hobbysObject;
	
	public static ClassValidator<Hobby> hobbyValidator = new ClassValidator<Hobby>(Hobby.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected HobbyLogicAdditional hobbyLogicAdditional=null;
	
	public HobbyLogicAdditional getHobbyLogicAdditional() {
		return this.hobbyLogicAdditional;
	}
	
	public void setHobbyLogicAdditional(HobbyLogicAdditional hobbyLogicAdditional) {
		try {
			this.hobbyLogicAdditional=hobbyLogicAdditional;
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
	
	
	
	
	public  HobbyLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.hobbyDataAccess = new HobbyDataAccess();
			
			this.hobbys= new ArrayList<Hobby>();
			this.hobby= new Hobby();
			
			this.hobbyObject=new Object();
			this.hobbysObject=new ArrayList<Object>();
				
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
			
			this.hobbyDataAccess.setConnexionType(this.connexionType);
			this.hobbyDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  HobbyLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.hobbyDataAccess = new HobbyDataAccess();
			this.hobbys= new ArrayList<Hobby>();
			this.hobby= new Hobby();
			this.hobbyObject=new Object();
			this.hobbysObject=new ArrayList<Object>();
			
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
			
			this.hobbyDataAccess.setConnexionType(this.connexionType);
			this.hobbyDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Hobby getHobby() throws Exception {	
		HobbyLogicAdditional.checkHobbyToGet(hobby,this.datosCliente,this.arrDatoGeneral);
		HobbyLogicAdditional.updateHobbyToGet(hobby,this.arrDatoGeneral);
		
		return hobby;
	}
		
	public void setHobby(Hobby newHobby) {
		this.hobby = newHobby;
	}
	
	public HobbyDataAccess getHobbyDataAccess() {
		return hobbyDataAccess;
	}
	
	public void setHobbyDataAccess(HobbyDataAccess newhobbyDataAccess) {
		this.hobbyDataAccess = newhobbyDataAccess;
	}
	
	public List<Hobby> getHobbys() throws Exception {		
		this.quitarHobbysNulos();
		
		HobbyLogicAdditional.checkHobbyToGets(hobbys,this.datosCliente,this.arrDatoGeneral);
		
		for (Hobby hobbyLocal: hobbys ) {
			HobbyLogicAdditional.updateHobbyToGet(hobbyLocal,this.arrDatoGeneral);
		}
		
		return hobbys;
	}
	
	public void setHobbys(List<Hobby> newHobbys) {
		this.hobbys = newHobbys;
	}
	
	public Object getHobbyObject() {	
		this.hobbyObject=this.hobbyDataAccess.getEntityObject();
		return this.hobbyObject;
	}
		
	public void setHobbyObject(Object newHobbyObject) {
		this.hobbyObject = newHobbyObject;
	}
	
	public List<Object> getHobbysObject() {		
		this.hobbysObject=this.hobbyDataAccess.getEntitiesObject();
		return this.hobbysObject;
	}
		
	public void setHobbysObject(List<Object> newHobbysObject) {
		this.hobbysObject = newHobbysObject;
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
		
		if(this.hobbyDataAccess!=null) {
			this.hobbyDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			hobbyDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			hobbyDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		hobby = new  Hobby();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			hobby=hobbyDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.hobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobby);
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
		hobby = new  Hobby();
		  		  
        try {
			
			hobby=hobbyDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.hobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobby);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		hobby = new  Hobby();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			hobby=hobbyDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.hobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobby);
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
		hobby = new  Hobby();
		  		  
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
		hobby = new  Hobby();
		  		  
        try {
			
			hobby=hobbyDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.hobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobby);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		hobby = new  Hobby();
		  		  
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
		hobby = new  Hobby();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =hobbyDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		hobby = new  Hobby();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=hobbyDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		hobby = new  Hobby();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =hobbyDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		hobby = new  Hobby();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=hobbyDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		hobby = new  Hobby();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =hobbyDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		hobby = new  Hobby();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=hobbyDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		hobbys = new  ArrayList<Hobby>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbys=hobbyDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHobby(hobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
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
		hobbys = new  ArrayList<Hobby>();
		  		  
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
		hobbys = new  ArrayList<Hobby>();
		  		  
        try {			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbys=hobbyDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarHobby(hobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		hobbys = new  ArrayList<Hobby>();
		  		  
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
		hobbys = new  ArrayList<Hobby>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbys=hobbyDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHobby(hobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
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
		hobbys = new  ArrayList<Hobby>();
		  		  
        try {
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbys=hobbyDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHobby(hobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
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
		hobbys = new  ArrayList<Hobby>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbys=hobbyDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHobby(hobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
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
		hobbys = new  ArrayList<Hobby>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbys=hobbyDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHobby(hobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		hobby = new  Hobby();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobby=hobbyDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHobby(hobby);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobby);
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
		hobby = new  Hobby();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobby=hobbyDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHobby(hobby);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobby);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		hobbys = new  ArrayList<Hobby>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbys=hobbyDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHobby(hobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
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
		hobbys = new  ArrayList<Hobby>();
		  		  
        try {
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbys=hobbyDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHobby(hobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosHobbysWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		hobbys = new  ArrayList<Hobby>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getTodosHobbysWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbys=hobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHobby(hobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
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
	
	public  void  getTodosHobbys(String sFinalQuery,Pagination pagination)throws Exception {
		hobbys = new  ArrayList<Hobby>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbys=hobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHobby(hobbys);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarHobby(Hobby hobby) throws Exception {
		Boolean estaValidado=false;
		
		if(hobby.getIsNew() || hobby.getIsChanged()) { 
			this.invalidValues = hobbyValidator.getInvalidValues(hobby);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(hobby);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarHobby(List<Hobby> Hobbys) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Hobby hobbyLocal:hobbys) {				
			estaValidadoObjeto=this.validarGuardarHobby(hobbyLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarHobby(List<Hobby> Hobbys) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHobby(hobbys)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarHobby(Hobby Hobby) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHobby(hobby)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Hobby hobby) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+hobby.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=HobbyConstantesFunciones.getHobbyLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"hobby","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(HobbyConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(HobbyConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveHobbyWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-saveHobbyWithConnection");connexion.begin();			
			
			HobbyLogicAdditional.checkHobbyToSave(this.hobby,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HobbyLogicAdditional.updateHobbyToSave(this.hobby,this.arrDatoGeneral);
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.hobby,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowHobby();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHobby(this.hobby)) {
				HobbyDataAccess.save(this.hobby, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.hobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HobbyLogicAdditional.checkHobbyToSaveAfter(this.hobby,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHobby();
			
			connexion.commit();			
			
			if(this.hobby.getIsDeleted()) {
				this.hobby=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveHobby()throws Exception {	
		try {	
			
			HobbyLogicAdditional.checkHobbyToSave(this.hobby,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HobbyLogicAdditional.updateHobbyToSave(this.hobby,this.arrDatoGeneral);
			
			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.hobby,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHobby(this.hobby)) {			
				HobbyDataAccess.save(this.hobby, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.hobby,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HobbyLogicAdditional.checkHobbyToSaveAfter(this.hobby,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.hobby.getIsDeleted()) {
				this.hobby=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveHobbysWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-saveHobbysWithConnection");connexion.begin();			
			
			HobbyLogicAdditional.checkHobbyToSaves(hobbys,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowHobbys();
			
			Boolean validadoTodosHobby=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Hobby hobbyLocal:hobbys) {		
				if(hobbyLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HobbyLogicAdditional.updateHobbyToSave(hobbyLocal,this.arrDatoGeneral);
	        	
				HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),hobbyLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHobby(hobbyLocal)) {
					HobbyDataAccess.save(hobbyLocal, connexion);				
				} else {
					validadoTodosHobby=false;
				}
			}
			
			if(!validadoTodosHobby) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HobbyLogicAdditional.checkHobbyToSavesAfter(hobbys,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHobbys();
			
			connexion.commit();		
			
			this.quitarHobbysEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveHobbys()throws Exception {				
		 try {	
			HobbyLogicAdditional.checkHobbyToSaves(hobbys,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosHobby=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Hobby hobbyLocal:hobbys) {				
				if(hobbyLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HobbyLogicAdditional.updateHobbyToSave(hobbyLocal,this.arrDatoGeneral);
	        	
				HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),hobbyLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHobby(hobbyLocal)) {				
					HobbyDataAccess.save(hobbyLocal, connexion);				
				} else {
					validadoTodosHobby=false;
				}
			}
			
			if(!validadoTodosHobby) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HobbyLogicAdditional.checkHobbyToSavesAfter(hobbys,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarHobbysEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HobbyParameterReturnGeneral procesarAccionHobbys(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Hobby> hobbys,HobbyParameterReturnGeneral hobbyParameterGeneral)throws Exception {
		 try {	
			HobbyParameterReturnGeneral hobbyReturnGeneral=new HobbyParameterReturnGeneral();
	
			HobbyLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,hobbys,hobbyParameterGeneral,hobbyReturnGeneral);
			
			return hobbyReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HobbyParameterReturnGeneral procesarAccionHobbysWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Hobby> hobbys,HobbyParameterReturnGeneral hobbyParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-procesarAccionHobbysWithConnection");connexion.begin();			
			
			HobbyParameterReturnGeneral hobbyReturnGeneral=new HobbyParameterReturnGeneral();
	
			HobbyLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,hobbys,hobbyParameterGeneral,hobbyReturnGeneral);
			
			this.connexion.commit();
			
			return hobbyReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HobbyParameterReturnGeneral procesarEventosHobbys(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Hobby> hobbys,Hobby hobby,HobbyParameterReturnGeneral hobbyParameterGeneral,Boolean isEsNuevoHobby,ArrayList<Classe> clases)throws Exception {
		 try {	
			HobbyParameterReturnGeneral hobbyReturnGeneral=new HobbyParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				hobbyReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HobbyLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,hobbys,hobby,hobbyParameterGeneral,hobbyReturnGeneral,isEsNuevoHobby,clases);
			
			return hobbyReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public HobbyParameterReturnGeneral procesarEventosHobbysWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Hobby> hobbys,Hobby hobby,HobbyParameterReturnGeneral hobbyParameterGeneral,Boolean isEsNuevoHobby,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-procesarEventosHobbysWithConnection");connexion.begin();			
			
			HobbyParameterReturnGeneral hobbyReturnGeneral=new HobbyParameterReturnGeneral();
	
			hobbyReturnGeneral.setHobby(hobby);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				hobbyReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HobbyLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,hobbys,hobby,hobbyParameterGeneral,hobbyReturnGeneral,isEsNuevoHobby,clases);
			
			this.connexion.commit();
			
			return hobbyReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HobbyParameterReturnGeneral procesarImportacionHobbysWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,HobbyParameterReturnGeneral hobbyParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-procesarImportacionHobbysWithConnection");connexion.begin();			
			
			HobbyParameterReturnGeneral hobbyReturnGeneral=new HobbyParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.hobbys=new ArrayList<Hobby>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.hobby=new Hobby();
				
				
				if(conColumnasBase) {this.hobby.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.hobby.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.hobby.setcodigo(arrColumnas[iColumn++]);
				this.hobby.setnombre(arrColumnas[iColumn++]);
				this.hobby.setdescripcion(arrColumnas[iColumn++]);
				
				this.hobbys.add(this.hobby);
			}
			
			this.saveHobbys();
			
			this.connexion.commit();
			
			hobbyReturnGeneral.setConRetornoEstaProcesado(true);
			hobbyReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return hobbyReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarHobbysEliminados() throws Exception {				
		
		List<Hobby> hobbysAux= new ArrayList<Hobby>();
		
		for(Hobby hobby:hobbys) {
			if(!hobby.getIsDeleted()) {
				hobbysAux.add(hobby);
			}
		}
		
		hobbys=hobbysAux;
	}
	
	public void quitarHobbysNulos() throws Exception {				
		
		List<Hobby> hobbysAux= new ArrayList<Hobby>();
		
		for(Hobby hobby : this.hobbys) {
			if(hobby==null) {
				hobbysAux.add(hobby);
			}
		}
		
		//this.hobbys=hobbysAux;
		
		this.hobbys.removeAll(hobbysAux);
	}
	
	public void getSetVersionRowHobbyWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(hobby.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((hobby.getIsDeleted() || (hobby.getIsChanged()&&!hobby.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=hobbyDataAccess.getSetVersionRowHobby(connexion,hobby.getId());
				
				if(!hobby.getVersionRow().equals(timestamp)) {	
					hobby.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				hobby.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowHobby()throws Exception {	
		
		if(hobby.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((hobby.getIsDeleted() || (hobby.getIsChanged()&&!hobby.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=hobbyDataAccess.getSetVersionRowHobby(connexion,hobby.getId());
			
			try {							
				if(!hobby.getVersionRow().equals(timestamp)) {	
					hobby.setVersionRow(timestamp);
				}
				
				hobby.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowHobbysWithConnection()throws Exception {	
		if(hobbys!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Hobby hobbyAux:hobbys) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(hobbyAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(hobbyAux.getIsDeleted() || (hobbyAux.getIsChanged()&&!hobbyAux.getIsNew())) {
						
						timestamp=hobbyDataAccess.getSetVersionRowHobby(connexion,hobbyAux.getId());
						
						if(!hobby.getVersionRow().equals(timestamp)) {	
							hobbyAux.setVersionRow(timestamp);
						}
								
						hobbyAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowHobbys()throws Exception {	
		if(hobbys!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Hobby hobbyAux:hobbys) {
					if(hobbyAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(hobbyAux.getIsDeleted() || (hobbyAux.getIsChanged()&&!hobbyAux.getIsNew())) {
						
						timestamp=hobbyDataAccess.getSetVersionRowHobby(connexion,hobbyAux.getId());
						
						if(!hobbyAux.getVersionRow().equals(timestamp)) {	
							hobbyAux.setVersionRow(timestamp);
						}
						
													
						hobbyAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public HobbyParameterReturnGeneral cargarCombosLoteForeignKeyHobbyWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		HobbyParameterReturnGeneral  hobbyReturnGeneral =new HobbyParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-cargarCombosLoteForeignKeyHobbyWithConnection");connexion.begin();
			
			hobbyReturnGeneral =new HobbyParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			hobbyReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return hobbyReturnGeneral;
	}
	
	public HobbyParameterReturnGeneral cargarCombosLoteForeignKeyHobby(String finalQueryGlobalEmpresa) throws Exception {
		HobbyParameterReturnGeneral  hobbyReturnGeneral =new HobbyParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			hobbyReturnGeneral =new HobbyParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			hobbyReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return hobbyReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyHobbyWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EmpleadoHobbyLogic empleadohobbyLogic=new EmpleadoHobbyLogic();
			HobbyClienteLogic hobbyclienteLogic=new HobbyClienteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyHobbyWithConnection");connexion.begin();
			
			
			classes.add(new Classe(EmpleadoHobby.class));
			classes.add(new Classe(HobbyCliente.class));
											
			

			empleadohobbyLogic.setConnexion(this.getConnexion());
			empleadohobbyLogic.setDatosCliente(this.datosCliente);
			empleadohobbyLogic.setIsConRefrescarForeignKeys(true);

			hobbyclienteLogic.setConnexion(this.getConnexion());
			hobbyclienteLogic.setDatosCliente(this.datosCliente);
			hobbyclienteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Hobby hobby:this.hobbys) {
				

				classes=new ArrayList<Classe>();
				classes=EmpleadoHobbyConstantesFunciones.getClassesForeignKeysOfEmpleadoHobby(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadohobbyLogic.setEmpleadoHobbys(hobby.empleadohobbys);
				empleadohobbyLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=HobbyClienteConstantesFunciones.getClassesForeignKeysOfHobbyCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				hobbyclienteLogic.setHobbyClientes(hobby.hobbyclientes);
				hobbyclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Hobby hobby,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			HobbyLogicAdditional.updateHobbyToGet(hobby,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		hobby.setEmpresa(hobbyDataAccess.getEmpresa(connexion,hobby));
		hobby.setEmpleadoHobbys(hobbyDataAccess.getEmpleadoHobbys(connexion,hobby));
		hobby.setHobbyClientes(hobbyDataAccess.getHobbyClientes(connexion,hobby));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				hobby.setEmpresa(hobbyDataAccess.getEmpresa(connexion,hobby));
				continue;
			}

			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				hobby.setEmpleadoHobbys(hobbyDataAccess.getEmpleadoHobbys(connexion,hobby));

				if(this.isConDeep) {
					EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(this.connexion);
					empleadohobbyLogic.setEmpleadoHobbys(hobby.getEmpleadoHobbys());
					ArrayList<Classe> classesLocal=EmpleadoHobbyConstantesFunciones.getClassesForeignKeysOfEmpleadoHobby(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadohobbyLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoHobbyConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHobby(empleadohobbyLogic.getEmpleadoHobbys());
					hobby.setEmpleadoHobbys(empleadohobbyLogic.getEmpleadoHobbys());
				}

				continue;
			}

			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				hobby.setHobbyClientes(hobbyDataAccess.getHobbyClientes(connexion,hobby));

				if(this.isConDeep) {
					HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(this.connexion);
					hobbyclienteLogic.setHobbyClientes(hobby.getHobbyClientes());
					ArrayList<Classe> classesLocal=HobbyClienteConstantesFunciones.getClassesForeignKeysOfHobbyCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					hobbyclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(hobbyclienteLogic.getHobbyClientes());
					hobby.setHobbyClientes(hobbyclienteLogic.getHobbyClientes());
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
			hobby.setEmpresa(hobbyDataAccess.getEmpresa(connexion,hobby));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoHobby.class));
			hobby.setEmpleadoHobbys(hobbyDataAccess.getEmpleadoHobbys(connexion,hobby));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HobbyCliente.class));
			hobby.setHobbyClientes(hobbyDataAccess.getHobbyClientes(connexion,hobby));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		hobby.setEmpresa(hobbyDataAccess.getEmpresa(connexion,hobby));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(hobby.getEmpresa(),isDeep,deepLoadType,clases);
				

		hobby.setEmpleadoHobbys(hobbyDataAccess.getEmpleadoHobbys(connexion,hobby));

		for(EmpleadoHobby empleadohobby:hobby.getEmpleadoHobbys()) {
			EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(connexion);
			empleadohobbyLogic.deepLoad(empleadohobby,isDeep,deepLoadType,clases);
		}

		hobby.setHobbyClientes(hobbyDataAccess.getHobbyClientes(connexion,hobby));

		for(HobbyCliente hobbycliente:hobby.getHobbyClientes()) {
			HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(connexion);
			hobbyclienteLogic.deepLoad(hobbycliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				hobby.setEmpresa(hobbyDataAccess.getEmpresa(connexion,hobby));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(hobby.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				hobby.setEmpleadoHobbys(hobbyDataAccess.getEmpleadoHobbys(connexion,hobby));

				for(EmpleadoHobby empleadohobby:hobby.getEmpleadoHobbys()) {
					EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(connexion);
					empleadohobbyLogic.deepLoad(empleadohobby,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				hobby.setHobbyClientes(hobbyDataAccess.getHobbyClientes(connexion,hobby));

				for(HobbyCliente hobbycliente:hobby.getHobbyClientes()) {
					HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(connexion);
					hobbyclienteLogic.deepLoad(hobbycliente,isDeep,deepLoadType,clases);
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
			hobby.setEmpresa(hobbyDataAccess.getEmpresa(connexion,hobby));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(hobby.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoHobby.class));
			hobby.setEmpleadoHobbys(hobbyDataAccess.getEmpleadoHobbys(connexion,hobby));

			for(EmpleadoHobby empleadohobby:hobby.getEmpleadoHobbys()) {
				EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(connexion);
				empleadohobbyLogic.deepLoad(empleadohobby,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HobbyCliente.class));
			hobby.setHobbyClientes(hobbyDataAccess.getHobbyClientes(connexion,hobby));

			for(HobbyCliente hobbycliente:hobby.getHobbyClientes()) {
				HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(connexion);
				hobbyclienteLogic.deepLoad(hobbycliente,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Hobby hobby,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			HobbyLogicAdditional.updateHobbyToSave(hobby,this.arrDatoGeneral);
			
HobbyDataAccess.save(hobby, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(hobby.getEmpresa(),connexion);

		for(EmpleadoHobby empleadohobby:hobby.getEmpleadoHobbys()) {
			empleadohobby.setid_hobby(hobby.getId());
			EmpleadoHobbyDataAccess.save(empleadohobby,connexion);
		}

		for(HobbyCliente hobbycliente:hobby.getHobbyClientes()) {
			hobbycliente.setid_hobby(hobby.getId());
			HobbyClienteDataAccess.save(hobbycliente,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(hobby.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoHobby empleadohobby:hobby.getEmpleadoHobbys()) {
					empleadohobby.setid_hobby(hobby.getId());
					EmpleadoHobbyDataAccess.save(empleadohobby,connexion);
				}
				continue;
			}

			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HobbyCliente hobbycliente:hobby.getHobbyClientes()) {
					hobbycliente.setid_hobby(hobby.getId());
					HobbyClienteDataAccess.save(hobbycliente,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(hobby.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(hobby.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(EmpleadoHobby empleadohobby:hobby.getEmpleadoHobbys()) {
			EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(connexion);
			empleadohobby.setid_hobby(hobby.getId());
			EmpleadoHobbyDataAccess.save(empleadohobby,connexion);
			empleadohobbyLogic.deepSave(empleadohobby,isDeep,deepLoadType,clases);
		}

		for(HobbyCliente hobbycliente:hobby.getHobbyClientes()) {
			HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(connexion);
			hobbycliente.setid_hobby(hobby.getId());
			HobbyClienteDataAccess.save(hobbycliente,connexion);
			hobbyclienteLogic.deepSave(hobbycliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(hobby.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(hobby.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(EmpleadoHobby.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoHobby empleadohobby:hobby.getEmpleadoHobbys()) {
					EmpleadoHobbyLogic empleadohobbyLogic= new EmpleadoHobbyLogic(connexion);
					empleadohobby.setid_hobby(hobby.getId());
					EmpleadoHobbyDataAccess.save(empleadohobby,connexion);
					empleadohobbyLogic.deepSave(empleadohobby,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HobbyCliente hobbycliente:hobby.getHobbyClientes()) {
					HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(connexion);
					hobbycliente.setid_hobby(hobby.getId());
					HobbyClienteDataAccess.save(hobbycliente,connexion);
					hobbyclienteLogic.deepSave(hobbycliente,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Hobby.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(hobby,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(hobby);
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
			this.deepLoad(this.hobby,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobby);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Hobby.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(hobbys!=null) {
				for(Hobby hobby:hobbys) {
					this.deepLoad(hobby,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(hobbys);
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
			if(hobbys!=null) {
				for(Hobby hobby:hobbys) {
					this.deepLoad(hobby,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(hobbys);
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
			this.getNewConnexionToDeep(Hobby.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(hobby,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Hobby.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(hobbys!=null) {
				for(Hobby hobby:hobbys) {
					this.deepSave(hobby,isDeep,deepLoadType,clases);
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
			if(hobbys!=null) {
				for(Hobby hobby:hobbys) {
					this.deepSave(hobby,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getHobbysBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",HobbyConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbys=hobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHobbysBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",HobbyConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbys=hobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHobbysBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",HobbyConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbys=hobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHobbysBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",HobbyConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbys=hobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHobbysFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Hobby.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HobbyConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbys=hobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHobbysFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HobbyConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HobbyLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbys=hobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyConstantesFunciones.refrescarForeignKeysDescripcionesHobby(this.hobbys);
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
			if(HobbyConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,HobbyDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Hobby hobby,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(HobbyConstantesFunciones.ISCONAUDITORIA) {
				if(hobby.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HobbyDataAccess.TABLENAME, hobby.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HobbyConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HobbyLogic.registrarAuditoriaDetallesHobby(connexion,hobby,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(hobby.getIsDeleted()) {
					/*if(!hobby.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,HobbyDataAccess.TABLENAME, hobby.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////HobbyLogic.registrarAuditoriaDetallesHobby(connexion,hobby,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HobbyDataAccess.TABLENAME, hobby.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(hobby.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HobbyDataAccess.TABLENAME, hobby.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HobbyConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HobbyLogic.registrarAuditoriaDetallesHobby(connexion,hobby,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesHobby(Connexion connexion,Hobby hobby)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(hobby.getIsNew()||!hobby.getid_empresa().equals(hobby.getHobbyOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(hobby.getHobbyOriginal().getid_empresa()!=null)
				{
					strValorActual=hobby.getHobbyOriginal().getid_empresa().toString();
				}
				if(hobby.getid_empresa()!=null)
				{
					strValorNuevo=hobby.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HobbyConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(hobby.getIsNew()||!hobby.getcodigo().equals(hobby.getHobbyOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(hobby.getHobbyOriginal().getcodigo()!=null)
				{
					strValorActual=hobby.getHobbyOriginal().getcodigo();
				}
				if(hobby.getcodigo()!=null)
				{
					strValorNuevo=hobby.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HobbyConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(hobby.getIsNew()||!hobby.getnombre().equals(hobby.getHobbyOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(hobby.getHobbyOriginal().getnombre()!=null)
				{
					strValorActual=hobby.getHobbyOriginal().getnombre();
				}
				if(hobby.getnombre()!=null)
				{
					strValorNuevo=hobby.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HobbyConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(hobby.getIsNew()||!hobby.getdescripcion().equals(hobby.getHobbyOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(hobby.getHobbyOriginal().getdescripcion()!=null)
				{
					strValorActual=hobby.getHobbyOriginal().getdescripcion();
				}
				if(hobby.getdescripcion()!=null)
				{
					strValorNuevo=hobby.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HobbyConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveHobbyRelacionesWithConnection(Hobby hobby,List<EmpleadoHobby> empleadohobbys,List<HobbyCliente> hobbyclientes) throws Exception {

		if(!hobby.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHobbyRelacionesBase(hobby,empleadohobbys,hobbyclientes,true);
		}
	}

	public void saveHobbyRelaciones(Hobby hobby,List<EmpleadoHobby> empleadohobbys,List<HobbyCliente> hobbyclientes)throws Exception {

		if(!hobby.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHobbyRelacionesBase(hobby,empleadohobbys,hobbyclientes,false);
		}
	}

	public void saveHobbyRelacionesBase(Hobby hobby,List<EmpleadoHobby> empleadohobbys,List<HobbyCliente> hobbyclientes,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Hobby-saveRelacionesWithConnection");}
	
			hobby.setEmpleadoHobbys(empleadohobbys);
			hobby.setHobbyClientes(hobbyclientes);

			this.setHobby(hobby);

			if(HobbyLogicAdditional.validarSaveRelaciones(hobby,this)) {

				HobbyLogicAdditional.updateRelacionesToSave(hobby,this);

				if((hobby.getIsNew()||hobby.getIsChanged())&&!hobby.getIsDeleted()) {
					this.saveHobby();
					this.saveHobbyRelacionesDetalles(empleadohobbys,hobbyclientes);

				} else if(hobby.getIsDeleted()) {
					this.saveHobbyRelacionesDetalles(empleadohobbys,hobbyclientes);
					this.saveHobby();
				}

				HobbyLogicAdditional.updateRelacionesToSaveAfter(hobby,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			EmpleadoHobbyConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoHobbys(empleadohobbys,true,true);
			HobbyClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresHobbyClientes(hobbyclientes,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveHobbyRelacionesDetalles(List<EmpleadoHobby> empleadohobbys,List<HobbyCliente> hobbyclientes)throws Exception {
		try {
	

			Long idHobbyActual=this.getHobby().getId();

			EmpleadoHobbyLogic empleadohobbyLogic_Desde_Hobby=new EmpleadoHobbyLogic();
			empleadohobbyLogic_Desde_Hobby.setEmpleadoHobbys(empleadohobbys);

			empleadohobbyLogic_Desde_Hobby.setConnexion(this.getConnexion());
			empleadohobbyLogic_Desde_Hobby.setDatosCliente(this.datosCliente);

			for(EmpleadoHobby empleadohobby_Desde_Hobby:empleadohobbyLogic_Desde_Hobby.getEmpleadoHobbys()) {
				empleadohobby_Desde_Hobby.setid_hobby(idHobbyActual);
			}

			empleadohobbyLogic_Desde_Hobby.saveEmpleadoHobbys();

			HobbyClienteLogic hobbyclienteLogic_Desde_Hobby=new HobbyClienteLogic();
			hobbyclienteLogic_Desde_Hobby.setHobbyClientes(hobbyclientes);

			hobbyclienteLogic_Desde_Hobby.setConnexion(this.getConnexion());
			hobbyclienteLogic_Desde_Hobby.setDatosCliente(this.datosCliente);

			for(HobbyCliente hobbycliente_Desde_Hobby:hobbyclienteLogic_Desde_Hobby.getHobbyClientes()) {
				hobbycliente_Desde_Hobby.setid_hobby(idHobbyActual);
			}

			hobbyclienteLogic_Desde_Hobby.saveHobbyClientes();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfHobby(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HobbyConstantesFunciones.getClassesForeignKeysOfHobby(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHobby(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HobbyConstantesFunciones.getClassesRelationshipsOfHobby(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

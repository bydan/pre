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
import com.bydan.erp.nomina.util.PreguntaNomiConstantesFunciones;
import com.bydan.erp.nomina.util.PreguntaNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.PreguntaNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.PreguntaNomi;
import com.bydan.erp.nomina.business.logic.PreguntaNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class PreguntaNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PreguntaNomiLogic.class);
	
	protected PreguntaNomiDataAccess preguntanomiDataAccess; 	
	protected PreguntaNomi preguntanomi;
	protected List<PreguntaNomi> preguntanomis;
	protected Object preguntanomiObject;	
	protected List<Object> preguntanomisObject;
	
	public static ClassValidator<PreguntaNomi> preguntanomiValidator = new ClassValidator<PreguntaNomi>(PreguntaNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PreguntaNomiLogicAdditional preguntanomiLogicAdditional=null;
	
	public PreguntaNomiLogicAdditional getPreguntaNomiLogicAdditional() {
		return this.preguntanomiLogicAdditional;
	}
	
	public void setPreguntaNomiLogicAdditional(PreguntaNomiLogicAdditional preguntanomiLogicAdditional) {
		try {
			this.preguntanomiLogicAdditional=preguntanomiLogicAdditional;
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
	
	
	
	
	public  PreguntaNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.preguntanomiDataAccess = new PreguntaNomiDataAccess();
			
			this.preguntanomis= new ArrayList<PreguntaNomi>();
			this.preguntanomi= new PreguntaNomi();
			
			this.preguntanomiObject=new Object();
			this.preguntanomisObject=new ArrayList<Object>();
				
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
			
			this.preguntanomiDataAccess.setConnexionType(this.connexionType);
			this.preguntanomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PreguntaNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.preguntanomiDataAccess = new PreguntaNomiDataAccess();
			this.preguntanomis= new ArrayList<PreguntaNomi>();
			this.preguntanomi= new PreguntaNomi();
			this.preguntanomiObject=new Object();
			this.preguntanomisObject=new ArrayList<Object>();
			
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
			
			this.preguntanomiDataAccess.setConnexionType(this.connexionType);
			this.preguntanomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PreguntaNomi getPreguntaNomi() throws Exception {	
		PreguntaNomiLogicAdditional.checkPreguntaNomiToGet(preguntanomi,this.datosCliente,this.arrDatoGeneral);
		PreguntaNomiLogicAdditional.updatePreguntaNomiToGet(preguntanomi,this.arrDatoGeneral);
		
		return preguntanomi;
	}
		
	public void setPreguntaNomi(PreguntaNomi newPreguntaNomi) {
		this.preguntanomi = newPreguntaNomi;
	}
	
	public PreguntaNomiDataAccess getPreguntaNomiDataAccess() {
		return preguntanomiDataAccess;
	}
	
	public void setPreguntaNomiDataAccess(PreguntaNomiDataAccess newpreguntanomiDataAccess) {
		this.preguntanomiDataAccess = newpreguntanomiDataAccess;
	}
	
	public List<PreguntaNomi> getPreguntaNomis() throws Exception {		
		this.quitarPreguntaNomisNulos();
		
		PreguntaNomiLogicAdditional.checkPreguntaNomiToGets(preguntanomis,this.datosCliente,this.arrDatoGeneral);
		
		for (PreguntaNomi preguntanomiLocal: preguntanomis ) {
			PreguntaNomiLogicAdditional.updatePreguntaNomiToGet(preguntanomiLocal,this.arrDatoGeneral);
		}
		
		return preguntanomis;
	}
	
	public void setPreguntaNomis(List<PreguntaNomi> newPreguntaNomis) {
		this.preguntanomis = newPreguntaNomis;
	}
	
	public Object getPreguntaNomiObject() {	
		this.preguntanomiObject=this.preguntanomiDataAccess.getEntityObject();
		return this.preguntanomiObject;
	}
		
	public void setPreguntaNomiObject(Object newPreguntaNomiObject) {
		this.preguntanomiObject = newPreguntaNomiObject;
	}
	
	public List<Object> getPreguntaNomisObject() {		
		this.preguntanomisObject=this.preguntanomiDataAccess.getEntitiesObject();
		return this.preguntanomisObject;
	}
		
	public void setPreguntaNomisObject(List<Object> newPreguntaNomisObject) {
		this.preguntanomisObject = newPreguntaNomisObject;
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
		
		if(this.preguntanomiDataAccess!=null) {
			this.preguntanomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			preguntanomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			preguntanomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		preguntanomi = new  PreguntaNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			preguntanomi=preguntanomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomi);
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
		preguntanomi = new  PreguntaNomi();
		  		  
        try {
			
			preguntanomi=preguntanomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		preguntanomi = new  PreguntaNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			preguntanomi=preguntanomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomi);
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
		preguntanomi = new  PreguntaNomi();
		  		  
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
		preguntanomi = new  PreguntaNomi();
		  		  
        try {
			
			preguntanomi=preguntanomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		preguntanomi = new  PreguntaNomi();
		  		  
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
		preguntanomi = new  PreguntaNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =preguntanomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		preguntanomi = new  PreguntaNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=preguntanomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		preguntanomi = new  PreguntaNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =preguntanomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		preguntanomi = new  PreguntaNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=preguntanomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		preguntanomi = new  PreguntaNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =preguntanomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		preguntanomi = new  PreguntaNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=preguntanomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		preguntanomis = new  ArrayList<PreguntaNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomis=preguntanomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaNomi(preguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
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
		preguntanomis = new  ArrayList<PreguntaNomi>();
		  		  
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
		preguntanomis = new  ArrayList<PreguntaNomi>();
		  		  
        try {			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomis=preguntanomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPreguntaNomi(preguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		preguntanomis = new  ArrayList<PreguntaNomi>();
		  		  
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
		preguntanomis = new  ArrayList<PreguntaNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomis=preguntanomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaNomi(preguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
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
		preguntanomis = new  ArrayList<PreguntaNomi>();
		  		  
        try {
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomis=preguntanomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaNomi(preguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
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
		preguntanomis = new  ArrayList<PreguntaNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomis=preguntanomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaNomi(preguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
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
		preguntanomis = new  ArrayList<PreguntaNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomis=preguntanomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaNomi(preguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		preguntanomi = new  PreguntaNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomi=preguntanomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaNomi(preguntanomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomi);
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
		preguntanomi = new  PreguntaNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomi=preguntanomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaNomi(preguntanomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		preguntanomis = new  ArrayList<PreguntaNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomis=preguntanomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaNomi(preguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
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
		preguntanomis = new  ArrayList<PreguntaNomi>();
		  		  
        try {
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomis=preguntanomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaNomi(preguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPreguntaNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		preguntanomis = new  ArrayList<PreguntaNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getTodosPreguntaNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomis=preguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPreguntaNomi(preguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
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
	
	public  void  getTodosPreguntaNomis(String sFinalQuery,Pagination pagination)throws Exception {
		preguntanomis = new  ArrayList<PreguntaNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntanomis=preguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPreguntaNomi(preguntanomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPreguntaNomi(PreguntaNomi preguntanomi) throws Exception {
		Boolean estaValidado=false;
		
		if(preguntanomi.getIsNew() || preguntanomi.getIsChanged()) { 
			this.invalidValues = preguntanomiValidator.getInvalidValues(preguntanomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(preguntanomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPreguntaNomi(List<PreguntaNomi> PreguntaNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PreguntaNomi preguntanomiLocal:preguntanomis) {				
			estaValidadoObjeto=this.validarGuardarPreguntaNomi(preguntanomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPreguntaNomi(List<PreguntaNomi> PreguntaNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPreguntaNomi(preguntanomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPreguntaNomi(PreguntaNomi PreguntaNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPreguntaNomi(preguntanomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PreguntaNomi preguntanomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+preguntanomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PreguntaNomiConstantesFunciones.getPreguntaNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"preguntanomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PreguntaNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PreguntaNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePreguntaNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-savePreguntaNomiWithConnection");connexion.begin();			
			
			PreguntaNomiLogicAdditional.checkPreguntaNomiToSave(this.preguntanomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PreguntaNomiLogicAdditional.updatePreguntaNomiToSave(this.preguntanomi,this.arrDatoGeneral);
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.preguntanomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPreguntaNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPreguntaNomi(this.preguntanomi)) {
				PreguntaNomiDataAccess.save(this.preguntanomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.preguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PreguntaNomiLogicAdditional.checkPreguntaNomiToSaveAfter(this.preguntanomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPreguntaNomi();
			
			connexion.commit();			
			
			if(this.preguntanomi.getIsDeleted()) {
				this.preguntanomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePreguntaNomi()throws Exception {	
		try {	
			
			PreguntaNomiLogicAdditional.checkPreguntaNomiToSave(this.preguntanomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PreguntaNomiLogicAdditional.updatePreguntaNomiToSave(this.preguntanomi,this.arrDatoGeneral);
			
			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.preguntanomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPreguntaNomi(this.preguntanomi)) {			
				PreguntaNomiDataAccess.save(this.preguntanomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.preguntanomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PreguntaNomiLogicAdditional.checkPreguntaNomiToSaveAfter(this.preguntanomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.preguntanomi.getIsDeleted()) {
				this.preguntanomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePreguntaNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-savePreguntaNomisWithConnection");connexion.begin();			
			
			PreguntaNomiLogicAdditional.checkPreguntaNomiToSaves(preguntanomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPreguntaNomis();
			
			Boolean validadoTodosPreguntaNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PreguntaNomi preguntanomiLocal:preguntanomis) {		
				if(preguntanomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PreguntaNomiLogicAdditional.updatePreguntaNomiToSave(preguntanomiLocal,this.arrDatoGeneral);
	        	
				PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),preguntanomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPreguntaNomi(preguntanomiLocal)) {
					PreguntaNomiDataAccess.save(preguntanomiLocal, connexion);				
				} else {
					validadoTodosPreguntaNomi=false;
				}
			}
			
			if(!validadoTodosPreguntaNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PreguntaNomiLogicAdditional.checkPreguntaNomiToSavesAfter(preguntanomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPreguntaNomis();
			
			connexion.commit();		
			
			this.quitarPreguntaNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePreguntaNomis()throws Exception {				
		 try {	
			PreguntaNomiLogicAdditional.checkPreguntaNomiToSaves(preguntanomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPreguntaNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PreguntaNomi preguntanomiLocal:preguntanomis) {				
				if(preguntanomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PreguntaNomiLogicAdditional.updatePreguntaNomiToSave(preguntanomiLocal,this.arrDatoGeneral);
	        	
				PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),preguntanomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPreguntaNomi(preguntanomiLocal)) {				
					PreguntaNomiDataAccess.save(preguntanomiLocal, connexion);				
				} else {
					validadoTodosPreguntaNomi=false;
				}
			}
			
			if(!validadoTodosPreguntaNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PreguntaNomiLogicAdditional.checkPreguntaNomiToSavesAfter(preguntanomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPreguntaNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PreguntaNomiParameterReturnGeneral procesarAccionPreguntaNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PreguntaNomi> preguntanomis,PreguntaNomiParameterReturnGeneral preguntanomiParameterGeneral)throws Exception {
		 try {	
			PreguntaNomiParameterReturnGeneral preguntanomiReturnGeneral=new PreguntaNomiParameterReturnGeneral();
	
			PreguntaNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,preguntanomis,preguntanomiParameterGeneral,preguntanomiReturnGeneral);
			
			return preguntanomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PreguntaNomiParameterReturnGeneral procesarAccionPreguntaNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PreguntaNomi> preguntanomis,PreguntaNomiParameterReturnGeneral preguntanomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-procesarAccionPreguntaNomisWithConnection");connexion.begin();			
			
			PreguntaNomiParameterReturnGeneral preguntanomiReturnGeneral=new PreguntaNomiParameterReturnGeneral();
	
			PreguntaNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,preguntanomis,preguntanomiParameterGeneral,preguntanomiReturnGeneral);
			
			this.connexion.commit();
			
			return preguntanomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PreguntaNomiParameterReturnGeneral procesarEventosPreguntaNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PreguntaNomi> preguntanomis,PreguntaNomi preguntanomi,PreguntaNomiParameterReturnGeneral preguntanomiParameterGeneral,Boolean isEsNuevoPreguntaNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			PreguntaNomiParameterReturnGeneral preguntanomiReturnGeneral=new PreguntaNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				preguntanomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PreguntaNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,preguntanomis,preguntanomi,preguntanomiParameterGeneral,preguntanomiReturnGeneral,isEsNuevoPreguntaNomi,clases);
			
			return preguntanomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PreguntaNomiParameterReturnGeneral procesarEventosPreguntaNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PreguntaNomi> preguntanomis,PreguntaNomi preguntanomi,PreguntaNomiParameterReturnGeneral preguntanomiParameterGeneral,Boolean isEsNuevoPreguntaNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-procesarEventosPreguntaNomisWithConnection");connexion.begin();			
			
			PreguntaNomiParameterReturnGeneral preguntanomiReturnGeneral=new PreguntaNomiParameterReturnGeneral();
	
			preguntanomiReturnGeneral.setPreguntaNomi(preguntanomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				preguntanomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PreguntaNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,preguntanomis,preguntanomi,preguntanomiParameterGeneral,preguntanomiReturnGeneral,isEsNuevoPreguntaNomi,clases);
			
			this.connexion.commit();
			
			return preguntanomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PreguntaNomiParameterReturnGeneral procesarImportacionPreguntaNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PreguntaNomiParameterReturnGeneral preguntanomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-procesarImportacionPreguntaNomisWithConnection");connexion.begin();			
			
			PreguntaNomiParameterReturnGeneral preguntanomiReturnGeneral=new PreguntaNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.preguntanomis=new ArrayList<PreguntaNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.preguntanomi=new PreguntaNomi();
				
				
				if(conColumnasBase) {this.preguntanomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.preguntanomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.preguntanomi.setpregunta(arrColumnas[iColumn++]);
				this.preguntanomi.setorden(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.preguntanomis.add(this.preguntanomi);
			}
			
			this.savePreguntaNomis();
			
			this.connexion.commit();
			
			preguntanomiReturnGeneral.setConRetornoEstaProcesado(true);
			preguntanomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return preguntanomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPreguntaNomisEliminados() throws Exception {				
		
		List<PreguntaNomi> preguntanomisAux= new ArrayList<PreguntaNomi>();
		
		for(PreguntaNomi preguntanomi:preguntanomis) {
			if(!preguntanomi.getIsDeleted()) {
				preguntanomisAux.add(preguntanomi);
			}
		}
		
		preguntanomis=preguntanomisAux;
	}
	
	public void quitarPreguntaNomisNulos() throws Exception {				
		
		List<PreguntaNomi> preguntanomisAux= new ArrayList<PreguntaNomi>();
		
		for(PreguntaNomi preguntanomi : this.preguntanomis) {
			if(preguntanomi==null) {
				preguntanomisAux.add(preguntanomi);
			}
		}
		
		//this.preguntanomis=preguntanomisAux;
		
		this.preguntanomis.removeAll(preguntanomisAux);
	}
	
	public void getSetVersionRowPreguntaNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(preguntanomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((preguntanomi.getIsDeleted() || (preguntanomi.getIsChanged()&&!preguntanomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=preguntanomiDataAccess.getSetVersionRowPreguntaNomi(connexion,preguntanomi.getId());
				
				if(!preguntanomi.getVersionRow().equals(timestamp)) {	
					preguntanomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				preguntanomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPreguntaNomi()throws Exception {	
		
		if(preguntanomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((preguntanomi.getIsDeleted() || (preguntanomi.getIsChanged()&&!preguntanomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=preguntanomiDataAccess.getSetVersionRowPreguntaNomi(connexion,preguntanomi.getId());
			
			try {							
				if(!preguntanomi.getVersionRow().equals(timestamp)) {	
					preguntanomi.setVersionRow(timestamp);
				}
				
				preguntanomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPreguntaNomisWithConnection()throws Exception {	
		if(preguntanomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PreguntaNomi preguntanomiAux:preguntanomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(preguntanomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(preguntanomiAux.getIsDeleted() || (preguntanomiAux.getIsChanged()&&!preguntanomiAux.getIsNew())) {
						
						timestamp=preguntanomiDataAccess.getSetVersionRowPreguntaNomi(connexion,preguntanomiAux.getId());
						
						if(!preguntanomi.getVersionRow().equals(timestamp)) {	
							preguntanomiAux.setVersionRow(timestamp);
						}
								
						preguntanomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPreguntaNomis()throws Exception {	
		if(preguntanomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PreguntaNomi preguntanomiAux:preguntanomis) {
					if(preguntanomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(preguntanomiAux.getIsDeleted() || (preguntanomiAux.getIsChanged()&&!preguntanomiAux.getIsNew())) {
						
						timestamp=preguntanomiDataAccess.getSetVersionRowPreguntaNomi(connexion,preguntanomiAux.getId());
						
						if(!preguntanomiAux.getVersionRow().equals(timestamp)) {	
							preguntanomiAux.setVersionRow(timestamp);
						}
						
													
						preguntanomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PreguntaNomiParameterReturnGeneral cargarCombosLoteForeignKeyPreguntaNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalFactorNomi) throws Exception {
		PreguntaNomiParameterReturnGeneral  preguntanomiReturnGeneral =new PreguntaNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyPreguntaNomiWithConnection");connexion.begin();
			
			preguntanomiReturnGeneral =new PreguntaNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			preguntanomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<FactorNomi> factornomisForeignKey=new ArrayList<FactorNomi>();
			FactorNomiLogic factornomiLogic=new FactorNomiLogic();
			factornomiLogic.setConnexion(this.connexion);
			factornomiLogic.getFactorNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactorNomi.equals("NONE")) {
				factornomiLogic.getTodosFactorNomis(finalQueryGlobalFactorNomi,new Pagination());
				factornomisForeignKey=factornomiLogic.getFactorNomis();
			}

			preguntanomiReturnGeneral.setfactornomisForeignKey(factornomisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return preguntanomiReturnGeneral;
	}
	
	public PreguntaNomiParameterReturnGeneral cargarCombosLoteForeignKeyPreguntaNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalFactorNomi) throws Exception {
		PreguntaNomiParameterReturnGeneral  preguntanomiReturnGeneral =new PreguntaNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			preguntanomiReturnGeneral =new PreguntaNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			preguntanomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<FactorNomi> factornomisForeignKey=new ArrayList<FactorNomi>();
			FactorNomiLogic factornomiLogic=new FactorNomiLogic();
			factornomiLogic.setConnexion(this.connexion);
			factornomiLogic.getFactorNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactorNomi.equals("NONE")) {
				factornomiLogic.getTodosFactorNomis(finalQueryGlobalFactorNomi,new Pagination());
				factornomisForeignKey=factornomiLogic.getFactorNomis();
			}

			preguntanomiReturnGeneral.setfactornomisForeignKey(factornomisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return preguntanomiReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPreguntaNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic=new FormatoNomiPreguntaNomiLogic();
			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic=new DetalleEvaluacionNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPreguntaNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormatoNomiPreguntaNomi.class));
			classes.add(new Classe(DetalleEvaluacionNomi.class));
											
			

			formatonomipreguntanomiLogic.setConnexion(this.getConnexion());
			formatonomipreguntanomiLogic.setDatosCliente(this.datosCliente);
			formatonomipreguntanomiLogic.setIsConRefrescarForeignKeys(true);

			detalleevaluacionnomiLogic.setConnexion(this.getConnexion());
			detalleevaluacionnomiLogic.setDatosCliente(this.datosCliente);
			detalleevaluacionnomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PreguntaNomi preguntanomi:this.preguntanomis) {
				

				classes=new ArrayList<Classe>();
				classes=FormatoNomiPreguntaNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiPreguntaNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				formatonomipreguntanomiLogic.setFormatoNomiPreguntaNomis(preguntanomi.formatonomipreguntanomis);
				formatonomipreguntanomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleEvaluacionNomiConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleevaluacionnomiLogic.setDetalleEvaluacionNomis(preguntanomi.detalleevaluacionnomis);
				detalleevaluacionnomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PreguntaNomi preguntanomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PreguntaNomiLogicAdditional.updatePreguntaNomiToGet(preguntanomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		preguntanomi.setEmpresa(preguntanomiDataAccess.getEmpresa(connexion,preguntanomi));
		preguntanomi.setFactorNomi(preguntanomiDataAccess.getFactorNomi(connexion,preguntanomi));
		preguntanomi.setFormatoNomiPreguntaNomis(preguntanomiDataAccess.getFormatoNomiPreguntaNomis(connexion,preguntanomi));
		preguntanomi.setDetalleEvaluacionNomis(preguntanomiDataAccess.getDetalleEvaluacionNomis(connexion,preguntanomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				preguntanomi.setEmpresa(preguntanomiDataAccess.getEmpresa(connexion,preguntanomi));
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				preguntanomi.setFactorNomi(preguntanomiDataAccess.getFactorNomi(connexion,preguntanomi));
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				preguntanomi.setFormatoNomiPreguntaNomis(preguntanomiDataAccess.getFormatoNomiPreguntaNomis(connexion,preguntanomi));

				if(this.isConDeep) {
					FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(this.connexion);
					formatonomipreguntanomiLogic.setFormatoNomiPreguntaNomis(preguntanomi.getFormatoNomiPreguntaNomis());
					ArrayList<Classe> classesLocal=FormatoNomiPreguntaNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomiPreguntaNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					formatonomipreguntanomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormatoNomiPreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomiPreguntaNomi(formatonomipreguntanomiLogic.getFormatoNomiPreguntaNomis());
					preguntanomi.setFormatoNomiPreguntaNomis(formatonomipreguntanomiLogic.getFormatoNomiPreguntaNomis());
				}

				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				preguntanomi.setDetalleEvaluacionNomis(preguntanomiDataAccess.getDetalleEvaluacionNomis(connexion,preguntanomi));

				if(this.isConDeep) {
					DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(this.connexion);
					detalleevaluacionnomiLogic.setDetalleEvaluacionNomis(preguntanomi.getDetalleEvaluacionNomis());
					ArrayList<Classe> classesLocal=DetalleEvaluacionNomiConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleevaluacionnomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(detalleevaluacionnomiLogic.getDetalleEvaluacionNomis());
					preguntanomi.setDetalleEvaluacionNomis(detalleevaluacionnomiLogic.getDetalleEvaluacionNomis());
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
			preguntanomi.setEmpresa(preguntanomiDataAccess.getEmpresa(connexion,preguntanomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FactorNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntanomi.setFactorNomi(preguntanomiDataAccess.getFactorNomi(connexion,preguntanomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomiPreguntaNomi.class));
			preguntanomi.setFormatoNomiPreguntaNomis(preguntanomiDataAccess.getFormatoNomiPreguntaNomis(connexion,preguntanomi));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleEvaluacionNomi.class));
			preguntanomi.setDetalleEvaluacionNomis(preguntanomiDataAccess.getDetalleEvaluacionNomis(connexion,preguntanomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		preguntanomi.setEmpresa(preguntanomiDataAccess.getEmpresa(connexion,preguntanomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(preguntanomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		preguntanomi.setFactorNomi(preguntanomiDataAccess.getFactorNomi(connexion,preguntanomi));
		FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
		factornomiLogic.deepLoad(preguntanomi.getFactorNomi(),isDeep,deepLoadType,clases);
				

		preguntanomi.setFormatoNomiPreguntaNomis(preguntanomiDataAccess.getFormatoNomiPreguntaNomis(connexion,preguntanomi));

		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:preguntanomi.getFormatoNomiPreguntaNomis()) {
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
			formatonomipreguntanomiLogic.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
		}

		preguntanomi.setDetalleEvaluacionNomis(preguntanomiDataAccess.getDetalleEvaluacionNomis(connexion,preguntanomi));

		for(DetalleEvaluacionNomi detalleevaluacionnomi:preguntanomi.getDetalleEvaluacionNomis()) {
			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
			detalleevaluacionnomiLogic.deepLoad(detalleevaluacionnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				preguntanomi.setEmpresa(preguntanomiDataAccess.getEmpresa(connexion,preguntanomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(preguntanomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				preguntanomi.setFactorNomi(preguntanomiDataAccess.getFactorNomi(connexion,preguntanomi));
				FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
				factornomiLogic.deepLoad(preguntanomi.getFactorNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				preguntanomi.setFormatoNomiPreguntaNomis(preguntanomiDataAccess.getFormatoNomiPreguntaNomis(connexion,preguntanomi));

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:preguntanomi.getFormatoNomiPreguntaNomis()) {
					FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
					formatonomipreguntanomiLogic.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				preguntanomi.setDetalleEvaluacionNomis(preguntanomiDataAccess.getDetalleEvaluacionNomis(connexion,preguntanomi));

				for(DetalleEvaluacionNomi detalleevaluacionnomi:preguntanomi.getDetalleEvaluacionNomis()) {
					DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
					detalleevaluacionnomiLogic.deepLoad(detalleevaluacionnomi,isDeep,deepLoadType,clases);
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
			preguntanomi.setEmpresa(preguntanomiDataAccess.getEmpresa(connexion,preguntanomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(preguntanomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FactorNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntanomi.setFactorNomi(preguntanomiDataAccess.getFactorNomi(connexion,preguntanomi));
			FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
			factornomiLogic.deepLoad(preguntanomi.getFactorNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomiPreguntaNomi.class));
			preguntanomi.setFormatoNomiPreguntaNomis(preguntanomiDataAccess.getFormatoNomiPreguntaNomis(connexion,preguntanomi));

			for(FormatoNomiPreguntaNomi formatonomipreguntanomi:preguntanomi.getFormatoNomiPreguntaNomis()) {
				FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
				formatonomipreguntanomiLogic.deepLoad(formatonomipreguntanomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleEvaluacionNomi.class));
			preguntanomi.setDetalleEvaluacionNomis(preguntanomiDataAccess.getDetalleEvaluacionNomis(connexion,preguntanomi));

			for(DetalleEvaluacionNomi detalleevaluacionnomi:preguntanomi.getDetalleEvaluacionNomis()) {
				DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
				detalleevaluacionnomiLogic.deepLoad(detalleevaluacionnomi,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PreguntaNomi preguntanomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PreguntaNomiLogicAdditional.updatePreguntaNomiToSave(preguntanomi,this.arrDatoGeneral);
			
PreguntaNomiDataAccess.save(preguntanomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(preguntanomi.getEmpresa(),connexion);

		FactorNomiDataAccess.save(preguntanomi.getFactorNomi(),connexion);

		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:preguntanomi.getFormatoNomiPreguntaNomis()) {
			formatonomipreguntanomi.setid_pregunta_nomi(preguntanomi.getId());
			FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
		}

		for(DetalleEvaluacionNomi detalleevaluacionnomi:preguntanomi.getDetalleEvaluacionNomis()) {
			detalleevaluacionnomi.setid_pregunta_nomi(preguntanomi.getId());
			DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(preguntanomi.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				FactorNomiDataAccess.save(preguntanomi.getFactorNomi(),connexion);
				continue;
			}


			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:preguntanomi.getFormatoNomiPreguntaNomis()) {
					formatonomipreguntanomi.setid_pregunta_nomi(preguntanomi.getId());
					FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionNomi detalleevaluacionnomi:preguntanomi.getDetalleEvaluacionNomis()) {
					detalleevaluacionnomi.setid_pregunta_nomi(preguntanomi.getId());
					DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(preguntanomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(preguntanomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		FactorNomiDataAccess.save(preguntanomi.getFactorNomi(),connexion);
		FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
		factornomiLogic.deepLoad(preguntanomi.getFactorNomi(),isDeep,deepLoadType,clases);
				

		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:preguntanomi.getFormatoNomiPreguntaNomis()) {
			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
			formatonomipreguntanomi.setid_pregunta_nomi(preguntanomi.getId());
			FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
			formatonomipreguntanomiLogic.deepSave(formatonomipreguntanomi,isDeep,deepLoadType,clases);
		}

		for(DetalleEvaluacionNomi detalleevaluacionnomi:preguntanomi.getDetalleEvaluacionNomis()) {
			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
			detalleevaluacionnomi.setid_pregunta_nomi(preguntanomi.getId());
			DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
			detalleevaluacionnomiLogic.deepSave(detalleevaluacionnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(preguntanomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(preguntanomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FactorNomi.class)) {
				FactorNomiDataAccess.save(preguntanomi.getFactorNomi(),connexion);
				FactorNomiLogic factornomiLogic= new FactorNomiLogic(connexion);
				factornomiLogic.deepSave(preguntanomi.getFactorNomi(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(FormatoNomiPreguntaNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi:preguntanomi.getFormatoNomiPreguntaNomis()) {
					FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic= new FormatoNomiPreguntaNomiLogic(connexion);
					formatonomipreguntanomi.setid_pregunta_nomi(preguntanomi.getId());
					FormatoNomiPreguntaNomiDataAccess.save(formatonomipreguntanomi,connexion);
					formatonomipreguntanomiLogic.deepSave(formatonomipreguntanomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionNomi detalleevaluacionnomi:preguntanomi.getDetalleEvaluacionNomis()) {
					DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
					detalleevaluacionnomi.setid_pregunta_nomi(preguntanomi.getId());
					DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
					detalleevaluacionnomiLogic.deepSave(detalleevaluacionnomi,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PreguntaNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(preguntanomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(preguntanomi);
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
			this.deepLoad(this.preguntanomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PreguntaNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(preguntanomis!=null) {
				for(PreguntaNomi preguntanomi:preguntanomis) {
					this.deepLoad(preguntanomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(preguntanomis);
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
			if(preguntanomis!=null) {
				for(PreguntaNomi preguntanomi:preguntanomis) {
					this.deepLoad(preguntanomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(preguntanomis);
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
			this.getNewConnexionToDeep(PreguntaNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(preguntanomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PreguntaNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(preguntanomis!=null) {
				for(PreguntaNomi preguntanomi:preguntanomis) {
					this.deepSave(preguntanomi,isDeep,deepLoadType,clases);
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
			if(preguntanomis!=null) {
				for(PreguntaNomi preguntanomi:preguntanomis) {
					this.deepSave(preguntanomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPreguntaNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PreguntaNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntanomis=preguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PreguntaNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntanomis=preguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaNomisFK_IdFactorNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_factor_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactorNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactorNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factor_nomi,PreguntaNomiConstantesFunciones.IDFACTORNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactorNomi);

			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactorNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntanomis=preguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaNomisFK_IdFactorNomi(String sFinalQuery,Pagination pagination,Long id_factor_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactorNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactorNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factor_nomi,PreguntaNomiConstantesFunciones.IDFACTORNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactorNomi);

			PreguntaNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactorNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntanomis=preguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaNomiConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaNomi(this.preguntanomis);
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
			if(PreguntaNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PreguntaNomi preguntanomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PreguntaNomiConstantesFunciones.ISCONAUDITORIA) {
				if(preguntanomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaNomiDataAccess.TABLENAME, preguntanomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PreguntaNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PreguntaNomiLogic.registrarAuditoriaDetallesPreguntaNomi(connexion,preguntanomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(preguntanomi.getIsDeleted()) {
					/*if(!preguntanomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PreguntaNomiDataAccess.TABLENAME, preguntanomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PreguntaNomiLogic.registrarAuditoriaDetallesPreguntaNomi(connexion,preguntanomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaNomiDataAccess.TABLENAME, preguntanomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(preguntanomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaNomiDataAccess.TABLENAME, preguntanomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PreguntaNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PreguntaNomiLogic.registrarAuditoriaDetallesPreguntaNomi(connexion,preguntanomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPreguntaNomi(Connexion connexion,PreguntaNomi preguntanomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(preguntanomi.getIsNew()||!preguntanomi.getid_empresa().equals(preguntanomi.getPreguntaNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntanomi.getPreguntaNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=preguntanomi.getPreguntaNomiOriginal().getid_empresa().toString();
				}
				if(preguntanomi.getid_empresa()!=null)
				{
					strValorNuevo=preguntanomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(preguntanomi.getIsNew()||!preguntanomi.getid_factor_nomi().equals(preguntanomi.getPreguntaNomiOriginal().getid_factor_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntanomi.getPreguntaNomiOriginal().getid_factor_nomi()!=null)
				{
					strValorActual=preguntanomi.getPreguntaNomiOriginal().getid_factor_nomi().toString();
				}
				if(preguntanomi.getid_factor_nomi()!=null)
				{
					strValorNuevo=preguntanomi.getid_factor_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaNomiConstantesFunciones.IDFACTORNOMI,strValorActual,strValorNuevo);
			}	
			
			if(preguntanomi.getIsNew()||!preguntanomi.getpregunta().equals(preguntanomi.getPreguntaNomiOriginal().getpregunta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntanomi.getPreguntaNomiOriginal().getpregunta()!=null)
				{
					strValorActual=preguntanomi.getPreguntaNomiOriginal().getpregunta();
				}
				if(preguntanomi.getpregunta()!=null)
				{
					strValorNuevo=preguntanomi.getpregunta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaNomiConstantesFunciones.PREGUNTA,strValorActual,strValorNuevo);
			}	
			
			if(preguntanomi.getIsNew()||!preguntanomi.getorden().equals(preguntanomi.getPreguntaNomiOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntanomi.getPreguntaNomiOriginal().getorden()!=null)
				{
					strValorActual=preguntanomi.getPreguntaNomiOriginal().getorden().toString();
				}
				if(preguntanomi.getorden()!=null)
				{
					strValorNuevo=preguntanomi.getorden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaNomiConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePreguntaNomiRelacionesWithConnection(PreguntaNomi preguntanomi,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,List<DetalleEvaluacionNomi> detalleevaluacionnomis) throws Exception {

		if(!preguntanomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePreguntaNomiRelacionesBase(preguntanomi,formatonomipreguntanomis,detalleevaluacionnomis,true);
		}
	}

	public void savePreguntaNomiRelaciones(PreguntaNomi preguntanomi,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,List<DetalleEvaluacionNomi> detalleevaluacionnomis)throws Exception {

		if(!preguntanomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePreguntaNomiRelacionesBase(preguntanomi,formatonomipreguntanomis,detalleevaluacionnomis,false);
		}
	}

	public void savePreguntaNomiRelacionesBase(PreguntaNomi preguntanomi,List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,List<DetalleEvaluacionNomi> detalleevaluacionnomis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PreguntaNomi-saveRelacionesWithConnection");}
	
			preguntanomi.setFormatoNomiPreguntaNomis(formatonomipreguntanomis);
			preguntanomi.setDetalleEvaluacionNomis(detalleevaluacionnomis);

			this.setPreguntaNomi(preguntanomi);

			if(PreguntaNomiLogicAdditional.validarSaveRelaciones(preguntanomi,this)) {

				PreguntaNomiLogicAdditional.updateRelacionesToSave(preguntanomi,this);

				if((preguntanomi.getIsNew()||preguntanomi.getIsChanged())&&!preguntanomi.getIsDeleted()) {
					this.savePreguntaNomi();
					this.savePreguntaNomiRelacionesDetalles(formatonomipreguntanomis,detalleevaluacionnomis);

				} else if(preguntanomi.getIsDeleted()) {
					this.savePreguntaNomiRelacionesDetalles(formatonomipreguntanomis,detalleevaluacionnomis);
					this.savePreguntaNomi();
				}

				PreguntaNomiLogicAdditional.updateRelacionesToSaveAfter(preguntanomi,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FormatoNomiPreguntaNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresFormatoNomiPreguntaNomis(formatonomipreguntanomis,true,true);
			DetalleEvaluacionNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleEvaluacionNomis(detalleevaluacionnomis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePreguntaNomiRelacionesDetalles(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis,List<DetalleEvaluacionNomi> detalleevaluacionnomis)throws Exception {
		try {
	

			Long idPreguntaNomiActual=this.getPreguntaNomi().getId();

			FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic_Desde_PreguntaNomi=new FormatoNomiPreguntaNomiLogic();
			formatonomipreguntanomiLogic_Desde_PreguntaNomi.setFormatoNomiPreguntaNomis(formatonomipreguntanomis);

			formatonomipreguntanomiLogic_Desde_PreguntaNomi.setConnexion(this.getConnexion());
			formatonomipreguntanomiLogic_Desde_PreguntaNomi.setDatosCliente(this.datosCliente);

			for(FormatoNomiPreguntaNomi formatonomipreguntanomi_Desde_PreguntaNomi:formatonomipreguntanomiLogic_Desde_PreguntaNomi.getFormatoNomiPreguntaNomis()) {
				formatonomipreguntanomi_Desde_PreguntaNomi.setid_pregunta_nomi(idPreguntaNomiActual);

				formatonomipreguntanomiLogic_Desde_PreguntaNomi.setFormatoNomiPreguntaNomi(formatonomipreguntanomi_Desde_PreguntaNomi);
				formatonomipreguntanomiLogic_Desde_PreguntaNomi.saveFormatoNomiPreguntaNomi();

				Long idFormatoNomiPreguntaNomiActual=formatonomipreguntanomi_Desde_PreguntaNomi.getId();

				CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi=new CalificacionEmpleadoLogic();

				if(formatonomipreguntanomi_Desde_PreguntaNomi.getCalificacionEmpleados()==null){
					formatonomipreguntanomi_Desde_PreguntaNomi.setCalificacionEmpleados(new ArrayList<CalificacionEmpleado>());
				}

				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setCalificacionEmpleados(formatonomipreguntanomi_Desde_PreguntaNomi.getCalificacionEmpleados());

				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setConnexion(this.getConnexion());
				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setDatosCliente(this.datosCliente);

				for(CalificacionEmpleado calificacionempleado_Desde_FormatoNomiPreguntaNomi:calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.getCalificacionEmpleados()) {
					calificacionempleado_Desde_FormatoNomiPreguntaNomi.setid_formato_nomi_pregunta_nomi(idFormatoNomiPreguntaNomiActual);
				}

				calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.saveCalificacionEmpleados();
			}


			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic_Desde_PreguntaNomi=new DetalleEvaluacionNomiLogic();
			detalleevaluacionnomiLogic_Desde_PreguntaNomi.setDetalleEvaluacionNomis(detalleevaluacionnomis);

			detalleevaluacionnomiLogic_Desde_PreguntaNomi.setConnexion(this.getConnexion());
			detalleevaluacionnomiLogic_Desde_PreguntaNomi.setDatosCliente(this.datosCliente);

			for(DetalleEvaluacionNomi detalleevaluacionnomi_Desde_PreguntaNomi:detalleevaluacionnomiLogic_Desde_PreguntaNomi.getDetalleEvaluacionNomis()) {
				detalleevaluacionnomi_Desde_PreguntaNomi.setid_pregunta_nomi(idPreguntaNomiActual);
			}

			detalleevaluacionnomiLogic_Desde_PreguntaNomi.saveDetalleEvaluacionNomis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPreguntaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PreguntaNomiConstantesFunciones.getClassesForeignKeysOfPreguntaNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreguntaNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PreguntaNomiConstantesFunciones.getClassesRelationshipsOfPreguntaNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

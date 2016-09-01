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
import com.bydan.erp.cartera.util.InformacionLaboralConstantesFunciones;
import com.bydan.erp.cartera.util.InformacionLaboralParameterReturnGeneral;
//import com.bydan.erp.cartera.util.InformacionLaboralParameterGeneral;
import com.bydan.erp.cartera.business.entity.InformacionLaboral;
import com.bydan.erp.cartera.business.logic.InformacionLaboralLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class InformacionLaboralLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(InformacionLaboralLogic.class);
	
	protected InformacionLaboralDataAccess informacionlaboralDataAccess; 	
	protected InformacionLaboral informacionlaboral;
	protected List<InformacionLaboral> informacionlaborals;
	protected Object informacionlaboralObject;	
	protected List<Object> informacionlaboralsObject;
	
	public static ClassValidator<InformacionLaboral> informacionlaboralValidator = new ClassValidator<InformacionLaboral>(InformacionLaboral.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected InformacionLaboralLogicAdditional informacionlaboralLogicAdditional=null;
	
	public InformacionLaboralLogicAdditional getInformacionLaboralLogicAdditional() {
		return this.informacionlaboralLogicAdditional;
	}
	
	public void setInformacionLaboralLogicAdditional(InformacionLaboralLogicAdditional informacionlaboralLogicAdditional) {
		try {
			this.informacionlaboralLogicAdditional=informacionlaboralLogicAdditional;
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
	
	
	
	
	public  InformacionLaboralLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.informacionlaboralDataAccess = new InformacionLaboralDataAccess();
			
			this.informacionlaborals= new ArrayList<InformacionLaboral>();
			this.informacionlaboral= new InformacionLaboral();
			
			this.informacionlaboralObject=new Object();
			this.informacionlaboralsObject=new ArrayList<Object>();
				
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
			
			this.informacionlaboralDataAccess.setConnexionType(this.connexionType);
			this.informacionlaboralDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  InformacionLaboralLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.informacionlaboralDataAccess = new InformacionLaboralDataAccess();
			this.informacionlaborals= new ArrayList<InformacionLaboral>();
			this.informacionlaboral= new InformacionLaboral();
			this.informacionlaboralObject=new Object();
			this.informacionlaboralsObject=new ArrayList<Object>();
			
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
			
			this.informacionlaboralDataAccess.setConnexionType(this.connexionType);
			this.informacionlaboralDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public InformacionLaboral getInformacionLaboral() throws Exception {	
		InformacionLaboralLogicAdditional.checkInformacionLaboralToGet(informacionlaboral,this.datosCliente,this.arrDatoGeneral);
		InformacionLaboralLogicAdditional.updateInformacionLaboralToGet(informacionlaboral,this.arrDatoGeneral);
		
		return informacionlaboral;
	}
		
	public void setInformacionLaboral(InformacionLaboral newInformacionLaboral) {
		this.informacionlaboral = newInformacionLaboral;
	}
	
	public InformacionLaboralDataAccess getInformacionLaboralDataAccess() {
		return informacionlaboralDataAccess;
	}
	
	public void setInformacionLaboralDataAccess(InformacionLaboralDataAccess newinformacionlaboralDataAccess) {
		this.informacionlaboralDataAccess = newinformacionlaboralDataAccess;
	}
	
	public List<InformacionLaboral> getInformacionLaborals() throws Exception {		
		this.quitarInformacionLaboralsNulos();
		
		InformacionLaboralLogicAdditional.checkInformacionLaboralToGets(informacionlaborals,this.datosCliente,this.arrDatoGeneral);
		
		for (InformacionLaboral informacionlaboralLocal: informacionlaborals ) {
			InformacionLaboralLogicAdditional.updateInformacionLaboralToGet(informacionlaboralLocal,this.arrDatoGeneral);
		}
		
		return informacionlaborals;
	}
	
	public void setInformacionLaborals(List<InformacionLaboral> newInformacionLaborals) {
		this.informacionlaborals = newInformacionLaborals;
	}
	
	public Object getInformacionLaboralObject() {	
		this.informacionlaboralObject=this.informacionlaboralDataAccess.getEntityObject();
		return this.informacionlaboralObject;
	}
		
	public void setInformacionLaboralObject(Object newInformacionLaboralObject) {
		this.informacionlaboralObject = newInformacionLaboralObject;
	}
	
	public List<Object> getInformacionLaboralsObject() {		
		this.informacionlaboralsObject=this.informacionlaboralDataAccess.getEntitiesObject();
		return this.informacionlaboralsObject;
	}
		
	public void setInformacionLaboralsObject(List<Object> newInformacionLaboralsObject) {
		this.informacionlaboralsObject = newInformacionLaboralsObject;
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
		
		if(this.informacionlaboralDataAccess!=null) {
			this.informacionlaboralDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			informacionlaboralDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			informacionlaboralDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		informacionlaboral = new  InformacionLaboral();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			informacionlaboral=informacionlaboralDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacionlaboral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaboral);
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
		informacionlaboral = new  InformacionLaboral();
		  		  
        try {
			
			informacionlaboral=informacionlaboralDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacionlaboral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaboral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		informacionlaboral = new  InformacionLaboral();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			informacionlaboral=informacionlaboralDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacionlaboral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaboral);
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
		informacionlaboral = new  InformacionLaboral();
		  		  
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
		informacionlaboral = new  InformacionLaboral();
		  		  
        try {
			
			informacionlaboral=informacionlaboralDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacionlaboral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaboral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		informacionlaboral = new  InformacionLaboral();
		  		  
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
		informacionlaboral = new  InformacionLaboral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =informacionlaboralDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		informacionlaboral = new  InformacionLaboral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=informacionlaboralDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		informacionlaboral = new  InformacionLaboral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =informacionlaboralDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		informacionlaboral = new  InformacionLaboral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=informacionlaboralDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		informacionlaboral = new  InformacionLaboral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =informacionlaboralDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		informacionlaboral = new  InformacionLaboral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=informacionlaboralDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionLaboral(informacionlaborals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
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
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		  		  
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
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		  		  
        try {			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarInformacionLaboral(informacionlaborals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		  		  
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
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionLaboral(informacionlaborals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
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
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		  		  
        try {
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionLaboral(informacionlaborals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
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
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionLaboral(informacionlaborals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
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
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionLaboral(informacionlaborals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		informacionlaboral = new  InformacionLaboral();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaboral=informacionlaboralDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionLaboral(informacionlaboral);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaboral);
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
		informacionlaboral = new  InformacionLaboral();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaboral=informacionlaboralDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionLaboral(informacionlaboral);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaboral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaborals=informacionlaboralDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionLaboral(informacionlaborals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
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
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		  		  
        try {
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaborals=informacionlaboralDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionLaboral(informacionlaborals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosInformacionLaboralsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getTodosInformacionLaboralsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarInformacionLaboral(informacionlaborals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
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
	
	public  void  getTodosInformacionLaborals(String sFinalQuery,Pagination pagination)throws Exception {
		informacionlaborals = new  ArrayList<InformacionLaboral>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarInformacionLaboral(informacionlaborals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarInformacionLaboral(InformacionLaboral informacionlaboral) throws Exception {
		Boolean estaValidado=false;
		
		if(informacionlaboral.getIsNew() || informacionlaboral.getIsChanged()) { 
			this.invalidValues = informacionlaboralValidator.getInvalidValues(informacionlaboral);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(informacionlaboral);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarInformacionLaboral(List<InformacionLaboral> InformacionLaborals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(InformacionLaboral informacionlaboralLocal:informacionlaborals) {				
			estaValidadoObjeto=this.validarGuardarInformacionLaboral(informacionlaboralLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarInformacionLaboral(List<InformacionLaboral> InformacionLaborals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarInformacionLaboral(informacionlaborals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarInformacionLaboral(InformacionLaboral InformacionLaboral) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarInformacionLaboral(informacionlaboral)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(InformacionLaboral informacionlaboral) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+informacionlaboral.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=InformacionLaboralConstantesFunciones.getInformacionLaboralLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"informacionlaboral","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(InformacionLaboralConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(InformacionLaboralConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveInformacionLaboralWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-saveInformacionLaboralWithConnection");connexion.begin();			
			
			InformacionLaboralLogicAdditional.checkInformacionLaboralToSave(this.informacionlaboral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			InformacionLaboralLogicAdditional.updateInformacionLaboralToSave(this.informacionlaboral,this.arrDatoGeneral);
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.informacionlaboral,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowInformacionLaboral();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarInformacionLaboral(this.informacionlaboral)) {
				InformacionLaboralDataAccess.save(this.informacionlaboral, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.informacionlaboral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			InformacionLaboralLogicAdditional.checkInformacionLaboralToSaveAfter(this.informacionlaboral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowInformacionLaboral();
			
			connexion.commit();			
			
			if(this.informacionlaboral.getIsDeleted()) {
				this.informacionlaboral=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveInformacionLaboral()throws Exception {	
		try {	
			
			InformacionLaboralLogicAdditional.checkInformacionLaboralToSave(this.informacionlaboral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			InformacionLaboralLogicAdditional.updateInformacionLaboralToSave(this.informacionlaboral,this.arrDatoGeneral);
			
			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.informacionlaboral,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarInformacionLaboral(this.informacionlaboral)) {			
				InformacionLaboralDataAccess.save(this.informacionlaboral, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.informacionlaboral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			InformacionLaboralLogicAdditional.checkInformacionLaboralToSaveAfter(this.informacionlaboral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.informacionlaboral.getIsDeleted()) {
				this.informacionlaboral=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveInformacionLaboralsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-saveInformacionLaboralsWithConnection");connexion.begin();			
			
			InformacionLaboralLogicAdditional.checkInformacionLaboralToSaves(informacionlaborals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowInformacionLaborals();
			
			Boolean validadoTodosInformacionLaboral=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(InformacionLaboral informacionlaboralLocal:informacionlaborals) {		
				if(informacionlaboralLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				InformacionLaboralLogicAdditional.updateInformacionLaboralToSave(informacionlaboralLocal,this.arrDatoGeneral);
	        	
				InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),informacionlaboralLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarInformacionLaboral(informacionlaboralLocal)) {
					InformacionLaboralDataAccess.save(informacionlaboralLocal, connexion);				
				} else {
					validadoTodosInformacionLaboral=false;
				}
			}
			
			if(!validadoTodosInformacionLaboral) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			InformacionLaboralLogicAdditional.checkInformacionLaboralToSavesAfter(informacionlaborals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowInformacionLaborals();
			
			connexion.commit();		
			
			this.quitarInformacionLaboralsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveInformacionLaborals()throws Exception {				
		 try {	
			InformacionLaboralLogicAdditional.checkInformacionLaboralToSaves(informacionlaborals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosInformacionLaboral=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(InformacionLaboral informacionlaboralLocal:informacionlaborals) {				
				if(informacionlaboralLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				InformacionLaboralLogicAdditional.updateInformacionLaboralToSave(informacionlaboralLocal,this.arrDatoGeneral);
	        	
				InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),informacionlaboralLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarInformacionLaboral(informacionlaboralLocal)) {				
					InformacionLaboralDataAccess.save(informacionlaboralLocal, connexion);				
				} else {
					validadoTodosInformacionLaboral=false;
				}
			}
			
			if(!validadoTodosInformacionLaboral) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			InformacionLaboralLogicAdditional.checkInformacionLaboralToSavesAfter(informacionlaborals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarInformacionLaboralsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public InformacionLaboralParameterReturnGeneral procesarAccionInformacionLaborals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<InformacionLaboral> informacionlaborals,InformacionLaboralParameterReturnGeneral informacionlaboralParameterGeneral)throws Exception {
		 try {	
			InformacionLaboralParameterReturnGeneral informacionlaboralReturnGeneral=new InformacionLaboralParameterReturnGeneral();
	
			InformacionLaboralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,informacionlaborals,informacionlaboralParameterGeneral,informacionlaboralReturnGeneral);
			
			return informacionlaboralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public InformacionLaboralParameterReturnGeneral procesarAccionInformacionLaboralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<InformacionLaboral> informacionlaborals,InformacionLaboralParameterReturnGeneral informacionlaboralParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-procesarAccionInformacionLaboralsWithConnection");connexion.begin();			
			
			InformacionLaboralParameterReturnGeneral informacionlaboralReturnGeneral=new InformacionLaboralParameterReturnGeneral();
	
			InformacionLaboralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,informacionlaborals,informacionlaboralParameterGeneral,informacionlaboralReturnGeneral);
			
			this.connexion.commit();
			
			return informacionlaboralReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public InformacionLaboralParameterReturnGeneral procesarEventosInformacionLaborals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<InformacionLaboral> informacionlaborals,InformacionLaboral informacionlaboral,InformacionLaboralParameterReturnGeneral informacionlaboralParameterGeneral,Boolean isEsNuevoInformacionLaboral,ArrayList<Classe> clases)throws Exception {
		 try {	
			InformacionLaboralParameterReturnGeneral informacionlaboralReturnGeneral=new InformacionLaboralParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				informacionlaboralReturnGeneral.setConRecargarPropiedades(true);
			}
			
			InformacionLaboralLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,informacionlaborals,informacionlaboral,informacionlaboralParameterGeneral,informacionlaboralReturnGeneral,isEsNuevoInformacionLaboral,clases);
			
			return informacionlaboralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public InformacionLaboralParameterReturnGeneral procesarEventosInformacionLaboralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<InformacionLaboral> informacionlaborals,InformacionLaboral informacionlaboral,InformacionLaboralParameterReturnGeneral informacionlaboralParameterGeneral,Boolean isEsNuevoInformacionLaboral,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-procesarEventosInformacionLaboralsWithConnection");connexion.begin();			
			
			InformacionLaboralParameterReturnGeneral informacionlaboralReturnGeneral=new InformacionLaboralParameterReturnGeneral();
	
			informacionlaboralReturnGeneral.setInformacionLaboral(informacionlaboral);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				informacionlaboralReturnGeneral.setConRecargarPropiedades(true);
			}
			
			InformacionLaboralLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,informacionlaborals,informacionlaboral,informacionlaboralParameterGeneral,informacionlaboralReturnGeneral,isEsNuevoInformacionLaboral,clases);
			
			this.connexion.commit();
			
			return informacionlaboralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public InformacionLaboralParameterReturnGeneral procesarImportacionInformacionLaboralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,InformacionLaboralParameterReturnGeneral informacionlaboralParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-procesarImportacionInformacionLaboralsWithConnection");connexion.begin();			
			
			InformacionLaboralParameterReturnGeneral informacionlaboralReturnGeneral=new InformacionLaboralParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.informacionlaborals=new ArrayList<InformacionLaboral>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.informacionlaboral=new InformacionLaboral();
				
				
				if(conColumnasBase) {this.informacionlaboral.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.informacionlaboral.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.informacionlaboral.settiempoa(Integer.parseInt(arrColumnas[iColumn++]));
				this.informacionlaboral.settiempom(Integer.parseInt(arrColumnas[iColumn++]));
				this.informacionlaboral.setnombreempresa(arrColumnas[iColumn++]);
			this.informacionlaboral.setdireccion(arrColumnas[iColumn++]);
			this.informacionlaboral.setnombrereferencia(arrColumnas[iColumn++]);
			this.informacionlaboral.settelefono(arrColumnas[iColumn++]);
				this.informacionlaboral.settelefonocodigoarea(arrColumnas[iColumn++]);
			this.informacionlaboral.settelefonomovil(arrColumnas[iColumn++]);
			this.informacionlaboral.setemail(arrColumnas[iColumn++]);
				this.informacionlaboral.setesactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.informacionlaborals.add(this.informacionlaboral);
			}
			
			this.saveInformacionLaborals();
			
			this.connexion.commit();
			
			informacionlaboralReturnGeneral.setConRetornoEstaProcesado(true);
			informacionlaboralReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return informacionlaboralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarInformacionLaboralsEliminados() throws Exception {				
		
		List<InformacionLaboral> informacionlaboralsAux= new ArrayList<InformacionLaboral>();
		
		for(InformacionLaboral informacionlaboral:informacionlaborals) {
			if(!informacionlaboral.getIsDeleted()) {
				informacionlaboralsAux.add(informacionlaboral);
			}
		}
		
		informacionlaborals=informacionlaboralsAux;
	}
	
	public void quitarInformacionLaboralsNulos() throws Exception {				
		
		List<InformacionLaboral> informacionlaboralsAux= new ArrayList<InformacionLaboral>();
		
		for(InformacionLaboral informacionlaboral : this.informacionlaborals) {
			if(informacionlaboral==null) {
				informacionlaboralsAux.add(informacionlaboral);
			}
		}
		
		//this.informacionlaborals=informacionlaboralsAux;
		
		this.informacionlaborals.removeAll(informacionlaboralsAux);
	}
	
	public void getSetVersionRowInformacionLaboralWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(informacionlaboral.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((informacionlaboral.getIsDeleted() || (informacionlaboral.getIsChanged()&&!informacionlaboral.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=informacionlaboralDataAccess.getSetVersionRowInformacionLaboral(connexion,informacionlaboral.getId());
				
				if(!informacionlaboral.getVersionRow().equals(timestamp)) {	
					informacionlaboral.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				informacionlaboral.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowInformacionLaboral()throws Exception {	
		
		if(informacionlaboral.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((informacionlaboral.getIsDeleted() || (informacionlaboral.getIsChanged()&&!informacionlaboral.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=informacionlaboralDataAccess.getSetVersionRowInformacionLaboral(connexion,informacionlaboral.getId());
			
			try {							
				if(!informacionlaboral.getVersionRow().equals(timestamp)) {	
					informacionlaboral.setVersionRow(timestamp);
				}
				
				informacionlaboral.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowInformacionLaboralsWithConnection()throws Exception {	
		if(informacionlaborals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(InformacionLaboral informacionlaboralAux:informacionlaborals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(informacionlaboralAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(informacionlaboralAux.getIsDeleted() || (informacionlaboralAux.getIsChanged()&&!informacionlaboralAux.getIsNew())) {
						
						timestamp=informacionlaboralDataAccess.getSetVersionRowInformacionLaboral(connexion,informacionlaboralAux.getId());
						
						if(!informacionlaboral.getVersionRow().equals(timestamp)) {	
							informacionlaboralAux.setVersionRow(timestamp);
						}
								
						informacionlaboralAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowInformacionLaborals()throws Exception {	
		if(informacionlaborals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(InformacionLaboral informacionlaboralAux:informacionlaborals) {
					if(informacionlaboralAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(informacionlaboralAux.getIsDeleted() || (informacionlaboralAux.getIsChanged()&&!informacionlaboralAux.getIsNew())) {
						
						timestamp=informacionlaboralDataAccess.getSetVersionRowInformacionLaboral(connexion,informacionlaboralAux.getId());
						
						if(!informacionlaboralAux.getVersionRow().equals(timestamp)) {	
							informacionlaboralAux.setVersionRow(timestamp);
						}
						
													
						informacionlaboralAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public InformacionLaboralParameterReturnGeneral cargarCombosLoteForeignKeyInformacionLaboralWithConnection(String finalQueryGlobalCliente,String finalQueryGlobalTipoEmpresa,String finalQueryGlobalTipoRelaLabo,String finalQueryGlobalTipoAreaLabo,String finalQueryGlobalTipoCargoLabo,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		InformacionLaboralParameterReturnGeneral  informacionlaboralReturnGeneral =new InformacionLaboralParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-cargarCombosLoteForeignKeyInformacionLaboralWithConnection");connexion.begin();
			
			informacionlaboralReturnGeneral =new InformacionLaboralParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			informacionlaboralReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoEmpresa> tipoempresasForeignKey=new ArrayList<TipoEmpresa>();
			TipoEmpresaLogic tipoempresaLogic=new TipoEmpresaLogic();
			tipoempresaLogic.setConnexion(this.connexion);
			tipoempresaLogic.getTipoEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEmpresa.equals("NONE")) {
				tipoempresaLogic.getTodosTipoEmpresas(finalQueryGlobalTipoEmpresa,new Pagination());
				tipoempresasForeignKey=tipoempresaLogic.getTipoEmpresas();
			}

			informacionlaboralReturnGeneral.settipoempresasForeignKey(tipoempresasForeignKey);


			List<TipoRelaLabo> tiporelalabosForeignKey=new ArrayList<TipoRelaLabo>();
			TipoRelaLaboLogic tiporelalaboLogic=new TipoRelaLaboLogic();
			tiporelalaboLogic.setConnexion(this.connexion);
			tiporelalaboLogic.getTipoRelaLaboDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRelaLabo.equals("NONE")) {
				tiporelalaboLogic.getTodosTipoRelaLabos(finalQueryGlobalTipoRelaLabo,new Pagination());
				tiporelalabosForeignKey=tiporelalaboLogic.getTipoRelaLabos();
			}

			informacionlaboralReturnGeneral.settiporelalabosForeignKey(tiporelalabosForeignKey);


			List<TipoAreaLabo> tipoarealabosForeignKey=new ArrayList<TipoAreaLabo>();
			TipoAreaLaboLogic tipoarealaboLogic=new TipoAreaLaboLogic();
			tipoarealaboLogic.setConnexion(this.connexion);
			tipoarealaboLogic.getTipoAreaLaboDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAreaLabo.equals("NONE")) {
				tipoarealaboLogic.getTodosTipoAreaLabos(finalQueryGlobalTipoAreaLabo,new Pagination());
				tipoarealabosForeignKey=tipoarealaboLogic.getTipoAreaLabos();
			}

			informacionlaboralReturnGeneral.settipoarealabosForeignKey(tipoarealabosForeignKey);


			List<TipoCargoLabo> tipocargolabosForeignKey=new ArrayList<TipoCargoLabo>();
			TipoCargoLaboLogic tipocargolaboLogic=new TipoCargoLaboLogic();
			tipocargolaboLogic.setConnexion(this.connexion);
			tipocargolaboLogic.getTipoCargoLaboDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCargoLabo.equals("NONE")) {
				tipocargolaboLogic.getTodosTipoCargoLabos(finalQueryGlobalTipoCargoLabo,new Pagination());
				tipocargolabosForeignKey=tipocargolaboLogic.getTipoCargoLabos();
			}

			informacionlaboralReturnGeneral.settipocargolabosForeignKey(tipocargolabosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			informacionlaboralReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			informacionlaboralReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return informacionlaboralReturnGeneral;
	}
	
	public InformacionLaboralParameterReturnGeneral cargarCombosLoteForeignKeyInformacionLaboral(String finalQueryGlobalCliente,String finalQueryGlobalTipoEmpresa,String finalQueryGlobalTipoRelaLabo,String finalQueryGlobalTipoAreaLabo,String finalQueryGlobalTipoCargoLabo,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		InformacionLaboralParameterReturnGeneral  informacionlaboralReturnGeneral =new InformacionLaboralParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			informacionlaboralReturnGeneral =new InformacionLaboralParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			informacionlaboralReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoEmpresa> tipoempresasForeignKey=new ArrayList<TipoEmpresa>();
			TipoEmpresaLogic tipoempresaLogic=new TipoEmpresaLogic();
			tipoempresaLogic.setConnexion(this.connexion);
			tipoempresaLogic.getTipoEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEmpresa.equals("NONE")) {
				tipoempresaLogic.getTodosTipoEmpresas(finalQueryGlobalTipoEmpresa,new Pagination());
				tipoempresasForeignKey=tipoempresaLogic.getTipoEmpresas();
			}

			informacionlaboralReturnGeneral.settipoempresasForeignKey(tipoempresasForeignKey);


			List<TipoRelaLabo> tiporelalabosForeignKey=new ArrayList<TipoRelaLabo>();
			TipoRelaLaboLogic tiporelalaboLogic=new TipoRelaLaboLogic();
			tiporelalaboLogic.setConnexion(this.connexion);
			tiporelalaboLogic.getTipoRelaLaboDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRelaLabo.equals("NONE")) {
				tiporelalaboLogic.getTodosTipoRelaLabos(finalQueryGlobalTipoRelaLabo,new Pagination());
				tiporelalabosForeignKey=tiporelalaboLogic.getTipoRelaLabos();
			}

			informacionlaboralReturnGeneral.settiporelalabosForeignKey(tiporelalabosForeignKey);


			List<TipoAreaLabo> tipoarealabosForeignKey=new ArrayList<TipoAreaLabo>();
			TipoAreaLaboLogic tipoarealaboLogic=new TipoAreaLaboLogic();
			tipoarealaboLogic.setConnexion(this.connexion);
			tipoarealaboLogic.getTipoAreaLaboDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAreaLabo.equals("NONE")) {
				tipoarealaboLogic.getTodosTipoAreaLabos(finalQueryGlobalTipoAreaLabo,new Pagination());
				tipoarealabosForeignKey=tipoarealaboLogic.getTipoAreaLabos();
			}

			informacionlaboralReturnGeneral.settipoarealabosForeignKey(tipoarealabosForeignKey);


			List<TipoCargoLabo> tipocargolabosForeignKey=new ArrayList<TipoCargoLabo>();
			TipoCargoLaboLogic tipocargolaboLogic=new TipoCargoLaboLogic();
			tipocargolaboLogic.setConnexion(this.connexion);
			tipocargolaboLogic.getTipoCargoLaboDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCargoLabo.equals("NONE")) {
				tipocargolaboLogic.getTodosTipoCargoLabos(finalQueryGlobalTipoCargoLabo,new Pagination());
				tipocargolabosForeignKey=tipocargolaboLogic.getTipoCargoLabos();
			}

			informacionlaboralReturnGeneral.settipocargolabosForeignKey(tipocargolabosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			informacionlaboralReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			informacionlaboralReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return informacionlaboralReturnGeneral;
	}
	
	
	public void deepLoad(InformacionLaboral informacionlaboral,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			InformacionLaboralLogicAdditional.updateInformacionLaboralToGet(informacionlaboral,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		informacionlaboral.setCliente(informacionlaboralDataAccess.getCliente(connexion,informacionlaboral));
		informacionlaboral.setTipoEmpresa(informacionlaboralDataAccess.getTipoEmpresa(connexion,informacionlaboral));
		informacionlaboral.setTipoRelaLabo(informacionlaboralDataAccess.getTipoRelaLabo(connexion,informacionlaboral));
		informacionlaboral.setTipoAreaLabo(informacionlaboralDataAccess.getTipoAreaLabo(connexion,informacionlaboral));
		informacionlaboral.setTipoCargoLabo(informacionlaboralDataAccess.getTipoCargoLabo(connexion,informacionlaboral));
		informacionlaboral.setPais(informacionlaboralDataAccess.getPais(connexion,informacionlaboral));
		informacionlaboral.setCiudad(informacionlaboralDataAccess.getCiudad(connexion,informacionlaboral));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				informacionlaboral.setCliente(informacionlaboralDataAccess.getCliente(connexion,informacionlaboral));
				continue;
			}

			if(clas.clas.equals(TipoEmpresa.class)) {
				informacionlaboral.setTipoEmpresa(informacionlaboralDataAccess.getTipoEmpresa(connexion,informacionlaboral));
				continue;
			}

			if(clas.clas.equals(TipoRelaLabo.class)) {
				informacionlaboral.setTipoRelaLabo(informacionlaboralDataAccess.getTipoRelaLabo(connexion,informacionlaboral));
				continue;
			}

			if(clas.clas.equals(TipoAreaLabo.class)) {
				informacionlaboral.setTipoAreaLabo(informacionlaboralDataAccess.getTipoAreaLabo(connexion,informacionlaboral));
				continue;
			}

			if(clas.clas.equals(TipoCargoLabo.class)) {
				informacionlaboral.setTipoCargoLabo(informacionlaboralDataAccess.getTipoCargoLabo(connexion,informacionlaboral));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				informacionlaboral.setPais(informacionlaboralDataAccess.getPais(connexion,informacionlaboral));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				informacionlaboral.setCiudad(informacionlaboralDataAccess.getCiudad(connexion,informacionlaboral));
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
			informacionlaboral.setCliente(informacionlaboralDataAccess.getCliente(connexion,informacionlaboral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setTipoEmpresa(informacionlaboralDataAccess.getTipoEmpresa(connexion,informacionlaboral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRelaLabo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setTipoRelaLabo(informacionlaboralDataAccess.getTipoRelaLabo(connexion,informacionlaboral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAreaLabo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setTipoAreaLabo(informacionlaboralDataAccess.getTipoAreaLabo(connexion,informacionlaboral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCargoLabo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setTipoCargoLabo(informacionlaboralDataAccess.getTipoCargoLabo(connexion,informacionlaboral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setPais(informacionlaboralDataAccess.getPais(connexion,informacionlaboral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setCiudad(informacionlaboralDataAccess.getCiudad(connexion,informacionlaboral));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		informacionlaboral.setCliente(informacionlaboralDataAccess.getCliente(connexion,informacionlaboral));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(informacionlaboral.getCliente(),isDeep,deepLoadType,clases);
				
		informacionlaboral.setTipoEmpresa(informacionlaboralDataAccess.getTipoEmpresa(connexion,informacionlaboral));
		TipoEmpresaLogic tipoempresaLogic= new TipoEmpresaLogic(connexion);
		tipoempresaLogic.deepLoad(informacionlaboral.getTipoEmpresa(),isDeep,deepLoadType,clases);
				
		informacionlaboral.setTipoRelaLabo(informacionlaboralDataAccess.getTipoRelaLabo(connexion,informacionlaboral));
		TipoRelaLaboLogic tiporelalaboLogic= new TipoRelaLaboLogic(connexion);
		tiporelalaboLogic.deepLoad(informacionlaboral.getTipoRelaLabo(),isDeep,deepLoadType,clases);
				
		informacionlaboral.setTipoAreaLabo(informacionlaboralDataAccess.getTipoAreaLabo(connexion,informacionlaboral));
		TipoAreaLaboLogic tipoarealaboLogic= new TipoAreaLaboLogic(connexion);
		tipoarealaboLogic.deepLoad(informacionlaboral.getTipoAreaLabo(),isDeep,deepLoadType,clases);
				
		informacionlaboral.setTipoCargoLabo(informacionlaboralDataAccess.getTipoCargoLabo(connexion,informacionlaboral));
		TipoCargoLaboLogic tipocargolaboLogic= new TipoCargoLaboLogic(connexion);
		tipocargolaboLogic.deepLoad(informacionlaboral.getTipoCargoLabo(),isDeep,deepLoadType,clases);
				
		informacionlaboral.setPais(informacionlaboralDataAccess.getPais(connexion,informacionlaboral));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(informacionlaboral.getPais(),isDeep,deepLoadType,clases);
				
		informacionlaboral.setCiudad(informacionlaboralDataAccess.getCiudad(connexion,informacionlaboral));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(informacionlaboral.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				informacionlaboral.setCliente(informacionlaboralDataAccess.getCliente(connexion,informacionlaboral));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(informacionlaboral.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEmpresa.class)) {
				informacionlaboral.setTipoEmpresa(informacionlaboralDataAccess.getTipoEmpresa(connexion,informacionlaboral));
				TipoEmpresaLogic tipoempresaLogic= new TipoEmpresaLogic(connexion);
				tipoempresaLogic.deepLoad(informacionlaboral.getTipoEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRelaLabo.class)) {
				informacionlaboral.setTipoRelaLabo(informacionlaboralDataAccess.getTipoRelaLabo(connexion,informacionlaboral));
				TipoRelaLaboLogic tiporelalaboLogic= new TipoRelaLaboLogic(connexion);
				tiporelalaboLogic.deepLoad(informacionlaboral.getTipoRelaLabo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAreaLabo.class)) {
				informacionlaboral.setTipoAreaLabo(informacionlaboralDataAccess.getTipoAreaLabo(connexion,informacionlaboral));
				TipoAreaLaboLogic tipoarealaboLogic= new TipoAreaLaboLogic(connexion);
				tipoarealaboLogic.deepLoad(informacionlaboral.getTipoAreaLabo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCargoLabo.class)) {
				informacionlaboral.setTipoCargoLabo(informacionlaboralDataAccess.getTipoCargoLabo(connexion,informacionlaboral));
				TipoCargoLaboLogic tipocargolaboLogic= new TipoCargoLaboLogic(connexion);
				tipocargolaboLogic.deepLoad(informacionlaboral.getTipoCargoLabo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				informacionlaboral.setPais(informacionlaboralDataAccess.getPais(connexion,informacionlaboral));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(informacionlaboral.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				informacionlaboral.setCiudad(informacionlaboralDataAccess.getCiudad(connexion,informacionlaboral));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(informacionlaboral.getCiudad(),isDeep,deepLoadType,clases);				
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
			informacionlaboral.setCliente(informacionlaboralDataAccess.getCliente(connexion,informacionlaboral));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(informacionlaboral.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setTipoEmpresa(informacionlaboralDataAccess.getTipoEmpresa(connexion,informacionlaboral));
			TipoEmpresaLogic tipoempresaLogic= new TipoEmpresaLogic(connexion);
			tipoempresaLogic.deepLoad(informacionlaboral.getTipoEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRelaLabo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setTipoRelaLabo(informacionlaboralDataAccess.getTipoRelaLabo(connexion,informacionlaboral));
			TipoRelaLaboLogic tiporelalaboLogic= new TipoRelaLaboLogic(connexion);
			tiporelalaboLogic.deepLoad(informacionlaboral.getTipoRelaLabo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAreaLabo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setTipoAreaLabo(informacionlaboralDataAccess.getTipoAreaLabo(connexion,informacionlaboral));
			TipoAreaLaboLogic tipoarealaboLogic= new TipoAreaLaboLogic(connexion);
			tipoarealaboLogic.deepLoad(informacionlaboral.getTipoAreaLabo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCargoLabo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setTipoCargoLabo(informacionlaboralDataAccess.getTipoCargoLabo(connexion,informacionlaboral));
			TipoCargoLaboLogic tipocargolaboLogic= new TipoCargoLaboLogic(connexion);
			tipocargolaboLogic.deepLoad(informacionlaboral.getTipoCargoLabo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setPais(informacionlaboralDataAccess.getPais(connexion,informacionlaboral));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(informacionlaboral.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionlaboral.setCiudad(informacionlaboralDataAccess.getCiudad(connexion,informacionlaboral));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(informacionlaboral.getCiudad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(InformacionLaboral informacionlaboral,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			InformacionLaboralLogicAdditional.updateInformacionLaboralToSave(informacionlaboral,this.arrDatoGeneral);
			
InformacionLaboralDataAccess.save(informacionlaboral, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(informacionlaboral.getCliente(),connexion);

		TipoEmpresaDataAccess.save(informacionlaboral.getTipoEmpresa(),connexion);

		TipoRelaLaboDataAccess.save(informacionlaboral.getTipoRelaLabo(),connexion);

		TipoAreaLaboDataAccess.save(informacionlaboral.getTipoAreaLabo(),connexion);

		TipoCargoLaboDataAccess.save(informacionlaboral.getTipoCargoLabo(),connexion);

		PaisDataAccess.save(informacionlaboral.getPais(),connexion);

		CiudadDataAccess.save(informacionlaboral.getCiudad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(informacionlaboral.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoEmpresa.class)) {
				TipoEmpresaDataAccess.save(informacionlaboral.getTipoEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRelaLabo.class)) {
				TipoRelaLaboDataAccess.save(informacionlaboral.getTipoRelaLabo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoAreaLabo.class)) {
				TipoAreaLaboDataAccess.save(informacionlaboral.getTipoAreaLabo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCargoLabo.class)) {
				TipoCargoLaboDataAccess.save(informacionlaboral.getTipoCargoLabo(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(informacionlaboral.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(informacionlaboral.getCiudad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(informacionlaboral.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(informacionlaboral.getCliente(),isDeep,deepLoadType,clases);
				

		TipoEmpresaDataAccess.save(informacionlaboral.getTipoEmpresa(),connexion);
		TipoEmpresaLogic tipoempresaLogic= new TipoEmpresaLogic(connexion);
		tipoempresaLogic.deepLoad(informacionlaboral.getTipoEmpresa(),isDeep,deepLoadType,clases);
				

		TipoRelaLaboDataAccess.save(informacionlaboral.getTipoRelaLabo(),connexion);
		TipoRelaLaboLogic tiporelalaboLogic= new TipoRelaLaboLogic(connexion);
		tiporelalaboLogic.deepLoad(informacionlaboral.getTipoRelaLabo(),isDeep,deepLoadType,clases);
				

		TipoAreaLaboDataAccess.save(informacionlaboral.getTipoAreaLabo(),connexion);
		TipoAreaLaboLogic tipoarealaboLogic= new TipoAreaLaboLogic(connexion);
		tipoarealaboLogic.deepLoad(informacionlaboral.getTipoAreaLabo(),isDeep,deepLoadType,clases);
				

		TipoCargoLaboDataAccess.save(informacionlaboral.getTipoCargoLabo(),connexion);
		TipoCargoLaboLogic tipocargolaboLogic= new TipoCargoLaboLogic(connexion);
		tipocargolaboLogic.deepLoad(informacionlaboral.getTipoCargoLabo(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(informacionlaboral.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(informacionlaboral.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(informacionlaboral.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(informacionlaboral.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(informacionlaboral.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(informacionlaboral.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEmpresa.class)) {
				TipoEmpresaDataAccess.save(informacionlaboral.getTipoEmpresa(),connexion);
				TipoEmpresaLogic tipoempresaLogic= new TipoEmpresaLogic(connexion);
				tipoempresaLogic.deepSave(informacionlaboral.getTipoEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRelaLabo.class)) {
				TipoRelaLaboDataAccess.save(informacionlaboral.getTipoRelaLabo(),connexion);
				TipoRelaLaboLogic tiporelalaboLogic= new TipoRelaLaboLogic(connexion);
				tiporelalaboLogic.deepSave(informacionlaboral.getTipoRelaLabo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAreaLabo.class)) {
				TipoAreaLaboDataAccess.save(informacionlaboral.getTipoAreaLabo(),connexion);
				TipoAreaLaboLogic tipoarealaboLogic= new TipoAreaLaboLogic(connexion);
				tipoarealaboLogic.deepSave(informacionlaboral.getTipoAreaLabo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCargoLabo.class)) {
				TipoCargoLaboDataAccess.save(informacionlaboral.getTipoCargoLabo(),connexion);
				TipoCargoLaboLogic tipocargolaboLogic= new TipoCargoLaboLogic(connexion);
				tipocargolaboLogic.deepSave(informacionlaboral.getTipoCargoLabo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(informacionlaboral.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(informacionlaboral.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(informacionlaboral.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(informacionlaboral.getCiudad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(InformacionLaboral.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(informacionlaboral);
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
			this.deepLoad(this.informacionlaboral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaboral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(InformacionLaboral.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(informacionlaborals!=null) {
				for(InformacionLaboral informacionlaboral:informacionlaborals) {
					this.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(informacionlaborals);
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
			if(informacionlaborals!=null) {
				for(InformacionLaboral informacionlaboral:informacionlaborals) {
					this.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(informacionlaborals);
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
			this.getNewConnexionToDeep(InformacionLaboral.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(informacionlaboral,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(InformacionLaboral.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(informacionlaborals!=null) {
				for(InformacionLaboral informacionlaboral:informacionlaborals) {
					this.deepSave(informacionlaboral,isDeep,deepLoadType,clases);
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
			if(informacionlaborals!=null) {
				for(InformacionLaboral informacionlaboral:informacionlaborals) {
					this.deepSave(informacionlaboral,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getInformacionLaboralsFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long idciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,idciudad,InformacionLaboralConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionLaboralsFK_IdCiudad(String sFinalQuery,Pagination pagination,Long idciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,idciudad,InformacionLaboralConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getInformacionLaboralsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,InformacionLaboralConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionLaboralsFK_IdCliente(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,InformacionLaboralConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getInformacionLaboralsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,InformacionLaboralConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionLaboralsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,InformacionLaboralConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getInformacionLaboralsFK_IdTipoEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long idvalorempresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorempresa,InformacionLaboralConstantesFunciones.IDTIPOEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEmpresa);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionLaboralsFK_IdTipoEmpresa(String sFinalQuery,Pagination pagination,Long idvalorempresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorempresa,InformacionLaboralConstantesFunciones.IDTIPOEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEmpresa);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getInformacionLaboralsFK_IdValorClienteAreaLaboralWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclientearealaboral)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAreaLabo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAreaLabo.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientearealaboral,InformacionLaboralConstantesFunciones.IDTIPOAREALABO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAreaLabo);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteAreaLaboral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionLaboralsFK_IdValorClienteAreaLaboral(String sFinalQuery,Pagination pagination,Long idvalorclientearealaboral)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAreaLabo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAreaLabo.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientearealaboral,InformacionLaboralConstantesFunciones.IDTIPOAREALABO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAreaLabo);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteAreaLaboral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getInformacionLaboralsFK_IdValorClienteCargoLaboralWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclientecargolaboral)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCargoLabo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCargoLabo.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientecargolaboral,InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCargoLabo);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteCargoLaboral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionLaboralsFK_IdValorClienteCargoLaboral(String sFinalQuery,Pagination pagination,Long idvalorclientecargolaboral)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCargoLabo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCargoLabo.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientecargolaboral,InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCargoLabo);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteCargoLaboral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getInformacionLaboralsFK_IdValorClienteRelacionLaboralWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclienterelacionlaboral)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionLaboral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRelaLabo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRelaLabo.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclienterelacionlaboral,InformacionLaboralConstantesFunciones.IDTIPORELALABO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRelaLabo);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteRelacionLaboral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionLaboralsFK_IdValorClienteRelacionLaboral(String sFinalQuery,Pagination pagination,Long idvalorclienterelacionlaboral)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRelaLabo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRelaLabo.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclienterelacionlaboral,InformacionLaboralConstantesFunciones.IDTIPORELALABO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRelaLabo);

			InformacionLaboralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteRelacionLaboral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(this.informacionlaborals);
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
			if(InformacionLaboralConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionLaboralDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,InformacionLaboral informacionlaboral,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(InformacionLaboralConstantesFunciones.ISCONAUDITORIA) {
				if(informacionlaboral.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionLaboralDataAccess.TABLENAME, informacionlaboral.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(InformacionLaboralConstantesFunciones.ISCONAUDITORIADETALLE) {
						////InformacionLaboralLogic.registrarAuditoriaDetallesInformacionLaboral(connexion,informacionlaboral,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(informacionlaboral.getIsDeleted()) {
					/*if(!informacionlaboral.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,InformacionLaboralDataAccess.TABLENAME, informacionlaboral.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////InformacionLaboralLogic.registrarAuditoriaDetallesInformacionLaboral(connexion,informacionlaboral,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionLaboralDataAccess.TABLENAME, informacionlaboral.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(informacionlaboral.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionLaboralDataAccess.TABLENAME, informacionlaboral.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(InformacionLaboralConstantesFunciones.ISCONAUDITORIADETALLE) {
						////InformacionLaboralLogic.registrarAuditoriaDetallesInformacionLaboral(connexion,informacionlaboral,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesInformacionLaboral(Connexion connexion,InformacionLaboral informacionlaboral)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getidcliente().equals(informacionlaboral.getInformacionLaboralOriginal().getidcliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getidcliente()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getidcliente().toString();
				}
				if(informacionlaboral.getidcliente()!=null)
				{
					strValorNuevo=informacionlaboral.getidcliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getidvalorempresa().equals(informacionlaboral.getInformacionLaboralOriginal().getidvalorempresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getidvalorempresa()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getidvalorempresa().toString();
				}
				if(informacionlaboral.getidvalorempresa()!=null)
				{
					strValorNuevo=informacionlaboral.getidvalorempresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.IDTIPOEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getidvalorclienterelacionlaboral().equals(informacionlaboral.getInformacionLaboralOriginal().getidvalorclienterelacionlaboral()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getidvalorclienterelacionlaboral()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getidvalorclienterelacionlaboral().toString();
				}
				if(informacionlaboral.getidvalorclienterelacionlaboral()!=null)
				{
					strValorNuevo=informacionlaboral.getidvalorclienterelacionlaboral().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.IDTIPORELALABO,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getidvalorclientearealaboral().equals(informacionlaboral.getInformacionLaboralOriginal().getidvalorclientearealaboral()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getidvalorclientearealaboral()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getidvalorclientearealaboral().toString();
				}
				if(informacionlaboral.getidvalorclientearealaboral()!=null)
				{
					strValorNuevo=informacionlaboral.getidvalorclientearealaboral().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.IDTIPOAREALABO,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getidvalorclientecargolaboral().equals(informacionlaboral.getInformacionLaboralOriginal().getidvalorclientecargolaboral()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getidvalorclientecargolaboral()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getidvalorclientecargolaboral().toString();
				}
				if(informacionlaboral.getidvalorclientecargolaboral()!=null)
				{
					strValorNuevo=informacionlaboral.getidvalorclientecargolaboral().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getid_pais().equals(informacionlaboral.getInformacionLaboralOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getid_pais()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getid_pais().toString();
				}
				if(informacionlaboral.getid_pais()!=null)
				{
					strValorNuevo=informacionlaboral.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getidciudad().equals(informacionlaboral.getInformacionLaboralOriginal().getidciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getidciudad()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getidciudad().toString();
				}
				if(informacionlaboral.getidciudad()!=null)
				{
					strValorNuevo=informacionlaboral.getidciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.gettiempoa().equals(informacionlaboral.getInformacionLaboralOriginal().gettiempoa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().gettiempoa()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().gettiempoa().toString();
				}
				if(informacionlaboral.gettiempoa()!=null)
				{
					strValorNuevo=informacionlaboral.gettiempoa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.TIEMPOA,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.gettiempom().equals(informacionlaboral.getInformacionLaboralOriginal().gettiempom()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().gettiempom()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().gettiempom().toString();
				}
				if(informacionlaboral.gettiempom()!=null)
				{
					strValorNuevo=informacionlaboral.gettiempom().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.TIEMPOM,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getnombreempresa().equals(informacionlaboral.getInformacionLaboralOriginal().getnombreempresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getnombreempresa()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getnombreempresa();
				}
				if(informacionlaboral.getnombreempresa()!=null)
				{
					strValorNuevo=informacionlaboral.getnombreempresa() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.NOMBREEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getdireccion().equals(informacionlaboral.getInformacionLaboralOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getdireccion()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getdireccion();
				}
				if(informacionlaboral.getdireccion()!=null)
				{
					strValorNuevo=informacionlaboral.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getnombrereferencia().equals(informacionlaboral.getInformacionLaboralOriginal().getnombrereferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getnombrereferencia()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getnombrereferencia();
				}
				if(informacionlaboral.getnombrereferencia()!=null)
				{
					strValorNuevo=informacionlaboral.getnombrereferencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.NOMBREREFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.gettelefono().equals(informacionlaboral.getInformacionLaboralOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().gettelefono()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().gettelefono();
				}
				if(informacionlaboral.gettelefono()!=null)
				{
					strValorNuevo=informacionlaboral.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.gettelefonocodigoarea().equals(informacionlaboral.getInformacionLaboralOriginal().gettelefonocodigoarea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().gettelefonocodigoarea()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().gettelefonocodigoarea();
				}
				if(informacionlaboral.gettelefonocodigoarea()!=null)
				{
					strValorNuevo=informacionlaboral.gettelefonocodigoarea() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.TELEFONOCODIGOAREA,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.gettelefonomovil().equals(informacionlaboral.getInformacionLaboralOriginal().gettelefonomovil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().gettelefonomovil()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().gettelefonomovil();
				}
				if(informacionlaboral.gettelefonomovil()!=null)
				{
					strValorNuevo=informacionlaboral.gettelefonomovil() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.TELEFONOMOVIL,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getemail().equals(informacionlaboral.getInformacionLaboralOriginal().getemail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getemail()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getemail();
				}
				if(informacionlaboral.getemail()!=null)
				{
					strValorNuevo=informacionlaboral.getemail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.EMAIL,strValorActual,strValorNuevo);
			}	
			
			if(informacionlaboral.getIsNew()||!informacionlaboral.getesactivo().equals(informacionlaboral.getInformacionLaboralOriginal().getesactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionlaboral.getInformacionLaboralOriginal().getesactivo()!=null)
				{
					strValorActual=informacionlaboral.getInformacionLaboralOriginal().getesactivo().toString();
				}
				if(informacionlaboral.getesactivo()!=null)
				{
					strValorNuevo=informacionlaboral.getesactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionLaboralConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveInformacionLaboralRelacionesWithConnection(InformacionLaboral informacionlaboral) throws Exception {

		if(!informacionlaboral.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveInformacionLaboralRelacionesBase(informacionlaboral,true);
		}
	}

	public void saveInformacionLaboralRelaciones(InformacionLaboral informacionlaboral)throws Exception {

		if(!informacionlaboral.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveInformacionLaboralRelacionesBase(informacionlaboral,false);
		}
	}

	public void saveInformacionLaboralRelacionesBase(InformacionLaboral informacionlaboral,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("InformacionLaboral-saveRelacionesWithConnection");}
	

			this.setInformacionLaboral(informacionlaboral);

			if(InformacionLaboralLogicAdditional.validarSaveRelaciones(informacionlaboral,this)) {

				InformacionLaboralLogicAdditional.updateRelacionesToSave(informacionlaboral,this);

				if((informacionlaboral.getIsNew()||informacionlaboral.getIsChanged())&&!informacionlaboral.getIsDeleted()) {
					this.saveInformacionLaboral();
					this.saveInformacionLaboralRelacionesDetalles();

				} else if(informacionlaboral.getIsDeleted()) {
					this.saveInformacionLaboralRelacionesDetalles();
					this.saveInformacionLaboral();
				}

				InformacionLaboralLogicAdditional.updateRelacionesToSaveAfter(informacionlaboral,this);

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
	
	
	private void saveInformacionLaboralRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfInformacionLaboral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=InformacionLaboralConstantesFunciones.getClassesForeignKeysOfInformacionLaboral(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformacionLaboral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=InformacionLaboralConstantesFunciones.getClassesRelationshipsOfInformacionLaboral(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

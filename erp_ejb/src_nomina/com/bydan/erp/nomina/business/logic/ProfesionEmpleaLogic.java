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
import com.bydan.erp.nomina.util.ProfesionEmpleaConstantesFunciones;
import com.bydan.erp.nomina.util.ProfesionEmpleaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ProfesionEmpleaParameterGeneral;
import com.bydan.erp.nomina.business.entity.ProfesionEmplea;
import com.bydan.erp.nomina.business.logic.ProfesionEmpleaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProfesionEmpleaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProfesionEmpleaLogic.class);
	
	protected ProfesionEmpleaDataAccess profesionempleaDataAccess; 	
	protected ProfesionEmplea profesionemplea;
	protected List<ProfesionEmplea> profesionempleas;
	protected Object profesionempleaObject;	
	protected List<Object> profesionempleasObject;
	
	public static ClassValidator<ProfesionEmplea> profesionempleaValidator = new ClassValidator<ProfesionEmplea>(ProfesionEmplea.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProfesionEmpleaLogicAdditional profesionempleaLogicAdditional=null;
	
	public ProfesionEmpleaLogicAdditional getProfesionEmpleaLogicAdditional() {
		return this.profesionempleaLogicAdditional;
	}
	
	public void setProfesionEmpleaLogicAdditional(ProfesionEmpleaLogicAdditional profesionempleaLogicAdditional) {
		try {
			this.profesionempleaLogicAdditional=profesionempleaLogicAdditional;
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
	
	
	
	
	public  ProfesionEmpleaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.profesionempleaDataAccess = new ProfesionEmpleaDataAccess();
			
			this.profesionempleas= new ArrayList<ProfesionEmplea>();
			this.profesionemplea= new ProfesionEmplea();
			
			this.profesionempleaObject=new Object();
			this.profesionempleasObject=new ArrayList<Object>();
				
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
			
			this.profesionempleaDataAccess.setConnexionType(this.connexionType);
			this.profesionempleaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProfesionEmpleaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.profesionempleaDataAccess = new ProfesionEmpleaDataAccess();
			this.profesionempleas= new ArrayList<ProfesionEmplea>();
			this.profesionemplea= new ProfesionEmplea();
			this.profesionempleaObject=new Object();
			this.profesionempleasObject=new ArrayList<Object>();
			
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
			
			this.profesionempleaDataAccess.setConnexionType(this.connexionType);
			this.profesionempleaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProfesionEmplea getProfesionEmplea() throws Exception {	
		ProfesionEmpleaLogicAdditional.checkProfesionEmpleaToGet(profesionemplea,this.datosCliente,this.arrDatoGeneral);
		ProfesionEmpleaLogicAdditional.updateProfesionEmpleaToGet(profesionemplea,this.arrDatoGeneral);
		
		return profesionemplea;
	}
		
	public void setProfesionEmplea(ProfesionEmplea newProfesionEmplea) {
		this.profesionemplea = newProfesionEmplea;
	}
	
	public ProfesionEmpleaDataAccess getProfesionEmpleaDataAccess() {
		return profesionempleaDataAccess;
	}
	
	public void setProfesionEmpleaDataAccess(ProfesionEmpleaDataAccess newprofesionempleaDataAccess) {
		this.profesionempleaDataAccess = newprofesionempleaDataAccess;
	}
	
	public List<ProfesionEmplea> getProfesionEmpleas() throws Exception {		
		this.quitarProfesionEmpleasNulos();
		
		ProfesionEmpleaLogicAdditional.checkProfesionEmpleaToGets(profesionempleas,this.datosCliente,this.arrDatoGeneral);
		
		for (ProfesionEmplea profesionempleaLocal: profesionempleas ) {
			ProfesionEmpleaLogicAdditional.updateProfesionEmpleaToGet(profesionempleaLocal,this.arrDatoGeneral);
		}
		
		return profesionempleas;
	}
	
	public void setProfesionEmpleas(List<ProfesionEmplea> newProfesionEmpleas) {
		this.profesionempleas = newProfesionEmpleas;
	}
	
	public Object getProfesionEmpleaObject() {	
		this.profesionempleaObject=this.profesionempleaDataAccess.getEntityObject();
		return this.profesionempleaObject;
	}
		
	public void setProfesionEmpleaObject(Object newProfesionEmpleaObject) {
		this.profesionempleaObject = newProfesionEmpleaObject;
	}
	
	public List<Object> getProfesionEmpleasObject() {		
		this.profesionempleasObject=this.profesionempleaDataAccess.getEntitiesObject();
		return this.profesionempleasObject;
	}
		
	public void setProfesionEmpleasObject(List<Object> newProfesionEmpleasObject) {
		this.profesionempleasObject = newProfesionEmpleasObject;
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
		
		if(this.profesionempleaDataAccess!=null) {
			this.profesionempleaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			profesionempleaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			profesionempleaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		profesionemplea = new  ProfesionEmplea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			profesionemplea=profesionempleaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.profesionemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionemplea);
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
		profesionemplea = new  ProfesionEmplea();
		  		  
        try {
			
			profesionemplea=profesionempleaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.profesionemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		profesionemplea = new  ProfesionEmplea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			profesionemplea=profesionempleaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.profesionemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionemplea);
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
		profesionemplea = new  ProfesionEmplea();
		  		  
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
		profesionemplea = new  ProfesionEmplea();
		  		  
        try {
			
			profesionemplea=profesionempleaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.profesionemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		profesionemplea = new  ProfesionEmplea();
		  		  
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
		profesionemplea = new  ProfesionEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =profesionempleaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		profesionemplea = new  ProfesionEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=profesionempleaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		profesionemplea = new  ProfesionEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =profesionempleaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		profesionemplea = new  ProfesionEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=profesionempleaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		profesionemplea = new  ProfesionEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =profesionempleaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		profesionemplea = new  ProfesionEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=profesionempleaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionempleas=profesionempleaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProfesionEmplea(profesionempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
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
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		  		  
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
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		  		  
        try {			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionempleas=profesionempleaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProfesionEmplea(profesionempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		  		  
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
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionempleas=profesionempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProfesionEmplea(profesionempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
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
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		  		  
        try {
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionempleas=profesionempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProfesionEmplea(profesionempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
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
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionempleas=profesionempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProfesionEmplea(profesionempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
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
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionempleas=profesionempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProfesionEmplea(profesionempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		profesionemplea = new  ProfesionEmplea();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionemplea=profesionempleaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProfesionEmplea(profesionemplea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionemplea);
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
		profesionemplea = new  ProfesionEmplea();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionemplea=profesionempleaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProfesionEmplea(profesionemplea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionempleas=profesionempleaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProfesionEmplea(profesionempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
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
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		  		  
        try {
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionempleas=profesionempleaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProfesionEmplea(profesionempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProfesionEmpleasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getTodosProfesionEmpleasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionempleas=profesionempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProfesionEmplea(profesionempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
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
	
	public  void  getTodosProfesionEmpleas(String sFinalQuery,Pagination pagination)throws Exception {
		profesionempleas = new  ArrayList<ProfesionEmplea>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesionempleas=profesionempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProfesionEmplea(profesionempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProfesionEmplea(ProfesionEmplea profesionemplea) throws Exception {
		Boolean estaValidado=false;
		
		if(profesionemplea.getIsNew() || profesionemplea.getIsChanged()) { 
			this.invalidValues = profesionempleaValidator.getInvalidValues(profesionemplea);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(profesionemplea);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProfesionEmplea(List<ProfesionEmplea> ProfesionEmpleas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProfesionEmplea profesionempleaLocal:profesionempleas) {				
			estaValidadoObjeto=this.validarGuardarProfesionEmplea(profesionempleaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProfesionEmplea(List<ProfesionEmplea> ProfesionEmpleas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProfesionEmplea(profesionempleas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProfesionEmplea(ProfesionEmplea ProfesionEmplea) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProfesionEmplea(profesionemplea)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProfesionEmplea profesionemplea) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+profesionemplea.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProfesionEmpleaConstantesFunciones.getProfesionEmpleaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"profesionemplea","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProfesionEmpleaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProfesionEmpleaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProfesionEmpleaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-saveProfesionEmpleaWithConnection");connexion.begin();			
			
			ProfesionEmpleaLogicAdditional.checkProfesionEmpleaToSave(this.profesionemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProfesionEmpleaLogicAdditional.updateProfesionEmpleaToSave(this.profesionemplea,this.arrDatoGeneral);
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.profesionemplea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProfesionEmplea();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProfesionEmplea(this.profesionemplea)) {
				ProfesionEmpleaDataAccess.save(this.profesionemplea, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.profesionemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProfesionEmpleaLogicAdditional.checkProfesionEmpleaToSaveAfter(this.profesionemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProfesionEmplea();
			
			connexion.commit();			
			
			if(this.profesionemplea.getIsDeleted()) {
				this.profesionemplea=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProfesionEmplea()throws Exception {	
		try {	
			
			ProfesionEmpleaLogicAdditional.checkProfesionEmpleaToSave(this.profesionemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProfesionEmpleaLogicAdditional.updateProfesionEmpleaToSave(this.profesionemplea,this.arrDatoGeneral);
			
			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.profesionemplea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProfesionEmplea(this.profesionemplea)) {			
				ProfesionEmpleaDataAccess.save(this.profesionemplea, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.profesionemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProfesionEmpleaLogicAdditional.checkProfesionEmpleaToSaveAfter(this.profesionemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.profesionemplea.getIsDeleted()) {
				this.profesionemplea=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProfesionEmpleasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-saveProfesionEmpleasWithConnection");connexion.begin();			
			
			ProfesionEmpleaLogicAdditional.checkProfesionEmpleaToSaves(profesionempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProfesionEmpleas();
			
			Boolean validadoTodosProfesionEmplea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProfesionEmplea profesionempleaLocal:profesionempleas) {		
				if(profesionempleaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProfesionEmpleaLogicAdditional.updateProfesionEmpleaToSave(profesionempleaLocal,this.arrDatoGeneral);
	        	
				ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),profesionempleaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProfesionEmplea(profesionempleaLocal)) {
					ProfesionEmpleaDataAccess.save(profesionempleaLocal, connexion);				
				} else {
					validadoTodosProfesionEmplea=false;
				}
			}
			
			if(!validadoTodosProfesionEmplea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProfesionEmpleaLogicAdditional.checkProfesionEmpleaToSavesAfter(profesionempleas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProfesionEmpleas();
			
			connexion.commit();		
			
			this.quitarProfesionEmpleasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProfesionEmpleas()throws Exception {				
		 try {	
			ProfesionEmpleaLogicAdditional.checkProfesionEmpleaToSaves(profesionempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProfesionEmplea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProfesionEmplea profesionempleaLocal:profesionempleas) {				
				if(profesionempleaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProfesionEmpleaLogicAdditional.updateProfesionEmpleaToSave(profesionempleaLocal,this.arrDatoGeneral);
	        	
				ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),profesionempleaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProfesionEmplea(profesionempleaLocal)) {				
					ProfesionEmpleaDataAccess.save(profesionempleaLocal, connexion);				
				} else {
					validadoTodosProfesionEmplea=false;
				}
			}
			
			if(!validadoTodosProfesionEmplea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProfesionEmpleaLogicAdditional.checkProfesionEmpleaToSavesAfter(profesionempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProfesionEmpleasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProfesionEmpleaParameterReturnGeneral procesarAccionProfesionEmpleas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProfesionEmplea> profesionempleas,ProfesionEmpleaParameterReturnGeneral profesionempleaParameterGeneral)throws Exception {
		 try {	
			ProfesionEmpleaParameterReturnGeneral profesionempleaReturnGeneral=new ProfesionEmpleaParameterReturnGeneral();
	
			ProfesionEmpleaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,profesionempleas,profesionempleaParameterGeneral,profesionempleaReturnGeneral);
			
			return profesionempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProfesionEmpleaParameterReturnGeneral procesarAccionProfesionEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProfesionEmplea> profesionempleas,ProfesionEmpleaParameterReturnGeneral profesionempleaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-procesarAccionProfesionEmpleasWithConnection");connexion.begin();			
			
			ProfesionEmpleaParameterReturnGeneral profesionempleaReturnGeneral=new ProfesionEmpleaParameterReturnGeneral();
	
			ProfesionEmpleaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,profesionempleas,profesionempleaParameterGeneral,profesionempleaReturnGeneral);
			
			this.connexion.commit();
			
			return profesionempleaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProfesionEmpleaParameterReturnGeneral procesarEventosProfesionEmpleas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProfesionEmplea> profesionempleas,ProfesionEmplea profesionemplea,ProfesionEmpleaParameterReturnGeneral profesionempleaParameterGeneral,Boolean isEsNuevoProfesionEmplea,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProfesionEmpleaParameterReturnGeneral profesionempleaReturnGeneral=new ProfesionEmpleaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				profesionempleaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProfesionEmpleaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,profesionempleas,profesionemplea,profesionempleaParameterGeneral,profesionempleaReturnGeneral,isEsNuevoProfesionEmplea,clases);
			
			return profesionempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProfesionEmpleaParameterReturnGeneral procesarEventosProfesionEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProfesionEmplea> profesionempleas,ProfesionEmplea profesionemplea,ProfesionEmpleaParameterReturnGeneral profesionempleaParameterGeneral,Boolean isEsNuevoProfesionEmplea,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-procesarEventosProfesionEmpleasWithConnection");connexion.begin();			
			
			ProfesionEmpleaParameterReturnGeneral profesionempleaReturnGeneral=new ProfesionEmpleaParameterReturnGeneral();
	
			profesionempleaReturnGeneral.setProfesionEmplea(profesionemplea);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				profesionempleaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProfesionEmpleaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,profesionempleas,profesionemplea,profesionempleaParameterGeneral,profesionempleaReturnGeneral,isEsNuevoProfesionEmplea,clases);
			
			this.connexion.commit();
			
			return profesionempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProfesionEmpleaParameterReturnGeneral procesarImportacionProfesionEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProfesionEmpleaParameterReturnGeneral profesionempleaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-procesarImportacionProfesionEmpleasWithConnection");connexion.begin();			
			
			ProfesionEmpleaParameterReturnGeneral profesionempleaReturnGeneral=new ProfesionEmpleaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.profesionempleas=new ArrayList<ProfesionEmplea>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.profesionemplea=new ProfesionEmplea();
				
				
				if(conColumnasBase) {this.profesionemplea.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.profesionemplea.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.profesionempleas.add(this.profesionemplea);
			}
			
			this.saveProfesionEmpleas();
			
			this.connexion.commit();
			
			profesionempleaReturnGeneral.setConRetornoEstaProcesado(true);
			profesionempleaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return profesionempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProfesionEmpleasEliminados() throws Exception {				
		
		List<ProfesionEmplea> profesionempleasAux= new ArrayList<ProfesionEmplea>();
		
		for(ProfesionEmplea profesionemplea:profesionempleas) {
			if(!profesionemplea.getIsDeleted()) {
				profesionempleasAux.add(profesionemplea);
			}
		}
		
		profesionempleas=profesionempleasAux;
	}
	
	public void quitarProfesionEmpleasNulos() throws Exception {				
		
		List<ProfesionEmplea> profesionempleasAux= new ArrayList<ProfesionEmplea>();
		
		for(ProfesionEmplea profesionemplea : this.profesionempleas) {
			if(profesionemplea==null) {
				profesionempleasAux.add(profesionemplea);
			}
		}
		
		//this.profesionempleas=profesionempleasAux;
		
		this.profesionempleas.removeAll(profesionempleasAux);
	}
	
	public void getSetVersionRowProfesionEmpleaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(profesionemplea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((profesionemplea.getIsDeleted() || (profesionemplea.getIsChanged()&&!profesionemplea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=profesionempleaDataAccess.getSetVersionRowProfesionEmplea(connexion,profesionemplea.getId());
				
				if(!profesionemplea.getVersionRow().equals(timestamp)) {	
					profesionemplea.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				profesionemplea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProfesionEmplea()throws Exception {	
		
		if(profesionemplea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((profesionemplea.getIsDeleted() || (profesionemplea.getIsChanged()&&!profesionemplea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=profesionempleaDataAccess.getSetVersionRowProfesionEmplea(connexion,profesionemplea.getId());
			
			try {							
				if(!profesionemplea.getVersionRow().equals(timestamp)) {	
					profesionemplea.setVersionRow(timestamp);
				}
				
				profesionemplea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProfesionEmpleasWithConnection()throws Exception {	
		if(profesionempleas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProfesionEmplea profesionempleaAux:profesionempleas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(profesionempleaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(profesionempleaAux.getIsDeleted() || (profesionempleaAux.getIsChanged()&&!profesionempleaAux.getIsNew())) {
						
						timestamp=profesionempleaDataAccess.getSetVersionRowProfesionEmplea(connexion,profesionempleaAux.getId());
						
						if(!profesionemplea.getVersionRow().equals(timestamp)) {	
							profesionempleaAux.setVersionRow(timestamp);
						}
								
						profesionempleaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProfesionEmpleas()throws Exception {	
		if(profesionempleas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProfesionEmplea profesionempleaAux:profesionempleas) {
					if(profesionempleaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(profesionempleaAux.getIsDeleted() || (profesionempleaAux.getIsChanged()&&!profesionempleaAux.getIsNew())) {
						
						timestamp=profesionempleaDataAccess.getSetVersionRowProfesionEmplea(connexion,profesionempleaAux.getId());
						
						if(!profesionempleaAux.getVersionRow().equals(timestamp)) {	
							profesionempleaAux.setVersionRow(timestamp);
						}
						
													
						profesionempleaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProfesionEmpleaParameterReturnGeneral cargarCombosLoteForeignKeyProfesionEmpleaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalProfesion) throws Exception {
		ProfesionEmpleaParameterReturnGeneral  profesionempleaReturnGeneral =new ProfesionEmpleaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-cargarCombosLoteForeignKeyProfesionEmpleaWithConnection");connexion.begin();
			
			profesionempleaReturnGeneral =new ProfesionEmpleaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			profesionempleaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			profesionempleaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Profesion> profesionsForeignKey=new ArrayList<Profesion>();
			ProfesionLogic profesionLogic=new ProfesionLogic();
			profesionLogic.setConnexion(this.connexion);
			profesionLogic.getProfesionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProfesion.equals("NONE")) {
				profesionLogic.getTodosProfesions(finalQueryGlobalProfesion,new Pagination());
				profesionsForeignKey=profesionLogic.getProfesions();
			}

			profesionempleaReturnGeneral.setprofesionsForeignKey(profesionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return profesionempleaReturnGeneral;
	}
	
	public ProfesionEmpleaParameterReturnGeneral cargarCombosLoteForeignKeyProfesionEmplea(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalProfesion) throws Exception {
		ProfesionEmpleaParameterReturnGeneral  profesionempleaReturnGeneral =new ProfesionEmpleaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			profesionempleaReturnGeneral =new ProfesionEmpleaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			profesionempleaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			profesionempleaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Profesion> profesionsForeignKey=new ArrayList<Profesion>();
			ProfesionLogic profesionLogic=new ProfesionLogic();
			profesionLogic.setConnexion(this.connexion);
			profesionLogic.getProfesionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProfesion.equals("NONE")) {
				profesionLogic.getTodosProfesions(finalQueryGlobalProfesion,new Pagination());
				profesionsForeignKey=profesionLogic.getProfesions();
			}

			profesionempleaReturnGeneral.setprofesionsForeignKey(profesionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return profesionempleaReturnGeneral;
	}
	
	
	public void deepLoad(ProfesionEmplea profesionemplea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProfesionEmpleaLogicAdditional.updateProfesionEmpleaToGet(profesionemplea,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		profesionemplea.setEmpresa(profesionempleaDataAccess.getEmpresa(connexion,profesionemplea));
		profesionemplea.setEmpleado(profesionempleaDataAccess.getEmpleado(connexion,profesionemplea));
		profesionemplea.setProfesion(profesionempleaDataAccess.getProfesion(connexion,profesionemplea));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				profesionemplea.setEmpresa(profesionempleaDataAccess.getEmpresa(connexion,profesionemplea));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				profesionemplea.setEmpleado(profesionempleaDataAccess.getEmpleado(connexion,profesionemplea));
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				profesionemplea.setProfesion(profesionempleaDataAccess.getProfesion(connexion,profesionemplea));
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
			profesionemplea.setEmpresa(profesionempleaDataAccess.getEmpresa(connexion,profesionemplea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			profesionemplea.setEmpleado(profesionempleaDataAccess.getEmpleado(connexion,profesionemplea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Profesion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			profesionemplea.setProfesion(profesionempleaDataAccess.getProfesion(connexion,profesionemplea));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		profesionemplea.setEmpresa(profesionempleaDataAccess.getEmpresa(connexion,profesionemplea));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(profesionemplea.getEmpresa(),isDeep,deepLoadType,clases);
				
		profesionemplea.setEmpleado(profesionempleaDataAccess.getEmpleado(connexion,profesionemplea));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(profesionemplea.getEmpleado(),isDeep,deepLoadType,clases);
				
		profesionemplea.setProfesion(profesionempleaDataAccess.getProfesion(connexion,profesionemplea));
		ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
		profesionLogic.deepLoad(profesionemplea.getProfesion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				profesionemplea.setEmpresa(profesionempleaDataAccess.getEmpresa(connexion,profesionemplea));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(profesionemplea.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				profesionemplea.setEmpleado(profesionempleaDataAccess.getEmpleado(connexion,profesionemplea));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(profesionemplea.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				profesionemplea.setProfesion(profesionempleaDataAccess.getProfesion(connexion,profesionemplea));
				ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
				profesionLogic.deepLoad(profesionemplea.getProfesion(),isDeep,deepLoadType,clases);				
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
			profesionemplea.setEmpresa(profesionempleaDataAccess.getEmpresa(connexion,profesionemplea));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(profesionemplea.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			profesionemplea.setEmpleado(profesionempleaDataAccess.getEmpleado(connexion,profesionemplea));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(profesionemplea.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Profesion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			profesionemplea.setProfesion(profesionempleaDataAccess.getProfesion(connexion,profesionemplea));
			ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
			profesionLogic.deepLoad(profesionemplea.getProfesion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProfesionEmplea profesionemplea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProfesionEmpleaLogicAdditional.updateProfesionEmpleaToSave(profesionemplea,this.arrDatoGeneral);
			
ProfesionEmpleaDataAccess.save(profesionemplea, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(profesionemplea.getEmpresa(),connexion);

		EmpleadoDataAccess.save(profesionemplea.getEmpleado(),connexion);

		ProfesionDataAccess.save(profesionemplea.getProfesion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(profesionemplea.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(profesionemplea.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				ProfesionDataAccess.save(profesionemplea.getProfesion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(profesionemplea.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(profesionemplea.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(profesionemplea.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(profesionemplea.getEmpleado(),isDeep,deepLoadType,clases);
				

		ProfesionDataAccess.save(profesionemplea.getProfesion(),connexion);
		ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
		profesionLogic.deepLoad(profesionemplea.getProfesion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(profesionemplea.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(profesionemplea.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(profesionemplea.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(profesionemplea.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				ProfesionDataAccess.save(profesionemplea.getProfesion(),connexion);
				ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
				profesionLogic.deepSave(profesionemplea.getProfesion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProfesionEmplea.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(profesionemplea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(profesionemplea);
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
			this.deepLoad(this.profesionemplea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProfesionEmplea.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(profesionempleas!=null) {
				for(ProfesionEmplea profesionemplea:profesionempleas) {
					this.deepLoad(profesionemplea,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(profesionempleas);
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
			if(profesionempleas!=null) {
				for(ProfesionEmplea profesionemplea:profesionempleas) {
					this.deepLoad(profesionemplea,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(profesionempleas);
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
			this.getNewConnexionToDeep(ProfesionEmplea.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(profesionemplea,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProfesionEmplea.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(profesionempleas!=null) {
				for(ProfesionEmplea profesionemplea:profesionempleas) {
					this.deepSave(profesionemplea,isDeep,deepLoadType,clases);
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
			if(profesionempleas!=null) {
				for(ProfesionEmplea profesionemplea:profesionempleas) {
					this.deepSave(profesionemplea,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProfesionEmpleasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ProfesionEmpleaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			profesionempleas=profesionempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProfesionEmpleasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ProfesionEmpleaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			profesionempleas=profesionempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProfesionEmpleasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProfesionEmpleaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			profesionempleas=profesionempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProfesionEmpleasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProfesionEmpleaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			profesionempleas=profesionempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProfesionEmpleasFK_IdProfesionWithConnection(String sFinalQuery,Pagination pagination,Long id_profesion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProfesionEmplea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProfesion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProfesion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_profesion,ProfesionEmpleaConstantesFunciones.IDPROFESION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProfesion);

			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProfesion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			profesionempleas=profesionempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProfesionEmpleasFK_IdProfesion(String sFinalQuery,Pagination pagination,Long id_profesion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProfesion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProfesion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_profesion,ProfesionEmpleaConstantesFunciones.IDPROFESION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProfesion);

			ProfesionEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProfesion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			profesionempleas=profesionempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(this.profesionempleas);
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
			if(ProfesionEmpleaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProfesionEmpleaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProfesionEmplea profesionemplea,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProfesionEmpleaConstantesFunciones.ISCONAUDITORIA) {
				if(profesionemplea.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProfesionEmpleaDataAccess.TABLENAME, profesionemplea.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProfesionEmpleaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProfesionEmpleaLogic.registrarAuditoriaDetallesProfesionEmplea(connexion,profesionemplea,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(profesionemplea.getIsDeleted()) {
					/*if(!profesionemplea.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProfesionEmpleaDataAccess.TABLENAME, profesionemplea.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProfesionEmpleaLogic.registrarAuditoriaDetallesProfesionEmplea(connexion,profesionemplea,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProfesionEmpleaDataAccess.TABLENAME, profesionemplea.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(profesionemplea.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProfesionEmpleaDataAccess.TABLENAME, profesionemplea.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProfesionEmpleaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProfesionEmpleaLogic.registrarAuditoriaDetallesProfesionEmplea(connexion,profesionemplea,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProfesionEmplea(Connexion connexion,ProfesionEmplea profesionemplea)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(profesionemplea.getIsNew()||!profesionemplea.getid_empresa().equals(profesionemplea.getProfesionEmpleaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(profesionemplea.getProfesionEmpleaOriginal().getid_empresa()!=null)
				{
					strValorActual=profesionemplea.getProfesionEmpleaOriginal().getid_empresa().toString();
				}
				if(profesionemplea.getid_empresa()!=null)
				{
					strValorNuevo=profesionemplea.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProfesionEmpleaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(profesionemplea.getIsNew()||!profesionemplea.getid_empleado().equals(profesionemplea.getProfesionEmpleaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(profesionemplea.getProfesionEmpleaOriginal().getid_empleado()!=null)
				{
					strValorActual=profesionemplea.getProfesionEmpleaOriginal().getid_empleado().toString();
				}
				if(profesionemplea.getid_empleado()!=null)
				{
					strValorNuevo=profesionemplea.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProfesionEmpleaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(profesionemplea.getIsNew()||!profesionemplea.getid_profesion().equals(profesionemplea.getProfesionEmpleaOriginal().getid_profesion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(profesionemplea.getProfesionEmpleaOriginal().getid_profesion()!=null)
				{
					strValorActual=profesionemplea.getProfesionEmpleaOriginal().getid_profesion().toString();
				}
				if(profesionemplea.getid_profesion()!=null)
				{
					strValorNuevo=profesionemplea.getid_profesion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProfesionEmpleaConstantesFunciones.IDPROFESION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProfesionEmpleaRelacionesWithConnection(ProfesionEmplea profesionemplea) throws Exception {

		if(!profesionemplea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProfesionEmpleaRelacionesBase(profesionemplea,true);
		}
	}

	public void saveProfesionEmpleaRelaciones(ProfesionEmplea profesionemplea)throws Exception {

		if(!profesionemplea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProfesionEmpleaRelacionesBase(profesionemplea,false);
		}
	}

	public void saveProfesionEmpleaRelacionesBase(ProfesionEmplea profesionemplea,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProfesionEmplea-saveRelacionesWithConnection");}
	

			this.setProfesionEmplea(profesionemplea);

			if(ProfesionEmpleaLogicAdditional.validarSaveRelaciones(profesionemplea,this)) {

				ProfesionEmpleaLogicAdditional.updateRelacionesToSave(profesionemplea,this);

				if((profesionemplea.getIsNew()||profesionemplea.getIsChanged())&&!profesionemplea.getIsDeleted()) {
					this.saveProfesionEmplea();
					this.saveProfesionEmpleaRelacionesDetalles();

				} else if(profesionemplea.getIsDeleted()) {
					this.saveProfesionEmpleaRelacionesDetalles();
					this.saveProfesionEmplea();
				}

				ProfesionEmpleaLogicAdditional.updateRelacionesToSaveAfter(profesionemplea,this);

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
	
	
	private void saveProfesionEmpleaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProfesionEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProfesionEmpleaConstantesFunciones.getClassesForeignKeysOfProfesionEmplea(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProfesionEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProfesionEmpleaConstantesFunciones.getClassesRelationshipsOfProfesionEmplea(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.EvaluacionNomiConstantesFunciones;
import com.bydan.erp.nomina.util.EvaluacionNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EvaluacionNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.EvaluacionNomi;
import com.bydan.erp.nomina.business.logic.EvaluacionNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EvaluacionNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EvaluacionNomiLogic.class);
	
	protected EvaluacionNomiDataAccess evaluacionnomiDataAccess; 	
	protected EvaluacionNomi evaluacionnomi;
	protected List<EvaluacionNomi> evaluacionnomis;
	protected Object evaluacionnomiObject;	
	protected List<Object> evaluacionnomisObject;
	
	public static ClassValidator<EvaluacionNomi> evaluacionnomiValidator = new ClassValidator<EvaluacionNomi>(EvaluacionNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EvaluacionNomiLogicAdditional evaluacionnomiLogicAdditional=null;
	
	public EvaluacionNomiLogicAdditional getEvaluacionNomiLogicAdditional() {
		return this.evaluacionnomiLogicAdditional;
	}
	
	public void setEvaluacionNomiLogicAdditional(EvaluacionNomiLogicAdditional evaluacionnomiLogicAdditional) {
		try {
			this.evaluacionnomiLogicAdditional=evaluacionnomiLogicAdditional;
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
	
	
	
	
	public  EvaluacionNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.evaluacionnomiDataAccess = new EvaluacionNomiDataAccess();
			
			this.evaluacionnomis= new ArrayList<EvaluacionNomi>();
			this.evaluacionnomi= new EvaluacionNomi();
			
			this.evaluacionnomiObject=new Object();
			this.evaluacionnomisObject=new ArrayList<Object>();
				
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
			
			this.evaluacionnomiDataAccess.setConnexionType(this.connexionType);
			this.evaluacionnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EvaluacionNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.evaluacionnomiDataAccess = new EvaluacionNomiDataAccess();
			this.evaluacionnomis= new ArrayList<EvaluacionNomi>();
			this.evaluacionnomi= new EvaluacionNomi();
			this.evaluacionnomiObject=new Object();
			this.evaluacionnomisObject=new ArrayList<Object>();
			
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
			
			this.evaluacionnomiDataAccess.setConnexionType(this.connexionType);
			this.evaluacionnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EvaluacionNomi getEvaluacionNomi() throws Exception {	
		EvaluacionNomiLogicAdditional.checkEvaluacionNomiToGet(evaluacionnomi,this.datosCliente,this.arrDatoGeneral);
		EvaluacionNomiLogicAdditional.updateEvaluacionNomiToGet(evaluacionnomi,this.arrDatoGeneral);
		
		return evaluacionnomi;
	}
		
	public void setEvaluacionNomi(EvaluacionNomi newEvaluacionNomi) {
		this.evaluacionnomi = newEvaluacionNomi;
	}
	
	public EvaluacionNomiDataAccess getEvaluacionNomiDataAccess() {
		return evaluacionnomiDataAccess;
	}
	
	public void setEvaluacionNomiDataAccess(EvaluacionNomiDataAccess newevaluacionnomiDataAccess) {
		this.evaluacionnomiDataAccess = newevaluacionnomiDataAccess;
	}
	
	public List<EvaluacionNomi> getEvaluacionNomis() throws Exception {		
		this.quitarEvaluacionNomisNulos();
		
		EvaluacionNomiLogicAdditional.checkEvaluacionNomiToGets(evaluacionnomis,this.datosCliente,this.arrDatoGeneral);
		
		for (EvaluacionNomi evaluacionnomiLocal: evaluacionnomis ) {
			EvaluacionNomiLogicAdditional.updateEvaluacionNomiToGet(evaluacionnomiLocal,this.arrDatoGeneral);
		}
		
		return evaluacionnomis;
	}
	
	public void setEvaluacionNomis(List<EvaluacionNomi> newEvaluacionNomis) {
		this.evaluacionnomis = newEvaluacionNomis;
	}
	
	public Object getEvaluacionNomiObject() {	
		this.evaluacionnomiObject=this.evaluacionnomiDataAccess.getEntityObject();
		return this.evaluacionnomiObject;
	}
		
	public void setEvaluacionNomiObject(Object newEvaluacionNomiObject) {
		this.evaluacionnomiObject = newEvaluacionNomiObject;
	}
	
	public List<Object> getEvaluacionNomisObject() {		
		this.evaluacionnomisObject=this.evaluacionnomiDataAccess.getEntitiesObject();
		return this.evaluacionnomisObject;
	}
		
	public void setEvaluacionNomisObject(List<Object> newEvaluacionNomisObject) {
		this.evaluacionnomisObject = newEvaluacionNomisObject;
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
		
		if(this.evaluacionnomiDataAccess!=null) {
			this.evaluacionnomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			evaluacionnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			evaluacionnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		evaluacionnomi = new  EvaluacionNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			evaluacionnomi=evaluacionnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomi);
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
		evaluacionnomi = new  EvaluacionNomi();
		  		  
        try {
			
			evaluacionnomi=evaluacionnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		evaluacionnomi = new  EvaluacionNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			evaluacionnomi=evaluacionnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomi);
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
		evaluacionnomi = new  EvaluacionNomi();
		  		  
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
		evaluacionnomi = new  EvaluacionNomi();
		  		  
        try {
			
			evaluacionnomi=evaluacionnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		evaluacionnomi = new  EvaluacionNomi();
		  		  
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
		evaluacionnomi = new  EvaluacionNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =evaluacionnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		evaluacionnomi = new  EvaluacionNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=evaluacionnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		evaluacionnomi = new  EvaluacionNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =evaluacionnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		evaluacionnomi = new  EvaluacionNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=evaluacionnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		evaluacionnomi = new  EvaluacionNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =evaluacionnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		evaluacionnomi = new  EvaluacionNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=evaluacionnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
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
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		  		  
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
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		  		  
        try {			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		  		  
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
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
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
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		  		  
        try {
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
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
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
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
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		evaluacionnomi = new  EvaluacionNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomi=evaluacionnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomi);
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
		evaluacionnomi = new  EvaluacionNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomi=evaluacionnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomis=evaluacionnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
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
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		  		  
        try {
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomis=evaluacionnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEvaluacionNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getTodosEvaluacionNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
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
	
	public  void  getTodosEvaluacionNomis(String sFinalQuery,Pagination pagination)throws Exception {
		evaluacionnomis = new  ArrayList<EvaluacionNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEvaluacionNomi(evaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEvaluacionNomi(EvaluacionNomi evaluacionnomi) throws Exception {
		Boolean estaValidado=false;
		
		if(evaluacionnomi.getIsNew() || evaluacionnomi.getIsChanged()) { 
			this.invalidValues = evaluacionnomiValidator.getInvalidValues(evaluacionnomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(evaluacionnomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEvaluacionNomi(List<EvaluacionNomi> EvaluacionNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EvaluacionNomi evaluacionnomiLocal:evaluacionnomis) {				
			estaValidadoObjeto=this.validarGuardarEvaluacionNomi(evaluacionnomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEvaluacionNomi(List<EvaluacionNomi> EvaluacionNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEvaluacionNomi(evaluacionnomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEvaluacionNomi(EvaluacionNomi EvaluacionNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEvaluacionNomi(evaluacionnomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EvaluacionNomi evaluacionnomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+evaluacionnomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EvaluacionNomiConstantesFunciones.getEvaluacionNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"evaluacionnomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EvaluacionNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EvaluacionNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEvaluacionNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-saveEvaluacionNomiWithConnection");connexion.begin();			
			
			EvaluacionNomiLogicAdditional.checkEvaluacionNomiToSave(this.evaluacionnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EvaluacionNomiLogicAdditional.updateEvaluacionNomiToSave(this.evaluacionnomi,this.arrDatoGeneral);
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.evaluacionnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEvaluacionNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEvaluacionNomi(this.evaluacionnomi)) {
				EvaluacionNomiDataAccess.save(this.evaluacionnomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.evaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EvaluacionNomiLogicAdditional.checkEvaluacionNomiToSaveAfter(this.evaluacionnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEvaluacionNomi();
			
			connexion.commit();			
			
			if(this.evaluacionnomi.getIsDeleted()) {
				this.evaluacionnomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEvaluacionNomi()throws Exception {	
		try {	
			
			EvaluacionNomiLogicAdditional.checkEvaluacionNomiToSave(this.evaluacionnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EvaluacionNomiLogicAdditional.updateEvaluacionNomiToSave(this.evaluacionnomi,this.arrDatoGeneral);
			
			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.evaluacionnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEvaluacionNomi(this.evaluacionnomi)) {			
				EvaluacionNomiDataAccess.save(this.evaluacionnomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.evaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EvaluacionNomiLogicAdditional.checkEvaluacionNomiToSaveAfter(this.evaluacionnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.evaluacionnomi.getIsDeleted()) {
				this.evaluacionnomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEvaluacionNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-saveEvaluacionNomisWithConnection");connexion.begin();			
			
			EvaluacionNomiLogicAdditional.checkEvaluacionNomiToSaves(evaluacionnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEvaluacionNomis();
			
			Boolean validadoTodosEvaluacionNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EvaluacionNomi evaluacionnomiLocal:evaluacionnomis) {		
				if(evaluacionnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EvaluacionNomiLogicAdditional.updateEvaluacionNomiToSave(evaluacionnomiLocal,this.arrDatoGeneral);
	        	
				EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),evaluacionnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEvaluacionNomi(evaluacionnomiLocal)) {
					EvaluacionNomiDataAccess.save(evaluacionnomiLocal, connexion);				
				} else {
					validadoTodosEvaluacionNomi=false;
				}
			}
			
			if(!validadoTodosEvaluacionNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EvaluacionNomiLogicAdditional.checkEvaluacionNomiToSavesAfter(evaluacionnomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEvaluacionNomis();
			
			connexion.commit();		
			
			this.quitarEvaluacionNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEvaluacionNomis()throws Exception {				
		 try {	
			EvaluacionNomiLogicAdditional.checkEvaluacionNomiToSaves(evaluacionnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEvaluacionNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EvaluacionNomi evaluacionnomiLocal:evaluacionnomis) {				
				if(evaluacionnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EvaluacionNomiLogicAdditional.updateEvaluacionNomiToSave(evaluacionnomiLocal,this.arrDatoGeneral);
	        	
				EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),evaluacionnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEvaluacionNomi(evaluacionnomiLocal)) {				
					EvaluacionNomiDataAccess.save(evaluacionnomiLocal, connexion);				
				} else {
					validadoTodosEvaluacionNomi=false;
				}
			}
			
			if(!validadoTodosEvaluacionNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EvaluacionNomiLogicAdditional.checkEvaluacionNomiToSavesAfter(evaluacionnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEvaluacionNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EvaluacionNomiParameterReturnGeneral procesarAccionEvaluacionNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionNomi> evaluacionnomis,EvaluacionNomiParameterReturnGeneral evaluacionnomiParameterGeneral)throws Exception {
		 try {	
			EvaluacionNomiParameterReturnGeneral evaluacionnomiReturnGeneral=new EvaluacionNomiParameterReturnGeneral();
	
			EvaluacionNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionnomis,evaluacionnomiParameterGeneral,evaluacionnomiReturnGeneral);
			
			return evaluacionnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EvaluacionNomiParameterReturnGeneral procesarAccionEvaluacionNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionNomi> evaluacionnomis,EvaluacionNomiParameterReturnGeneral evaluacionnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-procesarAccionEvaluacionNomisWithConnection");connexion.begin();			
			
			EvaluacionNomiParameterReturnGeneral evaluacionnomiReturnGeneral=new EvaluacionNomiParameterReturnGeneral();
	
			EvaluacionNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionnomis,evaluacionnomiParameterGeneral,evaluacionnomiReturnGeneral);
			
			this.connexion.commit();
			
			return evaluacionnomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EvaluacionNomiParameterReturnGeneral procesarEventosEvaluacionNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EvaluacionNomi> evaluacionnomis,EvaluacionNomi evaluacionnomi,EvaluacionNomiParameterReturnGeneral evaluacionnomiParameterGeneral,Boolean isEsNuevoEvaluacionNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			EvaluacionNomiParameterReturnGeneral evaluacionnomiReturnGeneral=new EvaluacionNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				evaluacionnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EvaluacionNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,evaluacionnomis,evaluacionnomi,evaluacionnomiParameterGeneral,evaluacionnomiReturnGeneral,isEsNuevoEvaluacionNomi,clases);
			
			return evaluacionnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EvaluacionNomiParameterReturnGeneral procesarEventosEvaluacionNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EvaluacionNomi> evaluacionnomis,EvaluacionNomi evaluacionnomi,EvaluacionNomiParameterReturnGeneral evaluacionnomiParameterGeneral,Boolean isEsNuevoEvaluacionNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-procesarEventosEvaluacionNomisWithConnection");connexion.begin();			
			
			EvaluacionNomiParameterReturnGeneral evaluacionnomiReturnGeneral=new EvaluacionNomiParameterReturnGeneral();
	
			evaluacionnomiReturnGeneral.setEvaluacionNomi(evaluacionnomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				evaluacionnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EvaluacionNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,evaluacionnomis,evaluacionnomi,evaluacionnomiParameterGeneral,evaluacionnomiReturnGeneral,isEsNuevoEvaluacionNomi,clases);
			
			this.connexion.commit();
			
			return evaluacionnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EvaluacionNomiParameterReturnGeneral procesarImportacionEvaluacionNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EvaluacionNomiParameterReturnGeneral evaluacionnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-procesarImportacionEvaluacionNomisWithConnection");connexion.begin();			
			
			EvaluacionNomiParameterReturnGeneral evaluacionnomiReturnGeneral=new EvaluacionNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.evaluacionnomis=new ArrayList<EvaluacionNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.evaluacionnomi=new EvaluacionNomi();
				
				
				if(conColumnasBase) {this.evaluacionnomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.evaluacionnomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.evaluacionnomi.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.evaluacionnomi.setinstrucciones(arrColumnas[iColumn++]);
			this.evaluacionnomi.setdescripcion(arrColumnas[iColumn++]);
			this.evaluacionnomi.setdescripcion2(arrColumnas[iColumn++]);
			this.evaluacionnomi.setdescripcion3(arrColumnas[iColumn++]);
			this.evaluacionnomi.setdescripcion4(arrColumnas[iColumn++]);
				
				this.evaluacionnomis.add(this.evaluacionnomi);
			}
			
			this.saveEvaluacionNomis();
			
			this.connexion.commit();
			
			evaluacionnomiReturnGeneral.setConRetornoEstaProcesado(true);
			evaluacionnomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return evaluacionnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEvaluacionNomisEliminados() throws Exception {				
		
		List<EvaluacionNomi> evaluacionnomisAux= new ArrayList<EvaluacionNomi>();
		
		for(EvaluacionNomi evaluacionnomi:evaluacionnomis) {
			if(!evaluacionnomi.getIsDeleted()) {
				evaluacionnomisAux.add(evaluacionnomi);
			}
		}
		
		evaluacionnomis=evaluacionnomisAux;
	}
	
	public void quitarEvaluacionNomisNulos() throws Exception {				
		
		List<EvaluacionNomi> evaluacionnomisAux= new ArrayList<EvaluacionNomi>();
		
		for(EvaluacionNomi evaluacionnomi : this.evaluacionnomis) {
			if(evaluacionnomi==null) {
				evaluacionnomisAux.add(evaluacionnomi);
			}
		}
		
		//this.evaluacionnomis=evaluacionnomisAux;
		
		this.evaluacionnomis.removeAll(evaluacionnomisAux);
	}
	
	public void getSetVersionRowEvaluacionNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(evaluacionnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((evaluacionnomi.getIsDeleted() || (evaluacionnomi.getIsChanged()&&!evaluacionnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=evaluacionnomiDataAccess.getSetVersionRowEvaluacionNomi(connexion,evaluacionnomi.getId());
				
				if(!evaluacionnomi.getVersionRow().equals(timestamp)) {	
					evaluacionnomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				evaluacionnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEvaluacionNomi()throws Exception {	
		
		if(evaluacionnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((evaluacionnomi.getIsDeleted() || (evaluacionnomi.getIsChanged()&&!evaluacionnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=evaluacionnomiDataAccess.getSetVersionRowEvaluacionNomi(connexion,evaluacionnomi.getId());
			
			try {							
				if(!evaluacionnomi.getVersionRow().equals(timestamp)) {	
					evaluacionnomi.setVersionRow(timestamp);
				}
				
				evaluacionnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEvaluacionNomisWithConnection()throws Exception {	
		if(evaluacionnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EvaluacionNomi evaluacionnomiAux:evaluacionnomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(evaluacionnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(evaluacionnomiAux.getIsDeleted() || (evaluacionnomiAux.getIsChanged()&&!evaluacionnomiAux.getIsNew())) {
						
						timestamp=evaluacionnomiDataAccess.getSetVersionRowEvaluacionNomi(connexion,evaluacionnomiAux.getId());
						
						if(!evaluacionnomi.getVersionRow().equals(timestamp)) {	
							evaluacionnomiAux.setVersionRow(timestamp);
						}
								
						evaluacionnomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEvaluacionNomis()throws Exception {	
		if(evaluacionnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EvaluacionNomi evaluacionnomiAux:evaluacionnomis) {
					if(evaluacionnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(evaluacionnomiAux.getIsDeleted() || (evaluacionnomiAux.getIsChanged()&&!evaluacionnomiAux.getIsNew())) {
						
						timestamp=evaluacionnomiDataAccess.getSetVersionRowEvaluacionNomi(connexion,evaluacionnomiAux.getId());
						
						if(!evaluacionnomiAux.getVersionRow().equals(timestamp)) {	
							evaluacionnomiAux.setVersionRow(timestamp);
						}
						
													
						evaluacionnomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EvaluacionNomiParameterReturnGeneral cargarCombosLoteForeignKeyEvaluacionNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalEmpleado,String finalQueryGlobalEmpleadoEvaluador,String finalQueryGlobalFormatoNomi,String finalQueryGlobalEstructura) throws Exception {
		EvaluacionNomiParameterReturnGeneral  evaluacionnomiReturnGeneral =new EvaluacionNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyEvaluacionNomiWithConnection");connexion.begin();
			
			evaluacionnomiReturnGeneral =new EvaluacionNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			evaluacionnomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			evaluacionnomiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			evaluacionnomiReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			evaluacionnomiReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			evaluacionnomiReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Empleado> empleadoevaluadorsForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoevaluadorLogic=new EmpleadoLogic();
			empleadoevaluadorLogic.setConnexion(this.connexion);
			empleadoevaluadorLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoEvaluador.equals("NONE")) {
				empleadoevaluadorLogic.getTodosEmpleados(finalQueryGlobalEmpleadoEvaluador,new Pagination());
				empleadoevaluadorsForeignKey=empleadoevaluadorLogic.getEmpleados();
			}

			evaluacionnomiReturnGeneral.setempleadoevaluadorsForeignKey(empleadoevaluadorsForeignKey);


			List<FormatoNomi> formatonomisForeignKey=new ArrayList<FormatoNomi>();
			FormatoNomiLogic formatonomiLogic=new FormatoNomiLogic();
			formatonomiLogic.setConnexion(this.connexion);
			formatonomiLogic.getFormatoNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomi.equals("NONE")) {
				formatonomiLogic.getTodosFormatoNomis(finalQueryGlobalFormatoNomi,new Pagination());
				formatonomisForeignKey=formatonomiLogic.getFormatoNomis();
			}

			evaluacionnomiReturnGeneral.setformatonomisForeignKey(formatonomisForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			evaluacionnomiReturnGeneral.setestructurasForeignKey(estructurasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return evaluacionnomiReturnGeneral;
	}
	
	public EvaluacionNomiParameterReturnGeneral cargarCombosLoteForeignKeyEvaluacionNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalEmpleado,String finalQueryGlobalEmpleadoEvaluador,String finalQueryGlobalFormatoNomi,String finalQueryGlobalEstructura) throws Exception {
		EvaluacionNomiParameterReturnGeneral  evaluacionnomiReturnGeneral =new EvaluacionNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			evaluacionnomiReturnGeneral =new EvaluacionNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			evaluacionnomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			evaluacionnomiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			evaluacionnomiReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			evaluacionnomiReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			evaluacionnomiReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Empleado> empleadoevaluadorsForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoevaluadorLogic=new EmpleadoLogic();
			empleadoevaluadorLogic.setConnexion(this.connexion);
			empleadoevaluadorLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoEvaluador.equals("NONE")) {
				empleadoevaluadorLogic.getTodosEmpleados(finalQueryGlobalEmpleadoEvaluador,new Pagination());
				empleadoevaluadorsForeignKey=empleadoevaluadorLogic.getEmpleados();
			}

			evaluacionnomiReturnGeneral.setempleadoevaluadorsForeignKey(empleadoevaluadorsForeignKey);


			List<FormatoNomi> formatonomisForeignKey=new ArrayList<FormatoNomi>();
			FormatoNomiLogic formatonomiLogic=new FormatoNomiLogic();
			formatonomiLogic.setConnexion(this.connexion);
			formatonomiLogic.getFormatoNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomi.equals("NONE")) {
				formatonomiLogic.getTodosFormatoNomis(finalQueryGlobalFormatoNomi,new Pagination());
				formatonomisForeignKey=formatonomiLogic.getFormatoNomis();
			}

			evaluacionnomiReturnGeneral.setformatonomisForeignKey(formatonomisForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			evaluacionnomiReturnGeneral.setestructurasForeignKey(estructurasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return evaluacionnomiReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEvaluacionNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic=new DetalleEvaluacionNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEvaluacionNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleEvaluacionNomi.class));
											
			

			detalleevaluacionnomiLogic.setConnexion(this.getConnexion());
			detalleevaluacionnomiLogic.setDatosCliente(this.datosCliente);
			detalleevaluacionnomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EvaluacionNomi evaluacionnomi:this.evaluacionnomis) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleEvaluacionNomiConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleevaluacionnomiLogic.setDetalleEvaluacionNomis(evaluacionnomi.detalleevaluacionnomis);
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
	
	public void deepLoad(EvaluacionNomi evaluacionnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EvaluacionNomiLogicAdditional.updateEvaluacionNomiToGet(evaluacionnomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionnomi.setEmpresa(evaluacionnomiDataAccess.getEmpresa(connexion,evaluacionnomi));
		evaluacionnomi.setSucursal(evaluacionnomiDataAccess.getSucursal(connexion,evaluacionnomi));
		evaluacionnomi.setEjercicio(evaluacionnomiDataAccess.getEjercicio(connexion,evaluacionnomi));
		evaluacionnomi.setPeriodo(evaluacionnomiDataAccess.getPeriodo(connexion,evaluacionnomi));
		evaluacionnomi.setEmpleado(evaluacionnomiDataAccess.getEmpleado(connexion,evaluacionnomi));
		evaluacionnomi.setEmpleadoEvaluador(evaluacionnomiDataAccess.getEmpleadoEvaluador(connexion,evaluacionnomi));
		evaluacionnomi.setFormatoNomi(evaluacionnomiDataAccess.getFormatoNomi(connexion,evaluacionnomi));
		evaluacionnomi.setEstructura(evaluacionnomiDataAccess.getEstructura(connexion,evaluacionnomi));
		evaluacionnomi.setDetalleEvaluacionNomis(evaluacionnomiDataAccess.getDetalleEvaluacionNomis(connexion,evaluacionnomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				evaluacionnomi.setEmpresa(evaluacionnomiDataAccess.getEmpresa(connexion,evaluacionnomi));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionnomi.setSucursal(evaluacionnomiDataAccess.getSucursal(connexion,evaluacionnomi));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				evaluacionnomi.setEjercicio(evaluacionnomiDataAccess.getEjercicio(connexion,evaluacionnomi));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				evaluacionnomi.setPeriodo(evaluacionnomiDataAccess.getPeriodo(connexion,evaluacionnomi));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				evaluacionnomi.setEmpleado(evaluacionnomiDataAccess.getEmpleado(connexion,evaluacionnomi));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				evaluacionnomi.setEmpleadoEvaluador(evaluacionnomiDataAccess.getEmpleadoEvaluador(connexion,evaluacionnomi));
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				evaluacionnomi.setFormatoNomi(evaluacionnomiDataAccess.getFormatoNomi(connexion,evaluacionnomi));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				evaluacionnomi.setEstructura(evaluacionnomiDataAccess.getEstructura(connexion,evaluacionnomi));
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				evaluacionnomi.setDetalleEvaluacionNomis(evaluacionnomiDataAccess.getDetalleEvaluacionNomis(connexion,evaluacionnomi));

				if(this.isConDeep) {
					DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(this.connexion);
					detalleevaluacionnomiLogic.setDetalleEvaluacionNomis(evaluacionnomi.getDetalleEvaluacionNomis());
					ArrayList<Classe> classesLocal=DetalleEvaluacionNomiConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleevaluacionnomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(detalleevaluacionnomiLogic.getDetalleEvaluacionNomis());
					evaluacionnomi.setDetalleEvaluacionNomis(detalleevaluacionnomiLogic.getDetalleEvaluacionNomis());
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
			evaluacionnomi.setEmpresa(evaluacionnomiDataAccess.getEmpresa(connexion,evaluacionnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setSucursal(evaluacionnomiDataAccess.getSucursal(connexion,evaluacionnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setEjercicio(evaluacionnomiDataAccess.getEjercicio(connexion,evaluacionnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setPeriodo(evaluacionnomiDataAccess.getPeriodo(connexion,evaluacionnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setEmpleado(evaluacionnomiDataAccess.getEmpleado(connexion,evaluacionnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setEmpleadoEvaluador(evaluacionnomiDataAccess.getEmpleadoEvaluador(connexion,evaluacionnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setFormatoNomi(evaluacionnomiDataAccess.getFormatoNomi(connexion,evaluacionnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setEstructura(evaluacionnomiDataAccess.getEstructura(connexion,evaluacionnomi));
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
			evaluacionnomi.setDetalleEvaluacionNomis(evaluacionnomiDataAccess.getDetalleEvaluacionNomis(connexion,evaluacionnomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionnomi.setEmpresa(evaluacionnomiDataAccess.getEmpresa(connexion,evaluacionnomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(evaluacionnomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		evaluacionnomi.setSucursal(evaluacionnomiDataAccess.getSucursal(connexion,evaluacionnomi));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(evaluacionnomi.getSucursal(),isDeep,deepLoadType,clases);
				
		evaluacionnomi.setEjercicio(evaluacionnomiDataAccess.getEjercicio(connexion,evaluacionnomi));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(evaluacionnomi.getEjercicio(),isDeep,deepLoadType,clases);
				
		evaluacionnomi.setPeriodo(evaluacionnomiDataAccess.getPeriodo(connexion,evaluacionnomi));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(evaluacionnomi.getPeriodo(),isDeep,deepLoadType,clases);
				
		evaluacionnomi.setEmpleado(evaluacionnomiDataAccess.getEmpleado(connexion,evaluacionnomi));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(evaluacionnomi.getEmpleado(),isDeep,deepLoadType,clases);
				
		evaluacionnomi.setEmpleadoEvaluador(evaluacionnomiDataAccess.getEmpleadoEvaluador(connexion,evaluacionnomi));
		EmpleadoLogic empleadoevaluadorLogic= new EmpleadoLogic(connexion);
		empleadoevaluadorLogic.deepLoad(evaluacionnomi.getEmpleadoEvaluador(),isDeep,deepLoadType,clases);
				
		evaluacionnomi.setFormatoNomi(evaluacionnomiDataAccess.getFormatoNomi(connexion,evaluacionnomi));
		FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
		formatonomiLogic.deepLoad(evaluacionnomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				
		evaluacionnomi.setEstructura(evaluacionnomiDataAccess.getEstructura(connexion,evaluacionnomi));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(evaluacionnomi.getEstructura(),isDeep,deepLoadType,clases);
				

		evaluacionnomi.setDetalleEvaluacionNomis(evaluacionnomiDataAccess.getDetalleEvaluacionNomis(connexion,evaluacionnomi));

		for(DetalleEvaluacionNomi detalleevaluacionnomi:evaluacionnomi.getDetalleEvaluacionNomis()) {
			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
			detalleevaluacionnomiLogic.deepLoad(detalleevaluacionnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				evaluacionnomi.setEmpresa(evaluacionnomiDataAccess.getEmpresa(connexion,evaluacionnomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(evaluacionnomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionnomi.setSucursal(evaluacionnomiDataAccess.getSucursal(connexion,evaluacionnomi));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(evaluacionnomi.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				evaluacionnomi.setEjercicio(evaluacionnomiDataAccess.getEjercicio(connexion,evaluacionnomi));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(evaluacionnomi.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				evaluacionnomi.setPeriodo(evaluacionnomiDataAccess.getPeriodo(connexion,evaluacionnomi));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(evaluacionnomi.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				evaluacionnomi.setEmpleado(evaluacionnomiDataAccess.getEmpleado(connexion,evaluacionnomi));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(evaluacionnomi.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				evaluacionnomi.setEmpleadoEvaluador(evaluacionnomiDataAccess.getEmpleadoEvaluador(connexion,evaluacionnomi));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(evaluacionnomi.getEmpleadoEvaluador(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				evaluacionnomi.setFormatoNomi(evaluacionnomiDataAccess.getFormatoNomi(connexion,evaluacionnomi));
				FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
				formatonomiLogic.deepLoad(evaluacionnomi.getFormatoNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				evaluacionnomi.setEstructura(evaluacionnomiDataAccess.getEstructura(connexion,evaluacionnomi));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(evaluacionnomi.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				evaluacionnomi.setDetalleEvaluacionNomis(evaluacionnomiDataAccess.getDetalleEvaluacionNomis(connexion,evaluacionnomi));

				for(DetalleEvaluacionNomi detalleevaluacionnomi:evaluacionnomi.getDetalleEvaluacionNomis()) {
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
			evaluacionnomi.setEmpresa(evaluacionnomiDataAccess.getEmpresa(connexion,evaluacionnomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(evaluacionnomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setSucursal(evaluacionnomiDataAccess.getSucursal(connexion,evaluacionnomi));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(evaluacionnomi.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setEjercicio(evaluacionnomiDataAccess.getEjercicio(connexion,evaluacionnomi));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(evaluacionnomi.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setPeriodo(evaluacionnomiDataAccess.getPeriodo(connexion,evaluacionnomi));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(evaluacionnomi.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setEmpleado(evaluacionnomiDataAccess.getEmpleado(connexion,evaluacionnomi));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(evaluacionnomi.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setEmpleadoEvaluador(evaluacionnomiDataAccess.getEmpleadoEvaluador(connexion,evaluacionnomi));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(evaluacionnomi.getEmpleadoEvaluador(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setFormatoNomi(evaluacionnomiDataAccess.getFormatoNomi(connexion,evaluacionnomi));
			FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
			formatonomiLogic.deepLoad(evaluacionnomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionnomi.setEstructura(evaluacionnomiDataAccess.getEstructura(connexion,evaluacionnomi));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(evaluacionnomi.getEstructura(),isDeep,deepLoadType,clases);
				
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
			evaluacionnomi.setDetalleEvaluacionNomis(evaluacionnomiDataAccess.getDetalleEvaluacionNomis(connexion,evaluacionnomi));

			for(DetalleEvaluacionNomi detalleevaluacionnomi:evaluacionnomi.getDetalleEvaluacionNomis()) {
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
	
	public void deepSave(EvaluacionNomi evaluacionnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EvaluacionNomiLogicAdditional.updateEvaluacionNomiToSave(evaluacionnomi,this.arrDatoGeneral);
			
EvaluacionNomiDataAccess.save(evaluacionnomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(evaluacionnomi.getEmpresa(),connexion);

		SucursalDataAccess.save(evaluacionnomi.getSucursal(),connexion);

		EjercicioDataAccess.save(evaluacionnomi.getEjercicio(),connexion);

		PeriodoDataAccess.save(evaluacionnomi.getPeriodo(),connexion);

		EmpleadoDataAccess.save(evaluacionnomi.getEmpleado(),connexion);

		EmpleadoDataAccess.save(evaluacionnomi.getEmpleadoEvaluador(),connexion);

		FormatoNomiDataAccess.save(evaluacionnomi.getFormatoNomi(),connexion);

		EstructuraDataAccess.save(evaluacionnomi.getEstructura(),connexion);

		for(DetalleEvaluacionNomi detalleevaluacionnomi:evaluacionnomi.getDetalleEvaluacionNomis()) {
			detalleevaluacionnomi.setid_evaluacion_nomi(evaluacionnomi.getId());
			DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(evaluacionnomi.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(evaluacionnomi.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(evaluacionnomi.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(evaluacionnomi.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(evaluacionnomi.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(evaluacionnomi.getEmpleadoEvaluador(),connexion);
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				FormatoNomiDataAccess.save(evaluacionnomi.getFormatoNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(evaluacionnomi.getEstructura(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionNomi detalleevaluacionnomi:evaluacionnomi.getDetalleEvaluacionNomis()) {
					detalleevaluacionnomi.setid_evaluacion_nomi(evaluacionnomi.getId());
					DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(evaluacionnomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(evaluacionnomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(evaluacionnomi.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(evaluacionnomi.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(evaluacionnomi.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(evaluacionnomi.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(evaluacionnomi.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(evaluacionnomi.getPeriodo(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(evaluacionnomi.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(evaluacionnomi.getEmpleado(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(evaluacionnomi.getEmpleadoEvaluador(),connexion);
		EmpleadoLogic empleadoevaluadorLogic= new EmpleadoLogic(connexion);
		empleadoevaluadorLogic.deepLoad(evaluacionnomi.getEmpleadoEvaluador(),isDeep,deepLoadType,clases);
				

		FormatoNomiDataAccess.save(evaluacionnomi.getFormatoNomi(),connexion);
		FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
		formatonomiLogic.deepLoad(evaluacionnomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(evaluacionnomi.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(evaluacionnomi.getEstructura(),isDeep,deepLoadType,clases);
				

		for(DetalleEvaluacionNomi detalleevaluacionnomi:evaluacionnomi.getDetalleEvaluacionNomis()) {
			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
			detalleevaluacionnomi.setid_evaluacion_nomi(evaluacionnomi.getId());
			DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi,connexion);
			detalleevaluacionnomiLogic.deepSave(detalleevaluacionnomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(evaluacionnomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(evaluacionnomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(evaluacionnomi.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(evaluacionnomi.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(evaluacionnomi.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(evaluacionnomi.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(evaluacionnomi.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(evaluacionnomi.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(evaluacionnomi.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(evaluacionnomi.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(evaluacionnomi.getEmpleadoEvaluador(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(evaluacionnomi.getEmpleadoEvaluador(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				FormatoNomiDataAccess.save(evaluacionnomi.getFormatoNomi(),connexion);
				FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
				formatonomiLogic.deepSave(evaluacionnomi.getFormatoNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(evaluacionnomi.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(evaluacionnomi.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleEvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionNomi detalleevaluacionnomi:evaluacionnomi.getDetalleEvaluacionNomis()) {
					DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic= new DetalleEvaluacionNomiLogic(connexion);
					detalleevaluacionnomi.setid_evaluacion_nomi(evaluacionnomi.getId());
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
			this.getNewConnexionToDeep(EvaluacionNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(evaluacionnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(evaluacionnomi);
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
			this.deepLoad(this.evaluacionnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EvaluacionNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(evaluacionnomis!=null) {
				for(EvaluacionNomi evaluacionnomi:evaluacionnomis) {
					this.deepLoad(evaluacionnomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(evaluacionnomis);
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
			if(evaluacionnomis!=null) {
				for(EvaluacionNomi evaluacionnomi:evaluacionnomis) {
					this.deepLoad(evaluacionnomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(evaluacionnomis);
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
			this.getNewConnexionToDeep(EvaluacionNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(evaluacionnomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EvaluacionNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(evaluacionnomis!=null) {
				for(EvaluacionNomi evaluacionnomi:evaluacionnomis) {
					this.deepSave(evaluacionnomi,isDeep,deepLoadType,clases);
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
			if(evaluacionnomis!=null) {
				for(EvaluacionNomi evaluacionnomi:evaluacionnomis) {
					this.deepSave(evaluacionnomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEvaluacionNomisFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,EvaluacionNomiConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionNomisFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,EvaluacionNomiConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionNomisFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EvaluacionNomiConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionNomisFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EvaluacionNomiConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionNomisFK_IdEmpleadoEvaluadorWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_evaluador)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoEvaluador= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoEvaluador.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_evaluador,EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoEvaluador);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoEvaluador","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionNomisFK_IdEmpleadoEvaluador(String sFinalQuery,Pagination pagination,Long id_empleado_evaluador)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoEvaluador= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoEvaluador.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_evaluador,EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoEvaluador);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoEvaluador","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EvaluacionNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EvaluacionNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionNomisFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EvaluacionNomiConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionNomisFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EvaluacionNomiConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionNomisFK_IdFormatoNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi,EvaluacionNomiConstantesFunciones.IDFORMATONOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomi);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionNomisFK_IdFormatoNomi(String sFinalQuery,Pagination pagination,Long id_formato_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi,EvaluacionNomiConstantesFunciones.IDFORMATONOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomi);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionNomisFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,EvaluacionNomiConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionNomisFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,EvaluacionNomiConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionNomisFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EvaluacionNomiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionNomisFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EvaluacionNomiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(this.evaluacionnomis);
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
			if(EvaluacionNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EvaluacionNomi evaluacionnomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EvaluacionNomiConstantesFunciones.ISCONAUDITORIA) {
				if(evaluacionnomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionNomiDataAccess.TABLENAME, evaluacionnomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EvaluacionNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EvaluacionNomiLogic.registrarAuditoriaDetallesEvaluacionNomi(connexion,evaluacionnomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(evaluacionnomi.getIsDeleted()) {
					/*if(!evaluacionnomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EvaluacionNomiDataAccess.TABLENAME, evaluacionnomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EvaluacionNomiLogic.registrarAuditoriaDetallesEvaluacionNomi(connexion,evaluacionnomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionNomiDataAccess.TABLENAME, evaluacionnomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(evaluacionnomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionNomiDataAccess.TABLENAME, evaluacionnomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EvaluacionNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EvaluacionNomiLogic.registrarAuditoriaDetallesEvaluacionNomi(connexion,evaluacionnomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEvaluacionNomi(Connexion connexion,EvaluacionNomi evaluacionnomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getid_empresa().equals(evaluacionnomi.getEvaluacionNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getid_empresa().toString();
				}
				if(evaluacionnomi.getid_empresa()!=null)
				{
					strValorNuevo=evaluacionnomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getid_sucursal().equals(evaluacionnomi.getEvaluacionNomiOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getid_sucursal()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getid_sucursal().toString();
				}
				if(evaluacionnomi.getid_sucursal()!=null)
				{
					strValorNuevo=evaluacionnomi.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getid_ejercicio().equals(evaluacionnomi.getEvaluacionNomiOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getid_ejercicio()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getid_ejercicio().toString();
				}
				if(evaluacionnomi.getid_ejercicio()!=null)
				{
					strValorNuevo=evaluacionnomi.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getid_periodo().equals(evaluacionnomi.getEvaluacionNomiOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getid_periodo()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getid_periodo().toString();
				}
				if(evaluacionnomi.getid_periodo()!=null)
				{
					strValorNuevo=evaluacionnomi.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getid_empleado().equals(evaluacionnomi.getEvaluacionNomiOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getid_empleado()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getid_empleado().toString();
				}
				if(evaluacionnomi.getid_empleado()!=null)
				{
					strValorNuevo=evaluacionnomi.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getid_empleado_evaluador().equals(evaluacionnomi.getEvaluacionNomiOriginal().getid_empleado_evaluador()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getid_empleado_evaluador()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getid_empleado_evaluador().toString();
				}
				if(evaluacionnomi.getid_empleado_evaluador()!=null)
				{
					strValorNuevo=evaluacionnomi.getid_empleado_evaluador().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getid_formato_nomi().equals(evaluacionnomi.getEvaluacionNomiOriginal().getid_formato_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getid_formato_nomi()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getid_formato_nomi().toString();
				}
				if(evaluacionnomi.getid_formato_nomi()!=null)
				{
					strValorNuevo=evaluacionnomi.getid_formato_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.IDFORMATONOMI,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getid_estructura().equals(evaluacionnomi.getEvaluacionNomiOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getid_estructura()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getid_estructura().toString();
				}
				if(evaluacionnomi.getid_estructura()!=null)
				{
					strValorNuevo=evaluacionnomi.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getfecha().equals(evaluacionnomi.getEvaluacionNomiOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getfecha()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getfecha().toString();
				}
				if(evaluacionnomi.getfecha()!=null)
				{
					strValorNuevo=evaluacionnomi.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getinstrucciones().equals(evaluacionnomi.getEvaluacionNomiOriginal().getinstrucciones()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getinstrucciones()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getinstrucciones();
				}
				if(evaluacionnomi.getinstrucciones()!=null)
				{
					strValorNuevo=evaluacionnomi.getinstrucciones() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.INSTRUCCIONES,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getdescripcion().equals(evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion();
				}
				if(evaluacionnomi.getdescripcion()!=null)
				{
					strValorNuevo=evaluacionnomi.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getdescripcion2().equals(evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion2()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion2();
				}
				if(evaluacionnomi.getdescripcion2()!=null)
				{
					strValorNuevo=evaluacionnomi.getdescripcion2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.DESCRIPCION2,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getdescripcion3().equals(evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion3()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion3();
				}
				if(evaluacionnomi.getdescripcion3()!=null)
				{
					strValorNuevo=evaluacionnomi.getdescripcion3() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.DESCRIPCION3,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionnomi.getIsNew()||!evaluacionnomi.getdescripcion4().equals(evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion4()!=null)
				{
					strValorActual=evaluacionnomi.getEvaluacionNomiOriginal().getdescripcion4();
				}
				if(evaluacionnomi.getdescripcion4()!=null)
				{
					strValorNuevo=evaluacionnomi.getdescripcion4() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionNomiConstantesFunciones.DESCRIPCION4,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEvaluacionNomiRelacionesWithConnection(EvaluacionNomi evaluacionnomi,List<DetalleEvaluacionNomi> detalleevaluacionnomis) throws Exception {

		if(!evaluacionnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEvaluacionNomiRelacionesBase(evaluacionnomi,detalleevaluacionnomis,true);
		}
	}

	public void saveEvaluacionNomiRelaciones(EvaluacionNomi evaluacionnomi,List<DetalleEvaluacionNomi> detalleevaluacionnomis)throws Exception {

		if(!evaluacionnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEvaluacionNomiRelacionesBase(evaluacionnomi,detalleevaluacionnomis,false);
		}
	}

	public void saveEvaluacionNomiRelacionesBase(EvaluacionNomi evaluacionnomi,List<DetalleEvaluacionNomi> detalleevaluacionnomis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EvaluacionNomi-saveRelacionesWithConnection");}
	
			evaluacionnomi.setDetalleEvaluacionNomis(detalleevaluacionnomis);

			this.setEvaluacionNomi(evaluacionnomi);

			if(EvaluacionNomiLogicAdditional.validarSaveRelaciones(evaluacionnomi,this)) {

				EvaluacionNomiLogicAdditional.updateRelacionesToSave(evaluacionnomi,this);

				if((evaluacionnomi.getIsNew()||evaluacionnomi.getIsChanged())&&!evaluacionnomi.getIsDeleted()) {
					this.saveEvaluacionNomi();
					this.saveEvaluacionNomiRelacionesDetalles(detalleevaluacionnomis);

				} else if(evaluacionnomi.getIsDeleted()) {
					this.saveEvaluacionNomiRelacionesDetalles(detalleevaluacionnomis);
					this.saveEvaluacionNomi();
				}

				EvaluacionNomiLogicAdditional.updateRelacionesToSaveAfter(evaluacionnomi,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleEvaluacionNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleEvaluacionNomis(detalleevaluacionnomis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEvaluacionNomiRelacionesDetalles(List<DetalleEvaluacionNomi> detalleevaluacionnomis)throws Exception {
		try {
	

			Long idEvaluacionNomiActual=this.getEvaluacionNomi().getId();

			DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic_Desde_EvaluacionNomi=new DetalleEvaluacionNomiLogic();
			detalleevaluacionnomiLogic_Desde_EvaluacionNomi.setDetalleEvaluacionNomis(detalleevaluacionnomis);

			detalleevaluacionnomiLogic_Desde_EvaluacionNomi.setConnexion(this.getConnexion());
			detalleevaluacionnomiLogic_Desde_EvaluacionNomi.setDatosCliente(this.datosCliente);

			for(DetalleEvaluacionNomi detalleevaluacionnomi_Desde_EvaluacionNomi:detalleevaluacionnomiLogic_Desde_EvaluacionNomi.getDetalleEvaluacionNomis()) {
				detalleevaluacionnomi_Desde_EvaluacionNomi.setid_evaluacion_nomi(idEvaluacionNomiActual);
			}

			detalleevaluacionnomiLogic_Desde_EvaluacionNomi.saveDetalleEvaluacionNomis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEvaluacionNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EvaluacionNomiConstantesFunciones.getClassesForeignKeysOfEvaluacionNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EvaluacionNomiConstantesFunciones.getClassesRelationshipsOfEvaluacionNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

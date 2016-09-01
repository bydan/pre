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
import com.bydan.erp.cartera.util.ReferenciaComercialConstantesFunciones;
import com.bydan.erp.cartera.util.ReferenciaComercialParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ReferenciaComercialParameterGeneral;
import com.bydan.erp.cartera.business.entity.ReferenciaComercial;
import com.bydan.erp.cartera.business.logic.ReferenciaComercialLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ReferenciaComercialLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ReferenciaComercialLogic.class);
	
	protected ReferenciaComercialDataAccess referenciacomercialDataAccess; 	
	protected ReferenciaComercial referenciacomercial;
	protected List<ReferenciaComercial> referenciacomercials;
	protected Object referenciacomercialObject;	
	protected List<Object> referenciacomercialsObject;
	
	public static ClassValidator<ReferenciaComercial> referenciacomercialValidator = new ClassValidator<ReferenciaComercial>(ReferenciaComercial.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ReferenciaComercialLogicAdditional referenciacomercialLogicAdditional=null;
	
	public ReferenciaComercialLogicAdditional getReferenciaComercialLogicAdditional() {
		return this.referenciacomercialLogicAdditional;
	}
	
	public void setReferenciaComercialLogicAdditional(ReferenciaComercialLogicAdditional referenciacomercialLogicAdditional) {
		try {
			this.referenciacomercialLogicAdditional=referenciacomercialLogicAdditional;
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
	
	
	
	
	public  ReferenciaComercialLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.referenciacomercialDataAccess = new ReferenciaComercialDataAccess();
			
			this.referenciacomercials= new ArrayList<ReferenciaComercial>();
			this.referenciacomercial= new ReferenciaComercial();
			
			this.referenciacomercialObject=new Object();
			this.referenciacomercialsObject=new ArrayList<Object>();
				
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
			
			this.referenciacomercialDataAccess.setConnexionType(this.connexionType);
			this.referenciacomercialDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ReferenciaComercialLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.referenciacomercialDataAccess = new ReferenciaComercialDataAccess();
			this.referenciacomercials= new ArrayList<ReferenciaComercial>();
			this.referenciacomercial= new ReferenciaComercial();
			this.referenciacomercialObject=new Object();
			this.referenciacomercialsObject=new ArrayList<Object>();
			
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
			
			this.referenciacomercialDataAccess.setConnexionType(this.connexionType);
			this.referenciacomercialDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ReferenciaComercial getReferenciaComercial() throws Exception {	
		ReferenciaComercialLogicAdditional.checkReferenciaComercialToGet(referenciacomercial,this.datosCliente,this.arrDatoGeneral);
		ReferenciaComercialLogicAdditional.updateReferenciaComercialToGet(referenciacomercial,this.arrDatoGeneral);
		
		return referenciacomercial;
	}
		
	public void setReferenciaComercial(ReferenciaComercial newReferenciaComercial) {
		this.referenciacomercial = newReferenciaComercial;
	}
	
	public ReferenciaComercialDataAccess getReferenciaComercialDataAccess() {
		return referenciacomercialDataAccess;
	}
	
	public void setReferenciaComercialDataAccess(ReferenciaComercialDataAccess newreferenciacomercialDataAccess) {
		this.referenciacomercialDataAccess = newreferenciacomercialDataAccess;
	}
	
	public List<ReferenciaComercial> getReferenciaComercials() throws Exception {		
		this.quitarReferenciaComercialsNulos();
		
		ReferenciaComercialLogicAdditional.checkReferenciaComercialToGets(referenciacomercials,this.datosCliente,this.arrDatoGeneral);
		
		for (ReferenciaComercial referenciacomercialLocal: referenciacomercials ) {
			ReferenciaComercialLogicAdditional.updateReferenciaComercialToGet(referenciacomercialLocal,this.arrDatoGeneral);
		}
		
		return referenciacomercials;
	}
	
	public void setReferenciaComercials(List<ReferenciaComercial> newReferenciaComercials) {
		this.referenciacomercials = newReferenciaComercials;
	}
	
	public Object getReferenciaComercialObject() {	
		this.referenciacomercialObject=this.referenciacomercialDataAccess.getEntityObject();
		return this.referenciacomercialObject;
	}
		
	public void setReferenciaComercialObject(Object newReferenciaComercialObject) {
		this.referenciacomercialObject = newReferenciaComercialObject;
	}
	
	public List<Object> getReferenciaComercialsObject() {		
		this.referenciacomercialsObject=this.referenciacomercialDataAccess.getEntitiesObject();
		return this.referenciacomercialsObject;
	}
		
	public void setReferenciaComercialsObject(List<Object> newReferenciaComercialsObject) {
		this.referenciacomercialsObject = newReferenciaComercialsObject;
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
		
		if(this.referenciacomercialDataAccess!=null) {
			this.referenciacomercialDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			referenciacomercialDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			referenciacomercialDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		referenciacomercial = new  ReferenciaComercial();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			referenciacomercial=referenciacomercialDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciacomercial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercial);
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
		referenciacomercial = new  ReferenciaComercial();
		  		  
        try {
			
			referenciacomercial=referenciacomercialDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciacomercial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		referenciacomercial = new  ReferenciaComercial();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			referenciacomercial=referenciacomercialDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciacomercial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercial);
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
		referenciacomercial = new  ReferenciaComercial();
		  		  
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
		referenciacomercial = new  ReferenciaComercial();
		  		  
        try {
			
			referenciacomercial=referenciacomercialDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciacomercial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		referenciacomercial = new  ReferenciaComercial();
		  		  
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
		referenciacomercial = new  ReferenciaComercial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =referenciacomercialDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referenciacomercial = new  ReferenciaComercial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=referenciacomercialDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		referenciacomercial = new  ReferenciaComercial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =referenciacomercialDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referenciacomercial = new  ReferenciaComercial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=referenciacomercialDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		referenciacomercial = new  ReferenciaComercial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =referenciacomercialDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referenciacomercial = new  ReferenciaComercial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=referenciacomercialDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
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
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		  		  
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
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		  		  
        try {			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarReferenciaComercial(referenciacomercials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		  		  
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
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
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
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		  		  
        try {
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
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
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
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
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		referenciacomercial = new  ReferenciaComercial();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercial=referenciacomercialDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercial);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercial);
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
		referenciacomercial = new  ReferenciaComercial();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercial=referenciacomercialDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercial);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercials=referenciacomercialDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
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
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		  		  
        try {
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercials=referenciacomercialDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosReferenciaComercialsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getTodosReferenciaComercialsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
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
	
	public  void  getTodosReferenciaComercials(String sFinalQuery,Pagination pagination)throws Exception {
		referenciacomercials = new  ArrayList<ReferenciaComercial>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarReferenciaComercial(referenciacomercials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarReferenciaComercial(ReferenciaComercial referenciacomercial) throws Exception {
		Boolean estaValidado=false;
		
		if(referenciacomercial.getIsNew() || referenciacomercial.getIsChanged()) { 
			this.invalidValues = referenciacomercialValidator.getInvalidValues(referenciacomercial);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(referenciacomercial);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarReferenciaComercial(List<ReferenciaComercial> ReferenciaComercials) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ReferenciaComercial referenciacomercialLocal:referenciacomercials) {				
			estaValidadoObjeto=this.validarGuardarReferenciaComercial(referenciacomercialLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarReferenciaComercial(List<ReferenciaComercial> ReferenciaComercials) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarReferenciaComercial(referenciacomercials)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarReferenciaComercial(ReferenciaComercial ReferenciaComercial) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarReferenciaComercial(referenciacomercial)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ReferenciaComercial referenciacomercial) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+referenciacomercial.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ReferenciaComercialConstantesFunciones.getReferenciaComercialLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"referenciacomercial","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ReferenciaComercialConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ReferenciaComercialConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveReferenciaComercialWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-saveReferenciaComercialWithConnection");connexion.begin();			
			
			ReferenciaComercialLogicAdditional.checkReferenciaComercialToSave(this.referenciacomercial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ReferenciaComercialLogicAdditional.updateReferenciaComercialToSave(this.referenciacomercial,this.arrDatoGeneral);
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.referenciacomercial,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowReferenciaComercial();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarReferenciaComercial(this.referenciacomercial)) {
				ReferenciaComercialDataAccess.save(this.referenciacomercial, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.referenciacomercial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ReferenciaComercialLogicAdditional.checkReferenciaComercialToSaveAfter(this.referenciacomercial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowReferenciaComercial();
			
			connexion.commit();			
			
			if(this.referenciacomercial.getIsDeleted()) {
				this.referenciacomercial=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveReferenciaComercial()throws Exception {	
		try {	
			
			ReferenciaComercialLogicAdditional.checkReferenciaComercialToSave(this.referenciacomercial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ReferenciaComercialLogicAdditional.updateReferenciaComercialToSave(this.referenciacomercial,this.arrDatoGeneral);
			
			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.referenciacomercial,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarReferenciaComercial(this.referenciacomercial)) {			
				ReferenciaComercialDataAccess.save(this.referenciacomercial, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.referenciacomercial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ReferenciaComercialLogicAdditional.checkReferenciaComercialToSaveAfter(this.referenciacomercial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.referenciacomercial.getIsDeleted()) {
				this.referenciacomercial=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveReferenciaComercialsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-saveReferenciaComercialsWithConnection");connexion.begin();			
			
			ReferenciaComercialLogicAdditional.checkReferenciaComercialToSaves(referenciacomercials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowReferenciaComercials();
			
			Boolean validadoTodosReferenciaComercial=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ReferenciaComercial referenciacomercialLocal:referenciacomercials) {		
				if(referenciacomercialLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ReferenciaComercialLogicAdditional.updateReferenciaComercialToSave(referenciacomercialLocal,this.arrDatoGeneral);
	        	
				ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),referenciacomercialLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarReferenciaComercial(referenciacomercialLocal)) {
					ReferenciaComercialDataAccess.save(referenciacomercialLocal, connexion);				
				} else {
					validadoTodosReferenciaComercial=false;
				}
			}
			
			if(!validadoTodosReferenciaComercial) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ReferenciaComercialLogicAdditional.checkReferenciaComercialToSavesAfter(referenciacomercials,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowReferenciaComercials();
			
			connexion.commit();		
			
			this.quitarReferenciaComercialsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveReferenciaComercials()throws Exception {				
		 try {	
			ReferenciaComercialLogicAdditional.checkReferenciaComercialToSaves(referenciacomercials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosReferenciaComercial=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ReferenciaComercial referenciacomercialLocal:referenciacomercials) {				
				if(referenciacomercialLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ReferenciaComercialLogicAdditional.updateReferenciaComercialToSave(referenciacomercialLocal,this.arrDatoGeneral);
	        	
				ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),referenciacomercialLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarReferenciaComercial(referenciacomercialLocal)) {				
					ReferenciaComercialDataAccess.save(referenciacomercialLocal, connexion);				
				} else {
					validadoTodosReferenciaComercial=false;
				}
			}
			
			if(!validadoTodosReferenciaComercial) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ReferenciaComercialLogicAdditional.checkReferenciaComercialToSavesAfter(referenciacomercials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarReferenciaComercialsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReferenciaComercialParameterReturnGeneral procesarAccionReferenciaComercials(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ReferenciaComercial> referenciacomercials,ReferenciaComercialParameterReturnGeneral referenciacomercialParameterGeneral)throws Exception {
		 try {	
			ReferenciaComercialParameterReturnGeneral referenciacomercialReturnGeneral=new ReferenciaComercialParameterReturnGeneral();
	
			ReferenciaComercialLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,referenciacomercials,referenciacomercialParameterGeneral,referenciacomercialReturnGeneral);
			
			return referenciacomercialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReferenciaComercialParameterReturnGeneral procesarAccionReferenciaComercialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ReferenciaComercial> referenciacomercials,ReferenciaComercialParameterReturnGeneral referenciacomercialParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-procesarAccionReferenciaComercialsWithConnection");connexion.begin();			
			
			ReferenciaComercialParameterReturnGeneral referenciacomercialReturnGeneral=new ReferenciaComercialParameterReturnGeneral();
	
			ReferenciaComercialLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,referenciacomercials,referenciacomercialParameterGeneral,referenciacomercialReturnGeneral);
			
			this.connexion.commit();
			
			return referenciacomercialReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ReferenciaComercialParameterReturnGeneral procesarEventosReferenciaComercials(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ReferenciaComercial> referenciacomercials,ReferenciaComercial referenciacomercial,ReferenciaComercialParameterReturnGeneral referenciacomercialParameterGeneral,Boolean isEsNuevoReferenciaComercial,ArrayList<Classe> clases)throws Exception {
		 try {	
			ReferenciaComercialParameterReturnGeneral referenciacomercialReturnGeneral=new ReferenciaComercialParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				referenciacomercialReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ReferenciaComercialLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,referenciacomercials,referenciacomercial,referenciacomercialParameterGeneral,referenciacomercialReturnGeneral,isEsNuevoReferenciaComercial,clases);
			
			return referenciacomercialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ReferenciaComercialParameterReturnGeneral procesarEventosReferenciaComercialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ReferenciaComercial> referenciacomercials,ReferenciaComercial referenciacomercial,ReferenciaComercialParameterReturnGeneral referenciacomercialParameterGeneral,Boolean isEsNuevoReferenciaComercial,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-procesarEventosReferenciaComercialsWithConnection");connexion.begin();			
			
			ReferenciaComercialParameterReturnGeneral referenciacomercialReturnGeneral=new ReferenciaComercialParameterReturnGeneral();
	
			referenciacomercialReturnGeneral.setReferenciaComercial(referenciacomercial);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				referenciacomercialReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ReferenciaComercialLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,referenciacomercials,referenciacomercial,referenciacomercialParameterGeneral,referenciacomercialReturnGeneral,isEsNuevoReferenciaComercial,clases);
			
			this.connexion.commit();
			
			return referenciacomercialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ReferenciaComercialParameterReturnGeneral procesarImportacionReferenciaComercialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ReferenciaComercialParameterReturnGeneral referenciacomercialParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-procesarImportacionReferenciaComercialsWithConnection");connexion.begin();			
			
			ReferenciaComercialParameterReturnGeneral referenciacomercialReturnGeneral=new ReferenciaComercialParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.referenciacomercials=new ArrayList<ReferenciaComercial>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.referenciacomercial=new ReferenciaComercial();
				
				
				if(conColumnasBase) {this.referenciacomercial.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.referenciacomercial.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

			this.referenciacomercial.setnombreempresa(arrColumnas[iColumn++]);
				this.referenciacomercial.setcodigo_cliente(arrColumnas[iColumn++]);
				this.referenciacomercial.setcontacto(arrColumnas[iColumn++]);
				this.referenciacomercial.setarticulo_compra(arrColumnas[iColumn++]);
				this.referenciacomercial.setnumero_anios(Integer.parseInt(arrColumnas[iColumn++]));
				this.referenciacomercial.setnumero_meses(Integer.parseInt(arrColumnas[iColumn++]));
			this.referenciacomercial.setdireccion(arrColumnas[iColumn++]);
			this.referenciacomercial.settelefono(arrColumnas[iColumn++]);
			this.referenciacomercial.settelefonomovil(arrColumnas[iColumn++]);
				this.referenciacomercial.settelefonocodigoarea(arrColumnas[iColumn++]);
			this.referenciacomercial.setemail(arrColumnas[iColumn++]);
				this.referenciacomercial.setmonto(Double.parseDouble(arrColumnas[iColumn++]));
				this.referenciacomercial.setesactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.referenciacomercials.add(this.referenciacomercial);
			}
			
			this.saveReferenciaComercials();
			
			this.connexion.commit();
			
			referenciacomercialReturnGeneral.setConRetornoEstaProcesado(true);
			referenciacomercialReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return referenciacomercialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarReferenciaComercialsEliminados() throws Exception {				
		
		List<ReferenciaComercial> referenciacomercialsAux= new ArrayList<ReferenciaComercial>();
		
		for(ReferenciaComercial referenciacomercial:referenciacomercials) {
			if(!referenciacomercial.getIsDeleted()) {
				referenciacomercialsAux.add(referenciacomercial);
			}
		}
		
		referenciacomercials=referenciacomercialsAux;
	}
	
	public void quitarReferenciaComercialsNulos() throws Exception {				
		
		List<ReferenciaComercial> referenciacomercialsAux= new ArrayList<ReferenciaComercial>();
		
		for(ReferenciaComercial referenciacomercial : this.referenciacomercials) {
			if(referenciacomercial==null) {
				referenciacomercialsAux.add(referenciacomercial);
			}
		}
		
		//this.referenciacomercials=referenciacomercialsAux;
		
		this.referenciacomercials.removeAll(referenciacomercialsAux);
	}
	
	public void getSetVersionRowReferenciaComercialWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(referenciacomercial.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((referenciacomercial.getIsDeleted() || (referenciacomercial.getIsChanged()&&!referenciacomercial.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=referenciacomercialDataAccess.getSetVersionRowReferenciaComercial(connexion,referenciacomercial.getId());
				
				if(!referenciacomercial.getVersionRow().equals(timestamp)) {	
					referenciacomercial.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				referenciacomercial.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowReferenciaComercial()throws Exception {	
		
		if(referenciacomercial.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((referenciacomercial.getIsDeleted() || (referenciacomercial.getIsChanged()&&!referenciacomercial.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=referenciacomercialDataAccess.getSetVersionRowReferenciaComercial(connexion,referenciacomercial.getId());
			
			try {							
				if(!referenciacomercial.getVersionRow().equals(timestamp)) {	
					referenciacomercial.setVersionRow(timestamp);
				}
				
				referenciacomercial.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowReferenciaComercialsWithConnection()throws Exception {	
		if(referenciacomercials!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ReferenciaComercial referenciacomercialAux:referenciacomercials) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(referenciacomercialAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(referenciacomercialAux.getIsDeleted() || (referenciacomercialAux.getIsChanged()&&!referenciacomercialAux.getIsNew())) {
						
						timestamp=referenciacomercialDataAccess.getSetVersionRowReferenciaComercial(connexion,referenciacomercialAux.getId());
						
						if(!referenciacomercial.getVersionRow().equals(timestamp)) {	
							referenciacomercialAux.setVersionRow(timestamp);
						}
								
						referenciacomercialAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowReferenciaComercials()throws Exception {	
		if(referenciacomercials!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ReferenciaComercial referenciacomercialAux:referenciacomercials) {
					if(referenciacomercialAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(referenciacomercialAux.getIsDeleted() || (referenciacomercialAux.getIsChanged()&&!referenciacomercialAux.getIsNew())) {
						
						timestamp=referenciacomercialDataAccess.getSetVersionRowReferenciaComercial(connexion,referenciacomercialAux.getId());
						
						if(!referenciacomercialAux.getVersionRow().equals(timestamp)) {	
							referenciacomercialAux.setVersionRow(timestamp);
						}
						
													
						referenciacomercialAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ReferenciaComercialParameterReturnGeneral cargarCombosLoteForeignKeyReferenciaComercialWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoSectorEcono,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalTipoValoracion) throws Exception {
		ReferenciaComercialParameterReturnGeneral  referenciacomercialReturnGeneral =new ReferenciaComercialParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-cargarCombosLoteForeignKeyReferenciaComercialWithConnection");connexion.begin();
			
			referenciacomercialReturnGeneral =new ReferenciaComercialParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			referenciacomercialReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			referenciacomercialReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoSectorEcono> tiposectoreconosForeignKey=new ArrayList<TipoSectorEcono>();
			TipoSectorEconoLogic tiposectoreconoLogic=new TipoSectorEconoLogic();
			tiposectoreconoLogic.setConnexion(this.connexion);
			tiposectoreconoLogic.getTipoSectorEconoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoSectorEcono.equals("NONE")) {
				tiposectoreconoLogic.getTodosTipoSectorEconos(finalQueryGlobalTipoSectorEcono,new Pagination());
				tiposectoreconosForeignKey=tiposectoreconoLogic.getTipoSectorEconos();
			}

			referenciacomercialReturnGeneral.settiposectoreconosForeignKey(tiposectoreconosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			referenciacomercialReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			referenciacomercialReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<TipoValoracion> tipovaloracionsForeignKey=new ArrayList<TipoValoracion>();
			TipoValoracionLogic tipovaloracionLogic=new TipoValoracionLogic();
			tipovaloracionLogic.setConnexion(this.connexion);
			tipovaloracionLogic.getTipoValoracionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoValoracion.equals("NONE")) {
				tipovaloracionLogic.getTodosTipoValoracions(finalQueryGlobalTipoValoracion,new Pagination());
				tipovaloracionsForeignKey=tipovaloracionLogic.getTipoValoracions();
			}

			referenciacomercialReturnGeneral.settipovaloracionsForeignKey(tipovaloracionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return referenciacomercialReturnGeneral;
	}
	
	public ReferenciaComercialParameterReturnGeneral cargarCombosLoteForeignKeyReferenciaComercial(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoSectorEcono,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalTipoValoracion) throws Exception {
		ReferenciaComercialParameterReturnGeneral  referenciacomercialReturnGeneral =new ReferenciaComercialParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			referenciacomercialReturnGeneral =new ReferenciaComercialParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			referenciacomercialReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			referenciacomercialReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoSectorEcono> tiposectoreconosForeignKey=new ArrayList<TipoSectorEcono>();
			TipoSectorEconoLogic tiposectoreconoLogic=new TipoSectorEconoLogic();
			tiposectoreconoLogic.setConnexion(this.connexion);
			tiposectoreconoLogic.getTipoSectorEconoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoSectorEcono.equals("NONE")) {
				tiposectoreconoLogic.getTodosTipoSectorEconos(finalQueryGlobalTipoSectorEcono,new Pagination());
				tiposectoreconosForeignKey=tiposectoreconoLogic.getTipoSectorEconos();
			}

			referenciacomercialReturnGeneral.settiposectoreconosForeignKey(tiposectoreconosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			referenciacomercialReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			referenciacomercialReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<TipoValoracion> tipovaloracionsForeignKey=new ArrayList<TipoValoracion>();
			TipoValoracionLogic tipovaloracionLogic=new TipoValoracionLogic();
			tipovaloracionLogic.setConnexion(this.connexion);
			tipovaloracionLogic.getTipoValoracionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoValoracion.equals("NONE")) {
				tipovaloracionLogic.getTodosTipoValoracions(finalQueryGlobalTipoValoracion,new Pagination());
				tipovaloracionsForeignKey=tipovaloracionLogic.getTipoValoracions();
			}

			referenciacomercialReturnGeneral.settipovaloracionsForeignKey(tipovaloracionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return referenciacomercialReturnGeneral;
	}
	
	
	public void deepLoad(ReferenciaComercial referenciacomercial,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ReferenciaComercialLogicAdditional.updateReferenciaComercialToGet(referenciacomercial,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		referenciacomercial.setEmpresa(referenciacomercialDataAccess.getEmpresa(connexion,referenciacomercial));
		referenciacomercial.setCliente(referenciacomercialDataAccess.getCliente(connexion,referenciacomercial));
		referenciacomercial.setTipoSectorEcono(referenciacomercialDataAccess.getTipoSectorEcono(connexion,referenciacomercial));
		referenciacomercial.setPais(referenciacomercialDataAccess.getPais(connexion,referenciacomercial));
		referenciacomercial.setCiudad(referenciacomercialDataAccess.getCiudad(connexion,referenciacomercial));
		referenciacomercial.setTipoValoracion(referenciacomercialDataAccess.getTipoValoracion(connexion,referenciacomercial));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				referenciacomercial.setEmpresa(referenciacomercialDataAccess.getEmpresa(connexion,referenciacomercial));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				referenciacomercial.setCliente(referenciacomercialDataAccess.getCliente(connexion,referenciacomercial));
				continue;
			}

			if(clas.clas.equals(TipoSectorEcono.class)) {
				referenciacomercial.setTipoSectorEcono(referenciacomercialDataAccess.getTipoSectorEcono(connexion,referenciacomercial));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				referenciacomercial.setPais(referenciacomercialDataAccess.getPais(connexion,referenciacomercial));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				referenciacomercial.setCiudad(referenciacomercialDataAccess.getCiudad(connexion,referenciacomercial));
				continue;
			}

			if(clas.clas.equals(TipoValoracion.class)) {
				referenciacomercial.setTipoValoracion(referenciacomercialDataAccess.getTipoValoracion(connexion,referenciacomercial));
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
			referenciacomercial.setEmpresa(referenciacomercialDataAccess.getEmpresa(connexion,referenciacomercial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciacomercial.setCliente(referenciacomercialDataAccess.getCliente(connexion,referenciacomercial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoSectorEcono.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciacomercial.setTipoSectorEcono(referenciacomercialDataAccess.getTipoSectorEcono(connexion,referenciacomercial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciacomercial.setPais(referenciacomercialDataAccess.getPais(connexion,referenciacomercial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciacomercial.setCiudad(referenciacomercialDataAccess.getCiudad(connexion,referenciacomercial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoValoracion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciacomercial.setTipoValoracion(referenciacomercialDataAccess.getTipoValoracion(connexion,referenciacomercial));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		referenciacomercial.setEmpresa(referenciacomercialDataAccess.getEmpresa(connexion,referenciacomercial));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(referenciacomercial.getEmpresa(),isDeep,deepLoadType,clases);
				
		referenciacomercial.setCliente(referenciacomercialDataAccess.getCliente(connexion,referenciacomercial));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(referenciacomercial.getCliente(),isDeep,deepLoadType,clases);
				
		referenciacomercial.setTipoSectorEcono(referenciacomercialDataAccess.getTipoSectorEcono(connexion,referenciacomercial));
		TipoSectorEconoLogic tiposectoreconoLogic= new TipoSectorEconoLogic(connexion);
		tiposectoreconoLogic.deepLoad(referenciacomercial.getTipoSectorEcono(),isDeep,deepLoadType,clases);
				
		referenciacomercial.setPais(referenciacomercialDataAccess.getPais(connexion,referenciacomercial));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(referenciacomercial.getPais(),isDeep,deepLoadType,clases);
				
		referenciacomercial.setCiudad(referenciacomercialDataAccess.getCiudad(connexion,referenciacomercial));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(referenciacomercial.getCiudad(),isDeep,deepLoadType,clases);
				
		referenciacomercial.setTipoValoracion(referenciacomercialDataAccess.getTipoValoracion(connexion,referenciacomercial));
		TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
		tipovaloracionLogic.deepLoad(referenciacomercial.getTipoValoracion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				referenciacomercial.setEmpresa(referenciacomercialDataAccess.getEmpresa(connexion,referenciacomercial));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(referenciacomercial.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				referenciacomercial.setCliente(referenciacomercialDataAccess.getCliente(connexion,referenciacomercial));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(referenciacomercial.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoSectorEcono.class)) {
				referenciacomercial.setTipoSectorEcono(referenciacomercialDataAccess.getTipoSectorEcono(connexion,referenciacomercial));
				TipoSectorEconoLogic tiposectoreconoLogic= new TipoSectorEconoLogic(connexion);
				tiposectoreconoLogic.deepLoad(referenciacomercial.getTipoSectorEcono(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				referenciacomercial.setPais(referenciacomercialDataAccess.getPais(connexion,referenciacomercial));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(referenciacomercial.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				referenciacomercial.setCiudad(referenciacomercialDataAccess.getCiudad(connexion,referenciacomercial));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(referenciacomercial.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoValoracion.class)) {
				referenciacomercial.setTipoValoracion(referenciacomercialDataAccess.getTipoValoracion(connexion,referenciacomercial));
				TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
				tipovaloracionLogic.deepLoad(referenciacomercial.getTipoValoracion(),isDeep,deepLoadType,clases);				
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
			referenciacomercial.setEmpresa(referenciacomercialDataAccess.getEmpresa(connexion,referenciacomercial));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(referenciacomercial.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciacomercial.setCliente(referenciacomercialDataAccess.getCliente(connexion,referenciacomercial));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(referenciacomercial.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoSectorEcono.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciacomercial.setTipoSectorEcono(referenciacomercialDataAccess.getTipoSectorEcono(connexion,referenciacomercial));
			TipoSectorEconoLogic tiposectoreconoLogic= new TipoSectorEconoLogic(connexion);
			tiposectoreconoLogic.deepLoad(referenciacomercial.getTipoSectorEcono(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciacomercial.setPais(referenciacomercialDataAccess.getPais(connexion,referenciacomercial));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(referenciacomercial.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciacomercial.setCiudad(referenciacomercialDataAccess.getCiudad(connexion,referenciacomercial));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(referenciacomercial.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoValoracion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciacomercial.setTipoValoracion(referenciacomercialDataAccess.getTipoValoracion(connexion,referenciacomercial));
			TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
			tipovaloracionLogic.deepLoad(referenciacomercial.getTipoValoracion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ReferenciaComercial referenciacomercial,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ReferenciaComercialLogicAdditional.updateReferenciaComercialToSave(referenciacomercial,this.arrDatoGeneral);
			
ReferenciaComercialDataAccess.save(referenciacomercial, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(referenciacomercial.getEmpresa(),connexion);

		ClienteDataAccess.save(referenciacomercial.getCliente(),connexion);

		TipoSectorEconoDataAccess.save(referenciacomercial.getTipoSectorEcono(),connexion);

		PaisDataAccess.save(referenciacomercial.getPais(),connexion);

		CiudadDataAccess.save(referenciacomercial.getCiudad(),connexion);

		TipoValoracionDataAccess.save(referenciacomercial.getTipoValoracion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(referenciacomercial.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(referenciacomercial.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoSectorEcono.class)) {
				TipoSectorEconoDataAccess.save(referenciacomercial.getTipoSectorEcono(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(referenciacomercial.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(referenciacomercial.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoValoracion.class)) {
				TipoValoracionDataAccess.save(referenciacomercial.getTipoValoracion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(referenciacomercial.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(referenciacomercial.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(referenciacomercial.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(referenciacomercial.getCliente(),isDeep,deepLoadType,clases);
				

		TipoSectorEconoDataAccess.save(referenciacomercial.getTipoSectorEcono(),connexion);
		TipoSectorEconoLogic tiposectoreconoLogic= new TipoSectorEconoLogic(connexion);
		tiposectoreconoLogic.deepLoad(referenciacomercial.getTipoSectorEcono(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(referenciacomercial.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(referenciacomercial.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(referenciacomercial.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(referenciacomercial.getCiudad(),isDeep,deepLoadType,clases);
				

		TipoValoracionDataAccess.save(referenciacomercial.getTipoValoracion(),connexion);
		TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
		tipovaloracionLogic.deepLoad(referenciacomercial.getTipoValoracion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(referenciacomercial.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(referenciacomercial.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(referenciacomercial.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(referenciacomercial.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoSectorEcono.class)) {
				TipoSectorEconoDataAccess.save(referenciacomercial.getTipoSectorEcono(),connexion);
				TipoSectorEconoLogic tiposectoreconoLogic= new TipoSectorEconoLogic(connexion);
				tiposectoreconoLogic.deepSave(referenciacomercial.getTipoSectorEcono(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(referenciacomercial.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(referenciacomercial.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(referenciacomercial.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(referenciacomercial.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoValoracion.class)) {
				TipoValoracionDataAccess.save(referenciacomercial.getTipoValoracion(),connexion);
				TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
				tipovaloracionLogic.deepSave(referenciacomercial.getTipoValoracion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ReferenciaComercial.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(referenciacomercial);
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
			this.deepLoad(this.referenciacomercial,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ReferenciaComercial.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(referenciacomercials!=null) {
				for(ReferenciaComercial referenciacomercial:referenciacomercials) {
					this.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(referenciacomercials);
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
			if(referenciacomercials!=null) {
				for(ReferenciaComercial referenciacomercial:referenciacomercials) {
					this.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(referenciacomercials);
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
			this.getNewConnexionToDeep(ReferenciaComercial.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(referenciacomercial,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ReferenciaComercial.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(referenciacomercials!=null) {
				for(ReferenciaComercial referenciacomercial:referenciacomercials) {
					this.deepSave(referenciacomercial,isDeep,deepLoadType,clases);
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
			if(referenciacomercials!=null) {
				for(ReferenciaComercial referenciacomercial:referenciacomercials) {
					this.deepSave(referenciacomercial,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getReferenciaComercialsFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long idciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,idciudad,ReferenciaComercialConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaComercialsFK_IdCiudad(String sFinalQuery,Pagination pagination,Long idciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,idciudad,ReferenciaComercialConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaComercialsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,ReferenciaComercialConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaComercialsFK_IdCliente(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,ReferenciaComercialConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaComercialsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ReferenciaComercialConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaComercialsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ReferenciaComercialConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaComercialsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ReferenciaComercialConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaComercialsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ReferenciaComercialConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaComercialsFK_IdTipoValoracionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_valoracion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoValoracion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoValoracion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_valoracion,ReferenciaComercialConstantesFunciones.IDTIPOVALORACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoValoracion);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoValoracion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaComercialsFK_IdTipoValoracion(String sFinalQuery,Pagination pagination,Long id_tipo_valoracion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoValoracion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoValoracion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_valoracion,ReferenciaComercialConstantesFunciones.IDTIPOVALORACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoValoracion);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoValoracion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaComercialsFK_IdValorClienteSectorEconomicoWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclientesectoreconomico)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaComercial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoSectorEcono= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoSectorEcono.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientesectoreconomico,ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoSectorEcono);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteSectorEconomico","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaComercialsFK_IdValorClienteSectorEconomico(String sFinalQuery,Pagination pagination,Long idvalorclientesectoreconomico)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoSectorEcono= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoSectorEcono.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientesectoreconomico,ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoSectorEcono);

			ReferenciaComercialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteSectorEconomico","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(this.referenciacomercials);
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
			if(ReferenciaComercialConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaComercialDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ReferenciaComercial referenciacomercial,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ReferenciaComercialConstantesFunciones.ISCONAUDITORIA) {
				if(referenciacomercial.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaComercialDataAccess.TABLENAME, referenciacomercial.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ReferenciaComercialConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ReferenciaComercialLogic.registrarAuditoriaDetallesReferenciaComercial(connexion,referenciacomercial,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(referenciacomercial.getIsDeleted()) {
					/*if(!referenciacomercial.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ReferenciaComercialDataAccess.TABLENAME, referenciacomercial.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ReferenciaComercialLogic.registrarAuditoriaDetallesReferenciaComercial(connexion,referenciacomercial,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaComercialDataAccess.TABLENAME, referenciacomercial.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(referenciacomercial.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaComercialDataAccess.TABLENAME, referenciacomercial.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ReferenciaComercialConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ReferenciaComercialLogic.registrarAuditoriaDetallesReferenciaComercial(connexion,referenciacomercial,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesReferenciaComercial(Connexion connexion,ReferenciaComercial referenciacomercial)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getid_empresa().equals(referenciacomercial.getReferenciaComercialOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getid_empresa()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getid_empresa().toString();
				}
				if(referenciacomercial.getid_empresa()!=null)
				{
					strValorNuevo=referenciacomercial.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getidcliente().equals(referenciacomercial.getReferenciaComercialOriginal().getidcliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getidcliente()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getidcliente().toString();
				}
				if(referenciacomercial.getidcliente()!=null)
				{
					strValorNuevo=referenciacomercial.getidcliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getidvalorclientesectoreconomico().equals(referenciacomercial.getReferenciaComercialOriginal().getidvalorclientesectoreconomico()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getidvalorclientesectoreconomico()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getidvalorclientesectoreconomico().toString();
				}
				if(referenciacomercial.getidvalorclientesectoreconomico()!=null)
				{
					strValorNuevo=referenciacomercial.getidvalorclientesectoreconomico().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getid_pais().equals(referenciacomercial.getReferenciaComercialOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getid_pais()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getid_pais().toString();
				}
				if(referenciacomercial.getid_pais()!=null)
				{
					strValorNuevo=referenciacomercial.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getidciudad().equals(referenciacomercial.getReferenciaComercialOriginal().getidciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getidciudad()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getidciudad().toString();
				}
				if(referenciacomercial.getidciudad()!=null)
				{
					strValorNuevo=referenciacomercial.getidciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getnombreempresa().equals(referenciacomercial.getReferenciaComercialOriginal().getnombreempresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getnombreempresa()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getnombreempresa();
				}
				if(referenciacomercial.getnombreempresa()!=null)
				{
					strValorNuevo=referenciacomercial.getnombreempresa() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.NOMBREEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getcodigo_cliente().equals(referenciacomercial.getReferenciaComercialOriginal().getcodigo_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getcodigo_cliente()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getcodigo_cliente();
				}
				if(referenciacomercial.getcodigo_cliente()!=null)
				{
					strValorNuevo=referenciacomercial.getcodigo_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.CODIGOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getcontacto().equals(referenciacomercial.getReferenciaComercialOriginal().getcontacto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getcontacto()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getcontacto();
				}
				if(referenciacomercial.getcontacto()!=null)
				{
					strValorNuevo=referenciacomercial.getcontacto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.CONTACTO,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getarticulo_compra().equals(referenciacomercial.getReferenciaComercialOriginal().getarticulo_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getarticulo_compra()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getarticulo_compra();
				}
				if(referenciacomercial.getarticulo_compra()!=null)
				{
					strValorNuevo=referenciacomercial.getarticulo_compra() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.ARTICULOCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getnumero_anios().equals(referenciacomercial.getReferenciaComercialOriginal().getnumero_anios()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getnumero_anios()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getnumero_anios().toString();
				}
				if(referenciacomercial.getnumero_anios()!=null)
				{
					strValorNuevo=referenciacomercial.getnumero_anios().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.NUMEROANIOS,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getnumero_meses().equals(referenciacomercial.getReferenciaComercialOriginal().getnumero_meses()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getnumero_meses()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getnumero_meses().toString();
				}
				if(referenciacomercial.getnumero_meses()!=null)
				{
					strValorNuevo=referenciacomercial.getnumero_meses().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.NUMEROMESES,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getid_tipo_valoracion().equals(referenciacomercial.getReferenciaComercialOriginal().getid_tipo_valoracion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getid_tipo_valoracion()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getid_tipo_valoracion().toString();
				}
				if(referenciacomercial.getid_tipo_valoracion()!=null)
				{
					strValorNuevo=referenciacomercial.getid_tipo_valoracion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.IDTIPOVALORACION,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getdireccion().equals(referenciacomercial.getReferenciaComercialOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getdireccion()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getdireccion();
				}
				if(referenciacomercial.getdireccion()!=null)
				{
					strValorNuevo=referenciacomercial.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.gettelefono().equals(referenciacomercial.getReferenciaComercialOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().gettelefono()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().gettelefono();
				}
				if(referenciacomercial.gettelefono()!=null)
				{
					strValorNuevo=referenciacomercial.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.gettelefonomovil().equals(referenciacomercial.getReferenciaComercialOriginal().gettelefonomovil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().gettelefonomovil()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().gettelefonomovil();
				}
				if(referenciacomercial.gettelefonomovil()!=null)
				{
					strValorNuevo=referenciacomercial.gettelefonomovil() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.TELEFONOMOVIL,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.gettelefonocodigoarea().equals(referenciacomercial.getReferenciaComercialOriginal().gettelefonocodigoarea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().gettelefonocodigoarea()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().gettelefonocodigoarea();
				}
				if(referenciacomercial.gettelefonocodigoarea()!=null)
				{
					strValorNuevo=referenciacomercial.gettelefonocodigoarea() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.TELEFONOCODIGOAREA,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getemail().equals(referenciacomercial.getReferenciaComercialOriginal().getemail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getemail()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getemail();
				}
				if(referenciacomercial.getemail()!=null)
				{
					strValorNuevo=referenciacomercial.getemail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.EMAIL,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getmonto().equals(referenciacomercial.getReferenciaComercialOriginal().getmonto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getmonto()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getmonto().toString();
				}
				if(referenciacomercial.getmonto()!=null)
				{
					strValorNuevo=referenciacomercial.getmonto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.MONTO,strValorActual,strValorNuevo);
			}	
			
			if(referenciacomercial.getIsNew()||!referenciacomercial.getesactivo().equals(referenciacomercial.getReferenciaComercialOriginal().getesactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciacomercial.getReferenciaComercialOriginal().getesactivo()!=null)
				{
					strValorActual=referenciacomercial.getReferenciaComercialOriginal().getesactivo().toString();
				}
				if(referenciacomercial.getesactivo()!=null)
				{
					strValorNuevo=referenciacomercial.getesactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaComercialConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveReferenciaComercialRelacionesWithConnection(ReferenciaComercial referenciacomercial) throws Exception {

		if(!referenciacomercial.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveReferenciaComercialRelacionesBase(referenciacomercial,true);
		}
	}

	public void saveReferenciaComercialRelaciones(ReferenciaComercial referenciacomercial)throws Exception {

		if(!referenciacomercial.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveReferenciaComercialRelacionesBase(referenciacomercial,false);
		}
	}

	public void saveReferenciaComercialRelacionesBase(ReferenciaComercial referenciacomercial,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ReferenciaComercial-saveRelacionesWithConnection");}
	

			this.setReferenciaComercial(referenciacomercial);

			if(ReferenciaComercialLogicAdditional.validarSaveRelaciones(referenciacomercial,this)) {

				ReferenciaComercialLogicAdditional.updateRelacionesToSave(referenciacomercial,this);

				if((referenciacomercial.getIsNew()||referenciacomercial.getIsChanged())&&!referenciacomercial.getIsDeleted()) {
					this.saveReferenciaComercial();
					this.saveReferenciaComercialRelacionesDetalles();

				} else if(referenciacomercial.getIsDeleted()) {
					this.saveReferenciaComercialRelacionesDetalles();
					this.saveReferenciaComercial();
				}

				ReferenciaComercialLogicAdditional.updateRelacionesToSaveAfter(referenciacomercial,this);

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
	
	
	private void saveReferenciaComercialRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfReferenciaComercial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ReferenciaComercialConstantesFunciones.getClassesForeignKeysOfReferenciaComercial(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferenciaComercial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ReferenciaComercialConstantesFunciones.getClassesRelationshipsOfReferenciaComercial(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.AsistenciaMensualConstantesFunciones;
import com.bydan.erp.nomina.util.AsistenciaMensualParameterReturnGeneral;
//import com.bydan.erp.nomina.util.AsistenciaMensualParameterGeneral;
import com.bydan.erp.nomina.business.entity.AsistenciaMensual;
import com.bydan.erp.nomina.business.logic.AsistenciaMensualLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class AsistenciaMensualLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AsistenciaMensualLogic.class);
	
	protected AsistenciaMensualDataAccess asistenciamensualDataAccess; 	
	protected AsistenciaMensual asistenciamensual;
	protected List<AsistenciaMensual> asistenciamensuals;
	protected Object asistenciamensualObject;	
	protected List<Object> asistenciamensualsObject;
	
	public static ClassValidator<AsistenciaMensual> asistenciamensualValidator = new ClassValidator<AsistenciaMensual>(AsistenciaMensual.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AsistenciaMensualLogicAdditional asistenciamensualLogicAdditional=null;
	
	public AsistenciaMensualLogicAdditional getAsistenciaMensualLogicAdditional() {
		return this.asistenciamensualLogicAdditional;
	}
	
	public void setAsistenciaMensualLogicAdditional(AsistenciaMensualLogicAdditional asistenciamensualLogicAdditional) {
		try {
			this.asistenciamensualLogicAdditional=asistenciamensualLogicAdditional;
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
	
	
	
	
	public  AsistenciaMensualLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.asistenciamensualDataAccess = new AsistenciaMensualDataAccess();
			
			this.asistenciamensuals= new ArrayList<AsistenciaMensual>();
			this.asistenciamensual= new AsistenciaMensual();
			
			this.asistenciamensualObject=new Object();
			this.asistenciamensualsObject=new ArrayList<Object>();
				
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
			
			this.asistenciamensualDataAccess.setConnexionType(this.connexionType);
			this.asistenciamensualDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AsistenciaMensualLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.asistenciamensualDataAccess = new AsistenciaMensualDataAccess();
			this.asistenciamensuals= new ArrayList<AsistenciaMensual>();
			this.asistenciamensual= new AsistenciaMensual();
			this.asistenciamensualObject=new Object();
			this.asistenciamensualsObject=new ArrayList<Object>();
			
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
			
			this.asistenciamensualDataAccess.setConnexionType(this.connexionType);
			this.asistenciamensualDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AsistenciaMensual getAsistenciaMensual() throws Exception {	
		AsistenciaMensualLogicAdditional.checkAsistenciaMensualToGet(asistenciamensual,this.datosCliente,this.arrDatoGeneral);
		AsistenciaMensualLogicAdditional.updateAsistenciaMensualToGet(asistenciamensual,this.arrDatoGeneral);
		
		return asistenciamensual;
	}
		
	public void setAsistenciaMensual(AsistenciaMensual newAsistenciaMensual) {
		this.asistenciamensual = newAsistenciaMensual;
	}
	
	public AsistenciaMensualDataAccess getAsistenciaMensualDataAccess() {
		return asistenciamensualDataAccess;
	}
	
	public void setAsistenciaMensualDataAccess(AsistenciaMensualDataAccess newasistenciamensualDataAccess) {
		this.asistenciamensualDataAccess = newasistenciamensualDataAccess;
	}
	
	public List<AsistenciaMensual> getAsistenciaMensuals() throws Exception {		
		this.quitarAsistenciaMensualsNulos();
		
		AsistenciaMensualLogicAdditional.checkAsistenciaMensualToGets(asistenciamensuals,this.datosCliente,this.arrDatoGeneral);
		
		for (AsistenciaMensual asistenciamensualLocal: asistenciamensuals ) {
			AsistenciaMensualLogicAdditional.updateAsistenciaMensualToGet(asistenciamensualLocal,this.arrDatoGeneral);
		}
		
		return asistenciamensuals;
	}
	
	public void setAsistenciaMensuals(List<AsistenciaMensual> newAsistenciaMensuals) {
		this.asistenciamensuals = newAsistenciaMensuals;
	}
	
	public Object getAsistenciaMensualObject() {	
		this.asistenciamensualObject=this.asistenciamensualDataAccess.getEntityObject();
		return this.asistenciamensualObject;
	}
		
	public void setAsistenciaMensualObject(Object newAsistenciaMensualObject) {
		this.asistenciamensualObject = newAsistenciaMensualObject;
	}
	
	public List<Object> getAsistenciaMensualsObject() {		
		this.asistenciamensualsObject=this.asistenciamensualDataAccess.getEntitiesObject();
		return this.asistenciamensualsObject;
	}
		
	public void setAsistenciaMensualsObject(List<Object> newAsistenciaMensualsObject) {
		this.asistenciamensualsObject = newAsistenciaMensualsObject;
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
		
		if(this.asistenciamensualDataAccess!=null) {
			this.asistenciamensualDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			asistenciamensualDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			asistenciamensualDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		asistenciamensual = new  AsistenciaMensual();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			asistenciamensual=asistenciamensualDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciamensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensual);
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
		asistenciamensual = new  AsistenciaMensual();
		  		  
        try {
			
			asistenciamensual=asistenciamensualDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciamensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensual);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		asistenciamensual = new  AsistenciaMensual();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			asistenciamensual=asistenciamensualDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciamensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensual);
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
		asistenciamensual = new  AsistenciaMensual();
		  		  
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
		asistenciamensual = new  AsistenciaMensual();
		  		  
        try {
			
			asistenciamensual=asistenciamensualDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asistenciamensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensual);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		asistenciamensual = new  AsistenciaMensual();
		  		  
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
		asistenciamensual = new  AsistenciaMensual();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =asistenciamensualDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asistenciamensual = new  AsistenciaMensual();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=asistenciamensualDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		asistenciamensual = new  AsistenciaMensual();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =asistenciamensualDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asistenciamensual = new  AsistenciaMensual();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=asistenciamensualDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		asistenciamensual = new  AsistenciaMensual();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =asistenciamensualDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asistenciamensual = new  AsistenciaMensual();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=asistenciamensualDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
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
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		  		  
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
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		  		  
        try {			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAsistenciaMensual(asistenciamensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		  		  
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
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
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
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		  		  
        try {
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
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
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
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
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		asistenciamensual = new  AsistenciaMensual();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensual=asistenciamensualDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensual);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensual);
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
		asistenciamensual = new  AsistenciaMensual();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensual=asistenciamensualDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensual);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensual);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensuals=asistenciamensualDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
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
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		  		  
        try {
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensuals=asistenciamensualDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAsistenciaMensualsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getTodosAsistenciaMensualsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
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
	
	public  void  getTodosAsistenciaMensuals(String sFinalQuery,Pagination pagination)throws Exception {
		asistenciamensuals = new  ArrayList<AsistenciaMensual>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAsistenciaMensual(asistenciamensuals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAsistenciaMensual(AsistenciaMensual asistenciamensual) throws Exception {
		Boolean estaValidado=false;
		
		if(asistenciamensual.getIsNew() || asistenciamensual.getIsChanged()) { 
			this.invalidValues = asistenciamensualValidator.getInvalidValues(asistenciamensual);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(asistenciamensual);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAsistenciaMensual(List<AsistenciaMensual> AsistenciaMensuals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AsistenciaMensual asistenciamensualLocal:asistenciamensuals) {				
			estaValidadoObjeto=this.validarGuardarAsistenciaMensual(asistenciamensualLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAsistenciaMensual(List<AsistenciaMensual> AsistenciaMensuals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAsistenciaMensual(asistenciamensuals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAsistenciaMensual(AsistenciaMensual AsistenciaMensual) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAsistenciaMensual(asistenciamensual)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AsistenciaMensual asistenciamensual) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+asistenciamensual.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AsistenciaMensualConstantesFunciones.getAsistenciaMensualLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"asistenciamensual","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AsistenciaMensualConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AsistenciaMensualConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAsistenciaMensualWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-saveAsistenciaMensualWithConnection");connexion.begin();			
			
			AsistenciaMensualLogicAdditional.checkAsistenciaMensualToSave(this.asistenciamensual,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AsistenciaMensualLogicAdditional.updateAsistenciaMensualToSave(this.asistenciamensual,this.arrDatoGeneral);
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.asistenciamensual,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAsistenciaMensual();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAsistenciaMensual(this.asistenciamensual)) {
				AsistenciaMensualDataAccess.save(this.asistenciamensual, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.asistenciamensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AsistenciaMensualLogicAdditional.checkAsistenciaMensualToSaveAfter(this.asistenciamensual,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAsistenciaMensual();
			
			connexion.commit();			
			
			if(this.asistenciamensual.getIsDeleted()) {
				this.asistenciamensual=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAsistenciaMensual()throws Exception {	
		try {	
			
			AsistenciaMensualLogicAdditional.checkAsistenciaMensualToSave(this.asistenciamensual,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AsistenciaMensualLogicAdditional.updateAsistenciaMensualToSave(this.asistenciamensual,this.arrDatoGeneral);
			
			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.asistenciamensual,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAsistenciaMensual(this.asistenciamensual)) {			
				AsistenciaMensualDataAccess.save(this.asistenciamensual, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.asistenciamensual,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AsistenciaMensualLogicAdditional.checkAsistenciaMensualToSaveAfter(this.asistenciamensual,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.asistenciamensual.getIsDeleted()) {
				this.asistenciamensual=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAsistenciaMensualsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-saveAsistenciaMensualsWithConnection");connexion.begin();			
			
			AsistenciaMensualLogicAdditional.checkAsistenciaMensualToSaves(asistenciamensuals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAsistenciaMensuals();
			
			Boolean validadoTodosAsistenciaMensual=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AsistenciaMensual asistenciamensualLocal:asistenciamensuals) {		
				if(asistenciamensualLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AsistenciaMensualLogicAdditional.updateAsistenciaMensualToSave(asistenciamensualLocal,this.arrDatoGeneral);
	        	
				AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),asistenciamensualLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAsistenciaMensual(asistenciamensualLocal)) {
					AsistenciaMensualDataAccess.save(asistenciamensualLocal, connexion);				
				} else {
					validadoTodosAsistenciaMensual=false;
				}
			}
			
			if(!validadoTodosAsistenciaMensual) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AsistenciaMensualLogicAdditional.checkAsistenciaMensualToSavesAfter(asistenciamensuals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAsistenciaMensuals();
			
			connexion.commit();		
			
			this.quitarAsistenciaMensualsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAsistenciaMensuals()throws Exception {				
		 try {	
			AsistenciaMensualLogicAdditional.checkAsistenciaMensualToSaves(asistenciamensuals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAsistenciaMensual=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AsistenciaMensual asistenciamensualLocal:asistenciamensuals) {				
				if(asistenciamensualLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AsistenciaMensualLogicAdditional.updateAsistenciaMensualToSave(asistenciamensualLocal,this.arrDatoGeneral);
	        	
				AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),asistenciamensualLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAsistenciaMensual(asistenciamensualLocal)) {				
					AsistenciaMensualDataAccess.save(asistenciamensualLocal, connexion);				
				} else {
					validadoTodosAsistenciaMensual=false;
				}
			}
			
			if(!validadoTodosAsistenciaMensual) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AsistenciaMensualLogicAdditional.checkAsistenciaMensualToSavesAfter(asistenciamensuals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAsistenciaMensualsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AsistenciaMensualParameterReturnGeneral procesarAccionAsistenciaMensuals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AsistenciaMensual> asistenciamensuals,AsistenciaMensualParameterReturnGeneral asistenciamensualParameterGeneral)throws Exception {
		 try {	
			AsistenciaMensualParameterReturnGeneral asistenciamensualReturnGeneral=new AsistenciaMensualParameterReturnGeneral();
	
			AsistenciaMensualLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,asistenciamensuals,asistenciamensualParameterGeneral,asistenciamensualReturnGeneral);
			
			return asistenciamensualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AsistenciaMensualParameterReturnGeneral procesarAccionAsistenciaMensualsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AsistenciaMensual> asistenciamensuals,AsistenciaMensualParameterReturnGeneral asistenciamensualParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-procesarAccionAsistenciaMensualsWithConnection");connexion.begin();			
			
			AsistenciaMensualParameterReturnGeneral asistenciamensualReturnGeneral=new AsistenciaMensualParameterReturnGeneral();
	
			AsistenciaMensualLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,asistenciamensuals,asistenciamensualParameterGeneral,asistenciamensualReturnGeneral);
			
			this.connexion.commit();
			
			return asistenciamensualReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AsistenciaMensualParameterReturnGeneral procesarEventosAsistenciaMensuals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AsistenciaMensual> asistenciamensuals,AsistenciaMensual asistenciamensual,AsistenciaMensualParameterReturnGeneral asistenciamensualParameterGeneral,Boolean isEsNuevoAsistenciaMensual,ArrayList<Classe> clases)throws Exception {
		 try {	
			AsistenciaMensualParameterReturnGeneral asistenciamensualReturnGeneral=new AsistenciaMensualParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				asistenciamensualReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AsistenciaMensualLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,asistenciamensuals,asistenciamensual,asistenciamensualParameterGeneral,asistenciamensualReturnGeneral,isEsNuevoAsistenciaMensual,clases);
			
			return asistenciamensualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AsistenciaMensualParameterReturnGeneral procesarEventosAsistenciaMensualsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AsistenciaMensual> asistenciamensuals,AsistenciaMensual asistenciamensual,AsistenciaMensualParameterReturnGeneral asistenciamensualParameterGeneral,Boolean isEsNuevoAsistenciaMensual,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-procesarEventosAsistenciaMensualsWithConnection");connexion.begin();			
			
			AsistenciaMensualParameterReturnGeneral asistenciamensualReturnGeneral=new AsistenciaMensualParameterReturnGeneral();
	
			asistenciamensualReturnGeneral.setAsistenciaMensual(asistenciamensual);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				asistenciamensualReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AsistenciaMensualLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,asistenciamensuals,asistenciamensual,asistenciamensualParameterGeneral,asistenciamensualReturnGeneral,isEsNuevoAsistenciaMensual,clases);
			
			this.connexion.commit();
			
			return asistenciamensualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AsistenciaMensualParameterReturnGeneral procesarImportacionAsistenciaMensualsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AsistenciaMensualParameterReturnGeneral asistenciamensualParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-procesarImportacionAsistenciaMensualsWithConnection");connexion.begin();			
			
			AsistenciaMensualParameterReturnGeneral asistenciamensualReturnGeneral=new AsistenciaMensualParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.asistenciamensuals=new ArrayList<AsistenciaMensual>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.asistenciamensual=new AsistenciaMensual();
				
				
				if(conColumnasBase) {this.asistenciamensual.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.asistenciamensual.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.asistenciamensual.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_trabajo(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_atraso(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_faltas(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_permiso(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_extra25(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_extra50(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_extra100(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_extra150(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_extra0(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_enfermo(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_maternidad(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.sethoras_vacacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.setnumero_dias(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.setnumero_noches(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.setnumero_feriados(Double.parseDouble(arrColumnas[iColumn++]));
				this.asistenciamensual.setnumero_trabajo(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.asistenciamensuals.add(this.asistenciamensual);
			}
			
			this.saveAsistenciaMensuals();
			
			this.connexion.commit();
			
			asistenciamensualReturnGeneral.setConRetornoEstaProcesado(true);
			asistenciamensualReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return asistenciamensualReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAsistenciaMensualsEliminados() throws Exception {				
		
		List<AsistenciaMensual> asistenciamensualsAux= new ArrayList<AsistenciaMensual>();
		
		for(AsistenciaMensual asistenciamensual:asistenciamensuals) {
			if(!asistenciamensual.getIsDeleted()) {
				asistenciamensualsAux.add(asistenciamensual);
			}
		}
		
		asistenciamensuals=asistenciamensualsAux;
	}
	
	public void quitarAsistenciaMensualsNulos() throws Exception {				
		
		List<AsistenciaMensual> asistenciamensualsAux= new ArrayList<AsistenciaMensual>();
		
		for(AsistenciaMensual asistenciamensual : this.asistenciamensuals) {
			if(asistenciamensual==null) {
				asistenciamensualsAux.add(asistenciamensual);
			}
		}
		
		//this.asistenciamensuals=asistenciamensualsAux;
		
		this.asistenciamensuals.removeAll(asistenciamensualsAux);
	}
	
	public void getSetVersionRowAsistenciaMensualWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(asistenciamensual.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((asistenciamensual.getIsDeleted() || (asistenciamensual.getIsChanged()&&!asistenciamensual.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=asistenciamensualDataAccess.getSetVersionRowAsistenciaMensual(connexion,asistenciamensual.getId());
				
				if(!asistenciamensual.getVersionRow().equals(timestamp)) {	
					asistenciamensual.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				asistenciamensual.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAsistenciaMensual()throws Exception {	
		
		if(asistenciamensual.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((asistenciamensual.getIsDeleted() || (asistenciamensual.getIsChanged()&&!asistenciamensual.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=asistenciamensualDataAccess.getSetVersionRowAsistenciaMensual(connexion,asistenciamensual.getId());
			
			try {							
				if(!asistenciamensual.getVersionRow().equals(timestamp)) {	
					asistenciamensual.setVersionRow(timestamp);
				}
				
				asistenciamensual.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAsistenciaMensualsWithConnection()throws Exception {	
		if(asistenciamensuals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AsistenciaMensual asistenciamensualAux:asistenciamensuals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(asistenciamensualAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(asistenciamensualAux.getIsDeleted() || (asistenciamensualAux.getIsChanged()&&!asistenciamensualAux.getIsNew())) {
						
						timestamp=asistenciamensualDataAccess.getSetVersionRowAsistenciaMensual(connexion,asistenciamensualAux.getId());
						
						if(!asistenciamensual.getVersionRow().equals(timestamp)) {	
							asistenciamensualAux.setVersionRow(timestamp);
						}
								
						asistenciamensualAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAsistenciaMensuals()throws Exception {	
		if(asistenciamensuals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AsistenciaMensual asistenciamensualAux:asistenciamensuals) {
					if(asistenciamensualAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(asistenciamensualAux.getIsDeleted() || (asistenciamensualAux.getIsChanged()&&!asistenciamensualAux.getIsNew())) {
						
						timestamp=asistenciamensualDataAccess.getSetVersionRowAsistenciaMensual(connexion,asistenciamensualAux.getId());
						
						if(!asistenciamensualAux.getVersionRow().equals(timestamp)) {	
							asistenciamensualAux.setVersionRow(timestamp);
						}
						
													
						asistenciamensualAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AsistenciaMensualParameterReturnGeneral cargarCombosLoteForeignKeyAsistenciaMensualWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalCargo,String finalQueryGlobalEstructura,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		AsistenciaMensualParameterReturnGeneral  asistenciamensualReturnGeneral =new AsistenciaMensualParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-cargarCombosLoteForeignKeyAsistenciaMensualWithConnection");connexion.begin();
			
			asistenciamensualReturnGeneral =new AsistenciaMensualParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			asistenciamensualReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			asistenciamensualReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Cargo> cargosForeignKey=new ArrayList<Cargo>();
			CargoLogic cargoLogic=new CargoLogic();
			cargoLogic.setConnexion(this.connexion);
			cargoLogic.getCargoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCargo.equals("NONE")) {
				cargoLogic.getTodosCargos(finalQueryGlobalCargo,new Pagination());
				cargosForeignKey=cargoLogic.getCargos();
			}

			asistenciamensualReturnGeneral.setcargosForeignKey(cargosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			asistenciamensualReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			asistenciamensualReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			asistenciamensualReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return asistenciamensualReturnGeneral;
	}
	
	public AsistenciaMensualParameterReturnGeneral cargarCombosLoteForeignKeyAsistenciaMensual(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalCargo,String finalQueryGlobalEstructura,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		AsistenciaMensualParameterReturnGeneral  asistenciamensualReturnGeneral =new AsistenciaMensualParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			asistenciamensualReturnGeneral =new AsistenciaMensualParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			asistenciamensualReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			asistenciamensualReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Cargo> cargosForeignKey=new ArrayList<Cargo>();
			CargoLogic cargoLogic=new CargoLogic();
			cargoLogic.setConnexion(this.connexion);
			cargoLogic.getCargoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCargo.equals("NONE")) {
				cargoLogic.getTodosCargos(finalQueryGlobalCargo,new Pagination());
				cargosForeignKey=cargoLogic.getCargos();
			}

			asistenciamensualReturnGeneral.setcargosForeignKey(cargosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			asistenciamensualReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			asistenciamensualReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			asistenciamensualReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return asistenciamensualReturnGeneral;
	}
	
	
	public void deepLoad(AsistenciaMensual asistenciamensual,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AsistenciaMensualLogicAdditional.updateAsistenciaMensualToGet(asistenciamensual,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		asistenciamensual.setEmpresa(asistenciamensualDataAccess.getEmpresa(connexion,asistenciamensual));
		asistenciamensual.setEmpleado(asistenciamensualDataAccess.getEmpleado(connexion,asistenciamensual));
		asistenciamensual.setCargo(asistenciamensualDataAccess.getCargo(connexion,asistenciamensual));
		asistenciamensual.setEstructura(asistenciamensualDataAccess.getEstructura(connexion,asistenciamensual));
		asistenciamensual.setAnio(asistenciamensualDataAccess.getAnio(connexion,asistenciamensual));
		asistenciamensual.setMes(asistenciamensualDataAccess.getMes(connexion,asistenciamensual));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				asistenciamensual.setEmpresa(asistenciamensualDataAccess.getEmpresa(connexion,asistenciamensual));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				asistenciamensual.setEmpleado(asistenciamensualDataAccess.getEmpleado(connexion,asistenciamensual));
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				asistenciamensual.setCargo(asistenciamensualDataAccess.getCargo(connexion,asistenciamensual));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				asistenciamensual.setEstructura(asistenciamensualDataAccess.getEstructura(connexion,asistenciamensual));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				asistenciamensual.setAnio(asistenciamensualDataAccess.getAnio(connexion,asistenciamensual));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				asistenciamensual.setMes(asistenciamensualDataAccess.getMes(connexion,asistenciamensual));
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
			asistenciamensual.setEmpresa(asistenciamensualDataAccess.getEmpresa(connexion,asistenciamensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciamensual.setEmpleado(asistenciamensualDataAccess.getEmpleado(connexion,asistenciamensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciamensual.setCargo(asistenciamensualDataAccess.getCargo(connexion,asistenciamensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciamensual.setEstructura(asistenciamensualDataAccess.getEstructura(connexion,asistenciamensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciamensual.setAnio(asistenciamensualDataAccess.getAnio(connexion,asistenciamensual));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciamensual.setMes(asistenciamensualDataAccess.getMes(connexion,asistenciamensual));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		asistenciamensual.setEmpresa(asistenciamensualDataAccess.getEmpresa(connexion,asistenciamensual));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(asistenciamensual.getEmpresa(),isDeep,deepLoadType,clases);
				
		asistenciamensual.setEmpleado(asistenciamensualDataAccess.getEmpleado(connexion,asistenciamensual));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(asistenciamensual.getEmpleado(),isDeep,deepLoadType,clases);
				
		asistenciamensual.setCargo(asistenciamensualDataAccess.getCargo(connexion,asistenciamensual));
		CargoLogic cargoLogic= new CargoLogic(connexion);
		cargoLogic.deepLoad(asistenciamensual.getCargo(),isDeep,deepLoadType,clases);
				
		asistenciamensual.setEstructura(asistenciamensualDataAccess.getEstructura(connexion,asistenciamensual));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(asistenciamensual.getEstructura(),isDeep,deepLoadType,clases);
				
		asistenciamensual.setAnio(asistenciamensualDataAccess.getAnio(connexion,asistenciamensual));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(asistenciamensual.getAnio(),isDeep,deepLoadType,clases);
				
		asistenciamensual.setMes(asistenciamensualDataAccess.getMes(connexion,asistenciamensual));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(asistenciamensual.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				asistenciamensual.setEmpresa(asistenciamensualDataAccess.getEmpresa(connexion,asistenciamensual));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(asistenciamensual.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				asistenciamensual.setEmpleado(asistenciamensualDataAccess.getEmpleado(connexion,asistenciamensual));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(asistenciamensual.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				asistenciamensual.setCargo(asistenciamensualDataAccess.getCargo(connexion,asistenciamensual));
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepLoad(asistenciamensual.getCargo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				asistenciamensual.setEstructura(asistenciamensualDataAccess.getEstructura(connexion,asistenciamensual));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(asistenciamensual.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				asistenciamensual.setAnio(asistenciamensualDataAccess.getAnio(connexion,asistenciamensual));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(asistenciamensual.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				asistenciamensual.setMes(asistenciamensualDataAccess.getMes(connexion,asistenciamensual));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(asistenciamensual.getMes(),isDeep,deepLoadType,clases);				
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
			asistenciamensual.setEmpresa(asistenciamensualDataAccess.getEmpresa(connexion,asistenciamensual));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(asistenciamensual.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciamensual.setEmpleado(asistenciamensualDataAccess.getEmpleado(connexion,asistenciamensual));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(asistenciamensual.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciamensual.setCargo(asistenciamensualDataAccess.getCargo(connexion,asistenciamensual));
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargoLogic.deepLoad(asistenciamensual.getCargo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciamensual.setEstructura(asistenciamensualDataAccess.getEstructura(connexion,asistenciamensual));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(asistenciamensual.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciamensual.setAnio(asistenciamensualDataAccess.getAnio(connexion,asistenciamensual));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(asistenciamensual.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asistenciamensual.setMes(asistenciamensualDataAccess.getMes(connexion,asistenciamensual));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(asistenciamensual.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AsistenciaMensual asistenciamensual,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AsistenciaMensualLogicAdditional.updateAsistenciaMensualToSave(asistenciamensual,this.arrDatoGeneral);
			
AsistenciaMensualDataAccess.save(asistenciamensual, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(asistenciamensual.getEmpresa(),connexion);

		EmpleadoDataAccess.save(asistenciamensual.getEmpleado(),connexion);

		CargoDataAccess.save(asistenciamensual.getCargo(),connexion);

		EstructuraDataAccess.save(asistenciamensual.getEstructura(),connexion);

		AnioDataAccess.save(asistenciamensual.getAnio(),connexion);

		MesDataAccess.save(asistenciamensual.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(asistenciamensual.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(asistenciamensual.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				CargoDataAccess.save(asistenciamensual.getCargo(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(asistenciamensual.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(asistenciamensual.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(asistenciamensual.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(asistenciamensual.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(asistenciamensual.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(asistenciamensual.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(asistenciamensual.getEmpleado(),isDeep,deepLoadType,clases);
				

		CargoDataAccess.save(asistenciamensual.getCargo(),connexion);
		CargoLogic cargoLogic= new CargoLogic(connexion);
		cargoLogic.deepLoad(asistenciamensual.getCargo(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(asistenciamensual.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(asistenciamensual.getEstructura(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(asistenciamensual.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(asistenciamensual.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(asistenciamensual.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(asistenciamensual.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(asistenciamensual.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(asistenciamensual.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(asistenciamensual.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(asistenciamensual.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				CargoDataAccess.save(asistenciamensual.getCargo(),connexion);
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepSave(asistenciamensual.getCargo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(asistenciamensual.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(asistenciamensual.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(asistenciamensual.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(asistenciamensual.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(asistenciamensual.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(asistenciamensual.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AsistenciaMensual.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(asistenciamensual);
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
			this.deepLoad(this.asistenciamensual,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensual);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AsistenciaMensual.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(asistenciamensuals!=null) {
				for(AsistenciaMensual asistenciamensual:asistenciamensuals) {
					this.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(asistenciamensuals);
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
			if(asistenciamensuals!=null) {
				for(AsistenciaMensual asistenciamensual:asistenciamensuals) {
					this.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(asistenciamensuals);
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
			this.getNewConnexionToDeep(AsistenciaMensual.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(asistenciamensual,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AsistenciaMensual.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(asistenciamensuals!=null) {
				for(AsistenciaMensual asistenciamensual:asistenciamensuals) {
					this.deepSave(asistenciamensual,isDeep,deepLoadType,clases);
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
			if(asistenciamensuals!=null) {
				for(AsistenciaMensual asistenciamensual:asistenciamensuals) {
					this.deepSave(asistenciamensual,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAsistenciaMensualsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,AsistenciaMensualConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaMensualsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,AsistenciaMensualConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsistenciaMensualsFK_IdCargoWithConnection(String sFinalQuery,Pagination pagination,Long id_cargo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cargo,AsistenciaMensualConstantesFunciones.IDCARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCargo);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaMensualsFK_IdCargo(String sFinalQuery,Pagination pagination,Long id_cargo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cargo,AsistenciaMensualConstantesFunciones.IDCARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCargo);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsistenciaMensualsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AsistenciaMensualConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaMensualsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,AsistenciaMensualConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsistenciaMensualsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AsistenciaMensualConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaMensualsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AsistenciaMensualConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsistenciaMensualsFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,AsistenciaMensualConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaMensualsFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,AsistenciaMensualConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsistenciaMensualsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsistenciaMensual.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,AsistenciaMensualConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsistenciaMensualsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,AsistenciaMensualConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			AsistenciaMensualLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(this.asistenciamensuals);
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
			if(AsistenciaMensualConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaMensualDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AsistenciaMensual asistenciamensual,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AsistenciaMensualConstantesFunciones.ISCONAUDITORIA) {
				if(asistenciamensual.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaMensualDataAccess.TABLENAME, asistenciamensual.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AsistenciaMensualConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AsistenciaMensualLogic.registrarAuditoriaDetallesAsistenciaMensual(connexion,asistenciamensual,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(asistenciamensual.getIsDeleted()) {
					/*if(!asistenciamensual.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AsistenciaMensualDataAccess.TABLENAME, asistenciamensual.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AsistenciaMensualLogic.registrarAuditoriaDetallesAsistenciaMensual(connexion,asistenciamensual,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaMensualDataAccess.TABLENAME, asistenciamensual.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(asistenciamensual.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsistenciaMensualDataAccess.TABLENAME, asistenciamensual.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AsistenciaMensualConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AsistenciaMensualLogic.registrarAuditoriaDetallesAsistenciaMensual(connexion,asistenciamensual,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAsistenciaMensual(Connexion connexion,AsistenciaMensual asistenciamensual)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getid_empresa().equals(asistenciamensual.getAsistenciaMensualOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getid_empresa()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getid_empresa().toString();
				}
				if(asistenciamensual.getid_empresa()!=null)
				{
					strValorNuevo=asistenciamensual.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getid_empleado().equals(asistenciamensual.getAsistenciaMensualOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getid_empleado()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getid_empleado().toString();
				}
				if(asistenciamensual.getid_empleado()!=null)
				{
					strValorNuevo=asistenciamensual.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getid_cargo().equals(asistenciamensual.getAsistenciaMensualOriginal().getid_cargo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getid_cargo()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getid_cargo().toString();
				}
				if(asistenciamensual.getid_cargo()!=null)
				{
					strValorNuevo=asistenciamensual.getid_cargo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.IDCARGO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getid_estructura().equals(asistenciamensual.getAsistenciaMensualOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getid_estructura()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getid_estructura().toString();
				}
				if(asistenciamensual.getid_estructura()!=null)
				{
					strValorNuevo=asistenciamensual.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getid_anio().equals(asistenciamensual.getAsistenciaMensualOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getid_anio()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getid_anio().toString();
				}
				if(asistenciamensual.getid_anio()!=null)
				{
					strValorNuevo=asistenciamensual.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getid_mes().equals(asistenciamensual.getAsistenciaMensualOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getid_mes()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getid_mes().toString();
				}
				if(asistenciamensual.getid_mes()!=null)
				{
					strValorNuevo=asistenciamensual.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getfecha().equals(asistenciamensual.getAsistenciaMensualOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getfecha()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getfecha().toString();
				}
				if(asistenciamensual.getfecha()!=null)
				{
					strValorNuevo=asistenciamensual.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_trabajo().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_trabajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_trabajo()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_trabajo().toString();
				}
				if(asistenciamensual.gethoras_trabajo()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_trabajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASTRABAJO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_atraso().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_atraso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_atraso()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_atraso().toString();
				}
				if(asistenciamensual.gethoras_atraso()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_atraso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASATRASO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_faltas().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_faltas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_faltas()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_faltas().toString();
				}
				if(asistenciamensual.gethoras_faltas()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_faltas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASFALTAS,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_permiso().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_permiso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_permiso()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_permiso().toString();
				}
				if(asistenciamensual.gethoras_permiso()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_permiso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASPERMISO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_extra25().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra25()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra25()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra25().toString();
				}
				if(asistenciamensual.gethoras_extra25()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_extra25().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASEXTRA25,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_extra50().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra50()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra50()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra50().toString();
				}
				if(asistenciamensual.gethoras_extra50()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_extra50().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASEXTRA50,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_extra100().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra100()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra100()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra100().toString();
				}
				if(asistenciamensual.gethoras_extra100()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_extra100().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASEXTRA100,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_extra150().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra150()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra150()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra150().toString();
				}
				if(asistenciamensual.gethoras_extra150()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_extra150().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASEXTRA150,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_extra0().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra0()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_extra0().toString();
				}
				if(asistenciamensual.gethoras_extra0()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_extra0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASEXTRA0,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_enfermo().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_enfermo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_enfermo()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_enfermo().toString();
				}
				if(asistenciamensual.gethoras_enfermo()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_enfermo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASENFERMO,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_maternidad().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_maternidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_maternidad()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_maternidad().toString();
				}
				if(asistenciamensual.gethoras_maternidad()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_maternidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASMATERNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.gethoras_vacacion().equals(asistenciamensual.getAsistenciaMensualOriginal().gethoras_vacacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().gethoras_vacacion()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().gethoras_vacacion().toString();
				}
				if(asistenciamensual.gethoras_vacacion()!=null)
				{
					strValorNuevo=asistenciamensual.gethoras_vacacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.HORASVACACION,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getnumero_dias().equals(asistenciamensual.getAsistenciaMensualOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getnumero_dias()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getnumero_dias().toString();
				}
				if(asistenciamensual.getnumero_dias()!=null)
				{
					strValorNuevo=asistenciamensual.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getnumero_noches().equals(asistenciamensual.getAsistenciaMensualOriginal().getnumero_noches()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getnumero_noches()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getnumero_noches().toString();
				}
				if(asistenciamensual.getnumero_noches()!=null)
				{
					strValorNuevo=asistenciamensual.getnumero_noches().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.NUMERONOCHES,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getnumero_feriados().equals(asistenciamensual.getAsistenciaMensualOriginal().getnumero_feriados()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getnumero_feriados()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getnumero_feriados().toString();
				}
				if(asistenciamensual.getnumero_feriados()!=null)
				{
					strValorNuevo=asistenciamensual.getnumero_feriados().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.NUMEROFERIADOS,strValorActual,strValorNuevo);
			}	
			
			if(asistenciamensual.getIsNew()||!asistenciamensual.getnumero_trabajo().equals(asistenciamensual.getAsistenciaMensualOriginal().getnumero_trabajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asistenciamensual.getAsistenciaMensualOriginal().getnumero_trabajo()!=null)
				{
					strValorActual=asistenciamensual.getAsistenciaMensualOriginal().getnumero_trabajo().toString();
				}
				if(asistenciamensual.getnumero_trabajo()!=null)
				{
					strValorNuevo=asistenciamensual.getnumero_trabajo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsistenciaMensualConstantesFunciones.NUMEROTRABAJO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAsistenciaMensualRelacionesWithConnection(AsistenciaMensual asistenciamensual) throws Exception {

		if(!asistenciamensual.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAsistenciaMensualRelacionesBase(asistenciamensual,true);
		}
	}

	public void saveAsistenciaMensualRelaciones(AsistenciaMensual asistenciamensual)throws Exception {

		if(!asistenciamensual.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAsistenciaMensualRelacionesBase(asistenciamensual,false);
		}
	}

	public void saveAsistenciaMensualRelacionesBase(AsistenciaMensual asistenciamensual,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AsistenciaMensual-saveRelacionesWithConnection");}
	

			this.setAsistenciaMensual(asistenciamensual);

			if(AsistenciaMensualLogicAdditional.validarSaveRelaciones(asistenciamensual,this)) {

				AsistenciaMensualLogicAdditional.updateRelacionesToSave(asistenciamensual,this);

				if((asistenciamensual.getIsNew()||asistenciamensual.getIsChanged())&&!asistenciamensual.getIsDeleted()) {
					this.saveAsistenciaMensual();
					this.saveAsistenciaMensualRelacionesDetalles();

				} else if(asistenciamensual.getIsDeleted()) {
					this.saveAsistenciaMensualRelacionesDetalles();
					this.saveAsistenciaMensual();
				}

				AsistenciaMensualLogicAdditional.updateRelacionesToSaveAfter(asistenciamensual,this);

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
	
	
	private void saveAsistenciaMensualRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAsistenciaMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AsistenciaMensualConstantesFunciones.getClassesForeignKeysOfAsistenciaMensual(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsistenciaMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AsistenciaMensualConstantesFunciones.getClassesRelationshipsOfAsistenciaMensual(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.SaldoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.SaldoContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.SaldoContableParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.SaldoContable;
import com.bydan.erp.contabilidad.business.logic.SaldoContableLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class SaldoContableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SaldoContableLogic.class);
	
	protected SaldoContableDataAccess saldocontableDataAccess; 	
	protected SaldoContable saldocontable;
	protected List<SaldoContable> saldocontables;
	protected Object saldocontableObject;	
	protected List<Object> saldocontablesObject;
	
	public static ClassValidator<SaldoContable> saldocontableValidator = new ClassValidator<SaldoContable>(SaldoContable.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SaldoContableLogicAdditional saldocontableLogicAdditional=null;
	
	public SaldoContableLogicAdditional getSaldoContableLogicAdditional() {
		return this.saldocontableLogicAdditional;
	}
	
	public void setSaldoContableLogicAdditional(SaldoContableLogicAdditional saldocontableLogicAdditional) {
		try {
			this.saldocontableLogicAdditional=saldocontableLogicAdditional;
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
	
	
	
	
	public  SaldoContableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.saldocontableDataAccess = new SaldoContableDataAccess();
			
			this.saldocontables= new ArrayList<SaldoContable>();
			this.saldocontable= new SaldoContable();
			
			this.saldocontableObject=new Object();
			this.saldocontablesObject=new ArrayList<Object>();
				
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
			
			this.saldocontableDataAccess.setConnexionType(this.connexionType);
			this.saldocontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SaldoContableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.saldocontableDataAccess = new SaldoContableDataAccess();
			this.saldocontables= new ArrayList<SaldoContable>();
			this.saldocontable= new SaldoContable();
			this.saldocontableObject=new Object();
			this.saldocontablesObject=new ArrayList<Object>();
			
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
			
			this.saldocontableDataAccess.setConnexionType(this.connexionType);
			this.saldocontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SaldoContable getSaldoContable() throws Exception {	
		SaldoContableLogicAdditional.checkSaldoContableToGet(saldocontable,this.datosCliente,this.arrDatoGeneral);
		SaldoContableLogicAdditional.updateSaldoContableToGet(saldocontable,this.arrDatoGeneral);
		
		return saldocontable;
	}
		
	public void setSaldoContable(SaldoContable newSaldoContable) {
		this.saldocontable = newSaldoContable;
	}
	
	public SaldoContableDataAccess getSaldoContableDataAccess() {
		return saldocontableDataAccess;
	}
	
	public void setSaldoContableDataAccess(SaldoContableDataAccess newsaldocontableDataAccess) {
		this.saldocontableDataAccess = newsaldocontableDataAccess;
	}
	
	public List<SaldoContable> getSaldoContables() throws Exception {		
		this.quitarSaldoContablesNulos();
		
		SaldoContableLogicAdditional.checkSaldoContableToGets(saldocontables,this.datosCliente,this.arrDatoGeneral);
		
		for (SaldoContable saldocontableLocal: saldocontables ) {
			SaldoContableLogicAdditional.updateSaldoContableToGet(saldocontableLocal,this.arrDatoGeneral);
		}
		
		return saldocontables;
	}
	
	public void setSaldoContables(List<SaldoContable> newSaldoContables) {
		this.saldocontables = newSaldoContables;
	}
	
	public Object getSaldoContableObject() {	
		this.saldocontableObject=this.saldocontableDataAccess.getEntityObject();
		return this.saldocontableObject;
	}
		
	public void setSaldoContableObject(Object newSaldoContableObject) {
		this.saldocontableObject = newSaldoContableObject;
	}
	
	public List<Object> getSaldoContablesObject() {		
		this.saldocontablesObject=this.saldocontableDataAccess.getEntitiesObject();
		return this.saldocontablesObject;
	}
		
	public void setSaldoContablesObject(List<Object> newSaldoContablesObject) {
		this.saldocontablesObject = newSaldoContablesObject;
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
		
		if(this.saldocontableDataAccess!=null) {
			this.saldocontableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			saldocontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			saldocontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		saldocontable = new  SaldoContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			saldocontable=saldocontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.saldocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontable);
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
		saldocontable = new  SaldoContable();
		  		  
        try {
			
			saldocontable=saldocontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.saldocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		saldocontable = new  SaldoContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			saldocontable=saldocontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.saldocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontable);
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
		saldocontable = new  SaldoContable();
		  		  
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
		saldocontable = new  SaldoContable();
		  		  
        try {
			
			saldocontable=saldocontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.saldocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		saldocontable = new  SaldoContable();
		  		  
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
		saldocontable = new  SaldoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =saldocontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		saldocontable = new  SaldoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=saldocontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		saldocontable = new  SaldoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =saldocontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		saldocontable = new  SaldoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=saldocontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		saldocontable = new  SaldoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =saldocontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		saldocontable = new  SaldoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=saldocontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		saldocontables = new  ArrayList<SaldoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontables=saldocontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSaldoContable(saldocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
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
		saldocontables = new  ArrayList<SaldoContable>();
		  		  
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
		saldocontables = new  ArrayList<SaldoContable>();
		  		  
        try {			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontables=saldocontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSaldoContable(saldocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		saldocontables = new  ArrayList<SaldoContable>();
		  		  
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
		saldocontables = new  ArrayList<SaldoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontables=saldocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSaldoContable(saldocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
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
		saldocontables = new  ArrayList<SaldoContable>();
		  		  
        try {
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontables=saldocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSaldoContable(saldocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
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
		saldocontables = new  ArrayList<SaldoContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontables=saldocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSaldoContable(saldocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
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
		saldocontables = new  ArrayList<SaldoContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontables=saldocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSaldoContable(saldocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		saldocontable = new  SaldoContable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontable=saldocontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSaldoContable(saldocontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontable);
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
		saldocontable = new  SaldoContable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontable=saldocontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSaldoContable(saldocontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		saldocontables = new  ArrayList<SaldoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontables=saldocontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSaldoContable(saldocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
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
		saldocontables = new  ArrayList<SaldoContable>();
		  		  
        try {
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontables=saldocontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSaldoContable(saldocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSaldoContablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		saldocontables = new  ArrayList<SaldoContable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getTodosSaldoContablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSaldoContable(saldocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
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
	
	public  void  getTodosSaldoContables(String sFinalQuery,Pagination pagination)throws Exception {
		saldocontables = new  ArrayList<SaldoContable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSaldoContable(saldocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSaldoContable(SaldoContable saldocontable) throws Exception {
		Boolean estaValidado=false;
		
		if(saldocontable.getIsNew() || saldocontable.getIsChanged()) { 
			this.invalidValues = saldocontableValidator.getInvalidValues(saldocontable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(saldocontable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSaldoContable(List<SaldoContable> SaldoContables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SaldoContable saldocontableLocal:saldocontables) {				
			estaValidadoObjeto=this.validarGuardarSaldoContable(saldocontableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSaldoContable(List<SaldoContable> SaldoContables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSaldoContable(saldocontables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSaldoContable(SaldoContable SaldoContable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSaldoContable(saldocontable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SaldoContable saldocontable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+saldocontable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SaldoContableConstantesFunciones.getSaldoContableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"saldocontable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SaldoContableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SaldoContableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSaldoContableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-saveSaldoContableWithConnection");connexion.begin();			
			
			SaldoContableLogicAdditional.checkSaldoContableToSave(this.saldocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SaldoContableLogicAdditional.updateSaldoContableToSave(this.saldocontable,this.arrDatoGeneral);
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.saldocontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSaldoContable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSaldoContable(this.saldocontable)) {
				SaldoContableDataAccess.save(this.saldocontable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.saldocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SaldoContableLogicAdditional.checkSaldoContableToSaveAfter(this.saldocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSaldoContable();
			
			connexion.commit();			
			
			if(this.saldocontable.getIsDeleted()) {
				this.saldocontable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSaldoContable()throws Exception {	
		try {	
			
			SaldoContableLogicAdditional.checkSaldoContableToSave(this.saldocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SaldoContableLogicAdditional.updateSaldoContableToSave(this.saldocontable,this.arrDatoGeneral);
			
			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.saldocontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSaldoContable(this.saldocontable)) {			
				SaldoContableDataAccess.save(this.saldocontable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.saldocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SaldoContableLogicAdditional.checkSaldoContableToSaveAfter(this.saldocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.saldocontable.getIsDeleted()) {
				this.saldocontable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSaldoContablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-saveSaldoContablesWithConnection");connexion.begin();			
			
			SaldoContableLogicAdditional.checkSaldoContableToSaves(saldocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSaldoContables();
			
			Boolean validadoTodosSaldoContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SaldoContable saldocontableLocal:saldocontables) {		
				if(saldocontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SaldoContableLogicAdditional.updateSaldoContableToSave(saldocontableLocal,this.arrDatoGeneral);
	        	
				SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),saldocontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSaldoContable(saldocontableLocal)) {
					SaldoContableDataAccess.save(saldocontableLocal, connexion);				
				} else {
					validadoTodosSaldoContable=false;
				}
			}
			
			if(!validadoTodosSaldoContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SaldoContableLogicAdditional.checkSaldoContableToSavesAfter(saldocontables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSaldoContables();
			
			connexion.commit();		
			
			this.quitarSaldoContablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSaldoContables()throws Exception {				
		 try {	
			SaldoContableLogicAdditional.checkSaldoContableToSaves(saldocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSaldoContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SaldoContable saldocontableLocal:saldocontables) {				
				if(saldocontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SaldoContableLogicAdditional.updateSaldoContableToSave(saldocontableLocal,this.arrDatoGeneral);
	        	
				SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),saldocontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSaldoContable(saldocontableLocal)) {				
					SaldoContableDataAccess.save(saldocontableLocal, connexion);				
				} else {
					validadoTodosSaldoContable=false;
				}
			}
			
			if(!validadoTodosSaldoContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SaldoContableLogicAdditional.checkSaldoContableToSavesAfter(saldocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSaldoContablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SaldoContableParameterReturnGeneral procesarAccionSaldoContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SaldoContable> saldocontables,SaldoContableParameterReturnGeneral saldocontableParameterGeneral)throws Exception {
		 try {	
			SaldoContableParameterReturnGeneral saldocontableReturnGeneral=new SaldoContableParameterReturnGeneral();
	
			SaldoContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,saldocontables,saldocontableParameterGeneral,saldocontableReturnGeneral);
			
			return saldocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SaldoContableParameterReturnGeneral procesarAccionSaldoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SaldoContable> saldocontables,SaldoContableParameterReturnGeneral saldocontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-procesarAccionSaldoContablesWithConnection");connexion.begin();			
			
			SaldoContableParameterReturnGeneral saldocontableReturnGeneral=new SaldoContableParameterReturnGeneral();
	
			SaldoContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,saldocontables,saldocontableParameterGeneral,saldocontableReturnGeneral);
			
			this.connexion.commit();
			
			return saldocontableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SaldoContableParameterReturnGeneral procesarEventosSaldoContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SaldoContable> saldocontables,SaldoContable saldocontable,SaldoContableParameterReturnGeneral saldocontableParameterGeneral,Boolean isEsNuevoSaldoContable,ArrayList<Classe> clases)throws Exception {
		 try {	
			SaldoContableParameterReturnGeneral saldocontableReturnGeneral=new SaldoContableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				saldocontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SaldoContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,saldocontables,saldocontable,saldocontableParameterGeneral,saldocontableReturnGeneral,isEsNuevoSaldoContable,clases);
			
			return saldocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SaldoContableParameterReturnGeneral procesarEventosSaldoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SaldoContable> saldocontables,SaldoContable saldocontable,SaldoContableParameterReturnGeneral saldocontableParameterGeneral,Boolean isEsNuevoSaldoContable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-procesarEventosSaldoContablesWithConnection");connexion.begin();			
			
			SaldoContableParameterReturnGeneral saldocontableReturnGeneral=new SaldoContableParameterReturnGeneral();
	
			saldocontableReturnGeneral.setSaldoContable(saldocontable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				saldocontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SaldoContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,saldocontables,saldocontable,saldocontableParameterGeneral,saldocontableReturnGeneral,isEsNuevoSaldoContable,clases);
			
			this.connexion.commit();
			
			return saldocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SaldoContableParameterReturnGeneral procesarImportacionSaldoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SaldoContableParameterReturnGeneral saldocontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-procesarImportacionSaldoContablesWithConnection");connexion.begin();			
			
			SaldoContableParameterReturnGeneral saldocontableReturnGeneral=new SaldoContableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.saldocontables=new ArrayList<SaldoContable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.saldocontable=new SaldoContable();
				
				
				if(conColumnasBase) {this.saldocontable.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.saldocontable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.saldocontable.setdebito_mone_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.saldocontable.setcredito_mone_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.saldocontable.setsaldo_mone_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.saldocontable.setdebito_mone_extra(Double.parseDouble(arrColumnas[iColumn++]));
				this.saldocontable.setcredito_mone_extra(Double.parseDouble(arrColumnas[iColumn++]));
				this.saldocontable.setsaldo_mone_extra(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.saldocontables.add(this.saldocontable);
			}
			
			this.saveSaldoContables();
			
			this.connexion.commit();
			
			saldocontableReturnGeneral.setConRetornoEstaProcesado(true);
			saldocontableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return saldocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSaldoContablesEliminados() throws Exception {				
		
		List<SaldoContable> saldocontablesAux= new ArrayList<SaldoContable>();
		
		for(SaldoContable saldocontable:saldocontables) {
			if(!saldocontable.getIsDeleted()) {
				saldocontablesAux.add(saldocontable);
			}
		}
		
		saldocontables=saldocontablesAux;
	}
	
	public void quitarSaldoContablesNulos() throws Exception {				
		
		List<SaldoContable> saldocontablesAux= new ArrayList<SaldoContable>();
		
		for(SaldoContable saldocontable : this.saldocontables) {
			if(saldocontable==null) {
				saldocontablesAux.add(saldocontable);
			}
		}
		
		//this.saldocontables=saldocontablesAux;
		
		this.saldocontables.removeAll(saldocontablesAux);
	}
	
	public void getSetVersionRowSaldoContableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(saldocontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((saldocontable.getIsDeleted() || (saldocontable.getIsChanged()&&!saldocontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=saldocontableDataAccess.getSetVersionRowSaldoContable(connexion,saldocontable.getId());
				
				if(!saldocontable.getVersionRow().equals(timestamp)) {	
					saldocontable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				saldocontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSaldoContable()throws Exception {	
		
		if(saldocontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((saldocontable.getIsDeleted() || (saldocontable.getIsChanged()&&!saldocontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=saldocontableDataAccess.getSetVersionRowSaldoContable(connexion,saldocontable.getId());
			
			try {							
				if(!saldocontable.getVersionRow().equals(timestamp)) {	
					saldocontable.setVersionRow(timestamp);
				}
				
				saldocontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSaldoContablesWithConnection()throws Exception {	
		if(saldocontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SaldoContable saldocontableAux:saldocontables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(saldocontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(saldocontableAux.getIsDeleted() || (saldocontableAux.getIsChanged()&&!saldocontableAux.getIsNew())) {
						
						timestamp=saldocontableDataAccess.getSetVersionRowSaldoContable(connexion,saldocontableAux.getId());
						
						if(!saldocontable.getVersionRow().equals(timestamp)) {	
							saldocontableAux.setVersionRow(timestamp);
						}
								
						saldocontableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSaldoContables()throws Exception {	
		if(saldocontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SaldoContable saldocontableAux:saldocontables) {
					if(saldocontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(saldocontableAux.getIsDeleted() || (saldocontableAux.getIsChanged()&&!saldocontableAux.getIsNew())) {
						
						timestamp=saldocontableDataAccess.getSetVersionRowSaldoContable(connexion,saldocontableAux.getId());
						
						if(!saldocontableAux.getVersionRow().equals(timestamp)) {	
							saldocontableAux.setVersionRow(timestamp);
						}
						
													
						saldocontableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SaldoContableParameterReturnGeneral cargarCombosLoteForeignKeySaldoContableWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCuentaContable) throws Exception {
		SaldoContableParameterReturnGeneral  saldocontableReturnGeneral =new SaldoContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-cargarCombosLoteForeignKeySaldoContableWithConnection");connexion.begin();
			
			saldocontableReturnGeneral =new SaldoContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			saldocontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			saldocontableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			saldocontableReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			saldocontableReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			saldocontableReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			saldocontableReturnGeneral.setmessForeignKey(messForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			saldocontableReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return saldocontableReturnGeneral;
	}
	
	public SaldoContableParameterReturnGeneral cargarCombosLoteForeignKeySaldoContable(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCuentaContable) throws Exception {
		SaldoContableParameterReturnGeneral  saldocontableReturnGeneral =new SaldoContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			saldocontableReturnGeneral =new SaldoContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			saldocontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			saldocontableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			saldocontableReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			saldocontableReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			saldocontableReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			saldocontableReturnGeneral.setmessForeignKey(messForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			saldocontableReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return saldocontableReturnGeneral;
	}
	
	
	public void deepLoad(SaldoContable saldocontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SaldoContableLogicAdditional.updateSaldoContableToGet(saldocontable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		saldocontable.setEmpresa(saldocontableDataAccess.getEmpresa(connexion,saldocontable));
		saldocontable.setSucursal(saldocontableDataAccess.getSucursal(connexion,saldocontable));
		saldocontable.setEjercicio(saldocontableDataAccess.getEjercicio(connexion,saldocontable));
		saldocontable.setPeriodo(saldocontableDataAccess.getPeriodo(connexion,saldocontable));
		saldocontable.setAnio(saldocontableDataAccess.getAnio(connexion,saldocontable));
		saldocontable.setMes(saldocontableDataAccess.getMes(connexion,saldocontable));
		saldocontable.setCuentaContable(saldocontableDataAccess.getCuentaContable(connexion,saldocontable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				saldocontable.setEmpresa(saldocontableDataAccess.getEmpresa(connexion,saldocontable));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				saldocontable.setSucursal(saldocontableDataAccess.getSucursal(connexion,saldocontable));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				saldocontable.setEjercicio(saldocontableDataAccess.getEjercicio(connexion,saldocontable));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				saldocontable.setPeriodo(saldocontableDataAccess.getPeriodo(connexion,saldocontable));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				saldocontable.setAnio(saldocontableDataAccess.getAnio(connexion,saldocontable));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				saldocontable.setMes(saldocontableDataAccess.getMes(connexion,saldocontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				saldocontable.setCuentaContable(saldocontableDataAccess.getCuentaContable(connexion,saldocontable));
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
			saldocontable.setEmpresa(saldocontableDataAccess.getEmpresa(connexion,saldocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setSucursal(saldocontableDataAccess.getSucursal(connexion,saldocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setEjercicio(saldocontableDataAccess.getEjercicio(connexion,saldocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setPeriodo(saldocontableDataAccess.getPeriodo(connexion,saldocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setAnio(saldocontableDataAccess.getAnio(connexion,saldocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setMes(saldocontableDataAccess.getMes(connexion,saldocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setCuentaContable(saldocontableDataAccess.getCuentaContable(connexion,saldocontable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		saldocontable.setEmpresa(saldocontableDataAccess.getEmpresa(connexion,saldocontable));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(saldocontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		saldocontable.setSucursal(saldocontableDataAccess.getSucursal(connexion,saldocontable));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(saldocontable.getSucursal(),isDeep,deepLoadType,clases);
				
		saldocontable.setEjercicio(saldocontableDataAccess.getEjercicio(connexion,saldocontable));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(saldocontable.getEjercicio(),isDeep,deepLoadType,clases);
				
		saldocontable.setPeriodo(saldocontableDataAccess.getPeriodo(connexion,saldocontable));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(saldocontable.getPeriodo(),isDeep,deepLoadType,clases);
				
		saldocontable.setAnio(saldocontableDataAccess.getAnio(connexion,saldocontable));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(saldocontable.getAnio(),isDeep,deepLoadType,clases);
				
		saldocontable.setMes(saldocontableDataAccess.getMes(connexion,saldocontable));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(saldocontable.getMes(),isDeep,deepLoadType,clases);
				
		saldocontable.setCuentaContable(saldocontableDataAccess.getCuentaContable(connexion,saldocontable));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(saldocontable.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				saldocontable.setEmpresa(saldocontableDataAccess.getEmpresa(connexion,saldocontable));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(saldocontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				saldocontable.setSucursal(saldocontableDataAccess.getSucursal(connexion,saldocontable));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(saldocontable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				saldocontable.setEjercicio(saldocontableDataAccess.getEjercicio(connexion,saldocontable));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(saldocontable.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				saldocontable.setPeriodo(saldocontableDataAccess.getPeriodo(connexion,saldocontable));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(saldocontable.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				saldocontable.setAnio(saldocontableDataAccess.getAnio(connexion,saldocontable));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(saldocontable.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				saldocontable.setMes(saldocontableDataAccess.getMes(connexion,saldocontable));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(saldocontable.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				saldocontable.setCuentaContable(saldocontableDataAccess.getCuentaContable(connexion,saldocontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(saldocontable.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			saldocontable.setEmpresa(saldocontableDataAccess.getEmpresa(connexion,saldocontable));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(saldocontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setSucursal(saldocontableDataAccess.getSucursal(connexion,saldocontable));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(saldocontable.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setEjercicio(saldocontableDataAccess.getEjercicio(connexion,saldocontable));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(saldocontable.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setPeriodo(saldocontableDataAccess.getPeriodo(connexion,saldocontable));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(saldocontable.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setAnio(saldocontableDataAccess.getAnio(connexion,saldocontable));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(saldocontable.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setMes(saldocontableDataAccess.getMes(connexion,saldocontable));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(saldocontable.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			saldocontable.setCuentaContable(saldocontableDataAccess.getCuentaContable(connexion,saldocontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(saldocontable.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SaldoContable saldocontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SaldoContableLogicAdditional.updateSaldoContableToSave(saldocontable,this.arrDatoGeneral);
			
SaldoContableDataAccess.save(saldocontable, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(saldocontable.getEmpresa(),connexion);

		SucursalDataAccess.save(saldocontable.getSucursal(),connexion);

		EjercicioDataAccess.save(saldocontable.getEjercicio(),connexion);

		PeriodoDataAccess.save(saldocontable.getPeriodo(),connexion);

		AnioDataAccess.save(saldocontable.getAnio(),connexion);

		MesDataAccess.save(saldocontable.getMes(),connexion);

		CuentaContableDataAccess.save(saldocontable.getCuentaContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(saldocontable.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(saldocontable.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(saldocontable.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(saldocontable.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(saldocontable.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(saldocontable.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(saldocontable.getCuentaContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(saldocontable.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(saldocontable.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(saldocontable.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(saldocontable.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(saldocontable.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(saldocontable.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(saldocontable.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(saldocontable.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(saldocontable.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(saldocontable.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(saldocontable.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(saldocontable.getMes(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(saldocontable.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(saldocontable.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(saldocontable.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(saldocontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(saldocontable.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(saldocontable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(saldocontable.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(saldocontable.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(saldocontable.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(saldocontable.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(saldocontable.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(saldocontable.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(saldocontable.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(saldocontable.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(saldocontable.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(saldocontable.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(SaldoContable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(saldocontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(saldocontable);
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
			this.deepLoad(this.saldocontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SaldoContable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(saldocontables!=null) {
				for(SaldoContable saldocontable:saldocontables) {
					this.deepLoad(saldocontable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(saldocontables);
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
			if(saldocontables!=null) {
				for(SaldoContable saldocontable:saldocontables) {
					this.deepLoad(saldocontable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(saldocontables);
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
			this.getNewConnexionToDeep(SaldoContable.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(saldocontable,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SaldoContable.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(saldocontables!=null) {
				for(SaldoContable saldocontable:saldocontables) {
					this.deepSave(saldocontable,isDeep,deepLoadType,clases);
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
			if(saldocontables!=null) {
				for(SaldoContable saldocontable:saldocontables) {
					this.deepSave(saldocontable,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSaldoContablesFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,SaldoContableConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoContablesFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,SaldoContableConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoContablesFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,SaldoContableConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoContablesFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,SaldoContableConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoContablesFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,SaldoContableConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoContablesFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,SaldoContableConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoContablesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SaldoContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoContablesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SaldoContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoContablesFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,SaldoContableConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoContablesFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,SaldoContableConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoContablesFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,SaldoContableConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoContablesFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,SaldoContableConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSaldoContablesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SaldoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SaldoContableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSaldoContablesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SaldoContableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SaldoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			saldocontables=saldocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SaldoContableConstantesFunciones.refrescarForeignKeysDescripcionesSaldoContable(this.saldocontables);
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
			if(SaldoContableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SaldoContableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SaldoContable saldocontable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SaldoContableConstantesFunciones.ISCONAUDITORIA) {
				if(saldocontable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SaldoContableDataAccess.TABLENAME, saldocontable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SaldoContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SaldoContableLogic.registrarAuditoriaDetallesSaldoContable(connexion,saldocontable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(saldocontable.getIsDeleted()) {
					/*if(!saldocontable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SaldoContableDataAccess.TABLENAME, saldocontable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SaldoContableLogic.registrarAuditoriaDetallesSaldoContable(connexion,saldocontable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SaldoContableDataAccess.TABLENAME, saldocontable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(saldocontable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SaldoContableDataAccess.TABLENAME, saldocontable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SaldoContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SaldoContableLogic.registrarAuditoriaDetallesSaldoContable(connexion,saldocontable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSaldoContable(Connexion connexion,SaldoContable saldocontable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(saldocontable.getIsNew()||!saldocontable.getid_empresa().equals(saldocontable.getSaldoContableOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getid_empresa()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getid_empresa().toString();
				}
				if(saldocontable.getid_empresa()!=null)
				{
					strValorNuevo=saldocontable.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getid_sucursal().equals(saldocontable.getSaldoContableOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getid_sucursal()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getid_sucursal().toString();
				}
				if(saldocontable.getid_sucursal()!=null)
				{
					strValorNuevo=saldocontable.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getid_ejercicio().equals(saldocontable.getSaldoContableOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getid_ejercicio()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getid_ejercicio().toString();
				}
				if(saldocontable.getid_ejercicio()!=null)
				{
					strValorNuevo=saldocontable.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getid_periodo().equals(saldocontable.getSaldoContableOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getid_periodo()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getid_periodo().toString();
				}
				if(saldocontable.getid_periodo()!=null)
				{
					strValorNuevo=saldocontable.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getid_anio().equals(saldocontable.getSaldoContableOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getid_anio()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getid_anio().toString();
				}
				if(saldocontable.getid_anio()!=null)
				{
					strValorNuevo=saldocontable.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getid_mes().equals(saldocontable.getSaldoContableOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getid_mes()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getid_mes().toString();
				}
				if(saldocontable.getid_mes()!=null)
				{
					strValorNuevo=saldocontable.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getid_cuenta_contable().equals(saldocontable.getSaldoContableOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getid_cuenta_contable().toString();
				}
				if(saldocontable.getid_cuenta_contable()!=null)
				{
					strValorNuevo=saldocontable.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getdebito_mone_local().equals(saldocontable.getSaldoContableOriginal().getdebito_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getdebito_mone_local()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getdebito_mone_local().toString();
				}
				if(saldocontable.getdebito_mone_local()!=null)
				{
					strValorNuevo=saldocontable.getdebito_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.DEBITOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getcredito_mone_local().equals(saldocontable.getSaldoContableOriginal().getcredito_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getcredito_mone_local()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getcredito_mone_local().toString();
				}
				if(saldocontable.getcredito_mone_local()!=null)
				{
					strValorNuevo=saldocontable.getcredito_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.CREDITOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getsaldo_mone_local().equals(saldocontable.getSaldoContableOriginal().getsaldo_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getsaldo_mone_local()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getsaldo_mone_local().toString();
				}
				if(saldocontable.getsaldo_mone_local()!=null)
				{
					strValorNuevo=saldocontable.getsaldo_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.SALDOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getdebito_mone_extra().equals(saldocontable.getSaldoContableOriginal().getdebito_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getdebito_mone_extra()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getdebito_mone_extra().toString();
				}
				if(saldocontable.getdebito_mone_extra()!=null)
				{
					strValorNuevo=saldocontable.getdebito_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.DEBITOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getcredito_mone_extra().equals(saldocontable.getSaldoContableOriginal().getcredito_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getcredito_mone_extra()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getcredito_mone_extra().toString();
				}
				if(saldocontable.getcredito_mone_extra()!=null)
				{
					strValorNuevo=saldocontable.getcredito_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.CREDITOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(saldocontable.getIsNew()||!saldocontable.getsaldo_mone_extra().equals(saldocontable.getSaldoContableOriginal().getsaldo_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(saldocontable.getSaldoContableOriginal().getsaldo_mone_extra()!=null)
				{
					strValorActual=saldocontable.getSaldoContableOriginal().getsaldo_mone_extra().toString();
				}
				if(saldocontable.getsaldo_mone_extra()!=null)
				{
					strValorNuevo=saldocontable.getsaldo_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SaldoContableConstantesFunciones.SALDOMONEEXTRA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSaldoContableRelacionesWithConnection(SaldoContable saldocontable) throws Exception {

		if(!saldocontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSaldoContableRelacionesBase(saldocontable,true);
		}
	}

	public void saveSaldoContableRelaciones(SaldoContable saldocontable)throws Exception {

		if(!saldocontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSaldoContableRelacionesBase(saldocontable,false);
		}
	}

	public void saveSaldoContableRelacionesBase(SaldoContable saldocontable,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SaldoContable-saveRelacionesWithConnection");}
	

			this.setSaldoContable(saldocontable);

			if(SaldoContableLogicAdditional.validarSaveRelaciones(saldocontable,this)) {

				SaldoContableLogicAdditional.updateRelacionesToSave(saldocontable,this);

				if((saldocontable.getIsNew()||saldocontable.getIsChanged())&&!saldocontable.getIsDeleted()) {
					this.saveSaldoContable();
					this.saveSaldoContableRelacionesDetalles();

				} else if(saldocontable.getIsDeleted()) {
					this.saveSaldoContableRelacionesDetalles();
					this.saveSaldoContable();
				}

				SaldoContableLogicAdditional.updateRelacionesToSaveAfter(saldocontable,this);

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
	
	
	private void saveSaldoContableRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSaldoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SaldoContableConstantesFunciones.getClassesForeignKeysOfSaldoContable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SaldoContableConstantesFunciones.getClassesRelationshipsOfSaldoContable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.FuncionEstrucConstantesFunciones;
import com.bydan.erp.nomina.util.FuncionEstrucParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FuncionEstrucParameterGeneral;
import com.bydan.erp.nomina.business.entity.FuncionEstruc;
import com.bydan.erp.nomina.business.logic.FuncionEstrucLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FuncionEstrucLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FuncionEstrucLogic.class);
	
	protected FuncionEstrucDataAccess funcionestrucDataAccess; 	
	protected FuncionEstruc funcionestruc;
	protected List<FuncionEstruc> funcionestrucs;
	protected Object funcionestrucObject;	
	protected List<Object> funcionestrucsObject;
	
	public static ClassValidator<FuncionEstruc> funcionestrucValidator = new ClassValidator<FuncionEstruc>(FuncionEstruc.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FuncionEstrucLogicAdditional funcionestrucLogicAdditional=null;
	
	public FuncionEstrucLogicAdditional getFuncionEstrucLogicAdditional() {
		return this.funcionestrucLogicAdditional;
	}
	
	public void setFuncionEstrucLogicAdditional(FuncionEstrucLogicAdditional funcionestrucLogicAdditional) {
		try {
			this.funcionestrucLogicAdditional=funcionestrucLogicAdditional;
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
	
	
	
	
	public  FuncionEstrucLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.funcionestrucDataAccess = new FuncionEstrucDataAccess();
			
			this.funcionestrucs= new ArrayList<FuncionEstruc>();
			this.funcionestruc= new FuncionEstruc();
			
			this.funcionestrucObject=new Object();
			this.funcionestrucsObject=new ArrayList<Object>();
				
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
			
			this.funcionestrucDataAccess.setConnexionType(this.connexionType);
			this.funcionestrucDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FuncionEstrucLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.funcionestrucDataAccess = new FuncionEstrucDataAccess();
			this.funcionestrucs= new ArrayList<FuncionEstruc>();
			this.funcionestruc= new FuncionEstruc();
			this.funcionestrucObject=new Object();
			this.funcionestrucsObject=new ArrayList<Object>();
			
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
			
			this.funcionestrucDataAccess.setConnexionType(this.connexionType);
			this.funcionestrucDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FuncionEstruc getFuncionEstruc() throws Exception {	
		FuncionEstrucLogicAdditional.checkFuncionEstrucToGet(funcionestruc,this.datosCliente,this.arrDatoGeneral);
		FuncionEstrucLogicAdditional.updateFuncionEstrucToGet(funcionestruc,this.arrDatoGeneral);
		
		return funcionestruc;
	}
		
	public void setFuncionEstruc(FuncionEstruc newFuncionEstruc) {
		this.funcionestruc = newFuncionEstruc;
	}
	
	public FuncionEstrucDataAccess getFuncionEstrucDataAccess() {
		return funcionestrucDataAccess;
	}
	
	public void setFuncionEstrucDataAccess(FuncionEstrucDataAccess newfuncionestrucDataAccess) {
		this.funcionestrucDataAccess = newfuncionestrucDataAccess;
	}
	
	public List<FuncionEstruc> getFuncionEstrucs() throws Exception {		
		this.quitarFuncionEstrucsNulos();
		
		FuncionEstrucLogicAdditional.checkFuncionEstrucToGets(funcionestrucs,this.datosCliente,this.arrDatoGeneral);
		
		for (FuncionEstruc funcionestrucLocal: funcionestrucs ) {
			FuncionEstrucLogicAdditional.updateFuncionEstrucToGet(funcionestrucLocal,this.arrDatoGeneral);
		}
		
		return funcionestrucs;
	}
	
	public void setFuncionEstrucs(List<FuncionEstruc> newFuncionEstrucs) {
		this.funcionestrucs = newFuncionEstrucs;
	}
	
	public Object getFuncionEstrucObject() {	
		this.funcionestrucObject=this.funcionestrucDataAccess.getEntityObject();
		return this.funcionestrucObject;
	}
		
	public void setFuncionEstrucObject(Object newFuncionEstrucObject) {
		this.funcionestrucObject = newFuncionEstrucObject;
	}
	
	public List<Object> getFuncionEstrucsObject() {		
		this.funcionestrucsObject=this.funcionestrucDataAccess.getEntitiesObject();
		return this.funcionestrucsObject;
	}
		
	public void setFuncionEstrucsObject(List<Object> newFuncionEstrucsObject) {
		this.funcionestrucsObject = newFuncionEstrucsObject;
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
		
		if(this.funcionestrucDataAccess!=null) {
			this.funcionestrucDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			funcionestrucDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			funcionestrucDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		funcionestruc = new  FuncionEstruc();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			funcionestruc=funcionestrucDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.funcionestruc,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestruc);
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
		funcionestruc = new  FuncionEstruc();
		  		  
        try {
			
			funcionestruc=funcionestrucDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.funcionestruc,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestruc);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		funcionestruc = new  FuncionEstruc();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			funcionestruc=funcionestrucDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.funcionestruc,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestruc);
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
		funcionestruc = new  FuncionEstruc();
		  		  
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
		funcionestruc = new  FuncionEstruc();
		  		  
        try {
			
			funcionestruc=funcionestrucDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.funcionestruc,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestruc);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		funcionestruc = new  FuncionEstruc();
		  		  
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
		funcionestruc = new  FuncionEstruc();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =funcionestrucDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		funcionestruc = new  FuncionEstruc();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=funcionestrucDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		funcionestruc = new  FuncionEstruc();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =funcionestrucDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		funcionestruc = new  FuncionEstruc();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=funcionestrucDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		funcionestruc = new  FuncionEstruc();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =funcionestrucDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		funcionestruc = new  FuncionEstruc();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=funcionestrucDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestrucs=funcionestrucDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFuncionEstruc(funcionestrucs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
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
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		  		  
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
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		  		  
        try {			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestrucs=funcionestrucDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFuncionEstruc(funcionestrucs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		  		  
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
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFuncionEstruc(funcionestrucs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
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
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		  		  
        try {
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFuncionEstruc(funcionestrucs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
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
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFuncionEstruc(funcionestrucs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
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
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFuncionEstruc(funcionestrucs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		funcionestruc = new  FuncionEstruc();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestruc=funcionestrucDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFuncionEstruc(funcionestruc);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestruc);
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
		funcionestruc = new  FuncionEstruc();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestruc=funcionestrucDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFuncionEstruc(funcionestruc);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestruc);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestrucs=funcionestrucDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFuncionEstruc(funcionestrucs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
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
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		  		  
        try {
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestrucs=funcionestrucDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFuncionEstruc(funcionestrucs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFuncionEstrucsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getTodosFuncionEstrucsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFuncionEstruc(funcionestrucs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
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
	
	public  void  getTodosFuncionEstrucs(String sFinalQuery,Pagination pagination)throws Exception {
		funcionestrucs = new  ArrayList<FuncionEstruc>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFuncionEstruc(funcionestrucs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFuncionEstruc(FuncionEstruc funcionestruc) throws Exception {
		Boolean estaValidado=false;
		
		if(funcionestruc.getIsNew() || funcionestruc.getIsChanged()) { 
			this.invalidValues = funcionestrucValidator.getInvalidValues(funcionestruc);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(funcionestruc);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFuncionEstruc(List<FuncionEstruc> FuncionEstrucs) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FuncionEstruc funcionestrucLocal:funcionestrucs) {				
			estaValidadoObjeto=this.validarGuardarFuncionEstruc(funcionestrucLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFuncionEstruc(List<FuncionEstruc> FuncionEstrucs) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFuncionEstruc(funcionestrucs)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFuncionEstruc(FuncionEstruc FuncionEstruc) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFuncionEstruc(funcionestruc)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FuncionEstruc funcionestruc) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+funcionestruc.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FuncionEstrucConstantesFunciones.getFuncionEstrucLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"funcionestruc","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FuncionEstrucConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FuncionEstrucConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFuncionEstrucWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-saveFuncionEstrucWithConnection");connexion.begin();			
			
			FuncionEstrucLogicAdditional.checkFuncionEstrucToSave(this.funcionestruc,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FuncionEstrucLogicAdditional.updateFuncionEstrucToSave(this.funcionestruc,this.arrDatoGeneral);
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.funcionestruc,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFuncionEstruc();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFuncionEstruc(this.funcionestruc)) {
				FuncionEstrucDataAccess.save(this.funcionestruc, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.funcionestruc,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FuncionEstrucLogicAdditional.checkFuncionEstrucToSaveAfter(this.funcionestruc,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFuncionEstruc();
			
			connexion.commit();			
			
			if(this.funcionestruc.getIsDeleted()) {
				this.funcionestruc=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFuncionEstruc()throws Exception {	
		try {	
			
			FuncionEstrucLogicAdditional.checkFuncionEstrucToSave(this.funcionestruc,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FuncionEstrucLogicAdditional.updateFuncionEstrucToSave(this.funcionestruc,this.arrDatoGeneral);
			
			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.funcionestruc,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFuncionEstruc(this.funcionestruc)) {			
				FuncionEstrucDataAccess.save(this.funcionestruc, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.funcionestruc,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FuncionEstrucLogicAdditional.checkFuncionEstrucToSaveAfter(this.funcionestruc,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.funcionestruc.getIsDeleted()) {
				this.funcionestruc=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFuncionEstrucsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-saveFuncionEstrucsWithConnection");connexion.begin();			
			
			FuncionEstrucLogicAdditional.checkFuncionEstrucToSaves(funcionestrucs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFuncionEstrucs();
			
			Boolean validadoTodosFuncionEstruc=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FuncionEstruc funcionestrucLocal:funcionestrucs) {		
				if(funcionestrucLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FuncionEstrucLogicAdditional.updateFuncionEstrucToSave(funcionestrucLocal,this.arrDatoGeneral);
	        	
				FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),funcionestrucLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFuncionEstruc(funcionestrucLocal)) {
					FuncionEstrucDataAccess.save(funcionestrucLocal, connexion);				
				} else {
					validadoTodosFuncionEstruc=false;
				}
			}
			
			if(!validadoTodosFuncionEstruc) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FuncionEstrucLogicAdditional.checkFuncionEstrucToSavesAfter(funcionestrucs,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFuncionEstrucs();
			
			connexion.commit();		
			
			this.quitarFuncionEstrucsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFuncionEstrucs()throws Exception {				
		 try {	
			FuncionEstrucLogicAdditional.checkFuncionEstrucToSaves(funcionestrucs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFuncionEstruc=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FuncionEstruc funcionestrucLocal:funcionestrucs) {				
				if(funcionestrucLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FuncionEstrucLogicAdditional.updateFuncionEstrucToSave(funcionestrucLocal,this.arrDatoGeneral);
	        	
				FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),funcionestrucLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFuncionEstruc(funcionestrucLocal)) {				
					FuncionEstrucDataAccess.save(funcionestrucLocal, connexion);				
				} else {
					validadoTodosFuncionEstruc=false;
				}
			}
			
			if(!validadoTodosFuncionEstruc) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FuncionEstrucLogicAdditional.checkFuncionEstrucToSavesAfter(funcionestrucs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFuncionEstrucsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FuncionEstrucParameterReturnGeneral procesarAccionFuncionEstrucs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FuncionEstruc> funcionestrucs,FuncionEstrucParameterReturnGeneral funcionestrucParameterGeneral)throws Exception {
		 try {	
			FuncionEstrucParameterReturnGeneral funcionestrucReturnGeneral=new FuncionEstrucParameterReturnGeneral();
	
			FuncionEstrucLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,funcionestrucs,funcionestrucParameterGeneral,funcionestrucReturnGeneral);
			
			return funcionestrucReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FuncionEstrucParameterReturnGeneral procesarAccionFuncionEstrucsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FuncionEstruc> funcionestrucs,FuncionEstrucParameterReturnGeneral funcionestrucParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-procesarAccionFuncionEstrucsWithConnection");connexion.begin();			
			
			FuncionEstrucParameterReturnGeneral funcionestrucReturnGeneral=new FuncionEstrucParameterReturnGeneral();
	
			FuncionEstrucLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,funcionestrucs,funcionestrucParameterGeneral,funcionestrucReturnGeneral);
			
			this.connexion.commit();
			
			return funcionestrucReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FuncionEstrucParameterReturnGeneral procesarEventosFuncionEstrucs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FuncionEstruc> funcionestrucs,FuncionEstruc funcionestruc,FuncionEstrucParameterReturnGeneral funcionestrucParameterGeneral,Boolean isEsNuevoFuncionEstruc,ArrayList<Classe> clases)throws Exception {
		 try {	
			FuncionEstrucParameterReturnGeneral funcionestrucReturnGeneral=new FuncionEstrucParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				funcionestrucReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FuncionEstrucLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,funcionestrucs,funcionestruc,funcionestrucParameterGeneral,funcionestrucReturnGeneral,isEsNuevoFuncionEstruc,clases);
			
			return funcionestrucReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FuncionEstrucParameterReturnGeneral procesarEventosFuncionEstrucsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FuncionEstruc> funcionestrucs,FuncionEstruc funcionestruc,FuncionEstrucParameterReturnGeneral funcionestrucParameterGeneral,Boolean isEsNuevoFuncionEstruc,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-procesarEventosFuncionEstrucsWithConnection");connexion.begin();			
			
			FuncionEstrucParameterReturnGeneral funcionestrucReturnGeneral=new FuncionEstrucParameterReturnGeneral();
	
			funcionestrucReturnGeneral.setFuncionEstruc(funcionestruc);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				funcionestrucReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FuncionEstrucLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,funcionestrucs,funcionestruc,funcionestrucParameterGeneral,funcionestrucReturnGeneral,isEsNuevoFuncionEstruc,clases);
			
			this.connexion.commit();
			
			return funcionestrucReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FuncionEstrucParameterReturnGeneral procesarImportacionFuncionEstrucsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FuncionEstrucParameterReturnGeneral funcionestrucParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-procesarImportacionFuncionEstrucsWithConnection");connexion.begin();			
			
			FuncionEstrucParameterReturnGeneral funcionestrucReturnGeneral=new FuncionEstrucParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.funcionestrucs=new ArrayList<FuncionEstruc>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.funcionestruc=new FuncionEstruc();
				
				
				if(conColumnasBase) {this.funcionestruc.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.funcionestruc.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.funcionestruc.setnombre(arrColumnas[iColumn++]);
				this.funcionestruc.setdescripcion(arrColumnas[iColumn++]);
				
				this.funcionestrucs.add(this.funcionestruc);
			}
			
			this.saveFuncionEstrucs();
			
			this.connexion.commit();
			
			funcionestrucReturnGeneral.setConRetornoEstaProcesado(true);
			funcionestrucReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return funcionestrucReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFuncionEstrucsEliminados() throws Exception {				
		
		List<FuncionEstruc> funcionestrucsAux= new ArrayList<FuncionEstruc>();
		
		for(FuncionEstruc funcionestruc:funcionestrucs) {
			if(!funcionestruc.getIsDeleted()) {
				funcionestrucsAux.add(funcionestruc);
			}
		}
		
		funcionestrucs=funcionestrucsAux;
	}
	
	public void quitarFuncionEstrucsNulos() throws Exception {				
		
		List<FuncionEstruc> funcionestrucsAux= new ArrayList<FuncionEstruc>();
		
		for(FuncionEstruc funcionestruc : this.funcionestrucs) {
			if(funcionestruc==null) {
				funcionestrucsAux.add(funcionestruc);
			}
		}
		
		//this.funcionestrucs=funcionestrucsAux;
		
		this.funcionestrucs.removeAll(funcionestrucsAux);
	}
	
	public void getSetVersionRowFuncionEstrucWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(funcionestruc.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((funcionestruc.getIsDeleted() || (funcionestruc.getIsChanged()&&!funcionestruc.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=funcionestrucDataAccess.getSetVersionRowFuncionEstruc(connexion,funcionestruc.getId());
				
				if(!funcionestruc.getVersionRow().equals(timestamp)) {	
					funcionestruc.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				funcionestruc.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFuncionEstruc()throws Exception {	
		
		if(funcionestruc.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((funcionestruc.getIsDeleted() || (funcionestruc.getIsChanged()&&!funcionestruc.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=funcionestrucDataAccess.getSetVersionRowFuncionEstruc(connexion,funcionestruc.getId());
			
			try {							
				if(!funcionestruc.getVersionRow().equals(timestamp)) {	
					funcionestruc.setVersionRow(timestamp);
				}
				
				funcionestruc.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFuncionEstrucsWithConnection()throws Exception {	
		if(funcionestrucs!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FuncionEstruc funcionestrucAux:funcionestrucs) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(funcionestrucAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(funcionestrucAux.getIsDeleted() || (funcionestrucAux.getIsChanged()&&!funcionestrucAux.getIsNew())) {
						
						timestamp=funcionestrucDataAccess.getSetVersionRowFuncionEstruc(connexion,funcionestrucAux.getId());
						
						if(!funcionestruc.getVersionRow().equals(timestamp)) {	
							funcionestrucAux.setVersionRow(timestamp);
						}
								
						funcionestrucAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFuncionEstrucs()throws Exception {	
		if(funcionestrucs!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FuncionEstruc funcionestrucAux:funcionestrucs) {
					if(funcionestrucAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(funcionestrucAux.getIsDeleted() || (funcionestrucAux.getIsChanged()&&!funcionestrucAux.getIsNew())) {
						
						timestamp=funcionestrucDataAccess.getSetVersionRowFuncionEstruc(connexion,funcionestrucAux.getId());
						
						if(!funcionestrucAux.getVersionRow().equals(timestamp)) {	
							funcionestrucAux.setVersionRow(timestamp);
						}
						
													
						funcionestrucAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FuncionEstrucParameterReturnGeneral cargarCombosLoteForeignKeyFuncionEstrucWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalFuncion) throws Exception {
		FuncionEstrucParameterReturnGeneral  funcionestrucReturnGeneral =new FuncionEstrucParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-cargarCombosLoteForeignKeyFuncionEstrucWithConnection");connexion.begin();
			
			funcionestrucReturnGeneral =new FuncionEstrucParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			funcionestrucReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			funcionestrucReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			funcionestrucReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Funcion> funcionsForeignKey=new ArrayList<Funcion>();
			FuncionLogic funcionLogic=new FuncionLogic();
			funcionLogic.setConnexion(this.connexion);
			funcionLogic.getFuncionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFuncion.equals("NONE")) {
				funcionLogic.getTodosFuncions(finalQueryGlobalFuncion,new Pagination());
				funcionsForeignKey=funcionLogic.getFuncions();
			}

			funcionestrucReturnGeneral.setfuncionsForeignKey(funcionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return funcionestrucReturnGeneral;
	}
	
	public FuncionEstrucParameterReturnGeneral cargarCombosLoteForeignKeyFuncionEstruc(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalFuncion) throws Exception {
		FuncionEstrucParameterReturnGeneral  funcionestrucReturnGeneral =new FuncionEstrucParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			funcionestrucReturnGeneral =new FuncionEstrucParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			funcionestrucReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			funcionestrucReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			funcionestrucReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Funcion> funcionsForeignKey=new ArrayList<Funcion>();
			FuncionLogic funcionLogic=new FuncionLogic();
			funcionLogic.setConnexion(this.connexion);
			funcionLogic.getFuncionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFuncion.equals("NONE")) {
				funcionLogic.getTodosFuncions(finalQueryGlobalFuncion,new Pagination());
				funcionsForeignKey=funcionLogic.getFuncions();
			}

			funcionestrucReturnGeneral.setfuncionsForeignKey(funcionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return funcionestrucReturnGeneral;
	}
	
	
	public void deepLoad(FuncionEstruc funcionestruc,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FuncionEstrucLogicAdditional.updateFuncionEstrucToGet(funcionestruc,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		funcionestruc.setEmpresa(funcionestrucDataAccess.getEmpresa(connexion,funcionestruc));
		funcionestruc.setSucursal(funcionestrucDataAccess.getSucursal(connexion,funcionestruc));
		funcionestruc.setEstructura(funcionestrucDataAccess.getEstructura(connexion,funcionestruc));
		funcionestruc.setFuncion(funcionestrucDataAccess.getFuncion(connexion,funcionestruc));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				funcionestruc.setEmpresa(funcionestrucDataAccess.getEmpresa(connexion,funcionestruc));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				funcionestruc.setSucursal(funcionestrucDataAccess.getSucursal(connexion,funcionestruc));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				funcionestruc.setEstructura(funcionestrucDataAccess.getEstructura(connexion,funcionestruc));
				continue;
			}

			if(clas.clas.equals(Funcion.class)) {
				funcionestruc.setFuncion(funcionestrucDataAccess.getFuncion(connexion,funcionestruc));
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
			funcionestruc.setEmpresa(funcionestrucDataAccess.getEmpresa(connexion,funcionestruc));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			funcionestruc.setSucursal(funcionestrucDataAccess.getSucursal(connexion,funcionestruc));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			funcionestruc.setEstructura(funcionestrucDataAccess.getEstructura(connexion,funcionestruc));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Funcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			funcionestruc.setFuncion(funcionestrucDataAccess.getFuncion(connexion,funcionestruc));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		funcionestruc.setEmpresa(funcionestrucDataAccess.getEmpresa(connexion,funcionestruc));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(funcionestruc.getEmpresa(),isDeep,deepLoadType,clases);
				
		funcionestruc.setSucursal(funcionestrucDataAccess.getSucursal(connexion,funcionestruc));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(funcionestruc.getSucursal(),isDeep,deepLoadType,clases);
				
		funcionestruc.setEstructura(funcionestrucDataAccess.getEstructura(connexion,funcionestruc));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(funcionestruc.getEstructura(),isDeep,deepLoadType,clases);
				
		funcionestruc.setFuncion(funcionestrucDataAccess.getFuncion(connexion,funcionestruc));
		FuncionLogic funcionLogic= new FuncionLogic(connexion);
		funcionLogic.deepLoad(funcionestruc.getFuncion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				funcionestruc.setEmpresa(funcionestrucDataAccess.getEmpresa(connexion,funcionestruc));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(funcionestruc.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				funcionestruc.setSucursal(funcionestrucDataAccess.getSucursal(connexion,funcionestruc));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(funcionestruc.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				funcionestruc.setEstructura(funcionestrucDataAccess.getEstructura(connexion,funcionestruc));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(funcionestruc.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Funcion.class)) {
				funcionestruc.setFuncion(funcionestrucDataAccess.getFuncion(connexion,funcionestruc));
				FuncionLogic funcionLogic= new FuncionLogic(connexion);
				funcionLogic.deepLoad(funcionestruc.getFuncion(),isDeep,deepLoadType,clases);				
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
			funcionestruc.setEmpresa(funcionestrucDataAccess.getEmpresa(connexion,funcionestruc));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(funcionestruc.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			funcionestruc.setSucursal(funcionestrucDataAccess.getSucursal(connexion,funcionestruc));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(funcionestruc.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			funcionestruc.setEstructura(funcionestrucDataAccess.getEstructura(connexion,funcionestruc));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(funcionestruc.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Funcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			funcionestruc.setFuncion(funcionestrucDataAccess.getFuncion(connexion,funcionestruc));
			FuncionLogic funcionLogic= new FuncionLogic(connexion);
			funcionLogic.deepLoad(funcionestruc.getFuncion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FuncionEstruc funcionestruc,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FuncionEstrucLogicAdditional.updateFuncionEstrucToSave(funcionestruc,this.arrDatoGeneral);
			
FuncionEstrucDataAccess.save(funcionestruc, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(funcionestruc.getEmpresa(),connexion);

		SucursalDataAccess.save(funcionestruc.getSucursal(),connexion);

		EstructuraDataAccess.save(funcionestruc.getEstructura(),connexion);

		FuncionDataAccess.save(funcionestruc.getFuncion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(funcionestruc.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(funcionestruc.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(funcionestruc.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Funcion.class)) {
				FuncionDataAccess.save(funcionestruc.getFuncion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(funcionestruc.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(funcionestruc.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(funcionestruc.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(funcionestruc.getSucursal(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(funcionestruc.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(funcionestruc.getEstructura(),isDeep,deepLoadType,clases);
				

		FuncionDataAccess.save(funcionestruc.getFuncion(),connexion);
		FuncionLogic funcionLogic= new FuncionLogic(connexion);
		funcionLogic.deepLoad(funcionestruc.getFuncion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(funcionestruc.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(funcionestruc.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(funcionestruc.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(funcionestruc.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(funcionestruc.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(funcionestruc.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Funcion.class)) {
				FuncionDataAccess.save(funcionestruc.getFuncion(),connexion);
				FuncionLogic funcionLogic= new FuncionLogic(connexion);
				funcionLogic.deepSave(funcionestruc.getFuncion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FuncionEstruc.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(funcionestruc,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(funcionestruc);
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
			this.deepLoad(this.funcionestruc,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestruc);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FuncionEstruc.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(funcionestrucs!=null) {
				for(FuncionEstruc funcionestruc:funcionestrucs) {
					this.deepLoad(funcionestruc,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(funcionestrucs);
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
			if(funcionestrucs!=null) {
				for(FuncionEstruc funcionestruc:funcionestrucs) {
					this.deepLoad(funcionestruc,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(funcionestrucs);
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
			this.getNewConnexionToDeep(FuncionEstruc.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(funcionestruc,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FuncionEstruc.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(funcionestrucs!=null) {
				for(FuncionEstruc funcionestruc:funcionestrucs) {
					this.deepSave(funcionestruc,isDeep,deepLoadType,clases);
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
			if(funcionestrucs!=null) {
				for(FuncionEstruc funcionestruc:funcionestrucs) {
					this.deepSave(funcionestruc,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFuncionEstrucsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FuncionEstrucConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFuncionEstrucsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FuncionEstrucConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFuncionEstrucsFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,FuncionEstrucConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFuncionEstrucsFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,FuncionEstrucConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFuncionEstrucsFK_IdFuncionWithConnection(String sFinalQuery,Pagination pagination,Long id_funcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFuncion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFuncion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_funcion,FuncionEstrucConstantesFunciones.IDFUNCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFuncion);

			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFuncion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFuncionEstrucsFK_IdFuncion(String sFinalQuery,Pagination pagination,Long id_funcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFuncion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFuncion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_funcion,FuncionEstrucConstantesFunciones.IDFUNCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFuncion);

			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFuncion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFuncionEstrucsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FuncionEstruc.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FuncionEstrucConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFuncionEstrucsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FuncionEstrucConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FuncionEstrucLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(this.funcionestrucs);
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
			if(FuncionEstrucConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FuncionEstrucDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FuncionEstruc funcionestruc,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FuncionEstrucConstantesFunciones.ISCONAUDITORIA) {
				if(funcionestruc.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FuncionEstrucDataAccess.TABLENAME, funcionestruc.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FuncionEstrucConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FuncionEstrucLogic.registrarAuditoriaDetallesFuncionEstruc(connexion,funcionestruc,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(funcionestruc.getIsDeleted()) {
					/*if(!funcionestruc.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FuncionEstrucDataAccess.TABLENAME, funcionestruc.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FuncionEstrucLogic.registrarAuditoriaDetallesFuncionEstruc(connexion,funcionestruc,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FuncionEstrucDataAccess.TABLENAME, funcionestruc.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(funcionestruc.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FuncionEstrucDataAccess.TABLENAME, funcionestruc.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FuncionEstrucConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FuncionEstrucLogic.registrarAuditoriaDetallesFuncionEstruc(connexion,funcionestruc,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFuncionEstruc(Connexion connexion,FuncionEstruc funcionestruc)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(funcionestruc.getIsNew()||!funcionestruc.getid_empresa().equals(funcionestruc.getFuncionEstrucOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(funcionestruc.getFuncionEstrucOriginal().getid_empresa()!=null)
				{
					strValorActual=funcionestruc.getFuncionEstrucOriginal().getid_empresa().toString();
				}
				if(funcionestruc.getid_empresa()!=null)
				{
					strValorNuevo=funcionestruc.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FuncionEstrucConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(funcionestruc.getIsNew()||!funcionestruc.getid_sucursal().equals(funcionestruc.getFuncionEstrucOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(funcionestruc.getFuncionEstrucOriginal().getid_sucursal()!=null)
				{
					strValorActual=funcionestruc.getFuncionEstrucOriginal().getid_sucursal().toString();
				}
				if(funcionestruc.getid_sucursal()!=null)
				{
					strValorNuevo=funcionestruc.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FuncionEstrucConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(funcionestruc.getIsNew()||!funcionestruc.getid_estructura().equals(funcionestruc.getFuncionEstrucOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(funcionestruc.getFuncionEstrucOriginal().getid_estructura()!=null)
				{
					strValorActual=funcionestruc.getFuncionEstrucOriginal().getid_estructura().toString();
				}
				if(funcionestruc.getid_estructura()!=null)
				{
					strValorNuevo=funcionestruc.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FuncionEstrucConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(funcionestruc.getIsNew()||!funcionestruc.getid_funcion().equals(funcionestruc.getFuncionEstrucOriginal().getid_funcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(funcionestruc.getFuncionEstrucOriginal().getid_funcion()!=null)
				{
					strValorActual=funcionestruc.getFuncionEstrucOriginal().getid_funcion().toString();
				}
				if(funcionestruc.getid_funcion()!=null)
				{
					strValorNuevo=funcionestruc.getid_funcion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FuncionEstrucConstantesFunciones.IDFUNCION,strValorActual,strValorNuevo);
			}	
			
			if(funcionestruc.getIsNew()||!funcionestruc.getnombre().equals(funcionestruc.getFuncionEstrucOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(funcionestruc.getFuncionEstrucOriginal().getnombre()!=null)
				{
					strValorActual=funcionestruc.getFuncionEstrucOriginal().getnombre();
				}
				if(funcionestruc.getnombre()!=null)
				{
					strValorNuevo=funcionestruc.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FuncionEstrucConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(funcionestruc.getIsNew()||!funcionestruc.getdescripcion().equals(funcionestruc.getFuncionEstrucOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(funcionestruc.getFuncionEstrucOriginal().getdescripcion()!=null)
				{
					strValorActual=funcionestruc.getFuncionEstrucOriginal().getdescripcion();
				}
				if(funcionestruc.getdescripcion()!=null)
				{
					strValorNuevo=funcionestruc.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FuncionEstrucConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFuncionEstrucRelacionesWithConnection(FuncionEstruc funcionestruc) throws Exception {

		if(!funcionestruc.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFuncionEstrucRelacionesBase(funcionestruc,true);
		}
	}

	public void saveFuncionEstrucRelaciones(FuncionEstruc funcionestruc)throws Exception {

		if(!funcionestruc.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFuncionEstrucRelacionesBase(funcionestruc,false);
		}
	}

	public void saveFuncionEstrucRelacionesBase(FuncionEstruc funcionestruc,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FuncionEstruc-saveRelacionesWithConnection");}
	

			this.setFuncionEstruc(funcionestruc);

			if(FuncionEstrucLogicAdditional.validarSaveRelaciones(funcionestruc,this)) {

				FuncionEstrucLogicAdditional.updateRelacionesToSave(funcionestruc,this);

				if((funcionestruc.getIsNew()||funcionestruc.getIsChanged())&&!funcionestruc.getIsDeleted()) {
					this.saveFuncionEstruc();
					this.saveFuncionEstrucRelacionesDetalles();

				} else if(funcionestruc.getIsDeleted()) {
					this.saveFuncionEstrucRelacionesDetalles();
					this.saveFuncionEstruc();
				}

				FuncionEstrucLogicAdditional.updateRelacionesToSaveAfter(funcionestruc,this);

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
	
	
	private void saveFuncionEstrucRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFuncionEstruc(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FuncionEstrucConstantesFunciones.getClassesForeignKeysOfFuncionEstruc(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFuncionEstruc(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FuncionEstrucConstantesFunciones.getClassesRelationshipsOfFuncionEstruc(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

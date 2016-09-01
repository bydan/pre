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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.EmpresaConstantesFunciones;
import com.bydan.erp.seguridad.util.EmpresaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.EmpresaParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Empresa;
import com.bydan.erp.seguridad.business.logic.EmpresaLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EmpresaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpresaLogic.class);
	
	protected EmpresaDataAccess empresaDataAccess; 	
	protected Empresa empresa;
	protected List<Empresa> empresas;
	protected Object empresaObject;	
	protected List<Object> empresasObject;
	
	public static ClassValidator<Empresa> empresaValidator = new ClassValidator<Empresa>(Empresa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpresaLogicAdditional empresaLogicAdditional=null;
	
	public EmpresaLogicAdditional getEmpresaLogicAdditional() {
		return this.empresaLogicAdditional;
	}
	
	public void setEmpresaLogicAdditional(EmpresaLogicAdditional empresaLogicAdditional) {
		try {
			this.empresaLogicAdditional=empresaLogicAdditional;
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
	
	
	
	
	public  EmpresaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empresaDataAccess = new EmpresaDataAccess();
			
			this.empresas= new ArrayList<Empresa>();
			this.empresa= new Empresa();
			
			this.empresaObject=new Object();
			this.empresasObject=new ArrayList<Object>();
				
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
			
			this.empresaDataAccess.setConnexionType(this.connexionType);
			this.empresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpresaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empresaDataAccess = new EmpresaDataAccess();
			this.empresas= new ArrayList<Empresa>();
			this.empresa= new Empresa();
			this.empresaObject=new Object();
			this.empresasObject=new ArrayList<Object>();
			
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
			
			this.empresaDataAccess.setConnexionType(this.connexionType);
			this.empresaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Empresa getEmpresa() throws Exception {	
		EmpresaLogicAdditional.checkEmpresaToGet(empresa,this.datosCliente,this.arrDatoGeneral);
		EmpresaLogicAdditional.updateEmpresaToGet(empresa,this.arrDatoGeneral);
		
		return empresa;
	}
		
	public void setEmpresa(Empresa newEmpresa) {
		this.empresa = newEmpresa;
	}
	
	public EmpresaDataAccess getEmpresaDataAccess() {
		return empresaDataAccess;
	}
	
	public void setEmpresaDataAccess(EmpresaDataAccess newempresaDataAccess) {
		this.empresaDataAccess = newempresaDataAccess;
	}
	
	public List<Empresa> getEmpresas() throws Exception {		
		this.quitarEmpresasNulos();
		
		EmpresaLogicAdditional.checkEmpresaToGets(empresas,this.datosCliente,this.arrDatoGeneral);
		
		for (Empresa empresaLocal: empresas ) {
			EmpresaLogicAdditional.updateEmpresaToGet(empresaLocal,this.arrDatoGeneral);
		}
		
		return empresas;
	}
	
	public void setEmpresas(List<Empresa> newEmpresas) {
		this.empresas = newEmpresas;
	}
	
	public Object getEmpresaObject() {	
		this.empresaObject=this.empresaDataAccess.getEntityObject();
		return this.empresaObject;
	}
		
	public void setEmpresaObject(Object newEmpresaObject) {
		this.empresaObject = newEmpresaObject;
	}
	
	public List<Object> getEmpresasObject() {		
		this.empresasObject=this.empresaDataAccess.getEntitiesObject();
		return this.empresasObject;
	}
		
	public void setEmpresasObject(List<Object> newEmpresasObject) {
		this.empresasObject = newEmpresasObject;
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
		
		if(this.empresaDataAccess!=null) {
			this.empresaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empresaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empresa = new  Empresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empresa=empresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresa);
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
		empresa = new  Empresa();
		  		  
        try {
			
			empresa=empresaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empresa = new  Empresa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empresa=empresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresa);
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
		empresa = new  Empresa();
		  		  
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
		empresa = new  Empresa();
		  		  
        try {
			
			empresa=empresaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empresa = new  Empresa();
		  		  
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
		empresa = new  Empresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empresa = new  Empresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empresaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empresa = new  Empresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empresa = new  Empresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empresaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empresa = new  Empresa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empresa = new  Empresa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empresaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empresas = new  ArrayList<Empresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresas=empresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpresa(empresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
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
		empresas = new  ArrayList<Empresa>();
		  		  
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
		empresas = new  ArrayList<Empresa>();
		  		  
        try {			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresas=empresaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpresa(empresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empresas = new  ArrayList<Empresa>();
		  		  
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
		empresas = new  ArrayList<Empresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresas=empresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpresa(empresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
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
		empresas = new  ArrayList<Empresa>();
		  		  
        try {
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresas=empresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpresa(empresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
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
		empresas = new  ArrayList<Empresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresas=empresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpresa(empresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
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
		empresas = new  ArrayList<Empresa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresas=empresaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpresa(empresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empresa = new  Empresa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresa=empresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpresa(empresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresa);
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
		empresa = new  Empresa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresa=empresaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpresa(empresa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empresas = new  ArrayList<Empresa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresas=empresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpresa(empresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
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
		empresas = new  ArrayList<Empresa>();
		  		  
        try {
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresas=empresaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpresa(empresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpresasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empresas = new  ArrayList<Empresa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getTodosEmpresasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresas=empresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpresa(empresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
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
	
	public  void  getTodosEmpresas(String sFinalQuery,Pagination pagination)throws Exception {
		empresas = new  ArrayList<Empresa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresas=empresaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpresa(empresas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpresa(Empresa empresa) throws Exception {
		Boolean estaValidado=false;
		
		if(empresa.getIsNew() || empresa.getIsChanged()) { 
			this.invalidValues = empresaValidator.getInvalidValues(empresa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empresa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpresa(List<Empresa> Empresas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Empresa empresaLocal:empresas) {				
			estaValidadoObjeto=this.validarGuardarEmpresa(empresaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpresa(List<Empresa> Empresas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpresa(empresas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpresa(Empresa Empresa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpresa(empresa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Empresa empresa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empresa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpresaConstantesFunciones.getEmpresaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empresa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpresaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpresaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-saveEmpresaWithConnection");connexion.begin();			
			
			EmpresaLogicAdditional.checkEmpresaToSave(this.empresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpresaLogicAdditional.updateEmpresaToSave(this.empresa,this.arrDatoGeneral);
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpresa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpresa(this.empresa)) {
				EmpresaDataAccess.save(this.empresa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpresaLogicAdditional.checkEmpresaToSaveAfter(this.empresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpresa();
			
			connexion.commit();			
			
			if(this.empresa.getIsDeleted()) {
				this.empresa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpresa()throws Exception {	
		try {	
			
			EmpresaLogicAdditional.checkEmpresaToSave(this.empresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpresaLogicAdditional.updateEmpresaToSave(this.empresa,this.arrDatoGeneral);
			
			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empresa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpresa(this.empresa)) {			
				EmpresaDataAccess.save(this.empresa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpresaLogicAdditional.checkEmpresaToSaveAfter(this.empresa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empresa.getIsDeleted()) {
				this.empresa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpresasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-saveEmpresasWithConnection");connexion.begin();			
			
			EmpresaLogicAdditional.checkEmpresaToSaves(empresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpresas();
			
			Boolean validadoTodosEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Empresa empresaLocal:empresas) {		
				if(empresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpresaLogicAdditional.updateEmpresaToSave(empresaLocal,this.arrDatoGeneral);
	        	
				EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpresa(empresaLocal)) {
					EmpresaDataAccess.save(empresaLocal, connexion);				
				} else {
					validadoTodosEmpresa=false;
				}
			}
			
			if(!validadoTodosEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpresaLogicAdditional.checkEmpresaToSavesAfter(empresas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpresas();
			
			connexion.commit();		
			
			this.quitarEmpresasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpresas()throws Exception {				
		 try {	
			EmpresaLogicAdditional.checkEmpresaToSaves(empresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpresa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Empresa empresaLocal:empresas) {				
				if(empresaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpresaLogicAdditional.updateEmpresaToSave(empresaLocal,this.arrDatoGeneral);
	        	
				EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empresaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpresa(empresaLocal)) {				
					EmpresaDataAccess.save(empresaLocal, connexion);				
				} else {
					validadoTodosEmpresa=false;
				}
			}
			
			if(!validadoTodosEmpresa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpresaLogicAdditional.checkEmpresaToSavesAfter(empresas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpresasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpresaParameterReturnGeneral procesarAccionEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Empresa> empresas,EmpresaParameterReturnGeneral empresaParameterGeneral)throws Exception {
		 try {	
			EmpresaParameterReturnGeneral empresaReturnGeneral=new EmpresaParameterReturnGeneral();
	
			EmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empresas,empresaParameterGeneral,empresaReturnGeneral);
			
			return empresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpresaParameterReturnGeneral procesarAccionEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Empresa> empresas,EmpresaParameterReturnGeneral empresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-procesarAccionEmpresasWithConnection");connexion.begin();			
			
			EmpresaParameterReturnGeneral empresaReturnGeneral=new EmpresaParameterReturnGeneral();
	
			EmpresaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empresas,empresaParameterGeneral,empresaReturnGeneral);
			
			this.connexion.commit();
			
			return empresaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpresaParameterReturnGeneral procesarEventosEmpresas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Empresa> empresas,Empresa empresa,EmpresaParameterReturnGeneral empresaParameterGeneral,Boolean isEsNuevoEmpresa,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpresaParameterReturnGeneral empresaReturnGeneral=new EmpresaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empresas,empresa,empresaParameterGeneral,empresaReturnGeneral,isEsNuevoEmpresa,clases);
			
			return empresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpresaParameterReturnGeneral procesarEventosEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Empresa> empresas,Empresa empresa,EmpresaParameterReturnGeneral empresaParameterGeneral,Boolean isEsNuevoEmpresa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-procesarEventosEmpresasWithConnection");connexion.begin();			
			
			EmpresaParameterReturnGeneral empresaReturnGeneral=new EmpresaParameterReturnGeneral();
	
			empresaReturnGeneral.setEmpresa(empresa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empresaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpresaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empresas,empresa,empresaParameterGeneral,empresaReturnGeneral,isEsNuevoEmpresa,clases);
			
			this.connexion.commit();
			
			return empresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpresaParameterReturnGeneral procesarImportacionEmpresasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpresaParameterReturnGeneral empresaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-procesarImportacionEmpresasWithConnection");connexion.begin();			
			
			EmpresaParameterReturnGeneral empresaReturnGeneral=new EmpresaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empresas=new ArrayList<Empresa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empresa=new Empresa();
				
				
				if(conColumnasBase) {this.empresa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empresa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empresa.setnombre(arrColumnas[iColumn++]);
			this.empresa.setdireccion(arrColumnas[iColumn++]);
				this.empresa.setruc(arrColumnas[iColumn++]);
				this.empresa.setmail(arrColumnas[iColumn++]);
				this.empresa.settelefono(arrColumnas[iColumn++]);
				this.empresa.setfax(arrColumnas[iColumn++]);
				this.empresa.setcodigo_postal(arrColumnas[iColumn++]);
				this.empresa.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.empresa.setactividad_principal(arrColumnas[iColumn++]);
				this.empresa.setactividad_secundaria(arrColumnas[iColumn++]);
				this.empresa.setcontador_nombre(arrColumnas[iColumn++]);
				this.empresa.setcontador_ruc(arrColumnas[iColumn++]);
				this.empresa.setcontador_licencia(arrColumnas[iColumn++]);
				this.empresa.setrepresentante_nombre(arrColumnas[iColumn++]);
				this.empresa.setrepresentante_cedula(arrColumnas[iColumn++]);
				
				this.empresas.add(this.empresa);
			}
			
			this.saveEmpresas();
			
			this.connexion.commit();
			
			empresaReturnGeneral.setConRetornoEstaProcesado(true);
			empresaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empresaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpresasEliminados() throws Exception {				
		
		List<Empresa> empresasAux= new ArrayList<Empresa>();
		
		for(Empresa empresa:empresas) {
			if(!empresa.getIsDeleted()) {
				empresasAux.add(empresa);
			}
		}
		
		empresas=empresasAux;
	}
	
	public void quitarEmpresasNulos() throws Exception {				
		
		List<Empresa> empresasAux= new ArrayList<Empresa>();
		
		for(Empresa empresa : this.empresas) {
			if(empresa==null) {
				empresasAux.add(empresa);
			}
		}
		
		//this.empresas=empresasAux;
		
		this.empresas.removeAll(empresasAux);
	}
	
	public void getSetVersionRowEmpresaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empresa.getIsDeleted() || (empresa.getIsChanged()&&!empresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empresaDataAccess.getSetVersionRowEmpresa(connexion,empresa.getId());
				
				if(!empresa.getVersionRow().equals(timestamp)) {	
					empresa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpresa()throws Exception {	
		
		if(empresa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empresa.getIsDeleted() || (empresa.getIsChanged()&&!empresa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empresaDataAccess.getSetVersionRowEmpresa(connexion,empresa.getId());
			
			try {							
				if(!empresa.getVersionRow().equals(timestamp)) {	
					empresa.setVersionRow(timestamp);
				}
				
				empresa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpresasWithConnection()throws Exception {	
		if(empresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Empresa empresaAux:empresas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empresaAux.getIsDeleted() || (empresaAux.getIsChanged()&&!empresaAux.getIsNew())) {
						
						timestamp=empresaDataAccess.getSetVersionRowEmpresa(connexion,empresaAux.getId());
						
						if(!empresa.getVersionRow().equals(timestamp)) {	
							empresaAux.setVersionRow(timestamp);
						}
								
						empresaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpresas()throws Exception {	
		if(empresas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Empresa empresaAux:empresas) {
					if(empresaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empresaAux.getIsDeleted() || (empresaAux.getIsChanged()&&!empresaAux.getIsNew())) {
						
						timestamp=empresaDataAccess.getSetVersionRowEmpresa(connexion,empresaAux.getId());
						
						if(!empresaAux.getVersionRow().equals(timestamp)) {	
							empresaAux.setVersionRow(timestamp);
						}
						
													
						empresaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpresaParameterReturnGeneral cargarCombosLoteForeignKeyEmpresaWithConnection(String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalTipoEmpresa) throws Exception {
		EmpresaParameterReturnGeneral  empresaReturnGeneral =new EmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpresaWithConnection");connexion.begin();
			
			empresaReturnGeneral =new EmpresaParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			empresaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			empresaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<TipoEmpresa> tipoempresasForeignKey=new ArrayList<TipoEmpresa>();
			TipoEmpresaLogic tipoempresaLogic=new TipoEmpresaLogic();
			tipoempresaLogic.setConnexion(this.connexion);
			tipoempresaLogic.getTipoEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEmpresa.equals("NONE")) {
				tipoempresaLogic.getTodosTipoEmpresas(finalQueryGlobalTipoEmpresa,new Pagination());
				tipoempresasForeignKey=tipoempresaLogic.getTipoEmpresas();
			}

			empresaReturnGeneral.settipoempresasForeignKey(tipoempresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empresaReturnGeneral;
	}
	
	public EmpresaParameterReturnGeneral cargarCombosLoteForeignKeyEmpresa(String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalTipoEmpresa) throws Exception {
		EmpresaParameterReturnGeneral  empresaReturnGeneral =new EmpresaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empresaReturnGeneral =new EmpresaParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			empresaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			empresaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<TipoEmpresa> tipoempresasForeignKey=new ArrayList<TipoEmpresa>();
			TipoEmpresaLogic tipoempresaLogic=new TipoEmpresaLogic();
			tipoempresaLogic.setConnexion(this.connexion);
			tipoempresaLogic.getTipoEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEmpresa.equals("NONE")) {
				tipoempresaLogic.getTodosTipoEmpresas(finalQueryGlobalTipoEmpresa,new Pagination());
				tipoempresasForeignKey=tipoempresaLogic.getTipoEmpresas();
			}

			empresaReturnGeneral.settipoempresasForeignKey(tipoempresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empresaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEmpresaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			SucursalLogic sucursalLogic=new SucursalLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEmpresaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Sucursal.class));
											
			

			sucursalLogic.setConnexion(this.getConnexion());
			sucursalLogic.setDatosCliente(this.datosCliente);
			sucursalLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Empresa empresa:this.empresas) {
				

				classes=new ArrayList<Classe>();
				classes=SucursalConstantesFunciones.getClassesForeignKeysOfSucursal(new ArrayList<Classe>(),DeepLoadType.NONE);

				sucursalLogic.setSucursals(empresa.sucursals);
				sucursalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Empresa empresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpresaLogicAdditional.updateEmpresaToGet(empresa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empresa.setPais(empresaDataAccess.getPais(connexion,empresa));
		empresa.setCiudad(empresaDataAccess.getCiudad(connexion,empresa));
		empresa.setTipoEmpresa(empresaDataAccess.getTipoEmpresa(connexion,empresa));
		empresa.setSucursals(empresaDataAccess.getSucursals(connexion,empresa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				empresa.setPais(empresaDataAccess.getPais(connexion,empresa));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				empresa.setCiudad(empresaDataAccess.getCiudad(connexion,empresa));
				continue;
			}

			if(clas.clas.equals(TipoEmpresa.class)) {
				empresa.setTipoEmpresa(empresaDataAccess.getTipoEmpresa(connexion,empresa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empresa.setSucursals(empresaDataAccess.getSucursals(connexion,empresa));

				if(this.isConDeep) {
					SucursalLogic sucursalLogic= new SucursalLogic(this.connexion);
					sucursalLogic.setSucursals(empresa.getSucursals());
					ArrayList<Classe> classesLocal=SucursalConstantesFunciones.getClassesForeignKeysOfSucursal(new ArrayList<Classe>(),DeepLoadType.NONE);
					sucursalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SucursalConstantesFunciones.refrescarForeignKeysDescripcionesSucursal(sucursalLogic.getSucursals());
					empresa.setSucursals(sucursalLogic.getSucursals());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empresa.setPais(empresaDataAccess.getPais(connexion,empresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empresa.setCiudad(empresaDataAccess.getCiudad(connexion,empresa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empresa.setTipoEmpresa(empresaDataAccess.getTipoEmpresa(connexion,empresa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Sucursal.class));
			empresa.setSucursals(empresaDataAccess.getSucursals(connexion,empresa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empresa.setPais(empresaDataAccess.getPais(connexion,empresa));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(empresa.getPais(),isDeep,deepLoadType,clases);
				
		empresa.setCiudad(empresaDataAccess.getCiudad(connexion,empresa));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(empresa.getCiudad(),isDeep,deepLoadType,clases);
				
		empresa.setTipoEmpresa(empresaDataAccess.getTipoEmpresa(connexion,empresa));
		TipoEmpresaLogic tipoempresaLogic= new TipoEmpresaLogic(connexion);
		tipoempresaLogic.deepLoad(empresa.getTipoEmpresa(),isDeep,deepLoadType,clases);
				

		empresa.setSucursals(empresaDataAccess.getSucursals(connexion,empresa));

		for(Sucursal sucursal:empresa.getSucursals()) {
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(sucursal,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				empresa.setPais(empresaDataAccess.getPais(connexion,empresa));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(empresa.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				empresa.setCiudad(empresaDataAccess.getCiudad(connexion,empresa));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(empresa.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEmpresa.class)) {
				empresa.setTipoEmpresa(empresaDataAccess.getTipoEmpresa(connexion,empresa));
				TipoEmpresaLogic tipoempresaLogic= new TipoEmpresaLogic(connexion);
				tipoempresaLogic.deepLoad(empresa.getTipoEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empresa.setSucursals(empresaDataAccess.getSucursals(connexion,empresa));

				for(Sucursal sucursal:empresa.getSucursals()) {
					SucursalLogic sucursalLogic= new SucursalLogic(connexion);
					sucursalLogic.deepLoad(sucursal,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empresa.setPais(empresaDataAccess.getPais(connexion,empresa));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(empresa.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empresa.setCiudad(empresaDataAccess.getCiudad(connexion,empresa));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(empresa.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empresa.setTipoEmpresa(empresaDataAccess.getTipoEmpresa(connexion,empresa));
			TipoEmpresaLogic tipoempresaLogic= new TipoEmpresaLogic(connexion);
			tipoempresaLogic.deepLoad(empresa.getTipoEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Sucursal.class));
			empresa.setSucursals(empresaDataAccess.getSucursals(connexion,empresa));

			for(Sucursal sucursal:empresa.getSucursals()) {
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(sucursal,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Empresa empresa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpresaLogicAdditional.updateEmpresaToSave(empresa,this.arrDatoGeneral);
			
EmpresaDataAccess.save(empresa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(empresa.getPais(),connexion);

		CiudadDataAccess.save(empresa.getCiudad(),connexion);

		TipoEmpresaDataAccess.save(empresa.getTipoEmpresa(),connexion);

		for(Sucursal sucursal:empresa.getSucursals()) {
			sucursal.setid_empresa(empresa.getId());
			SucursalDataAccess.save(sucursal,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(empresa.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(empresa.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoEmpresa.class)) {
				TipoEmpresaDataAccess.save(empresa.getTipoEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Sucursal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Sucursal sucursal:empresa.getSucursals()) {
					sucursal.setid_empresa(empresa.getId());
					SucursalDataAccess.save(sucursal,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(empresa.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(empresa.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(empresa.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(empresa.getCiudad(),isDeep,deepLoadType,clases);
				

		TipoEmpresaDataAccess.save(empresa.getTipoEmpresa(),connexion);
		TipoEmpresaLogic tipoempresaLogic= new TipoEmpresaLogic(connexion);
		tipoempresaLogic.deepLoad(empresa.getTipoEmpresa(),isDeep,deepLoadType,clases);
				

		for(Sucursal sucursal:empresa.getSucursals()) {
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursal.setid_empresa(empresa.getId());
			SucursalDataAccess.save(sucursal,connexion);
			sucursalLogic.deepSave(sucursal,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(empresa.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(empresa.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(empresa.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(empresa.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEmpresa.class)) {
				TipoEmpresaDataAccess.save(empresa.getTipoEmpresa(),connexion);
				TipoEmpresaLogic tipoempresaLogic= new TipoEmpresaLogic(connexion);
				tipoempresaLogic.deepSave(empresa.getTipoEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Sucursal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Sucursal sucursal:empresa.getSucursals()) {
					SucursalLogic sucursalLogic= new SucursalLogic(connexion);
					sucursal.setid_empresa(empresa.getId());
					SucursalDataAccess.save(sucursal,connexion);
					sucursalLogic.deepSave(sucursal,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Empresa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(empresa);
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
			this.deepLoad(this.empresa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Empresa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empresas!=null) {
				for(Empresa empresa:empresas) {
					this.deepLoad(empresa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(empresas);
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
			if(empresas!=null) {
				for(Empresa empresa:empresas) {
					this.deepLoad(empresa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(empresas);
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
			this.getNewConnexionToDeep(Empresa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empresa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Empresa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empresas!=null) {
				for(Empresa empresa:empresas) {
					this.deepSave(empresa,isDeep,deepLoadType,clases);
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
			if(empresas!=null) {
				for(Empresa empresa:empresas) {
					this.deepSave(empresa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpresasBusquedaPorIdPaisPorNombreWithConnection(String sFinalQuery,Pagination pagination,Long id_pais,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EmpresaConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",EmpresaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdPaisPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empresas=empresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpresasBusquedaPorIdPaisPorNombre(String sFinalQuery,Pagination pagination,Long id_pais,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EmpresaConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",EmpresaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdPaisPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empresas=empresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpresasFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,EmpresaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empresas=empresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpresasFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,EmpresaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empresas=empresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpresasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EmpresaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empresas=empresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpresasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EmpresaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empresas=empresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpresasFK_IdTipoEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_empresa,EmpresaConstantesFunciones.IDTIPOEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEmpresa);

			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empresas=empresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpresasFK_IdTipoEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_empresa,EmpresaConstantesFunciones.IDTIPOEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEmpresa);

			EmpresaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empresas=empresaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpresaPorIdPaisPorNombreWithConnection(Long id_pais,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empresa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EmpresaConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,EmpresaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			empresa=empresaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.empresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresa);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpresaPorIdPaisPorNombre(Long id_pais,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EmpresaConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,EmpresaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			empresa=empresaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.empresa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EmpresaConstantesFunciones.refrescarForeignKeysDescripcionesEmpresa(this.empresa);
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
			if(EmpresaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpresaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Empresa empresa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpresaConstantesFunciones.ISCONAUDITORIA) {
				if(empresa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpresaDataAccess.TABLENAME, empresa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpresaLogic.registrarAuditoriaDetallesEmpresa(connexion,empresa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empresa.getIsDeleted()) {
					/*if(!empresa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpresaDataAccess.TABLENAME, empresa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpresaLogic.registrarAuditoriaDetallesEmpresa(connexion,empresa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpresaDataAccess.TABLENAME, empresa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empresa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpresaDataAccess.TABLENAME, empresa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpresaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpresaLogic.registrarAuditoriaDetallesEmpresa(connexion,empresa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpresa(Connexion connexion,Empresa empresa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empresa.getIsNew()||!empresa.getid_pais().equals(empresa.getEmpresaOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getid_pais()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getid_pais().toString();
				}
				if(empresa.getid_pais()!=null)
				{
					strValorNuevo=empresa.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getid_ciudad().equals(empresa.getEmpresaOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getid_ciudad()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getid_ciudad().toString();
				}
				if(empresa.getid_ciudad()!=null)
				{
					strValorNuevo=empresa.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getid_tipo_empresa().equals(empresa.getEmpresaOriginal().getid_tipo_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getid_tipo_empresa()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getid_tipo_empresa().toString();
				}
				if(empresa.getid_tipo_empresa()!=null)
				{
					strValorNuevo=empresa.getid_tipo_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.IDTIPOEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getnombre().equals(empresa.getEmpresaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getnombre()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getnombre();
				}
				if(empresa.getnombre()!=null)
				{
					strValorNuevo=empresa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getdireccion().equals(empresa.getEmpresaOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getdireccion()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getdireccion();
				}
				if(empresa.getdireccion()!=null)
				{
					strValorNuevo=empresa.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getruc().equals(empresa.getEmpresaOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getruc()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getruc();
				}
				if(empresa.getruc()!=null)
				{
					strValorNuevo=empresa.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getmail().equals(empresa.getEmpresaOriginal().getmail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getmail()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getmail();
				}
				if(empresa.getmail()!=null)
				{
					strValorNuevo=empresa.getmail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.MAIL,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.gettelefono().equals(empresa.getEmpresaOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().gettelefono()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().gettelefono();
				}
				if(empresa.gettelefono()!=null)
				{
					strValorNuevo=empresa.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getfax().equals(empresa.getEmpresaOriginal().getfax()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getfax()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getfax();
				}
				if(empresa.getfax()!=null)
				{
					strValorNuevo=empresa.getfax() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.FAX,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getcodigo_postal().equals(empresa.getEmpresaOriginal().getcodigo_postal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getcodigo_postal()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getcodigo_postal();
				}
				if(empresa.getcodigo_postal()!=null)
				{
					strValorNuevo=empresa.getcodigo_postal() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.CODIGOPOSTAL,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getiva().equals(empresa.getEmpresaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getiva()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getiva().toString();
				}
				if(empresa.getiva()!=null)
				{
					strValorNuevo=empresa.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getactividad_principal().equals(empresa.getEmpresaOriginal().getactividad_principal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getactividad_principal()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getactividad_principal();
				}
				if(empresa.getactividad_principal()!=null)
				{
					strValorNuevo=empresa.getactividad_principal() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.ACTIVIDADPRINCIPAL,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getactividad_secundaria().equals(empresa.getEmpresaOriginal().getactividad_secundaria()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getactividad_secundaria()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getactividad_secundaria();
				}
				if(empresa.getactividad_secundaria()!=null)
				{
					strValorNuevo=empresa.getactividad_secundaria() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.ACTIVIDADSECUNDARIA,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getcontador_nombre().equals(empresa.getEmpresaOriginal().getcontador_nombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getcontador_nombre()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getcontador_nombre();
				}
				if(empresa.getcontador_nombre()!=null)
				{
					strValorNuevo=empresa.getcontador_nombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.CONTADORNOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getcontador_ruc().equals(empresa.getEmpresaOriginal().getcontador_ruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getcontador_ruc()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getcontador_ruc();
				}
				if(empresa.getcontador_ruc()!=null)
				{
					strValorNuevo=empresa.getcontador_ruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.CONTADORRUC,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getcontador_licencia().equals(empresa.getEmpresaOriginal().getcontador_licencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getcontador_licencia()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getcontador_licencia();
				}
				if(empresa.getcontador_licencia()!=null)
				{
					strValorNuevo=empresa.getcontador_licencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.CONTADORLICENCIA,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getrepresentante_nombre().equals(empresa.getEmpresaOriginal().getrepresentante_nombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getrepresentante_nombre()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getrepresentante_nombre();
				}
				if(empresa.getrepresentante_nombre()!=null)
				{
					strValorNuevo=empresa.getrepresentante_nombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.REPRESENTANTENOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(empresa.getIsNew()||!empresa.getrepresentante_cedula().equals(empresa.getEmpresaOriginal().getrepresentante_cedula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresa.getEmpresaOriginal().getrepresentante_cedula()!=null)
				{
					strValorActual=empresa.getEmpresaOriginal().getrepresentante_cedula();
				}
				if(empresa.getrepresentante_cedula()!=null)
				{
					strValorNuevo=empresa.getrepresentante_cedula() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaConstantesFunciones.REPRESENTANTECEDULA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpresaRelacionesWithConnection(Empresa empresa,List<Sucursal> sucursals) throws Exception {

		if(!empresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpresaRelacionesBase(empresa,sucursals,true);
		}
	}

	public void saveEmpresaRelaciones(Empresa empresa,List<Sucursal> sucursals)throws Exception {

		if(!empresa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpresaRelacionesBase(empresa,sucursals,false);
		}
	}

	public void saveEmpresaRelacionesBase(Empresa empresa,List<Sucursal> sucursals,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Empresa-saveRelacionesWithConnection");}
	
			empresa.setSucursals(sucursals);

			this.setEmpresa(empresa);

			if(EmpresaLogicAdditional.validarSaveRelaciones(empresa,this)) {

				EmpresaLogicAdditional.updateRelacionesToSave(empresa,this);

				if((empresa.getIsNew()||empresa.getIsChanged())&&!empresa.getIsDeleted()) {
					this.saveEmpresa();
					this.saveEmpresaRelacionesDetalles(sucursals);

				} else if(empresa.getIsDeleted()) {
					this.saveEmpresaRelacionesDetalles(sucursals);
					this.saveEmpresa();
				}

				EmpresaLogicAdditional.updateRelacionesToSaveAfter(empresa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			SucursalConstantesFunciones.InicializarGeneralEntityAuxiliaresSucursals(sucursals,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEmpresaRelacionesDetalles(List<Sucursal> sucursals)throws Exception {
		try {
	

			Long idEmpresaActual=this.getEmpresa().getId();

			SucursalLogic sucursalLogic_Desde_Empresa=new SucursalLogic();
			sucursalLogic_Desde_Empresa.setSucursals(sucursals);

			sucursalLogic_Desde_Empresa.setConnexion(this.getConnexion());
			sucursalLogic_Desde_Empresa.setDatosCliente(this.datosCliente);

			for(Sucursal sucursal_Desde_Empresa:sucursalLogic_Desde_Empresa.getSucursals()) {
				sucursal_Desde_Empresa.setid_empresa(idEmpresaActual);
			}

			sucursalLogic_Desde_Empresa.saveSucursals();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpresaConstantesFunciones.getClassesForeignKeysOfEmpresa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpresaConstantesFunciones.getClassesRelationshipsOfEmpresa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

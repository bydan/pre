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
import com.bydan.erp.contabilidad.util.EmpresaEspecialConstantesFunciones;
import com.bydan.erp.contabilidad.util.EmpresaEspecialParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.EmpresaEspecialParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.EmpresaEspecial;
import com.bydan.erp.contabilidad.business.logic.EmpresaEspecialLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EmpresaEspecialLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpresaEspecialLogic.class);
	
	protected EmpresaEspecialDataAccess empresaespecialDataAccess; 	
	protected EmpresaEspecial empresaespecial;
	protected List<EmpresaEspecial> empresaespecials;
	protected Object empresaespecialObject;	
	protected List<Object> empresaespecialsObject;
	
	public static ClassValidator<EmpresaEspecial> empresaespecialValidator = new ClassValidator<EmpresaEspecial>(EmpresaEspecial.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpresaEspecialLogicAdditional empresaespecialLogicAdditional=null;
	
	public EmpresaEspecialLogicAdditional getEmpresaEspecialLogicAdditional() {
		return this.empresaespecialLogicAdditional;
	}
	
	public void setEmpresaEspecialLogicAdditional(EmpresaEspecialLogicAdditional empresaespecialLogicAdditional) {
		try {
			this.empresaespecialLogicAdditional=empresaespecialLogicAdditional;
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
	
	
	
	
	public  EmpresaEspecialLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empresaespecialDataAccess = new EmpresaEspecialDataAccess();
			
			this.empresaespecials= new ArrayList<EmpresaEspecial>();
			this.empresaespecial= new EmpresaEspecial();
			
			this.empresaespecialObject=new Object();
			this.empresaespecialsObject=new ArrayList<Object>();
				
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
			
			this.empresaespecialDataAccess.setConnexionType(this.connexionType);
			this.empresaespecialDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpresaEspecialLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empresaespecialDataAccess = new EmpresaEspecialDataAccess();
			this.empresaespecials= new ArrayList<EmpresaEspecial>();
			this.empresaespecial= new EmpresaEspecial();
			this.empresaespecialObject=new Object();
			this.empresaespecialsObject=new ArrayList<Object>();
			
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
			
			this.empresaespecialDataAccess.setConnexionType(this.connexionType);
			this.empresaespecialDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpresaEspecial getEmpresaEspecial() throws Exception {	
		EmpresaEspecialLogicAdditional.checkEmpresaEspecialToGet(empresaespecial,this.datosCliente,this.arrDatoGeneral);
		EmpresaEspecialLogicAdditional.updateEmpresaEspecialToGet(empresaespecial,this.arrDatoGeneral);
		
		return empresaespecial;
	}
		
	public void setEmpresaEspecial(EmpresaEspecial newEmpresaEspecial) {
		this.empresaespecial = newEmpresaEspecial;
	}
	
	public EmpresaEspecialDataAccess getEmpresaEspecialDataAccess() {
		return empresaespecialDataAccess;
	}
	
	public void setEmpresaEspecialDataAccess(EmpresaEspecialDataAccess newempresaespecialDataAccess) {
		this.empresaespecialDataAccess = newempresaespecialDataAccess;
	}
	
	public List<EmpresaEspecial> getEmpresaEspecials() throws Exception {		
		this.quitarEmpresaEspecialsNulos();
		
		EmpresaEspecialLogicAdditional.checkEmpresaEspecialToGets(empresaespecials,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpresaEspecial empresaespecialLocal: empresaespecials ) {
			EmpresaEspecialLogicAdditional.updateEmpresaEspecialToGet(empresaespecialLocal,this.arrDatoGeneral);
		}
		
		return empresaespecials;
	}
	
	public void setEmpresaEspecials(List<EmpresaEspecial> newEmpresaEspecials) {
		this.empresaespecials = newEmpresaEspecials;
	}
	
	public Object getEmpresaEspecialObject() {	
		this.empresaespecialObject=this.empresaespecialDataAccess.getEntityObject();
		return this.empresaespecialObject;
	}
		
	public void setEmpresaEspecialObject(Object newEmpresaEspecialObject) {
		this.empresaespecialObject = newEmpresaEspecialObject;
	}
	
	public List<Object> getEmpresaEspecialsObject() {		
		this.empresaespecialsObject=this.empresaespecialDataAccess.getEntitiesObject();
		return this.empresaespecialsObject;
	}
		
	public void setEmpresaEspecialsObject(List<Object> newEmpresaEspecialsObject) {
		this.empresaespecialsObject = newEmpresaEspecialsObject;
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
		
		if(this.empresaespecialDataAccess!=null) {
			this.empresaespecialDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empresaespecialDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empresaespecialDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empresaespecial = new  EmpresaEspecial();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empresaespecial=empresaespecialDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empresaespecial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecial);
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
		empresaespecial = new  EmpresaEspecial();
		  		  
        try {
			
			empresaespecial=empresaespecialDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empresaespecial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empresaespecial = new  EmpresaEspecial();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empresaespecial=empresaespecialDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empresaespecial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecial);
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
		empresaespecial = new  EmpresaEspecial();
		  		  
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
		empresaespecial = new  EmpresaEspecial();
		  		  
        try {
			
			empresaespecial=empresaespecialDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empresaespecial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empresaespecial = new  EmpresaEspecial();
		  		  
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
		empresaespecial = new  EmpresaEspecial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empresaespecialDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empresaespecial = new  EmpresaEspecial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empresaespecialDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empresaespecial = new  EmpresaEspecial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empresaespecialDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empresaespecial = new  EmpresaEspecial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empresaespecialDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empresaespecial = new  EmpresaEspecial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empresaespecialDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empresaespecial = new  EmpresaEspecial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empresaespecialDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecials=empresaespecialDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecials);
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
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		  		  
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
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		  		  
        try {			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecials=empresaespecialDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpresaEspecial(empresaespecials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecials);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		  		  
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
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecials=empresaespecialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecials);
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
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		  		  
        try {
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecials=empresaespecialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecials);
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
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecials=empresaespecialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecials);
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
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecials=empresaespecialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecials);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empresaespecial = new  EmpresaEspecial();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecial=empresaespecialDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecial);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecial);
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
		empresaespecial = new  EmpresaEspecial();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecial=empresaespecialDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecial);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecials=empresaespecialDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecials);
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
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		  		  
        try {
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecials=empresaespecialDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecials);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpresaEspecialsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-getTodosEmpresaEspecialsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecials=empresaespecialDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecials);
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
	
	public  void  getTodosEmpresaEspecials(String sFinalQuery,Pagination pagination)throws Exception {
		empresaespecials = new  ArrayList<EmpresaEspecial>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empresaespecials=empresaespecialDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpresaEspecial(empresaespecials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecials);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpresaEspecial(EmpresaEspecial empresaespecial) throws Exception {
		Boolean estaValidado=false;
		
		if(empresaespecial.getIsNew() || empresaespecial.getIsChanged()) { 
			this.invalidValues = empresaespecialValidator.getInvalidValues(empresaespecial);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empresaespecial);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpresaEspecial(List<EmpresaEspecial> EmpresaEspecials) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpresaEspecial empresaespecialLocal:empresaespecials) {				
			estaValidadoObjeto=this.validarGuardarEmpresaEspecial(empresaespecialLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpresaEspecial(List<EmpresaEspecial> EmpresaEspecials) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpresaEspecial(empresaespecials)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpresaEspecial(EmpresaEspecial EmpresaEspecial) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpresaEspecial(empresaespecial)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpresaEspecial empresaespecial) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empresaespecial.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpresaEspecialConstantesFunciones.getEmpresaEspecialLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empresaespecial","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpresaEspecialConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpresaEspecialConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpresaEspecialWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-saveEmpresaEspecialWithConnection");connexion.begin();			
			
			EmpresaEspecialLogicAdditional.checkEmpresaEspecialToSave(this.empresaespecial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpresaEspecialLogicAdditional.updateEmpresaEspecialToSave(this.empresaespecial,this.arrDatoGeneral);
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empresaespecial,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpresaEspecial();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpresaEspecial(this.empresaespecial)) {
				EmpresaEspecialDataAccess.save(this.empresaespecial, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empresaespecial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpresaEspecialLogicAdditional.checkEmpresaEspecialToSaveAfter(this.empresaespecial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpresaEspecial();
			
			connexion.commit();			
			
			if(this.empresaespecial.getIsDeleted()) {
				this.empresaespecial=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpresaEspecial()throws Exception {	
		try {	
			
			EmpresaEspecialLogicAdditional.checkEmpresaEspecialToSave(this.empresaespecial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpresaEspecialLogicAdditional.updateEmpresaEspecialToSave(this.empresaespecial,this.arrDatoGeneral);
			
			EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empresaespecial,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpresaEspecial(this.empresaespecial)) {			
				EmpresaEspecialDataAccess.save(this.empresaespecial, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empresaespecial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpresaEspecialLogicAdditional.checkEmpresaEspecialToSaveAfter(this.empresaespecial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empresaespecial.getIsDeleted()) {
				this.empresaespecial=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpresaEspecialsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-saveEmpresaEspecialsWithConnection");connexion.begin();			
			
			EmpresaEspecialLogicAdditional.checkEmpresaEspecialToSaves(empresaespecials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpresaEspecials();
			
			Boolean validadoTodosEmpresaEspecial=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpresaEspecial empresaespecialLocal:empresaespecials) {		
				if(empresaespecialLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpresaEspecialLogicAdditional.updateEmpresaEspecialToSave(empresaespecialLocal,this.arrDatoGeneral);
	        	
				EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empresaespecialLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpresaEspecial(empresaespecialLocal)) {
					EmpresaEspecialDataAccess.save(empresaespecialLocal, connexion);				
				} else {
					validadoTodosEmpresaEspecial=false;
				}
			}
			
			if(!validadoTodosEmpresaEspecial) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpresaEspecialLogicAdditional.checkEmpresaEspecialToSavesAfter(empresaespecials,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpresaEspecials();
			
			connexion.commit();		
			
			this.quitarEmpresaEspecialsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpresaEspecials()throws Exception {				
		 try {	
			EmpresaEspecialLogicAdditional.checkEmpresaEspecialToSaves(empresaespecials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpresaEspecial=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpresaEspecial empresaespecialLocal:empresaespecials) {				
				if(empresaespecialLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpresaEspecialLogicAdditional.updateEmpresaEspecialToSave(empresaespecialLocal,this.arrDatoGeneral);
	        	
				EmpresaEspecialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empresaespecialLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpresaEspecial(empresaespecialLocal)) {				
					EmpresaEspecialDataAccess.save(empresaespecialLocal, connexion);				
				} else {
					validadoTodosEmpresaEspecial=false;
				}
			}
			
			if(!validadoTodosEmpresaEspecial) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpresaEspecialLogicAdditional.checkEmpresaEspecialToSavesAfter(empresaespecials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpresaEspecialsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpresaEspecialParameterReturnGeneral procesarAccionEmpresaEspecials(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpresaEspecial> empresaespecials,EmpresaEspecialParameterReturnGeneral empresaespecialParameterGeneral)throws Exception {
		 try {	
			EmpresaEspecialParameterReturnGeneral empresaespecialReturnGeneral=new EmpresaEspecialParameterReturnGeneral();
	
			EmpresaEspecialLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empresaespecials,empresaespecialParameterGeneral,empresaespecialReturnGeneral);
			
			return empresaespecialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpresaEspecialParameterReturnGeneral procesarAccionEmpresaEspecialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpresaEspecial> empresaespecials,EmpresaEspecialParameterReturnGeneral empresaespecialParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-procesarAccionEmpresaEspecialsWithConnection");connexion.begin();			
			
			EmpresaEspecialParameterReturnGeneral empresaespecialReturnGeneral=new EmpresaEspecialParameterReturnGeneral();
	
			EmpresaEspecialLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empresaespecials,empresaespecialParameterGeneral,empresaespecialReturnGeneral);
			
			this.connexion.commit();
			
			return empresaespecialReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpresaEspecialParameterReturnGeneral procesarEventosEmpresaEspecials(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpresaEspecial> empresaespecials,EmpresaEspecial empresaespecial,EmpresaEspecialParameterReturnGeneral empresaespecialParameterGeneral,Boolean isEsNuevoEmpresaEspecial,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpresaEspecialParameterReturnGeneral empresaespecialReturnGeneral=new EmpresaEspecialParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empresaespecialReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpresaEspecialLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empresaespecials,empresaespecial,empresaespecialParameterGeneral,empresaespecialReturnGeneral,isEsNuevoEmpresaEspecial,clases);
			
			return empresaespecialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpresaEspecialParameterReturnGeneral procesarEventosEmpresaEspecialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpresaEspecial> empresaespecials,EmpresaEspecial empresaespecial,EmpresaEspecialParameterReturnGeneral empresaespecialParameterGeneral,Boolean isEsNuevoEmpresaEspecial,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-procesarEventosEmpresaEspecialsWithConnection");connexion.begin();			
			
			EmpresaEspecialParameterReturnGeneral empresaespecialReturnGeneral=new EmpresaEspecialParameterReturnGeneral();
	
			empresaespecialReturnGeneral.setEmpresaEspecial(empresaespecial);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empresaespecialReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpresaEspecialLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empresaespecials,empresaespecial,empresaespecialParameterGeneral,empresaespecialReturnGeneral,isEsNuevoEmpresaEspecial,clases);
			
			this.connexion.commit();
			
			return empresaespecialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpresaEspecialParameterReturnGeneral procesarImportacionEmpresaEspecialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpresaEspecialParameterReturnGeneral empresaespecialParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpresaEspecial.class.getSimpleName()+"-procesarImportacionEmpresaEspecialsWithConnection");connexion.begin();			
			
			EmpresaEspecialParameterReturnGeneral empresaespecialReturnGeneral=new EmpresaEspecialParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empresaespecials=new ArrayList<EmpresaEspecial>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empresaespecial=new EmpresaEspecial();
				
				
				if(conColumnasBase) {this.empresaespecial.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empresaespecial.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empresaespecial.setnumero_resolucion(arrColumnas[iColumn++]);
				this.empresaespecial.setfecha_resolucion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.empresaespecials.add(this.empresaespecial);
			}
			
			this.saveEmpresaEspecials();
			
			this.connexion.commit();
			
			empresaespecialReturnGeneral.setConRetornoEstaProcesado(true);
			empresaespecialReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empresaespecialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpresaEspecialsEliminados() throws Exception {				
		
		List<EmpresaEspecial> empresaespecialsAux= new ArrayList<EmpresaEspecial>();
		
		for(EmpresaEspecial empresaespecial:empresaespecials) {
			if(!empresaespecial.getIsDeleted()) {
				empresaespecialsAux.add(empresaespecial);
			}
		}
		
		empresaespecials=empresaespecialsAux;
	}
	
	public void quitarEmpresaEspecialsNulos() throws Exception {				
		
		List<EmpresaEspecial> empresaespecialsAux= new ArrayList<EmpresaEspecial>();
		
		for(EmpresaEspecial empresaespecial : this.empresaespecials) {
			if(empresaespecial==null) {
				empresaespecialsAux.add(empresaespecial);
			}
		}
		
		//this.empresaespecials=empresaespecialsAux;
		
		this.empresaespecials.removeAll(empresaespecialsAux);
	}
	
	public void getSetVersionRowEmpresaEspecialWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empresaespecial.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empresaespecial.getIsDeleted() || (empresaespecial.getIsChanged()&&!empresaespecial.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empresaespecialDataAccess.getSetVersionRowEmpresaEspecial(connexion,empresaespecial.getId());
				
				if(!empresaespecial.getVersionRow().equals(timestamp)) {	
					empresaespecial.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empresaespecial.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpresaEspecial()throws Exception {	
		
		if(empresaespecial.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empresaespecial.getIsDeleted() || (empresaespecial.getIsChanged()&&!empresaespecial.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empresaespecialDataAccess.getSetVersionRowEmpresaEspecial(connexion,empresaespecial.getId());
			
			try {							
				if(!empresaespecial.getVersionRow().equals(timestamp)) {	
					empresaespecial.setVersionRow(timestamp);
				}
				
				empresaespecial.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpresaEspecialsWithConnection()throws Exception {	
		if(empresaespecials!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpresaEspecial empresaespecialAux:empresaespecials) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empresaespecialAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empresaespecialAux.getIsDeleted() || (empresaespecialAux.getIsChanged()&&!empresaespecialAux.getIsNew())) {
						
						timestamp=empresaespecialDataAccess.getSetVersionRowEmpresaEspecial(connexion,empresaespecialAux.getId());
						
						if(!empresaespecial.getVersionRow().equals(timestamp)) {	
							empresaespecialAux.setVersionRow(timestamp);
						}
								
						empresaespecialAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpresaEspecials()throws Exception {	
		if(empresaespecials!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpresaEspecial empresaespecialAux:empresaespecials) {
					if(empresaespecialAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empresaespecialAux.getIsDeleted() || (empresaespecialAux.getIsChanged()&&!empresaespecialAux.getIsNew())) {
						
						timestamp=empresaespecialDataAccess.getSetVersionRowEmpresaEspecial(connexion,empresaespecialAux.getId());
						
						if(!empresaespecialAux.getVersionRow().equals(timestamp)) {	
							empresaespecialAux.setVersionRow(timestamp);
						}
						
													
						empresaespecialAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(EmpresaEspecial empresaespecial,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			EmpresaEspecialLogicAdditional.updateEmpresaEspecialToGet(empresaespecial,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpresaEspecial empresaespecial,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
				
		try {
			EmpresaEspecialLogicAdditional.updateEmpresaEspecialToSave(empresaespecial,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpresaEspecial.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empresaespecial,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(empresaespecial);
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
			this.deepLoad(this.empresaespecial,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(this.empresaespecial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpresaEspecial.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empresaespecials!=null) {
				for(EmpresaEspecial empresaespecial:empresaespecials) {
					this.deepLoad(empresaespecial,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(empresaespecials);
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
			if(empresaespecials!=null) {
				for(EmpresaEspecial empresaespecial:empresaespecials) {
					this.deepLoad(empresaespecial,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpresaEspecialConstantesFunciones.refrescarForeignKeysDescripcionesEmpresaEspecial(empresaespecials);
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
			this.getNewConnexionToDeep(EmpresaEspecial.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empresaespecial,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpresaEspecial.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empresaespecials!=null) {
				for(EmpresaEspecial empresaespecial:empresaespecials) {
					this.deepSave(empresaespecial,isDeep,deepLoadType,clases);
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
			if(empresaespecials!=null) {
				for(EmpresaEspecial empresaespecial:empresaespecials) {
					this.deepSave(empresaespecial,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpresaEspecialConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpresaEspecialDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpresaEspecial empresaespecial,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpresaEspecialConstantesFunciones.ISCONAUDITORIA) {
				if(empresaespecial.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpresaEspecialDataAccess.TABLENAME, empresaespecial.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpresaEspecialConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpresaEspecialLogic.registrarAuditoriaDetallesEmpresaEspecial(connexion,empresaespecial,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empresaespecial.getIsDeleted()) {
					/*if(!empresaespecial.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpresaEspecialDataAccess.TABLENAME, empresaespecial.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpresaEspecialLogic.registrarAuditoriaDetallesEmpresaEspecial(connexion,empresaespecial,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpresaEspecialDataAccess.TABLENAME, empresaespecial.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empresaespecial.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpresaEspecialDataAccess.TABLENAME, empresaespecial.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpresaEspecialConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpresaEspecialLogic.registrarAuditoriaDetallesEmpresaEspecial(connexion,empresaespecial,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpresaEspecial(Connexion connexion,EmpresaEspecial empresaespecial)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empresaespecial.getIsNew()||!empresaespecial.getnumero_resolucion().equals(empresaespecial.getEmpresaEspecialOriginal().getnumero_resolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresaespecial.getEmpresaEspecialOriginal().getnumero_resolucion()!=null)
				{
					strValorActual=empresaespecial.getEmpresaEspecialOriginal().getnumero_resolucion();
				}
				if(empresaespecial.getnumero_resolucion()!=null)
				{
					strValorNuevo=empresaespecial.getnumero_resolucion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaEspecialConstantesFunciones.NUMERORESOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(empresaespecial.getIsNew()||!empresaespecial.getfecha_resolucion().equals(empresaespecial.getEmpresaEspecialOriginal().getfecha_resolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empresaespecial.getEmpresaEspecialOriginal().getfecha_resolucion()!=null)
				{
					strValorActual=empresaespecial.getEmpresaEspecialOriginal().getfecha_resolucion().toString();
				}
				if(empresaespecial.getfecha_resolucion()!=null)
				{
					strValorNuevo=empresaespecial.getfecha_resolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpresaEspecialConstantesFunciones.FECHARESOLUCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpresaEspecialRelacionesWithConnection(EmpresaEspecial empresaespecial) throws Exception {

		if(!empresaespecial.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpresaEspecialRelacionesBase(empresaespecial,true);
		}
	}

	public void saveEmpresaEspecialRelaciones(EmpresaEspecial empresaespecial)throws Exception {

		if(!empresaespecial.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpresaEspecialRelacionesBase(empresaespecial,false);
		}
	}

	public void saveEmpresaEspecialRelacionesBase(EmpresaEspecial empresaespecial,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpresaEspecial-saveRelacionesWithConnection");}
	

			this.setEmpresaEspecial(empresaespecial);

			if(EmpresaEspecialLogicAdditional.validarSaveRelaciones(empresaespecial,this)) {

				EmpresaEspecialLogicAdditional.updateRelacionesToSave(empresaespecial,this);

				if((empresaespecial.getIsNew()||empresaespecial.getIsChanged())&&!empresaespecial.getIsDeleted()) {
					this.saveEmpresaEspecial();
					this.saveEmpresaEspecialRelacionesDetalles();

				} else if(empresaespecial.getIsDeleted()) {
					this.saveEmpresaEspecialRelacionesDetalles();
					this.saveEmpresaEspecial();
				}

				EmpresaEspecialLogicAdditional.updateRelacionesToSaveAfter(empresaespecial,this);

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
	
	
	private void saveEmpresaEspecialRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpresaEspecial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpresaEspecialConstantesFunciones.getClassesForeignKeysOfEmpresaEspecial(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpresaEspecial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpresaEspecialConstantesFunciones.getClassesRelationshipsOfEmpresaEspecial(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

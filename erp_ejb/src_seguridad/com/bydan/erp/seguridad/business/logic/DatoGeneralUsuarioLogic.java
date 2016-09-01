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
import com.bydan.erp.seguridad.util.DatoGeneralUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.DatoGeneralUsuarioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.DatoGeneralUsuarioParameterGeneral;
import com.bydan.erp.seguridad.business.entity.DatoGeneralUsuario;
import com.bydan.erp.seguridad.business.logic.DatoGeneralUsuarioLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class DatoGeneralUsuarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DatoGeneralUsuarioLogic.class);
	
	protected DatoGeneralUsuarioDataAccess datogeneralusuarioDataAccess; 	
	protected DatoGeneralUsuario datogeneralusuario;
	protected List<DatoGeneralUsuario> datogeneralusuarios;
	protected Object datogeneralusuarioObject;	
	protected List<Object> datogeneralusuariosObject;
	
	public static ClassValidator<DatoGeneralUsuario> datogeneralusuarioValidator = new ClassValidator<DatoGeneralUsuario>(DatoGeneralUsuario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DatoGeneralUsuarioLogicAdditional datogeneralusuarioLogicAdditional=null;
	
	public DatoGeneralUsuarioLogicAdditional getDatoGeneralUsuarioLogicAdditional() {
		return this.datogeneralusuarioLogicAdditional;
	}
	
	public void setDatoGeneralUsuarioLogicAdditional(DatoGeneralUsuarioLogicAdditional datogeneralusuarioLogicAdditional) {
		try {
			this.datogeneralusuarioLogicAdditional=datogeneralusuarioLogicAdditional;
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
	
	
	
	
	public  DatoGeneralUsuarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.datogeneralusuarioDataAccess = new DatoGeneralUsuarioDataAccess();
			
			this.datogeneralusuarios= new ArrayList<DatoGeneralUsuario>();
			this.datogeneralusuario= new DatoGeneralUsuario();
			
			this.datogeneralusuarioObject=new Object();
			this.datogeneralusuariosObject=new ArrayList<Object>();
				
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
			
			this.datogeneralusuarioDataAccess.setConnexionType(this.connexionType);
			this.datogeneralusuarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DatoGeneralUsuarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.datogeneralusuarioDataAccess = new DatoGeneralUsuarioDataAccess();
			this.datogeneralusuarios= new ArrayList<DatoGeneralUsuario>();
			this.datogeneralusuario= new DatoGeneralUsuario();
			this.datogeneralusuarioObject=new Object();
			this.datogeneralusuariosObject=new ArrayList<Object>();
			
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
			
			this.datogeneralusuarioDataAccess.setConnexionType(this.connexionType);
			this.datogeneralusuarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DatoGeneralUsuario getDatoGeneralUsuario() throws Exception {	
		DatoGeneralUsuarioLogicAdditional.checkDatoGeneralUsuarioToGet(datogeneralusuario,this.datosCliente,this.arrDatoGeneral);
		DatoGeneralUsuarioLogicAdditional.updateDatoGeneralUsuarioToGet(datogeneralusuario,this.arrDatoGeneral);
		
		return datogeneralusuario;
	}
		
	public void setDatoGeneralUsuario(DatoGeneralUsuario newDatoGeneralUsuario) {
		this.datogeneralusuario = newDatoGeneralUsuario;
	}
	
	public DatoGeneralUsuarioDataAccess getDatoGeneralUsuarioDataAccess() {
		return datogeneralusuarioDataAccess;
	}
	
	public void setDatoGeneralUsuarioDataAccess(DatoGeneralUsuarioDataAccess newdatogeneralusuarioDataAccess) {
		this.datogeneralusuarioDataAccess = newdatogeneralusuarioDataAccess;
	}
	
	public List<DatoGeneralUsuario> getDatoGeneralUsuarios() throws Exception {		
		this.quitarDatoGeneralUsuariosNulos();
		
		DatoGeneralUsuarioLogicAdditional.checkDatoGeneralUsuarioToGets(datogeneralusuarios,this.datosCliente,this.arrDatoGeneral);
		
		for (DatoGeneralUsuario datogeneralusuarioLocal: datogeneralusuarios ) {
			DatoGeneralUsuarioLogicAdditional.updateDatoGeneralUsuarioToGet(datogeneralusuarioLocal,this.arrDatoGeneral);
		}
		
		return datogeneralusuarios;
	}
	
	public void setDatoGeneralUsuarios(List<DatoGeneralUsuario> newDatoGeneralUsuarios) {
		this.datogeneralusuarios = newDatoGeneralUsuarios;
	}
	
	public Object getDatoGeneralUsuarioObject() {	
		this.datogeneralusuarioObject=this.datogeneralusuarioDataAccess.getEntityObject();
		return this.datogeneralusuarioObject;
	}
		
	public void setDatoGeneralUsuarioObject(Object newDatoGeneralUsuarioObject) {
		this.datogeneralusuarioObject = newDatoGeneralUsuarioObject;
	}
	
	public List<Object> getDatoGeneralUsuariosObject() {		
		this.datogeneralusuariosObject=this.datogeneralusuarioDataAccess.getEntitiesObject();
		return this.datogeneralusuariosObject;
	}
		
	public void setDatoGeneralUsuariosObject(List<Object> newDatoGeneralUsuariosObject) {
		this.datogeneralusuariosObject = newDatoGeneralUsuariosObject;
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
		
		if(this.datogeneralusuarioDataAccess!=null) {
			this.datogeneralusuarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			datogeneralusuarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			datogeneralusuarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		datogeneralusuario = new  DatoGeneralUsuario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			datogeneralusuario=datogeneralusuarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuario);
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
		datogeneralusuario = new  DatoGeneralUsuario();
		  		  
        try {
			
			datogeneralusuario=datogeneralusuarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		datogeneralusuario = new  DatoGeneralUsuario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			datogeneralusuario=datogeneralusuarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuario);
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
		datogeneralusuario = new  DatoGeneralUsuario();
		  		  
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
		datogeneralusuario = new  DatoGeneralUsuario();
		  		  
        try {
			
			datogeneralusuario=datogeneralusuarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		datogeneralusuario = new  DatoGeneralUsuario();
		  		  
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
		datogeneralusuario = new  DatoGeneralUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =datogeneralusuarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datogeneralusuario = new  DatoGeneralUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=datogeneralusuarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		datogeneralusuario = new  DatoGeneralUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =datogeneralusuarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datogeneralusuario = new  DatoGeneralUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=datogeneralusuarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		datogeneralusuario = new  DatoGeneralUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =datogeneralusuarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datogeneralusuario = new  DatoGeneralUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=datogeneralusuarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
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
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		  		  
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
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		  		  
        try {			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		  		  
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
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
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
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		  		  
        try {
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
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
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
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
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		datogeneralusuario = new  DatoGeneralUsuario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuario=datogeneralusuarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuario);
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
		datogeneralusuario = new  DatoGeneralUsuario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuario=datogeneralusuarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
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
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		  		  
        try {
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDatoGeneralUsuariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getTodosDatoGeneralUsuariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
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
	
	public  void  getTodosDatoGeneralUsuarios(String sFinalQuery,Pagination pagination)throws Exception {
		datogeneralusuarios = new  ArrayList<DatoGeneralUsuario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDatoGeneralUsuario(datogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDatoGeneralUsuario(DatoGeneralUsuario datogeneralusuario) throws Exception {
		Boolean estaValidado=false;
		
		if(datogeneralusuario.getIsNew() || datogeneralusuario.getIsChanged()) { 
			this.invalidValues = datogeneralusuarioValidator.getInvalidValues(datogeneralusuario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(datogeneralusuario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDatoGeneralUsuario(List<DatoGeneralUsuario> DatoGeneralUsuarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DatoGeneralUsuario datogeneralusuarioLocal:datogeneralusuarios) {				
			estaValidadoObjeto=this.validarGuardarDatoGeneralUsuario(datogeneralusuarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDatoGeneralUsuario(List<DatoGeneralUsuario> DatoGeneralUsuarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDatoGeneralUsuario(datogeneralusuarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDatoGeneralUsuario(DatoGeneralUsuario DatoGeneralUsuario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDatoGeneralUsuario(datogeneralusuario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DatoGeneralUsuario datogeneralusuario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+datogeneralusuario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DatoGeneralUsuarioConstantesFunciones.getDatoGeneralUsuarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"datogeneralusuario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DatoGeneralUsuarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DatoGeneralUsuarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDatoGeneralUsuarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-saveDatoGeneralUsuarioWithConnection");connexion.begin();			
			
			DatoGeneralUsuarioLogicAdditional.checkDatoGeneralUsuarioToSave(this.datogeneralusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DatoGeneralUsuarioLogicAdditional.updateDatoGeneralUsuarioToSave(this.datogeneralusuario,this.arrDatoGeneral);
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.datogeneralusuario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDatoGeneralUsuario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDatoGeneralUsuario(this.datogeneralusuario)) {
				DatoGeneralUsuarioDataAccess.save(this.datogeneralusuario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.datogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DatoGeneralUsuarioLogicAdditional.checkDatoGeneralUsuarioToSaveAfter(this.datogeneralusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDatoGeneralUsuario();
			
			connexion.commit();			
			
			if(this.datogeneralusuario.getIsDeleted()) {
				this.datogeneralusuario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDatoGeneralUsuario()throws Exception {	
		try {	
			
			DatoGeneralUsuarioLogicAdditional.checkDatoGeneralUsuarioToSave(this.datogeneralusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DatoGeneralUsuarioLogicAdditional.updateDatoGeneralUsuarioToSave(this.datogeneralusuario,this.arrDatoGeneral);
			
			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.datogeneralusuario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDatoGeneralUsuario(this.datogeneralusuario)) {			
				DatoGeneralUsuarioDataAccess.save(this.datogeneralusuario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.datogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DatoGeneralUsuarioLogicAdditional.checkDatoGeneralUsuarioToSaveAfter(this.datogeneralusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.datogeneralusuario.getIsDeleted()) {
				this.datogeneralusuario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDatoGeneralUsuariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-saveDatoGeneralUsuariosWithConnection");connexion.begin();			
			
			DatoGeneralUsuarioLogicAdditional.checkDatoGeneralUsuarioToSaves(datogeneralusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDatoGeneralUsuarios();
			
			Boolean validadoTodosDatoGeneralUsuario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DatoGeneralUsuario datogeneralusuarioLocal:datogeneralusuarios) {		
				if(datogeneralusuarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DatoGeneralUsuarioLogicAdditional.updateDatoGeneralUsuarioToSave(datogeneralusuarioLocal,this.arrDatoGeneral);
	        	
				DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),datogeneralusuarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDatoGeneralUsuario(datogeneralusuarioLocal)) {
					DatoGeneralUsuarioDataAccess.save(datogeneralusuarioLocal, connexion);				
				} else {
					validadoTodosDatoGeneralUsuario=false;
				}
			}
			
			if(!validadoTodosDatoGeneralUsuario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DatoGeneralUsuarioLogicAdditional.checkDatoGeneralUsuarioToSavesAfter(datogeneralusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDatoGeneralUsuarios();
			
			connexion.commit();		
			
			this.quitarDatoGeneralUsuariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDatoGeneralUsuarios()throws Exception {				
		 try {	
			DatoGeneralUsuarioLogicAdditional.checkDatoGeneralUsuarioToSaves(datogeneralusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDatoGeneralUsuario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DatoGeneralUsuario datogeneralusuarioLocal:datogeneralusuarios) {				
				if(datogeneralusuarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DatoGeneralUsuarioLogicAdditional.updateDatoGeneralUsuarioToSave(datogeneralusuarioLocal,this.arrDatoGeneral);
	        	
				DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),datogeneralusuarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDatoGeneralUsuario(datogeneralusuarioLocal)) {				
					DatoGeneralUsuarioDataAccess.save(datogeneralusuarioLocal, connexion);				
				} else {
					validadoTodosDatoGeneralUsuario=false;
				}
			}
			
			if(!validadoTodosDatoGeneralUsuario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DatoGeneralUsuarioLogicAdditional.checkDatoGeneralUsuarioToSavesAfter(datogeneralusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDatoGeneralUsuariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DatoGeneralUsuarioParameterReturnGeneral procesarAccionDatoGeneralUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DatoGeneralUsuario> datogeneralusuarios,DatoGeneralUsuarioParameterReturnGeneral datogeneralusuarioParameterGeneral)throws Exception {
		 try {	
			DatoGeneralUsuarioParameterReturnGeneral datogeneralusuarioReturnGeneral=new DatoGeneralUsuarioParameterReturnGeneral();
	
			DatoGeneralUsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,datogeneralusuarios,datogeneralusuarioParameterGeneral,datogeneralusuarioReturnGeneral);
			
			return datogeneralusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DatoGeneralUsuarioParameterReturnGeneral procesarAccionDatoGeneralUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DatoGeneralUsuario> datogeneralusuarios,DatoGeneralUsuarioParameterReturnGeneral datogeneralusuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-procesarAccionDatoGeneralUsuariosWithConnection");connexion.begin();			
			
			DatoGeneralUsuarioParameterReturnGeneral datogeneralusuarioReturnGeneral=new DatoGeneralUsuarioParameterReturnGeneral();
	
			DatoGeneralUsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,datogeneralusuarios,datogeneralusuarioParameterGeneral,datogeneralusuarioReturnGeneral);
			
			this.connexion.commit();
			
			return datogeneralusuarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DatoGeneralUsuarioParameterReturnGeneral procesarEventosDatoGeneralUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DatoGeneralUsuario> datogeneralusuarios,DatoGeneralUsuario datogeneralusuario,DatoGeneralUsuarioParameterReturnGeneral datogeneralusuarioParameterGeneral,Boolean isEsNuevoDatoGeneralUsuario,ArrayList<Classe> clases)throws Exception {
		 try {	
			DatoGeneralUsuarioParameterReturnGeneral datogeneralusuarioReturnGeneral=new DatoGeneralUsuarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				datogeneralusuarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DatoGeneralUsuarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,datogeneralusuarios,datogeneralusuario,datogeneralusuarioParameterGeneral,datogeneralusuarioReturnGeneral,isEsNuevoDatoGeneralUsuario,clases);
			
			return datogeneralusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DatoGeneralUsuarioParameterReturnGeneral procesarEventosDatoGeneralUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DatoGeneralUsuario> datogeneralusuarios,DatoGeneralUsuario datogeneralusuario,DatoGeneralUsuarioParameterReturnGeneral datogeneralusuarioParameterGeneral,Boolean isEsNuevoDatoGeneralUsuario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-procesarEventosDatoGeneralUsuariosWithConnection");connexion.begin();			
			
			DatoGeneralUsuarioParameterReturnGeneral datogeneralusuarioReturnGeneral=new DatoGeneralUsuarioParameterReturnGeneral();
	
			datogeneralusuarioReturnGeneral.setDatoGeneralUsuario(datogeneralusuario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				datogeneralusuarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DatoGeneralUsuarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,datogeneralusuarios,datogeneralusuario,datogeneralusuarioParameterGeneral,datogeneralusuarioReturnGeneral,isEsNuevoDatoGeneralUsuario,clases);
			
			this.connexion.commit();
			
			return datogeneralusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DatoGeneralUsuarioParameterReturnGeneral procesarImportacionDatoGeneralUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DatoGeneralUsuarioParameterReturnGeneral datogeneralusuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-procesarImportacionDatoGeneralUsuariosWithConnection");connexion.begin();			
			
			DatoGeneralUsuarioParameterReturnGeneral datogeneralusuarioReturnGeneral=new DatoGeneralUsuarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.datogeneralusuarios=new ArrayList<DatoGeneralUsuario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.datogeneralusuario=new DatoGeneralUsuario();
				
				
				if(conColumnasBase) {this.datogeneralusuario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.datogeneralusuario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.datogeneralusuario.setcedula(arrColumnas[iColumn++]);
			this.datogeneralusuario.setapellidos(arrColumnas[iColumn++]);
			this.datogeneralusuario.setnombres(arrColumnas[iColumn++]);
			this.datogeneralusuario.settelefono(arrColumnas[iColumn++]);
			this.datogeneralusuario.settelefono_movil(arrColumnas[iColumn++]);
			this.datogeneralusuario.sete_mail(arrColumnas[iColumn++]);
			this.datogeneralusuario.seturl(arrColumnas[iColumn++]);
				this.datogeneralusuario.setfecha_nacimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.datogeneralusuario.setdireccion(arrColumnas[iColumn++]);
				
				this.datogeneralusuarios.add(this.datogeneralusuario);
			}
			
			this.saveDatoGeneralUsuarios();
			
			this.connexion.commit();
			
			datogeneralusuarioReturnGeneral.setConRetornoEstaProcesado(true);
			datogeneralusuarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return datogeneralusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDatoGeneralUsuariosEliminados() throws Exception {				
		
		List<DatoGeneralUsuario> datogeneralusuariosAux= new ArrayList<DatoGeneralUsuario>();
		
		for(DatoGeneralUsuario datogeneralusuario:datogeneralusuarios) {
			if(!datogeneralusuario.getIsDeleted()) {
				datogeneralusuariosAux.add(datogeneralusuario);
			}
		}
		
		datogeneralusuarios=datogeneralusuariosAux;
	}
	
	public void quitarDatoGeneralUsuariosNulos() throws Exception {				
		
		List<DatoGeneralUsuario> datogeneralusuariosAux= new ArrayList<DatoGeneralUsuario>();
		
		for(DatoGeneralUsuario datogeneralusuario : this.datogeneralusuarios) {
			if(datogeneralusuario==null) {
				datogeneralusuariosAux.add(datogeneralusuario);
			}
		}
		
		//this.datogeneralusuarios=datogeneralusuariosAux;
		
		this.datogeneralusuarios.removeAll(datogeneralusuariosAux);
	}
	
	public void getSetVersionRowDatoGeneralUsuarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(datogeneralusuario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((datogeneralusuario.getIsDeleted() || (datogeneralusuario.getIsChanged()&&!datogeneralusuario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=datogeneralusuarioDataAccess.getSetVersionRowDatoGeneralUsuario(connexion,datogeneralusuario.getId());
				
				if(!datogeneralusuario.getVersionRow().equals(timestamp)) {	
					datogeneralusuario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				datogeneralusuario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDatoGeneralUsuario()throws Exception {	
		
		if(datogeneralusuario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((datogeneralusuario.getIsDeleted() || (datogeneralusuario.getIsChanged()&&!datogeneralusuario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=datogeneralusuarioDataAccess.getSetVersionRowDatoGeneralUsuario(connexion,datogeneralusuario.getId());
			
			try {							
				if(!datogeneralusuario.getVersionRow().equals(timestamp)) {	
					datogeneralusuario.setVersionRow(timestamp);
				}
				
				datogeneralusuario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDatoGeneralUsuariosWithConnection()throws Exception {	
		if(datogeneralusuarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DatoGeneralUsuario datogeneralusuarioAux:datogeneralusuarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(datogeneralusuarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(datogeneralusuarioAux.getIsDeleted() || (datogeneralusuarioAux.getIsChanged()&&!datogeneralusuarioAux.getIsNew())) {
						
						timestamp=datogeneralusuarioDataAccess.getSetVersionRowDatoGeneralUsuario(connexion,datogeneralusuarioAux.getId());
						
						if(!datogeneralusuario.getVersionRow().equals(timestamp)) {	
							datogeneralusuarioAux.setVersionRow(timestamp);
						}
								
						datogeneralusuarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDatoGeneralUsuarios()throws Exception {	
		if(datogeneralusuarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DatoGeneralUsuario datogeneralusuarioAux:datogeneralusuarios) {
					if(datogeneralusuarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(datogeneralusuarioAux.getIsDeleted() || (datogeneralusuarioAux.getIsChanged()&&!datogeneralusuarioAux.getIsNew())) {
						
						timestamp=datogeneralusuarioDataAccess.getSetVersionRowDatoGeneralUsuario(connexion,datogeneralusuarioAux.getId());
						
						if(!datogeneralusuarioAux.getVersionRow().equals(timestamp)) {	
							datogeneralusuarioAux.setVersionRow(timestamp);
						}
						
													
						datogeneralusuarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DatoGeneralUsuarioParameterReturnGeneral cargarCombosLoteForeignKeyDatoGeneralUsuarioWithConnection(String finalQueryGlobalUsuario,String finalQueryGlobalPais,String finalQueryGlobalProvincia,String finalQueryGlobalCiudad) throws Exception {
		DatoGeneralUsuarioParameterReturnGeneral  datogeneralusuarioReturnGeneral =new DatoGeneralUsuarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-cargarCombosLoteForeignKeyDatoGeneralUsuarioWithConnection");connexion.begin();
			
			datogeneralusuarioReturnGeneral =new DatoGeneralUsuarioParameterReturnGeneral();
			
			

			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			datogeneralusuarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			datogeneralusuarioReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			datogeneralusuarioReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			datogeneralusuarioReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return datogeneralusuarioReturnGeneral;
	}
	
	public DatoGeneralUsuarioParameterReturnGeneral cargarCombosLoteForeignKeyDatoGeneralUsuario(String finalQueryGlobalUsuario,String finalQueryGlobalPais,String finalQueryGlobalProvincia,String finalQueryGlobalCiudad) throws Exception {
		DatoGeneralUsuarioParameterReturnGeneral  datogeneralusuarioReturnGeneral =new DatoGeneralUsuarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			datogeneralusuarioReturnGeneral =new DatoGeneralUsuarioParameterReturnGeneral();
			
			

			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			datogeneralusuarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			datogeneralusuarioReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			datogeneralusuarioReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			datogeneralusuarioReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return datogeneralusuarioReturnGeneral;
	}
	
	
	public void deepLoad(DatoGeneralUsuario datogeneralusuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DatoGeneralUsuarioLogicAdditional.updateDatoGeneralUsuarioToGet(datogeneralusuario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		datogeneralusuario.setUsuario(datogeneralusuarioDataAccess.getUsuario(connexion,datogeneralusuario));
		datogeneralusuario.setPais(datogeneralusuarioDataAccess.getPais(connexion,datogeneralusuario));
		datogeneralusuario.setProvincia(datogeneralusuarioDataAccess.getProvincia(connexion,datogeneralusuario));
		datogeneralusuario.setCiudad(datogeneralusuarioDataAccess.getCiudad(connexion,datogeneralusuario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				datogeneralusuario.setUsuario(datogeneralusuarioDataAccess.getUsuario(connexion,datogeneralusuario));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				datogeneralusuario.setPais(datogeneralusuarioDataAccess.getPais(connexion,datogeneralusuario));
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				datogeneralusuario.setProvincia(datogeneralusuarioDataAccess.getProvincia(connexion,datogeneralusuario));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				datogeneralusuario.setCiudad(datogeneralusuarioDataAccess.getCiudad(connexion,datogeneralusuario));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralusuario.setUsuario(datogeneralusuarioDataAccess.getUsuario(connexion,datogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralusuario.setPais(datogeneralusuarioDataAccess.getPais(connexion,datogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralusuario.setProvincia(datogeneralusuarioDataAccess.getProvincia(connexion,datogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralusuario.setCiudad(datogeneralusuarioDataAccess.getCiudad(connexion,datogeneralusuario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		datogeneralusuario.setUsuario(datogeneralusuarioDataAccess.getUsuario(connexion,datogeneralusuario));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(datogeneralusuario.getUsuario(),isDeep,deepLoadType,clases);
				
		datogeneralusuario.setPais(datogeneralusuarioDataAccess.getPais(connexion,datogeneralusuario));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(datogeneralusuario.getPais(),isDeep,deepLoadType,clases);
				
		datogeneralusuario.setProvincia(datogeneralusuarioDataAccess.getProvincia(connexion,datogeneralusuario));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(datogeneralusuario.getProvincia(),isDeep,deepLoadType,clases);
				
		datogeneralusuario.setCiudad(datogeneralusuarioDataAccess.getCiudad(connexion,datogeneralusuario));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(datogeneralusuario.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				datogeneralusuario.setUsuario(datogeneralusuarioDataAccess.getUsuario(connexion,datogeneralusuario));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(datogeneralusuario.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				datogeneralusuario.setPais(datogeneralusuarioDataAccess.getPais(connexion,datogeneralusuario));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(datogeneralusuario.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				datogeneralusuario.setProvincia(datogeneralusuarioDataAccess.getProvincia(connexion,datogeneralusuario));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(datogeneralusuario.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				datogeneralusuario.setCiudad(datogeneralusuarioDataAccess.getCiudad(connexion,datogeneralusuario));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(datogeneralusuario.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralusuario.setUsuario(datogeneralusuarioDataAccess.getUsuario(connexion,datogeneralusuario));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(datogeneralusuario.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralusuario.setPais(datogeneralusuarioDataAccess.getPais(connexion,datogeneralusuario));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(datogeneralusuario.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralusuario.setProvincia(datogeneralusuarioDataAccess.getProvincia(connexion,datogeneralusuario));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(datogeneralusuario.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datogeneralusuario.setCiudad(datogeneralusuarioDataAccess.getCiudad(connexion,datogeneralusuario));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(datogeneralusuario.getCiudad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DatoGeneralUsuario datogeneralusuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DatoGeneralUsuarioLogicAdditional.updateDatoGeneralUsuarioToSave(datogeneralusuario,this.arrDatoGeneral);
			
DatoGeneralUsuarioDataAccess.save(datogeneralusuario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		UsuarioDataAccess.save(datogeneralusuario.getUsuario(),connexion);

		PaisDataAccess.save(datogeneralusuario.getPais(),connexion);

		ProvinciaDataAccess.save(datogeneralusuario.getProvincia(),connexion);

		CiudadDataAccess.save(datogeneralusuario.getCiudad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(datogeneralusuario.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(datogeneralusuario.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(datogeneralusuario.getProvincia(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(datogeneralusuario.getCiudad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		UsuarioDataAccess.save(datogeneralusuario.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(datogeneralusuario.getUsuario(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(datogeneralusuario.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(datogeneralusuario.getPais(),isDeep,deepLoadType,clases);
				

		ProvinciaDataAccess.save(datogeneralusuario.getProvincia(),connexion);
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(datogeneralusuario.getProvincia(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(datogeneralusuario.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(datogeneralusuario.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(datogeneralusuario.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(datogeneralusuario.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(datogeneralusuario.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(datogeneralusuario.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(datogeneralusuario.getProvincia(),connexion);
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepSave(datogeneralusuario.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(datogeneralusuario.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(datogeneralusuario.getCiudad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DatoGeneralUsuario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(datogeneralusuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(datogeneralusuario);
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
			this.deepLoad(this.datogeneralusuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DatoGeneralUsuario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(datogeneralusuarios!=null) {
				for(DatoGeneralUsuario datogeneralusuario:datogeneralusuarios) {
					this.deepLoad(datogeneralusuario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(datogeneralusuarios);
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
			if(datogeneralusuarios!=null) {
				for(DatoGeneralUsuario datogeneralusuario:datogeneralusuarios) {
					this.deepLoad(datogeneralusuario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(datogeneralusuarios);
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
			this.getNewConnexionToDeep(DatoGeneralUsuario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(datogeneralusuario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DatoGeneralUsuario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(datogeneralusuarios!=null) {
				for(DatoGeneralUsuario datogeneralusuario:datogeneralusuarios) {
					this.deepSave(datogeneralusuario,isDeep,deepLoadType,clases);
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
			if(datogeneralusuarios!=null) {
				for(DatoGeneralUsuario datogeneralusuario:datogeneralusuarios) {
					this.deepSave(datogeneralusuario,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDatoGeneralUsuariosFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,DatoGeneralUsuarioConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralUsuariosFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,DatoGeneralUsuarioConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralUsuariosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,DatoGeneralUsuarioConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralUsuariosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,DatoGeneralUsuarioConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralUsuariosFK_IdProvinciaWithConnection(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralUsuariosFK_IdProvincia(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoGeneralUsuariosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,DatoGeneralUsuarioConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoGeneralUsuariosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,DatoGeneralUsuarioConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			DatoGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(this.datogeneralusuarios);
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
			if(DatoGeneralUsuarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoGeneralUsuarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DatoGeneralUsuario datogeneralusuario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DatoGeneralUsuarioConstantesFunciones.ISCONAUDITORIA) {
				if(datogeneralusuario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoGeneralUsuarioDataAccess.TABLENAME, datogeneralusuario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DatoGeneralUsuarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DatoGeneralUsuarioLogic.registrarAuditoriaDetallesDatoGeneralUsuario(connexion,datogeneralusuario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(datogeneralusuario.getIsDeleted()) {
					/*if(!datogeneralusuario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DatoGeneralUsuarioDataAccess.TABLENAME, datogeneralusuario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DatoGeneralUsuarioLogic.registrarAuditoriaDetallesDatoGeneralUsuario(connexion,datogeneralusuario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoGeneralUsuarioDataAccess.TABLENAME, datogeneralusuario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(datogeneralusuario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoGeneralUsuarioDataAccess.TABLENAME, datogeneralusuario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DatoGeneralUsuarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DatoGeneralUsuarioLogic.registrarAuditoriaDetallesDatoGeneralUsuario(connexion,datogeneralusuario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDatoGeneralUsuario(Connexion connexion,DatoGeneralUsuario datogeneralusuario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.getid_pais().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().getid_pais()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().getid_pais().toString();
				}
				if(datogeneralusuario.getid_pais()!=null)
				{
					strValorNuevo=datogeneralusuario.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.getid_provincia().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().getid_provincia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().getid_provincia()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().getid_provincia().toString();
				}
				if(datogeneralusuario.getid_provincia()!=null)
				{
					strValorNuevo=datogeneralusuario.getid_provincia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.getid_ciudad().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().getid_ciudad()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().getid_ciudad().toString();
				}
				if(datogeneralusuario.getid_ciudad()!=null)
				{
					strValorNuevo=datogeneralusuario.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.getcedula().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().getcedula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().getcedula()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().getcedula();
				}
				if(datogeneralusuario.getcedula()!=null)
				{
					strValorNuevo=datogeneralusuario.getcedula() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.CEDULA,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.getapellidos().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().getapellidos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().getapellidos()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().getapellidos();
				}
				if(datogeneralusuario.getapellidos()!=null)
				{
					strValorNuevo=datogeneralusuario.getapellidos() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.APELLIDOS,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.getnombres().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().getnombres()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().getnombres()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().getnombres();
				}
				if(datogeneralusuario.getnombres()!=null)
				{
					strValorNuevo=datogeneralusuario.getnombres() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.NOMBRES,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.gettelefono().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().gettelefono()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().gettelefono();
				}
				if(datogeneralusuario.gettelefono()!=null)
				{
					strValorNuevo=datogeneralusuario.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.gettelefono_movil().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().gettelefono_movil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().gettelefono_movil()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().gettelefono_movil();
				}
				if(datogeneralusuario.gettelefono_movil()!=null)
				{
					strValorNuevo=datogeneralusuario.gettelefono_movil() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.TELEFONOMOVIL,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.gete_mail().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().gete_mail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().gete_mail()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().gete_mail();
				}
				if(datogeneralusuario.gete_mail()!=null)
				{
					strValorNuevo=datogeneralusuario.gete_mail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.EMAIL,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.geturl().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().geturl()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().geturl()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().geturl();
				}
				if(datogeneralusuario.geturl()!=null)
				{
					strValorNuevo=datogeneralusuario.geturl() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.URL,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.getfecha_nacimiento().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().getfecha_nacimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().getfecha_nacimiento()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().getfecha_nacimiento().toString();
				}
				if(datogeneralusuario.getfecha_nacimiento()!=null)
				{
					strValorNuevo=datogeneralusuario.getfecha_nacimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.FECHANACIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(datogeneralusuario.getIsNew()||!datogeneralusuario.getdireccion().equals(datogeneralusuario.getDatoGeneralUsuarioOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datogeneralusuario.getDatoGeneralUsuarioOriginal().getdireccion()!=null)
				{
					strValorActual=datogeneralusuario.getDatoGeneralUsuarioOriginal().getdireccion();
				}
				if(datogeneralusuario.getdireccion()!=null)
				{
					strValorNuevo=datogeneralusuario.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoGeneralUsuarioConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDatoGeneralUsuarioRelacionesWithConnection(DatoGeneralUsuario datogeneralusuario) throws Exception {

		if(!datogeneralusuario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDatoGeneralUsuarioRelacionesBase(datogeneralusuario,true);
		}
	}

	public void saveDatoGeneralUsuarioRelaciones(DatoGeneralUsuario datogeneralusuario)throws Exception {

		if(!datogeneralusuario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDatoGeneralUsuarioRelacionesBase(datogeneralusuario,false);
		}
	}

	public void saveDatoGeneralUsuarioRelacionesBase(DatoGeneralUsuario datogeneralusuario,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DatoGeneralUsuario-saveRelacionesWithConnection");}
	

			this.setDatoGeneralUsuario(datogeneralusuario);

				if((datogeneralusuario.getIsNew()||datogeneralusuario.getIsChanged())&&!datogeneralusuario.getIsDeleted()) {
					this.saveDatoGeneralUsuario();
					this.saveDatoGeneralUsuarioRelacionesDetalles();

				} else if(datogeneralusuario.getIsDeleted()) {
					this.saveDatoGeneralUsuarioRelacionesDetalles();
					this.saveDatoGeneralUsuario();
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
	
	
	private void saveDatoGeneralUsuarioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDatoGeneralUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DatoGeneralUsuarioConstantesFunciones.getClassesForeignKeysOfDatoGeneralUsuario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoGeneralUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DatoGeneralUsuarioConstantesFunciones.getClassesRelationshipsOfDatoGeneralUsuario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

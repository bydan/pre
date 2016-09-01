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
import com.bydan.erp.seguridad.util.ParametroGeneralUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.ParametroGeneralUsuarioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ParametroGeneralUsuarioParameterGeneral;
import com.bydan.erp.seguridad.business.entity.ParametroGeneralUsuario;
import com.bydan.erp.seguridad.business.logic.ParametroGeneralUsuarioLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroGeneralUsuarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroGeneralUsuarioLogic.class);
	
	protected ParametroGeneralUsuarioDataAccess parametrogeneralusuarioDataAccess; 	
	protected ParametroGeneralUsuario parametrogeneralusuario;
	protected List<ParametroGeneralUsuario> parametrogeneralusuarios;
	protected Object parametrogeneralusuarioObject;	
	protected List<Object> parametrogeneralusuariosObject;
	
	public static ClassValidator<ParametroGeneralUsuario> parametrogeneralusuarioValidator = new ClassValidator<ParametroGeneralUsuario>(ParametroGeneralUsuario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroGeneralUsuarioLogicAdditional parametrogeneralusuarioLogicAdditional=null;
	
	public ParametroGeneralUsuarioLogicAdditional getParametroGeneralUsuarioLogicAdditional() {
		return this.parametrogeneralusuarioLogicAdditional;
	}
	
	public void setParametroGeneralUsuarioLogicAdditional(ParametroGeneralUsuarioLogicAdditional parametrogeneralusuarioLogicAdditional) {
		try {
			this.parametrogeneralusuarioLogicAdditional=parametrogeneralusuarioLogicAdditional;
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
	
	
	
	
	public  ParametroGeneralUsuarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrogeneralusuarioDataAccess = new ParametroGeneralUsuarioDataAccess();
			
			this.parametrogeneralusuarios= new ArrayList<ParametroGeneralUsuario>();
			this.parametrogeneralusuario= new ParametroGeneralUsuario();
			
			this.parametrogeneralusuarioObject=new Object();
			this.parametrogeneralusuariosObject=new ArrayList<Object>();
				
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
			
			this.parametrogeneralusuarioDataAccess.setConnexionType(this.connexionType);
			this.parametrogeneralusuarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroGeneralUsuarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrogeneralusuarioDataAccess = new ParametroGeneralUsuarioDataAccess();
			this.parametrogeneralusuarios= new ArrayList<ParametroGeneralUsuario>();
			this.parametrogeneralusuario= new ParametroGeneralUsuario();
			this.parametrogeneralusuarioObject=new Object();
			this.parametrogeneralusuariosObject=new ArrayList<Object>();
			
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
			
			this.parametrogeneralusuarioDataAccess.setConnexionType(this.connexionType);
			this.parametrogeneralusuarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroGeneralUsuario getParametroGeneralUsuario() throws Exception {	
		ParametroGeneralUsuarioLogicAdditional.checkParametroGeneralUsuarioToGet(parametrogeneralusuario,this.datosCliente,this.arrDatoGeneral);
		ParametroGeneralUsuarioLogicAdditional.updateParametroGeneralUsuarioToGet(parametrogeneralusuario,this.arrDatoGeneral);
		
		return parametrogeneralusuario;
	}
		
	public void setParametroGeneralUsuario(ParametroGeneralUsuario newParametroGeneralUsuario) {
		this.parametrogeneralusuario = newParametroGeneralUsuario;
	}
	
	public ParametroGeneralUsuarioDataAccess getParametroGeneralUsuarioDataAccess() {
		return parametrogeneralusuarioDataAccess;
	}
	
	public void setParametroGeneralUsuarioDataAccess(ParametroGeneralUsuarioDataAccess newparametrogeneralusuarioDataAccess) {
		this.parametrogeneralusuarioDataAccess = newparametrogeneralusuarioDataAccess;
	}
	
	public List<ParametroGeneralUsuario> getParametroGeneralUsuarios() throws Exception {		
		this.quitarParametroGeneralUsuariosNulos();
		
		ParametroGeneralUsuarioLogicAdditional.checkParametroGeneralUsuarioToGets(parametrogeneralusuarios,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroGeneralUsuario parametrogeneralusuarioLocal: parametrogeneralusuarios ) {
			ParametroGeneralUsuarioLogicAdditional.updateParametroGeneralUsuarioToGet(parametrogeneralusuarioLocal,this.arrDatoGeneral);
		}
		
		return parametrogeneralusuarios;
	}
	
	public void setParametroGeneralUsuarios(List<ParametroGeneralUsuario> newParametroGeneralUsuarios) {
		this.parametrogeneralusuarios = newParametroGeneralUsuarios;
	}
	
	public Object getParametroGeneralUsuarioObject() {	
		this.parametrogeneralusuarioObject=this.parametrogeneralusuarioDataAccess.getEntityObject();
		return this.parametrogeneralusuarioObject;
	}
		
	public void setParametroGeneralUsuarioObject(Object newParametroGeneralUsuarioObject) {
		this.parametrogeneralusuarioObject = newParametroGeneralUsuarioObject;
	}
	
	public List<Object> getParametroGeneralUsuariosObject() {		
		this.parametrogeneralusuariosObject=this.parametrogeneralusuarioDataAccess.getEntitiesObject();
		return this.parametrogeneralusuariosObject;
	}
		
	public void setParametroGeneralUsuariosObject(List<Object> newParametroGeneralUsuariosObject) {
		this.parametrogeneralusuariosObject = newParametroGeneralUsuariosObject;
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
		
		if(this.parametrogeneralusuarioDataAccess!=null) {
			this.parametrogeneralusuarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrogeneralusuarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrogeneralusuarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrogeneralusuario=parametrogeneralusuarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuario);
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
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		  		  
        try {
			
			parametrogeneralusuario=parametrogeneralusuarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrogeneralusuario=parametrogeneralusuarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuario);
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
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		  		  
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
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		  		  
        try {
			
			parametrogeneralusuario=parametrogeneralusuarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		  		  
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
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrogeneralusuarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrogeneralusuarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrogeneralusuarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrogeneralusuarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrogeneralusuarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrogeneralusuarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
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
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		  		  
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
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		  		  
        try {			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		  		  
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
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
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
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		  		  
        try {
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
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
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
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
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuario=parametrogeneralusuarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuario);
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
		parametrogeneralusuario = new  ParametroGeneralUsuario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuario=parametrogeneralusuarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
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
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		  		  
        try {
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroGeneralUsuariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getTodosParametroGeneralUsuariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
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
	
	public  void  getTodosParametroGeneralUsuarios(String sFinalQuery,Pagination pagination)throws Exception {
		parametrogeneralusuarios = new  ArrayList<ParametroGeneralUsuario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroGeneralUsuario(parametrogeneralusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroGeneralUsuario(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrogeneralusuario.getIsNew() || parametrogeneralusuario.getIsChanged()) { 
			this.invalidValues = parametrogeneralusuarioValidator.getInvalidValues(parametrogeneralusuario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrogeneralusuario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroGeneralUsuario(List<ParametroGeneralUsuario> ParametroGeneralUsuarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroGeneralUsuario parametrogeneralusuarioLocal:parametrogeneralusuarios) {				
			estaValidadoObjeto=this.validarGuardarParametroGeneralUsuario(parametrogeneralusuarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroGeneralUsuario(List<ParametroGeneralUsuario> ParametroGeneralUsuarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroGeneralUsuario(parametrogeneralusuarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroGeneralUsuario(ParametroGeneralUsuario ParametroGeneralUsuario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroGeneralUsuario(parametrogeneralusuario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrogeneralusuario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroGeneralUsuarioConstantesFunciones.getParametroGeneralUsuarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrogeneralusuario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroGeneralUsuarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroGeneralUsuarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroGeneralUsuarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-saveParametroGeneralUsuarioWithConnection");connexion.begin();			
			
			ParametroGeneralUsuarioLogicAdditional.checkParametroGeneralUsuarioToSave(this.parametrogeneralusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroGeneralUsuarioLogicAdditional.updateParametroGeneralUsuarioToSave(this.parametrogeneralusuario,this.arrDatoGeneral);
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrogeneralusuario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroGeneralUsuario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroGeneralUsuario(this.parametrogeneralusuario)) {
				ParametroGeneralUsuarioDataAccess.save(this.parametrogeneralusuario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroGeneralUsuarioLogicAdditional.checkParametroGeneralUsuarioToSaveAfter(this.parametrogeneralusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroGeneralUsuario();
			
			connexion.commit();			
			
			if(this.parametrogeneralusuario.getIsDeleted()) {
				this.parametrogeneralusuario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroGeneralUsuario()throws Exception {	
		try {	
			
			ParametroGeneralUsuarioLogicAdditional.checkParametroGeneralUsuarioToSave(this.parametrogeneralusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroGeneralUsuarioLogicAdditional.updateParametroGeneralUsuarioToSave(this.parametrogeneralusuario,this.arrDatoGeneral);
			
			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrogeneralusuario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroGeneralUsuario(this.parametrogeneralusuario)) {			
				ParametroGeneralUsuarioDataAccess.save(this.parametrogeneralusuario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrogeneralusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroGeneralUsuarioLogicAdditional.checkParametroGeneralUsuarioToSaveAfter(this.parametrogeneralusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrogeneralusuario.getIsDeleted()) {
				this.parametrogeneralusuario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroGeneralUsuariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-saveParametroGeneralUsuariosWithConnection");connexion.begin();			
			
			ParametroGeneralUsuarioLogicAdditional.checkParametroGeneralUsuarioToSaves(parametrogeneralusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroGeneralUsuarios();
			
			Boolean validadoTodosParametroGeneralUsuario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroGeneralUsuario parametrogeneralusuarioLocal:parametrogeneralusuarios) {		
				if(parametrogeneralusuarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroGeneralUsuarioLogicAdditional.updateParametroGeneralUsuarioToSave(parametrogeneralusuarioLocal,this.arrDatoGeneral);
	        	
				ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrogeneralusuarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroGeneralUsuario(parametrogeneralusuarioLocal)) {
					ParametroGeneralUsuarioDataAccess.save(parametrogeneralusuarioLocal, connexion);				
				} else {
					validadoTodosParametroGeneralUsuario=false;
				}
			}
			
			if(!validadoTodosParametroGeneralUsuario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroGeneralUsuarioLogicAdditional.checkParametroGeneralUsuarioToSavesAfter(parametrogeneralusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroGeneralUsuarios();
			
			connexion.commit();		
			
			this.quitarParametroGeneralUsuariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroGeneralUsuarios()throws Exception {				
		 try {	
			ParametroGeneralUsuarioLogicAdditional.checkParametroGeneralUsuarioToSaves(parametrogeneralusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroGeneralUsuario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroGeneralUsuario parametrogeneralusuarioLocal:parametrogeneralusuarios) {				
				if(parametrogeneralusuarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroGeneralUsuarioLogicAdditional.updateParametroGeneralUsuarioToSave(parametrogeneralusuarioLocal,this.arrDatoGeneral);
	        	
				ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrogeneralusuarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroGeneralUsuario(parametrogeneralusuarioLocal)) {				
					ParametroGeneralUsuarioDataAccess.save(parametrogeneralusuarioLocal, connexion);				
				} else {
					validadoTodosParametroGeneralUsuario=false;
				}
			}
			
			if(!validadoTodosParametroGeneralUsuario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroGeneralUsuarioLogicAdditional.checkParametroGeneralUsuarioToSavesAfter(parametrogeneralusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroGeneralUsuariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroGeneralUsuarioParameterReturnGeneral procesarAccionParametroGeneralUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroGeneralUsuario> parametrogeneralusuarios,ParametroGeneralUsuarioParameterReturnGeneral parametrogeneralusuarioParameterGeneral)throws Exception {
		 try {	
			ParametroGeneralUsuarioParameterReturnGeneral parametrogeneralusuarioReturnGeneral=new ParametroGeneralUsuarioParameterReturnGeneral();
	
			ParametroGeneralUsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrogeneralusuarios,parametrogeneralusuarioParameterGeneral,parametrogeneralusuarioReturnGeneral);
			
			return parametrogeneralusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroGeneralUsuarioParameterReturnGeneral procesarAccionParametroGeneralUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroGeneralUsuario> parametrogeneralusuarios,ParametroGeneralUsuarioParameterReturnGeneral parametrogeneralusuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-procesarAccionParametroGeneralUsuariosWithConnection");connexion.begin();			
			
			ParametroGeneralUsuarioParameterReturnGeneral parametrogeneralusuarioReturnGeneral=new ParametroGeneralUsuarioParameterReturnGeneral();
	
			ParametroGeneralUsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrogeneralusuarios,parametrogeneralusuarioParameterGeneral,parametrogeneralusuarioReturnGeneral);
			
			this.connexion.commit();
			
			return parametrogeneralusuarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroGeneralUsuarioParameterReturnGeneral procesarEventosParametroGeneralUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroGeneralUsuario> parametrogeneralusuarios,ParametroGeneralUsuario parametrogeneralusuario,ParametroGeneralUsuarioParameterReturnGeneral parametrogeneralusuarioParameterGeneral,Boolean isEsNuevoParametroGeneralUsuario,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroGeneralUsuarioParameterReturnGeneral parametrogeneralusuarioReturnGeneral=new ParametroGeneralUsuarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrogeneralusuarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroGeneralUsuarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrogeneralusuarios,parametrogeneralusuario,parametrogeneralusuarioParameterGeneral,parametrogeneralusuarioReturnGeneral,isEsNuevoParametroGeneralUsuario,clases);
			
			return parametrogeneralusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroGeneralUsuarioParameterReturnGeneral procesarEventosParametroGeneralUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroGeneralUsuario> parametrogeneralusuarios,ParametroGeneralUsuario parametrogeneralusuario,ParametroGeneralUsuarioParameterReturnGeneral parametrogeneralusuarioParameterGeneral,Boolean isEsNuevoParametroGeneralUsuario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-procesarEventosParametroGeneralUsuariosWithConnection");connexion.begin();			
			
			ParametroGeneralUsuarioParameterReturnGeneral parametrogeneralusuarioReturnGeneral=new ParametroGeneralUsuarioParameterReturnGeneral();
	
			parametrogeneralusuarioReturnGeneral.setParametroGeneralUsuario(parametrogeneralusuario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrogeneralusuarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroGeneralUsuarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrogeneralusuarios,parametrogeneralusuario,parametrogeneralusuarioParameterGeneral,parametrogeneralusuarioReturnGeneral,isEsNuevoParametroGeneralUsuario,clases);
			
			this.connexion.commit();
			
			return parametrogeneralusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroGeneralUsuarioParameterReturnGeneral procesarImportacionParametroGeneralUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroGeneralUsuarioParameterReturnGeneral parametrogeneralusuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-procesarImportacionParametroGeneralUsuariosWithConnection");connexion.begin();			
			
			ParametroGeneralUsuarioParameterReturnGeneral parametrogeneralusuarioReturnGeneral=new ParametroGeneralUsuarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrogeneralusuarios=new ArrayList<ParametroGeneralUsuario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrogeneralusuario=new ParametroGeneralUsuario();
				
				
				if(conColumnasBase) {this.parametrogeneralusuario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrogeneralusuario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrogeneralusuario.setfecha_sistema(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setdia(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_tamanio_control_manual(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_tamanio_control_todo_relacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_guardar_relaciones(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_mensaje_confirmacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_botones_tool_bar(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_mostrar_acciones_campo_general(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_mostrar_acciones_campo_relaciones(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_exportar_cabecera(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_exportar_campo_version(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setpath_exportar(arrColumnas[iColumn++]);
				this.parametrogeneralusuario.setcon_precargar_ventanas(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_precargar_por_usuario(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrogeneralusuario.setcon_cargar_por_parte(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametrogeneralusuarios.add(this.parametrogeneralusuario);
			}
			
			this.saveParametroGeneralUsuarios();
			
			this.connexion.commit();
			
			parametrogeneralusuarioReturnGeneral.setConRetornoEstaProcesado(true);
			parametrogeneralusuarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrogeneralusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroGeneralUsuariosEliminados() throws Exception {				
		
		List<ParametroGeneralUsuario> parametrogeneralusuariosAux= new ArrayList<ParametroGeneralUsuario>();
		
		for(ParametroGeneralUsuario parametrogeneralusuario:parametrogeneralusuarios) {
			if(!parametrogeneralusuario.getIsDeleted()) {
				parametrogeneralusuariosAux.add(parametrogeneralusuario);
			}
		}
		
		parametrogeneralusuarios=parametrogeneralusuariosAux;
	}
	
	public void quitarParametroGeneralUsuariosNulos() throws Exception {				
		
		List<ParametroGeneralUsuario> parametrogeneralusuariosAux= new ArrayList<ParametroGeneralUsuario>();
		
		for(ParametroGeneralUsuario parametrogeneralusuario : this.parametrogeneralusuarios) {
			if(parametrogeneralusuario==null) {
				parametrogeneralusuariosAux.add(parametrogeneralusuario);
			}
		}
		
		//this.parametrogeneralusuarios=parametrogeneralusuariosAux;
		
		this.parametrogeneralusuarios.removeAll(parametrogeneralusuariosAux);
	}
	
	public void getSetVersionRowParametroGeneralUsuarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrogeneralusuario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrogeneralusuario.getIsDeleted() || (parametrogeneralusuario.getIsChanged()&&!parametrogeneralusuario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrogeneralusuarioDataAccess.getSetVersionRowParametroGeneralUsuario(connexion,parametrogeneralusuario.getId());
				
				if(!parametrogeneralusuario.getVersionRow().equals(timestamp)) {	
					parametrogeneralusuario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrogeneralusuario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroGeneralUsuario()throws Exception {	
		
		if(parametrogeneralusuario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrogeneralusuario.getIsDeleted() || (parametrogeneralusuario.getIsChanged()&&!parametrogeneralusuario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrogeneralusuarioDataAccess.getSetVersionRowParametroGeneralUsuario(connexion,parametrogeneralusuario.getId());
			
			try {							
				if(!parametrogeneralusuario.getVersionRow().equals(timestamp)) {	
					parametrogeneralusuario.setVersionRow(timestamp);
				}
				
				parametrogeneralusuario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroGeneralUsuariosWithConnection()throws Exception {	
		if(parametrogeneralusuarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroGeneralUsuario parametrogeneralusuarioAux:parametrogeneralusuarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrogeneralusuarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrogeneralusuarioAux.getIsDeleted() || (parametrogeneralusuarioAux.getIsChanged()&&!parametrogeneralusuarioAux.getIsNew())) {
						
						timestamp=parametrogeneralusuarioDataAccess.getSetVersionRowParametroGeneralUsuario(connexion,parametrogeneralusuarioAux.getId());
						
						if(!parametrogeneralusuario.getVersionRow().equals(timestamp)) {	
							parametrogeneralusuarioAux.setVersionRow(timestamp);
						}
								
						parametrogeneralusuarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroGeneralUsuarios()throws Exception {	
		if(parametrogeneralusuarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroGeneralUsuario parametrogeneralusuarioAux:parametrogeneralusuarios) {
					if(parametrogeneralusuarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrogeneralusuarioAux.getIsDeleted() || (parametrogeneralusuarioAux.getIsChanged()&&!parametrogeneralusuarioAux.getIsNew())) {
						
						timestamp=parametrogeneralusuarioDataAccess.getSetVersionRowParametroGeneralUsuario(connexion,parametrogeneralusuarioAux.getId());
						
						if(!parametrogeneralusuarioAux.getVersionRow().equals(timestamp)) {	
							parametrogeneralusuarioAux.setVersionRow(timestamp);
						}
						
													
						parametrogeneralusuarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroGeneralUsuarioParameterReturnGeneral cargarCombosLoteForeignKeyParametroGeneralUsuarioWithConnection(String finalQueryGlobalUsuario,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalMoneda,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalTipoVisual,String finalQueryGlobalTipoFondo,String finalQueryGlobalTipoFondoBorde,String finalQueryGlobalTipoFondoControl,String finalQueryGlobalTipoFuente,String finalQueryGlobalTipoTamanioControlNormal,String finalQueryGlobalTipoTamanioControlRelacion,String finalQueryGlobalTipoExportar,String finalQueryGlobalTipoDelimiter) throws Exception {
		ParametroGeneralUsuarioParameterReturnGeneral  parametrogeneralusuarioReturnGeneral =new ParametroGeneralUsuarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroGeneralUsuarioWithConnection");connexion.begin();
			
			parametrogeneralusuarioReturnGeneral =new ParametroGeneralUsuarioParameterReturnGeneral();
			
			

			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			parametrogeneralusuarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrogeneralusuarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrogeneralusuarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			parametrogeneralusuarioReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			parametrogeneralusuarioReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			parametrogeneralusuarioReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			parametrogeneralusuarioReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			parametrogeneralusuarioReturnGeneral.setmessForeignKey(messForeignKey);


			List<TipoVisual> tipovisualsForeignKey=new ArrayList<TipoVisual>();
			TipoVisualLogic tipovisualLogic=new TipoVisualLogic();
			tipovisualLogic.setConnexion(this.connexion);
			tipovisualLogic.getTipoVisualDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoVisual.equals("NONE")) {
				tipovisualLogic.getTodosTipoVisuals(finalQueryGlobalTipoVisual,new Pagination());
				tipovisualsForeignKey=tipovisualLogic.getTipoVisuals();
			}

			parametrogeneralusuarioReturnGeneral.settipovisualsForeignKey(tipovisualsForeignKey);


			List<TipoFondo> tipofondosForeignKey=new ArrayList<TipoFondo>();
			TipoFondoLogic tipofondoLogic=new TipoFondoLogic();
			tipofondoLogic.setConnexion(this.connexion);
			tipofondoLogic.getTipoFondoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFondo.equals("NONE")) {
				tipofondoLogic.getTodosTipoFondos(finalQueryGlobalTipoFondo,new Pagination());
				tipofondosForeignKey=tipofondoLogic.getTipoFondos();
			}

			parametrogeneralusuarioReturnGeneral.settipofondosForeignKey(tipofondosForeignKey);


			List<TipoFondo> tipofondobordesForeignKey=new ArrayList<TipoFondo>();
			TipoFondoLogic tipofondobordeLogic=new TipoFondoLogic();
			tipofondobordeLogic.setConnexion(this.connexion);
			tipofondobordeLogic.getTipoFondoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFondoBorde.equals("NONE")) {
				tipofondobordeLogic.getTodosTipoFondos(finalQueryGlobalTipoFondoBorde,new Pagination());
				tipofondobordesForeignKey=tipofondobordeLogic.getTipoFondos();
			}

			parametrogeneralusuarioReturnGeneral.settipofondobordesForeignKey(tipofondobordesForeignKey);


			List<TipoFondoControl> tipofondocontrolsForeignKey=new ArrayList<TipoFondoControl>();
			TipoFondoControlLogic tipofondocontrolLogic=new TipoFondoControlLogic();
			tipofondocontrolLogic.setConnexion(this.connexion);
			tipofondocontrolLogic.getTipoFondoControlDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFondoControl.equals("NONE")) {
				tipofondocontrolLogic.getTodosTipoFondoControls(finalQueryGlobalTipoFondoControl,new Pagination());
				tipofondocontrolsForeignKey=tipofondocontrolLogic.getTipoFondoControls();
			}

			parametrogeneralusuarioReturnGeneral.settipofondocontrolsForeignKey(tipofondocontrolsForeignKey);


			List<TipoFuente> tipofuentesForeignKey=new ArrayList<TipoFuente>();
			TipoFuenteLogic tipofuenteLogic=new TipoFuenteLogic();
			tipofuenteLogic.setConnexion(this.connexion);
			tipofuenteLogic.getTipoFuenteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFuente.equals("NONE")) {
				tipofuenteLogic.getTodosTipoFuentes(finalQueryGlobalTipoFuente,new Pagination());
				tipofuentesForeignKey=tipofuenteLogic.getTipoFuentes();
			}

			parametrogeneralusuarioReturnGeneral.settipofuentesForeignKey(tipofuentesForeignKey);


			List<TipoTamanioControl> tipotamaniocontrolnormalsForeignKey=new ArrayList<TipoTamanioControl>();
			TipoTamanioControlLogic tipotamaniocontrolnormalLogic=new TipoTamanioControlLogic();
			tipotamaniocontrolnormalLogic.setConnexion(this.connexion);
			tipotamaniocontrolnormalLogic.getTipoTamanioControlDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTamanioControlNormal.equals("NONE")) {
				tipotamaniocontrolnormalLogic.getTodosTipoTamanioControls(finalQueryGlobalTipoTamanioControlNormal,new Pagination());
				tipotamaniocontrolnormalsForeignKey=tipotamaniocontrolnormalLogic.getTipoTamanioControls();
			}

			parametrogeneralusuarioReturnGeneral.settipotamaniocontrolnormalsForeignKey(tipotamaniocontrolnormalsForeignKey);


			List<TipoTamanioControl> tipotamaniocontrolrelacionsForeignKey=new ArrayList<TipoTamanioControl>();
			TipoTamanioControlLogic tipotamaniocontrolrelacionLogic=new TipoTamanioControlLogic();
			tipotamaniocontrolrelacionLogic.setConnexion(this.connexion);
			tipotamaniocontrolrelacionLogic.getTipoTamanioControlDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTamanioControlRelacion.equals("NONE")) {
				tipotamaniocontrolrelacionLogic.getTodosTipoTamanioControls(finalQueryGlobalTipoTamanioControlRelacion,new Pagination());
				tipotamaniocontrolrelacionsForeignKey=tipotamaniocontrolrelacionLogic.getTipoTamanioControls();
			}

			parametrogeneralusuarioReturnGeneral.settipotamaniocontrolrelacionsForeignKey(tipotamaniocontrolrelacionsForeignKey);


			List<TipoExportar> tipoexportarsForeignKey=new ArrayList<TipoExportar>();
			TipoExportarLogic tipoexportarLogic=new TipoExportarLogic();
			tipoexportarLogic.setConnexion(this.connexion);
			tipoexportarLogic.getTipoExportarDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoExportar.equals("NONE")) {
				tipoexportarLogic.getTodosTipoExportars(finalQueryGlobalTipoExportar,new Pagination());
				tipoexportarsForeignKey=tipoexportarLogic.getTipoExportars();
			}

			parametrogeneralusuarioReturnGeneral.settipoexportarsForeignKey(tipoexportarsForeignKey);


			List<TipoDelimiter> tipodelimitersForeignKey=new ArrayList<TipoDelimiter>();
			TipoDelimiterLogic tipodelimiterLogic=new TipoDelimiterLogic();
			tipodelimiterLogic.setConnexion(this.connexion);
			tipodelimiterLogic.getTipoDelimiterDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDelimiter.equals("NONE")) {
				tipodelimiterLogic.getTodosTipoDelimiters(finalQueryGlobalTipoDelimiter,new Pagination());
				tipodelimitersForeignKey=tipodelimiterLogic.getTipoDelimiters();
			}

			parametrogeneralusuarioReturnGeneral.settipodelimitersForeignKey(tipodelimitersForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrogeneralusuarioReturnGeneral;
	}
	
	public ParametroGeneralUsuarioParameterReturnGeneral cargarCombosLoteForeignKeyParametroGeneralUsuario(String finalQueryGlobalUsuario,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalMoneda,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalTipoVisual,String finalQueryGlobalTipoFondo,String finalQueryGlobalTipoFondoBorde,String finalQueryGlobalTipoFondoControl,String finalQueryGlobalTipoFuente,String finalQueryGlobalTipoTamanioControlNormal,String finalQueryGlobalTipoTamanioControlRelacion,String finalQueryGlobalTipoExportar,String finalQueryGlobalTipoDelimiter) throws Exception {
		ParametroGeneralUsuarioParameterReturnGeneral  parametrogeneralusuarioReturnGeneral =new ParametroGeneralUsuarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrogeneralusuarioReturnGeneral =new ParametroGeneralUsuarioParameterReturnGeneral();
			
			

			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			parametrogeneralusuarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrogeneralusuarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrogeneralusuarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			parametrogeneralusuarioReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			parametrogeneralusuarioReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			parametrogeneralusuarioReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			parametrogeneralusuarioReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			parametrogeneralusuarioReturnGeneral.setmessForeignKey(messForeignKey);


			List<TipoVisual> tipovisualsForeignKey=new ArrayList<TipoVisual>();
			TipoVisualLogic tipovisualLogic=new TipoVisualLogic();
			tipovisualLogic.setConnexion(this.connexion);
			tipovisualLogic.getTipoVisualDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoVisual.equals("NONE")) {
				tipovisualLogic.getTodosTipoVisuals(finalQueryGlobalTipoVisual,new Pagination());
				tipovisualsForeignKey=tipovisualLogic.getTipoVisuals();
			}

			parametrogeneralusuarioReturnGeneral.settipovisualsForeignKey(tipovisualsForeignKey);


			List<TipoFondo> tipofondosForeignKey=new ArrayList<TipoFondo>();
			TipoFondoLogic tipofondoLogic=new TipoFondoLogic();
			tipofondoLogic.setConnexion(this.connexion);
			tipofondoLogic.getTipoFondoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFondo.equals("NONE")) {
				tipofondoLogic.getTodosTipoFondos(finalQueryGlobalTipoFondo,new Pagination());
				tipofondosForeignKey=tipofondoLogic.getTipoFondos();
			}

			parametrogeneralusuarioReturnGeneral.settipofondosForeignKey(tipofondosForeignKey);


			List<TipoFondo> tipofondobordesForeignKey=new ArrayList<TipoFondo>();
			TipoFondoLogic tipofondobordeLogic=new TipoFondoLogic();
			tipofondobordeLogic.setConnexion(this.connexion);
			tipofondobordeLogic.getTipoFondoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFondoBorde.equals("NONE")) {
				tipofondobordeLogic.getTodosTipoFondos(finalQueryGlobalTipoFondoBorde,new Pagination());
				tipofondobordesForeignKey=tipofondobordeLogic.getTipoFondos();
			}

			parametrogeneralusuarioReturnGeneral.settipofondobordesForeignKey(tipofondobordesForeignKey);


			List<TipoFondoControl> tipofondocontrolsForeignKey=new ArrayList<TipoFondoControl>();
			TipoFondoControlLogic tipofondocontrolLogic=new TipoFondoControlLogic();
			tipofondocontrolLogic.setConnexion(this.connexion);
			tipofondocontrolLogic.getTipoFondoControlDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFondoControl.equals("NONE")) {
				tipofondocontrolLogic.getTodosTipoFondoControls(finalQueryGlobalTipoFondoControl,new Pagination());
				tipofondocontrolsForeignKey=tipofondocontrolLogic.getTipoFondoControls();
			}

			parametrogeneralusuarioReturnGeneral.settipofondocontrolsForeignKey(tipofondocontrolsForeignKey);


			List<TipoFuente> tipofuentesForeignKey=new ArrayList<TipoFuente>();
			TipoFuenteLogic tipofuenteLogic=new TipoFuenteLogic();
			tipofuenteLogic.setConnexion(this.connexion);
			tipofuenteLogic.getTipoFuenteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFuente.equals("NONE")) {
				tipofuenteLogic.getTodosTipoFuentes(finalQueryGlobalTipoFuente,new Pagination());
				tipofuentesForeignKey=tipofuenteLogic.getTipoFuentes();
			}

			parametrogeneralusuarioReturnGeneral.settipofuentesForeignKey(tipofuentesForeignKey);


			List<TipoTamanioControl> tipotamaniocontrolnormalsForeignKey=new ArrayList<TipoTamanioControl>();
			TipoTamanioControlLogic tipotamaniocontrolnormalLogic=new TipoTamanioControlLogic();
			tipotamaniocontrolnormalLogic.setConnexion(this.connexion);
			tipotamaniocontrolnormalLogic.getTipoTamanioControlDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTamanioControlNormal.equals("NONE")) {
				tipotamaniocontrolnormalLogic.getTodosTipoTamanioControls(finalQueryGlobalTipoTamanioControlNormal,new Pagination());
				tipotamaniocontrolnormalsForeignKey=tipotamaniocontrolnormalLogic.getTipoTamanioControls();
			}

			parametrogeneralusuarioReturnGeneral.settipotamaniocontrolnormalsForeignKey(tipotamaniocontrolnormalsForeignKey);


			List<TipoTamanioControl> tipotamaniocontrolrelacionsForeignKey=new ArrayList<TipoTamanioControl>();
			TipoTamanioControlLogic tipotamaniocontrolrelacionLogic=new TipoTamanioControlLogic();
			tipotamaniocontrolrelacionLogic.setConnexion(this.connexion);
			tipotamaniocontrolrelacionLogic.getTipoTamanioControlDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTamanioControlRelacion.equals("NONE")) {
				tipotamaniocontrolrelacionLogic.getTodosTipoTamanioControls(finalQueryGlobalTipoTamanioControlRelacion,new Pagination());
				tipotamaniocontrolrelacionsForeignKey=tipotamaniocontrolrelacionLogic.getTipoTamanioControls();
			}

			parametrogeneralusuarioReturnGeneral.settipotamaniocontrolrelacionsForeignKey(tipotamaniocontrolrelacionsForeignKey);


			List<TipoExportar> tipoexportarsForeignKey=new ArrayList<TipoExportar>();
			TipoExportarLogic tipoexportarLogic=new TipoExportarLogic();
			tipoexportarLogic.setConnexion(this.connexion);
			tipoexportarLogic.getTipoExportarDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoExportar.equals("NONE")) {
				tipoexportarLogic.getTodosTipoExportars(finalQueryGlobalTipoExportar,new Pagination());
				tipoexportarsForeignKey=tipoexportarLogic.getTipoExportars();
			}

			parametrogeneralusuarioReturnGeneral.settipoexportarsForeignKey(tipoexportarsForeignKey);


			List<TipoDelimiter> tipodelimitersForeignKey=new ArrayList<TipoDelimiter>();
			TipoDelimiterLogic tipodelimiterLogic=new TipoDelimiterLogic();
			tipodelimiterLogic.setConnexion(this.connexion);
			tipodelimiterLogic.getTipoDelimiterDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDelimiter.equals("NONE")) {
				tipodelimiterLogic.getTodosTipoDelimiters(finalQueryGlobalTipoDelimiter,new Pagination());
				tipodelimitersForeignKey=tipodelimiterLogic.getTipoDelimiters();
			}

			parametrogeneralusuarioReturnGeneral.settipodelimitersForeignKey(tipodelimitersForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrogeneralusuarioReturnGeneral;
	}
	
	
	public void deepLoad(ParametroGeneralUsuario parametrogeneralusuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroGeneralUsuarioLogicAdditional.updateParametroGeneralUsuarioToGet(parametrogeneralusuario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrogeneralusuario.setUsuario(parametrogeneralusuarioDataAccess.getUsuario(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setEmpresa(parametrogeneralusuarioDataAccess.getEmpresa(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setSucursal(parametrogeneralusuarioDataAccess.getSucursal(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setEjercicio(parametrogeneralusuarioDataAccess.getEjercicio(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setPeriodo(parametrogeneralusuarioDataAccess.getPeriodo(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setMoneda(parametrogeneralusuarioDataAccess.getMoneda(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setAnio(parametrogeneralusuarioDataAccess.getAnio(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setMes(parametrogeneralusuarioDataAccess.getMes(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setTipoVisual(parametrogeneralusuarioDataAccess.getTipoVisual(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setTipoFondo(parametrogeneralusuarioDataAccess.getTipoFondo(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setTipoFondoBorde(parametrogeneralusuarioDataAccess.getTipoFondoBorde(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setTipoFondoControl(parametrogeneralusuarioDataAccess.getTipoFondoControl(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setTipoFuente(parametrogeneralusuarioDataAccess.getTipoFuente(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setTipoTamanioControlNormal(parametrogeneralusuarioDataAccess.getTipoTamanioControlNormal(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setTipoTamanioControlRelacion(parametrogeneralusuarioDataAccess.getTipoTamanioControlRelacion(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setTipoExportar(parametrogeneralusuarioDataAccess.getTipoExportar(connexion,parametrogeneralusuario));
		parametrogeneralusuario.setTipoDelimiter(parametrogeneralusuarioDataAccess.getTipoDelimiter(connexion,parametrogeneralusuario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				parametrogeneralusuario.setUsuario(parametrogeneralusuarioDataAccess.getUsuario(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				parametrogeneralusuario.setEmpresa(parametrogeneralusuarioDataAccess.getEmpresa(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrogeneralusuario.setSucursal(parametrogeneralusuarioDataAccess.getSucursal(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				parametrogeneralusuario.setEjercicio(parametrogeneralusuarioDataAccess.getEjercicio(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				parametrogeneralusuario.setPeriodo(parametrogeneralusuarioDataAccess.getPeriodo(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				parametrogeneralusuario.setMoneda(parametrogeneralusuarioDataAccess.getMoneda(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				parametrogeneralusuario.setAnio(parametrogeneralusuarioDataAccess.getAnio(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				parametrogeneralusuario.setMes(parametrogeneralusuarioDataAccess.getMes(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(TipoVisual.class)) {
				parametrogeneralusuario.setTipoVisual(parametrogeneralusuarioDataAccess.getTipoVisual(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(TipoFondo.class)) {
				parametrogeneralusuario.setTipoFondo(parametrogeneralusuarioDataAccess.getTipoFondo(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(TipoFondo.class)) {
				parametrogeneralusuario.setTipoFondoBorde(parametrogeneralusuarioDataAccess.getTipoFondoBorde(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(TipoFondoControl.class)) {
				parametrogeneralusuario.setTipoFondoControl(parametrogeneralusuarioDataAccess.getTipoFondoControl(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(TipoFuente.class)) {
				parametrogeneralusuario.setTipoFuente(parametrogeneralusuarioDataAccess.getTipoFuente(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(TipoTamanioControl.class)) {
				parametrogeneralusuario.setTipoTamanioControlNormal(parametrogeneralusuarioDataAccess.getTipoTamanioControlNormal(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(TipoTamanioControl.class)) {
				parametrogeneralusuario.setTipoTamanioControlRelacion(parametrogeneralusuarioDataAccess.getTipoTamanioControlRelacion(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(TipoExportar.class)) {
				parametrogeneralusuario.setTipoExportar(parametrogeneralusuarioDataAccess.getTipoExportar(connexion,parametrogeneralusuario));
				continue;
			}

			if(clas.clas.equals(TipoDelimiter.class)) {
				parametrogeneralusuario.setTipoDelimiter(parametrogeneralusuarioDataAccess.getTipoDelimiter(connexion,parametrogeneralusuario));
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
			parametrogeneralusuario.setUsuario(parametrogeneralusuarioDataAccess.getUsuario(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setEmpresa(parametrogeneralusuarioDataAccess.getEmpresa(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setSucursal(parametrogeneralusuarioDataAccess.getSucursal(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setEjercicio(parametrogeneralusuarioDataAccess.getEjercicio(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setPeriodo(parametrogeneralusuarioDataAccess.getPeriodo(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setMoneda(parametrogeneralusuarioDataAccess.getMoneda(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setAnio(parametrogeneralusuarioDataAccess.getAnio(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setMes(parametrogeneralusuarioDataAccess.getMes(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVisual.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoVisual(parametrogeneralusuarioDataAccess.getTipoVisual(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoFondo(parametrogeneralusuarioDataAccess.getTipoFondo(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoFondoBorde(parametrogeneralusuarioDataAccess.getTipoFondoBorde(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondoControl.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoFondoControl(parametrogeneralusuarioDataAccess.getTipoFondoControl(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFuente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoFuente(parametrogeneralusuarioDataAccess.getTipoFuente(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTamanioControl.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoTamanioControlNormal(parametrogeneralusuarioDataAccess.getTipoTamanioControlNormal(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTamanioControl.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoTamanioControlRelacion(parametrogeneralusuarioDataAccess.getTipoTamanioControlRelacion(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoExportar.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoExportar(parametrogeneralusuarioDataAccess.getTipoExportar(connexion,parametrogeneralusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDelimiter.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoDelimiter(parametrogeneralusuarioDataAccess.getTipoDelimiter(connexion,parametrogeneralusuario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrogeneralusuario.setUsuario(parametrogeneralusuarioDataAccess.getUsuario(connexion,parametrogeneralusuario));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(parametrogeneralusuario.getUsuario(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setEmpresa(parametrogeneralusuarioDataAccess.getEmpresa(connexion,parametrogeneralusuario));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrogeneralusuario.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setSucursal(parametrogeneralusuarioDataAccess.getSucursal(connexion,parametrogeneralusuario));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrogeneralusuario.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setEjercicio(parametrogeneralusuarioDataAccess.getEjercicio(connexion,parametrogeneralusuario));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(parametrogeneralusuario.getEjercicio(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setPeriodo(parametrogeneralusuarioDataAccess.getPeriodo(connexion,parametrogeneralusuario));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(parametrogeneralusuario.getPeriodo(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setMoneda(parametrogeneralusuarioDataAccess.getMoneda(connexion,parametrogeneralusuario));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(parametrogeneralusuario.getMoneda(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setAnio(parametrogeneralusuarioDataAccess.getAnio(connexion,parametrogeneralusuario));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(parametrogeneralusuario.getAnio(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setMes(parametrogeneralusuarioDataAccess.getMes(connexion,parametrogeneralusuario));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(parametrogeneralusuario.getMes(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setTipoVisual(parametrogeneralusuarioDataAccess.getTipoVisual(connexion,parametrogeneralusuario));
		TipoVisualLogic tipovisualLogic= new TipoVisualLogic(connexion);
		tipovisualLogic.deepLoad(parametrogeneralusuario.getTipoVisual(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setTipoFondo(parametrogeneralusuarioDataAccess.getTipoFondo(connexion,parametrogeneralusuario));
		TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
		tipofondoLogic.deepLoad(parametrogeneralusuario.getTipoFondo(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setTipoFondoBorde(parametrogeneralusuarioDataAccess.getTipoFondoBorde(connexion,parametrogeneralusuario));
		TipoFondoLogic tipofondobordeLogic= new TipoFondoLogic(connexion);
		tipofondobordeLogic.deepLoad(parametrogeneralusuario.getTipoFondoBorde(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setTipoFondoControl(parametrogeneralusuarioDataAccess.getTipoFondoControl(connexion,parametrogeneralusuario));
		TipoFondoControlLogic tipofondocontrolLogic= new TipoFondoControlLogic(connexion);
		tipofondocontrolLogic.deepLoad(parametrogeneralusuario.getTipoFondoControl(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setTipoFuente(parametrogeneralusuarioDataAccess.getTipoFuente(connexion,parametrogeneralusuario));
		TipoFuenteLogic tipofuenteLogic= new TipoFuenteLogic(connexion);
		tipofuenteLogic.deepLoad(parametrogeneralusuario.getTipoFuente(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setTipoTamanioControlNormal(parametrogeneralusuarioDataAccess.getTipoTamanioControlNormal(connexion,parametrogeneralusuario));
		TipoTamanioControlLogic tipotamaniocontrolnormalLogic= new TipoTamanioControlLogic(connexion);
		tipotamaniocontrolnormalLogic.deepLoad(parametrogeneralusuario.getTipoTamanioControlNormal(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setTipoTamanioControlRelacion(parametrogeneralusuarioDataAccess.getTipoTamanioControlRelacion(connexion,parametrogeneralusuario));
		TipoTamanioControlLogic tipotamaniocontrolrelacionLogic= new TipoTamanioControlLogic(connexion);
		tipotamaniocontrolrelacionLogic.deepLoad(parametrogeneralusuario.getTipoTamanioControlRelacion(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setTipoExportar(parametrogeneralusuarioDataAccess.getTipoExportar(connexion,parametrogeneralusuario));
		TipoExportarLogic tipoexportarLogic= new TipoExportarLogic(connexion);
		tipoexportarLogic.deepLoad(parametrogeneralusuario.getTipoExportar(),isDeep,deepLoadType,clases);
				
		parametrogeneralusuario.setTipoDelimiter(parametrogeneralusuarioDataAccess.getTipoDelimiter(connexion,parametrogeneralusuario));
		TipoDelimiterLogic tipodelimiterLogic= new TipoDelimiterLogic(connexion);
		tipodelimiterLogic.deepLoad(parametrogeneralusuario.getTipoDelimiter(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				parametrogeneralusuario.setUsuario(parametrogeneralusuarioDataAccess.getUsuario(connexion,parametrogeneralusuario));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(parametrogeneralusuario.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				parametrogeneralusuario.setEmpresa(parametrogeneralusuarioDataAccess.getEmpresa(connexion,parametrogeneralusuario));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrogeneralusuario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrogeneralusuario.setSucursal(parametrogeneralusuarioDataAccess.getSucursal(connexion,parametrogeneralusuario));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrogeneralusuario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				parametrogeneralusuario.setEjercicio(parametrogeneralusuarioDataAccess.getEjercicio(connexion,parametrogeneralusuario));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(parametrogeneralusuario.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				parametrogeneralusuario.setPeriodo(parametrogeneralusuarioDataAccess.getPeriodo(connexion,parametrogeneralusuario));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(parametrogeneralusuario.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				parametrogeneralusuario.setMoneda(parametrogeneralusuarioDataAccess.getMoneda(connexion,parametrogeneralusuario));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(parametrogeneralusuario.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				parametrogeneralusuario.setAnio(parametrogeneralusuarioDataAccess.getAnio(connexion,parametrogeneralusuario));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(parametrogeneralusuario.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				parametrogeneralusuario.setMes(parametrogeneralusuarioDataAccess.getMes(connexion,parametrogeneralusuario));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(parametrogeneralusuario.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoVisual.class)) {
				parametrogeneralusuario.setTipoVisual(parametrogeneralusuarioDataAccess.getTipoVisual(connexion,parametrogeneralusuario));
				TipoVisualLogic tipovisualLogic= new TipoVisualLogic(connexion);
				tipovisualLogic.deepLoad(parametrogeneralusuario.getTipoVisual(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFondo.class)) {
				parametrogeneralusuario.setTipoFondo(parametrogeneralusuarioDataAccess.getTipoFondo(connexion,parametrogeneralusuario));
				TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
				tipofondoLogic.deepLoad(parametrogeneralusuario.getTipoFondo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFondo.class)) {
				parametrogeneralusuario.setTipoFondoBorde(parametrogeneralusuarioDataAccess.getTipoFondoBorde(connexion,parametrogeneralusuario));
				TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
				tipofondoLogic.deepLoad(parametrogeneralusuario.getTipoFondoBorde(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFondoControl.class)) {
				parametrogeneralusuario.setTipoFondoControl(parametrogeneralusuarioDataAccess.getTipoFondoControl(connexion,parametrogeneralusuario));
				TipoFondoControlLogic tipofondocontrolLogic= new TipoFondoControlLogic(connexion);
				tipofondocontrolLogic.deepLoad(parametrogeneralusuario.getTipoFondoControl(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFuente.class)) {
				parametrogeneralusuario.setTipoFuente(parametrogeneralusuarioDataAccess.getTipoFuente(connexion,parametrogeneralusuario));
				TipoFuenteLogic tipofuenteLogic= new TipoFuenteLogic(connexion);
				tipofuenteLogic.deepLoad(parametrogeneralusuario.getTipoFuente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTamanioControl.class)) {
				parametrogeneralusuario.setTipoTamanioControlNormal(parametrogeneralusuarioDataAccess.getTipoTamanioControlNormal(connexion,parametrogeneralusuario));
				TipoTamanioControlLogic tipotamaniocontrolLogic= new TipoTamanioControlLogic(connexion);
				tipotamaniocontrolLogic.deepLoad(parametrogeneralusuario.getTipoTamanioControlNormal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTamanioControl.class)) {
				parametrogeneralusuario.setTipoTamanioControlRelacion(parametrogeneralusuarioDataAccess.getTipoTamanioControlRelacion(connexion,parametrogeneralusuario));
				TipoTamanioControlLogic tipotamaniocontrolLogic= new TipoTamanioControlLogic(connexion);
				tipotamaniocontrolLogic.deepLoad(parametrogeneralusuario.getTipoTamanioControlRelacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoExportar.class)) {
				parametrogeneralusuario.setTipoExportar(parametrogeneralusuarioDataAccess.getTipoExportar(connexion,parametrogeneralusuario));
				TipoExportarLogic tipoexportarLogic= new TipoExportarLogic(connexion);
				tipoexportarLogic.deepLoad(parametrogeneralusuario.getTipoExportar(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDelimiter.class)) {
				parametrogeneralusuario.setTipoDelimiter(parametrogeneralusuarioDataAccess.getTipoDelimiter(connexion,parametrogeneralusuario));
				TipoDelimiterLogic tipodelimiterLogic= new TipoDelimiterLogic(connexion);
				tipodelimiterLogic.deepLoad(parametrogeneralusuario.getTipoDelimiter(),isDeep,deepLoadType,clases);				
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
			parametrogeneralusuario.setUsuario(parametrogeneralusuarioDataAccess.getUsuario(connexion,parametrogeneralusuario));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(parametrogeneralusuario.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setEmpresa(parametrogeneralusuarioDataAccess.getEmpresa(connexion,parametrogeneralusuario));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrogeneralusuario.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setSucursal(parametrogeneralusuarioDataAccess.getSucursal(connexion,parametrogeneralusuario));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrogeneralusuario.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setEjercicio(parametrogeneralusuarioDataAccess.getEjercicio(connexion,parametrogeneralusuario));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(parametrogeneralusuario.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setPeriodo(parametrogeneralusuarioDataAccess.getPeriodo(connexion,parametrogeneralusuario));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(parametrogeneralusuario.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setMoneda(parametrogeneralusuarioDataAccess.getMoneda(connexion,parametrogeneralusuario));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(parametrogeneralusuario.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setAnio(parametrogeneralusuarioDataAccess.getAnio(connexion,parametrogeneralusuario));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(parametrogeneralusuario.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setMes(parametrogeneralusuarioDataAccess.getMes(connexion,parametrogeneralusuario));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(parametrogeneralusuario.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVisual.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoVisual(parametrogeneralusuarioDataAccess.getTipoVisual(connexion,parametrogeneralusuario));
			TipoVisualLogic tipovisualLogic= new TipoVisualLogic(connexion);
			tipovisualLogic.deepLoad(parametrogeneralusuario.getTipoVisual(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoFondo(parametrogeneralusuarioDataAccess.getTipoFondo(connexion,parametrogeneralusuario));
			TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
			tipofondoLogic.deepLoad(parametrogeneralusuario.getTipoFondo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoFondoBorde(parametrogeneralusuarioDataAccess.getTipoFondoBorde(connexion,parametrogeneralusuario));
			TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
			tipofondoLogic.deepLoad(parametrogeneralusuario.getTipoFondoBorde(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFondoControl.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoFondoControl(parametrogeneralusuarioDataAccess.getTipoFondoControl(connexion,parametrogeneralusuario));
			TipoFondoControlLogic tipofondocontrolLogic= new TipoFondoControlLogic(connexion);
			tipofondocontrolLogic.deepLoad(parametrogeneralusuario.getTipoFondoControl(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFuente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoFuente(parametrogeneralusuarioDataAccess.getTipoFuente(connexion,parametrogeneralusuario));
			TipoFuenteLogic tipofuenteLogic= new TipoFuenteLogic(connexion);
			tipofuenteLogic.deepLoad(parametrogeneralusuario.getTipoFuente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTamanioControl.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoTamanioControlNormal(parametrogeneralusuarioDataAccess.getTipoTamanioControlNormal(connexion,parametrogeneralusuario));
			TipoTamanioControlLogic tipotamaniocontrolLogic= new TipoTamanioControlLogic(connexion);
			tipotamaniocontrolLogic.deepLoad(parametrogeneralusuario.getTipoTamanioControlNormal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTamanioControl.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoTamanioControlRelacion(parametrogeneralusuarioDataAccess.getTipoTamanioControlRelacion(connexion,parametrogeneralusuario));
			TipoTamanioControlLogic tipotamaniocontrolLogic= new TipoTamanioControlLogic(connexion);
			tipotamaniocontrolLogic.deepLoad(parametrogeneralusuario.getTipoTamanioControlRelacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoExportar.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoExportar(parametrogeneralusuarioDataAccess.getTipoExportar(connexion,parametrogeneralusuario));
			TipoExportarLogic tipoexportarLogic= new TipoExportarLogic(connexion);
			tipoexportarLogic.deepLoad(parametrogeneralusuario.getTipoExportar(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDelimiter.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneralusuario.setTipoDelimiter(parametrogeneralusuarioDataAccess.getTipoDelimiter(connexion,parametrogeneralusuario));
			TipoDelimiterLogic tipodelimiterLogic= new TipoDelimiterLogic(connexion);
			tipodelimiterLogic.deepLoad(parametrogeneralusuario.getTipoDelimiter(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroGeneralUsuario parametrogeneralusuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroGeneralUsuarioLogicAdditional.updateParametroGeneralUsuarioToSave(parametrogeneralusuario,this.arrDatoGeneral);
			
ParametroGeneralUsuarioDataAccess.save(parametrogeneralusuario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		UsuarioDataAccess.save(parametrogeneralusuario.getUsuario(),connexion);

		EmpresaDataAccess.save(parametrogeneralusuario.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrogeneralusuario.getSucursal(),connexion);

		EjercicioDataAccess.save(parametrogeneralusuario.getEjercicio(),connexion);

		PeriodoDataAccess.save(parametrogeneralusuario.getPeriodo(),connexion);

		MonedaDataAccess.save(parametrogeneralusuario.getMoneda(),connexion);

		AnioDataAccess.save(parametrogeneralusuario.getAnio(),connexion);

		MesDataAccess.save(parametrogeneralusuario.getMes(),connexion);

		TipoVisualDataAccess.save(parametrogeneralusuario.getTipoVisual(),connexion);

		TipoFondoDataAccess.save(parametrogeneralusuario.getTipoFondo(),connexion);

		TipoFondoDataAccess.save(parametrogeneralusuario.getTipoFondoBorde(),connexion);

		TipoFondoControlDataAccess.save(parametrogeneralusuario.getTipoFondoControl(),connexion);

		TipoFuenteDataAccess.save(parametrogeneralusuario.getTipoFuente(),connexion);

		TipoTamanioControlDataAccess.save(parametrogeneralusuario.getTipoTamanioControlNormal(),connexion);

		TipoTamanioControlDataAccess.save(parametrogeneralusuario.getTipoTamanioControlRelacion(),connexion);

		TipoExportarDataAccess.save(parametrogeneralusuario.getTipoExportar(),connexion);

		TipoDelimiterDataAccess.save(parametrogeneralusuario.getTipoDelimiter(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(parametrogeneralusuario.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrogeneralusuario.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrogeneralusuario.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(parametrogeneralusuario.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(parametrogeneralusuario.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(parametrogeneralusuario.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(parametrogeneralusuario.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(parametrogeneralusuario.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoVisual.class)) {
				TipoVisualDataAccess.save(parametrogeneralusuario.getTipoVisual(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFondo.class)) {
				TipoFondoDataAccess.save(parametrogeneralusuario.getTipoFondo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFondo.class)) {
				TipoFondoDataAccess.save(parametrogeneralusuario.getTipoFondoBorde(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFondoControl.class)) {
				TipoFondoControlDataAccess.save(parametrogeneralusuario.getTipoFondoControl(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFuente.class)) {
				TipoFuenteDataAccess.save(parametrogeneralusuario.getTipoFuente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTamanioControl.class)) {
				TipoTamanioControlDataAccess.save(parametrogeneralusuario.getTipoTamanioControlNormal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTamanioControl.class)) {
				TipoTamanioControlDataAccess.save(parametrogeneralusuario.getTipoTamanioControlRelacion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoExportar.class)) {
				TipoExportarDataAccess.save(parametrogeneralusuario.getTipoExportar(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDelimiter.class)) {
				TipoDelimiterDataAccess.save(parametrogeneralusuario.getTipoDelimiter(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		UsuarioDataAccess.save(parametrogeneralusuario.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(parametrogeneralusuario.getUsuario(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(parametrogeneralusuario.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrogeneralusuario.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrogeneralusuario.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrogeneralusuario.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(parametrogeneralusuario.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(parametrogeneralusuario.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(parametrogeneralusuario.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(parametrogeneralusuario.getPeriodo(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(parametrogeneralusuario.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(parametrogeneralusuario.getMoneda(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(parametrogeneralusuario.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(parametrogeneralusuario.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(parametrogeneralusuario.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(parametrogeneralusuario.getMes(),isDeep,deepLoadType,clases);
				

		TipoVisualDataAccess.save(parametrogeneralusuario.getTipoVisual(),connexion);
		TipoVisualLogic tipovisualLogic= new TipoVisualLogic(connexion);
		tipovisualLogic.deepLoad(parametrogeneralusuario.getTipoVisual(),isDeep,deepLoadType,clases);
				

		TipoFondoDataAccess.save(parametrogeneralusuario.getTipoFondo(),connexion);
		TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
		tipofondoLogic.deepLoad(parametrogeneralusuario.getTipoFondo(),isDeep,deepLoadType,clases);
				

		TipoFondoDataAccess.save(parametrogeneralusuario.getTipoFondoBorde(),connexion);
		TipoFondoLogic tipofondobordeLogic= new TipoFondoLogic(connexion);
		tipofondobordeLogic.deepLoad(parametrogeneralusuario.getTipoFondoBorde(),isDeep,deepLoadType,clases);
				

		TipoFondoControlDataAccess.save(parametrogeneralusuario.getTipoFondoControl(),connexion);
		TipoFondoControlLogic tipofondocontrolLogic= new TipoFondoControlLogic(connexion);
		tipofondocontrolLogic.deepLoad(parametrogeneralusuario.getTipoFondoControl(),isDeep,deepLoadType,clases);
				

		TipoFuenteDataAccess.save(parametrogeneralusuario.getTipoFuente(),connexion);
		TipoFuenteLogic tipofuenteLogic= new TipoFuenteLogic(connexion);
		tipofuenteLogic.deepLoad(parametrogeneralusuario.getTipoFuente(),isDeep,deepLoadType,clases);
				

		TipoTamanioControlDataAccess.save(parametrogeneralusuario.getTipoTamanioControlNormal(),connexion);
		TipoTamanioControlLogic tipotamaniocontrolnormalLogic= new TipoTamanioControlLogic(connexion);
		tipotamaniocontrolnormalLogic.deepLoad(parametrogeneralusuario.getTipoTamanioControlNormal(),isDeep,deepLoadType,clases);
				

		TipoTamanioControlDataAccess.save(parametrogeneralusuario.getTipoTamanioControlRelacion(),connexion);
		TipoTamanioControlLogic tipotamaniocontrolrelacionLogic= new TipoTamanioControlLogic(connexion);
		tipotamaniocontrolrelacionLogic.deepLoad(parametrogeneralusuario.getTipoTamanioControlRelacion(),isDeep,deepLoadType,clases);
				

		TipoExportarDataAccess.save(parametrogeneralusuario.getTipoExportar(),connexion);
		TipoExportarLogic tipoexportarLogic= new TipoExportarLogic(connexion);
		tipoexportarLogic.deepLoad(parametrogeneralusuario.getTipoExportar(),isDeep,deepLoadType,clases);
				

		TipoDelimiterDataAccess.save(parametrogeneralusuario.getTipoDelimiter(),connexion);
		TipoDelimiterLogic tipodelimiterLogic= new TipoDelimiterLogic(connexion);
		tipodelimiterLogic.deepLoad(parametrogeneralusuario.getTipoDelimiter(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(parametrogeneralusuario.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(parametrogeneralusuario.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrogeneralusuario.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrogeneralusuario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrogeneralusuario.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrogeneralusuario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(parametrogeneralusuario.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(parametrogeneralusuario.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(parametrogeneralusuario.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(parametrogeneralusuario.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(parametrogeneralusuario.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(parametrogeneralusuario.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(parametrogeneralusuario.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(parametrogeneralusuario.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(parametrogeneralusuario.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(parametrogeneralusuario.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoVisual.class)) {
				TipoVisualDataAccess.save(parametrogeneralusuario.getTipoVisual(),connexion);
				TipoVisualLogic tipovisualLogic= new TipoVisualLogic(connexion);
				tipovisualLogic.deepSave(parametrogeneralusuario.getTipoVisual(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFondo.class)) {
				TipoFondoDataAccess.save(parametrogeneralusuario.getTipoFondo(),connexion);
				TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
				tipofondoLogic.deepSave(parametrogeneralusuario.getTipoFondo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFondo.class)) {
				TipoFondoDataAccess.save(parametrogeneralusuario.getTipoFondoBorde(),connexion);
				TipoFondoLogic tipofondoLogic= new TipoFondoLogic(connexion);
				tipofondoLogic.deepSave(parametrogeneralusuario.getTipoFondoBorde(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFondoControl.class)) {
				TipoFondoControlDataAccess.save(parametrogeneralusuario.getTipoFondoControl(),connexion);
				TipoFondoControlLogic tipofondocontrolLogic= new TipoFondoControlLogic(connexion);
				tipofondocontrolLogic.deepSave(parametrogeneralusuario.getTipoFondoControl(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFuente.class)) {
				TipoFuenteDataAccess.save(parametrogeneralusuario.getTipoFuente(),connexion);
				TipoFuenteLogic tipofuenteLogic= new TipoFuenteLogic(connexion);
				tipofuenteLogic.deepSave(parametrogeneralusuario.getTipoFuente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTamanioControl.class)) {
				TipoTamanioControlDataAccess.save(parametrogeneralusuario.getTipoTamanioControlNormal(),connexion);
				TipoTamanioControlLogic tipotamaniocontrolLogic= new TipoTamanioControlLogic(connexion);
				tipotamaniocontrolLogic.deepSave(parametrogeneralusuario.getTipoTamanioControlNormal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTamanioControl.class)) {
				TipoTamanioControlDataAccess.save(parametrogeneralusuario.getTipoTamanioControlRelacion(),connexion);
				TipoTamanioControlLogic tipotamaniocontrolLogic= new TipoTamanioControlLogic(connexion);
				tipotamaniocontrolLogic.deepSave(parametrogeneralusuario.getTipoTamanioControlRelacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoExportar.class)) {
				TipoExportarDataAccess.save(parametrogeneralusuario.getTipoExportar(),connexion);
				TipoExportarLogic tipoexportarLogic= new TipoExportarLogic(connexion);
				tipoexportarLogic.deepSave(parametrogeneralusuario.getTipoExportar(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDelimiter.class)) {
				TipoDelimiterDataAccess.save(parametrogeneralusuario.getTipoDelimiter(),connexion);
				TipoDelimiterLogic tipodelimiterLogic= new TipoDelimiterLogic(connexion);
				tipodelimiterLogic.deepSave(parametrogeneralusuario.getTipoDelimiter(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroGeneralUsuario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrogeneralusuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(parametrogeneralusuario);
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
			this.deepLoad(this.parametrogeneralusuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroGeneralUsuario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrogeneralusuarios!=null) {
				for(ParametroGeneralUsuario parametrogeneralusuario:parametrogeneralusuarios) {
					this.deepLoad(parametrogeneralusuario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(parametrogeneralusuarios);
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
			if(parametrogeneralusuarios!=null) {
				for(ParametroGeneralUsuario parametrogeneralusuario:parametrogeneralusuarios) {
					this.deepLoad(parametrogeneralusuario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(parametrogeneralusuarios);
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
			this.getNewConnexionToDeep(ParametroGeneralUsuario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrogeneralusuario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroGeneralUsuario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrogeneralusuarios!=null) {
				for(ParametroGeneralUsuario parametrogeneralusuario:parametrogeneralusuarios) {
					this.deepSave(parametrogeneralusuario,isDeep,deepLoadType,clases);
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
			if(parametrogeneralusuarios!=null) {
				for(ParametroGeneralUsuario parametrogeneralusuario:parametrogeneralusuarios) {
					this.deepSave(parametrogeneralusuario,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroGeneralUsuariosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ParametroGeneralUsuarioConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ParametroGeneralUsuarioConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ParametroGeneralUsuarioConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ParametroGeneralUsuarioConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ParametroGeneralUsuarioConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ParametroGeneralUsuarioConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ParametroGeneralUsuarioConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ParametroGeneralUsuarioConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoDelimiterWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_delimiter)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDelimiter= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDelimiter.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_delimiter,ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDelimiter);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDelimiter","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoDelimiter(String sFinalQuery,Pagination pagination,Long id_tipo_delimiter)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDelimiter= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDelimiter.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_delimiter,ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDelimiter);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDelimiter","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoExportarWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_exportar)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoExportar= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoExportar.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_exportar,ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoExportar);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoExportar","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoExportar(String sFinalQuery,Pagination pagination,Long id_tipo_exportar)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoExportar= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoExportar.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_exportar,ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoExportar);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoExportar","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoFondoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_fondo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFondo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFondo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_fondo,ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFondo);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFondo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoFondo(String sFinalQuery,Pagination pagination,Long id_tipo_fondo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFondo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFondo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_fondo,ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFondo);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFondo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoFondoBordeWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_fondo_borde)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFondoBorde= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFondoBorde.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_fondo_borde,ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFondoBorde);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFondoBorde","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoFondoBorde(String sFinalQuery,Pagination pagination,Long id_tipo_fondo_borde)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFondoBorde= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFondoBorde.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_fondo_borde,ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFondoBorde);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFondoBorde","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoFondoControlWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_fondo_control)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFondoControl= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFondoControl.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_fondo_control,ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFondoControl);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFondoControl","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoFondoControl(String sFinalQuery,Pagination pagination,Long id_tipo_fondo_control)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFondoControl= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFondoControl.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_fondo_control,ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFondoControl);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFondoControl","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoFuenteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_fuente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFuente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFuente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_fuente,ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFuente);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFuente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoFuente(String sFinalQuery,Pagination pagination,Long id_tipo_fuente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFuente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFuente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_fuente,ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFuente);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFuente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoTamanioControlNormalWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_tamanio_control_normal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTamanioControlNormal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTamanioControlNormal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tamanio_control_normal,ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTamanioControlNormal);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTamanioControlNormal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoTamanioControlNormal(String sFinalQuery,Pagination pagination,Long id_tipo_tamanio_control_normal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTamanioControlNormal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTamanioControlNormal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tamanio_control_normal,ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTamanioControlNormal);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTamanioControlNormal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoTamanioControlRelacionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_tamanio_control_relacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTamanioControlRelacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTamanioControlRelacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tamanio_control_relacion,ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTamanioControlRelacion);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTamanioControlRelacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoTamanioControlRelacion(String sFinalQuery,Pagination pagination,Long id_tipo_tamanio_control_relacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTamanioControlRelacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTamanioControlRelacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tamanio_control_relacion,ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTamanioControlRelacion);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTamanioControlRelacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoVisualWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_visual)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoVisual= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoVisual.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_visual,ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoVisual);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoVisual","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdTipoVisual(String sFinalQuery,Pagination pagination,Long id_tipo_visual)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoVisual= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoVisual.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_visual,ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoVisual);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoVisual","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralUsuariosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ParametroGeneralUsuarioConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralUsuariosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ParametroGeneralUsuarioConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParametroGeneralUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogeneralusuarios=parametrogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(this.parametrogeneralusuarios);
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
			if(ParametroGeneralUsuarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralUsuarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroGeneralUsuario parametrogeneralusuario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroGeneralUsuarioConstantesFunciones.ISCONAUDITORIA) {
				if(parametrogeneralusuario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralUsuarioDataAccess.TABLENAME, parametrogeneralusuario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroGeneralUsuarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroGeneralUsuarioLogic.registrarAuditoriaDetallesParametroGeneralUsuario(connexion,parametrogeneralusuario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrogeneralusuario.getIsDeleted()) {
					/*if(!parametrogeneralusuario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroGeneralUsuarioDataAccess.TABLENAME, parametrogeneralusuario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroGeneralUsuarioLogic.registrarAuditoriaDetallesParametroGeneralUsuario(connexion,parametrogeneralusuario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralUsuarioDataAccess.TABLENAME, parametrogeneralusuario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrogeneralusuario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralUsuarioDataAccess.TABLENAME, parametrogeneralusuario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroGeneralUsuarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroGeneralUsuarioLogic.registrarAuditoriaDetallesParametroGeneralUsuario(connexion,parametrogeneralusuario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroGeneralUsuario(Connexion connexion,ParametroGeneralUsuario parametrogeneralusuario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_empresa().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_empresa().toString();
				}
				if(parametrogeneralusuario.getid_empresa()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_sucursal().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_sucursal().toString();
				}
				if(parametrogeneralusuario.getid_sucursal()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_ejercicio().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_ejercicio()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_ejercicio().toString();
				}
				if(parametrogeneralusuario.getid_ejercicio()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_periodo().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_periodo()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_periodo().toString();
				}
				if(parametrogeneralusuario.getid_periodo()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_moneda().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_moneda()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_moneda().toString();
				}
				if(parametrogeneralusuario.getid_moneda()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getfecha_sistema().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getfecha_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getfecha_sistema()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getfecha_sistema().toString();
				}
				if(parametrogeneralusuario.getfecha_sistema()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getfecha_sistema().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.FECHASISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_anio().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_anio()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_anio().toString();
				}
				if(parametrogeneralusuario.getid_anio()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_mes().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_mes()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_mes().toString();
				}
				if(parametrogeneralusuario.getid_mes()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getdia().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getdia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getdia()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getdia().toString();
				}
				if(parametrogeneralusuario.getdia()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getdia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.DIA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_tipo_visual().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_visual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_visual()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_visual().toString();
				}
				if(parametrogeneralusuario.getid_tipo_visual()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_tipo_visual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_tipo_fondo().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fondo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fondo()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fondo().toString();
				}
				if(parametrogeneralusuario.getid_tipo_fondo()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_tipo_fondo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_tipo_fondo_borde().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fondo_borde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fondo_borde()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fondo_borde().toString();
				}
				if(parametrogeneralusuario.getid_tipo_fondo_borde()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_tipo_fondo_borde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_tipo_fondo_control().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fondo_control()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fondo_control()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fondo_control().toString();
				}
				if(parametrogeneralusuario.getid_tipo_fondo_control()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_tipo_fondo_control().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_tipo_fuente().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fuente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fuente()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_fuente().toString();
				}
				if(parametrogeneralusuario.getid_tipo_fuente()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_tipo_fuente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_tipo_tamanio_control_normal().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_tamanio_control_normal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_tamanio_control_normal()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_tamanio_control_normal().toString();
				}
				if(parametrogeneralusuario.getid_tipo_tamanio_control_normal()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_tipo_tamanio_control_normal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_tipo_tamanio_control_relacion().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_tamanio_control_relacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_tamanio_control_relacion()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_tamanio_control_relacion().toString();
				}
				if(parametrogeneralusuario.getid_tipo_tamanio_control_relacion()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_tipo_tamanio_control_relacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_tamanio_control_manual().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_tamanio_control_manual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_tamanio_control_manual()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_tamanio_control_manual().toString();
				}
				if(parametrogeneralusuario.getcon_tamanio_control_manual()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_tamanio_control_manual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLMANUAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_tamanio_control_todo_relacion().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_tamanio_control_todo_relacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_tamanio_control_todo_relacion()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_tamanio_control_todo_relacion().toString();
				}
				if(parametrogeneralusuario.getcon_tamanio_control_todo_relacion()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_tamanio_control_todo_relacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLTODORELACION,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_guardar_relaciones().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_guardar_relaciones()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_guardar_relaciones()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_guardar_relaciones().toString();
				}
				if(parametrogeneralusuario.getcon_guardar_relaciones()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_guardar_relaciones().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONGUARDARRELACIONES,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_mensaje_confirmacion().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_mensaje_confirmacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_mensaje_confirmacion()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_mensaje_confirmacion().toString();
				}
				if(parametrogeneralusuario.getcon_mensaje_confirmacion()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_mensaje_confirmacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONMENSAJECONFIRMACION,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_botones_tool_bar().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_botones_tool_bar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_botones_tool_bar()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_botones_tool_bar().toString();
				}
				if(parametrogeneralusuario.getcon_botones_tool_bar()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_botones_tool_bar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONBOTONESTOOLBAR,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_mostrar_acciones_campo_general().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_mostrar_acciones_campo_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_mostrar_acciones_campo_general()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_mostrar_acciones_campo_general().toString();
				}
				if(parametrogeneralusuario.getcon_mostrar_acciones_campo_general()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_mostrar_acciones_campo_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPOGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_mostrar_acciones_campo_relaciones().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_mostrar_acciones_campo_relaciones()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_mostrar_acciones_campo_relaciones()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_mostrar_acciones_campo_relaciones().toString();
				}
				if(parametrogeneralusuario.getcon_mostrar_acciones_campo_relaciones()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_mostrar_acciones_campo_relaciones().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPORELACIONES,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_tipo_exportar().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_exportar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_exportar()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_exportar().toString();
				}
				if(parametrogeneralusuario.getid_tipo_exportar()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_tipo_exportar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getid_tipo_delimiter().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_delimiter()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_delimiter()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getid_tipo_delimiter().toString();
				}
				if(parametrogeneralusuario.getid_tipo_delimiter()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getid_tipo_delimiter().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_exportar_cabecera().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_exportar_cabecera()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_exportar_cabecera()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_exportar_cabecera().toString();
				}
				if(parametrogeneralusuario.getcon_exportar_cabecera()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_exportar_cabecera().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCABECERA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_exportar_campo_version().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_exportar_campo_version()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_exportar_campo_version()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_exportar_campo_version().toString();
				}
				if(parametrogeneralusuario.getcon_exportar_campo_version()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_exportar_campo_version().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCAMPOVERSION,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getpath_exportar().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getpath_exportar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getpath_exportar()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getpath_exportar();
				}
				if(parametrogeneralusuario.getpath_exportar()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getpath_exportar() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.PATHEXPORTAR,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_precargar_ventanas().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_precargar_ventanas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_precargar_ventanas()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_precargar_ventanas().toString();
				}
				if(parametrogeneralusuario.getcon_precargar_ventanas()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_precargar_ventanas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARVENTANAS,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_precargar_por_usuario().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_precargar_por_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_precargar_por_usuario()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_precargar_por_usuario().toString();
				}
				if(parametrogeneralusuario.getcon_precargar_por_usuario()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_precargar_por_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARPORUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralusuario.getIsNew()||!parametrogeneralusuario.getcon_cargar_por_parte().equals(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_cargar_por_parte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_cargar_por_parte()!=null)
				{
					strValorActual=parametrogeneralusuario.getParametroGeneralUsuarioOriginal().getcon_cargar_por_parte().toString();
				}
				if(parametrogeneralusuario.getcon_cargar_por_parte()!=null)
				{
					strValorNuevo=parametrogeneralusuario.getcon_cargar_por_parte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralUsuarioConstantesFunciones.CONCARGARPORPARTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroGeneralUsuarioRelacionesWithConnection(ParametroGeneralUsuario parametrogeneralusuario) throws Exception {

		if(!parametrogeneralusuario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroGeneralUsuarioRelacionesBase(parametrogeneralusuario,true);
		}
	}

	public void saveParametroGeneralUsuarioRelaciones(ParametroGeneralUsuario parametrogeneralusuario)throws Exception {

		if(!parametrogeneralusuario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroGeneralUsuarioRelacionesBase(parametrogeneralusuario,false);
		}
	}

	public void saveParametroGeneralUsuarioRelacionesBase(ParametroGeneralUsuario parametrogeneralusuario,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroGeneralUsuario-saveRelacionesWithConnection");}
	

			this.setParametroGeneralUsuario(parametrogeneralusuario);

				if((parametrogeneralusuario.getIsNew()||parametrogeneralusuario.getIsChanged())&&!parametrogeneralusuario.getIsDeleted()) {
					this.saveParametroGeneralUsuario();
					this.saveParametroGeneralUsuarioRelacionesDetalles();

				} else if(parametrogeneralusuario.getIsDeleted()) {
					this.saveParametroGeneralUsuarioRelacionesDetalles();
					this.saveParametroGeneralUsuario();
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
	
	
	private void saveParametroGeneralUsuarioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroGeneralUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroGeneralUsuarioConstantesFunciones.getClassesForeignKeysOfParametroGeneralUsuario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGeneralUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroGeneralUsuarioConstantesFunciones.getClassesRelationshipsOfParametroGeneralUsuario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

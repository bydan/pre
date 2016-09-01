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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.SecuencialUsuarioConstantesFunciones;
import com.bydan.erp.facturacion.util.SecuencialUsuarioParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.SecuencialUsuarioParameterGeneral;
import com.bydan.erp.facturacion.business.entity.SecuencialUsuario;
import com.bydan.erp.facturacion.business.logic.SecuencialUsuarioLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class SecuencialUsuarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SecuencialUsuarioLogic.class);
	
	protected SecuencialUsuarioDataAccess secuencialusuarioDataAccess; 	
	protected SecuencialUsuario secuencialusuario;
	protected List<SecuencialUsuario> secuencialusuarios;
	protected Object secuencialusuarioObject;	
	protected List<Object> secuencialusuariosObject;
	
	public static ClassValidator<SecuencialUsuario> secuencialusuarioValidator = new ClassValidator<SecuencialUsuario>(SecuencialUsuario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SecuencialUsuarioLogicAdditional secuencialusuarioLogicAdditional=null;
	
	public SecuencialUsuarioLogicAdditional getSecuencialUsuarioLogicAdditional() {
		return this.secuencialusuarioLogicAdditional;
	}
	
	public void setSecuencialUsuarioLogicAdditional(SecuencialUsuarioLogicAdditional secuencialusuarioLogicAdditional) {
		try {
			this.secuencialusuarioLogicAdditional=secuencialusuarioLogicAdditional;
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
	
	
	
	
	public  SecuencialUsuarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.secuencialusuarioDataAccess = new SecuencialUsuarioDataAccess();
			
			this.secuencialusuarios= new ArrayList<SecuencialUsuario>();
			this.secuencialusuario= new SecuencialUsuario();
			
			this.secuencialusuarioObject=new Object();
			this.secuencialusuariosObject=new ArrayList<Object>();
				
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
			
			this.secuencialusuarioDataAccess.setConnexionType(this.connexionType);
			this.secuencialusuarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SecuencialUsuarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.secuencialusuarioDataAccess = new SecuencialUsuarioDataAccess();
			this.secuencialusuarios= new ArrayList<SecuencialUsuario>();
			this.secuencialusuario= new SecuencialUsuario();
			this.secuencialusuarioObject=new Object();
			this.secuencialusuariosObject=new ArrayList<Object>();
			
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
			
			this.secuencialusuarioDataAccess.setConnexionType(this.connexionType);
			this.secuencialusuarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SecuencialUsuario getSecuencialUsuario() throws Exception {	
		SecuencialUsuarioLogicAdditional.checkSecuencialUsuarioToGet(secuencialusuario,this.datosCliente,this.arrDatoGeneral);
		SecuencialUsuarioLogicAdditional.updateSecuencialUsuarioToGet(secuencialusuario,this.arrDatoGeneral);
		
		return secuencialusuario;
	}
		
	public void setSecuencialUsuario(SecuencialUsuario newSecuencialUsuario) {
		this.secuencialusuario = newSecuencialUsuario;
	}
	
	public SecuencialUsuarioDataAccess getSecuencialUsuarioDataAccess() {
		return secuencialusuarioDataAccess;
	}
	
	public void setSecuencialUsuarioDataAccess(SecuencialUsuarioDataAccess newsecuencialusuarioDataAccess) {
		this.secuencialusuarioDataAccess = newsecuencialusuarioDataAccess;
	}
	
	public List<SecuencialUsuario> getSecuencialUsuarios() throws Exception {		
		this.quitarSecuencialUsuariosNulos();
		
		SecuencialUsuarioLogicAdditional.checkSecuencialUsuarioToGets(secuencialusuarios,this.datosCliente,this.arrDatoGeneral);
		
		for (SecuencialUsuario secuencialusuarioLocal: secuencialusuarios ) {
			SecuencialUsuarioLogicAdditional.updateSecuencialUsuarioToGet(secuencialusuarioLocal,this.arrDatoGeneral);
		}
		
		return secuencialusuarios;
	}
	
	public void setSecuencialUsuarios(List<SecuencialUsuario> newSecuencialUsuarios) {
		this.secuencialusuarios = newSecuencialUsuarios;
	}
	
	public Object getSecuencialUsuarioObject() {	
		this.secuencialusuarioObject=this.secuencialusuarioDataAccess.getEntityObject();
		return this.secuencialusuarioObject;
	}
		
	public void setSecuencialUsuarioObject(Object newSecuencialUsuarioObject) {
		this.secuencialusuarioObject = newSecuencialUsuarioObject;
	}
	
	public List<Object> getSecuencialUsuariosObject() {		
		this.secuencialusuariosObject=this.secuencialusuarioDataAccess.getEntitiesObject();
		return this.secuencialusuariosObject;
	}
		
	public void setSecuencialUsuariosObject(List<Object> newSecuencialUsuariosObject) {
		this.secuencialusuariosObject = newSecuencialUsuariosObject;
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
		
		if(this.secuencialusuarioDataAccess!=null) {
			this.secuencialusuarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			secuencialusuarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			secuencialusuarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		secuencialusuario = new  SecuencialUsuario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			secuencialusuario=secuencialusuarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.secuencialusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuario);
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
		secuencialusuario = new  SecuencialUsuario();
		  		  
        try {
			
			secuencialusuario=secuencialusuarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.secuencialusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		secuencialusuario = new  SecuencialUsuario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			secuencialusuario=secuencialusuarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.secuencialusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuario);
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
		secuencialusuario = new  SecuencialUsuario();
		  		  
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
		secuencialusuario = new  SecuencialUsuario();
		  		  
        try {
			
			secuencialusuario=secuencialusuarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.secuencialusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		secuencialusuario = new  SecuencialUsuario();
		  		  
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
		secuencialusuario = new  SecuencialUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =secuencialusuarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		secuencialusuario = new  SecuencialUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=secuencialusuarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		secuencialusuario = new  SecuencialUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =secuencialusuarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		secuencialusuario = new  SecuencialUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=secuencialusuarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		secuencialusuario = new  SecuencialUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =secuencialusuarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		secuencialusuario = new  SecuencialUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=secuencialusuarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
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
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		  		  
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
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		  		  
        try {			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSecuencialUsuario(secuencialusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		  		  
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
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
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
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		  		  
        try {
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
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
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
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
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		secuencialusuario = new  SecuencialUsuario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuario=secuencialusuarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuario);
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
		secuencialusuario = new  SecuencialUsuario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuario=secuencialusuarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuarios=secuencialusuarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
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
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		  		  
        try {
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuarios=secuencialusuarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSecuencialUsuariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getTodosSecuencialUsuariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
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
	
	public  void  getTodosSecuencialUsuarios(String sFinalQuery,Pagination pagination)throws Exception {
		secuencialusuarios = new  ArrayList<SecuencialUsuario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSecuencialUsuario(secuencialusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSecuencialUsuario(SecuencialUsuario secuencialusuario) throws Exception {
		Boolean estaValidado=false;
		
		if(secuencialusuario.getIsNew() || secuencialusuario.getIsChanged()) { 
			this.invalidValues = secuencialusuarioValidator.getInvalidValues(secuencialusuario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(secuencialusuario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSecuencialUsuario(List<SecuencialUsuario> SecuencialUsuarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SecuencialUsuario secuencialusuarioLocal:secuencialusuarios) {				
			estaValidadoObjeto=this.validarGuardarSecuencialUsuario(secuencialusuarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSecuencialUsuario(List<SecuencialUsuario> SecuencialUsuarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSecuencialUsuario(secuencialusuarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSecuencialUsuario(SecuencialUsuario SecuencialUsuario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSecuencialUsuario(secuencialusuario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SecuencialUsuario secuencialusuario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+secuencialusuario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SecuencialUsuarioConstantesFunciones.getSecuencialUsuarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"secuencialusuario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SecuencialUsuarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SecuencialUsuarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSecuencialUsuarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-saveSecuencialUsuarioWithConnection");connexion.begin();			
			
			SecuencialUsuarioLogicAdditional.checkSecuencialUsuarioToSave(this.secuencialusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SecuencialUsuarioLogicAdditional.updateSecuencialUsuarioToSave(this.secuencialusuario,this.arrDatoGeneral);
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.secuencialusuario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSecuencialUsuario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSecuencialUsuario(this.secuencialusuario)) {
				SecuencialUsuarioDataAccess.save(this.secuencialusuario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.secuencialusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SecuencialUsuarioLogicAdditional.checkSecuencialUsuarioToSaveAfter(this.secuencialusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSecuencialUsuario();
			
			connexion.commit();			
			
			if(this.secuencialusuario.getIsDeleted()) {
				this.secuencialusuario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSecuencialUsuario()throws Exception {	
		try {	
			
			SecuencialUsuarioLogicAdditional.checkSecuencialUsuarioToSave(this.secuencialusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SecuencialUsuarioLogicAdditional.updateSecuencialUsuarioToSave(this.secuencialusuario,this.arrDatoGeneral);
			
			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.secuencialusuario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSecuencialUsuario(this.secuencialusuario)) {			
				SecuencialUsuarioDataAccess.save(this.secuencialusuario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.secuencialusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SecuencialUsuarioLogicAdditional.checkSecuencialUsuarioToSaveAfter(this.secuencialusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.secuencialusuario.getIsDeleted()) {
				this.secuencialusuario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSecuencialUsuariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-saveSecuencialUsuariosWithConnection");connexion.begin();			
			
			SecuencialUsuarioLogicAdditional.checkSecuencialUsuarioToSaves(secuencialusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSecuencialUsuarios();
			
			Boolean validadoTodosSecuencialUsuario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SecuencialUsuario secuencialusuarioLocal:secuencialusuarios) {		
				if(secuencialusuarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SecuencialUsuarioLogicAdditional.updateSecuencialUsuarioToSave(secuencialusuarioLocal,this.arrDatoGeneral);
	        	
				SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),secuencialusuarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSecuencialUsuario(secuencialusuarioLocal)) {
					SecuencialUsuarioDataAccess.save(secuencialusuarioLocal, connexion);				
				} else {
					validadoTodosSecuencialUsuario=false;
				}
			}
			
			if(!validadoTodosSecuencialUsuario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SecuencialUsuarioLogicAdditional.checkSecuencialUsuarioToSavesAfter(secuencialusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSecuencialUsuarios();
			
			connexion.commit();		
			
			this.quitarSecuencialUsuariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSecuencialUsuarios()throws Exception {				
		 try {	
			SecuencialUsuarioLogicAdditional.checkSecuencialUsuarioToSaves(secuencialusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSecuencialUsuario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SecuencialUsuario secuencialusuarioLocal:secuencialusuarios) {				
				if(secuencialusuarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SecuencialUsuarioLogicAdditional.updateSecuencialUsuarioToSave(secuencialusuarioLocal,this.arrDatoGeneral);
	        	
				SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),secuencialusuarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSecuencialUsuario(secuencialusuarioLocal)) {				
					SecuencialUsuarioDataAccess.save(secuencialusuarioLocal, connexion);				
				} else {
					validadoTodosSecuencialUsuario=false;
				}
			}
			
			if(!validadoTodosSecuencialUsuario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SecuencialUsuarioLogicAdditional.checkSecuencialUsuarioToSavesAfter(secuencialusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSecuencialUsuariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SecuencialUsuarioParameterReturnGeneral procesarAccionSecuencialUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SecuencialUsuario> secuencialusuarios,SecuencialUsuarioParameterReturnGeneral secuencialusuarioParameterGeneral)throws Exception {
		 try {	
			SecuencialUsuarioParameterReturnGeneral secuencialusuarioReturnGeneral=new SecuencialUsuarioParameterReturnGeneral();
	
			SecuencialUsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,secuencialusuarios,secuencialusuarioParameterGeneral,secuencialusuarioReturnGeneral);
			
			return secuencialusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SecuencialUsuarioParameterReturnGeneral procesarAccionSecuencialUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SecuencialUsuario> secuencialusuarios,SecuencialUsuarioParameterReturnGeneral secuencialusuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-procesarAccionSecuencialUsuariosWithConnection");connexion.begin();			
			
			SecuencialUsuarioParameterReturnGeneral secuencialusuarioReturnGeneral=new SecuencialUsuarioParameterReturnGeneral();
	
			SecuencialUsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,secuencialusuarios,secuencialusuarioParameterGeneral,secuencialusuarioReturnGeneral);
			
			this.connexion.commit();
			
			return secuencialusuarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SecuencialUsuarioParameterReturnGeneral procesarEventosSecuencialUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SecuencialUsuario> secuencialusuarios,SecuencialUsuario secuencialusuario,SecuencialUsuarioParameterReturnGeneral secuencialusuarioParameterGeneral,Boolean isEsNuevoSecuencialUsuario,ArrayList<Classe> clases)throws Exception {
		 try {	
			SecuencialUsuarioParameterReturnGeneral secuencialusuarioReturnGeneral=new SecuencialUsuarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				secuencialusuarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SecuencialUsuarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,secuencialusuarios,secuencialusuario,secuencialusuarioParameterGeneral,secuencialusuarioReturnGeneral,isEsNuevoSecuencialUsuario,clases);
			
			return secuencialusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SecuencialUsuarioParameterReturnGeneral procesarEventosSecuencialUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SecuencialUsuario> secuencialusuarios,SecuencialUsuario secuencialusuario,SecuencialUsuarioParameterReturnGeneral secuencialusuarioParameterGeneral,Boolean isEsNuevoSecuencialUsuario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-procesarEventosSecuencialUsuariosWithConnection");connexion.begin();			
			
			SecuencialUsuarioParameterReturnGeneral secuencialusuarioReturnGeneral=new SecuencialUsuarioParameterReturnGeneral();
	
			secuencialusuarioReturnGeneral.setSecuencialUsuario(secuencialusuario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				secuencialusuarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SecuencialUsuarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,secuencialusuarios,secuencialusuario,secuencialusuarioParameterGeneral,secuencialusuarioReturnGeneral,isEsNuevoSecuencialUsuario,clases);
			
			this.connexion.commit();
			
			return secuencialusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SecuencialUsuarioParameterReturnGeneral procesarImportacionSecuencialUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SecuencialUsuarioParameterReturnGeneral secuencialusuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-procesarImportacionSecuencialUsuariosWithConnection");connexion.begin();			
			
			SecuencialUsuarioParameterReturnGeneral secuencialusuarioReturnGeneral=new SecuencialUsuarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.secuencialusuarios=new ArrayList<SecuencialUsuario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.secuencialusuario=new SecuencialUsuario();
				
				
				if(conColumnasBase) {this.secuencialusuario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.secuencialusuario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.secuencialusuario.setserie(arrColumnas[iColumn++]);
				this.secuencialusuario.setautorizacion(arrColumnas[iColumn++]);
				this.secuencialusuario.setsecuencial(arrColumnas[iColumn++]);
				this.secuencialusuario.setdigitos(Integer.parseInt(arrColumnas[iColumn++]));
				this.secuencialusuario.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.secuencialusuario.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.secuencialusuario.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.secuencialusuarios.add(this.secuencialusuario);
			}
			
			this.saveSecuencialUsuarios();
			
			this.connexion.commit();
			
			secuencialusuarioReturnGeneral.setConRetornoEstaProcesado(true);
			secuencialusuarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return secuencialusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSecuencialUsuariosEliminados() throws Exception {				
		
		List<SecuencialUsuario> secuencialusuariosAux= new ArrayList<SecuencialUsuario>();
		
		for(SecuencialUsuario secuencialusuario:secuencialusuarios) {
			if(!secuencialusuario.getIsDeleted()) {
				secuencialusuariosAux.add(secuencialusuario);
			}
		}
		
		secuencialusuarios=secuencialusuariosAux;
	}
	
	public void quitarSecuencialUsuariosNulos() throws Exception {				
		
		List<SecuencialUsuario> secuencialusuariosAux= new ArrayList<SecuencialUsuario>();
		
		for(SecuencialUsuario secuencialusuario : this.secuencialusuarios) {
			if(secuencialusuario==null) {
				secuencialusuariosAux.add(secuencialusuario);
			}
		}
		
		//this.secuencialusuarios=secuencialusuariosAux;
		
		this.secuencialusuarios.removeAll(secuencialusuariosAux);
	}
	
	public void getSetVersionRowSecuencialUsuarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(secuencialusuario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((secuencialusuario.getIsDeleted() || (secuencialusuario.getIsChanged()&&!secuencialusuario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=secuencialusuarioDataAccess.getSetVersionRowSecuencialUsuario(connexion,secuencialusuario.getId());
				
				if(!secuencialusuario.getVersionRow().equals(timestamp)) {	
					secuencialusuario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				secuencialusuario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSecuencialUsuario()throws Exception {	
		
		if(secuencialusuario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((secuencialusuario.getIsDeleted() || (secuencialusuario.getIsChanged()&&!secuencialusuario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=secuencialusuarioDataAccess.getSetVersionRowSecuencialUsuario(connexion,secuencialusuario.getId());
			
			try {							
				if(!secuencialusuario.getVersionRow().equals(timestamp)) {	
					secuencialusuario.setVersionRow(timestamp);
				}
				
				secuencialusuario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSecuencialUsuariosWithConnection()throws Exception {	
		if(secuencialusuarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SecuencialUsuario secuencialusuarioAux:secuencialusuarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(secuencialusuarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(secuencialusuarioAux.getIsDeleted() || (secuencialusuarioAux.getIsChanged()&&!secuencialusuarioAux.getIsNew())) {
						
						timestamp=secuencialusuarioDataAccess.getSetVersionRowSecuencialUsuario(connexion,secuencialusuarioAux.getId());
						
						if(!secuencialusuario.getVersionRow().equals(timestamp)) {	
							secuencialusuarioAux.setVersionRow(timestamp);
						}
								
						secuencialusuarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSecuencialUsuarios()throws Exception {	
		if(secuencialusuarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SecuencialUsuario secuencialusuarioAux:secuencialusuarios) {
					if(secuencialusuarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(secuencialusuarioAux.getIsDeleted() || (secuencialusuarioAux.getIsChanged()&&!secuencialusuarioAux.getIsNew())) {
						
						timestamp=secuencialusuarioDataAccess.getSetVersionRowSecuencialUsuario(connexion,secuencialusuarioAux.getId());
						
						if(!secuencialusuarioAux.getVersionRow().equals(timestamp)) {	
							secuencialusuarioAux.setVersionRow(timestamp);
						}
						
													
						secuencialusuarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SecuencialUsuarioParameterReturnGeneral cargarCombosLoteForeignKeySecuencialUsuarioWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalTipoDocumentoGeneral) throws Exception {
		SecuencialUsuarioParameterReturnGeneral  secuencialusuarioReturnGeneral =new SecuencialUsuarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-cargarCombosLoteForeignKeySecuencialUsuarioWithConnection");connexion.begin();
			
			secuencialusuarioReturnGeneral =new SecuencialUsuarioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			secuencialusuarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			secuencialusuarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			secuencialusuarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic=new TipoDocumentoGeneralLogic();
			tipodocumentogeneralLogic.setConnexion(this.connexion);
			tipodocumentogeneralLogic.getTipoDocumentoGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoGeneral.equals("NONE")) {
				tipodocumentogeneralLogic.getTodosTipoDocumentoGenerals(finalQueryGlobalTipoDocumentoGeneral,new Pagination());
				tipodocumentogeneralsForeignKey=tipodocumentogeneralLogic.getTipoDocumentoGenerals();
			}

			secuencialusuarioReturnGeneral.settipodocumentogeneralsForeignKey(tipodocumentogeneralsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return secuencialusuarioReturnGeneral;
	}
	
	public SecuencialUsuarioParameterReturnGeneral cargarCombosLoteForeignKeySecuencialUsuario(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalTipoDocumentoGeneral) throws Exception {
		SecuencialUsuarioParameterReturnGeneral  secuencialusuarioReturnGeneral =new SecuencialUsuarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			secuencialusuarioReturnGeneral =new SecuencialUsuarioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			secuencialusuarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			secuencialusuarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			secuencialusuarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic=new TipoDocumentoGeneralLogic();
			tipodocumentogeneralLogic.setConnexion(this.connexion);
			tipodocumentogeneralLogic.getTipoDocumentoGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoGeneral.equals("NONE")) {
				tipodocumentogeneralLogic.getTodosTipoDocumentoGenerals(finalQueryGlobalTipoDocumentoGeneral,new Pagination());
				tipodocumentogeneralsForeignKey=tipodocumentogeneralLogic.getTipoDocumentoGenerals();
			}

			secuencialusuarioReturnGeneral.settipodocumentogeneralsForeignKey(tipodocumentogeneralsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return secuencialusuarioReturnGeneral;
	}
	
	
	public void deepLoad(SecuencialUsuario secuencialusuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SecuencialUsuarioLogicAdditional.updateSecuencialUsuarioToGet(secuencialusuario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		secuencialusuario.setEmpresa(secuencialusuarioDataAccess.getEmpresa(connexion,secuencialusuario));
		secuencialusuario.setSucursal(secuencialusuarioDataAccess.getSucursal(connexion,secuencialusuario));
		secuencialusuario.setUsuario(secuencialusuarioDataAccess.getUsuario(connexion,secuencialusuario));
		secuencialusuario.setTipoDocumentoGeneral(secuencialusuarioDataAccess.getTipoDocumentoGeneral(connexion,secuencialusuario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				secuencialusuario.setEmpresa(secuencialusuarioDataAccess.getEmpresa(connexion,secuencialusuario));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				secuencialusuario.setSucursal(secuencialusuarioDataAccess.getSucursal(connexion,secuencialusuario));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				secuencialusuario.setUsuario(secuencialusuarioDataAccess.getUsuario(connexion,secuencialusuario));
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				secuencialusuario.setTipoDocumentoGeneral(secuencialusuarioDataAccess.getTipoDocumentoGeneral(connexion,secuencialusuario));
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
			secuencialusuario.setEmpresa(secuencialusuarioDataAccess.getEmpresa(connexion,secuencialusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencialusuario.setSucursal(secuencialusuarioDataAccess.getSucursal(connexion,secuencialusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencialusuario.setUsuario(secuencialusuarioDataAccess.getUsuario(connexion,secuencialusuario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencialusuario.setTipoDocumentoGeneral(secuencialusuarioDataAccess.getTipoDocumentoGeneral(connexion,secuencialusuario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		secuencialusuario.setEmpresa(secuencialusuarioDataAccess.getEmpresa(connexion,secuencialusuario));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(secuencialusuario.getEmpresa(),isDeep,deepLoadType,clases);
				
		secuencialusuario.setSucursal(secuencialusuarioDataAccess.getSucursal(connexion,secuencialusuario));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(secuencialusuario.getSucursal(),isDeep,deepLoadType,clases);
				
		secuencialusuario.setUsuario(secuencialusuarioDataAccess.getUsuario(connexion,secuencialusuario));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(secuencialusuario.getUsuario(),isDeep,deepLoadType,clases);
				
		secuencialusuario.setTipoDocumentoGeneral(secuencialusuarioDataAccess.getTipoDocumentoGeneral(connexion,secuencialusuario));
		TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
		tipodocumentogeneralLogic.deepLoad(secuencialusuario.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				secuencialusuario.setEmpresa(secuencialusuarioDataAccess.getEmpresa(connexion,secuencialusuario));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(secuencialusuario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				secuencialusuario.setSucursal(secuencialusuarioDataAccess.getSucursal(connexion,secuencialusuario));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(secuencialusuario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				secuencialusuario.setUsuario(secuencialusuarioDataAccess.getUsuario(connexion,secuencialusuario));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(secuencialusuario.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				secuencialusuario.setTipoDocumentoGeneral(secuencialusuarioDataAccess.getTipoDocumentoGeneral(connexion,secuencialusuario));
				TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
				tipodocumentogeneralLogic.deepLoad(secuencialusuario.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);				
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
			secuencialusuario.setEmpresa(secuencialusuarioDataAccess.getEmpresa(connexion,secuencialusuario));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(secuencialusuario.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencialusuario.setSucursal(secuencialusuarioDataAccess.getSucursal(connexion,secuencialusuario));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(secuencialusuario.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencialusuario.setUsuario(secuencialusuarioDataAccess.getUsuario(connexion,secuencialusuario));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(secuencialusuario.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencialusuario.setTipoDocumentoGeneral(secuencialusuarioDataAccess.getTipoDocumentoGeneral(connexion,secuencialusuario));
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
			tipodocumentogeneralLogic.deepLoad(secuencialusuario.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SecuencialUsuario secuencialusuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SecuencialUsuarioLogicAdditional.updateSecuencialUsuarioToSave(secuencialusuario,this.arrDatoGeneral);
			
SecuencialUsuarioDataAccess.save(secuencialusuario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(secuencialusuario.getEmpresa(),connexion);

		SucursalDataAccess.save(secuencialusuario.getSucursal(),connexion);

		UsuarioDataAccess.save(secuencialusuario.getUsuario(),connexion);

		TipoDocumentoGeneralDataAccess.save(secuencialusuario.getTipoDocumentoGeneral(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(secuencialusuario.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(secuencialusuario.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(secuencialusuario.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				TipoDocumentoGeneralDataAccess.save(secuencialusuario.getTipoDocumentoGeneral(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(secuencialusuario.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(secuencialusuario.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(secuencialusuario.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(secuencialusuario.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(secuencialusuario.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(secuencialusuario.getUsuario(),isDeep,deepLoadType,clases);
				

		TipoDocumentoGeneralDataAccess.save(secuencialusuario.getTipoDocumentoGeneral(),connexion);
		TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
		tipodocumentogeneralLogic.deepLoad(secuencialusuario.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(secuencialusuario.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(secuencialusuario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(secuencialusuario.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(secuencialusuario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(secuencialusuario.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(secuencialusuario.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				TipoDocumentoGeneralDataAccess.save(secuencialusuario.getTipoDocumentoGeneral(),connexion);
				TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
				tipodocumentogeneralLogic.deepSave(secuencialusuario.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(SecuencialUsuario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(secuencialusuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(secuencialusuario);
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
			this.deepLoad(this.secuencialusuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SecuencialUsuario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(secuencialusuarios!=null) {
				for(SecuencialUsuario secuencialusuario:secuencialusuarios) {
					this.deepLoad(secuencialusuario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(secuencialusuarios);
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
			if(secuencialusuarios!=null) {
				for(SecuencialUsuario secuencialusuario:secuencialusuarios) {
					this.deepLoad(secuencialusuario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(secuencialusuarios);
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
			this.getNewConnexionToDeep(SecuencialUsuario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(secuencialusuario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SecuencialUsuario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(secuencialusuarios!=null) {
				for(SecuencialUsuario secuencialusuario:secuencialusuarios) {
					this.deepSave(secuencialusuario,isDeep,deepLoadType,clases);
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
			if(secuencialusuarios!=null) {
				for(SecuencialUsuario secuencialusuario:secuencialusuarios) {
					this.deepSave(secuencialusuario,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSecuencialUsuariosBusquedaPorAutorizacionWithConnection(String sFinalQuery,Pagination pagination,String autorizacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralAutorizacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralAutorizacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+autorizacion+"%",SecuencialUsuarioConstantesFunciones.AUTORIZACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralAutorizacion);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorAutorizacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialUsuariosBusquedaPorAutorizacion(String sFinalQuery,Pagination pagination,String autorizacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralAutorizacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralAutorizacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+autorizacion+"%",SecuencialUsuarioConstantesFunciones.AUTORIZACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralAutorizacion);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorAutorizacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialUsuariosBusquedaPorFechaFinWithConnection(String sFinalQuery,Pagination pagination,Date fecha_fin)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaFin= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaFin.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_fin,SecuencialUsuarioConstantesFunciones.FECHAFIN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaFin);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaFin","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialUsuariosBusquedaPorFechaFin(String sFinalQuery,Pagination pagination,Date fecha_fin)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaFin= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaFin.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_fin,SecuencialUsuarioConstantesFunciones.FECHAFIN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaFin);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaFin","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialUsuariosBusquedaPorFechaInicioWithConnection(String sFinalQuery,Pagination pagination,Date fecha_inicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaInicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaInicio.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_inicio,SecuencialUsuarioConstantesFunciones.FECHAINICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaInicio);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaInicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialUsuariosBusquedaPorFechaInicio(String sFinalQuery,Pagination pagination,Date fecha_inicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaInicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaInicio.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_inicio,SecuencialUsuarioConstantesFunciones.FECHAINICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaInicio);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaInicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialUsuariosBusquedaPorIdUsuarioPorIdTipoDocumentoGeneralWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario,Long id_tipo_documento_general)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,SecuencialUsuarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdUsuarioPorIdTipoDocumentoGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialUsuariosBusquedaPorIdUsuarioPorIdTipoDocumentoGeneral(String sFinalQuery,Pagination pagination,Long id_usuario,Long id_tipo_documento_general)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,SecuencialUsuarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdUsuarioPorIdTipoDocumentoGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialUsuariosBusquedaPorSerieWithConnection(String sFinalQuery,Pagination pagination,String serie)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSerie= new ParameterSelectionGeneral();
			parameterSelectionGeneralSerie.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+serie+"%",SecuencialUsuarioConstantesFunciones.SERIE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSerie);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSerie","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialUsuariosBusquedaPorSerie(String sFinalQuery,Pagination pagination,String serie)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSerie= new ParameterSelectionGeneral();
			parameterSelectionGeneralSerie.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+serie+"%",SecuencialUsuarioConstantesFunciones.SERIE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSerie);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSerie","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialUsuariosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SecuencialUsuarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialUsuariosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SecuencialUsuarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialUsuariosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SecuencialUsuarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialUsuariosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SecuencialUsuarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialUsuariosFK_IdTipoDocumentoGeneralWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_general)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialUsuariosFK_IdTipoDocumentoGeneral(String sFinalQuery,Pagination pagination,Long id_tipo_documento_general)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialUsuariosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,SecuencialUsuarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialUsuariosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,SecuencialUsuarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			SecuencialUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialUsuarioPorEmpresaPorSucursalPorUsuarioPorDocuWithConnection(Long id_empresa,Long id_sucursal,Long id_usuario,Long id_tipo_documento_general)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SecuencialUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SecuencialUsuarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SecuencialUsuarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,SecuencialUsuarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			secuencialusuario=secuencialusuarioDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.secuencialusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuario);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialUsuarioPorEmpresaPorSucursalPorUsuarioPorDocu(Long id_empresa,Long id_sucursal,Long id_usuario,Long id_tipo_documento_general)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SecuencialUsuarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SecuencialUsuarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,SecuencialUsuarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			secuencialusuario=secuencialusuarioDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.secuencialusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(this.secuencialusuario);
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
			if(SecuencialUsuarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SecuencialUsuarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SecuencialUsuario secuencialusuario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SecuencialUsuarioConstantesFunciones.ISCONAUDITORIA) {
				if(secuencialusuario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SecuencialUsuarioDataAccess.TABLENAME, secuencialusuario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SecuencialUsuarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SecuencialUsuarioLogic.registrarAuditoriaDetallesSecuencialUsuario(connexion,secuencialusuario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(secuencialusuario.getIsDeleted()) {
					/*if(!secuencialusuario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SecuencialUsuarioDataAccess.TABLENAME, secuencialusuario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SecuencialUsuarioLogic.registrarAuditoriaDetallesSecuencialUsuario(connexion,secuencialusuario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SecuencialUsuarioDataAccess.TABLENAME, secuencialusuario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(secuencialusuario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SecuencialUsuarioDataAccess.TABLENAME, secuencialusuario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SecuencialUsuarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SecuencialUsuarioLogic.registrarAuditoriaDetallesSecuencialUsuario(connexion,secuencialusuario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSecuencialUsuario(Connexion connexion,SecuencialUsuario secuencialusuario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getid_empresa().equals(secuencialusuario.getSecuencialUsuarioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getid_empresa()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getid_empresa().toString();
				}
				if(secuencialusuario.getid_empresa()!=null)
				{
					strValorNuevo=secuencialusuario.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getid_sucursal().equals(secuencialusuario.getSecuencialUsuarioOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getid_sucursal()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getid_sucursal().toString();
				}
				if(secuencialusuario.getid_sucursal()!=null)
				{
					strValorNuevo=secuencialusuario.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getid_usuario().equals(secuencialusuario.getSecuencialUsuarioOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getid_usuario()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getid_usuario().toString();
				}
				if(secuencialusuario.getid_usuario()!=null)
				{
					strValorNuevo=secuencialusuario.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getid_tipo_documento_general().equals(secuencialusuario.getSecuencialUsuarioOriginal().getid_tipo_documento_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getid_tipo_documento_general()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getid_tipo_documento_general().toString();
				}
				if(secuencialusuario.getid_tipo_documento_general()!=null)
				{
					strValorNuevo=secuencialusuario.getid_tipo_documento_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getserie().equals(secuencialusuario.getSecuencialUsuarioOriginal().getserie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getserie()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getserie();
				}
				if(secuencialusuario.getserie()!=null)
				{
					strValorNuevo=secuencialusuario.getserie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.SERIE,strValorActual,strValorNuevo);
			}	
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getautorizacion().equals(secuencialusuario.getSecuencialUsuarioOriginal().getautorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getautorizacion()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getautorizacion();
				}
				if(secuencialusuario.getautorizacion()!=null)
				{
					strValorNuevo=secuencialusuario.getautorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.AUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getsecuencial().equals(secuencialusuario.getSecuencialUsuarioOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getsecuencial()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getsecuencial();
				}
				if(secuencialusuario.getsecuencial()!=null)
				{
					strValorNuevo=secuencialusuario.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getdigitos().equals(secuencialusuario.getSecuencialUsuarioOriginal().getdigitos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getdigitos()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getdigitos().toString();
				}
				if(secuencialusuario.getdigitos()!=null)
				{
					strValorNuevo=secuencialusuario.getdigitos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.DIGITOS,strValorActual,strValorNuevo);
			}	
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getfecha_inicio().equals(secuencialusuario.getSecuencialUsuarioOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getfecha_inicio()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getfecha_inicio().toString();
				}
				if(secuencialusuario.getfecha_inicio()!=null)
				{
					strValorNuevo=secuencialusuario.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getfecha_fin().equals(secuencialusuario.getSecuencialUsuarioOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getfecha_fin()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getfecha_fin().toString();
				}
				if(secuencialusuario.getfecha_fin()!=null)
				{
					strValorNuevo=secuencialusuario.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(secuencialusuario.getIsNew()||!secuencialusuario.getesta_activo().equals(secuencialusuario.getSecuencialUsuarioOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencialusuario.getSecuencialUsuarioOriginal().getesta_activo()!=null)
				{
					strValorActual=secuencialusuario.getSecuencialUsuarioOriginal().getesta_activo().toString();
				}
				if(secuencialusuario.getesta_activo()!=null)
				{
					strValorNuevo=secuencialusuario.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialUsuarioConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSecuencialUsuarioRelacionesWithConnection(SecuencialUsuario secuencialusuario) throws Exception {

		if(!secuencialusuario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSecuencialUsuarioRelacionesBase(secuencialusuario,true);
		}
	}

	public void saveSecuencialUsuarioRelaciones(SecuencialUsuario secuencialusuario)throws Exception {

		if(!secuencialusuario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSecuencialUsuarioRelacionesBase(secuencialusuario,false);
		}
	}

	public void saveSecuencialUsuarioRelacionesBase(SecuencialUsuario secuencialusuario,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SecuencialUsuario-saveRelacionesWithConnection");}
	

			this.setSecuencialUsuario(secuencialusuario);

			if(SecuencialUsuarioLogicAdditional.validarSaveRelaciones(secuencialusuario,this)) {

				SecuencialUsuarioLogicAdditional.updateRelacionesToSave(secuencialusuario,this);

				if((secuencialusuario.getIsNew()||secuencialusuario.getIsChanged())&&!secuencialusuario.getIsDeleted()) {
					this.saveSecuencialUsuario();
					this.saveSecuencialUsuarioRelacionesDetalles();

				} else if(secuencialusuario.getIsDeleted()) {
					this.saveSecuencialUsuarioRelacionesDetalles();
					this.saveSecuencialUsuario();
				}

				SecuencialUsuarioLogicAdditional.updateRelacionesToSaveAfter(secuencialusuario,this);

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
	
	
	private void saveSecuencialUsuarioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSecuencialUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SecuencialUsuarioConstantesFunciones.getClassesForeignKeysOfSecuencialUsuario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSecuencialUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SecuencialUsuarioConstantesFunciones.getClassesRelationshipsOfSecuencialUsuario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

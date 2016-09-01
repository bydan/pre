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
import com.bydan.erp.seguridad.util.ParametroGeneralSgConstantesFunciones;
import com.bydan.erp.seguridad.util.ParametroGeneralSgParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ParametroGeneralSgParameterGeneral;
import com.bydan.erp.seguridad.business.entity.ParametroGeneralSg;
import com.bydan.erp.seguridad.business.logic.ParametroGeneralSgLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class ParametroGeneralSgLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroGeneralSgLogic.class);
	
	protected ParametroGeneralSgDataAccess parametrogeneralsgDataAccess; 	
	protected ParametroGeneralSg parametrogeneralsg;
	protected List<ParametroGeneralSg> parametrogeneralsgs;
	protected Object parametrogeneralsgObject;	
	protected List<Object> parametrogeneralsgsObject;
	
	public static ClassValidator<ParametroGeneralSg> parametrogeneralsgValidator = new ClassValidator<ParametroGeneralSg>(ParametroGeneralSg.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroGeneralSgLogicAdditional parametrogeneralsgLogicAdditional=null;
	
	public ParametroGeneralSgLogicAdditional getParametroGeneralSgLogicAdditional() {
		return this.parametrogeneralsgLogicAdditional;
	}
	
	public void setParametroGeneralSgLogicAdditional(ParametroGeneralSgLogicAdditional parametrogeneralsgLogicAdditional) {
		try {
			this.parametrogeneralsgLogicAdditional=parametrogeneralsgLogicAdditional;
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
	
	
	
	
	public  ParametroGeneralSgLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrogeneralsgDataAccess = new ParametroGeneralSgDataAccess();
			
			this.parametrogeneralsgs= new ArrayList<ParametroGeneralSg>();
			this.parametrogeneralsg= new ParametroGeneralSg();
			
			this.parametrogeneralsgObject=new Object();
			this.parametrogeneralsgsObject=new ArrayList<Object>();
				
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
			
			this.parametrogeneralsgDataAccess.setConnexionType(this.connexionType);
			this.parametrogeneralsgDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroGeneralSgLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrogeneralsgDataAccess = new ParametroGeneralSgDataAccess();
			this.parametrogeneralsgs= new ArrayList<ParametroGeneralSg>();
			this.parametrogeneralsg= new ParametroGeneralSg();
			this.parametrogeneralsgObject=new Object();
			this.parametrogeneralsgsObject=new ArrayList<Object>();
			
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
			
			this.parametrogeneralsgDataAccess.setConnexionType(this.connexionType);
			this.parametrogeneralsgDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroGeneralSg getParametroGeneralSg() throws Exception {	
		ParametroGeneralSgLogicAdditional.checkParametroGeneralSgToGet(parametrogeneralsg,this.datosCliente,this.arrDatoGeneral);
		ParametroGeneralSgLogicAdditional.updateParametroGeneralSgToGet(parametrogeneralsg,this.arrDatoGeneral);
		
		return parametrogeneralsg;
	}
		
	public void setParametroGeneralSg(ParametroGeneralSg newParametroGeneralSg) {
		this.parametrogeneralsg = newParametroGeneralSg;
	}
	
	public ParametroGeneralSgDataAccess getParametroGeneralSgDataAccess() {
		return parametrogeneralsgDataAccess;
	}
	
	public void setParametroGeneralSgDataAccess(ParametroGeneralSgDataAccess newparametrogeneralsgDataAccess) {
		this.parametrogeneralsgDataAccess = newparametrogeneralsgDataAccess;
	}
	
	public List<ParametroGeneralSg> getParametroGeneralSgs() throws Exception {		
		this.quitarParametroGeneralSgsNulos();
		
		ParametroGeneralSgLogicAdditional.checkParametroGeneralSgToGets(parametrogeneralsgs,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroGeneralSg parametrogeneralsgLocal: parametrogeneralsgs ) {
			ParametroGeneralSgLogicAdditional.updateParametroGeneralSgToGet(parametrogeneralsgLocal,this.arrDatoGeneral);
		}
		
		return parametrogeneralsgs;
	}
	
	public void setParametroGeneralSgs(List<ParametroGeneralSg> newParametroGeneralSgs) {
		this.parametrogeneralsgs = newParametroGeneralSgs;
	}
	
	public Object getParametroGeneralSgObject() {	
		this.parametrogeneralsgObject=this.parametrogeneralsgDataAccess.getEntityObject();
		return this.parametrogeneralsgObject;
	}
		
	public void setParametroGeneralSgObject(Object newParametroGeneralSgObject) {
		this.parametrogeneralsgObject = newParametroGeneralSgObject;
	}
	
	public List<Object> getParametroGeneralSgsObject() {		
		this.parametrogeneralsgsObject=this.parametrogeneralsgDataAccess.getEntitiesObject();
		return this.parametrogeneralsgsObject;
	}
		
	public void setParametroGeneralSgsObject(List<Object> newParametroGeneralSgsObject) {
		this.parametrogeneralsgsObject = newParametroGeneralSgsObject;
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
		
		if(this.parametrogeneralsgDataAccess!=null) {
			this.parametrogeneralsgDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrogeneralsgDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrogeneralsgDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrogeneralsg = new  ParametroGeneralSg();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrogeneralsg=parametrogeneralsgDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneralsg,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsg);
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
		parametrogeneralsg = new  ParametroGeneralSg();
		  		  
        try {
			
			parametrogeneralsg=parametrogeneralsgDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneralsg,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsg);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrogeneralsg = new  ParametroGeneralSg();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrogeneralsg=parametrogeneralsgDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneralsg,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsg);
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
		parametrogeneralsg = new  ParametroGeneralSg();
		  		  
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
		parametrogeneralsg = new  ParametroGeneralSg();
		  		  
        try {
			
			parametrogeneralsg=parametrogeneralsgDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneralsg,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsg);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrogeneralsg = new  ParametroGeneralSg();
		  		  
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
		parametrogeneralsg = new  ParametroGeneralSg();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrogeneralsgDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogeneralsg = new  ParametroGeneralSg();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrogeneralsgDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrogeneralsg = new  ParametroGeneralSg();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrogeneralsgDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogeneralsg = new  ParametroGeneralSg();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrogeneralsgDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrogeneralsg = new  ParametroGeneralSg();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrogeneralsgDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogeneralsg = new  ParametroGeneralSg();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrogeneralsgDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsgs=parametrogeneralsgDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsgs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsgs);
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
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		  		  
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
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		  		  
        try {			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsgs=parametrogeneralsgDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsgs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsgs);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		  		  
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
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsgs=parametrogeneralsgDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsgs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsgs);
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
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		  		  
        try {
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsgs=parametrogeneralsgDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsgs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsgs);
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
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsgs=parametrogeneralsgDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsgs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsgs);
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
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsgs=parametrogeneralsgDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsgs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsgs);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrogeneralsg = new  ParametroGeneralSg();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsg=parametrogeneralsgDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsg);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsg);
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
		parametrogeneralsg = new  ParametroGeneralSg();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsg=parametrogeneralsgDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsg);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsg);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsgs=parametrogeneralsgDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsgs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsgs);
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
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		  		  
        try {
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsgs=parametrogeneralsgDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsgs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsgs);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroGeneralSgsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-getTodosParametroGeneralSgsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsgs=parametrogeneralsgDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsgs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsgs);
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
	
	public  void  getTodosParametroGeneralSgs(String sFinalQuery,Pagination pagination)throws Exception {
		parametrogeneralsgs = new  ArrayList<ParametroGeneralSg>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneralsgs=parametrogeneralsgDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroGeneralSg(parametrogeneralsgs);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsgs);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroGeneralSg(ParametroGeneralSg parametrogeneralsg) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrogeneralsg.getIsNew() || parametrogeneralsg.getIsChanged()) { 
			this.invalidValues = parametrogeneralsgValidator.getInvalidValues(parametrogeneralsg);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrogeneralsg);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroGeneralSg(List<ParametroGeneralSg> ParametroGeneralSgs) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroGeneralSg parametrogeneralsgLocal:parametrogeneralsgs) {				
			estaValidadoObjeto=this.validarGuardarParametroGeneralSg(parametrogeneralsgLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroGeneralSg(List<ParametroGeneralSg> ParametroGeneralSgs) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroGeneralSg(parametrogeneralsgs)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroGeneralSg(ParametroGeneralSg ParametroGeneralSg) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroGeneralSg(parametrogeneralsg)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroGeneralSg parametrogeneralsg) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrogeneralsg.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroGeneralSgConstantesFunciones.getParametroGeneralSgLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrogeneralsg","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroGeneralSgConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroGeneralSgConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroGeneralSgWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-saveParametroGeneralSgWithConnection");connexion.begin();			
			
			ParametroGeneralSgLogicAdditional.checkParametroGeneralSgToSave(this.parametrogeneralsg,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroGeneralSgLogicAdditional.updateParametroGeneralSgToSave(this.parametrogeneralsg,this.arrDatoGeneral);
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrogeneralsg,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroGeneralSg();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroGeneralSg(this.parametrogeneralsg)) {
				ParametroGeneralSgDataAccess.save(this.parametrogeneralsg, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrogeneralsg,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroGeneralSgLogicAdditional.checkParametroGeneralSgToSaveAfter(this.parametrogeneralsg,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroGeneralSg();
			
			connexion.commit();			
			
			if(this.parametrogeneralsg.getIsDeleted()) {
				this.parametrogeneralsg=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroGeneralSg()throws Exception {	
		try {	
			
			ParametroGeneralSgLogicAdditional.checkParametroGeneralSgToSave(this.parametrogeneralsg,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroGeneralSgLogicAdditional.updateParametroGeneralSgToSave(this.parametrogeneralsg,this.arrDatoGeneral);
			
			ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrogeneralsg,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroGeneralSg(this.parametrogeneralsg)) {			
				ParametroGeneralSgDataAccess.save(this.parametrogeneralsg, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrogeneralsg,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroGeneralSgLogicAdditional.checkParametroGeneralSgToSaveAfter(this.parametrogeneralsg,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrogeneralsg.getIsDeleted()) {
				this.parametrogeneralsg=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroGeneralSgsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-saveParametroGeneralSgsWithConnection");connexion.begin();			
			
			ParametroGeneralSgLogicAdditional.checkParametroGeneralSgToSaves(parametrogeneralsgs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroGeneralSgs();
			
			Boolean validadoTodosParametroGeneralSg=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroGeneralSg parametrogeneralsgLocal:parametrogeneralsgs) {		
				if(parametrogeneralsgLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroGeneralSgLogicAdditional.updateParametroGeneralSgToSave(parametrogeneralsgLocal,this.arrDatoGeneral);
	        	
				ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrogeneralsgLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroGeneralSg(parametrogeneralsgLocal)) {
					ParametroGeneralSgDataAccess.save(parametrogeneralsgLocal, connexion);				
				} else {
					validadoTodosParametroGeneralSg=false;
				}
			}
			
			if(!validadoTodosParametroGeneralSg) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroGeneralSgLogicAdditional.checkParametroGeneralSgToSavesAfter(parametrogeneralsgs,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroGeneralSgs();
			
			connexion.commit();		
			
			this.quitarParametroGeneralSgsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroGeneralSgs()throws Exception {				
		 try {	
			ParametroGeneralSgLogicAdditional.checkParametroGeneralSgToSaves(parametrogeneralsgs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroGeneralSg=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroGeneralSg parametrogeneralsgLocal:parametrogeneralsgs) {				
				if(parametrogeneralsgLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroGeneralSgLogicAdditional.updateParametroGeneralSgToSave(parametrogeneralsgLocal,this.arrDatoGeneral);
	        	
				ParametroGeneralSgLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrogeneralsgLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroGeneralSg(parametrogeneralsgLocal)) {				
					ParametroGeneralSgDataAccess.save(parametrogeneralsgLocal, connexion);				
				} else {
					validadoTodosParametroGeneralSg=false;
				}
			}
			
			if(!validadoTodosParametroGeneralSg) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroGeneralSgLogicAdditional.checkParametroGeneralSgToSavesAfter(parametrogeneralsgs,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroGeneralSgsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroGeneralSgParameterReturnGeneral procesarAccionParametroGeneralSgs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroGeneralSg> parametrogeneralsgs,ParametroGeneralSgParameterReturnGeneral parametrogeneralsgParameterGeneral)throws Exception {
		 try {	
			ParametroGeneralSgParameterReturnGeneral parametrogeneralsgReturnGeneral=new ParametroGeneralSgParameterReturnGeneral();
	
			ParametroGeneralSgLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrogeneralsgs,parametrogeneralsgParameterGeneral,parametrogeneralsgReturnGeneral);
			
			return parametrogeneralsgReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroGeneralSgParameterReturnGeneral procesarAccionParametroGeneralSgsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroGeneralSg> parametrogeneralsgs,ParametroGeneralSgParameterReturnGeneral parametrogeneralsgParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-procesarAccionParametroGeneralSgsWithConnection");connexion.begin();			
			
			ParametroGeneralSgParameterReturnGeneral parametrogeneralsgReturnGeneral=new ParametroGeneralSgParameterReturnGeneral();
	
			ParametroGeneralSgLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrogeneralsgs,parametrogeneralsgParameterGeneral,parametrogeneralsgReturnGeneral);
			
			this.connexion.commit();
			
			return parametrogeneralsgReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroGeneralSgParameterReturnGeneral procesarEventosParametroGeneralSgs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroGeneralSg> parametrogeneralsgs,ParametroGeneralSg parametrogeneralsg,ParametroGeneralSgParameterReturnGeneral parametrogeneralsgParameterGeneral,Boolean isEsNuevoParametroGeneralSg,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroGeneralSgParameterReturnGeneral parametrogeneralsgReturnGeneral=new ParametroGeneralSgParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrogeneralsgReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroGeneralSgLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrogeneralsgs,parametrogeneralsg,parametrogeneralsgParameterGeneral,parametrogeneralsgReturnGeneral,isEsNuevoParametroGeneralSg,clases);
			
			return parametrogeneralsgReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroGeneralSgParameterReturnGeneral procesarEventosParametroGeneralSgsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroGeneralSg> parametrogeneralsgs,ParametroGeneralSg parametrogeneralsg,ParametroGeneralSgParameterReturnGeneral parametrogeneralsgParameterGeneral,Boolean isEsNuevoParametroGeneralSg,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-procesarEventosParametroGeneralSgsWithConnection");connexion.begin();			
			
			ParametroGeneralSgParameterReturnGeneral parametrogeneralsgReturnGeneral=new ParametroGeneralSgParameterReturnGeneral();
	
			parametrogeneralsgReturnGeneral.setParametroGeneralSg(parametrogeneralsg);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrogeneralsgReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroGeneralSgLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrogeneralsgs,parametrogeneralsg,parametrogeneralsgParameterGeneral,parametrogeneralsgReturnGeneral,isEsNuevoParametroGeneralSg,clases);
			
			this.connexion.commit();
			
			return parametrogeneralsgReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroGeneralSgParameterReturnGeneral procesarImportacionParametroGeneralSgsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroGeneralSgParameterReturnGeneral parametrogeneralsgParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneralSg.class.getSimpleName()+"-procesarImportacionParametroGeneralSgsWithConnection");connexion.begin();			
			
			ParametroGeneralSgParameterReturnGeneral parametrogeneralsgReturnGeneral=new ParametroGeneralSgParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrogeneralsgs=new ArrayList<ParametroGeneralSg>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrogeneralsg=new ParametroGeneralSg();
				
				
				if(conColumnasBase) {this.parametrogeneralsg.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrogeneralsg.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrogeneralsg.setnombre_sistema(arrColumnas[iColumn++]);
				this.parametrogeneralsg.setnombre_simple_sistema(arrColumnas[iColumn++]);
				this.parametrogeneralsg.setnombre_empresa(arrColumnas[iColumn++]);
				this.parametrogeneralsg.setversion_sistema(Double.parseDouble(arrColumnas[iColumn++]));
				this.parametrogeneralsg.setsiglas_sistema(arrColumnas[iColumn++]);
				this.parametrogeneralsg.setmail_sistema(arrColumnas[iColumn++]);
				this.parametrogeneralsg.settelefono_sistema(arrColumnas[iColumn++]);
				this.parametrogeneralsg.setfax_sistema(arrColumnas[iColumn++]);
				this.parametrogeneralsg.setrepresentante_nombre(arrColumnas[iColumn++]);
				this.parametrogeneralsg.setcodigo_proceso_actualizacion(arrColumnas[iColumn++]);
				this.parametrogeneralsg.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametrogeneralsgs.add(this.parametrogeneralsg);
			}
			
			this.saveParametroGeneralSgs();
			
			this.connexion.commit();
			
			parametrogeneralsgReturnGeneral.setConRetornoEstaProcesado(true);
			parametrogeneralsgReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrogeneralsgReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroGeneralSgsEliminados() throws Exception {				
		
		List<ParametroGeneralSg> parametrogeneralsgsAux= new ArrayList<ParametroGeneralSg>();
		
		for(ParametroGeneralSg parametrogeneralsg:parametrogeneralsgs) {
			if(!parametrogeneralsg.getIsDeleted()) {
				parametrogeneralsgsAux.add(parametrogeneralsg);
			}
		}
		
		parametrogeneralsgs=parametrogeneralsgsAux;
	}
	
	public void quitarParametroGeneralSgsNulos() throws Exception {				
		
		List<ParametroGeneralSg> parametrogeneralsgsAux= new ArrayList<ParametroGeneralSg>();
		
		for(ParametroGeneralSg parametrogeneralsg : this.parametrogeneralsgs) {
			if(parametrogeneralsg==null) {
				parametrogeneralsgsAux.add(parametrogeneralsg);
			}
		}
		
		//this.parametrogeneralsgs=parametrogeneralsgsAux;
		
		this.parametrogeneralsgs.removeAll(parametrogeneralsgsAux);
	}
	
	public void getSetVersionRowParametroGeneralSgWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrogeneralsg.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrogeneralsg.getIsDeleted() || (parametrogeneralsg.getIsChanged()&&!parametrogeneralsg.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrogeneralsgDataAccess.getSetVersionRowParametroGeneralSg(connexion,parametrogeneralsg.getId());
				
				if(!parametrogeneralsg.getVersionRow().equals(timestamp)) {	
					parametrogeneralsg.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrogeneralsg.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroGeneralSg()throws Exception {	
		
		if(parametrogeneralsg.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrogeneralsg.getIsDeleted() || (parametrogeneralsg.getIsChanged()&&!parametrogeneralsg.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrogeneralsgDataAccess.getSetVersionRowParametroGeneralSg(connexion,parametrogeneralsg.getId());
			
			try {							
				if(!parametrogeneralsg.getVersionRow().equals(timestamp)) {	
					parametrogeneralsg.setVersionRow(timestamp);
				}
				
				parametrogeneralsg.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroGeneralSgsWithConnection()throws Exception {	
		if(parametrogeneralsgs!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroGeneralSg parametrogeneralsgAux:parametrogeneralsgs) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrogeneralsgAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrogeneralsgAux.getIsDeleted() || (parametrogeneralsgAux.getIsChanged()&&!parametrogeneralsgAux.getIsNew())) {
						
						timestamp=parametrogeneralsgDataAccess.getSetVersionRowParametroGeneralSg(connexion,parametrogeneralsgAux.getId());
						
						if(!parametrogeneralsg.getVersionRow().equals(timestamp)) {	
							parametrogeneralsgAux.setVersionRow(timestamp);
						}
								
						parametrogeneralsgAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroGeneralSgs()throws Exception {	
		if(parametrogeneralsgs!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroGeneralSg parametrogeneralsgAux:parametrogeneralsgs) {
					if(parametrogeneralsgAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrogeneralsgAux.getIsDeleted() || (parametrogeneralsgAux.getIsChanged()&&!parametrogeneralsgAux.getIsNew())) {
						
						timestamp=parametrogeneralsgDataAccess.getSetVersionRowParametroGeneralSg(connexion,parametrogeneralsgAux.getId());
						
						if(!parametrogeneralsgAux.getVersionRow().equals(timestamp)) {	
							parametrogeneralsgAux.setVersionRow(timestamp);
						}
						
													
						parametrogeneralsgAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(ParametroGeneralSg parametrogeneralsg,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			ParametroGeneralSgLogicAdditional.updateParametroGeneralSgToGet(parametrogeneralsg,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroGeneralSg parametrogeneralsg,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
				
		try {
			ParametroGeneralSgLogicAdditional.updateParametroGeneralSgToSave(parametrogeneralsg,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroGeneralSg.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrogeneralsg,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(parametrogeneralsg);
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
			this.deepLoad(this.parametrogeneralsg,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(this.parametrogeneralsg);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroGeneralSg.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrogeneralsgs!=null) {
				for(ParametroGeneralSg parametrogeneralsg:parametrogeneralsgs) {
					this.deepLoad(parametrogeneralsg,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(parametrogeneralsgs);
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
			if(parametrogeneralsgs!=null) {
				for(ParametroGeneralSg parametrogeneralsg:parametrogeneralsgs) {
					this.deepLoad(parametrogeneralsg,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroGeneralSgConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralSg(parametrogeneralsgs);
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
			this.getNewConnexionToDeep(ParametroGeneralSg.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrogeneralsg,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroGeneralSg.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrogeneralsgs!=null) {
				for(ParametroGeneralSg parametrogeneralsg:parametrogeneralsgs) {
					this.deepSave(parametrogeneralsg,isDeep,deepLoadType,clases);
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
			if(parametrogeneralsgs!=null) {
				for(ParametroGeneralSg parametrogeneralsg:parametrogeneralsgs) {
					this.deepSave(parametrogeneralsg,isDeep,deepLoadType,clases);
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
			if(ParametroGeneralSgConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralSgDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroGeneralSg parametrogeneralsg,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroGeneralSgConstantesFunciones.ISCONAUDITORIA) {
				if(parametrogeneralsg.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralSgDataAccess.TABLENAME, parametrogeneralsg.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroGeneralSgConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroGeneralSgLogic.registrarAuditoriaDetallesParametroGeneralSg(connexion,parametrogeneralsg,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrogeneralsg.getIsDeleted()) {
					/*if(!parametrogeneralsg.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroGeneralSgDataAccess.TABLENAME, parametrogeneralsg.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroGeneralSgLogic.registrarAuditoriaDetallesParametroGeneralSg(connexion,parametrogeneralsg,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralSgDataAccess.TABLENAME, parametrogeneralsg.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrogeneralsg.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralSgDataAccess.TABLENAME, parametrogeneralsg.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroGeneralSgConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroGeneralSgLogic.registrarAuditoriaDetallesParametroGeneralSg(connexion,parametrogeneralsg,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroGeneralSg(Connexion connexion,ParametroGeneralSg parametrogeneralsg)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.getnombre_sistema().equals(parametrogeneralsg.getParametroGeneralSgOriginal().getnombre_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().getnombre_sistema()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().getnombre_sistema();
				}
				if(parametrogeneralsg.getnombre_sistema()!=null)
				{
					strValorNuevo=parametrogeneralsg.getnombre_sistema() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.NOMBRESISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.getnombre_simple_sistema().equals(parametrogeneralsg.getParametroGeneralSgOriginal().getnombre_simple_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().getnombre_simple_sistema()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().getnombre_simple_sistema();
				}
				if(parametrogeneralsg.getnombre_simple_sistema()!=null)
				{
					strValorNuevo=parametrogeneralsg.getnombre_simple_sistema() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.getnombre_empresa().equals(parametrogeneralsg.getParametroGeneralSgOriginal().getnombre_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().getnombre_empresa()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().getnombre_empresa();
				}
				if(parametrogeneralsg.getnombre_empresa()!=null)
				{
					strValorNuevo=parametrogeneralsg.getnombre_empresa() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.NOMBREEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.getversion_sistema().equals(parametrogeneralsg.getParametroGeneralSgOriginal().getversion_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().getversion_sistema()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().getversion_sistema().toString();
				}
				if(parametrogeneralsg.getversion_sistema()!=null)
				{
					strValorNuevo=parametrogeneralsg.getversion_sistema().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.getsiglas_sistema().equals(parametrogeneralsg.getParametroGeneralSgOriginal().getsiglas_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().getsiglas_sistema()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().getsiglas_sistema();
				}
				if(parametrogeneralsg.getsiglas_sistema()!=null)
				{
					strValorNuevo=parametrogeneralsg.getsiglas_sistema() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.SIGLASSISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.getmail_sistema().equals(parametrogeneralsg.getParametroGeneralSgOriginal().getmail_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().getmail_sistema()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().getmail_sistema();
				}
				if(parametrogeneralsg.getmail_sistema()!=null)
				{
					strValorNuevo=parametrogeneralsg.getmail_sistema() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.MAILSISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.gettelefono_sistema().equals(parametrogeneralsg.getParametroGeneralSgOriginal().gettelefono_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().gettelefono_sistema()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().gettelefono_sistema();
				}
				if(parametrogeneralsg.gettelefono_sistema()!=null)
				{
					strValorNuevo=parametrogeneralsg.gettelefono_sistema() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.TELEFONOSISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.getfax_sistema().equals(parametrogeneralsg.getParametroGeneralSgOriginal().getfax_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().getfax_sistema()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().getfax_sistema();
				}
				if(parametrogeneralsg.getfax_sistema()!=null)
				{
					strValorNuevo=parametrogeneralsg.getfax_sistema() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.FAXSISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.getrepresentante_nombre().equals(parametrogeneralsg.getParametroGeneralSgOriginal().getrepresentante_nombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().getrepresentante_nombre()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().getrepresentante_nombre();
				}
				if(parametrogeneralsg.getrepresentante_nombre()!=null)
				{
					strValorNuevo=parametrogeneralsg.getrepresentante_nombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.REPRESENTANTENOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.getcodigo_proceso_actualizacion().equals(parametrogeneralsg.getParametroGeneralSgOriginal().getcodigo_proceso_actualizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().getcodigo_proceso_actualizacion()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().getcodigo_proceso_actualizacion();
				}
				if(parametrogeneralsg.getcodigo_proceso_actualizacion()!=null)
				{
					strValorNuevo=parametrogeneralsg.getcodigo_proceso_actualizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.CODIGOPROCESOACTUALIZACION,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneralsg.getIsNew()||!parametrogeneralsg.getesta_activo().equals(parametrogeneralsg.getParametroGeneralSgOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneralsg.getParametroGeneralSgOriginal().getesta_activo()!=null)
				{
					strValorActual=parametrogeneralsg.getParametroGeneralSgOriginal().getesta_activo().toString();
				}
				if(parametrogeneralsg.getesta_activo()!=null)
				{
					strValorNuevo=parametrogeneralsg.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralSgConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroGeneralSgRelacionesWithConnection(ParametroGeneralSg parametrogeneralsg) throws Exception {

		if(!parametrogeneralsg.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroGeneralSgRelacionesBase(parametrogeneralsg,true);
		}
	}

	public void saveParametroGeneralSgRelaciones(ParametroGeneralSg parametrogeneralsg)throws Exception {

		if(!parametrogeneralsg.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroGeneralSgRelacionesBase(parametrogeneralsg,false);
		}
	}

	public void saveParametroGeneralSgRelacionesBase(ParametroGeneralSg parametrogeneralsg,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroGeneralSg-saveRelacionesWithConnection");}
	

			this.setParametroGeneralSg(parametrogeneralsg);

			if(ParametroGeneralSgLogicAdditional.validarSaveRelaciones(parametrogeneralsg,this)) {

				ParametroGeneralSgLogicAdditional.updateRelacionesToSave(parametrogeneralsg,this);

				if((parametrogeneralsg.getIsNew()||parametrogeneralsg.getIsChanged())&&!parametrogeneralsg.getIsDeleted()) {
					this.saveParametroGeneralSg();
					this.saveParametroGeneralSgRelacionesDetalles();

				} else if(parametrogeneralsg.getIsDeleted()) {
					this.saveParametroGeneralSgRelacionesDetalles();
					this.saveParametroGeneralSg();
				}

				ParametroGeneralSgLogicAdditional.updateRelacionesToSaveAfter(parametrogeneralsg,this);

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
	
	
	private void saveParametroGeneralSgRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroGeneralSg(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroGeneralSgConstantesFunciones.getClassesForeignKeysOfParametroGeneralSg(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGeneralSg(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroGeneralSgConstantesFunciones.getClassesRelationshipsOfParametroGeneralSg(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

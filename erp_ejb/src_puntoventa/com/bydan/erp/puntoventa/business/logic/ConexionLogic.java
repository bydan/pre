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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.ConexionConstantesFunciones;
import com.bydan.erp.puntoventa.util.ConexionParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.ConexionParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.Conexion;
import com.bydan.erp.puntoventa.business.logic.ConexionLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class ConexionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ConexionLogic.class);
	
	protected ConexionDataAccess conexionDataAccess; 	
	protected Conexion conexion;
	protected List<Conexion> conexions;
	protected Object conexionObject;	
	protected List<Object> conexionsObject;
	
	public static ClassValidator<Conexion> conexionValidator = new ClassValidator<Conexion>(Conexion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ConexionLogicAdditional conexionLogicAdditional=null;
	
	public ConexionLogicAdditional getConexionLogicAdditional() {
		return this.conexionLogicAdditional;
	}
	
	public void setConexionLogicAdditional(ConexionLogicAdditional conexionLogicAdditional) {
		try {
			this.conexionLogicAdditional=conexionLogicAdditional;
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
	
	
	
	
	public  ConexionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.conexionDataAccess = new ConexionDataAccess();
			
			this.conexions= new ArrayList<Conexion>();
			this.conexion= new Conexion();
			
			this.conexionObject=new Object();
			this.conexionsObject=new ArrayList<Object>();
				
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
			
			this.conexionDataAccess.setConnexionType(this.connexionType);
			this.conexionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConexionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.conexionDataAccess = new ConexionDataAccess();
			this.conexions= new ArrayList<Conexion>();
			this.conexion= new Conexion();
			this.conexionObject=new Object();
			this.conexionsObject=new ArrayList<Object>();
			
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
			
			this.conexionDataAccess.setConnexionType(this.connexionType);
			this.conexionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Conexion getConexion() throws Exception {	
		ConexionLogicAdditional.checkConexionToGet(conexion,this.datosCliente,this.arrDatoGeneral);
		ConexionLogicAdditional.updateConexionToGet(conexion,this.arrDatoGeneral);
		
		return conexion;
	}
		
	public void setConexion(Conexion newConexion) {
		this.conexion = newConexion;
	}
	
	public ConexionDataAccess getConexionDataAccess() {
		return conexionDataAccess;
	}
	
	public void setConexionDataAccess(ConexionDataAccess newconexionDataAccess) {
		this.conexionDataAccess = newconexionDataAccess;
	}
	
	public List<Conexion> getConexions() throws Exception {		
		this.quitarConexionsNulos();
		
		ConexionLogicAdditional.checkConexionToGets(conexions,this.datosCliente,this.arrDatoGeneral);
		
		for (Conexion conexionLocal: conexions ) {
			ConexionLogicAdditional.updateConexionToGet(conexionLocal,this.arrDatoGeneral);
		}
		
		return conexions;
	}
	
	public void setConexions(List<Conexion> newConexions) {
		this.conexions = newConexions;
	}
	
	public Object getConexionObject() {	
		this.conexionObject=this.conexionDataAccess.getEntityObject();
		return this.conexionObject;
	}
		
	public void setConexionObject(Object newConexionObject) {
		this.conexionObject = newConexionObject;
	}
	
	public List<Object> getConexionsObject() {		
		this.conexionsObject=this.conexionDataAccess.getEntitiesObject();
		return this.conexionsObject;
	}
		
	public void setConexionsObject(List<Object> newConexionsObject) {
		this.conexionsObject = newConexionsObject;
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
		
		if(this.conexionDataAccess!=null) {
			this.conexionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			conexionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			conexionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		conexion = new  Conexion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			conexion=conexionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexion);
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
		conexion = new  Conexion();
		  		  
        try {
			
			conexion=conexionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		conexion = new  Conexion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			conexion=conexionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexion);
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
		conexion = new  Conexion();
		  		  
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
		conexion = new  Conexion();
		  		  
        try {
			
			conexion=conexionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		conexion = new  Conexion();
		  		  
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
		conexion = new  Conexion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =conexionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conexion = new  Conexion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=conexionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		conexion = new  Conexion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =conexionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conexion = new  Conexion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=conexionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		conexion = new  Conexion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =conexionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conexion = new  Conexion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=conexionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		conexions = new  ArrayList<Conexion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexions=conexionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConexion(conexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
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
		conexions = new  ArrayList<Conexion>();
		  		  
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
		conexions = new  ArrayList<Conexion>();
		  		  
        try {			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexions=conexionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarConexion(conexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		conexions = new  ArrayList<Conexion>();
		  		  
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
		conexions = new  ArrayList<Conexion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexions=conexionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConexion(conexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
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
		conexions = new  ArrayList<Conexion>();
		  		  
        try {
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexions=conexionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConexion(conexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
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
		conexions = new  ArrayList<Conexion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexions=conexionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConexion(conexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
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
		conexions = new  ArrayList<Conexion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexions=conexionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConexion(conexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		conexion = new  Conexion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexion=conexionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConexion(conexion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexion);
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
		conexion = new  Conexion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexion=conexionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConexion(conexion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		conexions = new  ArrayList<Conexion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexions=conexionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConexion(conexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
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
		conexions = new  ArrayList<Conexion>();
		  		  
        try {
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexions=conexionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConexion(conexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosConexionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		conexions = new  ArrayList<Conexion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getTodosConexionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexions=conexionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConexion(conexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
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
	
	public  void  getTodosConexions(String sFinalQuery,Pagination pagination)throws Exception {
		conexions = new  ArrayList<Conexion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conexions=conexionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConexion(conexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarConexion(Conexion conexion) throws Exception {
		Boolean estaValidado=false;
		
		if(conexion.getIsNew() || conexion.getIsChanged()) { 
			this.invalidValues = conexionValidator.getInvalidValues(conexion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(conexion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarConexion(List<Conexion> Conexions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Conexion conexionLocal:conexions) {				
			estaValidadoObjeto=this.validarGuardarConexion(conexionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarConexion(List<Conexion> Conexions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConexion(conexions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarConexion(Conexion Conexion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConexion(conexion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Conexion conexion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+conexion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ConexionConstantesFunciones.getConexionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"conexion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ConexionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ConexionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveConexionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-saveConexionWithConnection");connexion.begin();			
			
			ConexionLogicAdditional.checkConexionToSave(this.conexion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConexionLogicAdditional.updateConexionToSave(this.conexion,this.arrDatoGeneral);
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.conexion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowConexion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConexion(this.conexion)) {
				ConexionDataAccess.save(this.conexion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.conexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConexionLogicAdditional.checkConexionToSaveAfter(this.conexion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConexion();
			
			connexion.commit();			
			
			if(this.conexion.getIsDeleted()) {
				this.conexion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveConexion()throws Exception {	
		try {	
			
			ConexionLogicAdditional.checkConexionToSave(this.conexion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConexionLogicAdditional.updateConexionToSave(this.conexion,this.arrDatoGeneral);
			
			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.conexion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConexion(this.conexion)) {			
				ConexionDataAccess.save(this.conexion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.conexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConexionLogicAdditional.checkConexionToSaveAfter(this.conexion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.conexion.getIsDeleted()) {
				this.conexion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveConexionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-saveConexionsWithConnection");connexion.begin();			
			
			ConexionLogicAdditional.checkConexionToSaves(conexions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowConexions();
			
			Boolean validadoTodosConexion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Conexion conexionLocal:conexions) {		
				if(conexionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConexionLogicAdditional.updateConexionToSave(conexionLocal,this.arrDatoGeneral);
	        	
				ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),conexionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConexion(conexionLocal)) {
					ConexionDataAccess.save(conexionLocal, connexion);				
				} else {
					validadoTodosConexion=false;
				}
			}
			
			if(!validadoTodosConexion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConexionLogicAdditional.checkConexionToSavesAfter(conexions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConexions();
			
			connexion.commit();		
			
			this.quitarConexionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveConexions()throws Exception {				
		 try {	
			ConexionLogicAdditional.checkConexionToSaves(conexions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosConexion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Conexion conexionLocal:conexions) {				
				if(conexionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConexionLogicAdditional.updateConexionToSave(conexionLocal,this.arrDatoGeneral);
	        	
				ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),conexionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConexion(conexionLocal)) {				
					ConexionDataAccess.save(conexionLocal, connexion);				
				} else {
					validadoTodosConexion=false;
				}
			}
			
			if(!validadoTodosConexion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConexionLogicAdditional.checkConexionToSavesAfter(conexions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarConexionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConexionParameterReturnGeneral procesarAccionConexions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Conexion> conexions,ConexionParameterReturnGeneral conexionParameterGeneral)throws Exception {
		 try {	
			ConexionParameterReturnGeneral conexionReturnGeneral=new ConexionParameterReturnGeneral();
	
			ConexionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conexions,conexionParameterGeneral,conexionReturnGeneral);
			
			return conexionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConexionParameterReturnGeneral procesarAccionConexionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Conexion> conexions,ConexionParameterReturnGeneral conexionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-procesarAccionConexionsWithConnection");connexion.begin();			
			
			ConexionParameterReturnGeneral conexionReturnGeneral=new ConexionParameterReturnGeneral();
	
			ConexionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conexions,conexionParameterGeneral,conexionReturnGeneral);
			
			this.connexion.commit();
			
			return conexionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConexionParameterReturnGeneral procesarEventosConexions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Conexion> conexions,Conexion conexion,ConexionParameterReturnGeneral conexionParameterGeneral,Boolean isEsNuevoConexion,ArrayList<Classe> clases)throws Exception {
		 try {	
			ConexionParameterReturnGeneral conexionReturnGeneral=new ConexionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				conexionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConexionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,conexions,conexion,conexionParameterGeneral,conexionReturnGeneral,isEsNuevoConexion,clases);
			
			return conexionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ConexionParameterReturnGeneral procesarEventosConexionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Conexion> conexions,Conexion conexion,ConexionParameterReturnGeneral conexionParameterGeneral,Boolean isEsNuevoConexion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-procesarEventosConexionsWithConnection");connexion.begin();			
			
			ConexionParameterReturnGeneral conexionReturnGeneral=new ConexionParameterReturnGeneral();
	
			conexionReturnGeneral.setConexion(conexion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				conexionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConexionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,conexions,conexion,conexionParameterGeneral,conexionReturnGeneral,isEsNuevoConexion,clases);
			
			this.connexion.commit();
			
			return conexionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConexionParameterReturnGeneral procesarImportacionConexionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ConexionParameterReturnGeneral conexionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-procesarImportacionConexionsWithConnection");connexion.begin();			
			
			ConexionParameterReturnGeneral conexionReturnGeneral=new ConexionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.conexions=new ArrayList<Conexion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.conexion=new Conexion();
				
				
				if(conColumnasBase) {this.conexion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.conexion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.conexion.setnombre(arrColumnas[iColumn++]);
				this.conexion.setnombre_maquina(arrColumnas[iColumn++]);
				
				this.conexions.add(this.conexion);
			}
			
			this.saveConexions();
			
			this.connexion.commit();
			
			conexionReturnGeneral.setConRetornoEstaProcesado(true);
			conexionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return conexionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarConexionsEliminados() throws Exception {				
		
		List<Conexion> conexionsAux= new ArrayList<Conexion>();
		
		for(Conexion conexion:conexions) {
			if(!conexion.getIsDeleted()) {
				conexionsAux.add(conexion);
			}
		}
		
		conexions=conexionsAux;
	}
	
	public void quitarConexionsNulos() throws Exception {				
		
		List<Conexion> conexionsAux= new ArrayList<Conexion>();
		
		for(Conexion conexion : this.conexions) {
			if(conexion==null) {
				conexionsAux.add(conexion);
			}
		}
		
		//this.conexions=conexionsAux;
		
		this.conexions.removeAll(conexionsAux);
	}
	
	public void getSetVersionRowConexionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(conexion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((conexion.getIsDeleted() || (conexion.getIsChanged()&&!conexion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=conexionDataAccess.getSetVersionRowConexion(connexion,conexion.getId());
				
				if(!conexion.getVersionRow().equals(timestamp)) {	
					conexion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				conexion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowConexion()throws Exception {	
		
		if(conexion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((conexion.getIsDeleted() || (conexion.getIsChanged()&&!conexion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=conexionDataAccess.getSetVersionRowConexion(connexion,conexion.getId());
			
			try {							
				if(!conexion.getVersionRow().equals(timestamp)) {	
					conexion.setVersionRow(timestamp);
				}
				
				conexion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowConexionsWithConnection()throws Exception {	
		if(conexions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Conexion conexionAux:conexions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(conexionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(conexionAux.getIsDeleted() || (conexionAux.getIsChanged()&&!conexionAux.getIsNew())) {
						
						timestamp=conexionDataAccess.getSetVersionRowConexion(connexion,conexionAux.getId());
						
						if(!conexion.getVersionRow().equals(timestamp)) {	
							conexionAux.setVersionRow(timestamp);
						}
								
						conexionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowConexions()throws Exception {	
		if(conexions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Conexion conexionAux:conexions) {
					if(conexionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(conexionAux.getIsDeleted() || (conexionAux.getIsChanged()&&!conexionAux.getIsNew())) {
						
						timestamp=conexionDataAccess.getSetVersionRowConexion(connexion,conexionAux.getId());
						
						if(!conexionAux.getVersionRow().equals(timestamp)) {	
							conexionAux.setVersionRow(timestamp);
						}
						
													
						conexionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ConexionParameterReturnGeneral cargarCombosLoteForeignKeyConexionWithConnection(String finalQueryGlobalTipoConexion) throws Exception {
		ConexionParameterReturnGeneral  conexionReturnGeneral =new ConexionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-cargarCombosLoteForeignKeyConexionWithConnection");connexion.begin();
			
			conexionReturnGeneral =new ConexionParameterReturnGeneral();
			
			

			List<TipoConexion> tipoconexionsForeignKey=new ArrayList<TipoConexion>();
			TipoConexionLogic tipoconexionLogic=new TipoConexionLogic();
			tipoconexionLogic.setConnexion(this.connexion);
			tipoconexionLogic.getTipoConexionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoConexion.equals("NONE")) {
				tipoconexionLogic.getTodosTipoConexions(finalQueryGlobalTipoConexion,new Pagination());
				tipoconexionsForeignKey=tipoconexionLogic.getTipoConexions();
			}

			conexionReturnGeneral.settipoconexionsForeignKey(tipoconexionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return conexionReturnGeneral;
	}
	
	public ConexionParameterReturnGeneral cargarCombosLoteForeignKeyConexion(String finalQueryGlobalTipoConexion) throws Exception {
		ConexionParameterReturnGeneral  conexionReturnGeneral =new ConexionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			conexionReturnGeneral =new ConexionParameterReturnGeneral();
			
			

			List<TipoConexion> tipoconexionsForeignKey=new ArrayList<TipoConexion>();
			TipoConexionLogic tipoconexionLogic=new TipoConexionLogic();
			tipoconexionLogic.setConnexion(this.connexion);
			tipoconexionLogic.getTipoConexionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoConexion.equals("NONE")) {
				tipoconexionLogic.getTodosTipoConexions(finalQueryGlobalTipoConexion,new Pagination());
				tipoconexionsForeignKey=tipoconexionLogic.getTipoConexions();
			}

			conexionReturnGeneral.settipoconexionsForeignKey(tipoconexionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return conexionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyConexionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TarjetaCreditoConexionLogic tarjetacreditoconexionLogic=new TarjetaCreditoConexionLogic();
			NumeroRecapLogic numerorecapLogic=new NumeroRecapLogic();
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic=new FormaPagoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyConexionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TarjetaCreditoConexion.class));
			classes.add(new Classe(NumeroRecap.class));
			classes.add(new Classe(FormaPagoPuntoVenta.class));
											
			

			tarjetacreditoconexionLogic.setConnexion(this.getConnexion());
			tarjetacreditoconexionLogic.setDatosCliente(this.datosCliente);
			tarjetacreditoconexionLogic.setIsConRefrescarForeignKeys(true);

			numerorecapLogic.setConnexion(this.getConnexion());
			numerorecapLogic.setDatosCliente(this.datosCliente);
			numerorecapLogic.setIsConRefrescarForeignKeys(true);

			formapagopuntoventaLogic.setConnexion(this.getConnexion());
			formapagopuntoventaLogic.setDatosCliente(this.datosCliente);
			formapagopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Conexion conexion:this.conexions) {
				

				classes=new ArrayList<Classe>();
				classes=TarjetaCreditoConexionConstantesFunciones.getClassesForeignKeysOfTarjetaCreditoConexion(new ArrayList<Classe>(),DeepLoadType.NONE);

				tarjetacreditoconexionLogic.setTarjetaCreditoConexions(conexion.tarjetacreditoconexions);
				tarjetacreditoconexionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NumeroRecapConstantesFunciones.getClassesForeignKeysOfNumeroRecap(new ArrayList<Classe>(),DeepLoadType.NONE);

				numerorecapLogic.setNumeroRecaps(conexion.numerorecaps);
				numerorecapLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagopuntoventaLogic.setFormaPagoPuntoVentas(conexion.formapagopuntoventas);
				formapagopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Conexion conexion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConexionLogicAdditional.updateConexionToGet(conexion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conexion.setTipoConexion(conexionDataAccess.getTipoConexion(connexion,conexion));
		conexion.setTarjetaCreditoConexions(conexionDataAccess.getTarjetaCreditoConexions(connexion,conexion));
		conexion.setNumeroRecaps(conexionDataAccess.getNumeroRecaps(connexion,conexion));
		conexion.setFormaPagoPuntoVentas(conexionDataAccess.getFormaPagoPuntoVentas(connexion,conexion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoConexion.class)) {
				conexion.setTipoConexion(conexionDataAccess.getTipoConexion(connexion,conexion));
				continue;
			}

			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				conexion.setTarjetaCreditoConexions(conexionDataAccess.getTarjetaCreditoConexions(connexion,conexion));

				if(this.isConDeep) {
					TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(this.connexion);
					tarjetacreditoconexionLogic.setTarjetaCreditoConexions(conexion.getTarjetaCreditoConexions());
					ArrayList<Classe> classesLocal=TarjetaCreditoConexionConstantesFunciones.getClassesForeignKeysOfTarjetaCreditoConexion(new ArrayList<Classe>(),DeepLoadType.NONE);
					tarjetacreditoconexionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(tarjetacreditoconexionLogic.getTarjetaCreditoConexions());
					conexion.setTarjetaCreditoConexions(tarjetacreditoconexionLogic.getTarjetaCreditoConexions());
				}

				continue;
			}

			if(clas.clas.equals(NumeroRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				conexion.setNumeroRecaps(conexionDataAccess.getNumeroRecaps(connexion,conexion));

				if(this.isConDeep) {
					NumeroRecapLogic numerorecapLogic= new NumeroRecapLogic(this.connexion);
					numerorecapLogic.setNumeroRecaps(conexion.getNumeroRecaps());
					ArrayList<Classe> classesLocal=NumeroRecapConstantesFunciones.getClassesForeignKeysOfNumeroRecap(new ArrayList<Classe>(),DeepLoadType.NONE);
					numerorecapLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NumeroRecapConstantesFunciones.refrescarForeignKeysDescripcionesNumeroRecap(numerorecapLogic.getNumeroRecaps());
					conexion.setNumeroRecaps(numerorecapLogic.getNumeroRecaps());
				}

				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				conexion.setFormaPagoPuntoVentas(conexionDataAccess.getFormaPagoPuntoVentas(connexion,conexion));

				if(this.isConDeep) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(this.connexion);
					formapagopuntoventaLogic.setFormaPagoPuntoVentas(conexion.getFormaPagoPuntoVentas());
					ArrayList<Classe> classesLocal=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
					conexion.setFormaPagoPuntoVentas(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoConexion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conexion.setTipoConexion(conexionDataAccess.getTipoConexion(connexion,conexion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCreditoConexion.class));
			conexion.setTarjetaCreditoConexions(conexionDataAccess.getTarjetaCreditoConexions(connexion,conexion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NumeroRecap.class));
			conexion.setNumeroRecaps(conexionDataAccess.getNumeroRecaps(connexion,conexion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			conexion.setFormaPagoPuntoVentas(conexionDataAccess.getFormaPagoPuntoVentas(connexion,conexion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conexion.setTipoConexion(conexionDataAccess.getTipoConexion(connexion,conexion));
		TipoConexionLogic tipoconexionLogic= new TipoConexionLogic(connexion);
		tipoconexionLogic.deepLoad(conexion.getTipoConexion(),isDeep,deepLoadType,clases);
				

		conexion.setTarjetaCreditoConexions(conexionDataAccess.getTarjetaCreditoConexions(connexion,conexion));

		for(TarjetaCreditoConexion tarjetacreditoconexion:conexion.getTarjetaCreditoConexions()) {
			TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(connexion);
			tarjetacreditoconexionLogic.deepLoad(tarjetacreditoconexion,isDeep,deepLoadType,clases);
		}

		conexion.setNumeroRecaps(conexionDataAccess.getNumeroRecaps(connexion,conexion));

		for(NumeroRecap numerorecap:conexion.getNumeroRecaps()) {
			NumeroRecapLogic numerorecapLogic= new NumeroRecapLogic(connexion);
			numerorecapLogic.deepLoad(numerorecap,isDeep,deepLoadType,clases);
		}

		conexion.setFormaPagoPuntoVentas(conexionDataAccess.getFormaPagoPuntoVentas(connexion,conexion));

		for(FormaPagoPuntoVenta formapagopuntoventa:conexion.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoConexion.class)) {
				conexion.setTipoConexion(conexionDataAccess.getTipoConexion(connexion,conexion));
				TipoConexionLogic tipoconexionLogic= new TipoConexionLogic(connexion);
				tipoconexionLogic.deepLoad(conexion.getTipoConexion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				conexion.setTarjetaCreditoConexions(conexionDataAccess.getTarjetaCreditoConexions(connexion,conexion));

				for(TarjetaCreditoConexion tarjetacreditoconexion:conexion.getTarjetaCreditoConexions()) {
					TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(connexion);
					tarjetacreditoconexionLogic.deepLoad(tarjetacreditoconexion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NumeroRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				conexion.setNumeroRecaps(conexionDataAccess.getNumeroRecaps(connexion,conexion));

				for(NumeroRecap numerorecap:conexion.getNumeroRecaps()) {
					NumeroRecapLogic numerorecapLogic= new NumeroRecapLogic(connexion);
					numerorecapLogic.deepLoad(numerorecap,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				conexion.setFormaPagoPuntoVentas(conexionDataAccess.getFormaPagoPuntoVentas(connexion,conexion));

				for(FormaPagoPuntoVenta formapagopuntoventa:conexion.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoConexion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conexion.setTipoConexion(conexionDataAccess.getTipoConexion(connexion,conexion));
			TipoConexionLogic tipoconexionLogic= new TipoConexionLogic(connexion);
			tipoconexionLogic.deepLoad(conexion.getTipoConexion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCreditoConexion.class));
			conexion.setTarjetaCreditoConexions(conexionDataAccess.getTarjetaCreditoConexions(connexion,conexion));

			for(TarjetaCreditoConexion tarjetacreditoconexion:conexion.getTarjetaCreditoConexions()) {
				TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(connexion);
				tarjetacreditoconexionLogic.deepLoad(tarjetacreditoconexion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NumeroRecap.class));
			conexion.setNumeroRecaps(conexionDataAccess.getNumeroRecaps(connexion,conexion));

			for(NumeroRecap numerorecap:conexion.getNumeroRecaps()) {
				NumeroRecapLogic numerorecapLogic= new NumeroRecapLogic(connexion);
				numerorecapLogic.deepLoad(numerorecap,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			conexion.setFormaPagoPuntoVentas(conexionDataAccess.getFormaPagoPuntoVentas(connexion,conexion));

			for(FormaPagoPuntoVenta formapagopuntoventa:conexion.getFormaPagoPuntoVentas()) {
				FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
				formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Conexion conexion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ConexionLogicAdditional.updateConexionToSave(conexion,this.arrDatoGeneral);
			
ConexionDataAccess.save(conexion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TipoConexionDataAccess.save(conexion.getTipoConexion(),connexion);

		for(TarjetaCreditoConexion tarjetacreditoconexion:conexion.getTarjetaCreditoConexions()) {
			tarjetacreditoconexion.setid_conexion(conexion.getId());
			TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexion,connexion);
		}

		for(NumeroRecap numerorecap:conexion.getNumeroRecaps()) {
			numerorecap.setid_conexion(conexion.getId());
			NumeroRecapDataAccess.save(numerorecap,connexion);
		}

		for(FormaPagoPuntoVenta formapagopuntoventa:conexion.getFormaPagoPuntoVentas()) {
			formapagopuntoventa.setid_conexion(conexion.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoConexion.class)) {
				TipoConexionDataAccess.save(conexion.getTipoConexion(),connexion);
				continue;
			}


			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCreditoConexion tarjetacreditoconexion:conexion.getTarjetaCreditoConexions()) {
					tarjetacreditoconexion.setid_conexion(conexion.getId());
					TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(NumeroRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NumeroRecap numerorecap:conexion.getNumeroRecaps()) {
					numerorecap.setid_conexion(conexion.getId());
					NumeroRecapDataAccess.save(numerorecap,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:conexion.getFormaPagoPuntoVentas()) {
					formapagopuntoventa.setid_conexion(conexion.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TipoConexionDataAccess.save(conexion.getTipoConexion(),connexion);
		TipoConexionLogic tipoconexionLogic= new TipoConexionLogic(connexion);
		tipoconexionLogic.deepLoad(conexion.getTipoConexion(),isDeep,deepLoadType,clases);
				

		for(TarjetaCreditoConexion tarjetacreditoconexion:conexion.getTarjetaCreditoConexions()) {
			TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(connexion);
			tarjetacreditoconexion.setid_conexion(conexion.getId());
			TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexion,connexion);
			tarjetacreditoconexionLogic.deepSave(tarjetacreditoconexion,isDeep,deepLoadType,clases);
		}

		for(NumeroRecap numerorecap:conexion.getNumeroRecaps()) {
			NumeroRecapLogic numerorecapLogic= new NumeroRecapLogic(connexion);
			numerorecap.setid_conexion(conexion.getId());
			NumeroRecapDataAccess.save(numerorecap,connexion);
			numerorecapLogic.deepSave(numerorecap,isDeep,deepLoadType,clases);
		}

		for(FormaPagoPuntoVenta formapagopuntoventa:conexion.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventa.setid_conexion(conexion.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
			formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoConexion.class)) {
				TipoConexionDataAccess.save(conexion.getTipoConexion(),connexion);
				TipoConexionLogic tipoconexionLogic= new TipoConexionLogic(connexion);
				tipoconexionLogic.deepSave(conexion.getTipoConexion(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCreditoConexion tarjetacreditoconexion:conexion.getTarjetaCreditoConexions()) {
					TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(connexion);
					tarjetacreditoconexion.setid_conexion(conexion.getId());
					TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexion,connexion);
					tarjetacreditoconexionLogic.deepSave(tarjetacreditoconexion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NumeroRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NumeroRecap numerorecap:conexion.getNumeroRecaps()) {
					NumeroRecapLogic numerorecapLogic= new NumeroRecapLogic(connexion);
					numerorecap.setid_conexion(conexion.getId());
					NumeroRecapDataAccess.save(numerorecap,connexion);
					numerorecapLogic.deepSave(numerorecap,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:conexion.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventa.setid_conexion(conexion.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
					formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Conexion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(conexion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(conexion);
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
			this.deepLoad(this.conexion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Conexion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(conexions!=null) {
				for(Conexion conexion:conexions) {
					this.deepLoad(conexion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(conexions);
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
			if(conexions!=null) {
				for(Conexion conexion:conexions) {
					this.deepLoad(conexion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(conexions);
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
			this.getNewConnexionToDeep(Conexion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(conexion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Conexion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(conexions!=null) {
				for(Conexion conexion:conexions) {
					this.deepSave(conexion,isDeep,deepLoadType,clases);
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
			if(conexions!=null) {
				for(Conexion conexion:conexions) {
					this.deepSave(conexion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getConexionsFK_IdTipoConexionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_conexion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conexion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoConexion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoConexion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_conexion,ConexionConstantesFunciones.IDTIPOCONEXION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoConexion);

			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoConexion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conexions=conexionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConexionsFK_IdTipoConexion(String sFinalQuery,Pagination pagination,Long id_tipo_conexion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoConexion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoConexion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_conexion,ConexionConstantesFunciones.IDTIPOCONEXION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoConexion);

			ConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoConexion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conexions=conexionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConexionConstantesFunciones.refrescarForeignKeysDescripcionesConexion(this.conexions);
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
			if(ConexionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ConexionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Conexion conexion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ConexionConstantesFunciones.ISCONAUDITORIA) {
				if(conexion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConexionDataAccess.TABLENAME, conexion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConexionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConexionLogic.registrarAuditoriaDetallesConexion(connexion,conexion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(conexion.getIsDeleted()) {
					/*if(!conexion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ConexionDataAccess.TABLENAME, conexion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ConexionLogic.registrarAuditoriaDetallesConexion(connexion,conexion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConexionDataAccess.TABLENAME, conexion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(conexion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConexionDataAccess.TABLENAME, conexion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConexionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConexionLogic.registrarAuditoriaDetallesConexion(connexion,conexion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesConexion(Connexion connexion,Conexion conexion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(conexion.getIsNew()||!conexion.getid_tipo_conexion().equals(conexion.getConexionOriginal().getid_tipo_conexion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conexion.getConexionOriginal().getid_tipo_conexion()!=null)
				{
					strValorActual=conexion.getConexionOriginal().getid_tipo_conexion().toString();
				}
				if(conexion.getid_tipo_conexion()!=null)
				{
					strValorNuevo=conexion.getid_tipo_conexion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConexionConstantesFunciones.IDTIPOCONEXION,strValorActual,strValorNuevo);
			}	
			
			if(conexion.getIsNew()||!conexion.getnombre().equals(conexion.getConexionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conexion.getConexionOriginal().getnombre()!=null)
				{
					strValorActual=conexion.getConexionOriginal().getnombre();
				}
				if(conexion.getnombre()!=null)
				{
					strValorNuevo=conexion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConexionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(conexion.getIsNew()||!conexion.getnombre_maquina().equals(conexion.getConexionOriginal().getnombre_maquina()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conexion.getConexionOriginal().getnombre_maquina()!=null)
				{
					strValorActual=conexion.getConexionOriginal().getnombre_maquina();
				}
				if(conexion.getnombre_maquina()!=null)
				{
					strValorNuevo=conexion.getnombre_maquina() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConexionConstantesFunciones.NOMBREMAQUINA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveConexionRelacionesWithConnection(Conexion conexion,List<TarjetaCreditoConexion> tarjetacreditoconexions,List<NumeroRecap> numerorecaps,List<FormaPagoPuntoVenta> formapagopuntoventas) throws Exception {

		if(!conexion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConexionRelacionesBase(conexion,tarjetacreditoconexions,numerorecaps,formapagopuntoventas,true);
		}
	}

	public void saveConexionRelaciones(Conexion conexion,List<TarjetaCreditoConexion> tarjetacreditoconexions,List<NumeroRecap> numerorecaps,List<FormaPagoPuntoVenta> formapagopuntoventas)throws Exception {

		if(!conexion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConexionRelacionesBase(conexion,tarjetacreditoconexions,numerorecaps,formapagopuntoventas,false);
		}
	}

	public void saveConexionRelacionesBase(Conexion conexion,List<TarjetaCreditoConexion> tarjetacreditoconexions,List<NumeroRecap> numerorecaps,List<FormaPagoPuntoVenta> formapagopuntoventas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Conexion-saveRelacionesWithConnection");}
	
			conexion.setTarjetaCreditoConexions(tarjetacreditoconexions);
			conexion.setNumeroRecaps(numerorecaps);
			conexion.setFormaPagoPuntoVentas(formapagopuntoventas);

			this.setConexion(conexion);

			if(ConexionLogicAdditional.validarSaveRelaciones(conexion,this)) {

				ConexionLogicAdditional.updateRelacionesToSave(conexion,this);

				if((conexion.getIsNew()||conexion.getIsChanged())&&!conexion.getIsDeleted()) {
					this.saveConexion();
					this.saveConexionRelacionesDetalles(tarjetacreditoconexions,numerorecaps,formapagopuntoventas);

				} else if(conexion.getIsDeleted()) {
					this.saveConexionRelacionesDetalles(tarjetacreditoconexions,numerorecaps,formapagopuntoventas);
					this.saveConexion();
				}

				ConexionLogicAdditional.updateRelacionesToSaveAfter(conexion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TarjetaCreditoConexionConstantesFunciones.InicializarGeneralEntityAuxiliaresTarjetaCreditoConexions(tarjetacreditoconexions,true,true);
			NumeroRecapConstantesFunciones.InicializarGeneralEntityAuxiliaresNumeroRecaps(numerorecaps,true,true);
			FormaPagoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresFormaPagoPuntoVentas(formapagopuntoventas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveConexionRelacionesDetalles(List<TarjetaCreditoConexion> tarjetacreditoconexions,List<NumeroRecap> numerorecaps,List<FormaPagoPuntoVenta> formapagopuntoventas)throws Exception {
		try {
	

			Long idConexionActual=this.getConexion().getId();

			TarjetaCreditoConexionLogic tarjetacreditoconexionLogic_Desde_Conexion=new TarjetaCreditoConexionLogic();
			tarjetacreditoconexionLogic_Desde_Conexion.setTarjetaCreditoConexions(tarjetacreditoconexions);

			tarjetacreditoconexionLogic_Desde_Conexion.setConnexion(this.getConnexion());
			tarjetacreditoconexionLogic_Desde_Conexion.setDatosCliente(this.datosCliente);

			for(TarjetaCreditoConexion tarjetacreditoconexion_Desde_Conexion:tarjetacreditoconexionLogic_Desde_Conexion.getTarjetaCreditoConexions()) {
				tarjetacreditoconexion_Desde_Conexion.setid_conexion(idConexionActual);
			}

			tarjetacreditoconexionLogic_Desde_Conexion.saveTarjetaCreditoConexions();

			NumeroRecapLogic numerorecapLogic_Desde_Conexion=new NumeroRecapLogic();
			numerorecapLogic_Desde_Conexion.setNumeroRecaps(numerorecaps);

			numerorecapLogic_Desde_Conexion.setConnexion(this.getConnexion());
			numerorecapLogic_Desde_Conexion.setDatosCliente(this.datosCliente);

			for(NumeroRecap numerorecap_Desde_Conexion:numerorecapLogic_Desde_Conexion.getNumeroRecaps()) {
				numerorecap_Desde_Conexion.setid_conexion(idConexionActual);
			}

			numerorecapLogic_Desde_Conexion.saveNumeroRecaps();

			FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_Conexion=new FormaPagoPuntoVentaLogic();
			formapagopuntoventaLogic_Desde_Conexion.setFormaPagoPuntoVentas(formapagopuntoventas);

			formapagopuntoventaLogic_Desde_Conexion.setConnexion(this.getConnexion());
			formapagopuntoventaLogic_Desde_Conexion.setDatosCliente(this.datosCliente);

			for(FormaPagoPuntoVenta formapagopuntoventa_Desde_Conexion:formapagopuntoventaLogic_Desde_Conexion.getFormaPagoPuntoVentas()) {
				formapagopuntoventa_Desde_Conexion.setid_conexion(idConexionActual);
			}

			formapagopuntoventaLogic_Desde_Conexion.saveFormaPagoPuntoVentas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConexionConstantesFunciones.getClassesForeignKeysOfConexion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConexionConstantesFunciones.getClassesRelationshipsOfConexion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

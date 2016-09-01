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
package com.bydan.erp.comisiones.business.logic;

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
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.comisiones.util.ComisionPenaConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionPenaParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionPenaParameterGeneral;
import com.bydan.erp.comisiones.business.entity.ComisionPena;
import com.bydan.erp.comisiones.business.logic.ComisionPenaLogicAdditional;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.comisiones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ComisionPenaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ComisionPenaLogic.class);
	
	protected ComisionPenaDataAccess comisionpenaDataAccess; 	
	protected ComisionPena comisionpena;
	protected List<ComisionPena> comisionpenas;
	protected Object comisionpenaObject;	
	protected List<Object> comisionpenasObject;
	
	public static ClassValidator<ComisionPena> comisionpenaValidator = new ClassValidator<ComisionPena>(ComisionPena.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ComisionPenaLogicAdditional comisionpenaLogicAdditional=null;
	
	public ComisionPenaLogicAdditional getComisionPenaLogicAdditional() {
		return this.comisionpenaLogicAdditional;
	}
	
	public void setComisionPenaLogicAdditional(ComisionPenaLogicAdditional comisionpenaLogicAdditional) {
		try {
			this.comisionpenaLogicAdditional=comisionpenaLogicAdditional;
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
	
	
	
	
	public  ComisionPenaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.comisionpenaDataAccess = new ComisionPenaDataAccess();
			
			this.comisionpenas= new ArrayList<ComisionPena>();
			this.comisionpena= new ComisionPena();
			
			this.comisionpenaObject=new Object();
			this.comisionpenasObject=new ArrayList<Object>();
				
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
			
			this.comisionpenaDataAccess.setConnexionType(this.connexionType);
			this.comisionpenaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComisionPenaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.comisionpenaDataAccess = new ComisionPenaDataAccess();
			this.comisionpenas= new ArrayList<ComisionPena>();
			this.comisionpena= new ComisionPena();
			this.comisionpenaObject=new Object();
			this.comisionpenasObject=new ArrayList<Object>();
			
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
			
			this.comisionpenaDataAccess.setConnexionType(this.connexionType);
			this.comisionpenaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComisionPena getComisionPena() throws Exception {	
		ComisionPenaLogicAdditional.checkComisionPenaToGet(comisionpena,this.datosCliente,this.arrDatoGeneral);
		ComisionPenaLogicAdditional.updateComisionPenaToGet(comisionpena,this.arrDatoGeneral);
		
		return comisionpena;
	}
		
	public void setComisionPena(ComisionPena newComisionPena) {
		this.comisionpena = newComisionPena;
	}
	
	public ComisionPenaDataAccess getComisionPenaDataAccess() {
		return comisionpenaDataAccess;
	}
	
	public void setComisionPenaDataAccess(ComisionPenaDataAccess newcomisionpenaDataAccess) {
		this.comisionpenaDataAccess = newcomisionpenaDataAccess;
	}
	
	public List<ComisionPena> getComisionPenas() throws Exception {		
		this.quitarComisionPenasNulos();
		
		ComisionPenaLogicAdditional.checkComisionPenaToGets(comisionpenas,this.datosCliente,this.arrDatoGeneral);
		
		for (ComisionPena comisionpenaLocal: comisionpenas ) {
			ComisionPenaLogicAdditional.updateComisionPenaToGet(comisionpenaLocal,this.arrDatoGeneral);
		}
		
		return comisionpenas;
	}
	
	public void setComisionPenas(List<ComisionPena> newComisionPenas) {
		this.comisionpenas = newComisionPenas;
	}
	
	public Object getComisionPenaObject() {	
		this.comisionpenaObject=this.comisionpenaDataAccess.getEntityObject();
		return this.comisionpenaObject;
	}
		
	public void setComisionPenaObject(Object newComisionPenaObject) {
		this.comisionpenaObject = newComisionPenaObject;
	}
	
	public List<Object> getComisionPenasObject() {		
		this.comisionpenasObject=this.comisionpenaDataAccess.getEntitiesObject();
		return this.comisionpenasObject;
	}
		
	public void setComisionPenasObject(List<Object> newComisionPenasObject) {
		this.comisionpenasObject = newComisionPenasObject;
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
		
		if(this.comisionpenaDataAccess!=null) {
			this.comisionpenaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			comisionpenaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			comisionpenaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		comisionpena = new  ComisionPena();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisionpena=comisionpenaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionpena,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpena);
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
		comisionpena = new  ComisionPena();
		  		  
        try {
			
			comisionpena=comisionpenaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionpena,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpena);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		comisionpena = new  ComisionPena();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisionpena=comisionpenaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionpena,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpena);
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
		comisionpena = new  ComisionPena();
		  		  
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
		comisionpena = new  ComisionPena();
		  		  
        try {
			
			comisionpena=comisionpenaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionpena,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpena);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		comisionpena = new  ComisionPena();
		  		  
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
		comisionpena = new  ComisionPena();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =comisionpenaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionpena = new  ComisionPena();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=comisionpenaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionpena = new  ComisionPena();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =comisionpenaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionpena = new  ComisionPena();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=comisionpenaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionpena = new  ComisionPena();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =comisionpenaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		comisionpena = new  ComisionPena();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=comisionpenaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionpenas = new  ArrayList<ComisionPena>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpenas=comisionpenaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionPena(comisionpenas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
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
		comisionpenas = new  ArrayList<ComisionPena>();
		  		  
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
		comisionpenas = new  ArrayList<ComisionPena>();
		  		  
        try {			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpenas=comisionpenaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarComisionPena(comisionpenas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		comisionpenas = new  ArrayList<ComisionPena>();
		  		  
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
		comisionpenas = new  ArrayList<ComisionPena>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpenas=comisionpenaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionPena(comisionpenas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
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
		comisionpenas = new  ArrayList<ComisionPena>();
		  		  
        try {
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpenas=comisionpenaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionPena(comisionpenas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
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
		comisionpenas = new  ArrayList<ComisionPena>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpenas=comisionpenaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionPena(comisionpenas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
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
		comisionpenas = new  ArrayList<ComisionPena>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpenas=comisionpenaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionPena(comisionpenas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		comisionpena = new  ComisionPena();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpena=comisionpenaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionPena(comisionpena);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpena);
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
		comisionpena = new  ComisionPena();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpena=comisionpenaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionPena(comisionpena);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpena);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionpenas = new  ArrayList<ComisionPena>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpenas=comisionpenaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionPena(comisionpenas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
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
		comisionpenas = new  ArrayList<ComisionPena>();
		  		  
        try {
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpenas=comisionpenaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionPena(comisionpenas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosComisionPenasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		comisionpenas = new  ArrayList<ComisionPena>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getTodosComisionPenasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpenas=comisionpenaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionPena(comisionpenas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
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
	
	public  void  getTodosComisionPenas(String sFinalQuery,Pagination pagination)throws Exception {
		comisionpenas = new  ArrayList<ComisionPena>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionpenas=comisionpenaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionPena(comisionpenas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarComisionPena(ComisionPena comisionpena) throws Exception {
		Boolean estaValidado=false;
		
		if(comisionpena.getIsNew() || comisionpena.getIsChanged()) { 
			this.invalidValues = comisionpenaValidator.getInvalidValues(comisionpena);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(comisionpena);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarComisionPena(List<ComisionPena> ComisionPenas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ComisionPena comisionpenaLocal:comisionpenas) {				
			estaValidadoObjeto=this.validarGuardarComisionPena(comisionpenaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarComisionPena(List<ComisionPena> ComisionPenas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionPena(comisionpenas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarComisionPena(ComisionPena ComisionPena) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionPena(comisionpena)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ComisionPena comisionpena) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+comisionpena.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ComisionPenaConstantesFunciones.getComisionPenaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"comisionpena","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ComisionPenaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ComisionPenaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveComisionPenaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-saveComisionPenaWithConnection");connexion.begin();			
			
			ComisionPenaLogicAdditional.checkComisionPenaToSave(this.comisionpena,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionPenaLogicAdditional.updateComisionPenaToSave(this.comisionpena,this.arrDatoGeneral);
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisionpena,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowComisionPena();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionPena(this.comisionpena)) {
				ComisionPenaDataAccess.save(this.comisionpena, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.comisionpena,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionPenaLogicAdditional.checkComisionPenaToSaveAfter(this.comisionpena,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionPena();
			
			connexion.commit();			
			
			if(this.comisionpena.getIsDeleted()) {
				this.comisionpena=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveComisionPena()throws Exception {	
		try {	
			
			ComisionPenaLogicAdditional.checkComisionPenaToSave(this.comisionpena,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionPenaLogicAdditional.updateComisionPenaToSave(this.comisionpena,this.arrDatoGeneral);
			
			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisionpena,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionPena(this.comisionpena)) {			
				ComisionPenaDataAccess.save(this.comisionpena, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.comisionpena,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionPenaLogicAdditional.checkComisionPenaToSaveAfter(this.comisionpena,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.comisionpena.getIsDeleted()) {
				this.comisionpena=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveComisionPenasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-saveComisionPenasWithConnection");connexion.begin();			
			
			ComisionPenaLogicAdditional.checkComisionPenaToSaves(comisionpenas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowComisionPenas();
			
			Boolean validadoTodosComisionPena=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionPena comisionpenaLocal:comisionpenas) {		
				if(comisionpenaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionPenaLogicAdditional.updateComisionPenaToSave(comisionpenaLocal,this.arrDatoGeneral);
	        	
				ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisionpenaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionPena(comisionpenaLocal)) {
					ComisionPenaDataAccess.save(comisionpenaLocal, connexion);				
				} else {
					validadoTodosComisionPena=false;
				}
			}
			
			if(!validadoTodosComisionPena) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionPenaLogicAdditional.checkComisionPenaToSavesAfter(comisionpenas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionPenas();
			
			connexion.commit();		
			
			this.quitarComisionPenasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveComisionPenas()throws Exception {				
		 try {	
			ComisionPenaLogicAdditional.checkComisionPenaToSaves(comisionpenas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosComisionPena=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionPena comisionpenaLocal:comisionpenas) {				
				if(comisionpenaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionPenaLogicAdditional.updateComisionPenaToSave(comisionpenaLocal,this.arrDatoGeneral);
	        	
				ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisionpenaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionPena(comisionpenaLocal)) {				
					ComisionPenaDataAccess.save(comisionpenaLocal, connexion);				
				} else {
					validadoTodosComisionPena=false;
				}
			}
			
			if(!validadoTodosComisionPena) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionPenaLogicAdditional.checkComisionPenaToSavesAfter(comisionpenas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarComisionPenasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionPenaParameterReturnGeneral procesarAccionComisionPenas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionPena> comisionpenas,ComisionPenaParameterReturnGeneral comisionpenaParameterGeneral)throws Exception {
		 try {	
			ComisionPenaParameterReturnGeneral comisionpenaReturnGeneral=new ComisionPenaParameterReturnGeneral();
	
			ComisionPenaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisionpenas,comisionpenaParameterGeneral,comisionpenaReturnGeneral);
			
			return comisionpenaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionPenaParameterReturnGeneral procesarAccionComisionPenasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionPena> comisionpenas,ComisionPenaParameterReturnGeneral comisionpenaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-procesarAccionComisionPenasWithConnection");connexion.begin();			
			
			ComisionPenaParameterReturnGeneral comisionpenaReturnGeneral=new ComisionPenaParameterReturnGeneral();
	
			ComisionPenaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisionpenas,comisionpenaParameterGeneral,comisionpenaReturnGeneral);
			
			this.connexion.commit();
			
			return comisionpenaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionPenaParameterReturnGeneral procesarEventosComisionPenas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionPena> comisionpenas,ComisionPena comisionpena,ComisionPenaParameterReturnGeneral comisionpenaParameterGeneral,Boolean isEsNuevoComisionPena,ArrayList<Classe> clases)throws Exception {
		 try {	
			ComisionPenaParameterReturnGeneral comisionpenaReturnGeneral=new ComisionPenaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisionpenaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionPenaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisionpenas,comisionpena,comisionpenaParameterGeneral,comisionpenaReturnGeneral,isEsNuevoComisionPena,clases);
			
			return comisionpenaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ComisionPenaParameterReturnGeneral procesarEventosComisionPenasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionPena> comisionpenas,ComisionPena comisionpena,ComisionPenaParameterReturnGeneral comisionpenaParameterGeneral,Boolean isEsNuevoComisionPena,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-procesarEventosComisionPenasWithConnection");connexion.begin();			
			
			ComisionPenaParameterReturnGeneral comisionpenaReturnGeneral=new ComisionPenaParameterReturnGeneral();
	
			comisionpenaReturnGeneral.setComisionPena(comisionpena);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisionpenaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionPenaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisionpenas,comisionpena,comisionpenaParameterGeneral,comisionpenaReturnGeneral,isEsNuevoComisionPena,clases);
			
			this.connexion.commit();
			
			return comisionpenaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionPenaParameterReturnGeneral procesarImportacionComisionPenasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ComisionPenaParameterReturnGeneral comisionpenaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-procesarImportacionComisionPenasWithConnection");connexion.begin();			
			
			ComisionPenaParameterReturnGeneral comisionpenaReturnGeneral=new ComisionPenaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.comisionpenas=new ArrayList<ComisionPena>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.comisionpena=new ComisionPena();
				
				
				if(conColumnasBase) {this.comisionpena.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.comisionpena.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.comisionpena.setnum_dias_inicio(Integer.parseInt(arrColumnas[iColumn++]));
				this.comisionpena.setnum_dias_fin(Integer.parseInt(arrColumnas[iColumn++]));
				this.comisionpena.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.comisionpena.setdescripcion(arrColumnas[iColumn++]);
				
				this.comisionpenas.add(this.comisionpena);
			}
			
			this.saveComisionPenas();
			
			this.connexion.commit();
			
			comisionpenaReturnGeneral.setConRetornoEstaProcesado(true);
			comisionpenaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return comisionpenaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarComisionPenasEliminados() throws Exception {				
		
		List<ComisionPena> comisionpenasAux= new ArrayList<ComisionPena>();
		
		for(ComisionPena comisionpena:comisionpenas) {
			if(!comisionpena.getIsDeleted()) {
				comisionpenasAux.add(comisionpena);
			}
		}
		
		comisionpenas=comisionpenasAux;
	}
	
	public void quitarComisionPenasNulos() throws Exception {				
		
		List<ComisionPena> comisionpenasAux= new ArrayList<ComisionPena>();
		
		for(ComisionPena comisionpena : this.comisionpenas) {
			if(comisionpena==null) {
				comisionpenasAux.add(comisionpena);
			}
		}
		
		//this.comisionpenas=comisionpenasAux;
		
		this.comisionpenas.removeAll(comisionpenasAux);
	}
	
	public void getSetVersionRowComisionPenaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(comisionpena.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((comisionpena.getIsDeleted() || (comisionpena.getIsChanged()&&!comisionpena.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=comisionpenaDataAccess.getSetVersionRowComisionPena(connexion,comisionpena.getId());
				
				if(!comisionpena.getVersionRow().equals(timestamp)) {	
					comisionpena.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				comisionpena.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowComisionPena()throws Exception {	
		
		if(comisionpena.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((comisionpena.getIsDeleted() || (comisionpena.getIsChanged()&&!comisionpena.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=comisionpenaDataAccess.getSetVersionRowComisionPena(connexion,comisionpena.getId());
			
			try {							
				if(!comisionpena.getVersionRow().equals(timestamp)) {	
					comisionpena.setVersionRow(timestamp);
				}
				
				comisionpena.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowComisionPenasWithConnection()throws Exception {	
		if(comisionpenas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ComisionPena comisionpenaAux:comisionpenas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(comisionpenaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisionpenaAux.getIsDeleted() || (comisionpenaAux.getIsChanged()&&!comisionpenaAux.getIsNew())) {
						
						timestamp=comisionpenaDataAccess.getSetVersionRowComisionPena(connexion,comisionpenaAux.getId());
						
						if(!comisionpena.getVersionRow().equals(timestamp)) {	
							comisionpenaAux.setVersionRow(timestamp);
						}
								
						comisionpenaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowComisionPenas()throws Exception {	
		if(comisionpenas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ComisionPena comisionpenaAux:comisionpenas) {
					if(comisionpenaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisionpenaAux.getIsDeleted() || (comisionpenaAux.getIsChanged()&&!comisionpenaAux.getIsNew())) {
						
						timestamp=comisionpenaDataAccess.getSetVersionRowComisionPena(connexion,comisionpenaAux.getId());
						
						if(!comisionpenaAux.getVersionRow().equals(timestamp)) {	
							comisionpenaAux.setVersionRow(timestamp);
						}
						
													
						comisionpenaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ComisionPenaParameterReturnGeneral cargarCombosLoteForeignKeyComisionPenaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalComisionConfig) throws Exception {
		ComisionPenaParameterReturnGeneral  comisionpenaReturnGeneral =new ComisionPenaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-cargarCombosLoteForeignKeyComisionPenaWithConnection");connexion.begin();
			
			comisionpenaReturnGeneral =new ComisionPenaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisionpenaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ComisionConfig> comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
			comisionconfigLogic.setConnexion(this.connexion);
			comisionconfigLogic.getComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalComisionConfig.equals("NONE")) {
				comisionconfigLogic.getTodosComisionConfigs(finalQueryGlobalComisionConfig,new Pagination());
				comisionconfigsForeignKey=comisionconfigLogic.getComisionConfigs();
			}

			comisionpenaReturnGeneral.setcomisionconfigsForeignKey(comisionconfigsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return comisionpenaReturnGeneral;
	}
	
	public ComisionPenaParameterReturnGeneral cargarCombosLoteForeignKeyComisionPena(String finalQueryGlobalEmpresa,String finalQueryGlobalComisionConfig) throws Exception {
		ComisionPenaParameterReturnGeneral  comisionpenaReturnGeneral =new ComisionPenaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			comisionpenaReturnGeneral =new ComisionPenaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisionpenaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ComisionConfig> comisionconfigsForeignKey=new ArrayList<ComisionConfig>();
			ComisionConfigLogic comisionconfigLogic=new ComisionConfigLogic();
			comisionconfigLogic.setConnexion(this.connexion);
			comisionconfigLogic.getComisionConfigDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalComisionConfig.equals("NONE")) {
				comisionconfigLogic.getTodosComisionConfigs(finalQueryGlobalComisionConfig,new Pagination());
				comisionconfigsForeignKey=comisionconfigLogic.getComisionConfigs();
			}

			comisionpenaReturnGeneral.setcomisionconfigsForeignKey(comisionconfigsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return comisionpenaReturnGeneral;
	}
	
	
	public void deepLoad(ComisionPena comisionpena,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComisionPenaLogicAdditional.updateComisionPenaToGet(comisionpena,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisionpena.setEmpresa(comisionpenaDataAccess.getEmpresa(connexion,comisionpena));
		comisionpena.setComisionConfig(comisionpenaDataAccess.getComisionConfig(connexion,comisionpena));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisionpena.setEmpresa(comisionpenaDataAccess.getEmpresa(connexion,comisionpena));
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				comisionpena.setComisionConfig(comisionpenaDataAccess.getComisionConfig(connexion,comisionpena));
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
			comisionpena.setEmpresa(comisionpenaDataAccess.getEmpresa(connexion,comisionpena));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionpena.setComisionConfig(comisionpenaDataAccess.getComisionConfig(connexion,comisionpena));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisionpena.setEmpresa(comisionpenaDataAccess.getEmpresa(connexion,comisionpena));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisionpena.getEmpresa(),isDeep,deepLoadType,clases);
				
		comisionpena.setComisionConfig(comisionpenaDataAccess.getComisionConfig(connexion,comisionpena));
		ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
		comisionconfigLogic.deepLoad(comisionpena.getComisionConfig(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisionpena.setEmpresa(comisionpenaDataAccess.getEmpresa(connexion,comisionpena));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comisionpena.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				comisionpena.setComisionConfig(comisionpenaDataAccess.getComisionConfig(connexion,comisionpena));
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepLoad(comisionpena.getComisionConfig(),isDeep,deepLoadType,clases);				
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
			comisionpena.setEmpresa(comisionpenaDataAccess.getEmpresa(connexion,comisionpena));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comisionpena.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ComisionConfig.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionpena.setComisionConfig(comisionpenaDataAccess.getComisionConfig(connexion,comisionpena));
			ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
			comisionconfigLogic.deepLoad(comisionpena.getComisionConfig(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ComisionPena comisionpena,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ComisionPenaLogicAdditional.updateComisionPenaToSave(comisionpena,this.arrDatoGeneral);
			
ComisionPenaDataAccess.save(comisionpena, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisionpena.getEmpresa(),connexion);

		ComisionConfigDataAccess.save(comisionpena.getComisionConfig(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisionpena.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				ComisionConfigDataAccess.save(comisionpena.getComisionConfig(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisionpena.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisionpena.getEmpresa(),isDeep,deepLoadType,clases);
				

		ComisionConfigDataAccess.save(comisionpena.getComisionConfig(),connexion);
		ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
		comisionconfigLogic.deepLoad(comisionpena.getComisionConfig(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisionpena.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(comisionpena.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ComisionConfig.class)) {
				ComisionConfigDataAccess.save(comisionpena.getComisionConfig(),connexion);
				ComisionConfigLogic comisionconfigLogic= new ComisionConfigLogic(connexion);
				comisionconfigLogic.deepSave(comisionpena.getComisionConfig(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ComisionPena.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(comisionpena,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(comisionpena);
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
			this.deepLoad(this.comisionpena,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpena);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ComisionPena.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(comisionpenas!=null) {
				for(ComisionPena comisionpena:comisionpenas) {
					this.deepLoad(comisionpena,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(comisionpenas);
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
			if(comisionpenas!=null) {
				for(ComisionPena comisionpena:comisionpenas) {
					this.deepLoad(comisionpena,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(comisionpenas);
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
			this.getNewConnexionToDeep(ComisionPena.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(comisionpena,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ComisionPena.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(comisionpenas!=null) {
				for(ComisionPena comisionpena:comisionpenas) {
					this.deepSave(comisionpena,isDeep,deepLoadType,clases);
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
			if(comisionpenas!=null) {
				for(ComisionPena comisionpena:comisionpenas) {
					this.deepSave(comisionpena,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getComisionPenasFK_IdComisionConfigWithConnection(String sFinalQuery,Pagination pagination,Long id_comision_config)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_comision_config,ComisionPenaConstantesFunciones.IDCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidComisionConfig);

			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionpenas=comisionpenaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionPenasFK_IdComisionConfig(String sFinalQuery,Pagination pagination,Long id_comision_config)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidComisionConfig= new ParameterSelectionGeneral();
			parameterSelectionGeneralidComisionConfig.setParameterSelectionGeneralEqual(ParameterType.LONG,id_comision_config,ComisionPenaConstantesFunciones.IDCOMISIONCONFIG,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidComisionConfig);

			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdComisionConfig","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionpenas=comisionpenaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionPenasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionPena.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionPenaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionpenas=comisionpenaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionPenasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionPenaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionPenaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionpenas=comisionpenaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionPenaConstantesFunciones.refrescarForeignKeysDescripcionesComisionPena(this.comisionpenas);
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
			if(ComisionPenaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionPenaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ComisionPena comisionpena,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ComisionPenaConstantesFunciones.ISCONAUDITORIA) {
				if(comisionpena.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionPenaDataAccess.TABLENAME, comisionpena.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionPenaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionPenaLogic.registrarAuditoriaDetallesComisionPena(connexion,comisionpena,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(comisionpena.getIsDeleted()) {
					/*if(!comisionpena.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ComisionPenaDataAccess.TABLENAME, comisionpena.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ComisionPenaLogic.registrarAuditoriaDetallesComisionPena(connexion,comisionpena,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionPenaDataAccess.TABLENAME, comisionpena.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(comisionpena.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionPenaDataAccess.TABLENAME, comisionpena.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionPenaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionPenaLogic.registrarAuditoriaDetallesComisionPena(connexion,comisionpena,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesComisionPena(Connexion connexion,ComisionPena comisionpena)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(comisionpena.getIsNew()||!comisionpena.getid_empresa().equals(comisionpena.getComisionPenaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionpena.getComisionPenaOriginal().getid_empresa()!=null)
				{
					strValorActual=comisionpena.getComisionPenaOriginal().getid_empresa().toString();
				}
				if(comisionpena.getid_empresa()!=null)
				{
					strValorNuevo=comisionpena.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionPenaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(comisionpena.getIsNew()||!comisionpena.getid_comision_config().equals(comisionpena.getComisionPenaOriginal().getid_comision_config()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionpena.getComisionPenaOriginal().getid_comision_config()!=null)
				{
					strValorActual=comisionpena.getComisionPenaOriginal().getid_comision_config().toString();
				}
				if(comisionpena.getid_comision_config()!=null)
				{
					strValorNuevo=comisionpena.getid_comision_config().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionPenaConstantesFunciones.IDCOMISIONCONFIG,strValorActual,strValorNuevo);
			}	
			
			if(comisionpena.getIsNew()||!comisionpena.getnum_dias_inicio().equals(comisionpena.getComisionPenaOriginal().getnum_dias_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionpena.getComisionPenaOriginal().getnum_dias_inicio()!=null)
				{
					strValorActual=comisionpena.getComisionPenaOriginal().getnum_dias_inicio().toString();
				}
				if(comisionpena.getnum_dias_inicio()!=null)
				{
					strValorNuevo=comisionpena.getnum_dias_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionPenaConstantesFunciones.NUMDIASINICIO,strValorActual,strValorNuevo);
			}	
			
			if(comisionpena.getIsNew()||!comisionpena.getnum_dias_fin().equals(comisionpena.getComisionPenaOriginal().getnum_dias_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionpena.getComisionPenaOriginal().getnum_dias_fin()!=null)
				{
					strValorActual=comisionpena.getComisionPenaOriginal().getnum_dias_fin().toString();
				}
				if(comisionpena.getnum_dias_fin()!=null)
				{
					strValorNuevo=comisionpena.getnum_dias_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionPenaConstantesFunciones.NUMDIASFIN,strValorActual,strValorNuevo);
			}	
			
			if(comisionpena.getIsNew()||!comisionpena.getporcentaje().equals(comisionpena.getComisionPenaOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionpena.getComisionPenaOriginal().getporcentaje()!=null)
				{
					strValorActual=comisionpena.getComisionPenaOriginal().getporcentaje().toString();
				}
				if(comisionpena.getporcentaje()!=null)
				{
					strValorNuevo=comisionpena.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionPenaConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(comisionpena.getIsNew()||!comisionpena.getdescripcion().equals(comisionpena.getComisionPenaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionpena.getComisionPenaOriginal().getdescripcion()!=null)
				{
					strValorActual=comisionpena.getComisionPenaOriginal().getdescripcion();
				}
				if(comisionpena.getdescripcion()!=null)
				{
					strValorNuevo=comisionpena.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionPenaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveComisionPenaRelacionesWithConnection(ComisionPena comisionpena) throws Exception {

		if(!comisionpena.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionPenaRelacionesBase(comisionpena,true);
		}
	}

	public void saveComisionPenaRelaciones(ComisionPena comisionpena)throws Exception {

		if(!comisionpena.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionPenaRelacionesBase(comisionpena,false);
		}
	}

	public void saveComisionPenaRelacionesBase(ComisionPena comisionpena,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ComisionPena-saveRelacionesWithConnection");}
	

			this.setComisionPena(comisionpena);

			if(ComisionPenaLogicAdditional.validarSaveRelaciones(comisionpena,this)) {

				ComisionPenaLogicAdditional.updateRelacionesToSave(comisionpena,this);

				if((comisionpena.getIsNew()||comisionpena.getIsChanged())&&!comisionpena.getIsDeleted()) {
					this.saveComisionPena();
					this.saveComisionPenaRelacionesDetalles();

				} else if(comisionpena.getIsDeleted()) {
					this.saveComisionPenaRelacionesDetalles();
					this.saveComisionPena();
				}

				ComisionPenaLogicAdditional.updateRelacionesToSaveAfter(comisionpena,this);

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
	
	
	private void saveComisionPenaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfComisionPena(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionPenaConstantesFunciones.getClassesForeignKeysOfComisionPena(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionPena(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionPenaConstantesFunciones.getClassesRelationshipsOfComisionPena(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

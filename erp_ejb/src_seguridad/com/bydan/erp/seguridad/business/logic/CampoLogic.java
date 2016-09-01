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
import com.bydan.erp.seguridad.util.CampoConstantesFunciones;
import com.bydan.erp.seguridad.util.CampoParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.CampoParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Campo;
import com.bydan.erp.seguridad.business.logic.CampoLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class CampoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CampoLogic.class);
	
	protected CampoDataAccess campoDataAccess; 	
	protected Campo campo;
	protected List<Campo> campos;
	protected Object campoObject;	
	protected List<Object> camposObject;
	
	public static ClassValidator<Campo> campoValidator = new ClassValidator<Campo>(Campo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CampoLogicAdditional campoLogicAdditional=null;
	
	public CampoLogicAdditional getCampoLogicAdditional() {
		return this.campoLogicAdditional;
	}
	
	public void setCampoLogicAdditional(CampoLogicAdditional campoLogicAdditional) {
		try {
			this.campoLogicAdditional=campoLogicAdditional;
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
	
	
	
	
	public  CampoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.campoDataAccess = new CampoDataAccess();
			
			this.campos= new ArrayList<Campo>();
			this.campo= new Campo();
			
			this.campoObject=new Object();
			this.camposObject=new ArrayList<Object>();
				
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
			
			this.campoDataAccess.setConnexionType(this.connexionType);
			this.campoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CampoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.campoDataAccess = new CampoDataAccess();
			this.campos= new ArrayList<Campo>();
			this.campo= new Campo();
			this.campoObject=new Object();
			this.camposObject=new ArrayList<Object>();
			
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
			
			this.campoDataAccess.setConnexionType(this.connexionType);
			this.campoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Campo getCampo() throws Exception {	
		CampoLogicAdditional.checkCampoToGet(campo,this.datosCliente,this.arrDatoGeneral);
		CampoLogicAdditional.updateCampoToGet(campo,this.arrDatoGeneral);
		
		return campo;
	}
		
	public void setCampo(Campo newCampo) {
		this.campo = newCampo;
	}
	
	public CampoDataAccess getCampoDataAccess() {
		return campoDataAccess;
	}
	
	public void setCampoDataAccess(CampoDataAccess newcampoDataAccess) {
		this.campoDataAccess = newcampoDataAccess;
	}
	
	public List<Campo> getCampos() throws Exception {		
		this.quitarCamposNulos();
		
		CampoLogicAdditional.checkCampoToGets(campos,this.datosCliente,this.arrDatoGeneral);
		
		for (Campo campoLocal: campos ) {
			CampoLogicAdditional.updateCampoToGet(campoLocal,this.arrDatoGeneral);
		}
		
		return campos;
	}
	
	public void setCampos(List<Campo> newCampos) {
		this.campos = newCampos;
	}
	
	public Object getCampoObject() {	
		this.campoObject=this.campoDataAccess.getEntityObject();
		return this.campoObject;
	}
		
	public void setCampoObject(Object newCampoObject) {
		this.campoObject = newCampoObject;
	}
	
	public List<Object> getCamposObject() {		
		this.camposObject=this.campoDataAccess.getEntitiesObject();
		return this.camposObject;
	}
		
	public void setCamposObject(List<Object> newCamposObject) {
		this.camposObject = newCamposObject;
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
		
		if(this.campoDataAccess!=null) {
			this.campoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			campoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			campoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		campo = new  Campo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			campo=campoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.campo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campo);
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
		campo = new  Campo();
		  		  
        try {
			
			campo=campoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.campo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		campo = new  Campo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			campo=campoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.campo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campo);
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
		campo = new  Campo();
		  		  
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
		campo = new  Campo();
		  		  
        try {
			
			campo=campoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.campo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		campo = new  Campo();
		  		  
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
		campo = new  Campo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =campoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		campo = new  Campo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=campoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		campo = new  Campo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =campoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		campo = new  Campo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=campoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		campo = new  Campo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =campoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		campo = new  Campo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=campoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		campos = new  ArrayList<Campo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campos=campoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCampo(campos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
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
		campos = new  ArrayList<Campo>();
		  		  
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
		campos = new  ArrayList<Campo>();
		  		  
        try {			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campos=campoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCampo(campos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		campos = new  ArrayList<Campo>();
		  		  
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
		campos = new  ArrayList<Campo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campos=campoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCampo(campos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
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
		campos = new  ArrayList<Campo>();
		  		  
        try {
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campos=campoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCampo(campos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
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
		campos = new  ArrayList<Campo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campos=campoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCampo(campos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
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
		campos = new  ArrayList<Campo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campos=campoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCampo(campos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		campo = new  Campo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campo=campoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCampo(campo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campo);
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
		campo = new  Campo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campo=campoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCampo(campo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		campos = new  ArrayList<Campo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campos=campoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCampo(campos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
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
		campos = new  ArrayList<Campo>();
		  		  
        try {
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campos=campoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCampo(campos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCamposWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		campos = new  ArrayList<Campo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getTodosCamposWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campos=campoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCampo(campos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
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
	
	public  void  getTodosCampos(String sFinalQuery,Pagination pagination)throws Exception {
		campos = new  ArrayList<Campo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			campos=campoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCampo(campos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCampo(Campo campo) throws Exception {
		Boolean estaValidado=false;
		
		if(campo.getIsNew() || campo.getIsChanged()) { 
			this.invalidValues = campoValidator.getInvalidValues(campo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(campo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCampo(List<Campo> Campos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Campo campoLocal:campos) {				
			estaValidadoObjeto=this.validarGuardarCampo(campoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCampo(List<Campo> Campos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCampo(campos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCampo(Campo Campo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCampo(campo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Campo campo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+campo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CampoConstantesFunciones.getCampoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"campo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CampoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CampoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCampoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-saveCampoWithConnection");connexion.begin();			
			
			CampoLogicAdditional.checkCampoToSave(this.campo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CampoLogicAdditional.updateCampoToSave(this.campo,this.arrDatoGeneral);
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.campo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCampo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCampo(this.campo)) {
				CampoDataAccess.save(this.campo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.campo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CampoLogicAdditional.checkCampoToSaveAfter(this.campo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCampo();
			
			connexion.commit();			
			
			if(this.campo.getIsDeleted()) {
				this.campo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCampo()throws Exception {	
		try {	
			
			CampoLogicAdditional.checkCampoToSave(this.campo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CampoLogicAdditional.updateCampoToSave(this.campo,this.arrDatoGeneral);
			
			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.campo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCampo(this.campo)) {			
				CampoDataAccess.save(this.campo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.campo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CampoLogicAdditional.checkCampoToSaveAfter(this.campo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.campo.getIsDeleted()) {
				this.campo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCamposWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-saveCamposWithConnection");connexion.begin();			
			
			CampoLogicAdditional.checkCampoToSaves(campos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCampos();
			
			Boolean validadoTodosCampo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Campo campoLocal:campos) {		
				if(campoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CampoLogicAdditional.updateCampoToSave(campoLocal,this.arrDatoGeneral);
	        	
				CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),campoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCampo(campoLocal)) {
					CampoDataAccess.save(campoLocal, connexion);				
				} else {
					validadoTodosCampo=false;
				}
			}
			
			if(!validadoTodosCampo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CampoLogicAdditional.checkCampoToSavesAfter(campos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCampos();
			
			connexion.commit();		
			
			this.quitarCamposEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCampos()throws Exception {				
		 try {	
			CampoLogicAdditional.checkCampoToSaves(campos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCampo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Campo campoLocal:campos) {				
				if(campoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CampoLogicAdditional.updateCampoToSave(campoLocal,this.arrDatoGeneral);
	        	
				CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),campoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCampo(campoLocal)) {				
					CampoDataAccess.save(campoLocal, connexion);				
				} else {
					validadoTodosCampo=false;
				}
			}
			
			if(!validadoTodosCampo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CampoLogicAdditional.checkCampoToSavesAfter(campos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCamposEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CampoParameterReturnGeneral procesarAccionCampos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Campo> campos,CampoParameterReturnGeneral campoParameterGeneral)throws Exception {
		 try {	
			CampoParameterReturnGeneral campoReturnGeneral=new CampoParameterReturnGeneral();
	
			CampoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,campos,campoParameterGeneral,campoReturnGeneral);
			
			return campoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CampoParameterReturnGeneral procesarAccionCamposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Campo> campos,CampoParameterReturnGeneral campoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-procesarAccionCamposWithConnection");connexion.begin();			
			
			CampoParameterReturnGeneral campoReturnGeneral=new CampoParameterReturnGeneral();
	
			CampoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,campos,campoParameterGeneral,campoReturnGeneral);
			
			this.connexion.commit();
			
			return campoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CampoParameterReturnGeneral procesarEventosCampos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Campo> campos,Campo campo,CampoParameterReturnGeneral campoParameterGeneral,Boolean isEsNuevoCampo,ArrayList<Classe> clases)throws Exception {
		 try {	
			CampoParameterReturnGeneral campoReturnGeneral=new CampoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				campoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CampoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,campos,campo,campoParameterGeneral,campoReturnGeneral,isEsNuevoCampo,clases);
			
			return campoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CampoParameterReturnGeneral procesarEventosCamposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Campo> campos,Campo campo,CampoParameterReturnGeneral campoParameterGeneral,Boolean isEsNuevoCampo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-procesarEventosCamposWithConnection");connexion.begin();			
			
			CampoParameterReturnGeneral campoReturnGeneral=new CampoParameterReturnGeneral();
	
			campoReturnGeneral.setCampo(campo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				campoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CampoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,campos,campo,campoParameterGeneral,campoReturnGeneral,isEsNuevoCampo,clases);
			
			this.connexion.commit();
			
			return campoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CampoParameterReturnGeneral procesarImportacionCamposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CampoParameterReturnGeneral campoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-procesarImportacionCamposWithConnection");connexion.begin();			
			
			CampoParameterReturnGeneral campoReturnGeneral=new CampoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.campos=new ArrayList<Campo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.campo=new Campo();
				
				
				if(conColumnasBase) {this.campo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.campo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.campo.setcodigo(arrColumnas[iColumn++]);
				this.campo.setnombre(arrColumnas[iColumn++]);
			this.campo.setdescripcion(arrColumnas[iColumn++]);
				this.campo.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.campos.add(this.campo);
			}
			
			this.saveCampos();
			
			this.connexion.commit();
			
			campoReturnGeneral.setConRetornoEstaProcesado(true);
			campoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return campoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCamposEliminados() throws Exception {				
		
		List<Campo> camposAux= new ArrayList<Campo>();
		
		for(Campo campo:campos) {
			if(!campo.getIsDeleted()) {
				camposAux.add(campo);
			}
		}
		
		campos=camposAux;
	}
	
	public void quitarCamposNulos() throws Exception {				
		
		List<Campo> camposAux= new ArrayList<Campo>();
		
		for(Campo campo : this.campos) {
			if(campo==null) {
				camposAux.add(campo);
			}
		}
		
		//this.campos=camposAux;
		
		this.campos.removeAll(camposAux);
	}
	
	public void getSetVersionRowCampoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(campo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((campo.getIsDeleted() || (campo.getIsChanged()&&!campo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=campoDataAccess.getSetVersionRowCampo(connexion,campo.getId());
				
				if(!campo.getVersionRow().equals(timestamp)) {	
					campo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				campo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCampo()throws Exception {	
		
		if(campo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((campo.getIsDeleted() || (campo.getIsChanged()&&!campo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=campoDataAccess.getSetVersionRowCampo(connexion,campo.getId());
			
			try {							
				if(!campo.getVersionRow().equals(timestamp)) {	
					campo.setVersionRow(timestamp);
				}
				
				campo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCamposWithConnection()throws Exception {	
		if(campos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Campo campoAux:campos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(campoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(campoAux.getIsDeleted() || (campoAux.getIsChanged()&&!campoAux.getIsNew())) {
						
						timestamp=campoDataAccess.getSetVersionRowCampo(connexion,campoAux.getId());
						
						if(!campo.getVersionRow().equals(timestamp)) {	
							campoAux.setVersionRow(timestamp);
						}
								
						campoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCampos()throws Exception {	
		if(campos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Campo campoAux:campos) {
					if(campoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(campoAux.getIsDeleted() || (campoAux.getIsChanged()&&!campoAux.getIsNew())) {
						
						timestamp=campoDataAccess.getSetVersionRowCampo(connexion,campoAux.getId());
						
						if(!campoAux.getVersionRow().equals(timestamp)) {	
							campoAux.setVersionRow(timestamp);
						}
						
													
						campoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CampoParameterReturnGeneral cargarCombosLoteForeignKeyCampoWithConnection(String finalQueryGlobalOpcion) throws Exception {
		CampoParameterReturnGeneral  campoReturnGeneral =new CampoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-cargarCombosLoteForeignKeyCampoWithConnection");connexion.begin();
			
			campoReturnGeneral =new CampoParameterReturnGeneral();
			
			

			List<Opcion> opcionsForeignKey=new ArrayList<Opcion>();
			OpcionLogic opcionLogic=new OpcionLogic();
			opcionLogic.setConnexion(this.connexion);
			opcionLogic.getOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOpcion.equals("NONE")) {
				opcionLogic.getTodosOpcions(finalQueryGlobalOpcion,new Pagination());
				opcionsForeignKey=opcionLogic.getOpcions();
			}

			campoReturnGeneral.setopcionsForeignKey(opcionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return campoReturnGeneral;
	}
	
	public CampoParameterReturnGeneral cargarCombosLoteForeignKeyCampo(String finalQueryGlobalOpcion) throws Exception {
		CampoParameterReturnGeneral  campoReturnGeneral =new CampoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			campoReturnGeneral =new CampoParameterReturnGeneral();
			
			

			List<Opcion> opcionsForeignKey=new ArrayList<Opcion>();
			OpcionLogic opcionLogic=new OpcionLogic();
			opcionLogic.setConnexion(this.connexion);
			opcionLogic.getOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOpcion.equals("NONE")) {
				opcionLogic.getTodosOpcions(finalQueryGlobalOpcion,new Pagination());
				opcionsForeignKey=opcionLogic.getOpcions();
			}

			campoReturnGeneral.setopcionsForeignKey(opcionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return campoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCampoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PerfilCampoLogic perfilcampoLogic=new PerfilCampoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCampoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PerfilCampo.class));
											
			

			perfilcampoLogic.setConnexion(this.getConnexion());
			perfilcampoLogic.setDatosCliente(this.datosCliente);
			perfilcampoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Campo campo:this.campos) {
				

				classes=new ArrayList<Classe>();
				classes=PerfilCampoConstantesFunciones.getClassesForeignKeysOfPerfilCampo(new ArrayList<Classe>(),DeepLoadType.NONE);

				perfilcampoLogic.setPerfilCampos(campo.perfilcampos);
				perfilcampoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Campo campo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CampoLogicAdditional.updateCampoToGet(campo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		campo.setOpcion(campoDataAccess.getOpcion(connexion,campo));
		campo.setPerfilCampos(campoDataAccess.getPerfilCampos(connexion,campo));
		campo.setPerfils(campoDataAccess.getPerfils(connexion,campo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				campo.setOpcion(campoDataAccess.getOpcion(connexion,campo));
				continue;
			}

			if(clas.clas.equals(PerfilCampo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				campo.setPerfilCampos(campoDataAccess.getPerfilCampos(connexion,campo));

				if(this.isConDeep) {
					PerfilCampoLogic perfilcampoLogic= new PerfilCampoLogic(this.connexion);
					perfilcampoLogic.setPerfilCampos(campo.getPerfilCampos());
					ArrayList<Classe> classesLocal=PerfilCampoConstantesFunciones.getClassesForeignKeysOfPerfilCampo(new ArrayList<Classe>(),DeepLoadType.NONE);
					perfilcampoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PerfilCampoConstantesFunciones.refrescarForeignKeysDescripcionesPerfilCampo(perfilcampoLogic.getPerfilCampos());
					campo.setPerfilCampos(perfilcampoLogic.getPerfilCampos());
				}

				continue;
			}

			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				campo.setPerfils(campoDataAccess.getPerfils(connexion,campo));

				if(this.isConDeep) {
					PerfilLogic perfilLogic= new PerfilLogic(this.connexion);
					perfilLogic.setPerfils(campo.getPerfils());
					ArrayList<Classe> classesLocal=PerfilConstantesFunciones.getClassesForeignKeysOfPerfil(new ArrayList<Classe>(),DeepLoadType.NONE);
					perfilLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(perfilLogic.getPerfils());
					campo.setPerfils(perfilLogic.getPerfils());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			campo.setOpcion(campoDataAccess.getOpcion(connexion,campo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilCampo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilCampo.class));
			campo.setPerfilCampos(campoDataAccess.getPerfilCampos(connexion,campo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Perfil.class));
			campo.setPerfils(campoDataAccess.getPerfils(connexion,campo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		campo.setOpcion(campoDataAccess.getOpcion(connexion,campo));
		OpcionLogic opcionLogic= new OpcionLogic(connexion);
		opcionLogic.deepLoad(campo.getOpcion(),isDeep,deepLoadType,clases);
				

		campo.setPerfilCampos(campoDataAccess.getPerfilCampos(connexion,campo));

		for(PerfilCampo perfilcampo:campo.getPerfilCampos()) {
			PerfilCampoLogic perfilcampoLogic= new PerfilCampoLogic(connexion);
			perfilcampoLogic.deepLoad(perfilcampo,isDeep,deepLoadType,clases);
		}

		campo.setPerfils(campoDataAccess.getPerfils(connexion,campo));

		for(Perfil perfil:campo.getPerfils()) {
			PerfilLogic perfilLogic= new PerfilLogic(connexion);
			perfilLogic.deepLoad(perfil,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				campo.setOpcion(campoDataAccess.getOpcion(connexion,campo));
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepLoad(campo.getOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PerfilCampo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				campo.setPerfilCampos(campoDataAccess.getPerfilCampos(connexion,campo));

				for(PerfilCampo perfilcampo:campo.getPerfilCampos()) {
					PerfilCampoLogic perfilcampoLogic= new PerfilCampoLogic(connexion);
					perfilcampoLogic.deepLoad(perfilcampo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				campo.setPerfils(campoDataAccess.getPerfils(connexion,campo));

				for(Perfil perfil:campo.getPerfils()) {
					PerfilLogic perfilLogic= new PerfilLogic(connexion);
					perfilLogic.deepLoad(perfil,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			campo.setOpcion(campoDataAccess.getOpcion(connexion,campo));
			OpcionLogic opcionLogic= new OpcionLogic(connexion);
			opcionLogic.deepLoad(campo.getOpcion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilCampo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilCampo.class));
			campo.setPerfilCampos(campoDataAccess.getPerfilCampos(connexion,campo));

			for(PerfilCampo perfilcampo:campo.getPerfilCampos()) {
				PerfilCampoLogic perfilcampoLogic= new PerfilCampoLogic(connexion);
				perfilcampoLogic.deepLoad(perfilcampo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Perfil.class));
			campo.setPerfils(campoDataAccess.getPerfils(connexion,campo));

			for(Perfil perfil:campo.getPerfils()) {
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepLoad(perfil,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Campo campo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CampoLogicAdditional.updateCampoToSave(campo,this.arrDatoGeneral);
			
CampoDataAccess.save(campo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OpcionDataAccess.save(campo.getOpcion(),connexion);

		for(PerfilCampo perfilcampo:campo.getPerfilCampos()) {
			perfilcampo.setid_campo(campo.getId());
			PerfilCampoDataAccess.save(perfilcampo,connexion);
		}

		for(Perfil perfil:campo.getPerfils()) {
			PerfilDataAccess.save(perfil,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				OpcionDataAccess.save(campo.getOpcion(),connexion);
				continue;
			}


			if(clas.clas.equals(PerfilCampo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilCampo perfilcampo:campo.getPerfilCampos()) {
					perfilcampo.setid_campo(campo.getId());
					PerfilCampoDataAccess.save(perfilcampo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Perfil perfil:campo.getPerfils()) {
					PerfilDataAccess.save(perfil,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OpcionDataAccess.save(campo.getOpcion(),connexion);
		OpcionLogic opcionLogic= new OpcionLogic(connexion);
		opcionLogic.deepLoad(campo.getOpcion(),isDeep,deepLoadType,clases);
				

		for(PerfilCampo perfilcampo:campo.getPerfilCampos()) {
			PerfilCampoLogic perfilcampoLogic= new PerfilCampoLogic(connexion);
			perfilcampo.setid_campo(campo.getId());
			PerfilCampoDataAccess.save(perfilcampo,connexion);
			perfilcampoLogic.deepSave(perfilcampo,isDeep,deepLoadType,clases);
		}

		for(Perfil perfil:campo.getPerfils()) {
			PerfilLogic perfilLogic= new PerfilLogic(connexion);
			PerfilDataAccess.save(perfil,connexion);
			perfilLogic.deepSave(perfil,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				OpcionDataAccess.save(campo.getOpcion(),connexion);
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepSave(campo.getOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PerfilCampo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilCampo perfilcampo:campo.getPerfilCampos()) {
					PerfilCampoLogic perfilcampoLogic= new PerfilCampoLogic(connexion);
					perfilcampo.setid_campo(campo.getId());
					PerfilCampoDataAccess.save(perfilcampo,connexion);
					perfilcampoLogic.deepSave(perfilcampo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Perfil perfil:campo.getPerfils()) {
					PerfilLogic perfilLogic= new PerfilLogic(connexion);
					PerfilDataAccess.save(perfil,connexion);
					perfilLogic.deepSave(perfil,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Campo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(campo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(campo);
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
			this.deepLoad(this.campo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Campo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(campos!=null) {
				for(Campo campo:campos) {
					this.deepLoad(campo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(campos);
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
			if(campos!=null) {
				for(Campo campo:campos) {
					this.deepLoad(campo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(campos);
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
			this.getNewConnexionToDeep(Campo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(campo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Campo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(campos!=null) {
				for(Campo campo:campos) {
					this.deepSave(campo,isDeep,deepLoadType,clases);
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
			if(campos!=null) {
				for(Campo campo:campos) {
					this.deepSave(campo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCamposFK_IdOpcionWithConnection(String sFinalQuery,Pagination pagination,Long id_opcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Campo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,CampoConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			campos=campoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCamposFK_IdOpcion(String sFinalQuery,Pagination pagination,Long id_opcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,CampoConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			CampoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			campos=campoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(this.campos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CampoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CampoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Campo campo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CampoConstantesFunciones.ISCONAUDITORIA) {
				if(campo.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CampoDataAccess.TABLENAME, campo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CampoConstantesFunciones.ISCONAUDITORIADETALLE) {
						//CampoLogic.registrarAuditoriaDetallesCampo(connexion,campo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(campo.getIsDeleted()) {
					/*if(!campo.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CampoDataAccess.TABLENAME, campo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//CampoLogic.registrarAuditoriaDetallesCampo(connexion,campo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CampoDataAccess.TABLENAME, campo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(campo.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CampoDataAccess.TABLENAME, campo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CampoConstantesFunciones.ISCONAUDITORIADETALLE) {
						//CampoLogic.registrarAuditoriaDetallesCampo(connexion,campo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCampo(Connexion connexion,Campo campo)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(campo.getIsNew()||!campo.getid_opcion().equals(campo.getCampoOriginal().getid_opcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(campo.getCampoOriginal().getid_opcion()!=null)
				{
					strValorActual=campo.getCampoOriginal().getid_opcion().toString();
				}
				if(campo.getid_opcion()!=null)
				{
					strValorNuevo=campo.getid_opcion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CampoConstantesFunciones.IDOPCION,strValorActual,strValorNuevo);
			}	
			
			if(campo.getIsNew()||!campo.getcodigo().equals(campo.getCampoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(campo.getCampoOriginal().getcodigo()!=null)
				{
					strValorActual=campo.getCampoOriginal().getcodigo();
				}
				if(campo.getcodigo()!=null)
				{
					strValorNuevo=campo.getcodigo() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CampoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(campo.getIsNew()||!campo.getnombre().equals(campo.getCampoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(campo.getCampoOriginal().getnombre()!=null)
				{
					strValorActual=campo.getCampoOriginal().getnombre();
				}
				if(campo.getnombre()!=null)
				{
					strValorNuevo=campo.getnombre() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CampoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(campo.getIsNew()||!campo.getdescripcion().equals(campo.getCampoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(campo.getCampoOriginal().getdescripcion()!=null)
				{
					strValorActual=campo.getCampoOriginal().getdescripcion();
				}
				if(campo.getdescripcion()!=null)
				{
					strValorNuevo=campo.getdescripcion() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CampoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(campo.getIsNew()||!campo.getestado().equals(campo.getCampoOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(campo.getCampoOriginal().getestado()!=null)
				{
					strValorActual=campo.getCampoOriginal().getestado().toString();
				}
				if(campo.getestado()!=null)
				{
					strValorNuevo=campo.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CampoConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCampoRelacionesWithConnection(Campo campo,List<PerfilCampo> perfilcampos) throws Exception {

		if(!campo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCampoRelacionesBase(campo,perfilcampos,true);
		}
	}

	public void saveCampoRelaciones(Campo campo,List<PerfilCampo> perfilcampos)throws Exception {

		if(!campo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCampoRelacionesBase(campo,perfilcampos,false);
		}
	}

	public void saveCampoRelacionesBase(Campo campo,List<PerfilCampo> perfilcampos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Campo-saveRelacionesWithConnection");}
	
			campo.setPerfilCampos(perfilcampos);

			this.setCampo(campo);

			if(CampoLogicAdditional.validarSaveRelaciones(campo,this)) {

				CampoLogicAdditional.updateRelacionesToSave(campo,this);

				if((campo.getIsNew()||campo.getIsChanged())&&!campo.getIsDeleted()) {
					this.saveCampo();
					this.saveCampoRelacionesDetalles(perfilcampos);

				} else if(campo.getIsDeleted()) {
					this.saveCampoRelacionesDetalles(perfilcampos);
					this.saveCampo();
				}

				CampoLogicAdditional.updateRelacionesToSaveAfter(campo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PerfilCampoConstantesFunciones.InicializarGeneralEntityAuxiliaresPerfilCampos(perfilcampos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCampoRelacionesDetalles(List<PerfilCampo> perfilcampos)throws Exception {
		try {
	

			Long idCampoActual=this.getCampo().getId();

			PerfilCampoLogic perfilcampoLogic_Desde_Campo=new PerfilCampoLogic();
			perfilcampoLogic_Desde_Campo.setPerfilCampos(perfilcampos);

			perfilcampoLogic_Desde_Campo.setConnexion(this.getConnexion());
			perfilcampoLogic_Desde_Campo.setDatosCliente(this.datosCliente);

			for(PerfilCampo perfilcampo_Desde_Campo:perfilcampoLogic_Desde_Campo.getPerfilCampos()) {
				perfilcampo_Desde_Campo.setid_campo(idCampoActual);
			}

			perfilcampoLogic_Desde_Campo.savePerfilCampos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCampo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CampoConstantesFunciones.getClassesForeignKeysOfCampo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCampo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CampoConstantesFunciones.getClassesRelationshipsOfCampo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

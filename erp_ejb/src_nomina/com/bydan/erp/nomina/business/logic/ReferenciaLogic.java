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
import com.bydan.erp.nomina.util.ReferenciaConstantesFunciones;
import com.bydan.erp.nomina.util.ReferenciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ReferenciaParameterGeneral;
import com.bydan.erp.nomina.business.entity.Referencia;
import com.bydan.erp.nomina.business.logic.ReferenciaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ReferenciaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ReferenciaLogic.class);
	
	protected ReferenciaDataAccess referenciaDataAccess; 	
	protected Referencia referencia;
	protected List<Referencia> referencias;
	protected Object referenciaObject;	
	protected List<Object> referenciasObject;
	
	public static ClassValidator<Referencia> referenciaValidator = new ClassValidator<Referencia>(Referencia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ReferenciaLogicAdditional referenciaLogicAdditional=null;
	
	public ReferenciaLogicAdditional getReferenciaLogicAdditional() {
		return this.referenciaLogicAdditional;
	}
	
	public void setReferenciaLogicAdditional(ReferenciaLogicAdditional referenciaLogicAdditional) {
		try {
			this.referenciaLogicAdditional=referenciaLogicAdditional;
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
	
	
	
	
	public  ReferenciaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.referenciaDataAccess = new ReferenciaDataAccess();
			
			this.referencias= new ArrayList<Referencia>();
			this.referencia= new Referencia();
			
			this.referenciaObject=new Object();
			this.referenciasObject=new ArrayList<Object>();
				
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
			
			this.referenciaDataAccess.setConnexionType(this.connexionType);
			this.referenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ReferenciaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.referenciaDataAccess = new ReferenciaDataAccess();
			this.referencias= new ArrayList<Referencia>();
			this.referencia= new Referencia();
			this.referenciaObject=new Object();
			this.referenciasObject=new ArrayList<Object>();
			
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
			
			this.referenciaDataAccess.setConnexionType(this.connexionType);
			this.referenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Referencia getReferencia() throws Exception {	
		ReferenciaLogicAdditional.checkReferenciaToGet(referencia,this.datosCliente,this.arrDatoGeneral);
		ReferenciaLogicAdditional.updateReferenciaToGet(referencia,this.arrDatoGeneral);
		
		return referencia;
	}
		
	public void setReferencia(Referencia newReferencia) {
		this.referencia = newReferencia;
	}
	
	public ReferenciaDataAccess getReferenciaDataAccess() {
		return referenciaDataAccess;
	}
	
	public void setReferenciaDataAccess(ReferenciaDataAccess newreferenciaDataAccess) {
		this.referenciaDataAccess = newreferenciaDataAccess;
	}
	
	public List<Referencia> getReferencias() throws Exception {		
		this.quitarReferenciasNulos();
		
		ReferenciaLogicAdditional.checkReferenciaToGets(referencias,this.datosCliente,this.arrDatoGeneral);
		
		for (Referencia referenciaLocal: referencias ) {
			ReferenciaLogicAdditional.updateReferenciaToGet(referenciaLocal,this.arrDatoGeneral);
		}
		
		return referencias;
	}
	
	public void setReferencias(List<Referencia> newReferencias) {
		this.referencias = newReferencias;
	}
	
	public Object getReferenciaObject() {	
		this.referenciaObject=this.referenciaDataAccess.getEntityObject();
		return this.referenciaObject;
	}
		
	public void setReferenciaObject(Object newReferenciaObject) {
		this.referenciaObject = newReferenciaObject;
	}
	
	public List<Object> getReferenciasObject() {		
		this.referenciasObject=this.referenciaDataAccess.getEntitiesObject();
		return this.referenciasObject;
	}
		
	public void setReferenciasObject(List<Object> newReferenciasObject) {
		this.referenciasObject = newReferenciasObject;
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
		
		if(this.referenciaDataAccess!=null) {
			this.referenciaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			referenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			referenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		referencia = new  Referencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			referencia=referenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencia);
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
		referencia = new  Referencia();
		  		  
        try {
			
			referencia=referenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		referencia = new  Referencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			referencia=referenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencia);
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
		referencia = new  Referencia();
		  		  
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
		referencia = new  Referencia();
		  		  
        try {
			
			referencia=referenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		referencia = new  Referencia();
		  		  
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
		referencia = new  Referencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =referenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referencia = new  Referencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=referenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		referencia = new  Referencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =referenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referencia = new  Referencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=referenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		referencia = new  Referencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =referenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referencia = new  Referencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=referenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		referencias = new  ArrayList<Referencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencias=referenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferencia(referencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
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
		referencias = new  ArrayList<Referencia>();
		  		  
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
		referencias = new  ArrayList<Referencia>();
		  		  
        try {			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencias=referenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarReferencia(referencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		referencias = new  ArrayList<Referencia>();
		  		  
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
		referencias = new  ArrayList<Referencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencias=referenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferencia(referencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
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
		referencias = new  ArrayList<Referencia>();
		  		  
        try {
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencias=referenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferencia(referencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
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
		referencias = new  ArrayList<Referencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencias=referenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferencia(referencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
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
		referencias = new  ArrayList<Referencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencias=referenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferencia(referencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		referencia = new  Referencia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencia=referenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferencia(referencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencia);
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
		referencia = new  Referencia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencia=referenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferencia(referencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		referencias = new  ArrayList<Referencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencias=referenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferencia(referencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
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
		referencias = new  ArrayList<Referencia>();
		  		  
        try {
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencias=referenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferencia(referencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosReferenciasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		referencias = new  ArrayList<Referencia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getTodosReferenciasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarReferencia(referencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
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
	
	public  void  getTodosReferencias(String sFinalQuery,Pagination pagination)throws Exception {
		referencias = new  ArrayList<Referencia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarReferencia(referencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarReferencia(Referencia referencia) throws Exception {
		Boolean estaValidado=false;
		
		if(referencia.getIsNew() || referencia.getIsChanged()) { 
			this.invalidValues = referenciaValidator.getInvalidValues(referencia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(referencia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarReferencia(List<Referencia> Referencias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Referencia referenciaLocal:referencias) {				
			estaValidadoObjeto=this.validarGuardarReferencia(referenciaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarReferencia(List<Referencia> Referencias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarReferencia(referencias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarReferencia(Referencia Referencia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarReferencia(referencia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Referencia referencia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+referencia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ReferenciaConstantesFunciones.getReferenciaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"referencia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ReferenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ReferenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveReferenciaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-saveReferenciaWithConnection");connexion.begin();			
			
			ReferenciaLogicAdditional.checkReferenciaToSave(this.referencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ReferenciaLogicAdditional.updateReferenciaToSave(this.referencia,this.arrDatoGeneral);
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.referencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowReferencia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarReferencia(this.referencia)) {
				ReferenciaDataAccess.save(this.referencia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.referencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ReferenciaLogicAdditional.checkReferenciaToSaveAfter(this.referencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowReferencia();
			
			connexion.commit();			
			
			if(this.referencia.getIsDeleted()) {
				this.referencia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveReferencia()throws Exception {	
		try {	
			
			ReferenciaLogicAdditional.checkReferenciaToSave(this.referencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ReferenciaLogicAdditional.updateReferenciaToSave(this.referencia,this.arrDatoGeneral);
			
			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.referencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarReferencia(this.referencia)) {			
				ReferenciaDataAccess.save(this.referencia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.referencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ReferenciaLogicAdditional.checkReferenciaToSaveAfter(this.referencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.referencia.getIsDeleted()) {
				this.referencia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveReferenciasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-saveReferenciasWithConnection");connexion.begin();			
			
			ReferenciaLogicAdditional.checkReferenciaToSaves(referencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowReferencias();
			
			Boolean validadoTodosReferencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Referencia referenciaLocal:referencias) {		
				if(referenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ReferenciaLogicAdditional.updateReferenciaToSave(referenciaLocal,this.arrDatoGeneral);
	        	
				ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),referenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarReferencia(referenciaLocal)) {
					ReferenciaDataAccess.save(referenciaLocal, connexion);				
				} else {
					validadoTodosReferencia=false;
				}
			}
			
			if(!validadoTodosReferencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ReferenciaLogicAdditional.checkReferenciaToSavesAfter(referencias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowReferencias();
			
			connexion.commit();		
			
			this.quitarReferenciasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveReferencias()throws Exception {				
		 try {	
			ReferenciaLogicAdditional.checkReferenciaToSaves(referencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosReferencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Referencia referenciaLocal:referencias) {				
				if(referenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ReferenciaLogicAdditional.updateReferenciaToSave(referenciaLocal,this.arrDatoGeneral);
	        	
				ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),referenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarReferencia(referenciaLocal)) {				
					ReferenciaDataAccess.save(referenciaLocal, connexion);				
				} else {
					validadoTodosReferencia=false;
				}
			}
			
			if(!validadoTodosReferencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ReferenciaLogicAdditional.checkReferenciaToSavesAfter(referencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarReferenciasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReferenciaParameterReturnGeneral procesarAccionReferencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Referencia> referencias,ReferenciaParameterReturnGeneral referenciaParameterGeneral)throws Exception {
		 try {	
			ReferenciaParameterReturnGeneral referenciaReturnGeneral=new ReferenciaParameterReturnGeneral();
	
			ReferenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,referencias,referenciaParameterGeneral,referenciaReturnGeneral);
			
			return referenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReferenciaParameterReturnGeneral procesarAccionReferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Referencia> referencias,ReferenciaParameterReturnGeneral referenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-procesarAccionReferenciasWithConnection");connexion.begin();			
			
			ReferenciaParameterReturnGeneral referenciaReturnGeneral=new ReferenciaParameterReturnGeneral();
	
			ReferenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,referencias,referenciaParameterGeneral,referenciaReturnGeneral);
			
			this.connexion.commit();
			
			return referenciaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ReferenciaParameterReturnGeneral procesarEventosReferencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Referencia> referencias,Referencia referencia,ReferenciaParameterReturnGeneral referenciaParameterGeneral,Boolean isEsNuevoReferencia,ArrayList<Classe> clases)throws Exception {
		 try {	
			ReferenciaParameterReturnGeneral referenciaReturnGeneral=new ReferenciaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				referenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ReferenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,referencias,referencia,referenciaParameterGeneral,referenciaReturnGeneral,isEsNuevoReferencia,clases);
			
			return referenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ReferenciaParameterReturnGeneral procesarEventosReferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Referencia> referencias,Referencia referencia,ReferenciaParameterReturnGeneral referenciaParameterGeneral,Boolean isEsNuevoReferencia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-procesarEventosReferenciasWithConnection");connexion.begin();			
			
			ReferenciaParameterReturnGeneral referenciaReturnGeneral=new ReferenciaParameterReturnGeneral();
	
			referenciaReturnGeneral.setReferencia(referencia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				referenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ReferenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,referencias,referencia,referenciaParameterGeneral,referenciaReturnGeneral,isEsNuevoReferencia,clases);
			
			this.connexion.commit();
			
			return referenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ReferenciaParameterReturnGeneral procesarImportacionReferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ReferenciaParameterReturnGeneral referenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-procesarImportacionReferenciasWithConnection");connexion.begin();			
			
			ReferenciaParameterReturnGeneral referenciaReturnGeneral=new ReferenciaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.referencias=new ArrayList<Referencia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.referencia=new Referencia();
				
				
				if(conColumnasBase) {this.referencia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.referencia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.referencia.setcedula(arrColumnas[iColumn++]);
				this.referencia.setapellido(arrColumnas[iColumn++]);
				this.referencia.setnombre(arrColumnas[iColumn++]);
				this.referencia.setdireccion(arrColumnas[iColumn++]);
				this.referencia.settelefono(arrColumnas[iColumn++]);
				
				this.referencias.add(this.referencia);
			}
			
			this.saveReferencias();
			
			this.connexion.commit();
			
			referenciaReturnGeneral.setConRetornoEstaProcesado(true);
			referenciaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return referenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarReferenciasEliminados() throws Exception {				
		
		List<Referencia> referenciasAux= new ArrayList<Referencia>();
		
		for(Referencia referencia:referencias) {
			if(!referencia.getIsDeleted()) {
				referenciasAux.add(referencia);
			}
		}
		
		referencias=referenciasAux;
	}
	
	public void quitarReferenciasNulos() throws Exception {				
		
		List<Referencia> referenciasAux= new ArrayList<Referencia>();
		
		for(Referencia referencia : this.referencias) {
			if(referencia==null) {
				referenciasAux.add(referencia);
			}
		}
		
		//this.referencias=referenciasAux;
		
		this.referencias.removeAll(referenciasAux);
	}
	
	public void getSetVersionRowReferenciaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(referencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((referencia.getIsDeleted() || (referencia.getIsChanged()&&!referencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=referenciaDataAccess.getSetVersionRowReferencia(connexion,referencia.getId());
				
				if(!referencia.getVersionRow().equals(timestamp)) {	
					referencia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				referencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowReferencia()throws Exception {	
		
		if(referencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((referencia.getIsDeleted() || (referencia.getIsChanged()&&!referencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=referenciaDataAccess.getSetVersionRowReferencia(connexion,referencia.getId());
			
			try {							
				if(!referencia.getVersionRow().equals(timestamp)) {	
					referencia.setVersionRow(timestamp);
				}
				
				referencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowReferenciasWithConnection()throws Exception {	
		if(referencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Referencia referenciaAux:referencias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(referenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(referenciaAux.getIsDeleted() || (referenciaAux.getIsChanged()&&!referenciaAux.getIsNew())) {
						
						timestamp=referenciaDataAccess.getSetVersionRowReferencia(connexion,referenciaAux.getId());
						
						if(!referencia.getVersionRow().equals(timestamp)) {	
							referenciaAux.setVersionRow(timestamp);
						}
								
						referenciaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowReferencias()throws Exception {	
		if(referencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Referencia referenciaAux:referencias) {
					if(referenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(referenciaAux.getIsDeleted() || (referenciaAux.getIsChanged()&&!referenciaAux.getIsNew())) {
						
						timestamp=referenciaDataAccess.getSetVersionRowReferencia(connexion,referenciaAux.getId());
						
						if(!referenciaAux.getVersionRow().equals(timestamp)) {	
							referenciaAux.setVersionRow(timestamp);
						}
						
													
						referenciaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ReferenciaParameterReturnGeneral cargarCombosLoteForeignKeyReferenciaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalParentezco,String finalQueryGlobalProfesion) throws Exception {
		ReferenciaParameterReturnGeneral  referenciaReturnGeneral =new ReferenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-cargarCombosLoteForeignKeyReferenciaWithConnection");connexion.begin();
			
			referenciaReturnGeneral =new ReferenciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			referenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			referenciaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Parentezco> parentezcosForeignKey=new ArrayList<Parentezco>();
			ParentezcoLogic parentezcoLogic=new ParentezcoLogic();
			parentezcoLogic.setConnexion(this.connexion);
			parentezcoLogic.getParentezcoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParentezco.equals("NONE")) {
				parentezcoLogic.getTodosParentezcos(finalQueryGlobalParentezco,new Pagination());
				parentezcosForeignKey=parentezcoLogic.getParentezcos();
			}

			referenciaReturnGeneral.setparentezcosForeignKey(parentezcosForeignKey);


			List<Profesion> profesionsForeignKey=new ArrayList<Profesion>();
			ProfesionLogic profesionLogic=new ProfesionLogic();
			profesionLogic.setConnexion(this.connexion);
			profesionLogic.getProfesionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProfesion.equals("NONE")) {
				profesionLogic.getTodosProfesions(finalQueryGlobalProfesion,new Pagination());
				profesionsForeignKey=profesionLogic.getProfesions();
			}

			referenciaReturnGeneral.setprofesionsForeignKey(profesionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return referenciaReturnGeneral;
	}
	
	public ReferenciaParameterReturnGeneral cargarCombosLoteForeignKeyReferencia(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalParentezco,String finalQueryGlobalProfesion) throws Exception {
		ReferenciaParameterReturnGeneral  referenciaReturnGeneral =new ReferenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			referenciaReturnGeneral =new ReferenciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			referenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			referenciaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Parentezco> parentezcosForeignKey=new ArrayList<Parentezco>();
			ParentezcoLogic parentezcoLogic=new ParentezcoLogic();
			parentezcoLogic.setConnexion(this.connexion);
			parentezcoLogic.getParentezcoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParentezco.equals("NONE")) {
				parentezcoLogic.getTodosParentezcos(finalQueryGlobalParentezco,new Pagination());
				parentezcosForeignKey=parentezcoLogic.getParentezcos();
			}

			referenciaReturnGeneral.setparentezcosForeignKey(parentezcosForeignKey);


			List<Profesion> profesionsForeignKey=new ArrayList<Profesion>();
			ProfesionLogic profesionLogic=new ProfesionLogic();
			profesionLogic.setConnexion(this.connexion);
			profesionLogic.getProfesionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProfesion.equals("NONE")) {
				profesionLogic.getTodosProfesions(finalQueryGlobalProfesion,new Pagination());
				profesionsForeignKey=profesionLogic.getProfesions();
			}

			referenciaReturnGeneral.setprofesionsForeignKey(profesionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return referenciaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyReferenciaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TelefonoReferenciaLogic telefonoreferenciaLogic=new TelefonoReferenciaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyReferenciaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TelefonoReferencia.class));
											
			

			telefonoreferenciaLogic.setConnexion(this.getConnexion());
			telefonoreferenciaLogic.setDatosCliente(this.datosCliente);
			telefonoreferenciaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Referencia referencia:this.referencias) {
				

				classes=new ArrayList<Classe>();
				classes=TelefonoReferenciaConstantesFunciones.getClassesForeignKeysOfTelefonoReferencia(new ArrayList<Classe>(),DeepLoadType.NONE);

				telefonoreferenciaLogic.setTelefonoReferencias(referencia.telefonoreferencias);
				telefonoreferenciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Referencia referencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ReferenciaLogicAdditional.updateReferenciaToGet(referencia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		referencia.setEmpresa(referenciaDataAccess.getEmpresa(connexion,referencia));
		referencia.setEmpleado(referenciaDataAccess.getEmpleado(connexion,referencia));
		referencia.setParentezco(referenciaDataAccess.getParentezco(connexion,referencia));
		referencia.setProfesion(referenciaDataAccess.getProfesion(connexion,referencia));
		referencia.setTelefonoReferencias(referenciaDataAccess.getTelefonoReferencias(connexion,referencia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				referencia.setEmpresa(referenciaDataAccess.getEmpresa(connexion,referencia));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				referencia.setEmpleado(referenciaDataAccess.getEmpleado(connexion,referencia));
				continue;
			}

			if(clas.clas.equals(Parentezco.class)) {
				referencia.setParentezco(referenciaDataAccess.getParentezco(connexion,referencia));
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				referencia.setProfesion(referenciaDataAccess.getProfesion(connexion,referencia));
				continue;
			}

			if(clas.clas.equals(TelefonoReferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				referencia.setTelefonoReferencias(referenciaDataAccess.getTelefonoReferencias(connexion,referencia));

				if(this.isConDeep) {
					TelefonoReferenciaLogic telefonoreferenciaLogic= new TelefonoReferenciaLogic(this.connexion);
					telefonoreferenciaLogic.setTelefonoReferencias(referencia.getTelefonoReferencias());
					ArrayList<Classe> classesLocal=TelefonoReferenciaConstantesFunciones.getClassesForeignKeysOfTelefonoReferencia(new ArrayList<Classe>(),DeepLoadType.NONE);
					telefonoreferenciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(telefonoreferenciaLogic.getTelefonoReferencias());
					referencia.setTelefonoReferencias(telefonoreferenciaLogic.getTelefonoReferencias());
				}

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
			referencia.setEmpresa(referenciaDataAccess.getEmpresa(connexion,referencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referencia.setEmpleado(referenciaDataAccess.getEmpleado(connexion,referencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Parentezco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referencia.setParentezco(referenciaDataAccess.getParentezco(connexion,referencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Profesion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referencia.setProfesion(referenciaDataAccess.getProfesion(connexion,referencia));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TelefonoReferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TelefonoReferencia.class));
			referencia.setTelefonoReferencias(referenciaDataAccess.getTelefonoReferencias(connexion,referencia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		referencia.setEmpresa(referenciaDataAccess.getEmpresa(connexion,referencia));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(referencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		referencia.setEmpleado(referenciaDataAccess.getEmpleado(connexion,referencia));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(referencia.getEmpleado(),isDeep,deepLoadType,clases);
				
		referencia.setParentezco(referenciaDataAccess.getParentezco(connexion,referencia));
		ParentezcoLogic parentezcoLogic= new ParentezcoLogic(connexion);
		parentezcoLogic.deepLoad(referencia.getParentezco(),isDeep,deepLoadType,clases);
				
		referencia.setProfesion(referenciaDataAccess.getProfesion(connexion,referencia));
		ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
		profesionLogic.deepLoad(referencia.getProfesion(),isDeep,deepLoadType,clases);
				

		referencia.setTelefonoReferencias(referenciaDataAccess.getTelefonoReferencias(connexion,referencia));

		for(TelefonoReferencia telefonoreferencia:referencia.getTelefonoReferencias()) {
			TelefonoReferenciaLogic telefonoreferenciaLogic= new TelefonoReferenciaLogic(connexion);
			telefonoreferenciaLogic.deepLoad(telefonoreferencia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				referencia.setEmpresa(referenciaDataAccess.getEmpresa(connexion,referencia));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(referencia.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				referencia.setEmpleado(referenciaDataAccess.getEmpleado(connexion,referencia));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(referencia.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Parentezco.class)) {
				referencia.setParentezco(referenciaDataAccess.getParentezco(connexion,referencia));
				ParentezcoLogic parentezcoLogic= new ParentezcoLogic(connexion);
				parentezcoLogic.deepLoad(referencia.getParentezco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				referencia.setProfesion(referenciaDataAccess.getProfesion(connexion,referencia));
				ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
				profesionLogic.deepLoad(referencia.getProfesion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TelefonoReferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				referencia.setTelefonoReferencias(referenciaDataAccess.getTelefonoReferencias(connexion,referencia));

				for(TelefonoReferencia telefonoreferencia:referencia.getTelefonoReferencias()) {
					TelefonoReferenciaLogic telefonoreferenciaLogic= new TelefonoReferenciaLogic(connexion);
					telefonoreferenciaLogic.deepLoad(telefonoreferencia,isDeep,deepLoadType,clases);
				}
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
			referencia.setEmpresa(referenciaDataAccess.getEmpresa(connexion,referencia));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(referencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referencia.setEmpleado(referenciaDataAccess.getEmpleado(connexion,referencia));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(referencia.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Parentezco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referencia.setParentezco(referenciaDataAccess.getParentezco(connexion,referencia));
			ParentezcoLogic parentezcoLogic= new ParentezcoLogic(connexion);
			parentezcoLogic.deepLoad(referencia.getParentezco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Profesion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referencia.setProfesion(referenciaDataAccess.getProfesion(connexion,referencia));
			ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
			profesionLogic.deepLoad(referencia.getProfesion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TelefonoReferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TelefonoReferencia.class));
			referencia.setTelefonoReferencias(referenciaDataAccess.getTelefonoReferencias(connexion,referencia));

			for(TelefonoReferencia telefonoreferencia:referencia.getTelefonoReferencias()) {
				TelefonoReferenciaLogic telefonoreferenciaLogic= new TelefonoReferenciaLogic(connexion);
				telefonoreferenciaLogic.deepLoad(telefonoreferencia,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Referencia referencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ReferenciaLogicAdditional.updateReferenciaToSave(referencia,this.arrDatoGeneral);
			
ReferenciaDataAccess.save(referencia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(referencia.getEmpresa(),connexion);

		EmpleadoDataAccess.save(referencia.getEmpleado(),connexion);

		ParentezcoDataAccess.save(referencia.getParentezco(),connexion);

		ProfesionDataAccess.save(referencia.getProfesion(),connexion);

		for(TelefonoReferencia telefonoreferencia:referencia.getTelefonoReferencias()) {
			telefonoreferencia.setid_referencia(referencia.getId());
			TelefonoReferenciaDataAccess.save(telefonoreferencia,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(referencia.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(referencia.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Parentezco.class)) {
				ParentezcoDataAccess.save(referencia.getParentezco(),connexion);
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				ProfesionDataAccess.save(referencia.getProfesion(),connexion);
				continue;
			}


			if(clas.clas.equals(TelefonoReferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TelefonoReferencia telefonoreferencia:referencia.getTelefonoReferencias()) {
					telefonoreferencia.setid_referencia(referencia.getId());
					TelefonoReferenciaDataAccess.save(telefonoreferencia,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(referencia.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(referencia.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(referencia.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(referencia.getEmpleado(),isDeep,deepLoadType,clases);
				

		ParentezcoDataAccess.save(referencia.getParentezco(),connexion);
		ParentezcoLogic parentezcoLogic= new ParentezcoLogic(connexion);
		parentezcoLogic.deepLoad(referencia.getParentezco(),isDeep,deepLoadType,clases);
				

		ProfesionDataAccess.save(referencia.getProfesion(),connexion);
		ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
		profesionLogic.deepLoad(referencia.getProfesion(),isDeep,deepLoadType,clases);
				

		for(TelefonoReferencia telefonoreferencia:referencia.getTelefonoReferencias()) {
			TelefonoReferenciaLogic telefonoreferenciaLogic= new TelefonoReferenciaLogic(connexion);
			telefonoreferencia.setid_referencia(referencia.getId());
			TelefonoReferenciaDataAccess.save(telefonoreferencia,connexion);
			telefonoreferenciaLogic.deepSave(telefonoreferencia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(referencia.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(referencia.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(referencia.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(referencia.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Parentezco.class)) {
				ParentezcoDataAccess.save(referencia.getParentezco(),connexion);
				ParentezcoLogic parentezcoLogic= new ParentezcoLogic(connexion);
				parentezcoLogic.deepSave(referencia.getParentezco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				ProfesionDataAccess.save(referencia.getProfesion(),connexion);
				ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
				profesionLogic.deepSave(referencia.getProfesion(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(TelefonoReferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TelefonoReferencia telefonoreferencia:referencia.getTelefonoReferencias()) {
					TelefonoReferenciaLogic telefonoreferenciaLogic= new TelefonoReferenciaLogic(connexion);
					telefonoreferencia.setid_referencia(referencia.getId());
					TelefonoReferenciaDataAccess.save(telefonoreferencia,connexion);
					telefonoreferenciaLogic.deepSave(telefonoreferencia,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Referencia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(referencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(referencia);
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
			this.deepLoad(this.referencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Referencia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(referencias!=null) {
				for(Referencia referencia:referencias) {
					this.deepLoad(referencia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(referencias);
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
			if(referencias!=null) {
				for(Referencia referencia:referencias) {
					this.deepLoad(referencia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(referencias);
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
			this.getNewConnexionToDeep(Referencia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(referencia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Referencia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(referencias!=null) {
				for(Referencia referencia:referencias) {
					this.deepSave(referencia,isDeep,deepLoadType,clases);
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
			if(referencias!=null) {
				for(Referencia referencia:referencias) {
					this.deepSave(referencia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getReferenciasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ReferenciaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ReferenciaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ReferenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ReferenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciasFK_IdParentezcoWithConnection(String sFinalQuery,Pagination pagination,Long id_parentezco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParentezco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParentezco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parentezco,ReferenciaConstantesFunciones.IDPARENTEZCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParentezco);

			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParentezco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciasFK_IdParentezco(String sFinalQuery,Pagination pagination,Long id_parentezco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParentezco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParentezco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parentezco,ReferenciaConstantesFunciones.IDPARENTEZCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParentezco);

			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParentezco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciasFK_IdProfesionWithConnection(String sFinalQuery,Pagination pagination,Long id_profesion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Referencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProfesion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProfesion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_profesion,ReferenciaConstantesFunciones.IDPROFESION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProfesion);

			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProfesion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciasFK_IdProfesion(String sFinalQuery,Pagination pagination,Long id_profesion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProfesion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProfesion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_profesion,ReferenciaConstantesFunciones.IDPROFESION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProfesion);

			ReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProfesion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(this.referencias);
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
			if(ReferenciaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Referencia referencia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ReferenciaConstantesFunciones.ISCONAUDITORIA) {
				if(referencia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaDataAccess.TABLENAME, referencia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ReferenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ReferenciaLogic.registrarAuditoriaDetallesReferencia(connexion,referencia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(referencia.getIsDeleted()) {
					/*if(!referencia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ReferenciaDataAccess.TABLENAME, referencia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ReferenciaLogic.registrarAuditoriaDetallesReferencia(connexion,referencia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaDataAccess.TABLENAME, referencia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(referencia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaDataAccess.TABLENAME, referencia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ReferenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ReferenciaLogic.registrarAuditoriaDetallesReferencia(connexion,referencia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesReferencia(Connexion connexion,Referencia referencia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(referencia.getIsNew()||!referencia.getid_empresa().equals(referencia.getReferenciaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referencia.getReferenciaOriginal().getid_empresa()!=null)
				{
					strValorActual=referencia.getReferenciaOriginal().getid_empresa().toString();
				}
				if(referencia.getid_empresa()!=null)
				{
					strValorNuevo=referencia.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(referencia.getIsNew()||!referencia.getid_empleado().equals(referencia.getReferenciaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referencia.getReferenciaOriginal().getid_empleado()!=null)
				{
					strValorActual=referencia.getReferenciaOriginal().getid_empleado().toString();
				}
				if(referencia.getid_empleado()!=null)
				{
					strValorNuevo=referencia.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(referencia.getIsNew()||!referencia.getid_parentezco().equals(referencia.getReferenciaOriginal().getid_parentezco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referencia.getReferenciaOriginal().getid_parentezco()!=null)
				{
					strValorActual=referencia.getReferenciaOriginal().getid_parentezco().toString();
				}
				if(referencia.getid_parentezco()!=null)
				{
					strValorNuevo=referencia.getid_parentezco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaConstantesFunciones.IDPARENTEZCO,strValorActual,strValorNuevo);
			}	
			
			if(referencia.getIsNew()||!referencia.getid_profesion().equals(referencia.getReferenciaOriginal().getid_profesion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referencia.getReferenciaOriginal().getid_profesion()!=null)
				{
					strValorActual=referencia.getReferenciaOriginal().getid_profesion().toString();
				}
				if(referencia.getid_profesion()!=null)
				{
					strValorNuevo=referencia.getid_profesion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaConstantesFunciones.IDPROFESION,strValorActual,strValorNuevo);
			}	
			
			if(referencia.getIsNew()||!referencia.getcedula().equals(referencia.getReferenciaOriginal().getcedula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referencia.getReferenciaOriginal().getcedula()!=null)
				{
					strValorActual=referencia.getReferenciaOriginal().getcedula();
				}
				if(referencia.getcedula()!=null)
				{
					strValorNuevo=referencia.getcedula() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaConstantesFunciones.CEDULA,strValorActual,strValorNuevo);
			}	
			
			if(referencia.getIsNew()||!referencia.getapellido().equals(referencia.getReferenciaOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referencia.getReferenciaOriginal().getapellido()!=null)
				{
					strValorActual=referencia.getReferenciaOriginal().getapellido();
				}
				if(referencia.getapellido()!=null)
				{
					strValorNuevo=referencia.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(referencia.getIsNew()||!referencia.getnombre().equals(referencia.getReferenciaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referencia.getReferenciaOriginal().getnombre()!=null)
				{
					strValorActual=referencia.getReferenciaOriginal().getnombre();
				}
				if(referencia.getnombre()!=null)
				{
					strValorNuevo=referencia.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(referencia.getIsNew()||!referencia.getdireccion().equals(referencia.getReferenciaOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referencia.getReferenciaOriginal().getdireccion()!=null)
				{
					strValorActual=referencia.getReferenciaOriginal().getdireccion();
				}
				if(referencia.getdireccion()!=null)
				{
					strValorNuevo=referencia.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(referencia.getIsNew()||!referencia.gettelefono().equals(referencia.getReferenciaOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referencia.getReferenciaOriginal().gettelefono()!=null)
				{
					strValorActual=referencia.getReferenciaOriginal().gettelefono();
				}
				if(referencia.gettelefono()!=null)
				{
					strValorNuevo=referencia.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveReferenciaRelacionesWithConnection(Referencia referencia,List<TelefonoReferencia> telefonoreferencias) throws Exception {

		if(!referencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveReferenciaRelacionesBase(referencia,telefonoreferencias,true);
		}
	}

	public void saveReferenciaRelaciones(Referencia referencia,List<TelefonoReferencia> telefonoreferencias)throws Exception {

		if(!referencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveReferenciaRelacionesBase(referencia,telefonoreferencias,false);
		}
	}

	public void saveReferenciaRelacionesBase(Referencia referencia,List<TelefonoReferencia> telefonoreferencias,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Referencia-saveRelacionesWithConnection");}
	
			referencia.setTelefonoReferencias(telefonoreferencias);

			this.setReferencia(referencia);

			if(ReferenciaLogicAdditional.validarSaveRelaciones(referencia,this)) {

				ReferenciaLogicAdditional.updateRelacionesToSave(referencia,this);

				if((referencia.getIsNew()||referencia.getIsChanged())&&!referencia.getIsDeleted()) {
					this.saveReferencia();
					this.saveReferenciaRelacionesDetalles(telefonoreferencias);

				} else if(referencia.getIsDeleted()) {
					this.saveReferenciaRelacionesDetalles(telefonoreferencias);
					this.saveReferencia();
				}

				ReferenciaLogicAdditional.updateRelacionesToSaveAfter(referencia,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TelefonoReferenciaConstantesFunciones.InicializarGeneralEntityAuxiliaresTelefonoReferencias(telefonoreferencias,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveReferenciaRelacionesDetalles(List<TelefonoReferencia> telefonoreferencias)throws Exception {
		try {
	

			Long idReferenciaActual=this.getReferencia().getId();

			TelefonoReferenciaLogic telefonoreferenciaLogic_Desde_Referencia=new TelefonoReferenciaLogic();
			telefonoreferenciaLogic_Desde_Referencia.setTelefonoReferencias(telefonoreferencias);

			telefonoreferenciaLogic_Desde_Referencia.setConnexion(this.getConnexion());
			telefonoreferenciaLogic_Desde_Referencia.setDatosCliente(this.datosCliente);

			for(TelefonoReferencia telefonoreferencia_Desde_Referencia:telefonoreferenciaLogic_Desde_Referencia.getTelefonoReferencias()) {
				telefonoreferencia_Desde_Referencia.setid_referencia(idReferenciaActual);
			}

			telefonoreferenciaLogic_Desde_Referencia.saveTelefonoReferencias();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfReferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ReferenciaConstantesFunciones.getClassesForeignKeysOfReferencia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ReferenciaConstantesFunciones.getClassesRelationshipsOfReferencia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

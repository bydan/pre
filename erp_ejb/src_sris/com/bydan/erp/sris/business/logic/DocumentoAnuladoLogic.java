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
package com.bydan.erp.sris.business.logic;

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
import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.util.DocumentoAnuladoConstantesFunciones;
import com.bydan.erp.sris.util.DocumentoAnuladoParameterReturnGeneral;
//import com.bydan.erp.sris.util.DocumentoAnuladoParameterGeneral;
import com.bydan.erp.sris.business.entity.DocumentoAnulado;
import com.bydan.erp.sris.business.logic.DocumentoAnuladoLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DocumentoAnuladoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DocumentoAnuladoLogic.class);
	
	protected DocumentoAnuladoDataAccess documentoanuladoDataAccess; 	
	protected DocumentoAnulado documentoanulado;
	protected List<DocumentoAnulado> documentoanulados;
	protected Object documentoanuladoObject;	
	protected List<Object> documentoanuladosObject;
	
	public static ClassValidator<DocumentoAnulado> documentoanuladoValidator = new ClassValidator<DocumentoAnulado>(DocumentoAnulado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DocumentoAnuladoLogicAdditional documentoanuladoLogicAdditional=null;
	
	public DocumentoAnuladoLogicAdditional getDocumentoAnuladoLogicAdditional() {
		return this.documentoanuladoLogicAdditional;
	}
	
	public void setDocumentoAnuladoLogicAdditional(DocumentoAnuladoLogicAdditional documentoanuladoLogicAdditional) {
		try {
			this.documentoanuladoLogicAdditional=documentoanuladoLogicAdditional;
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
	
	
	
	
	public  DocumentoAnuladoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.documentoanuladoDataAccess = new DocumentoAnuladoDataAccess();
			
			this.documentoanulados= new ArrayList<DocumentoAnulado>();
			this.documentoanulado= new DocumentoAnulado();
			
			this.documentoanuladoObject=new Object();
			this.documentoanuladosObject=new ArrayList<Object>();
				
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
			
			this.documentoanuladoDataAccess.setConnexionType(this.connexionType);
			this.documentoanuladoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DocumentoAnuladoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.documentoanuladoDataAccess = new DocumentoAnuladoDataAccess();
			this.documentoanulados= new ArrayList<DocumentoAnulado>();
			this.documentoanulado= new DocumentoAnulado();
			this.documentoanuladoObject=new Object();
			this.documentoanuladosObject=new ArrayList<Object>();
			
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
			
			this.documentoanuladoDataAccess.setConnexionType(this.connexionType);
			this.documentoanuladoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DocumentoAnulado getDocumentoAnulado() throws Exception {	
		DocumentoAnuladoLogicAdditional.checkDocumentoAnuladoToGet(documentoanulado,this.datosCliente,this.arrDatoGeneral);
		DocumentoAnuladoLogicAdditional.updateDocumentoAnuladoToGet(documentoanulado,this.arrDatoGeneral);
		
		return documentoanulado;
	}
		
	public void setDocumentoAnulado(DocumentoAnulado newDocumentoAnulado) {
		this.documentoanulado = newDocumentoAnulado;
	}
	
	public DocumentoAnuladoDataAccess getDocumentoAnuladoDataAccess() {
		return documentoanuladoDataAccess;
	}
	
	public void setDocumentoAnuladoDataAccess(DocumentoAnuladoDataAccess newdocumentoanuladoDataAccess) {
		this.documentoanuladoDataAccess = newdocumentoanuladoDataAccess;
	}
	
	public List<DocumentoAnulado> getDocumentoAnulados() throws Exception {		
		this.quitarDocumentoAnuladosNulos();
		
		DocumentoAnuladoLogicAdditional.checkDocumentoAnuladoToGets(documentoanulados,this.datosCliente,this.arrDatoGeneral);
		
		for (DocumentoAnulado documentoanuladoLocal: documentoanulados ) {
			DocumentoAnuladoLogicAdditional.updateDocumentoAnuladoToGet(documentoanuladoLocal,this.arrDatoGeneral);
		}
		
		return documentoanulados;
	}
	
	public void setDocumentoAnulados(List<DocumentoAnulado> newDocumentoAnulados) {
		this.documentoanulados = newDocumentoAnulados;
	}
	
	public Object getDocumentoAnuladoObject() {	
		this.documentoanuladoObject=this.documentoanuladoDataAccess.getEntityObject();
		return this.documentoanuladoObject;
	}
		
	public void setDocumentoAnuladoObject(Object newDocumentoAnuladoObject) {
		this.documentoanuladoObject = newDocumentoAnuladoObject;
	}
	
	public List<Object> getDocumentoAnuladosObject() {		
		this.documentoanuladosObject=this.documentoanuladoDataAccess.getEntitiesObject();
		return this.documentoanuladosObject;
	}
		
	public void setDocumentoAnuladosObject(List<Object> newDocumentoAnuladosObject) {
		this.documentoanuladosObject = newDocumentoAnuladosObject;
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
		
		if(this.documentoanuladoDataAccess!=null) {
			this.documentoanuladoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			documentoanuladoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			documentoanuladoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		documentoanulado = new  DocumentoAnulado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			documentoanulado=documentoanuladoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.documentoanulado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulado);
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
		documentoanulado = new  DocumentoAnulado();
		  		  
        try {
			
			documentoanulado=documentoanuladoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.documentoanulado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		documentoanulado = new  DocumentoAnulado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			documentoanulado=documentoanuladoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.documentoanulado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulado);
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
		documentoanulado = new  DocumentoAnulado();
		  		  
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
		documentoanulado = new  DocumentoAnulado();
		  		  
        try {
			
			documentoanulado=documentoanuladoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.documentoanulado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		documentoanulado = new  DocumentoAnulado();
		  		  
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
		documentoanulado = new  DocumentoAnulado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =documentoanuladoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		documentoanulado = new  DocumentoAnulado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=documentoanuladoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		documentoanulado = new  DocumentoAnulado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =documentoanuladoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		documentoanulado = new  DocumentoAnulado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=documentoanuladoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		documentoanulado = new  DocumentoAnulado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =documentoanuladoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		documentoanulado = new  DocumentoAnulado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=documentoanuladoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulados=documentoanuladoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
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
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		  		  
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
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		  		  
        try {			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulados=documentoanuladoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDocumentoAnulado(documentoanulados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		  		  
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
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
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
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		  		  
        try {
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
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
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
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
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		documentoanulado = new  DocumentoAnulado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulado=documentoanuladoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulado);
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
		documentoanulado = new  DocumentoAnulado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulado=documentoanuladoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulados=documentoanuladoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
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
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		  		  
        try {
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulados=documentoanuladoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDocumentoAnuladosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getTodosDocumentoAnuladosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
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
	
	public  void  getTodosDocumentoAnulados(String sFinalQuery,Pagination pagination)throws Exception {
		documentoanulados = new  ArrayList<DocumentoAnulado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDocumentoAnulado(documentoanulados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDocumentoAnulado(DocumentoAnulado documentoanulado) throws Exception {
		Boolean estaValidado=false;
		
		if(documentoanulado.getIsNew() || documentoanulado.getIsChanged()) { 
			this.invalidValues = documentoanuladoValidator.getInvalidValues(documentoanulado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(documentoanulado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDocumentoAnulado(List<DocumentoAnulado> DocumentoAnulados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DocumentoAnulado documentoanuladoLocal:documentoanulados) {				
			estaValidadoObjeto=this.validarGuardarDocumentoAnulado(documentoanuladoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDocumentoAnulado(List<DocumentoAnulado> DocumentoAnulados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDocumentoAnulado(documentoanulados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDocumentoAnulado(DocumentoAnulado DocumentoAnulado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDocumentoAnulado(documentoanulado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DocumentoAnulado documentoanulado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+documentoanulado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DocumentoAnuladoConstantesFunciones.getDocumentoAnuladoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"documentoanulado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DocumentoAnuladoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DocumentoAnuladoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDocumentoAnuladoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-saveDocumentoAnuladoWithConnection");connexion.begin();			
			
			DocumentoAnuladoLogicAdditional.checkDocumentoAnuladoToSave(this.documentoanulado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DocumentoAnuladoLogicAdditional.updateDocumentoAnuladoToSave(this.documentoanulado,this.arrDatoGeneral);
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.documentoanulado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDocumentoAnulado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDocumentoAnulado(this.documentoanulado)) {
				DocumentoAnuladoDataAccess.save(this.documentoanulado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.documentoanulado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DocumentoAnuladoLogicAdditional.checkDocumentoAnuladoToSaveAfter(this.documentoanulado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDocumentoAnulado();
			
			connexion.commit();			
			
			if(this.documentoanulado.getIsDeleted()) {
				this.documentoanulado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDocumentoAnulado()throws Exception {	
		try {	
			
			DocumentoAnuladoLogicAdditional.checkDocumentoAnuladoToSave(this.documentoanulado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DocumentoAnuladoLogicAdditional.updateDocumentoAnuladoToSave(this.documentoanulado,this.arrDatoGeneral);
			
			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.documentoanulado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDocumentoAnulado(this.documentoanulado)) {			
				DocumentoAnuladoDataAccess.save(this.documentoanulado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.documentoanulado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DocumentoAnuladoLogicAdditional.checkDocumentoAnuladoToSaveAfter(this.documentoanulado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.documentoanulado.getIsDeleted()) {
				this.documentoanulado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDocumentoAnuladosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-saveDocumentoAnuladosWithConnection");connexion.begin();			
			
			DocumentoAnuladoLogicAdditional.checkDocumentoAnuladoToSaves(documentoanulados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDocumentoAnulados();
			
			Boolean validadoTodosDocumentoAnulado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DocumentoAnulado documentoanuladoLocal:documentoanulados) {		
				if(documentoanuladoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DocumentoAnuladoLogicAdditional.updateDocumentoAnuladoToSave(documentoanuladoLocal,this.arrDatoGeneral);
	        	
				DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),documentoanuladoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDocumentoAnulado(documentoanuladoLocal)) {
					DocumentoAnuladoDataAccess.save(documentoanuladoLocal, connexion);				
				} else {
					validadoTodosDocumentoAnulado=false;
				}
			}
			
			if(!validadoTodosDocumentoAnulado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DocumentoAnuladoLogicAdditional.checkDocumentoAnuladoToSavesAfter(documentoanulados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDocumentoAnulados();
			
			connexion.commit();		
			
			this.quitarDocumentoAnuladosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDocumentoAnulados()throws Exception {				
		 try {	
			DocumentoAnuladoLogicAdditional.checkDocumentoAnuladoToSaves(documentoanulados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDocumentoAnulado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DocumentoAnulado documentoanuladoLocal:documentoanulados) {				
				if(documentoanuladoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DocumentoAnuladoLogicAdditional.updateDocumentoAnuladoToSave(documentoanuladoLocal,this.arrDatoGeneral);
	        	
				DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),documentoanuladoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDocumentoAnulado(documentoanuladoLocal)) {				
					DocumentoAnuladoDataAccess.save(documentoanuladoLocal, connexion);				
				} else {
					validadoTodosDocumentoAnulado=false;
				}
			}
			
			if(!validadoTodosDocumentoAnulado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DocumentoAnuladoLogicAdditional.checkDocumentoAnuladoToSavesAfter(documentoanulados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDocumentoAnuladosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DocumentoAnuladoParameterReturnGeneral procesarAccionDocumentoAnulados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DocumentoAnulado> documentoanulados,DocumentoAnuladoParameterReturnGeneral documentoanuladoParameterGeneral)throws Exception {
		 try {	
			DocumentoAnuladoParameterReturnGeneral documentoanuladoReturnGeneral=new DocumentoAnuladoParameterReturnGeneral();
	
			DocumentoAnuladoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,documentoanulados,documentoanuladoParameterGeneral,documentoanuladoReturnGeneral);
			
			return documentoanuladoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DocumentoAnuladoParameterReturnGeneral procesarAccionDocumentoAnuladosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DocumentoAnulado> documentoanulados,DocumentoAnuladoParameterReturnGeneral documentoanuladoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-procesarAccionDocumentoAnuladosWithConnection");connexion.begin();			
			
			DocumentoAnuladoParameterReturnGeneral documentoanuladoReturnGeneral=new DocumentoAnuladoParameterReturnGeneral();
	
			DocumentoAnuladoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,documentoanulados,documentoanuladoParameterGeneral,documentoanuladoReturnGeneral);
			
			this.connexion.commit();
			
			return documentoanuladoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DocumentoAnuladoParameterReturnGeneral procesarEventosDocumentoAnulados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DocumentoAnulado> documentoanulados,DocumentoAnulado documentoanulado,DocumentoAnuladoParameterReturnGeneral documentoanuladoParameterGeneral,Boolean isEsNuevoDocumentoAnulado,ArrayList<Classe> clases)throws Exception {
		 try {	
			DocumentoAnuladoParameterReturnGeneral documentoanuladoReturnGeneral=new DocumentoAnuladoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				documentoanuladoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DocumentoAnuladoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,documentoanulados,documentoanulado,documentoanuladoParameterGeneral,documentoanuladoReturnGeneral,isEsNuevoDocumentoAnulado,clases);
			
			return documentoanuladoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DocumentoAnuladoParameterReturnGeneral procesarEventosDocumentoAnuladosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DocumentoAnulado> documentoanulados,DocumentoAnulado documentoanulado,DocumentoAnuladoParameterReturnGeneral documentoanuladoParameterGeneral,Boolean isEsNuevoDocumentoAnulado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-procesarEventosDocumentoAnuladosWithConnection");connexion.begin();			
			
			DocumentoAnuladoParameterReturnGeneral documentoanuladoReturnGeneral=new DocumentoAnuladoParameterReturnGeneral();
	
			documentoanuladoReturnGeneral.setDocumentoAnulado(documentoanulado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				documentoanuladoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DocumentoAnuladoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,documentoanulados,documentoanulado,documentoanuladoParameterGeneral,documentoanuladoReturnGeneral,isEsNuevoDocumentoAnulado,clases);
			
			this.connexion.commit();
			
			return documentoanuladoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DocumentoAnuladoParameterReturnGeneral procesarImportacionDocumentoAnuladosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DocumentoAnuladoParameterReturnGeneral documentoanuladoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-procesarImportacionDocumentoAnuladosWithConnection");connexion.begin();			
			
			DocumentoAnuladoParameterReturnGeneral documentoanuladoReturnGeneral=new DocumentoAnuladoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.documentoanulados=new ArrayList<DocumentoAnulado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.documentoanulado=new DocumentoAnulado();
				
				
				if(conColumnasBase) {this.documentoanulado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.documentoanulado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.documentoanulado.setnumero(arrColumnas[iColumn++]);
				this.documentoanulado.setserie(arrColumnas[iColumn++]);
				this.documentoanulado.setautorizacion(arrColumnas[iColumn++]);
				this.documentoanulado.setfecha_anulacion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.documentoanulados.add(this.documentoanulado);
			}
			
			this.saveDocumentoAnulados();
			
			this.connexion.commit();
			
			documentoanuladoReturnGeneral.setConRetornoEstaProcesado(true);
			documentoanuladoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return documentoanuladoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDocumentoAnuladosEliminados() throws Exception {				
		
		List<DocumentoAnulado> documentoanuladosAux= new ArrayList<DocumentoAnulado>();
		
		for(DocumentoAnulado documentoanulado:documentoanulados) {
			if(!documentoanulado.getIsDeleted()) {
				documentoanuladosAux.add(documentoanulado);
			}
		}
		
		documentoanulados=documentoanuladosAux;
	}
	
	public void quitarDocumentoAnuladosNulos() throws Exception {				
		
		List<DocumentoAnulado> documentoanuladosAux= new ArrayList<DocumentoAnulado>();
		
		for(DocumentoAnulado documentoanulado : this.documentoanulados) {
			if(documentoanulado==null) {
				documentoanuladosAux.add(documentoanulado);
			}
		}
		
		//this.documentoanulados=documentoanuladosAux;
		
		this.documentoanulados.removeAll(documentoanuladosAux);
	}
	
	public void getSetVersionRowDocumentoAnuladoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(documentoanulado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((documentoanulado.getIsDeleted() || (documentoanulado.getIsChanged()&&!documentoanulado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=documentoanuladoDataAccess.getSetVersionRowDocumentoAnulado(connexion,documentoanulado.getId());
				
				if(!documentoanulado.getVersionRow().equals(timestamp)) {	
					documentoanulado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				documentoanulado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDocumentoAnulado()throws Exception {	
		
		if(documentoanulado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((documentoanulado.getIsDeleted() || (documentoanulado.getIsChanged()&&!documentoanulado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=documentoanuladoDataAccess.getSetVersionRowDocumentoAnulado(connexion,documentoanulado.getId());
			
			try {							
				if(!documentoanulado.getVersionRow().equals(timestamp)) {	
					documentoanulado.setVersionRow(timestamp);
				}
				
				documentoanulado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDocumentoAnuladosWithConnection()throws Exception {	
		if(documentoanulados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DocumentoAnulado documentoanuladoAux:documentoanulados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(documentoanuladoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(documentoanuladoAux.getIsDeleted() || (documentoanuladoAux.getIsChanged()&&!documentoanuladoAux.getIsNew())) {
						
						timestamp=documentoanuladoDataAccess.getSetVersionRowDocumentoAnulado(connexion,documentoanuladoAux.getId());
						
						if(!documentoanulado.getVersionRow().equals(timestamp)) {	
							documentoanuladoAux.setVersionRow(timestamp);
						}
								
						documentoanuladoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDocumentoAnulados()throws Exception {	
		if(documentoanulados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DocumentoAnulado documentoanuladoAux:documentoanulados) {
					if(documentoanuladoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(documentoanuladoAux.getIsDeleted() || (documentoanuladoAux.getIsChanged()&&!documentoanuladoAux.getIsNew())) {
						
						timestamp=documentoanuladoDataAccess.getSetVersionRowDocumentoAnulado(connexion,documentoanuladoAux.getId());
						
						if(!documentoanuladoAux.getVersionRow().equals(timestamp)) {	
							documentoanuladoAux.setVersionRow(timestamp);
						}
						
													
						documentoanuladoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DocumentoAnuladoParameterReturnGeneral cargarCombosLoteForeignKeyDocumentoAnuladoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalPeriodoDeclara,String finalQueryGlobalModulo,String finalQueryGlobalTipoComprobante) throws Exception {
		DocumentoAnuladoParameterReturnGeneral  documentoanuladoReturnGeneral =new DocumentoAnuladoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-cargarCombosLoteForeignKeyDocumentoAnuladoWithConnection");connexion.begin();
			
			documentoanuladoReturnGeneral =new DocumentoAnuladoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			documentoanuladoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<PeriodoDeclara> periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
			PeriodoDeclaraLogic periododeclaraLogic=new PeriodoDeclaraLogic();
			periododeclaraLogic.setConnexion(this.connexion);
			periododeclaraLogic.getPeriodoDeclaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodoDeclara.equals("NONE")) {
				periododeclaraLogic.getTodosPeriodoDeclaras(finalQueryGlobalPeriodoDeclara,new Pagination());
				periododeclarasForeignKey=periododeclaraLogic.getPeriodoDeclaras();
			}

			documentoanuladoReturnGeneral.setperiododeclarasForeignKey(periododeclarasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			documentoanuladoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoComprobante> tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobanteLogic=new TipoComprobanteLogic();
			tipocomprobanteLogic.setConnexion(this.connexion);
			tipocomprobanteLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobante.equals("NONE")) {
				tipocomprobanteLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobante,new Pagination());
				tipocomprobantesForeignKey=tipocomprobanteLogic.getTipoComprobantes();
			}

			documentoanuladoReturnGeneral.settipocomprobantesForeignKey(tipocomprobantesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return documentoanuladoReturnGeneral;
	}
	
	public DocumentoAnuladoParameterReturnGeneral cargarCombosLoteForeignKeyDocumentoAnulado(String finalQueryGlobalEmpresa,String finalQueryGlobalPeriodoDeclara,String finalQueryGlobalModulo,String finalQueryGlobalTipoComprobante) throws Exception {
		DocumentoAnuladoParameterReturnGeneral  documentoanuladoReturnGeneral =new DocumentoAnuladoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			documentoanuladoReturnGeneral =new DocumentoAnuladoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			documentoanuladoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<PeriodoDeclara> periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
			PeriodoDeclaraLogic periododeclaraLogic=new PeriodoDeclaraLogic();
			periododeclaraLogic.setConnexion(this.connexion);
			periododeclaraLogic.getPeriodoDeclaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodoDeclara.equals("NONE")) {
				periododeclaraLogic.getTodosPeriodoDeclaras(finalQueryGlobalPeriodoDeclara,new Pagination());
				periododeclarasForeignKey=periododeclaraLogic.getPeriodoDeclaras();
			}

			documentoanuladoReturnGeneral.setperiododeclarasForeignKey(periododeclarasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			documentoanuladoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoComprobante> tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobanteLogic=new TipoComprobanteLogic();
			tipocomprobanteLogic.setConnexion(this.connexion);
			tipocomprobanteLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobante.equals("NONE")) {
				tipocomprobanteLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobante,new Pagination());
				tipocomprobantesForeignKey=tipocomprobanteLogic.getTipoComprobantes();
			}

			documentoanuladoReturnGeneral.settipocomprobantesForeignKey(tipocomprobantesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return documentoanuladoReturnGeneral;
	}
	
	
	public void deepLoad(DocumentoAnulado documentoanulado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DocumentoAnuladoLogicAdditional.updateDocumentoAnuladoToGet(documentoanulado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		documentoanulado.setEmpresa(documentoanuladoDataAccess.getEmpresa(connexion,documentoanulado));
		documentoanulado.setPeriodoDeclara(documentoanuladoDataAccess.getPeriodoDeclara(connexion,documentoanulado));
		documentoanulado.setModulo(documentoanuladoDataAccess.getModulo(connexion,documentoanulado));
		documentoanulado.setTipoComprobante(documentoanuladoDataAccess.getTipoComprobante(connexion,documentoanulado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				documentoanulado.setEmpresa(documentoanuladoDataAccess.getEmpresa(connexion,documentoanulado));
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				documentoanulado.setPeriodoDeclara(documentoanuladoDataAccess.getPeriodoDeclara(connexion,documentoanulado));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				documentoanulado.setModulo(documentoanuladoDataAccess.getModulo(connexion,documentoanulado));
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				documentoanulado.setTipoComprobante(documentoanuladoDataAccess.getTipoComprobante(connexion,documentoanulado));
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
			documentoanulado.setEmpresa(documentoanuladoDataAccess.getEmpresa(connexion,documentoanulado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			documentoanulado.setPeriodoDeclara(documentoanuladoDataAccess.getPeriodoDeclara(connexion,documentoanulado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			documentoanulado.setModulo(documentoanuladoDataAccess.getModulo(connexion,documentoanulado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			documentoanulado.setTipoComprobante(documentoanuladoDataAccess.getTipoComprobante(connexion,documentoanulado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		documentoanulado.setEmpresa(documentoanuladoDataAccess.getEmpresa(connexion,documentoanulado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(documentoanulado.getEmpresa(),isDeep,deepLoadType,clases);
				
		documentoanulado.setPeriodoDeclara(documentoanuladoDataAccess.getPeriodoDeclara(connexion,documentoanulado));
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(documentoanulado.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		documentoanulado.setModulo(documentoanuladoDataAccess.getModulo(connexion,documentoanulado));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(documentoanulado.getModulo(),isDeep,deepLoadType,clases);
				
		documentoanulado.setTipoComprobante(documentoanuladoDataAccess.getTipoComprobante(connexion,documentoanulado));
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(documentoanulado.getTipoComprobante(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				documentoanulado.setEmpresa(documentoanuladoDataAccess.getEmpresa(connexion,documentoanulado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(documentoanulado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				documentoanulado.setPeriodoDeclara(documentoanuladoDataAccess.getPeriodoDeclara(connexion,documentoanulado));
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepLoad(documentoanulado.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				documentoanulado.setModulo(documentoanuladoDataAccess.getModulo(connexion,documentoanulado));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(documentoanulado.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				documentoanulado.setTipoComprobante(documentoanuladoDataAccess.getTipoComprobante(connexion,documentoanulado));
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepLoad(documentoanulado.getTipoComprobante(),isDeep,deepLoadType,clases);				
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
			documentoanulado.setEmpresa(documentoanuladoDataAccess.getEmpresa(connexion,documentoanulado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(documentoanulado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			documentoanulado.setPeriodoDeclara(documentoanuladoDataAccess.getPeriodoDeclara(connexion,documentoanulado));
			PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
			periododeclaraLogic.deepLoad(documentoanulado.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			documentoanulado.setModulo(documentoanuladoDataAccess.getModulo(connexion,documentoanulado));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(documentoanulado.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			documentoanulado.setTipoComprobante(documentoanuladoDataAccess.getTipoComprobante(connexion,documentoanulado));
			TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
			tipocomprobanteLogic.deepLoad(documentoanulado.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DocumentoAnulado documentoanulado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DocumentoAnuladoLogicAdditional.updateDocumentoAnuladoToSave(documentoanulado,this.arrDatoGeneral);
			
DocumentoAnuladoDataAccess.save(documentoanulado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(documentoanulado.getEmpresa(),connexion);

		PeriodoDeclaraDataAccess.save(documentoanulado.getPeriodoDeclara(),connexion);

		ModuloDataAccess.save(documentoanulado.getModulo(),connexion);

		TipoComprobanteDataAccess.save(documentoanulado.getTipoComprobante(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(documentoanulado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				PeriodoDeclaraDataAccess.save(documentoanulado.getPeriodoDeclara(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(documentoanulado.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(documentoanulado.getTipoComprobante(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(documentoanulado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(documentoanulado.getEmpresa(),isDeep,deepLoadType,clases);
				

		PeriodoDeclaraDataAccess.save(documentoanulado.getPeriodoDeclara(),connexion);
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(documentoanulado.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(documentoanulado.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(documentoanulado.getModulo(),isDeep,deepLoadType,clases);
				

		TipoComprobanteDataAccess.save(documentoanulado.getTipoComprobante(),connexion);
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(documentoanulado.getTipoComprobante(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(documentoanulado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(documentoanulado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				PeriodoDeclaraDataAccess.save(documentoanulado.getPeriodoDeclara(),connexion);
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepSave(documentoanulado.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(documentoanulado.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(documentoanulado.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(documentoanulado.getTipoComprobante(),connexion);
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepSave(documentoanulado.getTipoComprobante(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DocumentoAnulado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(documentoanulado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(documentoanulado);
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
			this.deepLoad(this.documentoanulado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DocumentoAnulado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(documentoanulados!=null) {
				for(DocumentoAnulado documentoanulado:documentoanulados) {
					this.deepLoad(documentoanulado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(documentoanulados);
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
			if(documentoanulados!=null) {
				for(DocumentoAnulado documentoanulado:documentoanulados) {
					this.deepLoad(documentoanulado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(documentoanulados);
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
			this.getNewConnexionToDeep(DocumentoAnulado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(documentoanulado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DocumentoAnulado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(documentoanulados!=null) {
				for(DocumentoAnulado documentoanulado:documentoanulados) {
					this.deepSave(documentoanulado,isDeep,deepLoadType,clases);
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
			if(documentoanulados!=null) {
				for(DocumentoAnulado documentoanulado:documentoanulados) {
					this.deepSave(documentoanulado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDocumentoAnuladosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DocumentoAnuladoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDocumentoAnuladosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DocumentoAnuladoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDocumentoAnuladosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DocumentoAnuladoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDocumentoAnuladosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DocumentoAnuladoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDocumentoAnuladosFK_IdPeriodoDeclaraWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo_declara)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodoDeclara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodoDeclara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo_declara,DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodoDeclara);

			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodoDeclara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDocumentoAnuladosFK_IdPeriodoDeclara(String sFinalQuery,Pagination pagination,Long id_periodo_declara)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodoDeclara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodoDeclara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo_declara,DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodoDeclara);

			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodoDeclara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDocumentoAnuladosFK_IdTipoComprobanteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_comprobante)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DocumentoAnulado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobante.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comprobante,DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobante);

			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDocumentoAnuladosFK_IdTipoComprobante(String sFinalQuery,Pagination pagination,Long id_tipo_comprobante)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobante.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comprobante,DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobante);

			DocumentoAnuladoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(this.documentoanulados);
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
			if(DocumentoAnuladoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DocumentoAnuladoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DocumentoAnulado documentoanulado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DocumentoAnuladoConstantesFunciones.ISCONAUDITORIA) {
				if(documentoanulado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DocumentoAnuladoDataAccess.TABLENAME, documentoanulado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DocumentoAnuladoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DocumentoAnuladoLogic.registrarAuditoriaDetallesDocumentoAnulado(connexion,documentoanulado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(documentoanulado.getIsDeleted()) {
					/*if(!documentoanulado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DocumentoAnuladoDataAccess.TABLENAME, documentoanulado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DocumentoAnuladoLogic.registrarAuditoriaDetallesDocumentoAnulado(connexion,documentoanulado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DocumentoAnuladoDataAccess.TABLENAME, documentoanulado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(documentoanulado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DocumentoAnuladoDataAccess.TABLENAME, documentoanulado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DocumentoAnuladoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DocumentoAnuladoLogic.registrarAuditoriaDetallesDocumentoAnulado(connexion,documentoanulado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDocumentoAnulado(Connexion connexion,DocumentoAnulado documentoanulado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(documentoanulado.getIsNew()||!documentoanulado.getid_empresa().equals(documentoanulado.getDocumentoAnuladoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(documentoanulado.getDocumentoAnuladoOriginal().getid_empresa()!=null)
				{
					strValorActual=documentoanulado.getDocumentoAnuladoOriginal().getid_empresa().toString();
				}
				if(documentoanulado.getid_empresa()!=null)
				{
					strValorNuevo=documentoanulado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DocumentoAnuladoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(documentoanulado.getIsNew()||!documentoanulado.getid_periodo_declara().equals(documentoanulado.getDocumentoAnuladoOriginal().getid_periodo_declara()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(documentoanulado.getDocumentoAnuladoOriginal().getid_periodo_declara()!=null)
				{
					strValorActual=documentoanulado.getDocumentoAnuladoOriginal().getid_periodo_declara().toString();
				}
				if(documentoanulado.getid_periodo_declara()!=null)
				{
					strValorNuevo=documentoanulado.getid_periodo_declara().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA,strValorActual,strValorNuevo);
			}	
			
			if(documentoanulado.getIsNew()||!documentoanulado.getid_modulo().equals(documentoanulado.getDocumentoAnuladoOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(documentoanulado.getDocumentoAnuladoOriginal().getid_modulo()!=null)
				{
					strValorActual=documentoanulado.getDocumentoAnuladoOriginal().getid_modulo().toString();
				}
				if(documentoanulado.getid_modulo()!=null)
				{
					strValorNuevo=documentoanulado.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DocumentoAnuladoConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(documentoanulado.getIsNew()||!documentoanulado.getid_tipo_comprobante().equals(documentoanulado.getDocumentoAnuladoOriginal().getid_tipo_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(documentoanulado.getDocumentoAnuladoOriginal().getid_tipo_comprobante()!=null)
				{
					strValorActual=documentoanulado.getDocumentoAnuladoOriginal().getid_tipo_comprobante().toString();
				}
				if(documentoanulado.getid_tipo_comprobante()!=null)
				{
					strValorNuevo=documentoanulado.getid_tipo_comprobante().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(documentoanulado.getIsNew()||!documentoanulado.getnumero().equals(documentoanulado.getDocumentoAnuladoOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(documentoanulado.getDocumentoAnuladoOriginal().getnumero()!=null)
				{
					strValorActual=documentoanulado.getDocumentoAnuladoOriginal().getnumero();
				}
				if(documentoanulado.getnumero()!=null)
				{
					strValorNuevo=documentoanulado.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DocumentoAnuladoConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(documentoanulado.getIsNew()||!documentoanulado.getserie().equals(documentoanulado.getDocumentoAnuladoOriginal().getserie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(documentoanulado.getDocumentoAnuladoOriginal().getserie()!=null)
				{
					strValorActual=documentoanulado.getDocumentoAnuladoOriginal().getserie();
				}
				if(documentoanulado.getserie()!=null)
				{
					strValorNuevo=documentoanulado.getserie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DocumentoAnuladoConstantesFunciones.SERIE,strValorActual,strValorNuevo);
			}	
			
			if(documentoanulado.getIsNew()||!documentoanulado.getautorizacion().equals(documentoanulado.getDocumentoAnuladoOriginal().getautorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(documentoanulado.getDocumentoAnuladoOriginal().getautorizacion()!=null)
				{
					strValorActual=documentoanulado.getDocumentoAnuladoOriginal().getautorizacion();
				}
				if(documentoanulado.getautorizacion()!=null)
				{
					strValorNuevo=documentoanulado.getautorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DocumentoAnuladoConstantesFunciones.AUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(documentoanulado.getIsNew()||!documentoanulado.getfecha_anulacion().equals(documentoanulado.getDocumentoAnuladoOriginal().getfecha_anulacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(documentoanulado.getDocumentoAnuladoOriginal().getfecha_anulacion()!=null)
				{
					strValorActual=documentoanulado.getDocumentoAnuladoOriginal().getfecha_anulacion().toString();
				}
				if(documentoanulado.getfecha_anulacion()!=null)
				{
					strValorNuevo=documentoanulado.getfecha_anulacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DocumentoAnuladoConstantesFunciones.FECHAANULACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDocumentoAnuladoRelacionesWithConnection(DocumentoAnulado documentoanulado) throws Exception {

		if(!documentoanulado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDocumentoAnuladoRelacionesBase(documentoanulado,true);
		}
	}

	public void saveDocumentoAnuladoRelaciones(DocumentoAnulado documentoanulado)throws Exception {

		if(!documentoanulado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDocumentoAnuladoRelacionesBase(documentoanulado,false);
		}
	}

	public void saveDocumentoAnuladoRelacionesBase(DocumentoAnulado documentoanulado,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DocumentoAnulado-saveRelacionesWithConnection");}
	

			this.setDocumentoAnulado(documentoanulado);

			if(DocumentoAnuladoLogicAdditional.validarSaveRelaciones(documentoanulado,this)) {

				DocumentoAnuladoLogicAdditional.updateRelacionesToSave(documentoanulado,this);

				if((documentoanulado.getIsNew()||documentoanulado.getIsChanged())&&!documentoanulado.getIsDeleted()) {
					this.saveDocumentoAnulado();
					this.saveDocumentoAnuladoRelacionesDetalles();

				} else if(documentoanulado.getIsDeleted()) {
					this.saveDocumentoAnuladoRelacionesDetalles();
					this.saveDocumentoAnulado();
				}

				DocumentoAnuladoLogicAdditional.updateRelacionesToSaveAfter(documentoanulado,this);

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
	
	
	private void saveDocumentoAnuladoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDocumentoAnulado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DocumentoAnuladoConstantesFunciones.getClassesForeignKeysOfDocumentoAnulado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDocumentoAnulado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DocumentoAnuladoConstantesFunciones.getClassesRelationshipsOfDocumentoAnulado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

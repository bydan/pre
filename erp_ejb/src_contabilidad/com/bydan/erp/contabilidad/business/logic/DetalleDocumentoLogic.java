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
import com.bydan.erp.contabilidad.util.DetalleDocumentoConstantesFunciones;
import com.bydan.erp.contabilidad.util.DetalleDocumentoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DetalleDocumentoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.DetalleDocumento;
import com.bydan.erp.contabilidad.business.logic.DetalleDocumentoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleDocumentoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleDocumentoLogic.class);
	
	protected DetalleDocumentoDataAccess detalledocumentoDataAccess; 	
	protected DetalleDocumento detalledocumento;
	protected List<DetalleDocumento> detalledocumentos;
	protected Object detalledocumentoObject;	
	protected List<Object> detalledocumentosObject;
	
	public static ClassValidator<DetalleDocumento> detalledocumentoValidator = new ClassValidator<DetalleDocumento>(DetalleDocumento.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleDocumentoLogicAdditional detalledocumentoLogicAdditional=null;
	
	public DetalleDocumentoLogicAdditional getDetalleDocumentoLogicAdditional() {
		return this.detalledocumentoLogicAdditional;
	}
	
	public void setDetalleDocumentoLogicAdditional(DetalleDocumentoLogicAdditional detalledocumentoLogicAdditional) {
		try {
			this.detalledocumentoLogicAdditional=detalledocumentoLogicAdditional;
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
	
	
	
	
	public  DetalleDocumentoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalledocumentoDataAccess = new DetalleDocumentoDataAccess();
			
			this.detalledocumentos= new ArrayList<DetalleDocumento>();
			this.detalledocumento= new DetalleDocumento();
			
			this.detalledocumentoObject=new Object();
			this.detalledocumentosObject=new ArrayList<Object>();
				
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
			
			this.detalledocumentoDataAccess.setConnexionType(this.connexionType);
			this.detalledocumentoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleDocumentoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalledocumentoDataAccess = new DetalleDocumentoDataAccess();
			this.detalledocumentos= new ArrayList<DetalleDocumento>();
			this.detalledocumento= new DetalleDocumento();
			this.detalledocumentoObject=new Object();
			this.detalledocumentosObject=new ArrayList<Object>();
			
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
			
			this.detalledocumentoDataAccess.setConnexionType(this.connexionType);
			this.detalledocumentoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleDocumento getDetalleDocumento() throws Exception {	
		DetalleDocumentoLogicAdditional.checkDetalleDocumentoToGet(detalledocumento,this.datosCliente,this.arrDatoGeneral);
		DetalleDocumentoLogicAdditional.updateDetalleDocumentoToGet(detalledocumento,this.arrDatoGeneral);
		
		return detalledocumento;
	}
		
	public void setDetalleDocumento(DetalleDocumento newDetalleDocumento) {
		this.detalledocumento = newDetalleDocumento;
	}
	
	public DetalleDocumentoDataAccess getDetalleDocumentoDataAccess() {
		return detalledocumentoDataAccess;
	}
	
	public void setDetalleDocumentoDataAccess(DetalleDocumentoDataAccess newdetalledocumentoDataAccess) {
		this.detalledocumentoDataAccess = newdetalledocumentoDataAccess;
	}
	
	public List<DetalleDocumento> getDetalleDocumentos() throws Exception {		
		this.quitarDetalleDocumentosNulos();
		
		DetalleDocumentoLogicAdditional.checkDetalleDocumentoToGets(detalledocumentos,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleDocumento detalledocumentoLocal: detalledocumentos ) {
			DetalleDocumentoLogicAdditional.updateDetalleDocumentoToGet(detalledocumentoLocal,this.arrDatoGeneral);
		}
		
		return detalledocumentos;
	}
	
	public void setDetalleDocumentos(List<DetalleDocumento> newDetalleDocumentos) {
		this.detalledocumentos = newDetalleDocumentos;
	}
	
	public Object getDetalleDocumentoObject() {	
		this.detalledocumentoObject=this.detalledocumentoDataAccess.getEntityObject();
		return this.detalledocumentoObject;
	}
		
	public void setDetalleDocumentoObject(Object newDetalleDocumentoObject) {
		this.detalledocumentoObject = newDetalleDocumentoObject;
	}
	
	public List<Object> getDetalleDocumentosObject() {		
		this.detalledocumentosObject=this.detalledocumentoDataAccess.getEntitiesObject();
		return this.detalledocumentosObject;
	}
		
	public void setDetalleDocumentosObject(List<Object> newDetalleDocumentosObject) {
		this.detalledocumentosObject = newDetalleDocumentosObject;
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
		
		if(this.detalledocumentoDataAccess!=null) {
			this.detalledocumentoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalledocumentoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalledocumentoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalledocumento = new  DetalleDocumento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalledocumento=detalledocumentoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumento);
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
		detalledocumento = new  DetalleDocumento();
		  		  
        try {
			
			detalledocumento=detalledocumentoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalledocumento = new  DetalleDocumento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalledocumento=detalledocumentoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumento);
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
		detalledocumento = new  DetalleDocumento();
		  		  
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
		detalledocumento = new  DetalleDocumento();
		  		  
        try {
			
			detalledocumento=detalledocumentoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalledocumento = new  DetalleDocumento();
		  		  
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
		detalledocumento = new  DetalleDocumento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalledocumentoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalledocumento = new  DetalleDocumento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalledocumentoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalledocumento = new  DetalleDocumento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalledocumentoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalledocumento = new  DetalleDocumento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalledocumentoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalledocumento = new  DetalleDocumento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalledocumentoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalledocumento = new  DetalleDocumento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalledocumentoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleDocumento(detalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
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
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		  		  
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
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		  		  
        try {			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleDocumento(detalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		  		  
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
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleDocumento(detalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
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
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		  		  
        try {
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleDocumento(detalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
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
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleDocumento(detalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
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
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleDocumento(detalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalledocumento = new  DetalleDocumento();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumento=detalledocumentoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleDocumento(detalledocumento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumento);
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
		detalledocumento = new  DetalleDocumento();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumento=detalledocumentoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleDocumento(detalledocumento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumentos=detalledocumentoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleDocumento(detalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
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
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		  		  
        try {
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumentos=detalledocumentoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleDocumento(detalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleDocumentosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getTodosDetalleDocumentosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleDocumento(detalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
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
	
	public  void  getTodosDetalleDocumentos(String sFinalQuery,Pagination pagination)throws Exception {
		detalledocumentos = new  ArrayList<DetalleDocumento>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleDocumento(detalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleDocumento(DetalleDocumento detalledocumento) throws Exception {
		Boolean estaValidado=false;
		
		if(detalledocumento.getIsNew() || detalledocumento.getIsChanged()) { 
			this.invalidValues = detalledocumentoValidator.getInvalidValues(detalledocumento);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalledocumento);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleDocumento(List<DetalleDocumento> DetalleDocumentos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleDocumento detalledocumentoLocal:detalledocumentos) {				
			estaValidadoObjeto=this.validarGuardarDetalleDocumento(detalledocumentoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleDocumento(List<DetalleDocumento> DetalleDocumentos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleDocumento(detalledocumentos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleDocumento(DetalleDocumento DetalleDocumento) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleDocumento(detalledocumento)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleDocumento detalledocumento) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalledocumento.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleDocumentoConstantesFunciones.getDetalleDocumentoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalledocumento","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleDocumentoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleDocumentoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleDocumentoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-saveDetalleDocumentoWithConnection");connexion.begin();			
			
			DetalleDocumentoLogicAdditional.checkDetalleDocumentoToSave(this.detalledocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleDocumentoLogicAdditional.updateDetalleDocumentoToSave(this.detalledocumento,this.arrDatoGeneral);
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalledocumento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleDocumento();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleDocumento(this.detalledocumento)) {
				DetalleDocumentoDataAccess.save(this.detalledocumento, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleDocumentoLogicAdditional.checkDetalleDocumentoToSaveAfter(this.detalledocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleDocumento();
			
			connexion.commit();			
			
			if(this.detalledocumento.getIsDeleted()) {
				this.detalledocumento=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleDocumento()throws Exception {	
		try {	
			
			DetalleDocumentoLogicAdditional.checkDetalleDocumentoToSave(this.detalledocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleDocumentoLogicAdditional.updateDetalleDocumentoToSave(this.detalledocumento,this.arrDatoGeneral);
			
			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalledocumento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleDocumento(this.detalledocumento)) {			
				DetalleDocumentoDataAccess.save(this.detalledocumento, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleDocumentoLogicAdditional.checkDetalleDocumentoToSaveAfter(this.detalledocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalledocumento.getIsDeleted()) {
				this.detalledocumento=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleDocumentosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-saveDetalleDocumentosWithConnection");connexion.begin();			
			
			DetalleDocumentoLogicAdditional.checkDetalleDocumentoToSaves(detalledocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleDocumentos();
			
			Boolean validadoTodosDetalleDocumento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleDocumento detalledocumentoLocal:detalledocumentos) {		
				if(detalledocumentoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleDocumentoLogicAdditional.updateDetalleDocumentoToSave(detalledocumentoLocal,this.arrDatoGeneral);
	        	
				DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalledocumentoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleDocumento(detalledocumentoLocal)) {
					DetalleDocumentoDataAccess.save(detalledocumentoLocal, connexion);				
				} else {
					validadoTodosDetalleDocumento=false;
				}
			}
			
			if(!validadoTodosDetalleDocumento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleDocumentoLogicAdditional.checkDetalleDocumentoToSavesAfter(detalledocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleDocumentos();
			
			connexion.commit();		
			
			this.quitarDetalleDocumentosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleDocumentos()throws Exception {				
		 try {	
			DetalleDocumentoLogicAdditional.checkDetalleDocumentoToSaves(detalledocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleDocumento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleDocumento detalledocumentoLocal:detalledocumentos) {				
				if(detalledocumentoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleDocumentoLogicAdditional.updateDetalleDocumentoToSave(detalledocumentoLocal,this.arrDatoGeneral);
	        	
				DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalledocumentoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleDocumento(detalledocumentoLocal)) {				
					DetalleDocumentoDataAccess.save(detalledocumentoLocal, connexion);				
				} else {
					validadoTodosDetalleDocumento=false;
				}
			}
			
			if(!validadoTodosDetalleDocumento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleDocumentoLogicAdditional.checkDetalleDocumentoToSavesAfter(detalledocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleDocumentosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleDocumentoParameterReturnGeneral procesarAccionDetalleDocumentos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleDocumento> detalledocumentos,DetalleDocumentoParameterReturnGeneral detalledocumentoParameterGeneral)throws Exception {
		 try {	
			DetalleDocumentoParameterReturnGeneral detalledocumentoReturnGeneral=new DetalleDocumentoParameterReturnGeneral();
	
			DetalleDocumentoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalledocumentos,detalledocumentoParameterGeneral,detalledocumentoReturnGeneral);
			
			return detalledocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleDocumentoParameterReturnGeneral procesarAccionDetalleDocumentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleDocumento> detalledocumentos,DetalleDocumentoParameterReturnGeneral detalledocumentoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-procesarAccionDetalleDocumentosWithConnection");connexion.begin();			
			
			DetalleDocumentoParameterReturnGeneral detalledocumentoReturnGeneral=new DetalleDocumentoParameterReturnGeneral();
	
			DetalleDocumentoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalledocumentos,detalledocumentoParameterGeneral,detalledocumentoReturnGeneral);
			
			this.connexion.commit();
			
			return detalledocumentoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleDocumentoParameterReturnGeneral procesarEventosDetalleDocumentos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleDocumento> detalledocumentos,DetalleDocumento detalledocumento,DetalleDocumentoParameterReturnGeneral detalledocumentoParameterGeneral,Boolean isEsNuevoDetalleDocumento,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleDocumentoParameterReturnGeneral detalledocumentoReturnGeneral=new DetalleDocumentoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalledocumentoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleDocumentoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalledocumentos,detalledocumento,detalledocumentoParameterGeneral,detalledocumentoReturnGeneral,isEsNuevoDetalleDocumento,clases);
			
			return detalledocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleDocumentoParameterReturnGeneral procesarEventosDetalleDocumentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleDocumento> detalledocumentos,DetalleDocumento detalledocumento,DetalleDocumentoParameterReturnGeneral detalledocumentoParameterGeneral,Boolean isEsNuevoDetalleDocumento,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-procesarEventosDetalleDocumentosWithConnection");connexion.begin();			
			
			DetalleDocumentoParameterReturnGeneral detalledocumentoReturnGeneral=new DetalleDocumentoParameterReturnGeneral();
	
			detalledocumentoReturnGeneral.setDetalleDocumento(detalledocumento);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalledocumentoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleDocumentoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalledocumentos,detalledocumento,detalledocumentoParameterGeneral,detalledocumentoReturnGeneral,isEsNuevoDetalleDocumento,clases);
			
			this.connexion.commit();
			
			return detalledocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleDocumentoParameterReturnGeneral procesarImportacionDetalleDocumentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleDocumentoParameterReturnGeneral detalledocumentoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-procesarImportacionDetalleDocumentosWithConnection");connexion.begin();			
			
			DetalleDocumentoParameterReturnGeneral detalledocumentoReturnGeneral=new DetalleDocumentoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalledocumentos=new ArrayList<DetalleDocumento>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalledocumento=new DetalleDocumento();
				
				
				if(conColumnasBase) {this.detalledocumento.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalledocumento.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalledocumento.setnombre(arrColumnas[iColumn++]);
				
				this.detalledocumentos.add(this.detalledocumento);
			}
			
			this.saveDetalleDocumentos();
			
			this.connexion.commit();
			
			detalledocumentoReturnGeneral.setConRetornoEstaProcesado(true);
			detalledocumentoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalledocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleDocumentosEliminados() throws Exception {				
		
		List<DetalleDocumento> detalledocumentosAux= new ArrayList<DetalleDocumento>();
		
		for(DetalleDocumento detalledocumento:detalledocumentos) {
			if(!detalledocumento.getIsDeleted()) {
				detalledocumentosAux.add(detalledocumento);
			}
		}
		
		detalledocumentos=detalledocumentosAux;
	}
	
	public void quitarDetalleDocumentosNulos() throws Exception {				
		
		List<DetalleDocumento> detalledocumentosAux= new ArrayList<DetalleDocumento>();
		
		for(DetalleDocumento detalledocumento : this.detalledocumentos) {
			if(detalledocumento==null) {
				detalledocumentosAux.add(detalledocumento);
			}
		}
		
		//this.detalledocumentos=detalledocumentosAux;
		
		this.detalledocumentos.removeAll(detalledocumentosAux);
	}
	
	public void getSetVersionRowDetalleDocumentoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalledocumento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalledocumento.getIsDeleted() || (detalledocumento.getIsChanged()&&!detalledocumento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalledocumentoDataAccess.getSetVersionRowDetalleDocumento(connexion,detalledocumento.getId());
				
				if(!detalledocumento.getVersionRow().equals(timestamp)) {	
					detalledocumento.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalledocumento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleDocumento()throws Exception {	
		
		if(detalledocumento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalledocumento.getIsDeleted() || (detalledocumento.getIsChanged()&&!detalledocumento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalledocumentoDataAccess.getSetVersionRowDetalleDocumento(connexion,detalledocumento.getId());
			
			try {							
				if(!detalledocumento.getVersionRow().equals(timestamp)) {	
					detalledocumento.setVersionRow(timestamp);
				}
				
				detalledocumento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleDocumentosWithConnection()throws Exception {	
		if(detalledocumentos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleDocumento detalledocumentoAux:detalledocumentos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalledocumentoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalledocumentoAux.getIsDeleted() || (detalledocumentoAux.getIsChanged()&&!detalledocumentoAux.getIsNew())) {
						
						timestamp=detalledocumentoDataAccess.getSetVersionRowDetalleDocumento(connexion,detalledocumentoAux.getId());
						
						if(!detalledocumento.getVersionRow().equals(timestamp)) {	
							detalledocumentoAux.setVersionRow(timestamp);
						}
								
						detalledocumentoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleDocumentos()throws Exception {	
		if(detalledocumentos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleDocumento detalledocumentoAux:detalledocumentos) {
					if(detalledocumentoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalledocumentoAux.getIsDeleted() || (detalledocumentoAux.getIsChanged()&&!detalledocumentoAux.getIsNew())) {
						
						timestamp=detalledocumentoDataAccess.getSetVersionRowDetalleDocumento(connexion,detalledocumentoAux.getId());
						
						if(!detalledocumentoAux.getVersionRow().equals(timestamp)) {	
							detalledocumentoAux.setVersionRow(timestamp);
						}
						
													
						detalledocumentoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleDocumentoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleDocumentoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalTipoDetalleDocumento) throws Exception {
		DetalleDocumentoParameterReturnGeneral  detalledocumentoReturnGeneral =new DetalleDocumentoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleDocumentoWithConnection");connexion.begin();
			
			detalledocumentoReturnGeneral =new DetalleDocumentoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalledocumentoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detalledocumentoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			detalledocumentoReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<TipoDetalleDocumento> tipodetalledocumentosForeignKey=new ArrayList<TipoDetalleDocumento>();
			TipoDetalleDocumentoLogic tipodetalledocumentoLogic=new TipoDetalleDocumentoLogic();
			tipodetalledocumentoLogic.setConnexion(this.connexion);
			tipodetalledocumentoLogic.getTipoDetalleDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDetalleDocumento.equals("NONE")) {
				tipodetalledocumentoLogic.getTodosTipoDetalleDocumentos(finalQueryGlobalTipoDetalleDocumento,new Pagination());
				tipodetalledocumentosForeignKey=tipodetalledocumentoLogic.getTipoDetalleDocumentos();
			}

			detalledocumentoReturnGeneral.settipodetalledocumentosForeignKey(tipodetalledocumentosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalledocumentoReturnGeneral;
	}
	
	public DetalleDocumentoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleDocumento(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalTipoDetalleDocumento) throws Exception {
		DetalleDocumentoParameterReturnGeneral  detalledocumentoReturnGeneral =new DetalleDocumentoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalledocumentoReturnGeneral =new DetalleDocumentoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalledocumentoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detalledocumentoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			detalledocumentoReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<TipoDetalleDocumento> tipodetalledocumentosForeignKey=new ArrayList<TipoDetalleDocumento>();
			TipoDetalleDocumentoLogic tipodetalledocumentoLogic=new TipoDetalleDocumentoLogic();
			tipodetalledocumentoLogic.setConnexion(this.connexion);
			tipodetalledocumentoLogic.getTipoDetalleDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDetalleDocumento.equals("NONE")) {
				tipodetalledocumentoLogic.getTodosTipoDetalleDocumentos(finalQueryGlobalTipoDetalleDocumento,new Pagination());
				tipodetalledocumentosForeignKey=tipodetalledocumentoLogic.getTipoDetalleDocumentos();
			}

			detalledocumentoReturnGeneral.settipodetalledocumentosForeignKey(tipodetalledocumentosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalledocumentoReturnGeneral;
	}
	
	
	public void deepLoad(DetalleDocumento detalledocumento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleDocumentoLogicAdditional.updateDetalleDocumentoToGet(detalledocumento,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalledocumento.setEmpresa(detalledocumentoDataAccess.getEmpresa(connexion,detalledocumento));
		detalledocumento.setModulo(detalledocumentoDataAccess.getModulo(connexion,detalledocumento));
		detalledocumento.setTipoTransaccionModulo(detalledocumentoDataAccess.getTipoTransaccionModulo(connexion,detalledocumento));
		detalledocumento.setTipoDetalleDocumento(detalledocumentoDataAccess.getTipoDetalleDocumento(connexion,detalledocumento));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalledocumento.setEmpresa(detalledocumentoDataAccess.getEmpresa(connexion,detalledocumento));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detalledocumento.setModulo(detalledocumentoDataAccess.getModulo(connexion,detalledocumento));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				detalledocumento.setTipoTransaccionModulo(detalledocumentoDataAccess.getTipoTransaccionModulo(connexion,detalledocumento));
				continue;
			}

			if(clas.clas.equals(TipoDetalleDocumento.class)) {
				detalledocumento.setTipoDetalleDocumento(detalledocumentoDataAccess.getTipoDetalleDocumento(connexion,detalledocumento));
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
			detalledocumento.setEmpresa(detalledocumentoDataAccess.getEmpresa(connexion,detalledocumento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalledocumento.setModulo(detalledocumentoDataAccess.getModulo(connexion,detalledocumento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalledocumento.setTipoTransaccionModulo(detalledocumentoDataAccess.getTipoTransaccionModulo(connexion,detalledocumento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDetalleDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalledocumento.setTipoDetalleDocumento(detalledocumentoDataAccess.getTipoDetalleDocumento(connexion,detalledocumento));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalledocumento.setEmpresa(detalledocumentoDataAccess.getEmpresa(connexion,detalledocumento));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalledocumento.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalledocumento.setModulo(detalledocumentoDataAccess.getModulo(connexion,detalledocumento));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detalledocumento.getModulo(),isDeep,deepLoadType,clases);
				
		detalledocumento.setTipoTransaccionModulo(detalledocumentoDataAccess.getTipoTransaccionModulo(connexion,detalledocumento));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(detalledocumento.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		detalledocumento.setTipoDetalleDocumento(detalledocumentoDataAccess.getTipoDetalleDocumento(connexion,detalledocumento));
		TipoDetalleDocumentoLogic tipodetalledocumentoLogic= new TipoDetalleDocumentoLogic(connexion);
		tipodetalledocumentoLogic.deepLoad(detalledocumento.getTipoDetalleDocumento(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalledocumento.setEmpresa(detalledocumentoDataAccess.getEmpresa(connexion,detalledocumento));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalledocumento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detalledocumento.setModulo(detalledocumentoDataAccess.getModulo(connexion,detalledocumento));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(detalledocumento.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				detalledocumento.setTipoTransaccionModulo(detalledocumentoDataAccess.getTipoTransaccionModulo(connexion,detalledocumento));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(detalledocumento.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDetalleDocumento.class)) {
				detalledocumento.setTipoDetalleDocumento(detalledocumentoDataAccess.getTipoDetalleDocumento(connexion,detalledocumento));
				TipoDetalleDocumentoLogic tipodetalledocumentoLogic= new TipoDetalleDocumentoLogic(connexion);
				tipodetalledocumentoLogic.deepLoad(detalledocumento.getTipoDetalleDocumento(),isDeep,deepLoadType,clases);				
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
			detalledocumento.setEmpresa(detalledocumentoDataAccess.getEmpresa(connexion,detalledocumento));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalledocumento.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalledocumento.setModulo(detalledocumentoDataAccess.getModulo(connexion,detalledocumento));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(detalledocumento.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalledocumento.setTipoTransaccionModulo(detalledocumentoDataAccess.getTipoTransaccionModulo(connexion,detalledocumento));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(detalledocumento.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDetalleDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalledocumento.setTipoDetalleDocumento(detalledocumentoDataAccess.getTipoDetalleDocumento(connexion,detalledocumento));
			TipoDetalleDocumentoLogic tipodetalledocumentoLogic= new TipoDetalleDocumentoLogic(connexion);
			tipodetalledocumentoLogic.deepLoad(detalledocumento.getTipoDetalleDocumento(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleDocumento detalledocumento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleDocumentoLogicAdditional.updateDetalleDocumentoToSave(detalledocumento,this.arrDatoGeneral);
			
DetalleDocumentoDataAccess.save(detalledocumento, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalledocumento.getEmpresa(),connexion);

		ModuloDataAccess.save(detalledocumento.getModulo(),connexion);

		TipoTransaccionModuloDataAccess.save(detalledocumento.getTipoTransaccionModulo(),connexion);

		TipoDetalleDocumentoDataAccess.save(detalledocumento.getTipoDetalleDocumento(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalledocumento.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detalledocumento.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(detalledocumento.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDetalleDocumento.class)) {
				TipoDetalleDocumentoDataAccess.save(detalledocumento.getTipoDetalleDocumento(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalledocumento.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalledocumento.getEmpresa(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(detalledocumento.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detalledocumento.getModulo(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(detalledocumento.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(detalledocumento.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		TipoDetalleDocumentoDataAccess.save(detalledocumento.getTipoDetalleDocumento(),connexion);
		TipoDetalleDocumentoLogic tipodetalledocumentoLogic= new TipoDetalleDocumentoLogic(connexion);
		tipodetalledocumentoLogic.deepLoad(detalledocumento.getTipoDetalleDocumento(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalledocumento.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalledocumento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detalledocumento.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(detalledocumento.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(detalledocumento.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(detalledocumento.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDetalleDocumento.class)) {
				TipoDetalleDocumentoDataAccess.save(detalledocumento.getTipoDetalleDocumento(),connexion);
				TipoDetalleDocumentoLogic tipodetalledocumentoLogic= new TipoDetalleDocumentoLogic(connexion);
				tipodetalledocumentoLogic.deepSave(detalledocumento.getTipoDetalleDocumento(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleDocumento.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalledocumento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(detalledocumento);
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
			this.deepLoad(this.detalledocumento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleDocumento.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalledocumentos!=null) {
				for(DetalleDocumento detalledocumento:detalledocumentos) {
					this.deepLoad(detalledocumento,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(detalledocumentos);
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
			if(detalledocumentos!=null) {
				for(DetalleDocumento detalledocumento:detalledocumentos) {
					this.deepLoad(detalledocumento,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(detalledocumentos);
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
			this.getNewConnexionToDeep(DetalleDocumento.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalledocumento,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleDocumento.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalledocumentos!=null) {
				for(DetalleDocumento detalledocumento:detalledocumentos) {
					this.deepSave(detalledocumento,isDeep,deepLoadType,clases);
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
			if(detalledocumentos!=null) {
				for(DetalleDocumento detalledocumento:detalledocumentos) {
					this.deepSave(detalledocumento,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleDocumentosBusquedaPorIdModuloPorIdTipoTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorIdTipoTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleDocumentosBusquedaPorIdModuloPorIdTipoTransaccion(String sFinalQuery,Pagination pagination,Long id_modulo,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorIdTipoTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleDocumentosFK_IdDetalleDocumentoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_detalle_documento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDetalleDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDetalleDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_detalle_documento,DetalleDocumentoConstantesFunciones.IDTIPODETALLEDOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDetalleDocumento);

			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleDocumentosFK_IdDetalleDocumento(String sFinalQuery,Pagination pagination,Long id_tipo_detalle_documento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDetalleDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDetalleDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_detalle_documento,DetalleDocumentoConstantesFunciones.IDTIPODETALLEDOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDetalleDocumento);

			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleDocumentosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleDocumentosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleDocumentosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleDocumentosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleDocumentosFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleDocumentosFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(this.detalledocumentos);
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
			if(DetalleDocumentoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleDocumentoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleDocumento detalledocumento,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleDocumentoConstantesFunciones.ISCONAUDITORIA) {
				if(detalledocumento.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleDocumentoDataAccess.TABLENAME, detalledocumento.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleDocumentoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleDocumentoLogic.registrarAuditoriaDetallesDetalleDocumento(connexion,detalledocumento,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalledocumento.getIsDeleted()) {
					/*if(!detalledocumento.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleDocumentoDataAccess.TABLENAME, detalledocumento.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleDocumentoLogic.registrarAuditoriaDetallesDetalleDocumento(connexion,detalledocumento,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleDocumentoDataAccess.TABLENAME, detalledocumento.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalledocumento.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleDocumentoDataAccess.TABLENAME, detalledocumento.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleDocumentoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleDocumentoLogic.registrarAuditoriaDetallesDetalleDocumento(connexion,detalledocumento,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleDocumento(Connexion connexion,DetalleDocumento detalledocumento)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalledocumento.getIsNew()||!detalledocumento.getid_empresa().equals(detalledocumento.getDetalleDocumentoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalledocumento.getDetalleDocumentoOriginal().getid_empresa()!=null)
				{
					strValorActual=detalledocumento.getDetalleDocumentoOriginal().getid_empresa().toString();
				}
				if(detalledocumento.getid_empresa()!=null)
				{
					strValorNuevo=detalledocumento.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleDocumentoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalledocumento.getIsNew()||!detalledocumento.getid_modulo().equals(detalledocumento.getDetalleDocumentoOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalledocumento.getDetalleDocumentoOriginal().getid_modulo()!=null)
				{
					strValorActual=detalledocumento.getDetalleDocumentoOriginal().getid_modulo().toString();
				}
				if(detalledocumento.getid_modulo()!=null)
				{
					strValorNuevo=detalledocumento.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleDocumentoConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detalledocumento.getIsNew()||!detalledocumento.getid_tipo_transaccion_modulo().equals(detalledocumento.getDetalleDocumentoOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalledocumento.getDetalleDocumentoOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=detalledocumento.getDetalleDocumentoOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(detalledocumento.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=detalledocumento.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleDocumentoConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detalledocumento.getIsNew()||!detalledocumento.getid_tipo_detalle_documento().equals(detalledocumento.getDetalleDocumentoOriginal().getid_tipo_detalle_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalledocumento.getDetalleDocumentoOriginal().getid_tipo_detalle_documento()!=null)
				{
					strValorActual=detalledocumento.getDetalleDocumentoOriginal().getid_tipo_detalle_documento().toString();
				}
				if(detalledocumento.getid_tipo_detalle_documento()!=null)
				{
					strValorNuevo=detalledocumento.getid_tipo_detalle_documento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleDocumentoConstantesFunciones.IDTIPODETALLEDOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(detalledocumento.getIsNew()||!detalledocumento.getnombre().equals(detalledocumento.getDetalleDocumentoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalledocumento.getDetalleDocumentoOriginal().getnombre()!=null)
				{
					strValorActual=detalledocumento.getDetalleDocumentoOriginal().getnombre();
				}
				if(detalledocumento.getnombre()!=null)
				{
					strValorNuevo=detalledocumento.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleDocumentoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleDocumentoRelacionesWithConnection(DetalleDocumento detalledocumento) throws Exception {

		if(!detalledocumento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleDocumentoRelacionesBase(detalledocumento,true);
		}
	}

	public void saveDetalleDocumentoRelaciones(DetalleDocumento detalledocumento)throws Exception {

		if(!detalledocumento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleDocumentoRelacionesBase(detalledocumento,false);
		}
	}

	public void saveDetalleDocumentoRelacionesBase(DetalleDocumento detalledocumento,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleDocumento-saveRelacionesWithConnection");}
	

			this.setDetalleDocumento(detalledocumento);

			if(DetalleDocumentoLogicAdditional.validarSaveRelaciones(detalledocumento,this)) {

				DetalleDocumentoLogicAdditional.updateRelacionesToSave(detalledocumento,this);

				if((detalledocumento.getIsNew()||detalledocumento.getIsChanged())&&!detalledocumento.getIsDeleted()) {
					this.saveDetalleDocumento();
					this.saveDetalleDocumentoRelacionesDetalles();

				} else if(detalledocumento.getIsDeleted()) {
					this.saveDetalleDocumentoRelacionesDetalles();
					this.saveDetalleDocumento();
				}

				DetalleDocumentoLogicAdditional.updateRelacionesToSaveAfter(detalledocumento,this);

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
	
	
	private void saveDetalleDocumentoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleDocumentoConstantesFunciones.getClassesForeignKeysOfDetalleDocumento(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleDocumentoConstantesFunciones.getClassesRelationshipsOfDetalleDocumento(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

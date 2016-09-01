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
import com.bydan.erp.contabilidad.util.TipoDetalleDocumentoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoDetalleDocumentoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoDetalleDocumentoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoDetalleDocumento;
import com.bydan.erp.contabilidad.business.logic.TipoDetalleDocumentoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoDetalleDocumentoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDetalleDocumentoLogic.class);
	
	protected TipoDetalleDocumentoDataAccess tipodetalledocumentoDataAccess; 	
	protected TipoDetalleDocumento tipodetalledocumento;
	protected List<TipoDetalleDocumento> tipodetalledocumentos;
	protected Object tipodetalledocumentoObject;	
	protected List<Object> tipodetalledocumentosObject;
	
	public static ClassValidator<TipoDetalleDocumento> tipodetalledocumentoValidator = new ClassValidator<TipoDetalleDocumento>(TipoDetalleDocumento.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoDetalleDocumentoLogicAdditional tipodetalledocumentoLogicAdditional=null;
	
	public TipoDetalleDocumentoLogicAdditional getTipoDetalleDocumentoLogicAdditional() {
		return this.tipodetalledocumentoLogicAdditional;
	}
	
	public void setTipoDetalleDocumentoLogicAdditional(TipoDetalleDocumentoLogicAdditional tipodetalledocumentoLogicAdditional) {
		try {
			this.tipodetalledocumentoLogicAdditional=tipodetalledocumentoLogicAdditional;
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
	
	
	
	
	public  TipoDetalleDocumentoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodetalledocumentoDataAccess = new TipoDetalleDocumentoDataAccess();
			
			this.tipodetalledocumentos= new ArrayList<TipoDetalleDocumento>();
			this.tipodetalledocumento= new TipoDetalleDocumento();
			
			this.tipodetalledocumentoObject=new Object();
			this.tipodetalledocumentosObject=new ArrayList<Object>();
				
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
			
			this.tipodetalledocumentoDataAccess.setConnexionType(this.connexionType);
			this.tipodetalledocumentoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDetalleDocumentoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodetalledocumentoDataAccess = new TipoDetalleDocumentoDataAccess();
			this.tipodetalledocumentos= new ArrayList<TipoDetalleDocumento>();
			this.tipodetalledocumento= new TipoDetalleDocumento();
			this.tipodetalledocumentoObject=new Object();
			this.tipodetalledocumentosObject=new ArrayList<Object>();
			
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
			
			this.tipodetalledocumentoDataAccess.setConnexionType(this.connexionType);
			this.tipodetalledocumentoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDetalleDocumento getTipoDetalleDocumento() throws Exception {	
		TipoDetalleDocumentoLogicAdditional.checkTipoDetalleDocumentoToGet(tipodetalledocumento,this.datosCliente,this.arrDatoGeneral);
		TipoDetalleDocumentoLogicAdditional.updateTipoDetalleDocumentoToGet(tipodetalledocumento,this.arrDatoGeneral);
		
		return tipodetalledocumento;
	}
		
	public void setTipoDetalleDocumento(TipoDetalleDocumento newTipoDetalleDocumento) {
		this.tipodetalledocumento = newTipoDetalleDocumento;
	}
	
	public TipoDetalleDocumentoDataAccess getTipoDetalleDocumentoDataAccess() {
		return tipodetalledocumentoDataAccess;
	}
	
	public void setTipoDetalleDocumentoDataAccess(TipoDetalleDocumentoDataAccess newtipodetalledocumentoDataAccess) {
		this.tipodetalledocumentoDataAccess = newtipodetalledocumentoDataAccess;
	}
	
	public List<TipoDetalleDocumento> getTipoDetalleDocumentos() throws Exception {		
		this.quitarTipoDetalleDocumentosNulos();
		
		TipoDetalleDocumentoLogicAdditional.checkTipoDetalleDocumentoToGets(tipodetalledocumentos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDetalleDocumento tipodetalledocumentoLocal: tipodetalledocumentos ) {
			TipoDetalleDocumentoLogicAdditional.updateTipoDetalleDocumentoToGet(tipodetalledocumentoLocal,this.arrDatoGeneral);
		}
		
		return tipodetalledocumentos;
	}
	
	public void setTipoDetalleDocumentos(List<TipoDetalleDocumento> newTipoDetalleDocumentos) {
		this.tipodetalledocumentos = newTipoDetalleDocumentos;
	}
	
	public Object getTipoDetalleDocumentoObject() {	
		this.tipodetalledocumentoObject=this.tipodetalledocumentoDataAccess.getEntityObject();
		return this.tipodetalledocumentoObject;
	}
		
	public void setTipoDetalleDocumentoObject(Object newTipoDetalleDocumentoObject) {
		this.tipodetalledocumentoObject = newTipoDetalleDocumentoObject;
	}
	
	public List<Object> getTipoDetalleDocumentosObject() {		
		this.tipodetalledocumentosObject=this.tipodetalledocumentoDataAccess.getEntitiesObject();
		return this.tipodetalledocumentosObject;
	}
		
	public void setTipoDetalleDocumentosObject(List<Object> newTipoDetalleDocumentosObject) {
		this.tipodetalledocumentosObject = newTipoDetalleDocumentosObject;
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
		
		if(this.tipodetalledocumentoDataAccess!=null) {
			this.tipodetalledocumentoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodetalledocumentoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodetalledocumentoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodetalledocumento = new  TipoDetalleDocumento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodetalledocumento=tipodetalledocumentoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumento);
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
		tipodetalledocumento = new  TipoDetalleDocumento();
		  		  
        try {
			
			tipodetalledocumento=tipodetalledocumentoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodetalledocumento = new  TipoDetalleDocumento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodetalledocumento=tipodetalledocumentoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumento);
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
		tipodetalledocumento = new  TipoDetalleDocumento();
		  		  
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
		tipodetalledocumento = new  TipoDetalleDocumento();
		  		  
        try {
			
			tipodetalledocumento=tipodetalledocumentoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodetalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodetalledocumento = new  TipoDetalleDocumento();
		  		  
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
		tipodetalledocumento = new  TipoDetalleDocumento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodetalledocumentoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodetalledocumento = new  TipoDetalleDocumento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodetalledocumentoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodetalledocumento = new  TipoDetalleDocumento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodetalledocumentoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodetalledocumento = new  TipoDetalleDocumento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodetalledocumentoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodetalledocumento = new  TipoDetalleDocumento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodetalledocumentoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodetalledocumento = new  TipoDetalleDocumento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodetalledocumentoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
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
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		  		  
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
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		  		  
        try {			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		  		  
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
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
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
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		  		  
        try {
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
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
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
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
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodetalledocumento = new  TipoDetalleDocumento();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumento=tipodetalledocumentoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumento);
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
		tipodetalledocumento = new  TipoDetalleDocumento();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumento=tipodetalledocumentoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
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
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		  		  
        try {
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoDetalleDocumentosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getTodosTipoDetalleDocumentosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
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
	
	public  void  getTodosTipoDetalleDocumentos(String sFinalQuery,Pagination pagination)throws Exception {
		tipodetalledocumentos = new  ArrayList<TipoDetalleDocumento>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDetalleDocumento(tipodetalledocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDetalleDocumento(TipoDetalleDocumento tipodetalledocumento) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodetalledocumento.getIsNew() || tipodetalledocumento.getIsChanged()) { 
			this.invalidValues = tipodetalledocumentoValidator.getInvalidValues(tipodetalledocumento);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodetalledocumento);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDetalleDocumento(List<TipoDetalleDocumento> TipoDetalleDocumentos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDetalleDocumento tipodetalledocumentoLocal:tipodetalledocumentos) {				
			estaValidadoObjeto=this.validarGuardarTipoDetalleDocumento(tipodetalledocumentoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDetalleDocumento(List<TipoDetalleDocumento> TipoDetalleDocumentos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDetalleDocumento(tipodetalledocumentos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDetalleDocumento(TipoDetalleDocumento TipoDetalleDocumento) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDetalleDocumento(tipodetalledocumento)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDetalleDocumento tipodetalledocumento) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodetalledocumento.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDetalleDocumentoConstantesFunciones.getTipoDetalleDocumentoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodetalledocumento","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDetalleDocumentoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDetalleDocumentoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDetalleDocumentoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-saveTipoDetalleDocumentoWithConnection");connexion.begin();			
			
			TipoDetalleDocumentoLogicAdditional.checkTipoDetalleDocumentoToSave(this.tipodetalledocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDetalleDocumentoLogicAdditional.updateTipoDetalleDocumentoToSave(this.tipodetalledocumento,this.arrDatoGeneral);
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodetalledocumento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDetalleDocumento();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDetalleDocumento(this.tipodetalledocumento)) {
				TipoDetalleDocumentoDataAccess.save(this.tipodetalledocumento, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodetalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDetalleDocumentoLogicAdditional.checkTipoDetalleDocumentoToSaveAfter(this.tipodetalledocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDetalleDocumento();
			
			connexion.commit();			
			
			if(this.tipodetalledocumento.getIsDeleted()) {
				this.tipodetalledocumento=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDetalleDocumento()throws Exception {	
		try {	
			
			TipoDetalleDocumentoLogicAdditional.checkTipoDetalleDocumentoToSave(this.tipodetalledocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDetalleDocumentoLogicAdditional.updateTipoDetalleDocumentoToSave(this.tipodetalledocumento,this.arrDatoGeneral);
			
			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodetalledocumento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDetalleDocumento(this.tipodetalledocumento)) {			
				TipoDetalleDocumentoDataAccess.save(this.tipodetalledocumento, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodetalledocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDetalleDocumentoLogicAdditional.checkTipoDetalleDocumentoToSaveAfter(this.tipodetalledocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodetalledocumento.getIsDeleted()) {
				this.tipodetalledocumento=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDetalleDocumentosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-saveTipoDetalleDocumentosWithConnection");connexion.begin();			
			
			TipoDetalleDocumentoLogicAdditional.checkTipoDetalleDocumentoToSaves(tipodetalledocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDetalleDocumentos();
			
			Boolean validadoTodosTipoDetalleDocumento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDetalleDocumento tipodetalledocumentoLocal:tipodetalledocumentos) {		
				if(tipodetalledocumentoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDetalleDocumentoLogicAdditional.updateTipoDetalleDocumentoToSave(tipodetalledocumentoLocal,this.arrDatoGeneral);
	        	
				TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodetalledocumentoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDetalleDocumento(tipodetalledocumentoLocal)) {
					TipoDetalleDocumentoDataAccess.save(tipodetalledocumentoLocal, connexion);				
				} else {
					validadoTodosTipoDetalleDocumento=false;
				}
			}
			
			if(!validadoTodosTipoDetalleDocumento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDetalleDocumentoLogicAdditional.checkTipoDetalleDocumentoToSavesAfter(tipodetalledocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDetalleDocumentos();
			
			connexion.commit();		
			
			this.quitarTipoDetalleDocumentosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDetalleDocumentos()throws Exception {				
		 try {	
			TipoDetalleDocumentoLogicAdditional.checkTipoDetalleDocumentoToSaves(tipodetalledocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDetalleDocumento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDetalleDocumento tipodetalledocumentoLocal:tipodetalledocumentos) {				
				if(tipodetalledocumentoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDetalleDocumentoLogicAdditional.updateTipoDetalleDocumentoToSave(tipodetalledocumentoLocal,this.arrDatoGeneral);
	        	
				TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodetalledocumentoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDetalleDocumento(tipodetalledocumentoLocal)) {				
					TipoDetalleDocumentoDataAccess.save(tipodetalledocumentoLocal, connexion);				
				} else {
					validadoTodosTipoDetalleDocumento=false;
				}
			}
			
			if(!validadoTodosTipoDetalleDocumento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDetalleDocumentoLogicAdditional.checkTipoDetalleDocumentoToSavesAfter(tipodetalledocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDetalleDocumentosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDetalleDocumentoParameterReturnGeneral procesarAccionTipoDetalleDocumentos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDetalleDocumento> tipodetalledocumentos,TipoDetalleDocumentoParameterReturnGeneral tipodetalledocumentoParameterGeneral)throws Exception {
		 try {	
			TipoDetalleDocumentoParameterReturnGeneral tipodetalledocumentoReturnGeneral=new TipoDetalleDocumentoParameterReturnGeneral();
	
			TipoDetalleDocumentoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodetalledocumentos,tipodetalledocumentoParameterGeneral,tipodetalledocumentoReturnGeneral);
			
			return tipodetalledocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDetalleDocumentoParameterReturnGeneral procesarAccionTipoDetalleDocumentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDetalleDocumento> tipodetalledocumentos,TipoDetalleDocumentoParameterReturnGeneral tipodetalledocumentoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-procesarAccionTipoDetalleDocumentosWithConnection");connexion.begin();			
			
			TipoDetalleDocumentoParameterReturnGeneral tipodetalledocumentoReturnGeneral=new TipoDetalleDocumentoParameterReturnGeneral();
	
			TipoDetalleDocumentoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodetalledocumentos,tipodetalledocumentoParameterGeneral,tipodetalledocumentoReturnGeneral);
			
			this.connexion.commit();
			
			return tipodetalledocumentoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDetalleDocumentoParameterReturnGeneral procesarEventosTipoDetalleDocumentos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDetalleDocumento> tipodetalledocumentos,TipoDetalleDocumento tipodetalledocumento,TipoDetalleDocumentoParameterReturnGeneral tipodetalledocumentoParameterGeneral,Boolean isEsNuevoTipoDetalleDocumento,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDetalleDocumentoParameterReturnGeneral tipodetalledocumentoReturnGeneral=new TipoDetalleDocumentoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodetalledocumentoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDetalleDocumentoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodetalledocumentos,tipodetalledocumento,tipodetalledocumentoParameterGeneral,tipodetalledocumentoReturnGeneral,isEsNuevoTipoDetalleDocumento,clases);
			
			return tipodetalledocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDetalleDocumentoParameterReturnGeneral procesarEventosTipoDetalleDocumentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDetalleDocumento> tipodetalledocumentos,TipoDetalleDocumento tipodetalledocumento,TipoDetalleDocumentoParameterReturnGeneral tipodetalledocumentoParameterGeneral,Boolean isEsNuevoTipoDetalleDocumento,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-procesarEventosTipoDetalleDocumentosWithConnection");connexion.begin();			
			
			TipoDetalleDocumentoParameterReturnGeneral tipodetalledocumentoReturnGeneral=new TipoDetalleDocumentoParameterReturnGeneral();
	
			tipodetalledocumentoReturnGeneral.setTipoDetalleDocumento(tipodetalledocumento);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodetalledocumentoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDetalleDocumentoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodetalledocumentos,tipodetalledocumento,tipodetalledocumentoParameterGeneral,tipodetalledocumentoReturnGeneral,isEsNuevoTipoDetalleDocumento,clases);
			
			this.connexion.commit();
			
			return tipodetalledocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDetalleDocumentoParameterReturnGeneral procesarImportacionTipoDetalleDocumentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDetalleDocumentoParameterReturnGeneral tipodetalledocumentoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-procesarImportacionTipoDetalleDocumentosWithConnection");connexion.begin();			
			
			TipoDetalleDocumentoParameterReturnGeneral tipodetalledocumentoReturnGeneral=new TipoDetalleDocumentoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodetalledocumentos=new ArrayList<TipoDetalleDocumento>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodetalledocumento=new TipoDetalleDocumento();
				
				
				if(conColumnasBase) {this.tipodetalledocumento.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodetalledocumento.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodetalledocumento.setcodigo(arrColumnas[iColumn++]);
				this.tipodetalledocumento.setnombre(arrColumnas[iColumn++]);
				
				this.tipodetalledocumentos.add(this.tipodetalledocumento);
			}
			
			this.saveTipoDetalleDocumentos();
			
			this.connexion.commit();
			
			tipodetalledocumentoReturnGeneral.setConRetornoEstaProcesado(true);
			tipodetalledocumentoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodetalledocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDetalleDocumentosEliminados() throws Exception {				
		
		List<TipoDetalleDocumento> tipodetalledocumentosAux= new ArrayList<TipoDetalleDocumento>();
		
		for(TipoDetalleDocumento tipodetalledocumento:tipodetalledocumentos) {
			if(!tipodetalledocumento.getIsDeleted()) {
				tipodetalledocumentosAux.add(tipodetalledocumento);
			}
		}
		
		tipodetalledocumentos=tipodetalledocumentosAux;
	}
	
	public void quitarTipoDetalleDocumentosNulos() throws Exception {				
		
		List<TipoDetalleDocumento> tipodetalledocumentosAux= new ArrayList<TipoDetalleDocumento>();
		
		for(TipoDetalleDocumento tipodetalledocumento : this.tipodetalledocumentos) {
			if(tipodetalledocumento==null) {
				tipodetalledocumentosAux.add(tipodetalledocumento);
			}
		}
		
		//this.tipodetalledocumentos=tipodetalledocumentosAux;
		
		this.tipodetalledocumentos.removeAll(tipodetalledocumentosAux);
	}
	
	public void getSetVersionRowTipoDetalleDocumentoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodetalledocumento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodetalledocumento.getIsDeleted() || (tipodetalledocumento.getIsChanged()&&!tipodetalledocumento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodetalledocumentoDataAccess.getSetVersionRowTipoDetalleDocumento(connexion,tipodetalledocumento.getId());
				
				if(!tipodetalledocumento.getVersionRow().equals(timestamp)) {	
					tipodetalledocumento.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodetalledocumento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDetalleDocumento()throws Exception {	
		
		if(tipodetalledocumento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodetalledocumento.getIsDeleted() || (tipodetalledocumento.getIsChanged()&&!tipodetalledocumento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodetalledocumentoDataAccess.getSetVersionRowTipoDetalleDocumento(connexion,tipodetalledocumento.getId());
			
			try {							
				if(!tipodetalledocumento.getVersionRow().equals(timestamp)) {	
					tipodetalledocumento.setVersionRow(timestamp);
				}
				
				tipodetalledocumento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDetalleDocumentosWithConnection()throws Exception {	
		if(tipodetalledocumentos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDetalleDocumento tipodetalledocumentoAux:tipodetalledocumentos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodetalledocumentoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodetalledocumentoAux.getIsDeleted() || (tipodetalledocumentoAux.getIsChanged()&&!tipodetalledocumentoAux.getIsNew())) {
						
						timestamp=tipodetalledocumentoDataAccess.getSetVersionRowTipoDetalleDocumento(connexion,tipodetalledocumentoAux.getId());
						
						if(!tipodetalledocumento.getVersionRow().equals(timestamp)) {	
							tipodetalledocumentoAux.setVersionRow(timestamp);
						}
								
						tipodetalledocumentoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDetalleDocumentos()throws Exception {	
		if(tipodetalledocumentos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDetalleDocumento tipodetalledocumentoAux:tipodetalledocumentos) {
					if(tipodetalledocumentoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodetalledocumentoAux.getIsDeleted() || (tipodetalledocumentoAux.getIsChanged()&&!tipodetalledocumentoAux.getIsNew())) {
						
						timestamp=tipodetalledocumentoDataAccess.getSetVersionRowTipoDetalleDocumento(connexion,tipodetalledocumentoAux.getId());
						
						if(!tipodetalledocumentoAux.getVersionRow().equals(timestamp)) {	
							tipodetalledocumentoAux.setVersionRow(timestamp);
						}
						
													
						tipodetalledocumentoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoDetalleDocumentoParameterReturnGeneral cargarCombosLoteForeignKeyTipoDetalleDocumentoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoDetalleDocumentoParameterReturnGeneral  tipodetalledocumentoReturnGeneral =new TipoDetalleDocumentoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoDetalleDocumentoWithConnection");connexion.begin();
			
			tipodetalledocumentoReturnGeneral =new TipoDetalleDocumentoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodetalledocumentoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipodetalledocumentoReturnGeneral;
	}
	
	public TipoDetalleDocumentoParameterReturnGeneral cargarCombosLoteForeignKeyTipoDetalleDocumento(String finalQueryGlobalEmpresa) throws Exception {
		TipoDetalleDocumentoParameterReturnGeneral  tipodetalledocumentoReturnGeneral =new TipoDetalleDocumentoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipodetalledocumentoReturnGeneral =new TipoDetalleDocumentoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodetalledocumentoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipodetalledocumentoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoDetalleDocumentoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleDocumentoLogic detalledocumentoLogic=new DetalleDocumentoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoDetalleDocumentoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleDocumento.class));
											
			

			detalledocumentoLogic.setConnexion(this.getConnexion());
			detalledocumentoLogic.setDatosCliente(this.datosCliente);
			detalledocumentoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoDetalleDocumento tipodetalledocumento:this.tipodetalledocumentos) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleDocumentoConstantesFunciones.getClassesForeignKeysOfDetalleDocumento(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalledocumentoLogic.setDetalleDocumentos(tipodetalledocumento.detalledocumentos);
				detalledocumentoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoDetalleDocumento tipodetalledocumento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoDetalleDocumentoLogicAdditional.updateTipoDetalleDocumentoToGet(tipodetalledocumento,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodetalledocumento.setEmpresa(tipodetalledocumentoDataAccess.getEmpresa(connexion,tipodetalledocumento));
		tipodetalledocumento.setDetalleDocumentos(tipodetalledocumentoDataAccess.getDetalleDocumentos(connexion,tipodetalledocumento));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodetalledocumento.setEmpresa(tipodetalledocumentoDataAccess.getEmpresa(connexion,tipodetalledocumento));
				continue;
			}

			if(clas.clas.equals(DetalleDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodetalledocumento.setDetalleDocumentos(tipodetalledocumentoDataAccess.getDetalleDocumentos(connexion,tipodetalledocumento));

				if(this.isConDeep) {
					DetalleDocumentoLogic detalledocumentoLogic= new DetalleDocumentoLogic(this.connexion);
					detalledocumentoLogic.setDetalleDocumentos(tipodetalledocumento.getDetalleDocumentos());
					ArrayList<Classe> classesLocal=DetalleDocumentoConstantesFunciones.getClassesForeignKeysOfDetalleDocumento(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalledocumentoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleDocumento(detalledocumentoLogic.getDetalleDocumentos());
					tipodetalledocumento.setDetalleDocumentos(detalledocumentoLogic.getDetalleDocumentos());
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
			tipodetalledocumento.setEmpresa(tipodetalledocumentoDataAccess.getEmpresa(connexion,tipodetalledocumento));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleDocumento.class));
			tipodetalledocumento.setDetalleDocumentos(tipodetalledocumentoDataAccess.getDetalleDocumentos(connexion,tipodetalledocumento));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodetalledocumento.setEmpresa(tipodetalledocumentoDataAccess.getEmpresa(connexion,tipodetalledocumento));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodetalledocumento.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipodetalledocumento.setDetalleDocumentos(tipodetalledocumentoDataAccess.getDetalleDocumentos(connexion,tipodetalledocumento));

		for(DetalleDocumento detalledocumento:tipodetalledocumento.getDetalleDocumentos()) {
			DetalleDocumentoLogic detalledocumentoLogic= new DetalleDocumentoLogic(connexion);
			detalledocumentoLogic.deepLoad(detalledocumento,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodetalledocumento.setEmpresa(tipodetalledocumentoDataAccess.getEmpresa(connexion,tipodetalledocumento));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipodetalledocumento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodetalledocumento.setDetalleDocumentos(tipodetalledocumentoDataAccess.getDetalleDocumentos(connexion,tipodetalledocumento));

				for(DetalleDocumento detalledocumento:tipodetalledocumento.getDetalleDocumentos()) {
					DetalleDocumentoLogic detalledocumentoLogic= new DetalleDocumentoLogic(connexion);
					detalledocumentoLogic.deepLoad(detalledocumento,isDeep,deepLoadType,clases);
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
			tipodetalledocumento.setEmpresa(tipodetalledocumentoDataAccess.getEmpresa(connexion,tipodetalledocumento));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipodetalledocumento.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleDocumento.class));
			tipodetalledocumento.setDetalleDocumentos(tipodetalledocumentoDataAccess.getDetalleDocumentos(connexion,tipodetalledocumento));

			for(DetalleDocumento detalledocumento:tipodetalledocumento.getDetalleDocumentos()) {
				DetalleDocumentoLogic detalledocumentoLogic= new DetalleDocumentoLogic(connexion);
				detalledocumentoLogic.deepLoad(detalledocumento,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDetalleDocumento tipodetalledocumento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoDetalleDocumentoLogicAdditional.updateTipoDetalleDocumentoToSave(tipodetalledocumento,this.arrDatoGeneral);
			
TipoDetalleDocumentoDataAccess.save(tipodetalledocumento, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodetalledocumento.getEmpresa(),connexion);

		for(DetalleDocumento detalledocumento:tipodetalledocumento.getDetalleDocumentos()) {
			detalledocumento.setid_tipo_detalle_documento(tipodetalledocumento.getId());
			DetalleDocumentoDataAccess.save(detalledocumento,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodetalledocumento.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleDocumento detalledocumento:tipodetalledocumento.getDetalleDocumentos()) {
					detalledocumento.setid_tipo_detalle_documento(tipodetalledocumento.getId());
					DetalleDocumentoDataAccess.save(detalledocumento,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodetalledocumento.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodetalledocumento.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(DetalleDocumento detalledocumento:tipodetalledocumento.getDetalleDocumentos()) {
			DetalleDocumentoLogic detalledocumentoLogic= new DetalleDocumentoLogic(connexion);
			detalledocumento.setid_tipo_detalle_documento(tipodetalledocumento.getId());
			DetalleDocumentoDataAccess.save(detalledocumento,connexion);
			detalledocumentoLogic.deepSave(detalledocumento,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodetalledocumento.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipodetalledocumento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleDocumento.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleDocumento detalledocumento:tipodetalledocumento.getDetalleDocumentos()) {
					DetalleDocumentoLogic detalledocumentoLogic= new DetalleDocumentoLogic(connexion);
					detalledocumento.setid_tipo_detalle_documento(tipodetalledocumento.getId());
					DetalleDocumentoDataAccess.save(detalledocumento,connexion);
					detalledocumentoLogic.deepSave(detalledocumento,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoDetalleDocumento.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodetalledocumento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(tipodetalledocumento);
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
			this.deepLoad(this.tipodetalledocumento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDetalleDocumento.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodetalledocumentos!=null) {
				for(TipoDetalleDocumento tipodetalledocumento:tipodetalledocumentos) {
					this.deepLoad(tipodetalledocumento,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(tipodetalledocumentos);
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
			if(tipodetalledocumentos!=null) {
				for(TipoDetalleDocumento tipodetalledocumento:tipodetalledocumentos) {
					this.deepLoad(tipodetalledocumento,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(tipodetalledocumentos);
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
			this.getNewConnexionToDeep(TipoDetalleDocumento.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipodetalledocumento,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoDetalleDocumento.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipodetalledocumentos!=null) {
				for(TipoDetalleDocumento tipodetalledocumento:tipodetalledocumentos) {
					this.deepSave(tipodetalledocumento,isDeep,deepLoadType,clases);
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
			if(tipodetalledocumentos!=null) {
				for(TipoDetalleDocumento tipodetalledocumento:tipodetalledocumentos) {
					this.deepSave(tipodetalledocumento,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoDetalleDocumentosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoDetalleDocumentoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDetalleDocumentosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoDetalleDocumentoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDetalleDocumentosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoDetalleDocumentoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDetalleDocumentosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoDetalleDocumentoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDetalleDocumentosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDetalleDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDetalleDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDetalleDocumentosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDetalleDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDetalleDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodetalledocumentos=tipodetalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDetalleDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDetalleDocumento(this.tipodetalledocumentos);
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
			if(TipoDetalleDocumentoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetalleDocumentoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDetalleDocumento tipodetalledocumento,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDetalleDocumentoConstantesFunciones.ISCONAUDITORIA) {
				if(tipodetalledocumento.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetalleDocumentoDataAccess.TABLENAME, tipodetalledocumento.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDetalleDocumentoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDetalleDocumentoLogic.registrarAuditoriaDetallesTipoDetalleDocumento(connexion,tipodetalledocumento,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodetalledocumento.getIsDeleted()) {
					/*if(!tipodetalledocumento.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDetalleDocumentoDataAccess.TABLENAME, tipodetalledocumento.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDetalleDocumentoLogic.registrarAuditoriaDetallesTipoDetalleDocumento(connexion,tipodetalledocumento,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetalleDocumentoDataAccess.TABLENAME, tipodetalledocumento.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodetalledocumento.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDetalleDocumentoDataAccess.TABLENAME, tipodetalledocumento.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDetalleDocumentoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDetalleDocumentoLogic.registrarAuditoriaDetallesTipoDetalleDocumento(connexion,tipodetalledocumento,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDetalleDocumento(Connexion connexion,TipoDetalleDocumento tipodetalledocumento)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodetalledocumento.getIsNew()||!tipodetalledocumento.getid_empresa().equals(tipodetalledocumento.getTipoDetalleDocumentoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodetalledocumento.getTipoDetalleDocumentoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipodetalledocumento.getTipoDetalleDocumentoOriginal().getid_empresa().toString();
				}
				if(tipodetalledocumento.getid_empresa()!=null)
				{
					strValorNuevo=tipodetalledocumento.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDetalleDocumentoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipodetalledocumento.getIsNew()||!tipodetalledocumento.getcodigo().equals(tipodetalledocumento.getTipoDetalleDocumentoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodetalledocumento.getTipoDetalleDocumentoOriginal().getcodigo()!=null)
				{
					strValorActual=tipodetalledocumento.getTipoDetalleDocumentoOriginal().getcodigo();
				}
				if(tipodetalledocumento.getcodigo()!=null)
				{
					strValorNuevo=tipodetalledocumento.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDetalleDocumentoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipodetalledocumento.getIsNew()||!tipodetalledocumento.getnombre().equals(tipodetalledocumento.getTipoDetalleDocumentoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodetalledocumento.getTipoDetalleDocumentoOriginal().getnombre()!=null)
				{
					strValorActual=tipodetalledocumento.getTipoDetalleDocumentoOriginal().getnombre();
				}
				if(tipodetalledocumento.getnombre()!=null)
				{
					strValorNuevo=tipodetalledocumento.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDetalleDocumentoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoDetalleDocumentoRelacionesWithConnection(TipoDetalleDocumento tipodetalledocumento,List<DetalleDocumento> detalledocumentos) throws Exception {

		if(!tipodetalledocumento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDetalleDocumentoRelacionesBase(tipodetalledocumento,detalledocumentos,true);
		}
	}

	public void saveTipoDetalleDocumentoRelaciones(TipoDetalleDocumento tipodetalledocumento,List<DetalleDocumento> detalledocumentos)throws Exception {

		if(!tipodetalledocumento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDetalleDocumentoRelacionesBase(tipodetalledocumento,detalledocumentos,false);
		}
	}

	public void saveTipoDetalleDocumentoRelacionesBase(TipoDetalleDocumento tipodetalledocumento,List<DetalleDocumento> detalledocumentos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoDetalleDocumento-saveRelacionesWithConnection");}
	
			tipodetalledocumento.setDetalleDocumentos(detalledocumentos);

			this.setTipoDetalleDocumento(tipodetalledocumento);

			if(TipoDetalleDocumentoLogicAdditional.validarSaveRelaciones(tipodetalledocumento,this)) {

				TipoDetalleDocumentoLogicAdditional.updateRelacionesToSave(tipodetalledocumento,this);

				if((tipodetalledocumento.getIsNew()||tipodetalledocumento.getIsChanged())&&!tipodetalledocumento.getIsDeleted()) {
					this.saveTipoDetalleDocumento();
					this.saveTipoDetalleDocumentoRelacionesDetalles(detalledocumentos);

				} else if(tipodetalledocumento.getIsDeleted()) {
					this.saveTipoDetalleDocumentoRelacionesDetalles(detalledocumentos);
					this.saveTipoDetalleDocumento();
				}

				TipoDetalleDocumentoLogicAdditional.updateRelacionesToSaveAfter(tipodetalledocumento,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleDocumentoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleDocumentos(detalledocumentos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoDetalleDocumentoRelacionesDetalles(List<DetalleDocumento> detalledocumentos)throws Exception {
		try {
	

			Long idTipoDetalleDocumentoActual=this.getTipoDetalleDocumento().getId();

			DetalleDocumentoLogic detalledocumentoLogic_Desde_TipoDetalleDocumento=new DetalleDocumentoLogic();
			detalledocumentoLogic_Desde_TipoDetalleDocumento.setDetalleDocumentos(detalledocumentos);

			detalledocumentoLogic_Desde_TipoDetalleDocumento.setConnexion(this.getConnexion());
			detalledocumentoLogic_Desde_TipoDetalleDocumento.setDatosCliente(this.datosCliente);

			for(DetalleDocumento detalledocumento_Desde_TipoDetalleDocumento:detalledocumentoLogic_Desde_TipoDetalleDocumento.getDetalleDocumentos()) {
				detalledocumento_Desde_TipoDetalleDocumento.setid_tipo_detalle_documento(idTipoDetalleDocumentoActual);
			}

			detalledocumentoLogic_Desde_TipoDetalleDocumento.saveDetalleDocumentos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDetalleDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDetalleDocumentoConstantesFunciones.getClassesForeignKeysOfTipoDetalleDocumento(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDetalleDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDetalleDocumentoConstantesFunciones.getClassesRelationshipsOfTipoDetalleDocumento(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.contabilidad.util.TipoDocumentoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoDocumentoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoDocumentoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoDocumento;
import com.bydan.erp.contabilidad.business.logic.TipoDocumentoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoDocumentoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDocumentoLogic.class);
	
	protected TipoDocumentoDataAccess tipodocumentoDataAccess; 	
	protected TipoDocumento tipodocumento;
	protected List<TipoDocumento> tipodocumentos;
	protected Object tipodocumentoObject;	
	protected List<Object> tipodocumentosObject;
	
	public static ClassValidator<TipoDocumento> tipodocumentoValidator = new ClassValidator<TipoDocumento>(TipoDocumento.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoDocumentoLogicAdditional tipodocumentoLogicAdditional=null;
	
	public TipoDocumentoLogicAdditional getTipoDocumentoLogicAdditional() {
		return this.tipodocumentoLogicAdditional;
	}
	
	public void setTipoDocumentoLogicAdditional(TipoDocumentoLogicAdditional tipodocumentoLogicAdditional) {
		try {
			this.tipodocumentoLogicAdditional=tipodocumentoLogicAdditional;
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
	
	
	
	
	public  TipoDocumentoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodocumentoDataAccess = new TipoDocumentoDataAccess();
			
			this.tipodocumentos= new ArrayList<TipoDocumento>();
			this.tipodocumento= new TipoDocumento();
			
			this.tipodocumentoObject=new Object();
			this.tipodocumentosObject=new ArrayList<Object>();
				
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
			
			this.tipodocumentoDataAccess.setConnexionType(this.connexionType);
			this.tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDocumentoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodocumentoDataAccess = new TipoDocumentoDataAccess();
			this.tipodocumentos= new ArrayList<TipoDocumento>();
			this.tipodocumento= new TipoDocumento();
			this.tipodocumentoObject=new Object();
			this.tipodocumentosObject=new ArrayList<Object>();
			
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
			
			this.tipodocumentoDataAccess.setConnexionType(this.connexionType);
			this.tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDocumento getTipoDocumento() throws Exception {	
		TipoDocumentoLogicAdditional.checkTipoDocumentoToGet(tipodocumento,this.datosCliente,this.arrDatoGeneral);
		TipoDocumentoLogicAdditional.updateTipoDocumentoToGet(tipodocumento,this.arrDatoGeneral);
		
		return tipodocumento;
	}
		
	public void setTipoDocumento(TipoDocumento newTipoDocumento) {
		this.tipodocumento = newTipoDocumento;
	}
	
	public TipoDocumentoDataAccess getTipoDocumentoDataAccess() {
		return tipodocumentoDataAccess;
	}
	
	public void setTipoDocumentoDataAccess(TipoDocumentoDataAccess newtipodocumentoDataAccess) {
		this.tipodocumentoDataAccess = newtipodocumentoDataAccess;
	}
	
	public List<TipoDocumento> getTipoDocumentos() throws Exception {		
		this.quitarTipoDocumentosNulos();
		
		TipoDocumentoLogicAdditional.checkTipoDocumentoToGets(tipodocumentos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDocumento tipodocumentoLocal: tipodocumentos ) {
			TipoDocumentoLogicAdditional.updateTipoDocumentoToGet(tipodocumentoLocal,this.arrDatoGeneral);
		}
		
		return tipodocumentos;
	}
	
	public void setTipoDocumentos(List<TipoDocumento> newTipoDocumentos) {
		this.tipodocumentos = newTipoDocumentos;
	}
	
	public Object getTipoDocumentoObject() {	
		this.tipodocumentoObject=this.tipodocumentoDataAccess.getEntityObject();
		return this.tipodocumentoObject;
	}
		
	public void setTipoDocumentoObject(Object newTipoDocumentoObject) {
		this.tipodocumentoObject = newTipoDocumentoObject;
	}
	
	public List<Object> getTipoDocumentosObject() {		
		this.tipodocumentosObject=this.tipodocumentoDataAccess.getEntitiesObject();
		return this.tipodocumentosObject;
	}
		
	public void setTipoDocumentosObject(List<Object> newTipoDocumentosObject) {
		this.tipodocumentosObject = newTipoDocumentosObject;
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
		
		if(this.tipodocumentoDataAccess!=null) {
			this.tipodocumentoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodocumentoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodocumentoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodocumento = new  TipoDocumento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodocumento=tipodocumentoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
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
		tipodocumento = new  TipoDocumento();
		  		  
        try {
			
			tipodocumento=tipodocumentoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodocumento = new  TipoDocumento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodocumento=tipodocumentoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
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
		tipodocumento = new  TipoDocumento();
		  		  
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
		tipodocumento = new  TipoDocumento();
		  		  
        try {
			
			tipodocumento=tipodocumentoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodocumento = new  TipoDocumento();
		  		  
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
		tipodocumento = new  TipoDocumento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodocumentoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodocumento = new  TipoDocumento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodocumentoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodocumento = new  TipoDocumento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodocumentoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodocumento = new  TipoDocumento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodocumentoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodocumento = new  TipoDocumento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodocumentoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodocumento = new  TipoDocumento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodocumentoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodocumentos = new  ArrayList<TipoDocumento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumento(tipodocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
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
		tipodocumentos = new  ArrayList<TipoDocumento>();
		  		  
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
		tipodocumentos = new  ArrayList<TipoDocumento>();
		  		  
        try {			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDocumento(tipodocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodocumentos = new  ArrayList<TipoDocumento>();
		  		  
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
		tipodocumentos = new  ArrayList<TipoDocumento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumento(tipodocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
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
		tipodocumentos = new  ArrayList<TipoDocumento>();
		  		  
        try {
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumento(tipodocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
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
		tipodocumentos = new  ArrayList<TipoDocumento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumento(tipodocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
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
		tipodocumentos = new  ArrayList<TipoDocumento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumento(tipodocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodocumento = new  TipoDocumento();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumento(tipodocumento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
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
		tipodocumento = new  TipoDocumento();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumento(tipodocumento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodocumentos = new  ArrayList<TipoDocumento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentos=tipodocumentoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumento(tipodocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
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
		tipodocumentos = new  ArrayList<TipoDocumento>();
		  		  
        try {
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentos=tipodocumentoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumento(tipodocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoDocumentosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodocumentos = new  ArrayList<TipoDocumento>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getTodosTipoDocumentosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDocumento(tipodocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
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
	
	public  void  getTodosTipoDocumentos(String sFinalQuery,Pagination pagination)throws Exception {
		tipodocumentos = new  ArrayList<TipoDocumento>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDocumento(tipodocumentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDocumento(TipoDocumento tipodocumento) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodocumento.getIsNew() || tipodocumento.getIsChanged()) { 
			this.invalidValues = tipodocumentoValidator.getInvalidValues(tipodocumento);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodocumento);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDocumento(List<TipoDocumento> TipoDocumentos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDocumento tipodocumentoLocal:tipodocumentos) {				
			estaValidadoObjeto=this.validarGuardarTipoDocumento(tipodocumentoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDocumento(List<TipoDocumento> TipoDocumentos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDocumento(tipodocumentos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDocumento(TipoDocumento TipoDocumento) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDocumento(tipodocumento)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDocumento tipodocumento) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodocumento.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDocumentoConstantesFunciones.getTipoDocumentoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodocumento","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDocumentoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDocumentoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDocumentoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-saveTipoDocumentoWithConnection");connexion.begin();			
			
			TipoDocumentoLogicAdditional.checkTipoDocumentoToSave(this.tipodocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDocumentoLogicAdditional.updateTipoDocumentoToSave(this.tipodocumento,this.arrDatoGeneral);
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodocumento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDocumento();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDocumento(this.tipodocumento)) {
				TipoDocumentoDataAccess.save(this.tipodocumento, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDocumentoLogicAdditional.checkTipoDocumentoToSaveAfter(this.tipodocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDocumento();
			
			connexion.commit();			
			
			if(this.tipodocumento.getIsDeleted()) {
				this.tipodocumento=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDocumento()throws Exception {	
		try {	
			
			TipoDocumentoLogicAdditional.checkTipoDocumentoToSave(this.tipodocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDocumentoLogicAdditional.updateTipoDocumentoToSave(this.tipodocumento,this.arrDatoGeneral);
			
			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodocumento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDocumento(this.tipodocumento)) {			
				TipoDocumentoDataAccess.save(this.tipodocumento, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDocumentoLogicAdditional.checkTipoDocumentoToSaveAfter(this.tipodocumento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodocumento.getIsDeleted()) {
				this.tipodocumento=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDocumentosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-saveTipoDocumentosWithConnection");connexion.begin();			
			
			TipoDocumentoLogicAdditional.checkTipoDocumentoToSaves(tipodocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDocumentos();
			
			Boolean validadoTodosTipoDocumento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDocumento tipodocumentoLocal:tipodocumentos) {		
				if(tipodocumentoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDocumentoLogicAdditional.updateTipoDocumentoToSave(tipodocumentoLocal,this.arrDatoGeneral);
	        	
				TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodocumentoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDocumento(tipodocumentoLocal)) {
					TipoDocumentoDataAccess.save(tipodocumentoLocal, connexion);				
				} else {
					validadoTodosTipoDocumento=false;
				}
			}
			
			if(!validadoTodosTipoDocumento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDocumentoLogicAdditional.checkTipoDocumentoToSavesAfter(tipodocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDocumentos();
			
			connexion.commit();		
			
			this.quitarTipoDocumentosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDocumentos()throws Exception {				
		 try {	
			TipoDocumentoLogicAdditional.checkTipoDocumentoToSaves(tipodocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDocumento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDocumento tipodocumentoLocal:tipodocumentos) {				
				if(tipodocumentoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDocumentoLogicAdditional.updateTipoDocumentoToSave(tipodocumentoLocal,this.arrDatoGeneral);
	        	
				TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodocumentoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDocumento(tipodocumentoLocal)) {				
					TipoDocumentoDataAccess.save(tipodocumentoLocal, connexion);				
				} else {
					validadoTodosTipoDocumento=false;
				}
			}
			
			if(!validadoTodosTipoDocumento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDocumentoLogicAdditional.checkTipoDocumentoToSavesAfter(tipodocumentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDocumentosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDocumentoParameterReturnGeneral procesarAccionTipoDocumentos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDocumento> tipodocumentos,TipoDocumentoParameterReturnGeneral tipodocumentoParameterGeneral)throws Exception {
		 try {	
			TipoDocumentoParameterReturnGeneral tipodocumentoReturnGeneral=new TipoDocumentoParameterReturnGeneral();
	
			TipoDocumentoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodocumentos,tipodocumentoParameterGeneral,tipodocumentoReturnGeneral);
			
			return tipodocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDocumentoParameterReturnGeneral procesarAccionTipoDocumentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDocumento> tipodocumentos,TipoDocumentoParameterReturnGeneral tipodocumentoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-procesarAccionTipoDocumentosWithConnection");connexion.begin();			
			
			TipoDocumentoParameterReturnGeneral tipodocumentoReturnGeneral=new TipoDocumentoParameterReturnGeneral();
	
			TipoDocumentoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodocumentos,tipodocumentoParameterGeneral,tipodocumentoReturnGeneral);
			
			this.connexion.commit();
			
			return tipodocumentoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDocumentoParameterReturnGeneral procesarEventosTipoDocumentos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDocumento> tipodocumentos,TipoDocumento tipodocumento,TipoDocumentoParameterReturnGeneral tipodocumentoParameterGeneral,Boolean isEsNuevoTipoDocumento,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDocumentoParameterReturnGeneral tipodocumentoReturnGeneral=new TipoDocumentoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodocumentoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDocumentoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodocumentos,tipodocumento,tipodocumentoParameterGeneral,tipodocumentoReturnGeneral,isEsNuevoTipoDocumento,clases);
			
			return tipodocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDocumentoParameterReturnGeneral procesarEventosTipoDocumentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDocumento> tipodocumentos,TipoDocumento tipodocumento,TipoDocumentoParameterReturnGeneral tipodocumentoParameterGeneral,Boolean isEsNuevoTipoDocumento,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-procesarEventosTipoDocumentosWithConnection");connexion.begin();			
			
			TipoDocumentoParameterReturnGeneral tipodocumentoReturnGeneral=new TipoDocumentoParameterReturnGeneral();
	
			tipodocumentoReturnGeneral.setTipoDocumento(tipodocumento);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodocumentoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDocumentoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodocumentos,tipodocumento,tipodocumentoParameterGeneral,tipodocumentoReturnGeneral,isEsNuevoTipoDocumento,clases);
			
			this.connexion.commit();
			
			return tipodocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDocumentoParameterReturnGeneral procesarImportacionTipoDocumentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDocumentoParameterReturnGeneral tipodocumentoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-procesarImportacionTipoDocumentosWithConnection");connexion.begin();			
			
			TipoDocumentoParameterReturnGeneral tipodocumentoReturnGeneral=new TipoDocumentoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodocumentos=new ArrayList<TipoDocumento>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodocumento=new TipoDocumento();
				
				
				if(conColumnasBase) {this.tipodocumento.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodocumento.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodocumento.setcodigo(arrColumnas[iColumn++]);
				this.tipodocumento.setnombre(arrColumnas[iColumn++]);
				this.tipodocumento.setes_defecto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tipodocumento.setes_mayor(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tipodocumentos.add(this.tipodocumento);
			}
			
			this.saveTipoDocumentos();
			
			this.connexion.commit();
			
			tipodocumentoReturnGeneral.setConRetornoEstaProcesado(true);
			tipodocumentoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodocumentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDocumentosEliminados() throws Exception {				
		
		List<TipoDocumento> tipodocumentosAux= new ArrayList<TipoDocumento>();
		
		for(TipoDocumento tipodocumento:tipodocumentos) {
			if(!tipodocumento.getIsDeleted()) {
				tipodocumentosAux.add(tipodocumento);
			}
		}
		
		tipodocumentos=tipodocumentosAux;
	}
	
	public void quitarTipoDocumentosNulos() throws Exception {				
		
		List<TipoDocumento> tipodocumentosAux= new ArrayList<TipoDocumento>();
		
		for(TipoDocumento tipodocumento : this.tipodocumentos) {
			if(tipodocumento==null) {
				tipodocumentosAux.add(tipodocumento);
			}
		}
		
		//this.tipodocumentos=tipodocumentosAux;
		
		this.tipodocumentos.removeAll(tipodocumentosAux);
	}
	
	public void getSetVersionRowTipoDocumentoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodocumento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodocumento.getIsDeleted() || (tipodocumento.getIsChanged()&&!tipodocumento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodocumentoDataAccess.getSetVersionRowTipoDocumento(connexion,tipodocumento.getId());
				
				if(!tipodocumento.getVersionRow().equals(timestamp)) {	
					tipodocumento.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodocumento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDocumento()throws Exception {	
		
		if(tipodocumento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodocumento.getIsDeleted() || (tipodocumento.getIsChanged()&&!tipodocumento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodocumentoDataAccess.getSetVersionRowTipoDocumento(connexion,tipodocumento.getId());
			
			try {							
				if(!tipodocumento.getVersionRow().equals(timestamp)) {	
					tipodocumento.setVersionRow(timestamp);
				}
				
				tipodocumento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDocumentosWithConnection()throws Exception {	
		if(tipodocumentos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDocumento tipodocumentoAux:tipodocumentos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodocumentoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodocumentoAux.getIsDeleted() || (tipodocumentoAux.getIsChanged()&&!tipodocumentoAux.getIsNew())) {
						
						timestamp=tipodocumentoDataAccess.getSetVersionRowTipoDocumento(connexion,tipodocumentoAux.getId());
						
						if(!tipodocumento.getVersionRow().equals(timestamp)) {	
							tipodocumentoAux.setVersionRow(timestamp);
						}
								
						tipodocumentoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDocumentos()throws Exception {	
		if(tipodocumentos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDocumento tipodocumentoAux:tipodocumentos) {
					if(tipodocumentoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodocumentoAux.getIsDeleted() || (tipodocumentoAux.getIsChanged()&&!tipodocumentoAux.getIsNew())) {
						
						timestamp=tipodocumentoDataAccess.getSetVersionRowTipoDocumento(connexion,tipodocumentoAux.getId());
						
						if(!tipodocumentoAux.getVersionRow().equals(timestamp)) {	
							tipodocumentoAux.setVersionRow(timestamp);
						}
						
													
						tipodocumentoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoDocumentoParameterReturnGeneral cargarCombosLoteForeignKeyTipoDocumentoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoMovimientoModulo) throws Exception {
		TipoDocumentoParameterReturnGeneral  tipodocumentoReturnGeneral =new TipoDocumentoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoDocumentoWithConnection");connexion.begin();
			
			tipodocumentoReturnGeneral =new TipoDocumentoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodocumentoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipodocumentoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			tipodocumentoReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			tipodocumentoReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipodocumentoReturnGeneral;
	}
	
	public TipoDocumentoParameterReturnGeneral cargarCombosLoteForeignKeyTipoDocumento(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoMovimientoModulo) throws Exception {
		TipoDocumentoParameterReturnGeneral  tipodocumentoReturnGeneral =new TipoDocumentoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipodocumentoReturnGeneral =new TipoDocumentoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodocumentoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipodocumentoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			tipodocumentoReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			tipodocumentoReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipodocumentoReturnGeneral;
	}
	
	
	public void deepLoad(TipoDocumento tipodocumento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoDocumentoLogicAdditional.updateTipoDocumentoToGet(tipodocumento,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodocumento.setEmpresa(tipodocumentoDataAccess.getEmpresa(connexion,tipodocumento));
		tipodocumento.setModulo(tipodocumentoDataAccess.getModulo(connexion,tipodocumento));
		tipodocumento.setTipoMovimiento(tipodocumentoDataAccess.getTipoMovimiento(connexion,tipodocumento));
		tipodocumento.setTipoMovimientoModulo(tipodocumentoDataAccess.getTipoMovimientoModulo(connexion,tipodocumento));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodocumento.setEmpresa(tipodocumentoDataAccess.getEmpresa(connexion,tipodocumento));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				tipodocumento.setModulo(tipodocumentoDataAccess.getModulo(connexion,tipodocumento));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				tipodocumento.setTipoMovimiento(tipodocumentoDataAccess.getTipoMovimiento(connexion,tipodocumento));
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				tipodocumento.setTipoMovimientoModulo(tipodocumentoDataAccess.getTipoMovimientoModulo(connexion,tipodocumento));
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
			tipodocumento.setEmpresa(tipodocumentoDataAccess.getEmpresa(connexion,tipodocumento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipodocumento.setModulo(tipodocumentoDataAccess.getModulo(connexion,tipodocumento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipodocumento.setTipoMovimiento(tipodocumentoDataAccess.getTipoMovimiento(connexion,tipodocumento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipodocumento.setTipoMovimientoModulo(tipodocumentoDataAccess.getTipoMovimientoModulo(connexion,tipodocumento));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodocumento.setEmpresa(tipodocumentoDataAccess.getEmpresa(connexion,tipodocumento));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodocumento.getEmpresa(),isDeep,deepLoadType,clases);
				
		tipodocumento.setModulo(tipodocumentoDataAccess.getModulo(connexion,tipodocumento));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipodocumento.getModulo(),isDeep,deepLoadType,clases);
				
		tipodocumento.setTipoMovimiento(tipodocumentoDataAccess.getTipoMovimiento(connexion,tipodocumento));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(tipodocumento.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		tipodocumento.setTipoMovimientoModulo(tipodocumentoDataAccess.getTipoMovimientoModulo(connexion,tipodocumento));
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(tipodocumento.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodocumento.setEmpresa(tipodocumentoDataAccess.getEmpresa(connexion,tipodocumento));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipodocumento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				tipodocumento.setModulo(tipodocumentoDataAccess.getModulo(connexion,tipodocumento));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(tipodocumento.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				tipodocumento.setTipoMovimiento(tipodocumentoDataAccess.getTipoMovimiento(connexion,tipodocumento));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(tipodocumento.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				tipodocumento.setTipoMovimientoModulo(tipodocumentoDataAccess.getTipoMovimientoModulo(connexion,tipodocumento));
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepLoad(tipodocumento.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
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
			tipodocumento.setEmpresa(tipodocumentoDataAccess.getEmpresa(connexion,tipodocumento));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipodocumento.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipodocumento.setModulo(tipodocumentoDataAccess.getModulo(connexion,tipodocumento));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(tipodocumento.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipodocumento.setTipoMovimiento(tipodocumentoDataAccess.getTipoMovimiento(connexion,tipodocumento));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(tipodocumento.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipodocumento.setTipoMovimientoModulo(tipodocumentoDataAccess.getTipoMovimientoModulo(connexion,tipodocumento));
			TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
			tipomovimientomoduloLogic.deepLoad(tipodocumento.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDocumento tipodocumento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoDocumentoLogicAdditional.updateTipoDocumentoToSave(tipodocumento,this.arrDatoGeneral);
			
TipoDocumentoDataAccess.save(tipodocumento, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodocumento.getEmpresa(),connexion);

		ModuloDataAccess.save(tipodocumento.getModulo(),connexion);

		TipoMovimientoDataAccess.save(tipodocumento.getTipoMovimiento(),connexion);

		TipoMovimientoModuloDataAccess.save(tipodocumento.getTipoMovimientoModulo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodocumento.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(tipodocumento.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(tipodocumento.getTipoMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(tipodocumento.getTipoMovimientoModulo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodocumento.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodocumento.getEmpresa(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(tipodocumento.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipodocumento.getModulo(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(tipodocumento.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(tipodocumento.getTipoMovimiento(),isDeep,deepLoadType,clases);
				

		TipoMovimientoModuloDataAccess.save(tipodocumento.getTipoMovimientoModulo(),connexion);
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(tipodocumento.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodocumento.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipodocumento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(tipodocumento.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(tipodocumento.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(tipodocumento.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(tipodocumento.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(tipodocumento.getTipoMovimientoModulo(),connexion);
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepSave(tipodocumento.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoDocumento.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodocumento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(tipodocumento);
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
			this.deepLoad(this.tipodocumento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDocumento.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodocumentos!=null) {
				for(TipoDocumento tipodocumento:tipodocumentos) {
					this.deepLoad(tipodocumento,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(tipodocumentos);
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
			if(tipodocumentos!=null) {
				for(TipoDocumento tipodocumento:tipodocumentos) {
					this.deepLoad(tipodocumento,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(tipodocumentos);
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
			this.getNewConnexionToDeep(TipoDocumento.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipodocumento,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoDocumento.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipodocumentos!=null) {
				for(TipoDocumento tipodocumento:tipodocumentos) {
					this.deepSave(tipodocumento,isDeep,deepLoadType,clases);
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
			if(tipodocumentos!=null) {
				for(TipoDocumento tipodocumento:tipodocumentos) {
					this.deepSave(tipodocumento,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoDocumentosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoDocumentoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoDocumentoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentosBusquedaPorIdModuloPorIdTipoMovimientoModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorIdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentosBusquedaPorIdModuloPorIdTipoMovimientoModulo(String sFinalQuery,Pagination pagination,Long id_modulo,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorIdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoDocumentoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoDocumentoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentosFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentosFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentosFK_IdTipoMovimientoModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentosFK_IdTipoMovimientoModulo(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			TipoDocumentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentoPorEmpresaPorModuloPorTipoMoviModuWithConnection(Long id_empresa,Long id_modulo,Long id_tipo_movimiento_modulo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentoPorEmpresaPorModuloPorTipoMoviModu(Long id_empresa,Long id_modulo,Long id_tipo_movimiento_modulo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentoPorIdPorEmprePorModuPorTiMovPorTiMovModuWithConnection(Long id,Long id_empresa,Long id_modulo,Long id_tipo_movimiento,Long id_tipo_movimiento_modulo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoDocumentoConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentoPorIdPorEmprePorModuPorTiMovPorTiMovModu(Long id,Long id_empresa,Long id_modulo,Long id_tipo_movimiento,Long id_tipo_movimiento_modulo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoDocumentoConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentoPorIdPorEmpresaPorModuPorTiMoviModuWithConnection(Long id,Long id_empresa,Long id_modulo,Long id_tipo_movimiento_modulo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoDocumentoConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentoPorIdPorEmpresaPorModuPorTiMoviModu(Long id,Long id_empresa,Long id_modulo,Long id_tipo_movimiento_modulo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoDocumentoConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDocumentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDocumentoConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipodocumento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoDocumentoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumento(this.tipodocumento);
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
			if(TipoDocumentoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDocumento tipodocumento,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDocumentoConstantesFunciones.ISCONAUDITORIA) {
				if(tipodocumento.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoDataAccess.TABLENAME, tipodocumento.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDocumentoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDocumentoLogic.registrarAuditoriaDetallesTipoDocumento(connexion,tipodocumento,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodocumento.getIsDeleted()) {
					/*if(!tipodocumento.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDocumentoDataAccess.TABLENAME, tipodocumento.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDocumentoLogic.registrarAuditoriaDetallesTipoDocumento(connexion,tipodocumento,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoDataAccess.TABLENAME, tipodocumento.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodocumento.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoDataAccess.TABLENAME, tipodocumento.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDocumentoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDocumentoLogic.registrarAuditoriaDetallesTipoDocumento(connexion,tipodocumento,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDocumento(Connexion connexion,TipoDocumento tipodocumento)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodocumento.getIsNew()||!tipodocumento.getid_empresa().equals(tipodocumento.getTipoDocumentoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumento.getTipoDocumentoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipodocumento.getTipoDocumentoOriginal().getid_empresa().toString();
				}
				if(tipodocumento.getid_empresa()!=null)
				{
					strValorNuevo=tipodocumento.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipodocumento.getIsNew()||!tipodocumento.getid_modulo().equals(tipodocumento.getTipoDocumentoOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumento.getTipoDocumentoOriginal().getid_modulo()!=null)
				{
					strValorActual=tipodocumento.getTipoDocumentoOriginal().getid_modulo().toString();
				}
				if(tipodocumento.getid_modulo()!=null)
				{
					strValorNuevo=tipodocumento.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(tipodocumento.getIsNew()||!tipodocumento.getid_tipo_movimiento().equals(tipodocumento.getTipoDocumentoOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumento.getTipoDocumentoOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=tipodocumento.getTipoDocumentoOriginal().getid_tipo_movimiento().toString();
				}
				if(tipodocumento.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=tipodocumento.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(tipodocumento.getIsNew()||!tipodocumento.getcodigo().equals(tipodocumento.getTipoDocumentoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumento.getTipoDocumentoOriginal().getcodigo()!=null)
				{
					strValorActual=tipodocumento.getTipoDocumentoOriginal().getcodigo();
				}
				if(tipodocumento.getcodigo()!=null)
				{
					strValorNuevo=tipodocumento.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipodocumento.getIsNew()||!tipodocumento.getnombre().equals(tipodocumento.getTipoDocumentoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumento.getTipoDocumentoOriginal().getnombre()!=null)
				{
					strValorActual=tipodocumento.getTipoDocumentoOriginal().getnombre();
				}
				if(tipodocumento.getnombre()!=null)
				{
					strValorNuevo=tipodocumento.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipodocumento.getIsNew()||!tipodocumento.getid_tipo_movimiento_modulo().equals(tipodocumento.getTipoDocumentoOriginal().getid_tipo_movimiento_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumento.getTipoDocumentoOriginal().getid_tipo_movimiento_modulo()!=null)
				{
					strValorActual=tipodocumento.getTipoDocumentoOriginal().getid_tipo_movimiento_modulo().toString();
				}
				if(tipodocumento.getid_tipo_movimiento_modulo()!=null)
				{
					strValorNuevo=tipodocumento.getid_tipo_movimiento_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO,strValorActual,strValorNuevo);
			}	
			
			if(tipodocumento.getIsNew()||!tipodocumento.getes_defecto().equals(tipodocumento.getTipoDocumentoOriginal().getes_defecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumento.getTipoDocumentoOriginal().getes_defecto()!=null)
				{
					strValorActual=tipodocumento.getTipoDocumentoOriginal().getes_defecto().toString();
				}
				if(tipodocumento.getes_defecto()!=null)
				{
					strValorNuevo=tipodocumento.getes_defecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoConstantesFunciones.ESDEFECTO,strValorActual,strValorNuevo);
			}	
			
			if(tipodocumento.getIsNew()||!tipodocumento.getes_mayor().equals(tipodocumento.getTipoDocumentoOriginal().getes_mayor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumento.getTipoDocumentoOriginal().getes_mayor()!=null)
				{
					strValorActual=tipodocumento.getTipoDocumentoOriginal().getes_mayor().toString();
				}
				if(tipodocumento.getes_mayor()!=null)
				{
					strValorNuevo=tipodocumento.getes_mayor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoConstantesFunciones.ESMAYOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoDocumentoRelacionesWithConnection(TipoDocumento tipodocumento) throws Exception {

		if(!tipodocumento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDocumentoRelacionesBase(tipodocumento,true);
		}
	}

	public void saveTipoDocumentoRelaciones(TipoDocumento tipodocumento)throws Exception {

		if(!tipodocumento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDocumentoRelacionesBase(tipodocumento,false);
		}
	}

	public void saveTipoDocumentoRelacionesBase(TipoDocumento tipodocumento,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoDocumento-saveRelacionesWithConnection");}
	

			this.setTipoDocumento(tipodocumento);

			if(TipoDocumentoLogicAdditional.validarSaveRelaciones(tipodocumento,this)) {

				TipoDocumentoLogicAdditional.updateRelacionesToSave(tipodocumento,this);

				if((tipodocumento.getIsNew()||tipodocumento.getIsChanged())&&!tipodocumento.getIsDeleted()) {
					this.saveTipoDocumento();
					this.saveTipoDocumentoRelacionesDetalles();

				} else if(tipodocumento.getIsDeleted()) {
					this.saveTipoDocumentoRelacionesDetalles();
					this.saveTipoDocumento();
				}

				TipoDocumentoLogicAdditional.updateRelacionesToSaveAfter(tipodocumento,this);

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
	
	
	private void saveTipoDocumentoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDocumentoConstantesFunciones.getClassesForeignKeysOfTipoDocumento(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDocumento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDocumentoConstantesFunciones.getClassesRelationshipsOfTipoDocumento(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

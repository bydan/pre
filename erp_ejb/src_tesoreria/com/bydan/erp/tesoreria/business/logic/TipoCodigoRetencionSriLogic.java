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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.TipoCodigoRetencionSriConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoCodigoRetencionSriParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoCodigoRetencionSriParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TipoCodigoRetencionSri;
//import com.bydan.erp.tesoreria.business.logic.TipoCodigoRetencionSriLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoCodigoRetencionSriLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCodigoRetencionSriLogic.class);
	
	protected TipoCodigoRetencionSriDataAccess tipocodigoretencionsriDataAccess; 	
	protected TipoCodigoRetencionSri tipocodigoretencionsri;
	protected List<TipoCodigoRetencionSri> tipocodigoretencionsris;
	protected Object tipocodigoretencionsriObject;	
	protected List<Object> tipocodigoretencionsrisObject;
	
	public static ClassValidator<TipoCodigoRetencionSri> tipocodigoretencionsriValidator = new ClassValidator<TipoCodigoRetencionSri>(TipoCodigoRetencionSri.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoCodigoRetencionSriLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocodigoretencionsriDataAccess = new TipoCodigoRetencionSriDataAccess();
			
			this.tipocodigoretencionsris= new ArrayList<TipoCodigoRetencionSri>();
			this.tipocodigoretencionsri= new TipoCodigoRetencionSri();
			
			this.tipocodigoretencionsriObject=new Object();
			this.tipocodigoretencionsrisObject=new ArrayList<Object>();
				
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
			
			this.tipocodigoretencionsriDataAccess.setConnexionType(this.connexionType);
			this.tipocodigoretencionsriDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCodigoRetencionSriLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocodigoretencionsriDataAccess = new TipoCodigoRetencionSriDataAccess();
			this.tipocodigoretencionsris= new ArrayList<TipoCodigoRetencionSri>();
			this.tipocodigoretencionsri= new TipoCodigoRetencionSri();
			this.tipocodigoretencionsriObject=new Object();
			this.tipocodigoretencionsrisObject=new ArrayList<Object>();
			
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
			
			this.tipocodigoretencionsriDataAccess.setConnexionType(this.connexionType);
			this.tipocodigoretencionsriDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCodigoRetencionSri getTipoCodigoRetencionSri() throws Exception {	
		//TipoCodigoRetencionSriLogicAdditional.checkTipoCodigoRetencionSriToGet(tipocodigoretencionsri,this.datosCliente,this.arrDatoGeneral);
		//TipoCodigoRetencionSriLogicAdditional.updateTipoCodigoRetencionSriToGet(tipocodigoretencionsri,this.arrDatoGeneral);
		
		return tipocodigoretencionsri;
	}
		
	public void setTipoCodigoRetencionSri(TipoCodigoRetencionSri newTipoCodigoRetencionSri) {
		this.tipocodigoretencionsri = newTipoCodigoRetencionSri;
	}
	
	public TipoCodigoRetencionSriDataAccess getTipoCodigoRetencionSriDataAccess() {
		return tipocodigoretencionsriDataAccess;
	}
	
	public void setTipoCodigoRetencionSriDataAccess(TipoCodigoRetencionSriDataAccess newtipocodigoretencionsriDataAccess) {
		this.tipocodigoretencionsriDataAccess = newtipocodigoretencionsriDataAccess;
	}
	
	public List<TipoCodigoRetencionSri> getTipoCodigoRetencionSris() throws Exception {		
		this.quitarTipoCodigoRetencionSrisNulos();
		
		//TipoCodigoRetencionSriLogicAdditional.checkTipoCodigoRetencionSriToGets(tipocodigoretencionsris,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCodigoRetencionSri tipocodigoretencionsriLocal: tipocodigoretencionsris ) {
			//TipoCodigoRetencionSriLogicAdditional.updateTipoCodigoRetencionSriToGet(tipocodigoretencionsriLocal,this.arrDatoGeneral);
		}
		
		return tipocodigoretencionsris;
	}
	
	public void setTipoCodigoRetencionSris(List<TipoCodigoRetencionSri> newTipoCodigoRetencionSris) {
		this.tipocodigoretencionsris = newTipoCodigoRetencionSris;
	}
	
	public Object getTipoCodigoRetencionSriObject() {	
		this.tipocodigoretencionsriObject=this.tipocodigoretencionsriDataAccess.getEntityObject();
		return this.tipocodigoretencionsriObject;
	}
		
	public void setTipoCodigoRetencionSriObject(Object newTipoCodigoRetencionSriObject) {
		this.tipocodigoretencionsriObject = newTipoCodigoRetencionSriObject;
	}
	
	public List<Object> getTipoCodigoRetencionSrisObject() {		
		this.tipocodigoretencionsrisObject=this.tipocodigoretencionsriDataAccess.getEntitiesObject();
		return this.tipocodigoretencionsrisObject;
	}
		
	public void setTipoCodigoRetencionSrisObject(List<Object> newTipoCodigoRetencionSrisObject) {
		this.tipocodigoretencionsrisObject = newTipoCodigoRetencionSrisObject;
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
		
		if(this.tipocodigoretencionsriDataAccess!=null) {
			this.tipocodigoretencionsriDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocodigoretencionsriDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocodigoretencionsriDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocodigoretencionsri=tipocodigoretencionsriDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocodigoretencionsri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsri);
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
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		  		  
        try {
			
			tipocodigoretencionsri=tipocodigoretencionsriDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocodigoretencionsri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocodigoretencionsri=tipocodigoretencionsriDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocodigoretencionsri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsri);
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
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		  		  
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
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		  		  
        try {
			
			tipocodigoretencionsri=tipocodigoretencionsriDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocodigoretencionsri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		  		  
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
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocodigoretencionsriDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocodigoretencionsriDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocodigoretencionsriDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocodigoretencionsriDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocodigoretencionsriDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocodigoretencionsriDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocodigoretencionsris = new  ArrayList<TipoCodigoRetencionSri>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCodigoRetencionSri(tipocodigoretencionsris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
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
		tipocodigoretencionsris = new  ArrayList<TipoCodigoRetencionSri>();
		  		  
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
		tipocodigoretencionsris = new  ArrayList<TipoCodigoRetencionSri>();
		  		  
        try {			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCodigoRetencionSri(tipocodigoretencionsris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocodigoretencionsris = new  ArrayList<TipoCodigoRetencionSri>();
		  		  
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
		tipocodigoretencionsris = new  ArrayList<TipoCodigoRetencionSri>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCodigoRetencionSri(tipocodigoretencionsris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
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
		tipocodigoretencionsris = new  ArrayList<TipoCodigoRetencionSri>();
		  		  
        try {
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCodigoRetencionSri(tipocodigoretencionsris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
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
		tipocodigoretencionsris = new  ArrayList<TipoCodigoRetencionSri>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCodigoRetencionSri(tipocodigoretencionsris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
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
		tipocodigoretencionsris = new  ArrayList<TipoCodigoRetencionSri>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCodigoRetencionSri(tipocodigoretencionsris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigoretencionsri=tipocodigoretencionsriDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCodigoRetencionSri(tipocodigoretencionsri);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsri);
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
		tipocodigoretencionsri = new  TipoCodigoRetencionSri();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigoretencionsri=tipocodigoretencionsriDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCodigoRetencionSri(tipocodigoretencionsri);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoCodigoRetencionSrisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocodigoretencionsris = new  ArrayList<TipoCodigoRetencionSri>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getTodosTipoCodigoRetencionSrisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCodigoRetencionSri(tipocodigoretencionsris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
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
	
	public  void  getTodosTipoCodigoRetencionSris(String sFinalQuery,Pagination pagination)throws Exception {
		tipocodigoretencionsris = new  ArrayList<TipoCodigoRetencionSri>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCodigoRetencionSri(tipocodigoretencionsris);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCodigoRetencionSri(TipoCodigoRetencionSri tipocodigoretencionsri) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocodigoretencionsri.getIsNew() || tipocodigoretencionsri.getIsChanged()) { 
			this.invalidValues = tipocodigoretencionsriValidator.getInvalidValues(tipocodigoretencionsri);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocodigoretencionsri);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCodigoRetencionSri(List<TipoCodigoRetencionSri> TipoCodigoRetencionSris) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCodigoRetencionSri tipocodigoretencionsriLocal:tipocodigoretencionsris) {				
			estaValidadoObjeto=this.validarGuardarTipoCodigoRetencionSri(tipocodigoretencionsriLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCodigoRetencionSri(List<TipoCodigoRetencionSri> TipoCodigoRetencionSris) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCodigoRetencionSri(tipocodigoretencionsris)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCodigoRetencionSri(TipoCodigoRetencionSri TipoCodigoRetencionSri) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCodigoRetencionSri(tipocodigoretencionsri)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCodigoRetencionSri tipocodigoretencionsri) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocodigoretencionsri.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCodigoRetencionSriConstantesFunciones.getTipoCodigoRetencionSriLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocodigoretencionsri","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCodigoRetencionSriConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCodigoRetencionSriConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCodigoRetencionSriWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-saveTipoCodigoRetencionSriWithConnection");connexion.begin();			
			
			//TipoCodigoRetencionSriLogicAdditional.checkTipoCodigoRetencionSriToSave(this.tipocodigoretencionsri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCodigoRetencionSriLogicAdditional.updateTipoCodigoRetencionSriToSave(this.tipocodigoretencionsri,this.arrDatoGeneral);
			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocodigoretencionsri,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCodigoRetencionSri();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCodigoRetencionSri(this.tipocodigoretencionsri)) {
				TipoCodigoRetencionSriDataAccess.save(this.tipocodigoretencionsri, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocodigoretencionsri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCodigoRetencionSriLogicAdditional.checkTipoCodigoRetencionSriToSaveAfter(this.tipocodigoretencionsri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCodigoRetencionSri();
			
			connexion.commit();			
			
			if(this.tipocodigoretencionsri.getIsDeleted()) {
				this.tipocodigoretencionsri=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCodigoRetencionSri()throws Exception {	
		try {	
			
			//TipoCodigoRetencionSriLogicAdditional.checkTipoCodigoRetencionSriToSave(this.tipocodigoretencionsri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCodigoRetencionSriLogicAdditional.updateTipoCodigoRetencionSriToSave(this.tipocodigoretencionsri,this.arrDatoGeneral);
			
			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocodigoretencionsri,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCodigoRetencionSri(this.tipocodigoretencionsri)) {			
				TipoCodigoRetencionSriDataAccess.save(this.tipocodigoretencionsri, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocodigoretencionsri,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCodigoRetencionSriLogicAdditional.checkTipoCodigoRetencionSriToSaveAfter(this.tipocodigoretencionsri,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocodigoretencionsri.getIsDeleted()) {
				this.tipocodigoretencionsri=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCodigoRetencionSrisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-saveTipoCodigoRetencionSrisWithConnection");connexion.begin();			
			
			//TipoCodigoRetencionSriLogicAdditional.checkTipoCodigoRetencionSriToSaves(tipocodigoretencionsris,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCodigoRetencionSris();
			
			Boolean validadoTodosTipoCodigoRetencionSri=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCodigoRetencionSri tipocodigoretencionsriLocal:tipocodigoretencionsris) {		
				if(tipocodigoretencionsriLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCodigoRetencionSriLogicAdditional.updateTipoCodigoRetencionSriToSave(tipocodigoretencionsriLocal,this.arrDatoGeneral);
	        	
				TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocodigoretencionsriLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCodigoRetencionSri(tipocodigoretencionsriLocal)) {
					TipoCodigoRetencionSriDataAccess.save(tipocodigoretencionsriLocal, connexion);				
				} else {
					validadoTodosTipoCodigoRetencionSri=false;
				}
			}
			
			if(!validadoTodosTipoCodigoRetencionSri) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCodigoRetencionSriLogicAdditional.checkTipoCodigoRetencionSriToSavesAfter(tipocodigoretencionsris,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCodigoRetencionSris();
			
			connexion.commit();		
			
			this.quitarTipoCodigoRetencionSrisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCodigoRetencionSris()throws Exception {				
		 try {	
			//TipoCodigoRetencionSriLogicAdditional.checkTipoCodigoRetencionSriToSaves(tipocodigoretencionsris,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCodigoRetencionSri=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCodigoRetencionSri tipocodigoretencionsriLocal:tipocodigoretencionsris) {				
				if(tipocodigoretencionsriLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCodigoRetencionSriLogicAdditional.updateTipoCodigoRetencionSriToSave(tipocodigoretencionsriLocal,this.arrDatoGeneral);
	        	
				TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocodigoretencionsriLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCodigoRetencionSri(tipocodigoretencionsriLocal)) {				
					TipoCodigoRetencionSriDataAccess.save(tipocodigoretencionsriLocal, connexion);				
				} else {
					validadoTodosTipoCodigoRetencionSri=false;
				}
			}
			
			if(!validadoTodosTipoCodigoRetencionSri) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCodigoRetencionSriLogicAdditional.checkTipoCodigoRetencionSriToSavesAfter(tipocodigoretencionsris,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCodigoRetencionSrisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCodigoRetencionSriParameterReturnGeneral procesarAccionTipoCodigoRetencionSris(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCodigoRetencionSri> tipocodigoretencionsris,TipoCodigoRetencionSriParameterReturnGeneral tipocodigoretencionsriParameterGeneral)throws Exception {
		 try {	
			TipoCodigoRetencionSriParameterReturnGeneral tipocodigoretencionsriReturnGeneral=new TipoCodigoRetencionSriParameterReturnGeneral();
	
			
			return tipocodigoretencionsriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCodigoRetencionSriParameterReturnGeneral procesarAccionTipoCodigoRetencionSrisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCodigoRetencionSri> tipocodigoretencionsris,TipoCodigoRetencionSriParameterReturnGeneral tipocodigoretencionsriParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-procesarAccionTipoCodigoRetencionSrisWithConnection");connexion.begin();			
			
			TipoCodigoRetencionSriParameterReturnGeneral tipocodigoretencionsriReturnGeneral=new TipoCodigoRetencionSriParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipocodigoretencionsriReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCodigoRetencionSriParameterReturnGeneral procesarEventosTipoCodigoRetencionSris(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCodigoRetencionSri> tipocodigoretencionsris,TipoCodigoRetencionSri tipocodigoretencionsri,TipoCodigoRetencionSriParameterReturnGeneral tipocodigoretencionsriParameterGeneral,Boolean isEsNuevoTipoCodigoRetencionSri,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCodigoRetencionSriParameterReturnGeneral tipocodigoretencionsriReturnGeneral=new TipoCodigoRetencionSriParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocodigoretencionsriReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipocodigoretencionsriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCodigoRetencionSriParameterReturnGeneral procesarEventosTipoCodigoRetencionSrisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCodigoRetencionSri> tipocodigoretencionsris,TipoCodigoRetencionSri tipocodigoretencionsri,TipoCodigoRetencionSriParameterReturnGeneral tipocodigoretencionsriParameterGeneral,Boolean isEsNuevoTipoCodigoRetencionSri,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-procesarEventosTipoCodigoRetencionSrisWithConnection");connexion.begin();			
			
			TipoCodigoRetencionSriParameterReturnGeneral tipocodigoretencionsriReturnGeneral=new TipoCodigoRetencionSriParameterReturnGeneral();
	
			tipocodigoretencionsriReturnGeneral.setTipoCodigoRetencionSri(tipocodigoretencionsri);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocodigoretencionsriReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipocodigoretencionsriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCodigoRetencionSriParameterReturnGeneral procesarImportacionTipoCodigoRetencionSrisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCodigoRetencionSriParameterReturnGeneral tipocodigoretencionsriParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-procesarImportacionTipoCodigoRetencionSrisWithConnection");connexion.begin();			
			
			TipoCodigoRetencionSriParameterReturnGeneral tipocodigoretencionsriReturnGeneral=new TipoCodigoRetencionSriParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocodigoretencionsris=new ArrayList<TipoCodigoRetencionSri>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocodigoretencionsri=new TipoCodigoRetencionSri();
				
				
				if(conColumnasBase) {this.tipocodigoretencionsri.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocodigoretencionsri.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocodigoretencionsri.setcodigo(arrColumnas[iColumn++]);
				this.tipocodigoretencionsri.setnombre(arrColumnas[iColumn++]);
				
				this.tipocodigoretencionsris.add(this.tipocodigoretencionsri);
			}
			
			this.saveTipoCodigoRetencionSris();
			
			this.connexion.commit();
			
			tipocodigoretencionsriReturnGeneral.setConRetornoEstaProcesado(true);
			tipocodigoretencionsriReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocodigoretencionsriReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCodigoRetencionSrisEliminados() throws Exception {				
		
		List<TipoCodigoRetencionSri> tipocodigoretencionsrisAux= new ArrayList<TipoCodigoRetencionSri>();
		
		for(TipoCodigoRetencionSri tipocodigoretencionsri:tipocodigoretencionsris) {
			if(!tipocodigoretencionsri.getIsDeleted()) {
				tipocodigoretencionsrisAux.add(tipocodigoretencionsri);
			}
		}
		
		tipocodigoretencionsris=tipocodigoretencionsrisAux;
	}
	
	public void quitarTipoCodigoRetencionSrisNulos() throws Exception {				
		
		List<TipoCodigoRetencionSri> tipocodigoretencionsrisAux= new ArrayList<TipoCodigoRetencionSri>();
		
		for(TipoCodigoRetencionSri tipocodigoretencionsri : this.tipocodigoretencionsris) {
			if(tipocodigoretencionsri==null) {
				tipocodigoretencionsrisAux.add(tipocodigoretencionsri);
			}
		}
		
		//this.tipocodigoretencionsris=tipocodigoretencionsrisAux;
		
		this.tipocodigoretencionsris.removeAll(tipocodigoretencionsrisAux);
	}
	
	public void getSetVersionRowTipoCodigoRetencionSriWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocodigoretencionsri.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocodigoretencionsri.getIsDeleted() || (tipocodigoretencionsri.getIsChanged()&&!tipocodigoretencionsri.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocodigoretencionsriDataAccess.getSetVersionRowTipoCodigoRetencionSri(connexion,tipocodigoretencionsri.getId());
				
				if(!tipocodigoretencionsri.getVersionRow().equals(timestamp)) {	
					tipocodigoretencionsri.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocodigoretencionsri.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCodigoRetencionSri()throws Exception {	
		
		if(tipocodigoretencionsri.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocodigoretencionsri.getIsDeleted() || (tipocodigoretencionsri.getIsChanged()&&!tipocodigoretencionsri.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocodigoretencionsriDataAccess.getSetVersionRowTipoCodigoRetencionSri(connexion,tipocodigoretencionsri.getId());
			
			try {							
				if(!tipocodigoretencionsri.getVersionRow().equals(timestamp)) {	
					tipocodigoretencionsri.setVersionRow(timestamp);
				}
				
				tipocodigoretencionsri.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCodigoRetencionSrisWithConnection()throws Exception {	
		if(tipocodigoretencionsris!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCodigoRetencionSri tipocodigoretencionsriAux:tipocodigoretencionsris) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocodigoretencionsriAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocodigoretencionsriAux.getIsDeleted() || (tipocodigoretencionsriAux.getIsChanged()&&!tipocodigoretencionsriAux.getIsNew())) {
						
						timestamp=tipocodigoretencionsriDataAccess.getSetVersionRowTipoCodigoRetencionSri(connexion,tipocodigoretencionsriAux.getId());
						
						if(!tipocodigoretencionsri.getVersionRow().equals(timestamp)) {	
							tipocodigoretencionsriAux.setVersionRow(timestamp);
						}
								
						tipocodigoretencionsriAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCodigoRetencionSris()throws Exception {	
		if(tipocodigoretencionsris!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCodigoRetencionSri tipocodigoretencionsriAux:tipocodigoretencionsris) {
					if(tipocodigoretencionsriAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocodigoretencionsriAux.getIsDeleted() || (tipocodigoretencionsriAux.getIsChanged()&&!tipocodigoretencionsriAux.getIsNew())) {
						
						timestamp=tipocodigoretencionsriDataAccess.getSetVersionRowTipoCodigoRetencionSri(connexion,tipocodigoretencionsriAux.getId());
						
						if(!tipocodigoretencionsriAux.getVersionRow().equals(timestamp)) {	
							tipocodigoretencionsriAux.setVersionRow(timestamp);
						}
						
													
						tipocodigoretencionsriAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoCodigoRetencionSriParameterReturnGeneral cargarCombosLoteForeignKeyTipoCodigoRetencionSriWithConnection(String finalQueryGlobalPais) throws Exception {
		TipoCodigoRetencionSriParameterReturnGeneral  tipocodigoretencionsriReturnGeneral =new TipoCodigoRetencionSriParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoCodigoRetencionSriWithConnection");connexion.begin();
			
			tipocodigoretencionsriReturnGeneral =new TipoCodigoRetencionSriParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipocodigoretencionsriReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocodigoretencionsriReturnGeneral;
	}
	
	public TipoCodigoRetencionSriParameterReturnGeneral cargarCombosLoteForeignKeyTipoCodigoRetencionSri(String finalQueryGlobalPais) throws Exception {
		TipoCodigoRetencionSriParameterReturnGeneral  tipocodigoretencionsriReturnGeneral =new TipoCodigoRetencionSriParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocodigoretencionsriReturnGeneral =new TipoCodigoRetencionSriParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipocodigoretencionsriReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocodigoretencionsriReturnGeneral;
	}
	
	
	public void deepLoad(TipoCodigoRetencionSri tipocodigoretencionsri,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoCodigoRetencionSriLogicAdditional.updateTipoCodigoRetencionSriToGet(tipocodigoretencionsri,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocodigoretencionsri.setPais(tipocodigoretencionsriDataAccess.getPais(connexion,tipocodigoretencionsri));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipocodigoretencionsri.setPais(tipocodigoretencionsriDataAccess.getPais(connexion,tipocodigoretencionsri));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocodigoretencionsri.setPais(tipocodigoretencionsriDataAccess.getPais(connexion,tipocodigoretencionsri));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocodigoretencionsri.setPais(tipocodigoretencionsriDataAccess.getPais(connexion,tipocodigoretencionsri));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tipocodigoretencionsri.getPais(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipocodigoretencionsri.setPais(tipocodigoretencionsriDataAccess.getPais(connexion,tipocodigoretencionsri));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(tipocodigoretencionsri.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocodigoretencionsri.setPais(tipocodigoretencionsriDataAccess.getPais(connexion,tipocodigoretencionsri));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(tipocodigoretencionsri.getPais(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCodigoRetencionSri tipocodigoretencionsri,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCodigoRetencionSri.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocodigoretencionsri,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(tipocodigoretencionsri);
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
			this.deepLoad(this.tipocodigoretencionsri,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsri);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCodigoRetencionSri.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocodigoretencionsris!=null) {
				for(TipoCodigoRetencionSri tipocodigoretencionsri:tipocodigoretencionsris) {
					this.deepLoad(tipocodigoretencionsri,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(tipocodigoretencionsris);
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
			if(tipocodigoretencionsris!=null) {
				for(TipoCodigoRetencionSri tipocodigoretencionsri:tipocodigoretencionsris) {
					this.deepLoad(tipocodigoretencionsri,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(tipocodigoretencionsris);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoCodigoRetencionSrisBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoCodigoRetencionSriConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCodigoRetencionSrisBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoCodigoRetencionSriConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoCodigoRetencionSrisBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoCodigoRetencionSriConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCodigoRetencionSrisBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoCodigoRetencionSriConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoCodigoRetencionSrisFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoRetencionSri.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoCodigoRetencionSriConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCodigoRetencionSrisFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoCodigoRetencionSriConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoCodigoRetencionSriLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocodigoretencionsris=tipocodigoretencionsriDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCodigoRetencionSriConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoRetencionSri(this.tipocodigoretencionsris);
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
			if(TipoCodigoRetencionSriConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCodigoRetencionSriDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCodigoRetencionSri tipocodigoretencionsri,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCodigoRetencionSriConstantesFunciones.ISCONAUDITORIA) {
				if(tipocodigoretencionsri.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCodigoRetencionSriDataAccess.TABLENAME, tipocodigoretencionsri.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCodigoRetencionSriConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCodigoRetencionSriLogic.registrarAuditoriaDetallesTipoCodigoRetencionSri(connexion,tipocodigoretencionsri,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocodigoretencionsri.getIsDeleted()) {
					/*if(!tipocodigoretencionsri.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCodigoRetencionSriDataAccess.TABLENAME, tipocodigoretencionsri.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCodigoRetencionSriLogic.registrarAuditoriaDetallesTipoCodigoRetencionSri(connexion,tipocodigoretencionsri,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCodigoRetencionSriDataAccess.TABLENAME, tipocodigoretencionsri.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocodigoretencionsri.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCodigoRetencionSriDataAccess.TABLENAME, tipocodigoretencionsri.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCodigoRetencionSriConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCodigoRetencionSriLogic.registrarAuditoriaDetallesTipoCodigoRetencionSri(connexion,tipocodigoretencionsri,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCodigoRetencionSri(Connexion connexion,TipoCodigoRetencionSri tipocodigoretencionsri)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocodigoretencionsri.getIsNew()||!tipocodigoretencionsri.getid_pais().equals(tipocodigoretencionsri.getTipoCodigoRetencionSriOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocodigoretencionsri.getTipoCodigoRetencionSriOriginal().getid_pais()!=null)
				{
					strValorActual=tipocodigoretencionsri.getTipoCodigoRetencionSriOriginal().getid_pais().toString();
				}
				if(tipocodigoretencionsri.getid_pais()!=null)
				{
					strValorNuevo=tipocodigoretencionsri.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCodigoRetencionSriConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(tipocodigoretencionsri.getIsNew()||!tipocodigoretencionsri.getcodigo().equals(tipocodigoretencionsri.getTipoCodigoRetencionSriOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocodigoretencionsri.getTipoCodigoRetencionSriOriginal().getcodigo()!=null)
				{
					strValorActual=tipocodigoretencionsri.getTipoCodigoRetencionSriOriginal().getcodigo();
				}
				if(tipocodigoretencionsri.getcodigo()!=null)
				{
					strValorNuevo=tipocodigoretencionsri.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCodigoRetencionSriConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocodigoretencionsri.getIsNew()||!tipocodigoretencionsri.getnombre().equals(tipocodigoretencionsri.getTipoCodigoRetencionSriOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocodigoretencionsri.getTipoCodigoRetencionSriOriginal().getnombre()!=null)
				{
					strValorActual=tipocodigoretencionsri.getTipoCodigoRetencionSriOriginal().getnombre();
				}
				if(tipocodigoretencionsri.getnombre()!=null)
				{
					strValorNuevo=tipocodigoretencionsri.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCodigoRetencionSriConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCodigoRetencionSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCodigoRetencionSriConstantesFunciones.getClassesForeignKeysOfTipoCodigoRetencionSri(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCodigoRetencionSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCodigoRetencionSriConstantesFunciones.getClassesRelationshipsOfTipoCodigoRetencionSri(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

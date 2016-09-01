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
import com.bydan.erp.tesoreria.util.TipoRetencionFuenteIvaConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoRetencionFuenteIvaParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoRetencionFuenteIvaParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TipoRetencionFuenteIva;
import com.bydan.erp.tesoreria.business.logic.TipoRetencionFuenteIvaLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

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
public class TipoRetencionFuenteIvaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoRetencionFuenteIvaLogic.class);
	
	protected TipoRetencionFuenteIvaDataAccess tiporetencionfuenteivaDataAccess; 	
	protected TipoRetencionFuenteIva tiporetencionfuenteiva;
	protected List<TipoRetencionFuenteIva> tiporetencionfuenteivas;
	protected Object tiporetencionfuenteivaObject;	
	protected List<Object> tiporetencionfuenteivasObject;
	
	public static ClassValidator<TipoRetencionFuenteIva> tiporetencionfuenteivaValidator = new ClassValidator<TipoRetencionFuenteIva>(TipoRetencionFuenteIva.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoRetencionFuenteIvaLogicAdditional tiporetencionfuenteivaLogicAdditional=null;
	
	public TipoRetencionFuenteIvaLogicAdditional getTipoRetencionFuenteIvaLogicAdditional() {
		return this.tiporetencionfuenteivaLogicAdditional;
	}
	
	public void setTipoRetencionFuenteIvaLogicAdditional(TipoRetencionFuenteIvaLogicAdditional tiporetencionfuenteivaLogicAdditional) {
		try {
			this.tiporetencionfuenteivaLogicAdditional=tiporetencionfuenteivaLogicAdditional;
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
	
	
	
	
	public  TipoRetencionFuenteIvaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiporetencionfuenteivaDataAccess = new TipoRetencionFuenteIvaDataAccess();
			
			this.tiporetencionfuenteivas= new ArrayList<TipoRetencionFuenteIva>();
			this.tiporetencionfuenteiva= new TipoRetencionFuenteIva();
			
			this.tiporetencionfuenteivaObject=new Object();
			this.tiporetencionfuenteivasObject=new ArrayList<Object>();
				
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
			
			this.tiporetencionfuenteivaDataAccess.setConnexionType(this.connexionType);
			this.tiporetencionfuenteivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoRetencionFuenteIvaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiporetencionfuenteivaDataAccess = new TipoRetencionFuenteIvaDataAccess();
			this.tiporetencionfuenteivas= new ArrayList<TipoRetencionFuenteIva>();
			this.tiporetencionfuenteiva= new TipoRetencionFuenteIva();
			this.tiporetencionfuenteivaObject=new Object();
			this.tiporetencionfuenteivasObject=new ArrayList<Object>();
			
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
			
			this.tiporetencionfuenteivaDataAccess.setConnexionType(this.connexionType);
			this.tiporetencionfuenteivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoRetencionFuenteIva getTipoRetencionFuenteIva() throws Exception {	
		TipoRetencionFuenteIvaLogicAdditional.checkTipoRetencionFuenteIvaToGet(tiporetencionfuenteiva,this.datosCliente,this.arrDatoGeneral);
		TipoRetencionFuenteIvaLogicAdditional.updateTipoRetencionFuenteIvaToGet(tiporetencionfuenteiva,this.arrDatoGeneral);
		
		return tiporetencionfuenteiva;
	}
		
	public void setTipoRetencionFuenteIva(TipoRetencionFuenteIva newTipoRetencionFuenteIva) {
		this.tiporetencionfuenteiva = newTipoRetencionFuenteIva;
	}
	
	public TipoRetencionFuenteIvaDataAccess getTipoRetencionFuenteIvaDataAccess() {
		return tiporetencionfuenteivaDataAccess;
	}
	
	public void setTipoRetencionFuenteIvaDataAccess(TipoRetencionFuenteIvaDataAccess newtiporetencionfuenteivaDataAccess) {
		this.tiporetencionfuenteivaDataAccess = newtiporetencionfuenteivaDataAccess;
	}
	
	public List<TipoRetencionFuenteIva> getTipoRetencionFuenteIvas() throws Exception {		
		this.quitarTipoRetencionFuenteIvasNulos();
		
		TipoRetencionFuenteIvaLogicAdditional.checkTipoRetencionFuenteIvaToGets(tiporetencionfuenteivas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoRetencionFuenteIva tiporetencionfuenteivaLocal: tiporetencionfuenteivas ) {
			TipoRetencionFuenteIvaLogicAdditional.updateTipoRetencionFuenteIvaToGet(tiporetencionfuenteivaLocal,this.arrDatoGeneral);
		}
		
		return tiporetencionfuenteivas;
	}
	
	public void setTipoRetencionFuenteIvas(List<TipoRetencionFuenteIva> newTipoRetencionFuenteIvas) {
		this.tiporetencionfuenteivas = newTipoRetencionFuenteIvas;
	}
	
	public Object getTipoRetencionFuenteIvaObject() {	
		this.tiporetencionfuenteivaObject=this.tiporetencionfuenteivaDataAccess.getEntityObject();
		return this.tiporetencionfuenteivaObject;
	}
		
	public void setTipoRetencionFuenteIvaObject(Object newTipoRetencionFuenteIvaObject) {
		this.tiporetencionfuenteivaObject = newTipoRetencionFuenteIvaObject;
	}
	
	public List<Object> getTipoRetencionFuenteIvasObject() {		
		this.tiporetencionfuenteivasObject=this.tiporetencionfuenteivaDataAccess.getEntitiesObject();
		return this.tiporetencionfuenteivasObject;
	}
		
	public void setTipoRetencionFuenteIvasObject(List<Object> newTipoRetencionFuenteIvasObject) {
		this.tiporetencionfuenteivasObject = newTipoRetencionFuenteIvasObject;
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
		
		if(this.tiporetencionfuenteivaDataAccess!=null) {
			this.tiporetencionfuenteivaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiporetencionfuenteivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiporetencionfuenteivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporetencionfuenteiva=tiporetencionfuenteivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporetencionfuenteiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteiva);
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
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		  		  
        try {
			
			tiporetencionfuenteiva=tiporetencionfuenteivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporetencionfuenteiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporetencionfuenteiva=tiporetencionfuenteivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporetencionfuenteiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteiva);
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
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		  		  
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
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		  		  
        try {
			
			tiporetencionfuenteiva=tiporetencionfuenteivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporetencionfuenteiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		  		  
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
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiporetencionfuenteivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiporetencionfuenteivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiporetencionfuenteivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiporetencionfuenteivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiporetencionfuenteivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiporetencionfuenteivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
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
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		  		  
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
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		  		  
        try {			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		  		  
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
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
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
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		  		  
        try {
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
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
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
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
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteiva=tiporetencionfuenteivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteiva);
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
		tiporetencionfuenteiva = new  TipoRetencionFuenteIva();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteiva=tiporetencionfuenteivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
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
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		  		  
        try {
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoRetencionFuenteIvasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getTodosTipoRetencionFuenteIvasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
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
	
	public  void  getTodosTipoRetencionFuenteIvas(String sFinalQuery,Pagination pagination)throws Exception {
		tiporetencionfuenteivas = new  ArrayList<TipoRetencionFuenteIva>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRetencionFuenteIva(tiporetencionfuenteivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoRetencionFuenteIva(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		Boolean estaValidado=false;
		
		if(tiporetencionfuenteiva.getIsNew() || tiporetencionfuenteiva.getIsChanged()) { 
			this.invalidValues = tiporetencionfuenteivaValidator.getInvalidValues(tiporetencionfuenteiva);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiporetencionfuenteiva);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoRetencionFuenteIva(List<TipoRetencionFuenteIva> TipoRetencionFuenteIvas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoRetencionFuenteIva tiporetencionfuenteivaLocal:tiporetencionfuenteivas) {				
			estaValidadoObjeto=this.validarGuardarTipoRetencionFuenteIva(tiporetencionfuenteivaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoRetencionFuenteIva(List<TipoRetencionFuenteIva> TipoRetencionFuenteIvas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRetencionFuenteIva(tiporetencionfuenteivas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoRetencionFuenteIva(TipoRetencionFuenteIva TipoRetencionFuenteIva) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRetencionFuenteIva(tiporetencionfuenteiva)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiporetencionfuenteiva.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoRetencionFuenteIvaConstantesFunciones.getTipoRetencionFuenteIvaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiporetencionfuenteiva","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoRetencionFuenteIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoRetencionFuenteIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoRetencionFuenteIvaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-saveTipoRetencionFuenteIvaWithConnection");connexion.begin();			
			
			TipoRetencionFuenteIvaLogicAdditional.checkTipoRetencionFuenteIvaToSave(this.tiporetencionfuenteiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRetencionFuenteIvaLogicAdditional.updateTipoRetencionFuenteIvaToSave(this.tiporetencionfuenteiva,this.arrDatoGeneral);
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporetencionfuenteiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoRetencionFuenteIva();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRetencionFuenteIva(this.tiporetencionfuenteiva)) {
				TipoRetencionFuenteIvaDataAccess.save(this.tiporetencionfuenteiva, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiporetencionfuenteiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRetencionFuenteIvaLogicAdditional.checkTipoRetencionFuenteIvaToSaveAfter(this.tiporetencionfuenteiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRetencionFuenteIva();
			
			connexion.commit();			
			
			if(this.tiporetencionfuenteiva.getIsDeleted()) {
				this.tiporetencionfuenteiva=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoRetencionFuenteIva()throws Exception {	
		try {	
			
			TipoRetencionFuenteIvaLogicAdditional.checkTipoRetencionFuenteIvaToSave(this.tiporetencionfuenteiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRetencionFuenteIvaLogicAdditional.updateTipoRetencionFuenteIvaToSave(this.tiporetencionfuenteiva,this.arrDatoGeneral);
			
			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporetencionfuenteiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRetencionFuenteIva(this.tiporetencionfuenteiva)) {			
				TipoRetencionFuenteIvaDataAccess.save(this.tiporetencionfuenteiva, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiporetencionfuenteiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRetencionFuenteIvaLogicAdditional.checkTipoRetencionFuenteIvaToSaveAfter(this.tiporetencionfuenteiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiporetencionfuenteiva.getIsDeleted()) {
				this.tiporetencionfuenteiva=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoRetencionFuenteIvasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-saveTipoRetencionFuenteIvasWithConnection");connexion.begin();			
			
			TipoRetencionFuenteIvaLogicAdditional.checkTipoRetencionFuenteIvaToSaves(tiporetencionfuenteivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoRetencionFuenteIvas();
			
			Boolean validadoTodosTipoRetencionFuenteIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRetencionFuenteIva tiporetencionfuenteivaLocal:tiporetencionfuenteivas) {		
				if(tiporetencionfuenteivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRetencionFuenteIvaLogicAdditional.updateTipoRetencionFuenteIvaToSave(tiporetencionfuenteivaLocal,this.arrDatoGeneral);
	        	
				TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporetencionfuenteivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRetencionFuenteIva(tiporetencionfuenteivaLocal)) {
					TipoRetencionFuenteIvaDataAccess.save(tiporetencionfuenteivaLocal, connexion);				
				} else {
					validadoTodosTipoRetencionFuenteIva=false;
				}
			}
			
			if(!validadoTodosTipoRetencionFuenteIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRetencionFuenteIvaLogicAdditional.checkTipoRetencionFuenteIvaToSavesAfter(tiporetencionfuenteivas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRetencionFuenteIvas();
			
			connexion.commit();		
			
			this.quitarTipoRetencionFuenteIvasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoRetencionFuenteIvas()throws Exception {				
		 try {	
			TipoRetencionFuenteIvaLogicAdditional.checkTipoRetencionFuenteIvaToSaves(tiporetencionfuenteivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoRetencionFuenteIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRetencionFuenteIva tiporetencionfuenteivaLocal:tiporetencionfuenteivas) {				
				if(tiporetencionfuenteivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRetencionFuenteIvaLogicAdditional.updateTipoRetencionFuenteIvaToSave(tiporetencionfuenteivaLocal,this.arrDatoGeneral);
	        	
				TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporetencionfuenteivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRetencionFuenteIva(tiporetencionfuenteivaLocal)) {				
					TipoRetencionFuenteIvaDataAccess.save(tiporetencionfuenteivaLocal, connexion);				
				} else {
					validadoTodosTipoRetencionFuenteIva=false;
				}
			}
			
			if(!validadoTodosTipoRetencionFuenteIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRetencionFuenteIvaLogicAdditional.checkTipoRetencionFuenteIvaToSavesAfter(tiporetencionfuenteivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoRetencionFuenteIvasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRetencionFuenteIvaParameterReturnGeneral procesarAccionTipoRetencionFuenteIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRetencionFuenteIva> tiporetencionfuenteivas,TipoRetencionFuenteIvaParameterReturnGeneral tiporetencionfuenteivaParameterGeneral)throws Exception {
		 try {	
			TipoRetencionFuenteIvaParameterReturnGeneral tiporetencionfuenteivaReturnGeneral=new TipoRetencionFuenteIvaParameterReturnGeneral();
	
			TipoRetencionFuenteIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporetencionfuenteivas,tiporetencionfuenteivaParameterGeneral,tiporetencionfuenteivaReturnGeneral);
			
			return tiporetencionfuenteivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRetencionFuenteIvaParameterReturnGeneral procesarAccionTipoRetencionFuenteIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRetencionFuenteIva> tiporetencionfuenteivas,TipoRetencionFuenteIvaParameterReturnGeneral tiporetencionfuenteivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-procesarAccionTipoRetencionFuenteIvasWithConnection");connexion.begin();			
			
			TipoRetencionFuenteIvaParameterReturnGeneral tiporetencionfuenteivaReturnGeneral=new TipoRetencionFuenteIvaParameterReturnGeneral();
	
			TipoRetencionFuenteIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporetencionfuenteivas,tiporetencionfuenteivaParameterGeneral,tiporetencionfuenteivaReturnGeneral);
			
			this.connexion.commit();
			
			return tiporetencionfuenteivaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRetencionFuenteIvaParameterReturnGeneral procesarEventosTipoRetencionFuenteIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRetencionFuenteIva> tiporetencionfuenteivas,TipoRetencionFuenteIva tiporetencionfuenteiva,TipoRetencionFuenteIvaParameterReturnGeneral tiporetencionfuenteivaParameterGeneral,Boolean isEsNuevoTipoRetencionFuenteIva,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoRetencionFuenteIvaParameterReturnGeneral tiporetencionfuenteivaReturnGeneral=new TipoRetencionFuenteIvaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporetencionfuenteivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRetencionFuenteIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporetencionfuenteivas,tiporetencionfuenteiva,tiporetencionfuenteivaParameterGeneral,tiporetencionfuenteivaReturnGeneral,isEsNuevoTipoRetencionFuenteIva,clases);
			
			return tiporetencionfuenteivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoRetencionFuenteIvaParameterReturnGeneral procesarEventosTipoRetencionFuenteIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRetencionFuenteIva> tiporetencionfuenteivas,TipoRetencionFuenteIva tiporetencionfuenteiva,TipoRetencionFuenteIvaParameterReturnGeneral tiporetencionfuenteivaParameterGeneral,Boolean isEsNuevoTipoRetencionFuenteIva,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-procesarEventosTipoRetencionFuenteIvasWithConnection");connexion.begin();			
			
			TipoRetencionFuenteIvaParameterReturnGeneral tiporetencionfuenteivaReturnGeneral=new TipoRetencionFuenteIvaParameterReturnGeneral();
	
			tiporetencionfuenteivaReturnGeneral.setTipoRetencionFuenteIva(tiporetencionfuenteiva);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporetencionfuenteivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRetencionFuenteIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporetencionfuenteivas,tiporetencionfuenteiva,tiporetencionfuenteivaParameterGeneral,tiporetencionfuenteivaReturnGeneral,isEsNuevoTipoRetencionFuenteIva,clases);
			
			this.connexion.commit();
			
			return tiporetencionfuenteivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRetencionFuenteIvaParameterReturnGeneral procesarImportacionTipoRetencionFuenteIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoRetencionFuenteIvaParameterReturnGeneral tiporetencionfuenteivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-procesarImportacionTipoRetencionFuenteIvasWithConnection");connexion.begin();			
			
			TipoRetencionFuenteIvaParameterReturnGeneral tiporetencionfuenteivaReturnGeneral=new TipoRetencionFuenteIvaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiporetencionfuenteivas=new ArrayList<TipoRetencionFuenteIva>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiporetencionfuenteiva=new TipoRetencionFuenteIva();
				
				
				if(conColumnasBase) {this.tiporetencionfuenteiva.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiporetencionfuenteiva.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiporetencionfuenteiva.setcodigo(arrColumnas[iColumn++]);
				this.tiporetencionfuenteiva.setnombre(arrColumnas[iColumn++]);
				this.tiporetencionfuenteiva.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.tiporetencionfuenteiva.setmonto_minimo(Double.parseDouble(arrColumnas[iColumn++]));
				this.tiporetencionfuenteiva.setes_retencion_iva(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tiporetencionfuenteiva.setes_debito(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tiporetencionfuenteiva.setes_con_iva_factura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tiporetencionfuenteiva.setes_con_sub_total_factura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tiporetencionfuenteiva.setes_con_secuencial(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tiporetencionfuenteivas.add(this.tiporetencionfuenteiva);
			}
			
			this.saveTipoRetencionFuenteIvas();
			
			this.connexion.commit();
			
			tiporetencionfuenteivaReturnGeneral.setConRetornoEstaProcesado(true);
			tiporetencionfuenteivaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiporetencionfuenteivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoRetencionFuenteIvasEliminados() throws Exception {				
		
		List<TipoRetencionFuenteIva> tiporetencionfuenteivasAux= new ArrayList<TipoRetencionFuenteIva>();
		
		for(TipoRetencionFuenteIva tiporetencionfuenteiva:tiporetencionfuenteivas) {
			if(!tiporetencionfuenteiva.getIsDeleted()) {
				tiporetencionfuenteivasAux.add(tiporetencionfuenteiva);
			}
		}
		
		tiporetencionfuenteivas=tiporetencionfuenteivasAux;
	}
	
	public void quitarTipoRetencionFuenteIvasNulos() throws Exception {				
		
		List<TipoRetencionFuenteIva> tiporetencionfuenteivasAux= new ArrayList<TipoRetencionFuenteIva>();
		
		for(TipoRetencionFuenteIva tiporetencionfuenteiva : this.tiporetencionfuenteivas) {
			if(tiporetencionfuenteiva==null) {
				tiporetencionfuenteivasAux.add(tiporetencionfuenteiva);
			}
		}
		
		//this.tiporetencionfuenteivas=tiporetencionfuenteivasAux;
		
		this.tiporetencionfuenteivas.removeAll(tiporetencionfuenteivasAux);
	}
	
	public void getSetVersionRowTipoRetencionFuenteIvaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiporetencionfuenteiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiporetencionfuenteiva.getIsDeleted() || (tiporetencionfuenteiva.getIsChanged()&&!tiporetencionfuenteiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiporetencionfuenteivaDataAccess.getSetVersionRowTipoRetencionFuenteIva(connexion,tiporetencionfuenteiva.getId());
				
				if(!tiporetencionfuenteiva.getVersionRow().equals(timestamp)) {	
					tiporetencionfuenteiva.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiporetencionfuenteiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoRetencionFuenteIva()throws Exception {	
		
		if(tiporetencionfuenteiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiporetencionfuenteiva.getIsDeleted() || (tiporetencionfuenteiva.getIsChanged()&&!tiporetencionfuenteiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiporetencionfuenteivaDataAccess.getSetVersionRowTipoRetencionFuenteIva(connexion,tiporetencionfuenteiva.getId());
			
			try {							
				if(!tiporetencionfuenteiva.getVersionRow().equals(timestamp)) {	
					tiporetencionfuenteiva.setVersionRow(timestamp);
				}
				
				tiporetencionfuenteiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoRetencionFuenteIvasWithConnection()throws Exception {	
		if(tiporetencionfuenteivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoRetencionFuenteIva tiporetencionfuenteivaAux:tiporetencionfuenteivas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiporetencionfuenteivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporetencionfuenteivaAux.getIsDeleted() || (tiporetencionfuenteivaAux.getIsChanged()&&!tiporetencionfuenteivaAux.getIsNew())) {
						
						timestamp=tiporetencionfuenteivaDataAccess.getSetVersionRowTipoRetencionFuenteIva(connexion,tiporetencionfuenteivaAux.getId());
						
						if(!tiporetencionfuenteiva.getVersionRow().equals(timestamp)) {	
							tiporetencionfuenteivaAux.setVersionRow(timestamp);
						}
								
						tiporetencionfuenteivaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoRetencionFuenteIvas()throws Exception {	
		if(tiporetencionfuenteivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoRetencionFuenteIva tiporetencionfuenteivaAux:tiporetencionfuenteivas) {
					if(tiporetencionfuenteivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporetencionfuenteivaAux.getIsDeleted() || (tiporetencionfuenteivaAux.getIsChanged()&&!tiporetencionfuenteivaAux.getIsNew())) {
						
						timestamp=tiporetencionfuenteivaDataAccess.getSetVersionRowTipoRetencionFuenteIva(connexion,tiporetencionfuenteivaAux.getId());
						
						if(!tiporetencionfuenteivaAux.getVersionRow().equals(timestamp)) {	
							tiporetencionfuenteivaAux.setVersionRow(timestamp);
						}
						
													
						tiporetencionfuenteivaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoRetencionFuenteIvaParameterReturnGeneral cargarCombosLoteForeignKeyTipoRetencionFuenteIvaWithConnection(String finalQueryGlobalPais,String finalQueryGlobalCuentaContable,String finalQueryGlobalCuentaContableCredito) throws Exception {
		TipoRetencionFuenteIvaParameterReturnGeneral  tiporetencionfuenteivaReturnGeneral =new TipoRetencionFuenteIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoRetencionFuenteIvaWithConnection");connexion.begin();
			
			tiporetencionfuenteivaReturnGeneral =new TipoRetencionFuenteIvaParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tiporetencionfuenteivaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			tiporetencionfuenteivaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			tiporetencionfuenteivaReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tiporetencionfuenteivaReturnGeneral;
	}
	
	public TipoRetencionFuenteIvaParameterReturnGeneral cargarCombosLoteForeignKeyTipoRetencionFuenteIva(String finalQueryGlobalPais,String finalQueryGlobalCuentaContable,String finalQueryGlobalCuentaContableCredito) throws Exception {
		TipoRetencionFuenteIvaParameterReturnGeneral  tiporetencionfuenteivaReturnGeneral =new TipoRetencionFuenteIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tiporetencionfuenteivaReturnGeneral =new TipoRetencionFuenteIvaParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tiporetencionfuenteivaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			tiporetencionfuenteivaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			tiporetencionfuenteivaReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tiporetencionfuenteivaReturnGeneral;
	}
	
	
	public void deepLoad(TipoRetencionFuenteIva tiporetencionfuenteiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoRetencionFuenteIvaLogicAdditional.updateTipoRetencionFuenteIvaToGet(tiporetencionfuenteiva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporetencionfuenteiva.setPais(tiporetencionfuenteivaDataAccess.getPais(connexion,tiporetencionfuenteiva));
		tiporetencionfuenteiva.setCuentaContable(tiporetencionfuenteivaDataAccess.getCuentaContable(connexion,tiporetencionfuenteiva));
		tiporetencionfuenteiva.setCuentaContableCredito(tiporetencionfuenteivaDataAccess.getCuentaContableCredito(connexion,tiporetencionfuenteiva));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tiporetencionfuenteiva.setPais(tiporetencionfuenteivaDataAccess.getPais(connexion,tiporetencionfuenteiva));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tiporetencionfuenteiva.setCuentaContable(tiporetencionfuenteivaDataAccess.getCuentaContable(connexion,tiporetencionfuenteiva));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tiporetencionfuenteiva.setCuentaContableCredito(tiporetencionfuenteivaDataAccess.getCuentaContableCredito(connexion,tiporetencionfuenteiva));
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
			tiporetencionfuenteiva.setPais(tiporetencionfuenteivaDataAccess.getPais(connexion,tiporetencionfuenteiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tiporetencionfuenteiva.setCuentaContable(tiporetencionfuenteivaDataAccess.getCuentaContable(connexion,tiporetencionfuenteiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tiporetencionfuenteiva.setCuentaContableCredito(tiporetencionfuenteivaDataAccess.getCuentaContableCredito(connexion,tiporetencionfuenteiva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporetencionfuenteiva.setPais(tiporetencionfuenteivaDataAccess.getPais(connexion,tiporetencionfuenteiva));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tiporetencionfuenteiva.getPais(),isDeep,deepLoadType,clases);
				
		tiporetencionfuenteiva.setCuentaContable(tiporetencionfuenteivaDataAccess.getCuentaContable(connexion,tiporetencionfuenteiva));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(tiporetencionfuenteiva.getCuentaContable(),isDeep,deepLoadType,clases);
				
		tiporetencionfuenteiva.setCuentaContableCredito(tiporetencionfuenteivaDataAccess.getCuentaContableCredito(connexion,tiporetencionfuenteiva));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(tiporetencionfuenteiva.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tiporetencionfuenteiva.setPais(tiporetencionfuenteivaDataAccess.getPais(connexion,tiporetencionfuenteiva));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(tiporetencionfuenteiva.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tiporetencionfuenteiva.setCuentaContable(tiporetencionfuenteivaDataAccess.getCuentaContable(connexion,tiporetencionfuenteiva));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tiporetencionfuenteiva.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tiporetencionfuenteiva.setCuentaContableCredito(tiporetencionfuenteivaDataAccess.getCuentaContableCredito(connexion,tiporetencionfuenteiva));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tiporetencionfuenteiva.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			tiporetencionfuenteiva.setPais(tiporetencionfuenteivaDataAccess.getPais(connexion,tiporetencionfuenteiva));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(tiporetencionfuenteiva.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tiporetencionfuenteiva.setCuentaContable(tiporetencionfuenteivaDataAccess.getCuentaContable(connexion,tiporetencionfuenteiva));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tiporetencionfuenteiva.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tiporetencionfuenteiva.setCuentaContableCredito(tiporetencionfuenteivaDataAccess.getCuentaContableCredito(connexion,tiporetencionfuenteiva));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tiporetencionfuenteiva.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoRetencionFuenteIva tiporetencionfuenteiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoRetencionFuenteIvaLogicAdditional.updateTipoRetencionFuenteIvaToSave(tiporetencionfuenteiva,this.arrDatoGeneral);
			
TipoRetencionFuenteIvaDataAccess.save(tiporetencionfuenteiva, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(tiporetencionfuenteiva.getPais(),connexion);

		CuentaContableDataAccess.save(tiporetencionfuenteiva.getCuentaContable(),connexion);

		CuentaContableDataAccess.save(tiporetencionfuenteiva.getCuentaContableCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(tiporetencionfuenteiva.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tiporetencionfuenteiva.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tiporetencionfuenteiva.getCuentaContableCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(tiporetencionfuenteiva.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tiporetencionfuenteiva.getPais(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tiporetencionfuenteiva.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(tiporetencionfuenteiva.getCuentaContable(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tiporetencionfuenteiva.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(tiporetencionfuenteiva.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(tiporetencionfuenteiva.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(tiporetencionfuenteiva.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tiporetencionfuenteiva.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tiporetencionfuenteiva.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tiporetencionfuenteiva.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tiporetencionfuenteiva.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoRetencionFuenteIva.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiporetencionfuenteiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(tiporetencionfuenteiva);
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
			this.deepLoad(this.tiporetencionfuenteiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRetencionFuenteIva.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiporetencionfuenteivas!=null) {
				for(TipoRetencionFuenteIva tiporetencionfuenteiva:tiporetencionfuenteivas) {
					this.deepLoad(tiporetencionfuenteiva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(tiporetencionfuenteivas);
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
			if(tiporetencionfuenteivas!=null) {
				for(TipoRetencionFuenteIva tiporetencionfuenteiva:tiporetencionfuenteivas) {
					this.deepLoad(tiporetencionfuenteiva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(tiporetencionfuenteivas);
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
			this.getNewConnexionToDeep(TipoRetencionFuenteIva.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiporetencionfuenteiva,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoRetencionFuenteIva.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiporetencionfuenteivas!=null) {
				for(TipoRetencionFuenteIva tiporetencionfuenteiva:tiporetencionfuenteivas) {
					this.deepSave(tiporetencionfuenteiva,isDeep,deepLoadType,clases);
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
			if(tiporetencionfuenteivas!=null) {
				for(TipoRetencionFuenteIva tiporetencionfuenteiva:tiporetencionfuenteivas) {
					this.deepSave(tiporetencionfuenteiva,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoRetencionFuenteIvasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoRetencionFuenteIvaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRetencionFuenteIvasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoRetencionFuenteIvaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoRetencionFuenteIvasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoRetencionFuenteIvaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRetencionFuenteIvasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoRetencionFuenteIvaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoRetencionFuenteIvasFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRetencionFuenteIvasFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoRetencionFuenteIvasFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRetencionFuenteIvasFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoRetencionFuenteIvasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionFuenteIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoRetencionFuenteIvaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRetencionFuenteIvasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoRetencionFuenteIvaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoRetencionFuenteIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporetencionfuenteivas=tiporetencionfuenteivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRetencionFuenteIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(this.tiporetencionfuenteivas);
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
			if(TipoRetencionFuenteIvaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRetencionFuenteIvaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoRetencionFuenteIva tiporetencionfuenteiva,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRetencionFuenteIvaConstantesFunciones.ISCONAUDITORIA) {
				if(tiporetencionfuenteiva.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRetencionFuenteIvaDataAccess.TABLENAME, tiporetencionfuenteiva.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRetencionFuenteIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRetencionFuenteIvaLogic.registrarAuditoriaDetallesTipoRetencionFuenteIva(connexion,tiporetencionfuenteiva,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiporetencionfuenteiva.getIsDeleted()) {
					/*if(!tiporetencionfuenteiva.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoRetencionFuenteIvaDataAccess.TABLENAME, tiporetencionfuenteiva.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoRetencionFuenteIvaLogic.registrarAuditoriaDetallesTipoRetencionFuenteIva(connexion,tiporetencionfuenteiva,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRetencionFuenteIvaDataAccess.TABLENAME, tiporetencionfuenteiva.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiporetencionfuenteiva.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRetencionFuenteIvaDataAccess.TABLENAME, tiporetencionfuenteiva.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRetencionFuenteIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRetencionFuenteIvaLogic.registrarAuditoriaDetallesTipoRetencionFuenteIva(connexion,tiporetencionfuenteiva,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoRetencionFuenteIva(Connexion connexion,TipoRetencionFuenteIva tiporetencionfuenteiva)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getid_pais().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getid_pais()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getid_pais().toString();
				}
				if(tiporetencionfuenteiva.getid_pais()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getcodigo().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getcodigo()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getcodigo();
				}
				if(tiporetencionfuenteiva.getcodigo()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getnombre().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getnombre()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getnombre();
				}
				if(tiporetencionfuenteiva.getnombre()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getporcentaje().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getporcentaje()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getporcentaje().toString();
				}
				if(tiporetencionfuenteiva.getporcentaje()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getmonto_minimo().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getmonto_minimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getmonto_minimo()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getmonto_minimo().toString();
				}
				if(tiporetencionfuenteiva.getmonto_minimo()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getmonto_minimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getid_cuenta_contable().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getid_cuenta_contable().toString();
				}
				if(tiporetencionfuenteiva.getid_cuenta_contable()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getid_cuenta_contable_credito().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getid_cuenta_contable_credito().toString();
				}
				if(tiporetencionfuenteiva.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getes_retencion_iva().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_retencion_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_retencion_iva()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_retencion_iva().toString();
				}
				if(tiporetencionfuenteiva.getes_retencion_iva()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getes_retencion_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.ESRETENCIONIVA,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getes_debito().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_debito()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_debito().toString();
				}
				if(tiporetencionfuenteiva.getes_debito()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getes_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.ESDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getes_con_iva_factura().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_con_iva_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_con_iva_factura()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_con_iva_factura().toString();
				}
				if(tiporetencionfuenteiva.getes_con_iva_factura()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getes_con_iva_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.ESCONIVAFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getes_con_sub_total_factura().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_con_sub_total_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_con_sub_total_factura()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_con_sub_total_factura().toString();
				}
				if(tiporetencionfuenteiva.getes_con_sub_total_factura()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getes_con_sub_total_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.ESCONSUBTOTALFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencionfuenteiva.getIsNew()||!tiporetencionfuenteiva.getes_con_secuencial().equals(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_con_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_con_secuencial()!=null)
				{
					strValorActual=tiporetencionfuenteiva.getTipoRetencionFuenteIvaOriginal().getes_con_secuencial().toString();
				}
				if(tiporetencionfuenteiva.getes_con_secuencial()!=null)
				{
					strValorNuevo=tiporetencionfuenteiva.getes_con_secuencial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionFuenteIvaConstantesFunciones.ESCONSECUENCIAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoRetencionFuenteIvaRelacionesWithConnection(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {

		if(!tiporetencionfuenteiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRetencionFuenteIvaRelacionesBase(tiporetencionfuenteiva,true);
		}
	}

	public void saveTipoRetencionFuenteIvaRelaciones(TipoRetencionFuenteIva tiporetencionfuenteiva)throws Exception {

		if(!tiporetencionfuenteiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRetencionFuenteIvaRelacionesBase(tiporetencionfuenteiva,false);
		}
	}

	public void saveTipoRetencionFuenteIvaRelacionesBase(TipoRetencionFuenteIva tiporetencionfuenteiva,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoRetencionFuenteIva-saveRelacionesWithConnection");}
	

			this.setTipoRetencionFuenteIva(tiporetencionfuenteiva);

				if((tiporetencionfuenteiva.getIsNew()||tiporetencionfuenteiva.getIsChanged())&&!tiporetencionfuenteiva.getIsDeleted()) {
					this.saveTipoRetencionFuenteIva();
					this.saveTipoRetencionFuenteIvaRelacionesDetalles();

				} else if(tiporetencionfuenteiva.getIsDeleted()) {
					this.saveTipoRetencionFuenteIvaRelacionesDetalles();
					this.saveTipoRetencionFuenteIva();
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
	
	
	private void saveTipoRetencionFuenteIvaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRetencionFuenteIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRetencionFuenteIvaConstantesFunciones.getClassesForeignKeysOfTipoRetencionFuenteIva(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRetencionFuenteIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRetencionFuenteIvaConstantesFunciones.getClassesRelationshipsOfTipoRetencionFuenteIva(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

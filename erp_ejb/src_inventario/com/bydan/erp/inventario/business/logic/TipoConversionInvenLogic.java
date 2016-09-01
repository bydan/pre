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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.TipoConversionInvenConstantesFunciones;
import com.bydan.erp.inventario.util.TipoConversionInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoConversionInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoConversionInven;
import com.bydan.erp.inventario.business.logic.TipoConversionInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoConversionInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoConversionInvenLogic.class);
	
	protected TipoConversionInvenDataAccess tipoconversioninvenDataAccess; 	
	protected TipoConversionInven tipoconversioninven;
	protected List<TipoConversionInven> tipoconversioninvens;
	protected Object tipoconversioninvenObject;	
	protected List<Object> tipoconversioninvensObject;
	
	public static ClassValidator<TipoConversionInven> tipoconversioninvenValidator = new ClassValidator<TipoConversionInven>(TipoConversionInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoConversionInvenLogicAdditional tipoconversioninvenLogicAdditional=null;
	
	public TipoConversionInvenLogicAdditional getTipoConversionInvenLogicAdditional() {
		return this.tipoconversioninvenLogicAdditional;
	}
	
	public void setTipoConversionInvenLogicAdditional(TipoConversionInvenLogicAdditional tipoconversioninvenLogicAdditional) {
		try {
			this.tipoconversioninvenLogicAdditional=tipoconversioninvenLogicAdditional;
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
	
	
	
	
	public  TipoConversionInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoconversioninvenDataAccess = new TipoConversionInvenDataAccess();
			
			this.tipoconversioninvens= new ArrayList<TipoConversionInven>();
			this.tipoconversioninven= new TipoConversionInven();
			
			this.tipoconversioninvenObject=new Object();
			this.tipoconversioninvensObject=new ArrayList<Object>();
				
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
			
			this.tipoconversioninvenDataAccess.setConnexionType(this.connexionType);
			this.tipoconversioninvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoConversionInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoconversioninvenDataAccess = new TipoConversionInvenDataAccess();
			this.tipoconversioninvens= new ArrayList<TipoConversionInven>();
			this.tipoconversioninven= new TipoConversionInven();
			this.tipoconversioninvenObject=new Object();
			this.tipoconversioninvensObject=new ArrayList<Object>();
			
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
			
			this.tipoconversioninvenDataAccess.setConnexionType(this.connexionType);
			this.tipoconversioninvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoConversionInven getTipoConversionInven() throws Exception {	
		TipoConversionInvenLogicAdditional.checkTipoConversionInvenToGet(tipoconversioninven,this.datosCliente,this.arrDatoGeneral);
		TipoConversionInvenLogicAdditional.updateTipoConversionInvenToGet(tipoconversioninven,this.arrDatoGeneral);
		
		return tipoconversioninven;
	}
		
	public void setTipoConversionInven(TipoConversionInven newTipoConversionInven) {
		this.tipoconversioninven = newTipoConversionInven;
	}
	
	public TipoConversionInvenDataAccess getTipoConversionInvenDataAccess() {
		return tipoconversioninvenDataAccess;
	}
	
	public void setTipoConversionInvenDataAccess(TipoConversionInvenDataAccess newtipoconversioninvenDataAccess) {
		this.tipoconversioninvenDataAccess = newtipoconversioninvenDataAccess;
	}
	
	public List<TipoConversionInven> getTipoConversionInvens() throws Exception {		
		this.quitarTipoConversionInvensNulos();
		
		TipoConversionInvenLogicAdditional.checkTipoConversionInvenToGets(tipoconversioninvens,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoConversionInven tipoconversioninvenLocal: tipoconversioninvens ) {
			TipoConversionInvenLogicAdditional.updateTipoConversionInvenToGet(tipoconversioninvenLocal,this.arrDatoGeneral);
		}
		
		return tipoconversioninvens;
	}
	
	public void setTipoConversionInvens(List<TipoConversionInven> newTipoConversionInvens) {
		this.tipoconversioninvens = newTipoConversionInvens;
	}
	
	public Object getTipoConversionInvenObject() {	
		this.tipoconversioninvenObject=this.tipoconversioninvenDataAccess.getEntityObject();
		return this.tipoconversioninvenObject;
	}
		
	public void setTipoConversionInvenObject(Object newTipoConversionInvenObject) {
		this.tipoconversioninvenObject = newTipoConversionInvenObject;
	}
	
	public List<Object> getTipoConversionInvensObject() {		
		this.tipoconversioninvensObject=this.tipoconversioninvenDataAccess.getEntitiesObject();
		return this.tipoconversioninvensObject;
	}
		
	public void setTipoConversionInvensObject(List<Object> newTipoConversionInvensObject) {
		this.tipoconversioninvensObject = newTipoConversionInvensObject;
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
		
		if(this.tipoconversioninvenDataAccess!=null) {
			this.tipoconversioninvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoconversioninvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoconversioninvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoconversioninven = new  TipoConversionInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoconversioninven=tipoconversioninvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninven);
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
		tipoconversioninven = new  TipoConversionInven();
		  		  
        try {
			
			tipoconversioninven=tipoconversioninvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoconversioninven = new  TipoConversionInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoconversioninven=tipoconversioninvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninven);
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
		tipoconversioninven = new  TipoConversionInven();
		  		  
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
		tipoconversioninven = new  TipoConversionInven();
		  		  
        try {
			
			tipoconversioninven=tipoconversioninvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoconversioninven = new  TipoConversionInven();
		  		  
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
		tipoconversioninven = new  TipoConversionInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoconversioninvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoconversioninven = new  TipoConversionInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoconversioninvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoconversioninven = new  TipoConversionInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoconversioninvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoconversioninven = new  TipoConversionInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoconversioninvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoconversioninven = new  TipoConversionInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoconversioninvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoconversioninven = new  TipoConversionInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoconversioninvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
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
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		  		  
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
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		  		  
        try {			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoConversionInven(tipoconversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		  		  
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
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
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
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		  		  
        try {
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
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
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
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
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoconversioninven = new  TipoConversionInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninven=tipoconversioninvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninven);
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
		tipoconversioninven = new  TipoConversionInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninven=tipoconversioninvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninvens=tipoconversioninvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
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
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		  		  
        try {
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninvens=tipoconversioninvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoConversionInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getTodosTipoConversionInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
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
	
	public  void  getTodosTipoConversionInvens(String sFinalQuery,Pagination pagination)throws Exception {
		tipoconversioninvens = new  ArrayList<TipoConversionInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoConversionInven(tipoconversioninvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoConversionInven(TipoConversionInven tipoconversioninven) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoconversioninven.getIsNew() || tipoconversioninven.getIsChanged()) { 
			this.invalidValues = tipoconversioninvenValidator.getInvalidValues(tipoconversioninven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoconversioninven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoConversionInven(List<TipoConversionInven> TipoConversionInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoConversionInven tipoconversioninvenLocal:tipoconversioninvens) {				
			estaValidadoObjeto=this.validarGuardarTipoConversionInven(tipoconversioninvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoConversionInven(List<TipoConversionInven> TipoConversionInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoConversionInven(tipoconversioninvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoConversionInven(TipoConversionInven TipoConversionInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoConversionInven(tipoconversioninven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoConversionInven tipoconversioninven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoconversioninven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoConversionInvenConstantesFunciones.getTipoConversionInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoconversioninven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoConversionInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoConversionInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoConversionInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-saveTipoConversionInvenWithConnection");connexion.begin();			
			
			TipoConversionInvenLogicAdditional.checkTipoConversionInvenToSave(this.tipoconversioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoConversionInvenLogicAdditional.updateTipoConversionInvenToSave(this.tipoconversioninven,this.arrDatoGeneral);
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoconversioninven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoConversionInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoConversionInven(this.tipoconversioninven)) {
				TipoConversionInvenDataAccess.save(this.tipoconversioninven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoconversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoConversionInvenLogicAdditional.checkTipoConversionInvenToSaveAfter(this.tipoconversioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoConversionInven();
			
			connexion.commit();			
			
			if(this.tipoconversioninven.getIsDeleted()) {
				this.tipoconversioninven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoConversionInven()throws Exception {	
		try {	
			
			TipoConversionInvenLogicAdditional.checkTipoConversionInvenToSave(this.tipoconversioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoConversionInvenLogicAdditional.updateTipoConversionInvenToSave(this.tipoconversioninven,this.arrDatoGeneral);
			
			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoconversioninven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoConversionInven(this.tipoconversioninven)) {			
				TipoConversionInvenDataAccess.save(this.tipoconversioninven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoconversioninven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoConversionInvenLogicAdditional.checkTipoConversionInvenToSaveAfter(this.tipoconversioninven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoconversioninven.getIsDeleted()) {
				this.tipoconversioninven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoConversionInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-saveTipoConversionInvensWithConnection");connexion.begin();			
			
			TipoConversionInvenLogicAdditional.checkTipoConversionInvenToSaves(tipoconversioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoConversionInvens();
			
			Boolean validadoTodosTipoConversionInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoConversionInven tipoconversioninvenLocal:tipoconversioninvens) {		
				if(tipoconversioninvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoConversionInvenLogicAdditional.updateTipoConversionInvenToSave(tipoconversioninvenLocal,this.arrDatoGeneral);
	        	
				TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoconversioninvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoConversionInven(tipoconversioninvenLocal)) {
					TipoConversionInvenDataAccess.save(tipoconversioninvenLocal, connexion);				
				} else {
					validadoTodosTipoConversionInven=false;
				}
			}
			
			if(!validadoTodosTipoConversionInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoConversionInvenLogicAdditional.checkTipoConversionInvenToSavesAfter(tipoconversioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoConversionInvens();
			
			connexion.commit();		
			
			this.quitarTipoConversionInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoConversionInvens()throws Exception {				
		 try {	
			TipoConversionInvenLogicAdditional.checkTipoConversionInvenToSaves(tipoconversioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoConversionInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoConversionInven tipoconversioninvenLocal:tipoconversioninvens) {				
				if(tipoconversioninvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoConversionInvenLogicAdditional.updateTipoConversionInvenToSave(tipoconversioninvenLocal,this.arrDatoGeneral);
	        	
				TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoconversioninvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoConversionInven(tipoconversioninvenLocal)) {				
					TipoConversionInvenDataAccess.save(tipoconversioninvenLocal, connexion);				
				} else {
					validadoTodosTipoConversionInven=false;
				}
			}
			
			if(!validadoTodosTipoConversionInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoConversionInvenLogicAdditional.checkTipoConversionInvenToSavesAfter(tipoconversioninvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoConversionInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoConversionInvenParameterReturnGeneral procesarAccionTipoConversionInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoConversionInven> tipoconversioninvens,TipoConversionInvenParameterReturnGeneral tipoconversioninvenParameterGeneral)throws Exception {
		 try {	
			TipoConversionInvenParameterReturnGeneral tipoconversioninvenReturnGeneral=new TipoConversionInvenParameterReturnGeneral();
	
			TipoConversionInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoconversioninvens,tipoconversioninvenParameterGeneral,tipoconversioninvenReturnGeneral);
			
			return tipoconversioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoConversionInvenParameterReturnGeneral procesarAccionTipoConversionInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoConversionInven> tipoconversioninvens,TipoConversionInvenParameterReturnGeneral tipoconversioninvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-procesarAccionTipoConversionInvensWithConnection");connexion.begin();			
			
			TipoConversionInvenParameterReturnGeneral tipoconversioninvenReturnGeneral=new TipoConversionInvenParameterReturnGeneral();
	
			TipoConversionInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoconversioninvens,tipoconversioninvenParameterGeneral,tipoconversioninvenReturnGeneral);
			
			this.connexion.commit();
			
			return tipoconversioninvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoConversionInvenParameterReturnGeneral procesarEventosTipoConversionInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoConversionInven> tipoconversioninvens,TipoConversionInven tipoconversioninven,TipoConversionInvenParameterReturnGeneral tipoconversioninvenParameterGeneral,Boolean isEsNuevoTipoConversionInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoConversionInvenParameterReturnGeneral tipoconversioninvenReturnGeneral=new TipoConversionInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoconversioninvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoConversionInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoconversioninvens,tipoconversioninven,tipoconversioninvenParameterGeneral,tipoconversioninvenReturnGeneral,isEsNuevoTipoConversionInven,clases);
			
			return tipoconversioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoConversionInvenParameterReturnGeneral procesarEventosTipoConversionInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoConversionInven> tipoconversioninvens,TipoConversionInven tipoconversioninven,TipoConversionInvenParameterReturnGeneral tipoconversioninvenParameterGeneral,Boolean isEsNuevoTipoConversionInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-procesarEventosTipoConversionInvensWithConnection");connexion.begin();			
			
			TipoConversionInvenParameterReturnGeneral tipoconversioninvenReturnGeneral=new TipoConversionInvenParameterReturnGeneral();
	
			tipoconversioninvenReturnGeneral.setTipoConversionInven(tipoconversioninven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoconversioninvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoConversionInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoconversioninvens,tipoconversioninven,tipoconversioninvenParameterGeneral,tipoconversioninvenReturnGeneral,isEsNuevoTipoConversionInven,clases);
			
			this.connexion.commit();
			
			return tipoconversioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoConversionInvenParameterReturnGeneral procesarImportacionTipoConversionInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoConversionInvenParameterReturnGeneral tipoconversioninvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-procesarImportacionTipoConversionInvensWithConnection");connexion.begin();			
			
			TipoConversionInvenParameterReturnGeneral tipoconversioninvenReturnGeneral=new TipoConversionInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoconversioninvens=new ArrayList<TipoConversionInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoconversioninven=new TipoConversionInven();
				
				
				if(conColumnasBase) {this.tipoconversioninven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoconversioninven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoconversioninven.setcodigo(arrColumnas[iColumn++]);
				this.tipoconversioninven.setnombre(arrColumnas[iColumn++]);
				
				this.tipoconversioninvens.add(this.tipoconversioninven);
			}
			
			this.saveTipoConversionInvens();
			
			this.connexion.commit();
			
			tipoconversioninvenReturnGeneral.setConRetornoEstaProcesado(true);
			tipoconversioninvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoconversioninvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoConversionInvensEliminados() throws Exception {				
		
		List<TipoConversionInven> tipoconversioninvensAux= new ArrayList<TipoConversionInven>();
		
		for(TipoConversionInven tipoconversioninven:tipoconversioninvens) {
			if(!tipoconversioninven.getIsDeleted()) {
				tipoconversioninvensAux.add(tipoconversioninven);
			}
		}
		
		tipoconversioninvens=tipoconversioninvensAux;
	}
	
	public void quitarTipoConversionInvensNulos() throws Exception {				
		
		List<TipoConversionInven> tipoconversioninvensAux= new ArrayList<TipoConversionInven>();
		
		for(TipoConversionInven tipoconversioninven : this.tipoconversioninvens) {
			if(tipoconversioninven==null) {
				tipoconversioninvensAux.add(tipoconversioninven);
			}
		}
		
		//this.tipoconversioninvens=tipoconversioninvensAux;
		
		this.tipoconversioninvens.removeAll(tipoconversioninvensAux);
	}
	
	public void getSetVersionRowTipoConversionInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoconversioninven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoconversioninven.getIsDeleted() || (tipoconversioninven.getIsChanged()&&!tipoconversioninven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoconversioninvenDataAccess.getSetVersionRowTipoConversionInven(connexion,tipoconversioninven.getId());
				
				if(!tipoconversioninven.getVersionRow().equals(timestamp)) {	
					tipoconversioninven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoconversioninven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoConversionInven()throws Exception {	
		
		if(tipoconversioninven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoconversioninven.getIsDeleted() || (tipoconversioninven.getIsChanged()&&!tipoconversioninven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoconversioninvenDataAccess.getSetVersionRowTipoConversionInven(connexion,tipoconversioninven.getId());
			
			try {							
				if(!tipoconversioninven.getVersionRow().equals(timestamp)) {	
					tipoconversioninven.setVersionRow(timestamp);
				}
				
				tipoconversioninven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoConversionInvensWithConnection()throws Exception {	
		if(tipoconversioninvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoConversionInven tipoconversioninvenAux:tipoconversioninvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoconversioninvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoconversioninvenAux.getIsDeleted() || (tipoconversioninvenAux.getIsChanged()&&!tipoconversioninvenAux.getIsNew())) {
						
						timestamp=tipoconversioninvenDataAccess.getSetVersionRowTipoConversionInven(connexion,tipoconversioninvenAux.getId());
						
						if(!tipoconversioninven.getVersionRow().equals(timestamp)) {	
							tipoconversioninvenAux.setVersionRow(timestamp);
						}
								
						tipoconversioninvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoConversionInvens()throws Exception {	
		if(tipoconversioninvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoConversionInven tipoconversioninvenAux:tipoconversioninvens) {
					if(tipoconversioninvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoconversioninvenAux.getIsDeleted() || (tipoconversioninvenAux.getIsChanged()&&!tipoconversioninvenAux.getIsNew())) {
						
						timestamp=tipoconversioninvenDataAccess.getSetVersionRowTipoConversionInven(connexion,tipoconversioninvenAux.getId());
						
						if(!tipoconversioninvenAux.getVersionRow().equals(timestamp)) {	
							tipoconversioninvenAux.setVersionRow(timestamp);
						}
						
													
						tipoconversioninvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoConversionInvenParameterReturnGeneral cargarCombosLoteForeignKeyTipoConversionInvenWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoConversionInvenParameterReturnGeneral  tipoconversioninvenReturnGeneral =new TipoConversionInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoConversionInvenWithConnection");connexion.begin();
			
			tipoconversioninvenReturnGeneral =new TipoConversionInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoconversioninvenReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoconversioninvenReturnGeneral;
	}
	
	public TipoConversionInvenParameterReturnGeneral cargarCombosLoteForeignKeyTipoConversionInven(String finalQueryGlobalEmpresa) throws Exception {
		TipoConversionInvenParameterReturnGeneral  tipoconversioninvenReturnGeneral =new TipoConversionInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoconversioninvenReturnGeneral =new TipoConversionInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoconversioninvenReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoconversioninvenReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoConversionInvenWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ConversionInvenLogic conversioninvenLogic=new ConversionInvenLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoConversionInvenWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ConversionInven.class));
											
			

			conversioninvenLogic.setConnexion(this.getConnexion());
			conversioninvenLogic.setDatosCliente(this.datosCliente);
			conversioninvenLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoConversionInven tipoconversioninven:this.tipoconversioninvens) {
				

				classes=new ArrayList<Classe>();
				classes=ConversionInvenConstantesFunciones.getClassesForeignKeysOfConversionInven(new ArrayList<Classe>(),DeepLoadType.NONE);

				conversioninvenLogic.setConversionInvens(tipoconversioninven.conversioninvens);
				conversioninvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoConversionInven tipoconversioninven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoConversionInvenLogicAdditional.updateTipoConversionInvenToGet(tipoconversioninven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoconversioninven.setEmpresa(tipoconversioninvenDataAccess.getEmpresa(connexion,tipoconversioninven));
		tipoconversioninven.setConversionInvens(tipoconversioninvenDataAccess.getConversionInvens(connexion,tipoconversioninven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoconversioninven.setEmpresa(tipoconversioninvenDataAccess.getEmpresa(connexion,tipoconversioninven));
				continue;
			}

			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoconversioninven.setConversionInvens(tipoconversioninvenDataAccess.getConversionInvens(connexion,tipoconversioninven));

				if(this.isConDeep) {
					ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(this.connexion);
					conversioninvenLogic.setConversionInvens(tipoconversioninven.getConversionInvens());
					ArrayList<Classe> classesLocal=ConversionInvenConstantesFunciones.getClassesForeignKeysOfConversionInven(new ArrayList<Classe>(),DeepLoadType.NONE);
					conversioninvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesConversionInven(conversioninvenLogic.getConversionInvens());
					tipoconversioninven.setConversionInvens(conversioninvenLogic.getConversionInvens());
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
			tipoconversioninven.setEmpresa(tipoconversioninvenDataAccess.getEmpresa(connexion,tipoconversioninven));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ConversionInven.class));
			tipoconversioninven.setConversionInvens(tipoconversioninvenDataAccess.getConversionInvens(connexion,tipoconversioninven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoconversioninven.setEmpresa(tipoconversioninvenDataAccess.getEmpresa(connexion,tipoconversioninven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoconversioninven.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoconversioninven.setConversionInvens(tipoconversioninvenDataAccess.getConversionInvens(connexion,tipoconversioninven));

		for(ConversionInven conversioninven:tipoconversioninven.getConversionInvens()) {
			ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(connexion);
			conversioninvenLogic.deepLoad(conversioninven,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoconversioninven.setEmpresa(tipoconversioninvenDataAccess.getEmpresa(connexion,tipoconversioninven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoconversioninven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoconversioninven.setConversionInvens(tipoconversioninvenDataAccess.getConversionInvens(connexion,tipoconversioninven));

				for(ConversionInven conversioninven:tipoconversioninven.getConversionInvens()) {
					ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(connexion);
					conversioninvenLogic.deepLoad(conversioninven,isDeep,deepLoadType,clases);
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
			tipoconversioninven.setEmpresa(tipoconversioninvenDataAccess.getEmpresa(connexion,tipoconversioninven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoconversioninven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ConversionInven.class));
			tipoconversioninven.setConversionInvens(tipoconversioninvenDataAccess.getConversionInvens(connexion,tipoconversioninven));

			for(ConversionInven conversioninven:tipoconversioninven.getConversionInvens()) {
				ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(connexion);
				conversioninvenLogic.deepLoad(conversioninven,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoConversionInven tipoconversioninven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoConversionInvenLogicAdditional.updateTipoConversionInvenToSave(tipoconversioninven,this.arrDatoGeneral);
			
TipoConversionInvenDataAccess.save(tipoconversioninven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoconversioninven.getEmpresa(),connexion);

		for(ConversionInven conversioninven:tipoconversioninven.getConversionInvens()) {
			conversioninven.setid_tipo_conversion_inven(tipoconversioninven.getId());
			ConversionInvenDataAccess.save(conversioninven,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoconversioninven.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ConversionInven conversioninven:tipoconversioninven.getConversionInvens()) {
					conversioninven.setid_tipo_conversion_inven(tipoconversioninven.getId());
					ConversionInvenDataAccess.save(conversioninven,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoconversioninven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoconversioninven.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(ConversionInven conversioninven:tipoconversioninven.getConversionInvens()) {
			ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(connexion);
			conversioninven.setid_tipo_conversion_inven(tipoconversioninven.getId());
			ConversionInvenDataAccess.save(conversioninven,connexion);
			conversioninvenLogic.deepSave(conversioninven,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoconversioninven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoconversioninven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ConversionInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ConversionInven conversioninven:tipoconversioninven.getConversionInvens()) {
					ConversionInvenLogic conversioninvenLogic= new ConversionInvenLogic(connexion);
					conversioninven.setid_tipo_conversion_inven(tipoconversioninven.getId());
					ConversionInvenDataAccess.save(conversioninven,connexion);
					conversioninvenLogic.deepSave(conversioninven,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoConversionInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoconversioninven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(tipoconversioninven);
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
			this.deepLoad(this.tipoconversioninven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoConversionInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoconversioninvens!=null) {
				for(TipoConversionInven tipoconversioninven:tipoconversioninvens) {
					this.deepLoad(tipoconversioninven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(tipoconversioninvens);
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
			if(tipoconversioninvens!=null) {
				for(TipoConversionInven tipoconversioninven:tipoconversioninvens) {
					this.deepLoad(tipoconversioninven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(tipoconversioninvens);
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
			this.getNewConnexionToDeep(TipoConversionInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoconversioninven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoConversionInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoconversioninvens!=null) {
				for(TipoConversionInven tipoconversioninven:tipoconversioninvens) {
					this.deepSave(tipoconversioninven,isDeep,deepLoadType,clases);
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
			if(tipoconversioninvens!=null) {
				for(TipoConversionInven tipoconversioninven:tipoconversioninvens) {
					this.deepSave(tipoconversioninven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoConversionInvensBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoConversionInvenConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoConversionInvensBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoConversionInvenConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoConversionInvensBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoConversionInvenConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoConversionInvensBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoConversionInvenConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoConversionInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConversionInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoConversionInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoConversionInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoConversionInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoConversionInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconversioninvens=tipoconversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConversionInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoConversionInven(this.tipoconversioninvens);
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
			if(TipoConversionInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConversionInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoConversionInven tipoconversioninven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoConversionInvenConstantesFunciones.ISCONAUDITORIA) {
				if(tipoconversioninven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConversionInvenDataAccess.TABLENAME, tipoconversioninven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoConversionInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoConversionInvenLogic.registrarAuditoriaDetallesTipoConversionInven(connexion,tipoconversioninven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoconversioninven.getIsDeleted()) {
					/*if(!tipoconversioninven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoConversionInvenDataAccess.TABLENAME, tipoconversioninven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoConversionInvenLogic.registrarAuditoriaDetallesTipoConversionInven(connexion,tipoconversioninven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConversionInvenDataAccess.TABLENAME, tipoconversioninven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoconversioninven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConversionInvenDataAccess.TABLENAME, tipoconversioninven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoConversionInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoConversionInvenLogic.registrarAuditoriaDetallesTipoConversionInven(connexion,tipoconversioninven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoConversionInven(Connexion connexion,TipoConversionInven tipoconversioninven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoconversioninven.getIsNew()||!tipoconversioninven.getid_empresa().equals(tipoconversioninven.getTipoConversionInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoconversioninven.getTipoConversionInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoconversioninven.getTipoConversionInvenOriginal().getid_empresa().toString();
				}
				if(tipoconversioninven.getid_empresa()!=null)
				{
					strValorNuevo=tipoconversioninven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoConversionInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoconversioninven.getIsNew()||!tipoconversioninven.getcodigo().equals(tipoconversioninven.getTipoConversionInvenOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoconversioninven.getTipoConversionInvenOriginal().getcodigo()!=null)
				{
					strValorActual=tipoconversioninven.getTipoConversionInvenOriginal().getcodigo();
				}
				if(tipoconversioninven.getcodigo()!=null)
				{
					strValorNuevo=tipoconversioninven.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoConversionInvenConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoconversioninven.getIsNew()||!tipoconversioninven.getnombre().equals(tipoconversioninven.getTipoConversionInvenOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoconversioninven.getTipoConversionInvenOriginal().getnombre()!=null)
				{
					strValorActual=tipoconversioninven.getTipoConversionInvenOriginal().getnombre();
				}
				if(tipoconversioninven.getnombre()!=null)
				{
					strValorNuevo=tipoconversioninven.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoConversionInvenConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoConversionInvenRelacionesWithConnection(TipoConversionInven tipoconversioninven,List<ConversionInven> conversioninvens) throws Exception {

		if(!tipoconversioninven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoConversionInvenRelacionesBase(tipoconversioninven,conversioninvens,true);
		}
	}

	public void saveTipoConversionInvenRelaciones(TipoConversionInven tipoconversioninven,List<ConversionInven> conversioninvens)throws Exception {

		if(!tipoconversioninven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoConversionInvenRelacionesBase(tipoconversioninven,conversioninvens,false);
		}
	}

	public void saveTipoConversionInvenRelacionesBase(TipoConversionInven tipoconversioninven,List<ConversionInven> conversioninvens,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoConversionInven-saveRelacionesWithConnection");}
	
			tipoconversioninven.setConversionInvens(conversioninvens);

			this.setTipoConversionInven(tipoconversioninven);

			if(TipoConversionInvenLogicAdditional.validarSaveRelaciones(tipoconversioninven,this)) {

				TipoConversionInvenLogicAdditional.updateRelacionesToSave(tipoconversioninven,this);

				if((tipoconversioninven.getIsNew()||tipoconversioninven.getIsChanged())&&!tipoconversioninven.getIsDeleted()) {
					this.saveTipoConversionInven();
					this.saveTipoConversionInvenRelacionesDetalles(conversioninvens);

				} else if(tipoconversioninven.getIsDeleted()) {
					this.saveTipoConversionInvenRelacionesDetalles(conversioninvens);
					this.saveTipoConversionInven();
				}

				TipoConversionInvenLogicAdditional.updateRelacionesToSaveAfter(tipoconversioninven,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ConversionInvenConstantesFunciones.InicializarGeneralEntityAuxiliaresConversionInvens(conversioninvens,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoConversionInvenRelacionesDetalles(List<ConversionInven> conversioninvens)throws Exception {
		try {
	

			Long idTipoConversionInvenActual=this.getTipoConversionInven().getId();

			ConversionInvenLogic conversioninvenLogic_Desde_TipoConversionInven=new ConversionInvenLogic();
			conversioninvenLogic_Desde_TipoConversionInven.setConversionInvens(conversioninvens);

			conversioninvenLogic_Desde_TipoConversionInven.setConnexion(this.getConnexion());
			conversioninvenLogic_Desde_TipoConversionInven.setDatosCliente(this.datosCliente);

			for(ConversionInven conversioninven_Desde_TipoConversionInven:conversioninvenLogic_Desde_TipoConversionInven.getConversionInvens()) {
				conversioninven_Desde_TipoConversionInven.setid_tipo_conversion_inven(idTipoConversionInvenActual);
			}

			conversioninvenLogic_Desde_TipoConversionInven.saveConversionInvens();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoConversionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoConversionInvenConstantesFunciones.getClassesForeignKeysOfTipoConversionInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConversionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoConversionInvenConstantesFunciones.getClassesRelationshipsOfTipoConversionInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

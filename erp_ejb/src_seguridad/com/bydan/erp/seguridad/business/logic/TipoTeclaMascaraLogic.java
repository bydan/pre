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
import com.bydan.erp.seguridad.util.TipoTeclaMascaraConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoTeclaMascaraParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoTeclaMascaraParameterGeneral;
import com.bydan.erp.seguridad.business.entity.TipoTeclaMascara;
//import com.bydan.erp.seguridad.business.logic.TipoTeclaMascaraLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoTeclaMascaraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoTeclaMascaraLogic.class);
	
	protected TipoTeclaMascaraDataAccess tipoteclamascaraDataAccess; 	
	protected TipoTeclaMascara tipoteclamascara;
	protected List<TipoTeclaMascara> tipoteclamascaras;
	protected Object tipoteclamascaraObject;	
	protected List<Object> tipoteclamascarasObject;
	
	public static ClassValidator<TipoTeclaMascara> tipoteclamascaraValidator = new ClassValidator<TipoTeclaMascara>(TipoTeclaMascara.class);	
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
	
	
	
	
	public  TipoTeclaMascaraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoteclamascaraDataAccess = new TipoTeclaMascaraDataAccess();
			
			this.tipoteclamascaras= new ArrayList<TipoTeclaMascara>();
			this.tipoteclamascara= new TipoTeclaMascara();
			
			this.tipoteclamascaraObject=new Object();
			this.tipoteclamascarasObject=new ArrayList<Object>();
				
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
			
			this.tipoteclamascaraDataAccess.setConnexionType(this.connexionType);
			this.tipoteclamascaraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoTeclaMascaraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoteclamascaraDataAccess = new TipoTeclaMascaraDataAccess();
			this.tipoteclamascaras= new ArrayList<TipoTeclaMascara>();
			this.tipoteclamascara= new TipoTeclaMascara();
			this.tipoteclamascaraObject=new Object();
			this.tipoteclamascarasObject=new ArrayList<Object>();
			
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
			
			this.tipoteclamascaraDataAccess.setConnexionType(this.connexionType);
			this.tipoteclamascaraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoTeclaMascara getTipoTeclaMascara() throws Exception {	
		//TipoTeclaMascaraLogicAdditional.checkTipoTeclaMascaraToGet(tipoteclamascara,this.datosCliente,this.arrDatoGeneral);
		//TipoTeclaMascaraLogicAdditional.updateTipoTeclaMascaraToGet(tipoteclamascara,this.arrDatoGeneral);
		
		return tipoteclamascara;
	}
		
	public void setTipoTeclaMascara(TipoTeclaMascara newTipoTeclaMascara) {
		this.tipoteclamascara = newTipoTeclaMascara;
	}
	
	public TipoTeclaMascaraDataAccess getTipoTeclaMascaraDataAccess() {
		return tipoteclamascaraDataAccess;
	}
	
	public void setTipoTeclaMascaraDataAccess(TipoTeclaMascaraDataAccess newtipoteclamascaraDataAccess) {
		this.tipoteclamascaraDataAccess = newtipoteclamascaraDataAccess;
	}
	
	public List<TipoTeclaMascara> getTipoTeclaMascaras() throws Exception {		
		this.quitarTipoTeclaMascarasNulos();
		
		//TipoTeclaMascaraLogicAdditional.checkTipoTeclaMascaraToGets(tipoteclamascaras,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoTeclaMascara tipoteclamascaraLocal: tipoteclamascaras ) {
			//TipoTeclaMascaraLogicAdditional.updateTipoTeclaMascaraToGet(tipoteclamascaraLocal,this.arrDatoGeneral);
		}
		
		return tipoteclamascaras;
	}
	
	public void setTipoTeclaMascaras(List<TipoTeclaMascara> newTipoTeclaMascaras) {
		this.tipoteclamascaras = newTipoTeclaMascaras;
	}
	
	public Object getTipoTeclaMascaraObject() {	
		this.tipoteclamascaraObject=this.tipoteclamascaraDataAccess.getEntityObject();
		return this.tipoteclamascaraObject;
	}
		
	public void setTipoTeclaMascaraObject(Object newTipoTeclaMascaraObject) {
		this.tipoteclamascaraObject = newTipoTeclaMascaraObject;
	}
	
	public List<Object> getTipoTeclaMascarasObject() {		
		this.tipoteclamascarasObject=this.tipoteclamascaraDataAccess.getEntitiesObject();
		return this.tipoteclamascarasObject;
	}
		
	public void setTipoTeclaMascarasObject(List<Object> newTipoTeclaMascarasObject) {
		this.tipoteclamascarasObject = newTipoTeclaMascarasObject;
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
		
		if(this.tipoteclamascaraDataAccess!=null) {
			this.tipoteclamascaraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoteclamascaraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoteclamascaraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoteclamascara = new  TipoTeclaMascara();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoteclamascara=tipoteclamascaraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoteclamascara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascara);
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
		tipoteclamascara = new  TipoTeclaMascara();
		  		  
        try {
			
			tipoteclamascara=tipoteclamascaraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoteclamascara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascara);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoteclamascara = new  TipoTeclaMascara();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoteclamascara=tipoteclamascaraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoteclamascara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascara);
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
		tipoteclamascara = new  TipoTeclaMascara();
		  		  
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
		tipoteclamascara = new  TipoTeclaMascara();
		  		  
        try {
			
			tipoteclamascara=tipoteclamascaraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoteclamascara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascara);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoteclamascara = new  TipoTeclaMascara();
		  		  
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
		tipoteclamascara = new  TipoTeclaMascara();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoteclamascaraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoteclamascara = new  TipoTeclaMascara();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoteclamascaraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoteclamascara = new  TipoTeclaMascara();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoteclamascaraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoteclamascara = new  TipoTeclaMascara();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoteclamascaraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoteclamascara = new  TipoTeclaMascara();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoteclamascaraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoteclamascara = new  TipoTeclaMascara();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoteclamascaraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoteclamascaras = new  ArrayList<TipoTeclaMascara>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoteclamascaras=tipoteclamascaraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTeclaMascara(tipoteclamascaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascaras);
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
		tipoteclamascaras = new  ArrayList<TipoTeclaMascara>();
		  		  
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
		tipoteclamascaras = new  ArrayList<TipoTeclaMascara>();
		  		  
        try {			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoteclamascaras=tipoteclamascaraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoTeclaMascara(tipoteclamascaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascaras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoteclamascaras = new  ArrayList<TipoTeclaMascara>();
		  		  
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
		tipoteclamascaras = new  ArrayList<TipoTeclaMascara>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoteclamascaras=tipoteclamascaraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTeclaMascara(tipoteclamascaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascaras);
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
		tipoteclamascaras = new  ArrayList<TipoTeclaMascara>();
		  		  
        try {
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoteclamascaras=tipoteclamascaraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTeclaMascara(tipoteclamascaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascaras);
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
		tipoteclamascaras = new  ArrayList<TipoTeclaMascara>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoteclamascaras=tipoteclamascaraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTeclaMascara(tipoteclamascaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascaras);
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
		tipoteclamascaras = new  ArrayList<TipoTeclaMascara>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoteclamascaras=tipoteclamascaraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTeclaMascara(tipoteclamascaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascaras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoteclamascara = new  TipoTeclaMascara();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoteclamascara=tipoteclamascaraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTeclaMascara(tipoteclamascara);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascara);
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
		tipoteclamascara = new  TipoTeclaMascara();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoteclamascara=tipoteclamascaraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTeclaMascara(tipoteclamascara);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascara);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoTeclaMascarasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoteclamascaras = new  ArrayList<TipoTeclaMascara>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-getTodosTipoTeclaMascarasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoteclamascaras=tipoteclamascaraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTeclaMascara(tipoteclamascaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascaras);
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
	
	public  void  getTodosTipoTeclaMascaras(String sFinalQuery,Pagination pagination)throws Exception {
		tipoteclamascaras = new  ArrayList<TipoTeclaMascara>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoteclamascaras=tipoteclamascaraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTeclaMascara(tipoteclamascaras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascaras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoTeclaMascara(TipoTeclaMascara tipoteclamascara) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoteclamascara.getIsNew() || tipoteclamascara.getIsChanged()) { 
			this.invalidValues = tipoteclamascaraValidator.getInvalidValues(tipoteclamascara);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoteclamascara);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoTeclaMascara(List<TipoTeclaMascara> TipoTeclaMascaras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoTeclaMascara tipoteclamascaraLocal:tipoteclamascaras) {				
			estaValidadoObjeto=this.validarGuardarTipoTeclaMascara(tipoteclamascaraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoTeclaMascara(List<TipoTeclaMascara> TipoTeclaMascaras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTeclaMascara(tipoteclamascaras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoTeclaMascara(TipoTeclaMascara TipoTeclaMascara) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTeclaMascara(tipoteclamascara)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoTeclaMascara tipoteclamascara) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoteclamascara.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoTeclaMascaraConstantesFunciones.getTipoTeclaMascaraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoteclamascara","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoTeclaMascaraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoTeclaMascaraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoTeclaMascaraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-saveTipoTeclaMascaraWithConnection");connexion.begin();			
			
			//TipoTeclaMascaraLogicAdditional.checkTipoTeclaMascaraToSave(this.tipoteclamascara,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoTeclaMascaraLogicAdditional.updateTipoTeclaMascaraToSave(this.tipoteclamascara,this.arrDatoGeneral);
			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoteclamascara,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoTeclaMascara();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTeclaMascara(this.tipoteclamascara)) {
				TipoTeclaMascaraDataAccess.save(this.tipoteclamascara, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoteclamascara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoTeclaMascaraLogicAdditional.checkTipoTeclaMascaraToSaveAfter(this.tipoteclamascara,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTeclaMascara();
			
			connexion.commit();			
			
			if(this.tipoteclamascara.getIsDeleted()) {
				this.tipoteclamascara=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoTeclaMascara()throws Exception {	
		try {	
			
			//TipoTeclaMascaraLogicAdditional.checkTipoTeclaMascaraToSave(this.tipoteclamascara,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoTeclaMascaraLogicAdditional.updateTipoTeclaMascaraToSave(this.tipoteclamascara,this.arrDatoGeneral);
			
			TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoteclamascara,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTeclaMascara(this.tipoteclamascara)) {			
				TipoTeclaMascaraDataAccess.save(this.tipoteclamascara, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoteclamascara,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoTeclaMascaraLogicAdditional.checkTipoTeclaMascaraToSaveAfter(this.tipoteclamascara,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoteclamascara.getIsDeleted()) {
				this.tipoteclamascara=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoTeclaMascarasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-saveTipoTeclaMascarasWithConnection");connexion.begin();			
			
			//TipoTeclaMascaraLogicAdditional.checkTipoTeclaMascaraToSaves(tipoteclamascaras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoTeclaMascaras();
			
			Boolean validadoTodosTipoTeclaMascara=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTeclaMascara tipoteclamascaraLocal:tipoteclamascaras) {		
				if(tipoteclamascaraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoTeclaMascaraLogicAdditional.updateTipoTeclaMascaraToSave(tipoteclamascaraLocal,this.arrDatoGeneral);
	        	
				TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoteclamascaraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTeclaMascara(tipoteclamascaraLocal)) {
					TipoTeclaMascaraDataAccess.save(tipoteclamascaraLocal, connexion);				
				} else {
					validadoTodosTipoTeclaMascara=false;
				}
			}
			
			if(!validadoTodosTipoTeclaMascara) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoTeclaMascaraLogicAdditional.checkTipoTeclaMascaraToSavesAfter(tipoteclamascaras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTeclaMascaras();
			
			connexion.commit();		
			
			this.quitarTipoTeclaMascarasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoTeclaMascaras()throws Exception {				
		 try {	
			//TipoTeclaMascaraLogicAdditional.checkTipoTeclaMascaraToSaves(tipoteclamascaras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoTeclaMascara=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTeclaMascara tipoteclamascaraLocal:tipoteclamascaras) {				
				if(tipoteclamascaraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoTeclaMascaraLogicAdditional.updateTipoTeclaMascaraToSave(tipoteclamascaraLocal,this.arrDatoGeneral);
	        	
				TipoTeclaMascaraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoteclamascaraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTeclaMascara(tipoteclamascaraLocal)) {				
					TipoTeclaMascaraDataAccess.save(tipoteclamascaraLocal, connexion);				
				} else {
					validadoTodosTipoTeclaMascara=false;
				}
			}
			
			if(!validadoTodosTipoTeclaMascara) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoTeclaMascaraLogicAdditional.checkTipoTeclaMascaraToSavesAfter(tipoteclamascaras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoTeclaMascarasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTeclaMascaraParameterReturnGeneral procesarAccionTipoTeclaMascaras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTeclaMascara> tipoteclamascaras,TipoTeclaMascaraParameterReturnGeneral tipoteclamascaraParameterGeneral)throws Exception {
		 try {	
			TipoTeclaMascaraParameterReturnGeneral tipoteclamascaraReturnGeneral=new TipoTeclaMascaraParameterReturnGeneral();
	
			
			return tipoteclamascaraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTeclaMascaraParameterReturnGeneral procesarAccionTipoTeclaMascarasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTeclaMascara> tipoteclamascaras,TipoTeclaMascaraParameterReturnGeneral tipoteclamascaraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-procesarAccionTipoTeclaMascarasWithConnection");connexion.begin();			
			
			TipoTeclaMascaraParameterReturnGeneral tipoteclamascaraReturnGeneral=new TipoTeclaMascaraParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoteclamascaraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTeclaMascaraParameterReturnGeneral procesarEventosTipoTeclaMascaras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTeclaMascara> tipoteclamascaras,TipoTeclaMascara tipoteclamascara,TipoTeclaMascaraParameterReturnGeneral tipoteclamascaraParameterGeneral,Boolean isEsNuevoTipoTeclaMascara,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoTeclaMascaraParameterReturnGeneral tipoteclamascaraReturnGeneral=new TipoTeclaMascaraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoteclamascaraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoteclamascaraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoTeclaMascaraParameterReturnGeneral procesarEventosTipoTeclaMascarasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTeclaMascara> tipoteclamascaras,TipoTeclaMascara tipoteclamascara,TipoTeclaMascaraParameterReturnGeneral tipoteclamascaraParameterGeneral,Boolean isEsNuevoTipoTeclaMascara,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-procesarEventosTipoTeclaMascarasWithConnection");connexion.begin();			
			
			TipoTeclaMascaraParameterReturnGeneral tipoteclamascaraReturnGeneral=new TipoTeclaMascaraParameterReturnGeneral();
	
			tipoteclamascaraReturnGeneral.setTipoTeclaMascara(tipoteclamascara);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoteclamascaraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoteclamascaraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTeclaMascaraParameterReturnGeneral procesarImportacionTipoTeclaMascarasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoTeclaMascaraParameterReturnGeneral tipoteclamascaraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTeclaMascara.class.getSimpleName()+"-procesarImportacionTipoTeclaMascarasWithConnection");connexion.begin();			
			
			TipoTeclaMascaraParameterReturnGeneral tipoteclamascaraReturnGeneral=new TipoTeclaMascaraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoteclamascaras=new ArrayList<TipoTeclaMascara>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoteclamascara=new TipoTeclaMascara();
				
				
				if(conColumnasBase) {this.tipoteclamascara.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoteclamascara.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoteclamascara.setcodigo(arrColumnas[iColumn++]);
				this.tipoteclamascara.setnombre(arrColumnas[iColumn++]);
				
				this.tipoteclamascaras.add(this.tipoteclamascara);
			}
			
			this.saveTipoTeclaMascaras();
			
			this.connexion.commit();
			
			tipoteclamascaraReturnGeneral.setConRetornoEstaProcesado(true);
			tipoteclamascaraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoteclamascaraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoTeclaMascarasEliminados() throws Exception {				
		
		List<TipoTeclaMascara> tipoteclamascarasAux= new ArrayList<TipoTeclaMascara>();
		
		for(TipoTeclaMascara tipoteclamascara:tipoteclamascaras) {
			if(!tipoteclamascara.getIsDeleted()) {
				tipoteclamascarasAux.add(tipoteclamascara);
			}
		}
		
		tipoteclamascaras=tipoteclamascarasAux;
	}
	
	public void quitarTipoTeclaMascarasNulos() throws Exception {				
		
		List<TipoTeclaMascara> tipoteclamascarasAux= new ArrayList<TipoTeclaMascara>();
		
		for(TipoTeclaMascara tipoteclamascara : this.tipoteclamascaras) {
			if(tipoteclamascara==null) {
				tipoteclamascarasAux.add(tipoteclamascara);
			}
		}
		
		//this.tipoteclamascaras=tipoteclamascarasAux;
		
		this.tipoteclamascaras.removeAll(tipoteclamascarasAux);
	}
	
	public void getSetVersionRowTipoTeclaMascaraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoteclamascara.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoteclamascara.getIsDeleted() || (tipoteclamascara.getIsChanged()&&!tipoteclamascara.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoteclamascaraDataAccess.getSetVersionRowTipoTeclaMascara(connexion,tipoteclamascara.getId());
				
				if(!tipoteclamascara.getVersionRow().equals(timestamp)) {	
					tipoteclamascara.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoteclamascara.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoTeclaMascara()throws Exception {	
		
		if(tipoteclamascara.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoteclamascara.getIsDeleted() || (tipoteclamascara.getIsChanged()&&!tipoteclamascara.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoteclamascaraDataAccess.getSetVersionRowTipoTeclaMascara(connexion,tipoteclamascara.getId());
			
			try {							
				if(!tipoteclamascara.getVersionRow().equals(timestamp)) {	
					tipoteclamascara.setVersionRow(timestamp);
				}
				
				tipoteclamascara.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoTeclaMascarasWithConnection()throws Exception {	
		if(tipoteclamascaras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoTeclaMascara tipoteclamascaraAux:tipoteclamascaras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoteclamascaraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoteclamascaraAux.getIsDeleted() || (tipoteclamascaraAux.getIsChanged()&&!tipoteclamascaraAux.getIsNew())) {
						
						timestamp=tipoteclamascaraDataAccess.getSetVersionRowTipoTeclaMascara(connexion,tipoteclamascaraAux.getId());
						
						if(!tipoteclamascara.getVersionRow().equals(timestamp)) {	
							tipoteclamascaraAux.setVersionRow(timestamp);
						}
								
						tipoteclamascaraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoTeclaMascaras()throws Exception {	
		if(tipoteclamascaras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoTeclaMascara tipoteclamascaraAux:tipoteclamascaras) {
					if(tipoteclamascaraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoteclamascaraAux.getIsDeleted() || (tipoteclamascaraAux.getIsChanged()&&!tipoteclamascaraAux.getIsNew())) {
						
						timestamp=tipoteclamascaraDataAccess.getSetVersionRowTipoTeclaMascara(connexion,tipoteclamascaraAux.getId());
						
						if(!tipoteclamascaraAux.getVersionRow().equals(timestamp)) {	
							tipoteclamascaraAux.setVersionRow(timestamp);
						}
						
													
						tipoteclamascaraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoTeclaMascara tipoteclamascara,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoTeclaMascaraLogicAdditional.updateTipoTeclaMascaraToGet(tipoteclamascara,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoTeclaMascara tipoteclamascara,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoTeclaMascara.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoteclamascara,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(tipoteclamascara);
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
			this.deepLoad(this.tipoteclamascara,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(this.tipoteclamascara);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoTeclaMascara.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoteclamascaras!=null) {
				for(TipoTeclaMascara tipoteclamascara:tipoteclamascaras) {
					this.deepLoad(tipoteclamascara,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(tipoteclamascaras);
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
			if(tipoteclamascaras!=null) {
				for(TipoTeclaMascara tipoteclamascara:tipoteclamascaras) {
					this.deepLoad(tipoteclamascara,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoTeclaMascaraConstantesFunciones.refrescarForeignKeysDescripcionesTipoTeclaMascara(tipoteclamascaras);
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
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoTeclaMascaraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTeclaMascaraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoTeclaMascara tipoteclamascara,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoTeclaMascaraConstantesFunciones.ISCONAUDITORIA) {
				if(tipoteclamascara.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTeclaMascaraDataAccess.TABLENAME, tipoteclamascara.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTeclaMascaraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTeclaMascaraLogic.registrarAuditoriaDetallesTipoTeclaMascara(connexion,tipoteclamascara,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoteclamascara.getIsDeleted()) {
					/*if(!tipoteclamascara.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoTeclaMascaraDataAccess.TABLENAME, tipoteclamascara.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoTeclaMascaraLogic.registrarAuditoriaDetallesTipoTeclaMascara(connexion,tipoteclamascara,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTeclaMascaraDataAccess.TABLENAME, tipoteclamascara.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoteclamascara.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTeclaMascaraDataAccess.TABLENAME, tipoteclamascara.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTeclaMascaraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTeclaMascaraLogic.registrarAuditoriaDetallesTipoTeclaMascara(connexion,tipoteclamascara,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoTeclaMascara(Connexion connexion,TipoTeclaMascara tipoteclamascara)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoteclamascara.getIsNew()||!tipoteclamascara.getcodigo().equals(tipoteclamascara.getTipoTeclaMascaraOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoteclamascara.getTipoTeclaMascaraOriginal().getcodigo()!=null)
				{
					strValorActual=tipoteclamascara.getTipoTeclaMascaraOriginal().getcodigo();
				}
				if(tipoteclamascara.getcodigo()!=null)
				{
					strValorNuevo=tipoteclamascara.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTeclaMascaraConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoteclamascara.getIsNew()||!tipoteclamascara.getnombre().equals(tipoteclamascara.getTipoTeclaMascaraOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoteclamascara.getTipoTeclaMascaraOriginal().getnombre()!=null)
				{
					strValorActual=tipoteclamascara.getTipoTeclaMascaraOriginal().getnombre();
				}
				if(tipoteclamascara.getnombre()!=null)
				{
					strValorNuevo=tipoteclamascara.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTeclaMascaraConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTeclaMascara(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTeclaMascaraConstantesFunciones.getClassesForeignKeysOfTipoTeclaMascara(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTeclaMascara(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTeclaMascaraConstantesFunciones.getClassesRelationshipsOfTipoTeclaMascara(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

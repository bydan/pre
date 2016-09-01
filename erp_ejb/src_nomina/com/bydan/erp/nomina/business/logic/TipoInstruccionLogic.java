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
import com.bydan.erp.nomina.util.TipoInstruccionConstantesFunciones;
import com.bydan.erp.nomina.util.TipoInstruccionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoInstruccionParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoInstruccion;
//import com.bydan.erp.nomina.business.logic.TipoInstruccionLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoInstruccionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoInstruccionLogic.class);
	
	protected TipoInstruccionDataAccess tipoinstruccionDataAccess; 	
	protected TipoInstruccion tipoinstruccion;
	protected List<TipoInstruccion> tipoinstruccions;
	protected Object tipoinstruccionObject;	
	protected List<Object> tipoinstruccionsObject;
	
	public static ClassValidator<TipoInstruccion> tipoinstruccionValidator = new ClassValidator<TipoInstruccion>(TipoInstruccion.class);	
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
	
	
	
	
	public  TipoInstruccionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoinstruccionDataAccess = new TipoInstruccionDataAccess();
			
			this.tipoinstruccions= new ArrayList<TipoInstruccion>();
			this.tipoinstruccion= new TipoInstruccion();
			
			this.tipoinstruccionObject=new Object();
			this.tipoinstruccionsObject=new ArrayList<Object>();
				
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
			
			this.tipoinstruccionDataAccess.setConnexionType(this.connexionType);
			this.tipoinstruccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoInstruccionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoinstruccionDataAccess = new TipoInstruccionDataAccess();
			this.tipoinstruccions= new ArrayList<TipoInstruccion>();
			this.tipoinstruccion= new TipoInstruccion();
			this.tipoinstruccionObject=new Object();
			this.tipoinstruccionsObject=new ArrayList<Object>();
			
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
			
			this.tipoinstruccionDataAccess.setConnexionType(this.connexionType);
			this.tipoinstruccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoInstruccion getTipoInstruccion() throws Exception {	
		//TipoInstruccionLogicAdditional.checkTipoInstruccionToGet(tipoinstruccion,this.datosCliente,this.arrDatoGeneral);
		//TipoInstruccionLogicAdditional.updateTipoInstruccionToGet(tipoinstruccion,this.arrDatoGeneral);
		
		return tipoinstruccion;
	}
		
	public void setTipoInstruccion(TipoInstruccion newTipoInstruccion) {
		this.tipoinstruccion = newTipoInstruccion;
	}
	
	public TipoInstruccionDataAccess getTipoInstruccionDataAccess() {
		return tipoinstruccionDataAccess;
	}
	
	public void setTipoInstruccionDataAccess(TipoInstruccionDataAccess newtipoinstruccionDataAccess) {
		this.tipoinstruccionDataAccess = newtipoinstruccionDataAccess;
	}
	
	public List<TipoInstruccion> getTipoInstruccions() throws Exception {		
		this.quitarTipoInstruccionsNulos();
		
		//TipoInstruccionLogicAdditional.checkTipoInstruccionToGets(tipoinstruccions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoInstruccion tipoinstruccionLocal: tipoinstruccions ) {
			//TipoInstruccionLogicAdditional.updateTipoInstruccionToGet(tipoinstruccionLocal,this.arrDatoGeneral);
		}
		
		return tipoinstruccions;
	}
	
	public void setTipoInstruccions(List<TipoInstruccion> newTipoInstruccions) {
		this.tipoinstruccions = newTipoInstruccions;
	}
	
	public Object getTipoInstruccionObject() {	
		this.tipoinstruccionObject=this.tipoinstruccionDataAccess.getEntityObject();
		return this.tipoinstruccionObject;
	}
		
	public void setTipoInstruccionObject(Object newTipoInstruccionObject) {
		this.tipoinstruccionObject = newTipoInstruccionObject;
	}
	
	public List<Object> getTipoInstruccionsObject() {		
		this.tipoinstruccionsObject=this.tipoinstruccionDataAccess.getEntitiesObject();
		return this.tipoinstruccionsObject;
	}
		
	public void setTipoInstruccionsObject(List<Object> newTipoInstruccionsObject) {
		this.tipoinstruccionsObject = newTipoInstruccionsObject;
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
		
		if(this.tipoinstruccionDataAccess!=null) {
			this.tipoinstruccionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoinstruccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoinstruccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoinstruccion = new  TipoInstruccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoinstruccion=tipoinstruccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinstruccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccion);
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
		tipoinstruccion = new  TipoInstruccion();
		  		  
        try {
			
			tipoinstruccion=tipoinstruccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinstruccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoinstruccion = new  TipoInstruccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoinstruccion=tipoinstruccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinstruccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccion);
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
		tipoinstruccion = new  TipoInstruccion();
		  		  
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
		tipoinstruccion = new  TipoInstruccion();
		  		  
        try {
			
			tipoinstruccion=tipoinstruccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinstruccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoinstruccion = new  TipoInstruccion();
		  		  
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
		tipoinstruccion = new  TipoInstruccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoinstruccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoinstruccion = new  TipoInstruccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoinstruccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoinstruccion = new  TipoInstruccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoinstruccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoinstruccion = new  TipoInstruccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoinstruccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoinstruccion = new  TipoInstruccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoinstruccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoinstruccion = new  TipoInstruccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoinstruccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoinstruccions = new  ArrayList<TipoInstruccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstruccions=tipoinstruccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInstruccion(tipoinstruccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccions);
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
		tipoinstruccions = new  ArrayList<TipoInstruccion>();
		  		  
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
		tipoinstruccions = new  ArrayList<TipoInstruccion>();
		  		  
        try {			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstruccions=tipoinstruccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoInstruccion(tipoinstruccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoinstruccions = new  ArrayList<TipoInstruccion>();
		  		  
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
		tipoinstruccions = new  ArrayList<TipoInstruccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstruccions=tipoinstruccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInstruccion(tipoinstruccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccions);
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
		tipoinstruccions = new  ArrayList<TipoInstruccion>();
		  		  
        try {
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstruccions=tipoinstruccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInstruccion(tipoinstruccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccions);
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
		tipoinstruccions = new  ArrayList<TipoInstruccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstruccions=tipoinstruccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInstruccion(tipoinstruccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccions);
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
		tipoinstruccions = new  ArrayList<TipoInstruccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstruccions=tipoinstruccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInstruccion(tipoinstruccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoinstruccion = new  TipoInstruccion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstruccion=tipoinstruccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInstruccion(tipoinstruccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccion);
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
		tipoinstruccion = new  TipoInstruccion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstruccion=tipoinstruccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInstruccion(tipoinstruccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoInstruccionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoinstruccions = new  ArrayList<TipoInstruccion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-getTodosTipoInstruccionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstruccions=tipoinstruccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoInstruccion(tipoinstruccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccions);
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
	
	public  void  getTodosTipoInstruccions(String sFinalQuery,Pagination pagination)throws Exception {
		tipoinstruccions = new  ArrayList<TipoInstruccion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstruccions=tipoinstruccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoInstruccion(tipoinstruccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoInstruccion(TipoInstruccion tipoinstruccion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoinstruccion.getIsNew() || tipoinstruccion.getIsChanged()) { 
			this.invalidValues = tipoinstruccionValidator.getInvalidValues(tipoinstruccion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoinstruccion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoInstruccion(List<TipoInstruccion> TipoInstruccions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoInstruccion tipoinstruccionLocal:tipoinstruccions) {				
			estaValidadoObjeto=this.validarGuardarTipoInstruccion(tipoinstruccionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoInstruccion(List<TipoInstruccion> TipoInstruccions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoInstruccion(tipoinstruccions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoInstruccion(TipoInstruccion TipoInstruccion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoInstruccion(tipoinstruccion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoInstruccion tipoinstruccion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoinstruccion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoInstruccionConstantesFunciones.getTipoInstruccionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoinstruccion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoInstruccionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoInstruccionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoInstruccionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-saveTipoInstruccionWithConnection");connexion.begin();			
			
			//TipoInstruccionLogicAdditional.checkTipoInstruccionToSave(this.tipoinstruccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoInstruccionLogicAdditional.updateTipoInstruccionToSave(this.tipoinstruccion,this.arrDatoGeneral);
			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoinstruccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoInstruccion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoInstruccion(this.tipoinstruccion)) {
				TipoInstruccionDataAccess.save(this.tipoinstruccion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoinstruccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoInstruccionLogicAdditional.checkTipoInstruccionToSaveAfter(this.tipoinstruccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoInstruccion();
			
			connexion.commit();			
			
			if(this.tipoinstruccion.getIsDeleted()) {
				this.tipoinstruccion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoInstruccion()throws Exception {	
		try {	
			
			//TipoInstruccionLogicAdditional.checkTipoInstruccionToSave(this.tipoinstruccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoInstruccionLogicAdditional.updateTipoInstruccionToSave(this.tipoinstruccion,this.arrDatoGeneral);
			
			TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoinstruccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoInstruccion(this.tipoinstruccion)) {			
				TipoInstruccionDataAccess.save(this.tipoinstruccion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoinstruccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoInstruccionLogicAdditional.checkTipoInstruccionToSaveAfter(this.tipoinstruccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoinstruccion.getIsDeleted()) {
				this.tipoinstruccion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoInstruccionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-saveTipoInstruccionsWithConnection");connexion.begin();			
			
			//TipoInstruccionLogicAdditional.checkTipoInstruccionToSaves(tipoinstruccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoInstruccions();
			
			Boolean validadoTodosTipoInstruccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoInstruccion tipoinstruccionLocal:tipoinstruccions) {		
				if(tipoinstruccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoInstruccionLogicAdditional.updateTipoInstruccionToSave(tipoinstruccionLocal,this.arrDatoGeneral);
	        	
				TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoinstruccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoInstruccion(tipoinstruccionLocal)) {
					TipoInstruccionDataAccess.save(tipoinstruccionLocal, connexion);				
				} else {
					validadoTodosTipoInstruccion=false;
				}
			}
			
			if(!validadoTodosTipoInstruccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoInstruccionLogicAdditional.checkTipoInstruccionToSavesAfter(tipoinstruccions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoInstruccions();
			
			connexion.commit();		
			
			this.quitarTipoInstruccionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoInstruccions()throws Exception {				
		 try {	
			//TipoInstruccionLogicAdditional.checkTipoInstruccionToSaves(tipoinstruccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoInstruccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoInstruccion tipoinstruccionLocal:tipoinstruccions) {				
				if(tipoinstruccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoInstruccionLogicAdditional.updateTipoInstruccionToSave(tipoinstruccionLocal,this.arrDatoGeneral);
	        	
				TipoInstruccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoinstruccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoInstruccion(tipoinstruccionLocal)) {				
					TipoInstruccionDataAccess.save(tipoinstruccionLocal, connexion);				
				} else {
					validadoTodosTipoInstruccion=false;
				}
			}
			
			if(!validadoTodosTipoInstruccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoInstruccionLogicAdditional.checkTipoInstruccionToSavesAfter(tipoinstruccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoInstruccionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoInstruccionParameterReturnGeneral procesarAccionTipoInstruccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoInstruccion> tipoinstruccions,TipoInstruccionParameterReturnGeneral tipoinstruccionParameterGeneral)throws Exception {
		 try {	
			TipoInstruccionParameterReturnGeneral tipoinstruccionReturnGeneral=new TipoInstruccionParameterReturnGeneral();
	
			
			return tipoinstruccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoInstruccionParameterReturnGeneral procesarAccionTipoInstruccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoInstruccion> tipoinstruccions,TipoInstruccionParameterReturnGeneral tipoinstruccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-procesarAccionTipoInstruccionsWithConnection");connexion.begin();			
			
			TipoInstruccionParameterReturnGeneral tipoinstruccionReturnGeneral=new TipoInstruccionParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoinstruccionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoInstruccionParameterReturnGeneral procesarEventosTipoInstruccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoInstruccion> tipoinstruccions,TipoInstruccion tipoinstruccion,TipoInstruccionParameterReturnGeneral tipoinstruccionParameterGeneral,Boolean isEsNuevoTipoInstruccion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoInstruccionParameterReturnGeneral tipoinstruccionReturnGeneral=new TipoInstruccionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoinstruccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoinstruccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoInstruccionParameterReturnGeneral procesarEventosTipoInstruccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoInstruccion> tipoinstruccions,TipoInstruccion tipoinstruccion,TipoInstruccionParameterReturnGeneral tipoinstruccionParameterGeneral,Boolean isEsNuevoTipoInstruccion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-procesarEventosTipoInstruccionsWithConnection");connexion.begin();			
			
			TipoInstruccionParameterReturnGeneral tipoinstruccionReturnGeneral=new TipoInstruccionParameterReturnGeneral();
	
			tipoinstruccionReturnGeneral.setTipoInstruccion(tipoinstruccion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoinstruccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoinstruccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoInstruccionParameterReturnGeneral procesarImportacionTipoInstruccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoInstruccionParameterReturnGeneral tipoinstruccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-procesarImportacionTipoInstruccionsWithConnection");connexion.begin();			
			
			TipoInstruccionParameterReturnGeneral tipoinstruccionReturnGeneral=new TipoInstruccionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoinstruccions=new ArrayList<TipoInstruccion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoinstruccion=new TipoInstruccion();
				
				
				if(conColumnasBase) {this.tipoinstruccion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoinstruccion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoinstruccion.setcodigo(arrColumnas[iColumn++]);
				this.tipoinstruccion.setnombre(arrColumnas[iColumn++]);
				
				this.tipoinstruccions.add(this.tipoinstruccion);
			}
			
			this.saveTipoInstruccions();
			
			this.connexion.commit();
			
			tipoinstruccionReturnGeneral.setConRetornoEstaProcesado(true);
			tipoinstruccionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoinstruccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoInstruccionsEliminados() throws Exception {				
		
		List<TipoInstruccion> tipoinstruccionsAux= new ArrayList<TipoInstruccion>();
		
		for(TipoInstruccion tipoinstruccion:tipoinstruccions) {
			if(!tipoinstruccion.getIsDeleted()) {
				tipoinstruccionsAux.add(tipoinstruccion);
			}
		}
		
		tipoinstruccions=tipoinstruccionsAux;
	}
	
	public void quitarTipoInstruccionsNulos() throws Exception {				
		
		List<TipoInstruccion> tipoinstruccionsAux= new ArrayList<TipoInstruccion>();
		
		for(TipoInstruccion tipoinstruccion : this.tipoinstruccions) {
			if(tipoinstruccion==null) {
				tipoinstruccionsAux.add(tipoinstruccion);
			}
		}
		
		//this.tipoinstruccions=tipoinstruccionsAux;
		
		this.tipoinstruccions.removeAll(tipoinstruccionsAux);
	}
	
	public void getSetVersionRowTipoInstruccionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoinstruccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoinstruccion.getIsDeleted() || (tipoinstruccion.getIsChanged()&&!tipoinstruccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoinstruccionDataAccess.getSetVersionRowTipoInstruccion(connexion,tipoinstruccion.getId());
				
				if(!tipoinstruccion.getVersionRow().equals(timestamp)) {	
					tipoinstruccion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoinstruccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoInstruccion()throws Exception {	
		
		if(tipoinstruccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoinstruccion.getIsDeleted() || (tipoinstruccion.getIsChanged()&&!tipoinstruccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoinstruccionDataAccess.getSetVersionRowTipoInstruccion(connexion,tipoinstruccion.getId());
			
			try {							
				if(!tipoinstruccion.getVersionRow().equals(timestamp)) {	
					tipoinstruccion.setVersionRow(timestamp);
				}
				
				tipoinstruccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoInstruccionsWithConnection()throws Exception {	
		if(tipoinstruccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoInstruccion tipoinstruccionAux:tipoinstruccions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoinstruccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoinstruccionAux.getIsDeleted() || (tipoinstruccionAux.getIsChanged()&&!tipoinstruccionAux.getIsNew())) {
						
						timestamp=tipoinstruccionDataAccess.getSetVersionRowTipoInstruccion(connexion,tipoinstruccionAux.getId());
						
						if(!tipoinstruccion.getVersionRow().equals(timestamp)) {	
							tipoinstruccionAux.setVersionRow(timestamp);
						}
								
						tipoinstruccionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoInstruccions()throws Exception {	
		if(tipoinstruccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoInstruccion tipoinstruccionAux:tipoinstruccions) {
					if(tipoinstruccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoinstruccionAux.getIsDeleted() || (tipoinstruccionAux.getIsChanged()&&!tipoinstruccionAux.getIsNew())) {
						
						timestamp=tipoinstruccionDataAccess.getSetVersionRowTipoInstruccion(connexion,tipoinstruccionAux.getId());
						
						if(!tipoinstruccionAux.getVersionRow().equals(timestamp)) {	
							tipoinstruccionAux.setVersionRow(timestamp);
						}
						
													
						tipoinstruccionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoInstruccionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstruccion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoInstruccionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Empleado.class));
											
			

			empleadoLogic.setConnexion(this.getConnexion());
			empleadoLogic.setDatosCliente(this.datosCliente);
			empleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoInstruccion tipoinstruccion:this.tipoinstruccions) {
				

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoLogic.setEmpleados(tipoinstruccion.empleados);
				empleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoInstruccion tipoinstruccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoInstruccionLogicAdditional.updateTipoInstruccionToGet(tipoinstruccion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoinstruccion.setEmpleados(tipoinstruccionDataAccess.getEmpleados(connexion,tipoinstruccion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoinstruccion.setEmpleados(tipoinstruccionDataAccess.getEmpleados(connexion,tipoinstruccion));

				if(this.isConDeep) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(this.connexion);
					empleadoLogic.setEmpleados(tipoinstruccion.getEmpleados());
					ArrayList<Classe> classesLocal=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleadoLogic.getEmpleados());
					tipoinstruccion.setEmpleados(empleadoLogic.getEmpleados());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			tipoinstruccion.setEmpleados(tipoinstruccionDataAccess.getEmpleados(connexion,tipoinstruccion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoinstruccion.setEmpleados(tipoinstruccionDataAccess.getEmpleados(connexion,tipoinstruccion));

		for(Empleado empleado:tipoinstruccion.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoinstruccion.setEmpleados(tipoinstruccionDataAccess.getEmpleados(connexion,tipoinstruccion));

				for(Empleado empleado:tipoinstruccion.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			tipoinstruccion.setEmpleados(tipoinstruccionDataAccess.getEmpleados(connexion,tipoinstruccion));

			for(Empleado empleado:tipoinstruccion.getEmpleados()) {
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoInstruccion tipoinstruccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoInstruccion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoinstruccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(tipoinstruccion);
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
			this.deepLoad(this.tipoinstruccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(this.tipoinstruccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoInstruccion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoinstruccions!=null) {
				for(TipoInstruccion tipoinstruccion:tipoinstruccions) {
					this.deepLoad(tipoinstruccion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(tipoinstruccions);
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
			if(tipoinstruccions!=null) {
				for(TipoInstruccion tipoinstruccion:tipoinstruccions) {
					this.deepLoad(tipoinstruccion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoInstruccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstruccion(tipoinstruccions);
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
			if(TipoInstruccionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInstruccionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoInstruccion tipoinstruccion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoInstruccionConstantesFunciones.ISCONAUDITORIA) {
				if(tipoinstruccion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInstruccionDataAccess.TABLENAME, tipoinstruccion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoInstruccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoInstruccionLogic.registrarAuditoriaDetallesTipoInstruccion(connexion,tipoinstruccion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoinstruccion.getIsDeleted()) {
					/*if(!tipoinstruccion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoInstruccionDataAccess.TABLENAME, tipoinstruccion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoInstruccionLogic.registrarAuditoriaDetallesTipoInstruccion(connexion,tipoinstruccion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInstruccionDataAccess.TABLENAME, tipoinstruccion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoinstruccion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInstruccionDataAccess.TABLENAME, tipoinstruccion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoInstruccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoInstruccionLogic.registrarAuditoriaDetallesTipoInstruccion(connexion,tipoinstruccion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoInstruccion(Connexion connexion,TipoInstruccion tipoinstruccion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoinstruccion.getIsNew()||!tipoinstruccion.getcodigo().equals(tipoinstruccion.getTipoInstruccionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoinstruccion.getTipoInstruccionOriginal().getcodigo()!=null)
				{
					strValorActual=tipoinstruccion.getTipoInstruccionOriginal().getcodigo();
				}
				if(tipoinstruccion.getcodigo()!=null)
				{
					strValorNuevo=tipoinstruccion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoInstruccionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoinstruccion.getIsNew()||!tipoinstruccion.getnombre().equals(tipoinstruccion.getTipoInstruccionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoinstruccion.getTipoInstruccionOriginal().getnombre()!=null)
				{
					strValorActual=tipoinstruccion.getTipoInstruccionOriginal().getnombre();
				}
				if(tipoinstruccion.getnombre()!=null)
				{
					strValorNuevo=tipoinstruccion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoInstruccionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoInstruccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoInstruccionConstantesFunciones.getClassesForeignKeysOfTipoInstruccion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInstruccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoInstruccionConstantesFunciones.getClassesRelationshipsOfTipoInstruccion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

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
import com.bydan.erp.contabilidad.util.TipoDescripcionAsientoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoDescripcionAsientoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoDescripcionAsientoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoDescripcionAsiento;
import com.bydan.erp.contabilidad.business.logic.TipoDescripcionAsientoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoDescripcionAsientoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDescripcionAsientoLogic.class);
	
	protected TipoDescripcionAsientoDataAccess tipodescripcionasientoDataAccess; 	
	protected TipoDescripcionAsiento tipodescripcionasiento;
	protected List<TipoDescripcionAsiento> tipodescripcionasientos;
	protected Object tipodescripcionasientoObject;	
	protected List<Object> tipodescripcionasientosObject;
	
	public static ClassValidator<TipoDescripcionAsiento> tipodescripcionasientoValidator = new ClassValidator<TipoDescripcionAsiento>(TipoDescripcionAsiento.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoDescripcionAsientoLogicAdditional tipodescripcionasientoLogicAdditional=null;
	
	public TipoDescripcionAsientoLogicAdditional getTipoDescripcionAsientoLogicAdditional() {
		return this.tipodescripcionasientoLogicAdditional;
	}
	
	public void setTipoDescripcionAsientoLogicAdditional(TipoDescripcionAsientoLogicAdditional tipodescripcionasientoLogicAdditional) {
		try {
			this.tipodescripcionasientoLogicAdditional=tipodescripcionasientoLogicAdditional;
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
	
	
	
	
	public  TipoDescripcionAsientoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodescripcionasientoDataAccess = new TipoDescripcionAsientoDataAccess();
			
			this.tipodescripcionasientos= new ArrayList<TipoDescripcionAsiento>();
			this.tipodescripcionasiento= new TipoDescripcionAsiento();
			
			this.tipodescripcionasientoObject=new Object();
			this.tipodescripcionasientosObject=new ArrayList<Object>();
				
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
			
			this.tipodescripcionasientoDataAccess.setConnexionType(this.connexionType);
			this.tipodescripcionasientoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDescripcionAsientoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodescripcionasientoDataAccess = new TipoDescripcionAsientoDataAccess();
			this.tipodescripcionasientos= new ArrayList<TipoDescripcionAsiento>();
			this.tipodescripcionasiento= new TipoDescripcionAsiento();
			this.tipodescripcionasientoObject=new Object();
			this.tipodescripcionasientosObject=new ArrayList<Object>();
			
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
			
			this.tipodescripcionasientoDataAccess.setConnexionType(this.connexionType);
			this.tipodescripcionasientoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDescripcionAsiento getTipoDescripcionAsiento() throws Exception {	
		TipoDescripcionAsientoLogicAdditional.checkTipoDescripcionAsientoToGet(tipodescripcionasiento,this.datosCliente,this.arrDatoGeneral);
		TipoDescripcionAsientoLogicAdditional.updateTipoDescripcionAsientoToGet(tipodescripcionasiento,this.arrDatoGeneral);
		
		return tipodescripcionasiento;
	}
		
	public void setTipoDescripcionAsiento(TipoDescripcionAsiento newTipoDescripcionAsiento) {
		this.tipodescripcionasiento = newTipoDescripcionAsiento;
	}
	
	public TipoDescripcionAsientoDataAccess getTipoDescripcionAsientoDataAccess() {
		return tipodescripcionasientoDataAccess;
	}
	
	public void setTipoDescripcionAsientoDataAccess(TipoDescripcionAsientoDataAccess newtipodescripcionasientoDataAccess) {
		this.tipodescripcionasientoDataAccess = newtipodescripcionasientoDataAccess;
	}
	
	public List<TipoDescripcionAsiento> getTipoDescripcionAsientos() throws Exception {		
		this.quitarTipoDescripcionAsientosNulos();
		
		TipoDescripcionAsientoLogicAdditional.checkTipoDescripcionAsientoToGets(tipodescripcionasientos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDescripcionAsiento tipodescripcionasientoLocal: tipodescripcionasientos ) {
			TipoDescripcionAsientoLogicAdditional.updateTipoDescripcionAsientoToGet(tipodescripcionasientoLocal,this.arrDatoGeneral);
		}
		
		return tipodescripcionasientos;
	}
	
	public void setTipoDescripcionAsientos(List<TipoDescripcionAsiento> newTipoDescripcionAsientos) {
		this.tipodescripcionasientos = newTipoDescripcionAsientos;
	}
	
	public Object getTipoDescripcionAsientoObject() {	
		this.tipodescripcionasientoObject=this.tipodescripcionasientoDataAccess.getEntityObject();
		return this.tipodescripcionasientoObject;
	}
		
	public void setTipoDescripcionAsientoObject(Object newTipoDescripcionAsientoObject) {
		this.tipodescripcionasientoObject = newTipoDescripcionAsientoObject;
	}
	
	public List<Object> getTipoDescripcionAsientosObject() {		
		this.tipodescripcionasientosObject=this.tipodescripcionasientoDataAccess.getEntitiesObject();
		return this.tipodescripcionasientosObject;
	}
		
	public void setTipoDescripcionAsientosObject(List<Object> newTipoDescripcionAsientosObject) {
		this.tipodescripcionasientosObject = newTipoDescripcionAsientosObject;
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
		
		if(this.tipodescripcionasientoDataAccess!=null) {
			this.tipodescripcionasientoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodescripcionasientoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodescripcionasientoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodescripcionasiento=tipodescripcionasientoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodescripcionasiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasiento);
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
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		  		  
        try {
			
			tipodescripcionasiento=tipodescripcionasientoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodescripcionasiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodescripcionasiento=tipodescripcionasientoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodescripcionasiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasiento);
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
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		  		  
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
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		  		  
        try {
			
			tipodescripcionasiento=tipodescripcionasientoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodescripcionasiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		  		  
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
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodescripcionasientoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodescripcionasientoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodescripcionasientoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodescripcionasientoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodescripcionasientoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodescripcionasientoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
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
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		  		  
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
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		  		  
        try {			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		  		  
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
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
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
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		  		  
        try {
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
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
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
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
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasiento=tipodescripcionasientoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasiento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasiento);
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
		tipodescripcionasiento = new  TipoDescripcionAsiento();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasiento=tipodescripcionasientoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasiento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
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
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		  		  
        try {
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoDescripcionAsientosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getTodosTipoDescripcionAsientosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
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
	
	public  void  getTodosTipoDescripcionAsientos(String sFinalQuery,Pagination pagination)throws Exception {
		tipodescripcionasientos = new  ArrayList<TipoDescripcionAsiento>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDescripcionAsiento(tipodescripcionasientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDescripcionAsiento(TipoDescripcionAsiento tipodescripcionasiento) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodescripcionasiento.getIsNew() || tipodescripcionasiento.getIsChanged()) { 
			this.invalidValues = tipodescripcionasientoValidator.getInvalidValues(tipodescripcionasiento);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodescripcionasiento);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDescripcionAsiento(List<TipoDescripcionAsiento> TipoDescripcionAsientos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDescripcionAsiento tipodescripcionasientoLocal:tipodescripcionasientos) {				
			estaValidadoObjeto=this.validarGuardarTipoDescripcionAsiento(tipodescripcionasientoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDescripcionAsiento(List<TipoDescripcionAsiento> TipoDescripcionAsientos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDescripcionAsiento(tipodescripcionasientos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDescripcionAsiento(TipoDescripcionAsiento TipoDescripcionAsiento) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDescripcionAsiento(tipodescripcionasiento)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDescripcionAsiento tipodescripcionasiento) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodescripcionasiento.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDescripcionAsientoConstantesFunciones.getTipoDescripcionAsientoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodescripcionasiento","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDescripcionAsientoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDescripcionAsientoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDescripcionAsientoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-saveTipoDescripcionAsientoWithConnection");connexion.begin();			
			
			TipoDescripcionAsientoLogicAdditional.checkTipoDescripcionAsientoToSave(this.tipodescripcionasiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDescripcionAsientoLogicAdditional.updateTipoDescripcionAsientoToSave(this.tipodescripcionasiento,this.arrDatoGeneral);
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodescripcionasiento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDescripcionAsiento();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDescripcionAsiento(this.tipodescripcionasiento)) {
				TipoDescripcionAsientoDataAccess.save(this.tipodescripcionasiento, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodescripcionasiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDescripcionAsientoLogicAdditional.checkTipoDescripcionAsientoToSaveAfter(this.tipodescripcionasiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDescripcionAsiento();
			
			connexion.commit();			
			
			if(this.tipodescripcionasiento.getIsDeleted()) {
				this.tipodescripcionasiento=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDescripcionAsiento()throws Exception {	
		try {	
			
			TipoDescripcionAsientoLogicAdditional.checkTipoDescripcionAsientoToSave(this.tipodescripcionasiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDescripcionAsientoLogicAdditional.updateTipoDescripcionAsientoToSave(this.tipodescripcionasiento,this.arrDatoGeneral);
			
			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodescripcionasiento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDescripcionAsiento(this.tipodescripcionasiento)) {			
				TipoDescripcionAsientoDataAccess.save(this.tipodescripcionasiento, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodescripcionasiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDescripcionAsientoLogicAdditional.checkTipoDescripcionAsientoToSaveAfter(this.tipodescripcionasiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodescripcionasiento.getIsDeleted()) {
				this.tipodescripcionasiento=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDescripcionAsientosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-saveTipoDescripcionAsientosWithConnection");connexion.begin();			
			
			TipoDescripcionAsientoLogicAdditional.checkTipoDescripcionAsientoToSaves(tipodescripcionasientos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDescripcionAsientos();
			
			Boolean validadoTodosTipoDescripcionAsiento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDescripcionAsiento tipodescripcionasientoLocal:tipodescripcionasientos) {		
				if(tipodescripcionasientoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDescripcionAsientoLogicAdditional.updateTipoDescripcionAsientoToSave(tipodescripcionasientoLocal,this.arrDatoGeneral);
	        	
				TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodescripcionasientoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDescripcionAsiento(tipodescripcionasientoLocal)) {
					TipoDescripcionAsientoDataAccess.save(tipodescripcionasientoLocal, connexion);				
				} else {
					validadoTodosTipoDescripcionAsiento=false;
				}
			}
			
			if(!validadoTodosTipoDescripcionAsiento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDescripcionAsientoLogicAdditional.checkTipoDescripcionAsientoToSavesAfter(tipodescripcionasientos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDescripcionAsientos();
			
			connexion.commit();		
			
			this.quitarTipoDescripcionAsientosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDescripcionAsientos()throws Exception {				
		 try {	
			TipoDescripcionAsientoLogicAdditional.checkTipoDescripcionAsientoToSaves(tipodescripcionasientos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDescripcionAsiento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDescripcionAsiento tipodescripcionasientoLocal:tipodescripcionasientos) {				
				if(tipodescripcionasientoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDescripcionAsientoLogicAdditional.updateTipoDescripcionAsientoToSave(tipodescripcionasientoLocal,this.arrDatoGeneral);
	        	
				TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodescripcionasientoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDescripcionAsiento(tipodescripcionasientoLocal)) {				
					TipoDescripcionAsientoDataAccess.save(tipodescripcionasientoLocal, connexion);				
				} else {
					validadoTodosTipoDescripcionAsiento=false;
				}
			}
			
			if(!validadoTodosTipoDescripcionAsiento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDescripcionAsientoLogicAdditional.checkTipoDescripcionAsientoToSavesAfter(tipodescripcionasientos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDescripcionAsientosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDescripcionAsientoParameterReturnGeneral procesarAccionTipoDescripcionAsientos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDescripcionAsiento> tipodescripcionasientos,TipoDescripcionAsientoParameterReturnGeneral tipodescripcionasientoParameterGeneral)throws Exception {
		 try {	
			TipoDescripcionAsientoParameterReturnGeneral tipodescripcionasientoReturnGeneral=new TipoDescripcionAsientoParameterReturnGeneral();
	
			TipoDescripcionAsientoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodescripcionasientos,tipodescripcionasientoParameterGeneral,tipodescripcionasientoReturnGeneral);
			
			return tipodescripcionasientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDescripcionAsientoParameterReturnGeneral procesarAccionTipoDescripcionAsientosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDescripcionAsiento> tipodescripcionasientos,TipoDescripcionAsientoParameterReturnGeneral tipodescripcionasientoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-procesarAccionTipoDescripcionAsientosWithConnection");connexion.begin();			
			
			TipoDescripcionAsientoParameterReturnGeneral tipodescripcionasientoReturnGeneral=new TipoDescripcionAsientoParameterReturnGeneral();
	
			TipoDescripcionAsientoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodescripcionasientos,tipodescripcionasientoParameterGeneral,tipodescripcionasientoReturnGeneral);
			
			this.connexion.commit();
			
			return tipodescripcionasientoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDescripcionAsientoParameterReturnGeneral procesarEventosTipoDescripcionAsientos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDescripcionAsiento> tipodescripcionasientos,TipoDescripcionAsiento tipodescripcionasiento,TipoDescripcionAsientoParameterReturnGeneral tipodescripcionasientoParameterGeneral,Boolean isEsNuevoTipoDescripcionAsiento,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDescripcionAsientoParameterReturnGeneral tipodescripcionasientoReturnGeneral=new TipoDescripcionAsientoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodescripcionasientoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDescripcionAsientoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodescripcionasientos,tipodescripcionasiento,tipodescripcionasientoParameterGeneral,tipodescripcionasientoReturnGeneral,isEsNuevoTipoDescripcionAsiento,clases);
			
			return tipodescripcionasientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDescripcionAsientoParameterReturnGeneral procesarEventosTipoDescripcionAsientosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDescripcionAsiento> tipodescripcionasientos,TipoDescripcionAsiento tipodescripcionasiento,TipoDescripcionAsientoParameterReturnGeneral tipodescripcionasientoParameterGeneral,Boolean isEsNuevoTipoDescripcionAsiento,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-procesarEventosTipoDescripcionAsientosWithConnection");connexion.begin();			
			
			TipoDescripcionAsientoParameterReturnGeneral tipodescripcionasientoReturnGeneral=new TipoDescripcionAsientoParameterReturnGeneral();
	
			tipodescripcionasientoReturnGeneral.setTipoDescripcionAsiento(tipodescripcionasiento);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodescripcionasientoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDescripcionAsientoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodescripcionasientos,tipodescripcionasiento,tipodescripcionasientoParameterGeneral,tipodescripcionasientoReturnGeneral,isEsNuevoTipoDescripcionAsiento,clases);
			
			this.connexion.commit();
			
			return tipodescripcionasientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDescripcionAsientoParameterReturnGeneral procesarImportacionTipoDescripcionAsientosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDescripcionAsientoParameterReturnGeneral tipodescripcionasientoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-procesarImportacionTipoDescripcionAsientosWithConnection");connexion.begin();			
			
			TipoDescripcionAsientoParameterReturnGeneral tipodescripcionasientoReturnGeneral=new TipoDescripcionAsientoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodescripcionasientos=new ArrayList<TipoDescripcionAsiento>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodescripcionasiento=new TipoDescripcionAsiento();
				
				
				if(conColumnasBase) {this.tipodescripcionasiento.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodescripcionasiento.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodescripcionasiento.setcodigo(arrColumnas[iColumn++]);
				this.tipodescripcionasiento.setnombre(arrColumnas[iColumn++]);
				
				this.tipodescripcionasientos.add(this.tipodescripcionasiento);
			}
			
			this.saveTipoDescripcionAsientos();
			
			this.connexion.commit();
			
			tipodescripcionasientoReturnGeneral.setConRetornoEstaProcesado(true);
			tipodescripcionasientoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodescripcionasientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDescripcionAsientosEliminados() throws Exception {				
		
		List<TipoDescripcionAsiento> tipodescripcionasientosAux= new ArrayList<TipoDescripcionAsiento>();
		
		for(TipoDescripcionAsiento tipodescripcionasiento:tipodescripcionasientos) {
			if(!tipodescripcionasiento.getIsDeleted()) {
				tipodescripcionasientosAux.add(tipodescripcionasiento);
			}
		}
		
		tipodescripcionasientos=tipodescripcionasientosAux;
	}
	
	public void quitarTipoDescripcionAsientosNulos() throws Exception {				
		
		List<TipoDescripcionAsiento> tipodescripcionasientosAux= new ArrayList<TipoDescripcionAsiento>();
		
		for(TipoDescripcionAsiento tipodescripcionasiento : this.tipodescripcionasientos) {
			if(tipodescripcionasiento==null) {
				tipodescripcionasientosAux.add(tipodescripcionasiento);
			}
		}
		
		//this.tipodescripcionasientos=tipodescripcionasientosAux;
		
		this.tipodescripcionasientos.removeAll(tipodescripcionasientosAux);
	}
	
	public void getSetVersionRowTipoDescripcionAsientoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodescripcionasiento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodescripcionasiento.getIsDeleted() || (tipodescripcionasiento.getIsChanged()&&!tipodescripcionasiento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodescripcionasientoDataAccess.getSetVersionRowTipoDescripcionAsiento(connexion,tipodescripcionasiento.getId());
				
				if(!tipodescripcionasiento.getVersionRow().equals(timestamp)) {	
					tipodescripcionasiento.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodescripcionasiento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDescripcionAsiento()throws Exception {	
		
		if(tipodescripcionasiento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodescripcionasiento.getIsDeleted() || (tipodescripcionasiento.getIsChanged()&&!tipodescripcionasiento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodescripcionasientoDataAccess.getSetVersionRowTipoDescripcionAsiento(connexion,tipodescripcionasiento.getId());
			
			try {							
				if(!tipodescripcionasiento.getVersionRow().equals(timestamp)) {	
					tipodescripcionasiento.setVersionRow(timestamp);
				}
				
				tipodescripcionasiento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDescripcionAsientosWithConnection()throws Exception {	
		if(tipodescripcionasientos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDescripcionAsiento tipodescripcionasientoAux:tipodescripcionasientos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodescripcionasientoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodescripcionasientoAux.getIsDeleted() || (tipodescripcionasientoAux.getIsChanged()&&!tipodescripcionasientoAux.getIsNew())) {
						
						timestamp=tipodescripcionasientoDataAccess.getSetVersionRowTipoDescripcionAsiento(connexion,tipodescripcionasientoAux.getId());
						
						if(!tipodescripcionasiento.getVersionRow().equals(timestamp)) {	
							tipodescripcionasientoAux.setVersionRow(timestamp);
						}
								
						tipodescripcionasientoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDescripcionAsientos()throws Exception {	
		if(tipodescripcionasientos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDescripcionAsiento tipodescripcionasientoAux:tipodescripcionasientos) {
					if(tipodescripcionasientoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodescripcionasientoAux.getIsDeleted() || (tipodescripcionasientoAux.getIsChanged()&&!tipodescripcionasientoAux.getIsNew())) {
						
						timestamp=tipodescripcionasientoDataAccess.getSetVersionRowTipoDescripcionAsiento(connexion,tipodescripcionasientoAux.getId());
						
						if(!tipodescripcionasientoAux.getVersionRow().equals(timestamp)) {	
							tipodescripcionasientoAux.setVersionRow(timestamp);
						}
						
													
						tipodescripcionasientoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoDescripcionAsientoParameterReturnGeneral cargarCombosLoteForeignKeyTipoDescripcionAsientoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo) throws Exception {
		TipoDescripcionAsientoParameterReturnGeneral  tipodescripcionasientoReturnGeneral =new TipoDescripcionAsientoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoDescripcionAsientoWithConnection");connexion.begin();
			
			tipodescripcionasientoReturnGeneral =new TipoDescripcionAsientoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodescripcionasientoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipodescripcionasientoReturnGeneral.setmodulosForeignKey(modulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipodescripcionasientoReturnGeneral;
	}
	
	public TipoDescripcionAsientoParameterReturnGeneral cargarCombosLoteForeignKeyTipoDescripcionAsiento(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo) throws Exception {
		TipoDescripcionAsientoParameterReturnGeneral  tipodescripcionasientoReturnGeneral =new TipoDescripcionAsientoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipodescripcionasientoReturnGeneral =new TipoDescripcionAsientoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodescripcionasientoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipodescripcionasientoReturnGeneral.setmodulosForeignKey(modulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipodescripcionasientoReturnGeneral;
	}
	
	
	public void deepLoad(TipoDescripcionAsiento tipodescripcionasiento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoDescripcionAsientoLogicAdditional.updateTipoDescripcionAsientoToGet(tipodescripcionasiento,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodescripcionasiento.setEmpresa(tipodescripcionasientoDataAccess.getEmpresa(connexion,tipodescripcionasiento));
		tipodescripcionasiento.setModulo(tipodescripcionasientoDataAccess.getModulo(connexion,tipodescripcionasiento));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodescripcionasiento.setEmpresa(tipodescripcionasientoDataAccess.getEmpresa(connexion,tipodescripcionasiento));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				tipodescripcionasiento.setModulo(tipodescripcionasientoDataAccess.getModulo(connexion,tipodescripcionasiento));
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
			tipodescripcionasiento.setEmpresa(tipodescripcionasientoDataAccess.getEmpresa(connexion,tipodescripcionasiento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipodescripcionasiento.setModulo(tipodescripcionasientoDataAccess.getModulo(connexion,tipodescripcionasiento));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodescripcionasiento.setEmpresa(tipodescripcionasientoDataAccess.getEmpresa(connexion,tipodescripcionasiento));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodescripcionasiento.getEmpresa(),isDeep,deepLoadType,clases);
				
		tipodescripcionasiento.setModulo(tipodescripcionasientoDataAccess.getModulo(connexion,tipodescripcionasiento));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipodescripcionasiento.getModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodescripcionasiento.setEmpresa(tipodescripcionasientoDataAccess.getEmpresa(connexion,tipodescripcionasiento));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipodescripcionasiento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				tipodescripcionasiento.setModulo(tipodescripcionasientoDataAccess.getModulo(connexion,tipodescripcionasiento));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(tipodescripcionasiento.getModulo(),isDeep,deepLoadType,clases);				
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
			tipodescripcionasiento.setEmpresa(tipodescripcionasientoDataAccess.getEmpresa(connexion,tipodescripcionasiento));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipodescripcionasiento.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipodescripcionasiento.setModulo(tipodescripcionasientoDataAccess.getModulo(connexion,tipodescripcionasiento));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(tipodescripcionasiento.getModulo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDescripcionAsiento tipodescripcionasiento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoDescripcionAsientoLogicAdditional.updateTipoDescripcionAsientoToSave(tipodescripcionasiento,this.arrDatoGeneral);
			
TipoDescripcionAsientoDataAccess.save(tipodescripcionasiento, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodescripcionasiento.getEmpresa(),connexion);

		ModuloDataAccess.save(tipodescripcionasiento.getModulo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodescripcionasiento.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(tipodescripcionasiento.getModulo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodescripcionasiento.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodescripcionasiento.getEmpresa(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(tipodescripcionasiento.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipodescripcionasiento.getModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodescripcionasiento.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipodescripcionasiento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(tipodescripcionasiento.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(tipodescripcionasiento.getModulo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoDescripcionAsiento.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodescripcionasiento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(tipodescripcionasiento);
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
			this.deepLoad(this.tipodescripcionasiento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDescripcionAsiento.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodescripcionasientos!=null) {
				for(TipoDescripcionAsiento tipodescripcionasiento:tipodescripcionasientos) {
					this.deepLoad(tipodescripcionasiento,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(tipodescripcionasientos);
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
			if(tipodescripcionasientos!=null) {
				for(TipoDescripcionAsiento tipodescripcionasiento:tipodescripcionasientos) {
					this.deepLoad(tipodescripcionasiento,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(tipodescripcionasientos);
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
			this.getNewConnexionToDeep(TipoDescripcionAsiento.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipodescripcionasiento,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoDescripcionAsiento.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipodescripcionasientos!=null) {
				for(TipoDescripcionAsiento tipodescripcionasiento:tipodescripcionasientos) {
					this.deepSave(tipodescripcionasiento,isDeep,deepLoadType,clases);
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
			if(tipodescripcionasientos!=null) {
				for(TipoDescripcionAsiento tipodescripcionasiento:tipodescripcionasientos) {
					this.deepSave(tipodescripcionasiento,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoDescripcionAsientosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDescripcionAsientoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDescripcionAsientosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDescripcionAsientoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDescripcionAsientosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDescripcionAsiento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDescripcionAsientoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDescripcionAsientosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoDescripcionAsientoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoDescripcionAsientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodescripcionasientos=tipodescripcionasientoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDescripcionAsientoConstantesFunciones.refrescarForeignKeysDescripcionesTipoDescripcionAsiento(this.tipodescripcionasientos);
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
			if(TipoDescripcionAsientoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDescripcionAsientoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDescripcionAsiento tipodescripcionasiento,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDescripcionAsientoConstantesFunciones.ISCONAUDITORIA) {
				if(tipodescripcionasiento.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDescripcionAsientoDataAccess.TABLENAME, tipodescripcionasiento.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDescripcionAsientoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDescripcionAsientoLogic.registrarAuditoriaDetallesTipoDescripcionAsiento(connexion,tipodescripcionasiento,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodescripcionasiento.getIsDeleted()) {
					/*if(!tipodescripcionasiento.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDescripcionAsientoDataAccess.TABLENAME, tipodescripcionasiento.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDescripcionAsientoLogic.registrarAuditoriaDetallesTipoDescripcionAsiento(connexion,tipodescripcionasiento,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDescripcionAsientoDataAccess.TABLENAME, tipodescripcionasiento.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodescripcionasiento.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDescripcionAsientoDataAccess.TABLENAME, tipodescripcionasiento.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDescripcionAsientoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDescripcionAsientoLogic.registrarAuditoriaDetallesTipoDescripcionAsiento(connexion,tipodescripcionasiento,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDescripcionAsiento(Connexion connexion,TipoDescripcionAsiento tipodescripcionasiento)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodescripcionasiento.getIsNew()||!tipodescripcionasiento.getid_empresa().equals(tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getid_empresa().toString();
				}
				if(tipodescripcionasiento.getid_empresa()!=null)
				{
					strValorNuevo=tipodescripcionasiento.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDescripcionAsientoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipodescripcionasiento.getIsNew()||!tipodescripcionasiento.getid_modulo().equals(tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getid_modulo()!=null)
				{
					strValorActual=tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getid_modulo().toString();
				}
				if(tipodescripcionasiento.getid_modulo()!=null)
				{
					strValorNuevo=tipodescripcionasiento.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDescripcionAsientoConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(tipodescripcionasiento.getIsNew()||!tipodescripcionasiento.getcodigo().equals(tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getcodigo()!=null)
				{
					strValorActual=tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getcodigo();
				}
				if(tipodescripcionasiento.getcodigo()!=null)
				{
					strValorNuevo=tipodescripcionasiento.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDescripcionAsientoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipodescripcionasiento.getIsNew()||!tipodescripcionasiento.getnombre().equals(tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getnombre()!=null)
				{
					strValorActual=tipodescripcionasiento.getTipoDescripcionAsientoOriginal().getnombre();
				}
				if(tipodescripcionasiento.getnombre()!=null)
				{
					strValorNuevo=tipodescripcionasiento.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDescripcionAsientoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoDescripcionAsientoRelacionesWithConnection(TipoDescripcionAsiento tipodescripcionasiento) throws Exception {

		if(!tipodescripcionasiento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDescripcionAsientoRelacionesBase(tipodescripcionasiento,true);
		}
	}

	public void saveTipoDescripcionAsientoRelaciones(TipoDescripcionAsiento tipodescripcionasiento)throws Exception {

		if(!tipodescripcionasiento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDescripcionAsientoRelacionesBase(tipodescripcionasiento,false);
		}
	}

	public void saveTipoDescripcionAsientoRelacionesBase(TipoDescripcionAsiento tipodescripcionasiento,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoDescripcionAsiento-saveRelacionesWithConnection");}
	

			this.setTipoDescripcionAsiento(tipodescripcionasiento);

			if(TipoDescripcionAsientoLogicAdditional.validarSaveRelaciones(tipodescripcionasiento,this)) {

				TipoDescripcionAsientoLogicAdditional.updateRelacionesToSave(tipodescripcionasiento,this);

				if((tipodescripcionasiento.getIsNew()||tipodescripcionasiento.getIsChanged())&&!tipodescripcionasiento.getIsDeleted()) {
					this.saveTipoDescripcionAsiento();
					this.saveTipoDescripcionAsientoRelacionesDetalles();

				} else if(tipodescripcionasiento.getIsDeleted()) {
					this.saveTipoDescripcionAsientoRelacionesDetalles();
					this.saveTipoDescripcionAsiento();
				}

				TipoDescripcionAsientoLogicAdditional.updateRelacionesToSaveAfter(tipodescripcionasiento,this);

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
	
	
	private void saveTipoDescripcionAsientoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDescripcionAsiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDescripcionAsientoConstantesFunciones.getClassesForeignKeysOfTipoDescripcionAsiento(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDescripcionAsiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDescripcionAsientoConstantesFunciones.getClassesRelationshipsOfTipoDescripcionAsiento(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

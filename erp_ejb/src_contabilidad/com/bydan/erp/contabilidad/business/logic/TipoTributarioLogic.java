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
import com.bydan.erp.contabilidad.util.TipoTributarioConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoTributarioParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoTributarioParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoTributario;
import com.bydan.erp.contabilidad.business.logic.TipoTributarioLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoTributarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoTributarioLogic.class);
	
	protected TipoTributarioDataAccess tipotributarioDataAccess; 	
	protected TipoTributario tipotributario;
	protected List<TipoTributario> tipotributarios;
	protected Object tipotributarioObject;	
	protected List<Object> tipotributariosObject;
	
	public static ClassValidator<TipoTributario> tipotributarioValidator = new ClassValidator<TipoTributario>(TipoTributario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoTributarioLogicAdditional tipotributarioLogicAdditional=null;
	
	public TipoTributarioLogicAdditional getTipoTributarioLogicAdditional() {
		return this.tipotributarioLogicAdditional;
	}
	
	public void setTipoTributarioLogicAdditional(TipoTributarioLogicAdditional tipotributarioLogicAdditional) {
		try {
			this.tipotributarioLogicAdditional=tipotributarioLogicAdditional;
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
	
	
	
	
	public  TipoTributarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipotributarioDataAccess = new TipoTributarioDataAccess();
			
			this.tipotributarios= new ArrayList<TipoTributario>();
			this.tipotributario= new TipoTributario();
			
			this.tipotributarioObject=new Object();
			this.tipotributariosObject=new ArrayList<Object>();
				
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
			
			this.tipotributarioDataAccess.setConnexionType(this.connexionType);
			this.tipotributarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoTributarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipotributarioDataAccess = new TipoTributarioDataAccess();
			this.tipotributarios= new ArrayList<TipoTributario>();
			this.tipotributario= new TipoTributario();
			this.tipotributarioObject=new Object();
			this.tipotributariosObject=new ArrayList<Object>();
			
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
			
			this.tipotributarioDataAccess.setConnexionType(this.connexionType);
			this.tipotributarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoTributario getTipoTributario() throws Exception {	
		TipoTributarioLogicAdditional.checkTipoTributarioToGet(tipotributario,this.datosCliente,this.arrDatoGeneral);
		TipoTributarioLogicAdditional.updateTipoTributarioToGet(tipotributario,this.arrDatoGeneral);
		
		return tipotributario;
	}
		
	public void setTipoTributario(TipoTributario newTipoTributario) {
		this.tipotributario = newTipoTributario;
	}
	
	public TipoTributarioDataAccess getTipoTributarioDataAccess() {
		return tipotributarioDataAccess;
	}
	
	public void setTipoTributarioDataAccess(TipoTributarioDataAccess newtipotributarioDataAccess) {
		this.tipotributarioDataAccess = newtipotributarioDataAccess;
	}
	
	public List<TipoTributario> getTipoTributarios() throws Exception {		
		this.quitarTipoTributariosNulos();
		
		TipoTributarioLogicAdditional.checkTipoTributarioToGets(tipotributarios,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoTributario tipotributarioLocal: tipotributarios ) {
			TipoTributarioLogicAdditional.updateTipoTributarioToGet(tipotributarioLocal,this.arrDatoGeneral);
		}
		
		return tipotributarios;
	}
	
	public void setTipoTributarios(List<TipoTributario> newTipoTributarios) {
		this.tipotributarios = newTipoTributarios;
	}
	
	public Object getTipoTributarioObject() {	
		this.tipotributarioObject=this.tipotributarioDataAccess.getEntityObject();
		return this.tipotributarioObject;
	}
		
	public void setTipoTributarioObject(Object newTipoTributarioObject) {
		this.tipotributarioObject = newTipoTributarioObject;
	}
	
	public List<Object> getTipoTributariosObject() {		
		this.tipotributariosObject=this.tipotributarioDataAccess.getEntitiesObject();
		return this.tipotributariosObject;
	}
		
	public void setTipoTributariosObject(List<Object> newTipoTributariosObject) {
		this.tipotributariosObject = newTipoTributariosObject;
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
		
		if(this.tipotributarioDataAccess!=null) {
			this.tipotributarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipotributarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipotributarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipotributario = new  TipoTributario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipotributario=tipotributarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotributario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributario);
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
		tipotributario = new  TipoTributario();
		  		  
        try {
			
			tipotributario=tipotributarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotributario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipotributario = new  TipoTributario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipotributario=tipotributarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotributario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributario);
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
		tipotributario = new  TipoTributario();
		  		  
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
		tipotributario = new  TipoTributario();
		  		  
        try {
			
			tipotributario=tipotributarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotributario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipotributario = new  TipoTributario();
		  		  
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
		tipotributario = new  TipoTributario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipotributarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotributario = new  TipoTributario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipotributarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipotributario = new  TipoTributario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipotributarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotributario = new  TipoTributario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipotributarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipotributario = new  TipoTributario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipotributarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotributario = new  TipoTributario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipotributarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipotributarios = new  ArrayList<TipoTributario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributarios=tipotributarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTributario(tipotributarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
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
		tipotributarios = new  ArrayList<TipoTributario>();
		  		  
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
		tipotributarios = new  ArrayList<TipoTributario>();
		  		  
        try {			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributarios=tipotributarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoTributario(tipotributarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipotributarios = new  ArrayList<TipoTributario>();
		  		  
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
		tipotributarios = new  ArrayList<TipoTributario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributarios=tipotributarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTributario(tipotributarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
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
		tipotributarios = new  ArrayList<TipoTributario>();
		  		  
        try {
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributarios=tipotributarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTributario(tipotributarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
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
		tipotributarios = new  ArrayList<TipoTributario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributarios=tipotributarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTributario(tipotributarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
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
		tipotributarios = new  ArrayList<TipoTributario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributarios=tipotributarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTributario(tipotributarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipotributario = new  TipoTributario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributario=tipotributarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTributario(tipotributario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributario);
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
		tipotributario = new  TipoTributario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributario=tipotributarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTributario(tipotributario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipotributarios = new  ArrayList<TipoTributario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributarios=tipotributarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTributario(tipotributarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
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
		tipotributarios = new  ArrayList<TipoTributario>();
		  		  
        try {
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributarios=tipotributarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTributario(tipotributarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoTributariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipotributarios = new  ArrayList<TipoTributario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getTodosTipoTributariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributarios=tipotributarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTributario(tipotributarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
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
	
	public  void  getTodosTipoTributarios(String sFinalQuery,Pagination pagination)throws Exception {
		tipotributarios = new  ArrayList<TipoTributario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotributarios=tipotributarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTributario(tipotributarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoTributario(TipoTributario tipotributario) throws Exception {
		Boolean estaValidado=false;
		
		if(tipotributario.getIsNew() || tipotributario.getIsChanged()) { 
			this.invalidValues = tipotributarioValidator.getInvalidValues(tipotributario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipotributario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoTributario(List<TipoTributario> TipoTributarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoTributario tipotributarioLocal:tipotributarios) {				
			estaValidadoObjeto=this.validarGuardarTipoTributario(tipotributarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoTributario(List<TipoTributario> TipoTributarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTributario(tipotributarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoTributario(TipoTributario TipoTributario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTributario(tipotributario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoTributario tipotributario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipotributario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoTributarioConstantesFunciones.getTipoTributarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipotributario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoTributarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoTributarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoTributarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-saveTipoTributarioWithConnection");connexion.begin();			
			
			TipoTributarioLogicAdditional.checkTipoTributarioToSave(this.tipotributario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoTributarioLogicAdditional.updateTipoTributarioToSave(this.tipotributario,this.arrDatoGeneral);
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipotributario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoTributario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTributario(this.tipotributario)) {
				TipoTributarioDataAccess.save(this.tipotributario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipotributario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoTributarioLogicAdditional.checkTipoTributarioToSaveAfter(this.tipotributario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTributario();
			
			connexion.commit();			
			
			if(this.tipotributario.getIsDeleted()) {
				this.tipotributario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoTributario()throws Exception {	
		try {	
			
			TipoTributarioLogicAdditional.checkTipoTributarioToSave(this.tipotributario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoTributarioLogicAdditional.updateTipoTributarioToSave(this.tipotributario,this.arrDatoGeneral);
			
			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipotributario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTributario(this.tipotributario)) {			
				TipoTributarioDataAccess.save(this.tipotributario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipotributario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoTributarioLogicAdditional.checkTipoTributarioToSaveAfter(this.tipotributario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipotributario.getIsDeleted()) {
				this.tipotributario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoTributariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-saveTipoTributariosWithConnection");connexion.begin();			
			
			TipoTributarioLogicAdditional.checkTipoTributarioToSaves(tipotributarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoTributarios();
			
			Boolean validadoTodosTipoTributario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTributario tipotributarioLocal:tipotributarios) {		
				if(tipotributarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoTributarioLogicAdditional.updateTipoTributarioToSave(tipotributarioLocal,this.arrDatoGeneral);
	        	
				TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipotributarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTributario(tipotributarioLocal)) {
					TipoTributarioDataAccess.save(tipotributarioLocal, connexion);				
				} else {
					validadoTodosTipoTributario=false;
				}
			}
			
			if(!validadoTodosTipoTributario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoTributarioLogicAdditional.checkTipoTributarioToSavesAfter(tipotributarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTributarios();
			
			connexion.commit();		
			
			this.quitarTipoTributariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoTributarios()throws Exception {				
		 try {	
			TipoTributarioLogicAdditional.checkTipoTributarioToSaves(tipotributarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoTributario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTributario tipotributarioLocal:tipotributarios) {				
				if(tipotributarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoTributarioLogicAdditional.updateTipoTributarioToSave(tipotributarioLocal,this.arrDatoGeneral);
	        	
				TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipotributarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTributario(tipotributarioLocal)) {				
					TipoTributarioDataAccess.save(tipotributarioLocal, connexion);				
				} else {
					validadoTodosTipoTributario=false;
				}
			}
			
			if(!validadoTodosTipoTributario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoTributarioLogicAdditional.checkTipoTributarioToSavesAfter(tipotributarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoTributariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTributarioParameterReturnGeneral procesarAccionTipoTributarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTributario> tipotributarios,TipoTributarioParameterReturnGeneral tipotributarioParameterGeneral)throws Exception {
		 try {	
			TipoTributarioParameterReturnGeneral tipotributarioReturnGeneral=new TipoTributarioParameterReturnGeneral();
	
			TipoTributarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipotributarios,tipotributarioParameterGeneral,tipotributarioReturnGeneral);
			
			return tipotributarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTributarioParameterReturnGeneral procesarAccionTipoTributariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTributario> tipotributarios,TipoTributarioParameterReturnGeneral tipotributarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-procesarAccionTipoTributariosWithConnection");connexion.begin();			
			
			TipoTributarioParameterReturnGeneral tipotributarioReturnGeneral=new TipoTributarioParameterReturnGeneral();
	
			TipoTributarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipotributarios,tipotributarioParameterGeneral,tipotributarioReturnGeneral);
			
			this.connexion.commit();
			
			return tipotributarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTributarioParameterReturnGeneral procesarEventosTipoTributarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTributario> tipotributarios,TipoTributario tipotributario,TipoTributarioParameterReturnGeneral tipotributarioParameterGeneral,Boolean isEsNuevoTipoTributario,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoTributarioParameterReturnGeneral tipotributarioReturnGeneral=new TipoTributarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipotributarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoTributarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipotributarios,tipotributario,tipotributarioParameterGeneral,tipotributarioReturnGeneral,isEsNuevoTipoTributario,clases);
			
			return tipotributarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoTributarioParameterReturnGeneral procesarEventosTipoTributariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTributario> tipotributarios,TipoTributario tipotributario,TipoTributarioParameterReturnGeneral tipotributarioParameterGeneral,Boolean isEsNuevoTipoTributario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-procesarEventosTipoTributariosWithConnection");connexion.begin();			
			
			TipoTributarioParameterReturnGeneral tipotributarioReturnGeneral=new TipoTributarioParameterReturnGeneral();
	
			tipotributarioReturnGeneral.setTipoTributario(tipotributario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipotributarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoTributarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipotributarios,tipotributario,tipotributarioParameterGeneral,tipotributarioReturnGeneral,isEsNuevoTipoTributario,clases);
			
			this.connexion.commit();
			
			return tipotributarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTributarioParameterReturnGeneral procesarImportacionTipoTributariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoTributarioParameterReturnGeneral tipotributarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-procesarImportacionTipoTributariosWithConnection");connexion.begin();			
			
			TipoTributarioParameterReturnGeneral tipotributarioReturnGeneral=new TipoTributarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipotributarios=new ArrayList<TipoTributario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipotributario=new TipoTributario();
				
				
				if(conColumnasBase) {this.tipotributario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipotributario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipotributario.setcodigo(arrColumnas[iColumn++]);
				this.tipotributario.setnombre(arrColumnas[iColumn++]);
				
				this.tipotributarios.add(this.tipotributario);
			}
			
			this.saveTipoTributarios();
			
			this.connexion.commit();
			
			tipotributarioReturnGeneral.setConRetornoEstaProcesado(true);
			tipotributarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipotributarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoTributariosEliminados() throws Exception {				
		
		List<TipoTributario> tipotributariosAux= new ArrayList<TipoTributario>();
		
		for(TipoTributario tipotributario:tipotributarios) {
			if(!tipotributario.getIsDeleted()) {
				tipotributariosAux.add(tipotributario);
			}
		}
		
		tipotributarios=tipotributariosAux;
	}
	
	public void quitarTipoTributariosNulos() throws Exception {				
		
		List<TipoTributario> tipotributariosAux= new ArrayList<TipoTributario>();
		
		for(TipoTributario tipotributario : this.tipotributarios) {
			if(tipotributario==null) {
				tipotributariosAux.add(tipotributario);
			}
		}
		
		//this.tipotributarios=tipotributariosAux;
		
		this.tipotributarios.removeAll(tipotributariosAux);
	}
	
	public void getSetVersionRowTipoTributarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipotributario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipotributario.getIsDeleted() || (tipotributario.getIsChanged()&&!tipotributario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipotributarioDataAccess.getSetVersionRowTipoTributario(connexion,tipotributario.getId());
				
				if(!tipotributario.getVersionRow().equals(timestamp)) {	
					tipotributario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipotributario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoTributario()throws Exception {	
		
		if(tipotributario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipotributario.getIsDeleted() || (tipotributario.getIsChanged()&&!tipotributario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipotributarioDataAccess.getSetVersionRowTipoTributario(connexion,tipotributario.getId());
			
			try {							
				if(!tipotributario.getVersionRow().equals(timestamp)) {	
					tipotributario.setVersionRow(timestamp);
				}
				
				tipotributario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoTributariosWithConnection()throws Exception {	
		if(tipotributarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoTributario tipotributarioAux:tipotributarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipotributarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipotributarioAux.getIsDeleted() || (tipotributarioAux.getIsChanged()&&!tipotributarioAux.getIsNew())) {
						
						timestamp=tipotributarioDataAccess.getSetVersionRowTipoTributario(connexion,tipotributarioAux.getId());
						
						if(!tipotributario.getVersionRow().equals(timestamp)) {	
							tipotributarioAux.setVersionRow(timestamp);
						}
								
						tipotributarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoTributarios()throws Exception {	
		if(tipotributarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoTributario tipotributarioAux:tipotributarios) {
					if(tipotributarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipotributarioAux.getIsDeleted() || (tipotributarioAux.getIsChanged()&&!tipotributarioAux.getIsNew())) {
						
						timestamp=tipotributarioDataAccess.getSetVersionRowTipoTributario(connexion,tipotributarioAux.getId());
						
						if(!tipotributarioAux.getVersionRow().equals(timestamp)) {	
							tipotributarioAux.setVersionRow(timestamp);
						}
						
													
						tipotributarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoTributarioParameterReturnGeneral cargarCombosLoteForeignKeyTipoTributarioWithConnection(String finalQueryGlobalPais) throws Exception {
		TipoTributarioParameterReturnGeneral  tipotributarioReturnGeneral =new TipoTributarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoTributarioWithConnection");connexion.begin();
			
			tipotributarioReturnGeneral =new TipoTributarioParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipotributarioReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipotributarioReturnGeneral;
	}
	
	public TipoTributarioParameterReturnGeneral cargarCombosLoteForeignKeyTipoTributario(String finalQueryGlobalPais) throws Exception {
		TipoTributarioParameterReturnGeneral  tipotributarioReturnGeneral =new TipoTributarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipotributarioReturnGeneral =new TipoTributarioParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipotributarioReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipotributarioReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoTributarioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TransaccionLocalLogic transaccionlocalLogic=new TransaccionLocalLogic();
			FacturaProveedorServicioLogic facturaproveedorservicioLogic=new FacturaProveedorServicioLogic();
			DefinicionLogic definicionLogic=new DefinicionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoTributarioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TransaccionLocal.class));
			classes.add(new Classe(FacturaProveedorServicio.class));
			classes.add(new Classe(Definicion.class));
											
			

			transaccionlocalLogic.setConnexion(this.getConnexion());
			transaccionlocalLogic.setDatosCliente(this.datosCliente);
			transaccionlocalLogic.setIsConRefrescarForeignKeys(true);

			facturaproveedorservicioLogic.setConnexion(this.getConnexion());
			facturaproveedorservicioLogic.setDatosCliente(this.datosCliente);
			facturaproveedorservicioLogic.setIsConRefrescarForeignKeys(true);

			definicionLogic.setConnexion(this.getConnexion());
			definicionLogic.setDatosCliente(this.datosCliente);
			definicionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoTributario tipotributario:this.tipotributarios) {
				

				classes=new ArrayList<Classe>();
				classes=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);

				transaccionlocalLogic.setTransaccionLocals(tipotributario.transaccionlocals);
				transaccionlocalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FacturaProveedorServicioConstantesFunciones.getClassesForeignKeysOfFacturaProveedorServicio(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturaproveedorservicioLogic.setFacturaProveedorServicios(tipotributario.facturaproveedorservicios);
				facturaproveedorservicioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);

				definicionLogic.setDefinicions(tipotributario.definicions);
				definicionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoTributario tipotributario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoTributarioLogicAdditional.updateTipoTributarioToGet(tipotributario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipotributario.setPais(tipotributarioDataAccess.getPais(connexion,tipotributario));
		tipotributario.setTransaccionLocals(tipotributarioDataAccess.getTransaccionLocals(connexion,tipotributario));
		tipotributario.setFacturaProveedorServicios(tipotributarioDataAccess.getFacturaProveedorServicios(connexion,tipotributario));
		tipotributario.setDefinicions(tipotributarioDataAccess.getDefinicions(connexion,tipotributario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipotributario.setPais(tipotributarioDataAccess.getPais(connexion,tipotributario));
				continue;
			}

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipotributario.setTransaccionLocals(tipotributarioDataAccess.getTransaccionLocals(connexion,tipotributario));

				if(this.isConDeep) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(this.connexion);
					transaccionlocalLogic.setTransaccionLocals(tipotributario.getTransaccionLocals());
					ArrayList<Classe> classesLocal=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);
					transaccionlocalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(transaccionlocalLogic.getTransaccionLocals());
					tipotributario.setTransaccionLocals(transaccionlocalLogic.getTransaccionLocals());
				}

				continue;
			}

			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipotributario.setFacturaProveedorServicios(tipotributarioDataAccess.getFacturaProveedorServicios(connexion,tipotributario));

				if(this.isConDeep) {
					FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(this.connexion);
					facturaproveedorservicioLogic.setFacturaProveedorServicios(tipotributario.getFacturaProveedorServicios());
					ArrayList<Classe> classesLocal=FacturaProveedorServicioConstantesFunciones.getClassesForeignKeysOfFacturaProveedorServicio(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturaproveedorservicioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(facturaproveedorservicioLogic.getFacturaProveedorServicios());
					tipotributario.setFacturaProveedorServicios(facturaproveedorservicioLogic.getFacturaProveedorServicios());
				}

				continue;
			}

			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipotributario.setDefinicions(tipotributarioDataAccess.getDefinicions(connexion,tipotributario));

				if(this.isConDeep) {
					DefinicionLogic definicionLogic= new DefinicionLogic(this.connexion);
					definicionLogic.setDefinicions(tipotributario.getDefinicions());
					ArrayList<Classe> classesLocal=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);
					definicionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(definicionLogic.getDefinicions());
					tipotributario.setDefinicions(definicionLogic.getDefinicions());
				}

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
			tipotributario.setPais(tipotributarioDataAccess.getPais(connexion,tipotributario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			tipotributario.setTransaccionLocals(tipotributarioDataAccess.getTransaccionLocals(connexion,tipotributario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaProveedorServicio.class));
			tipotributario.setFacturaProveedorServicios(tipotributarioDataAccess.getFacturaProveedorServicios(connexion,tipotributario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Definicion.class));
			tipotributario.setDefinicions(tipotributarioDataAccess.getDefinicions(connexion,tipotributario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipotributario.setPais(tipotributarioDataAccess.getPais(connexion,tipotributario));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tipotributario.getPais(),isDeep,deepLoadType,clases);
				

		tipotributario.setTransaccionLocals(tipotributarioDataAccess.getTransaccionLocals(connexion,tipotributario));

		for(TransaccionLocal transaccionlocal:tipotributario.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
		}

		tipotributario.setFacturaProveedorServicios(tipotributarioDataAccess.getFacturaProveedorServicios(connexion,tipotributario));

		for(FacturaProveedorServicio facturaproveedorservicio:tipotributario.getFacturaProveedorServicios()) {
			FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(connexion);
			facturaproveedorservicioLogic.deepLoad(facturaproveedorservicio,isDeep,deepLoadType,clases);
		}

		tipotributario.setDefinicions(tipotributarioDataAccess.getDefinicions(connexion,tipotributario));

		for(Definicion definicion:tipotributario.getDefinicions()) {
			DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
			definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipotributario.setPais(tipotributarioDataAccess.getPais(connexion,tipotributario));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(tipotributario.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipotributario.setTransaccionLocals(tipotributarioDataAccess.getTransaccionLocals(connexion,tipotributario));

				for(TransaccionLocal transaccionlocal:tipotributario.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipotributario.setFacturaProveedorServicios(tipotributarioDataAccess.getFacturaProveedorServicios(connexion,tipotributario));

				for(FacturaProveedorServicio facturaproveedorservicio:tipotributario.getFacturaProveedorServicios()) {
					FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(connexion);
					facturaproveedorservicioLogic.deepLoad(facturaproveedorservicio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipotributario.setDefinicions(tipotributarioDataAccess.getDefinicions(connexion,tipotributario));

				for(Definicion definicion:tipotributario.getDefinicions()) {
					DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
					definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
				}
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
			tipotributario.setPais(tipotributarioDataAccess.getPais(connexion,tipotributario));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(tipotributario.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			tipotributario.setTransaccionLocals(tipotributarioDataAccess.getTransaccionLocals(connexion,tipotributario));

			for(TransaccionLocal transaccionlocal:tipotributario.getTransaccionLocals()) {
				TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
				transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaProveedorServicio.class));
			tipotributario.setFacturaProveedorServicios(tipotributarioDataAccess.getFacturaProveedorServicios(connexion,tipotributario));

			for(FacturaProveedorServicio facturaproveedorservicio:tipotributario.getFacturaProveedorServicios()) {
				FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(connexion);
				facturaproveedorservicioLogic.deepLoad(facturaproveedorservicio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Definicion.class));
			tipotributario.setDefinicions(tipotributarioDataAccess.getDefinicions(connexion,tipotributario));

			for(Definicion definicion:tipotributario.getDefinicions()) {
				DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
				definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoTributario tipotributario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoTributarioLogicAdditional.updateTipoTributarioToSave(tipotributario,this.arrDatoGeneral);
			
TipoTributarioDataAccess.save(tipotributario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(tipotributario.getPais(),connexion);

		for(TransaccionLocal transaccionlocal:tipotributario.getTransaccionLocals()) {
			transaccionlocal.setid_tipo_tributario(tipotributario.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
		}

		for(FacturaProveedorServicio facturaproveedorservicio:tipotributario.getFacturaProveedorServicios()) {
			facturaproveedorservicio.setid_tipo_tributario(tipotributario.getId());
			FacturaProveedorServicioDataAccess.save(facturaproveedorservicio,connexion);
		}

		for(Definicion definicion:tipotributario.getDefinicions()) {
			definicion.setid_tipo_tributario(tipotributario.getId());
			DefinicionDataAccess.save(definicion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(tipotributario.getPais(),connexion);
				continue;
			}


			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:tipotributario.getTransaccionLocals()) {
					transaccionlocal.setid_tipo_tributario(tipotributario.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaProveedorServicio facturaproveedorservicio:tipotributario.getFacturaProveedorServicios()) {
					facturaproveedorservicio.setid_tipo_tributario(tipotributario.getId());
					FacturaProveedorServicioDataAccess.save(facturaproveedorservicio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Definicion definicion:tipotributario.getDefinicions()) {
					definicion.setid_tipo_tributario(tipotributario.getId());
					DefinicionDataAccess.save(definicion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(tipotributario.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tipotributario.getPais(),isDeep,deepLoadType,clases);
				

		for(TransaccionLocal transaccionlocal:tipotributario.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocal.setid_tipo_tributario(tipotributario.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
			transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
		}

		for(FacturaProveedorServicio facturaproveedorservicio:tipotributario.getFacturaProveedorServicios()) {
			FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(connexion);
			facturaproveedorservicio.setid_tipo_tributario(tipotributario.getId());
			FacturaProveedorServicioDataAccess.save(facturaproveedorservicio,connexion);
			facturaproveedorservicioLogic.deepSave(facturaproveedorservicio,isDeep,deepLoadType,clases);
		}

		for(Definicion definicion:tipotributario.getDefinicions()) {
			DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
			definicion.setid_tipo_tributario(tipotributario.getId());
			DefinicionDataAccess.save(definicion,connexion);
			definicionLogic.deepSave(definicion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(tipotributario.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(tipotributario.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:tipotributario.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocal.setid_tipo_tributario(tipotributario.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
					transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaProveedorServicio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaProveedorServicio facturaproveedorservicio:tipotributario.getFacturaProveedorServicios()) {
					FacturaProveedorServicioLogic facturaproveedorservicioLogic= new FacturaProveedorServicioLogic(connexion);
					facturaproveedorservicio.setid_tipo_tributario(tipotributario.getId());
					FacturaProveedorServicioDataAccess.save(facturaproveedorservicio,connexion);
					facturaproveedorservicioLogic.deepSave(facturaproveedorservicio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Definicion definicion:tipotributario.getDefinicions()) {
					DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
					definicion.setid_tipo_tributario(tipotributario.getId());
					DefinicionDataAccess.save(definicion,connexion);
					definicionLogic.deepSave(definicion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoTributario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipotributario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(tipotributario);
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
			this.deepLoad(this.tipotributario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoTributario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipotributarios!=null) {
				for(TipoTributario tipotributario:tipotributarios) {
					this.deepLoad(tipotributario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(tipotributarios);
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
			if(tipotributarios!=null) {
				for(TipoTributario tipotributario:tipotributarios) {
					this.deepLoad(tipotributario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(tipotributarios);
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
			this.getNewConnexionToDeep(TipoTributario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipotributario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoTributario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipotributarios!=null) {
				for(TipoTributario tipotributario:tipotributarios) {
					this.deepSave(tipotributario,isDeep,deepLoadType,clases);
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
			if(tipotributarios!=null) {
				for(TipoTributario tipotributario:tipotributarios) {
					this.deepSave(tipotributario,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoTributariosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoTributarioConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotributarios=tipotributarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTributariosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoTributarioConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotributarios=tipotributarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoTributariosBusquedaPorIdWithConnection(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoTributarioConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotributarios=tipotributarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTributariosBusquedaPorId(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoTributarioConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotributarios=tipotributarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoTributariosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoTributarioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotributarios=tipotributarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTributariosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoTributarioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotributarios=tipotributarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoTributariosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoTributarioConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotributarios=tipotributarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTributariosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoTributarioConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoTributarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipotributarios=tipotributarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoTributarioPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTributario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,TipoTributarioConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			tipotributario=tipotributarioDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipotributario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributario);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoTributarioPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,TipoTributarioConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			tipotributario=tipotributarioDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipotributario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoTributarioConstantesFunciones.refrescarForeignKeysDescripcionesTipoTributario(this.tipotributario);
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
			if(TipoTributarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTributarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoTributario tipotributario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoTributarioConstantesFunciones.ISCONAUDITORIA) {
				if(tipotributario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTributarioDataAccess.TABLENAME, tipotributario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTributarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTributarioLogic.registrarAuditoriaDetallesTipoTributario(connexion,tipotributario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipotributario.getIsDeleted()) {
					/*if(!tipotributario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoTributarioDataAccess.TABLENAME, tipotributario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoTributarioLogic.registrarAuditoriaDetallesTipoTributario(connexion,tipotributario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTributarioDataAccess.TABLENAME, tipotributario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipotributario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTributarioDataAccess.TABLENAME, tipotributario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTributarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTributarioLogic.registrarAuditoriaDetallesTipoTributario(connexion,tipotributario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoTributario(Connexion connexion,TipoTributario tipotributario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipotributario.getIsNew()||!tipotributario.getid_pais().equals(tipotributario.getTipoTributarioOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotributario.getTipoTributarioOriginal().getid_pais()!=null)
				{
					strValorActual=tipotributario.getTipoTributarioOriginal().getid_pais().toString();
				}
				if(tipotributario.getid_pais()!=null)
				{
					strValorNuevo=tipotributario.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTributarioConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(tipotributario.getIsNew()||!tipotributario.getcodigo().equals(tipotributario.getTipoTributarioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotributario.getTipoTributarioOriginal().getcodigo()!=null)
				{
					strValorActual=tipotributario.getTipoTributarioOriginal().getcodigo();
				}
				if(tipotributario.getcodigo()!=null)
				{
					strValorNuevo=tipotributario.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTributarioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipotributario.getIsNew()||!tipotributario.getnombre().equals(tipotributario.getTipoTributarioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotributario.getTipoTributarioOriginal().getnombre()!=null)
				{
					strValorActual=tipotributario.getTipoTributarioOriginal().getnombre();
				}
				if(tipotributario.getnombre()!=null)
				{
					strValorNuevo=tipotributario.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTributarioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoTributarioRelacionesWithConnection(TipoTributario tipotributario,List<TransaccionLocal> transaccionlocals,List<FacturaProveedorServicio> facturaproveedorservicios,List<Definicion> definicions) throws Exception {

		if(!tipotributario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoTributarioRelacionesBase(tipotributario,transaccionlocals,facturaproveedorservicios,definicions,true);
		}
	}

	public void saveTipoTributarioRelaciones(TipoTributario tipotributario,List<TransaccionLocal> transaccionlocals,List<FacturaProveedorServicio> facturaproveedorservicios,List<Definicion> definicions)throws Exception {

		if(!tipotributario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoTributarioRelacionesBase(tipotributario,transaccionlocals,facturaproveedorservicios,definicions,false);
		}
	}

	public void saveTipoTributarioRelacionesBase(TipoTributario tipotributario,List<TransaccionLocal> transaccionlocals,List<FacturaProveedorServicio> facturaproveedorservicios,List<Definicion> definicions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoTributario-saveRelacionesWithConnection");}
	
			tipotributario.setTransaccionLocals(transaccionlocals);
			tipotributario.setFacturaProveedorServicios(facturaproveedorservicios);
			tipotributario.setDefinicions(definicions);

			this.setTipoTributario(tipotributario);

			if(TipoTributarioLogicAdditional.validarSaveRelaciones(tipotributario,this)) {

				TipoTributarioLogicAdditional.updateRelacionesToSave(tipotributario,this);

				if((tipotributario.getIsNew()||tipotributario.getIsChanged())&&!tipotributario.getIsDeleted()) {
					this.saveTipoTributario();
					this.saveTipoTributarioRelacionesDetalles(transaccionlocals,facturaproveedorservicios,definicions);

				} else if(tipotributario.getIsDeleted()) {
					this.saveTipoTributarioRelacionesDetalles(transaccionlocals,facturaproveedorservicios,definicions);
					this.saveTipoTributario();
				}

				TipoTributarioLogicAdditional.updateRelacionesToSaveAfter(tipotributario,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TransaccionLocalConstantesFunciones.InicializarGeneralEntityAuxiliaresTransaccionLocals(transaccionlocals,true,true);
			FacturaProveedorServicioConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturaProveedorServicios(facturaproveedorservicios,true,true);
			DefinicionConstantesFunciones.InicializarGeneralEntityAuxiliaresDefinicions(definicions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoTributarioRelacionesDetalles(List<TransaccionLocal> transaccionlocals,List<FacturaProveedorServicio> facturaproveedorservicios,List<Definicion> definicions)throws Exception {
		try {
	

			Long idTipoTributarioActual=this.getTipoTributario().getId();

			TransaccionLocalLogic transaccionlocalLogic_Desde_TipoTributario=new TransaccionLocalLogic();
			transaccionlocalLogic_Desde_TipoTributario.setTransaccionLocals(transaccionlocals);

			transaccionlocalLogic_Desde_TipoTributario.setConnexion(this.getConnexion());
			transaccionlocalLogic_Desde_TipoTributario.setDatosCliente(this.datosCliente);

			for(TransaccionLocal transaccionlocal_Desde_TipoTributario:transaccionlocalLogic_Desde_TipoTributario.getTransaccionLocals()) {
				transaccionlocal_Desde_TipoTributario.setid_tipo_tributario(idTipoTributarioActual);
			}

			transaccionlocalLogic_Desde_TipoTributario.saveTransaccionLocals();

			FacturaProveedorServicioLogic facturaproveedorservicioLogic_Desde_TipoTributario=new FacturaProveedorServicioLogic();
			facturaproveedorservicioLogic_Desde_TipoTributario.setFacturaProveedorServicios(facturaproveedorservicios);

			facturaproveedorservicioLogic_Desde_TipoTributario.setConnexion(this.getConnexion());
			facturaproveedorservicioLogic_Desde_TipoTributario.setDatosCliente(this.datosCliente);

			for(FacturaProveedorServicio facturaproveedorservicio_Desde_TipoTributario:facturaproveedorservicioLogic_Desde_TipoTributario.getFacturaProveedorServicios()) {
				facturaproveedorservicio_Desde_TipoTributario.setid_tipo_tributario(idTipoTributarioActual);
			}

			facturaproveedorservicioLogic_Desde_TipoTributario.saveFacturaProveedorServicios();

			DefinicionLogic definicionLogic_Desde_TipoTributario=new DefinicionLogic();
			definicionLogic_Desde_TipoTributario.setDefinicions(definicions);

			definicionLogic_Desde_TipoTributario.setConnexion(this.getConnexion());
			definicionLogic_Desde_TipoTributario.setDatosCliente(this.datosCliente);

			for(Definicion definicion_Desde_TipoTributario:definicionLogic_Desde_TipoTributario.getDefinicions()) {
				definicion_Desde_TipoTributario.setid_tipo_tributario(idTipoTributarioActual);
			}

			definicionLogic_Desde_TipoTributario.saveDefinicions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTributario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTributarioConstantesFunciones.getClassesForeignKeysOfTipoTributario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTributario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTributarioConstantesFunciones.getClassesRelationshipsOfTipoTributario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

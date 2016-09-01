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
import com.bydan.erp.inventario.util.TipoPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.TipoPrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoPrecioParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoPrecio;
import com.bydan.erp.inventario.business.logic.TipoPrecioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoPrecioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoPrecioLogic.class);
	
	protected TipoPrecioDataAccess tipoprecioDataAccess; 	
	protected TipoPrecio tipoprecio;
	protected List<TipoPrecio> tipoprecios;
	protected Object tipoprecioObject;	
	protected List<Object> tipopreciosObject;
	
	public static ClassValidator<TipoPrecio> tipoprecioValidator = new ClassValidator<TipoPrecio>(TipoPrecio.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoPrecioLogicAdditional tipoprecioLogicAdditional=null;
	
	public TipoPrecioLogicAdditional getTipoPrecioLogicAdditional() {
		return this.tipoprecioLogicAdditional;
	}
	
	public void setTipoPrecioLogicAdditional(TipoPrecioLogicAdditional tipoprecioLogicAdditional) {
		try {
			this.tipoprecioLogicAdditional=tipoprecioLogicAdditional;
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
	
	
	
	
	public  TipoPrecioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoprecioDataAccess = new TipoPrecioDataAccess();
			
			this.tipoprecios= new ArrayList<TipoPrecio>();
			this.tipoprecio= new TipoPrecio();
			
			this.tipoprecioObject=new Object();
			this.tipopreciosObject=new ArrayList<Object>();
				
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
			
			this.tipoprecioDataAccess.setConnexionType(this.connexionType);
			this.tipoprecioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoPrecioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoprecioDataAccess = new TipoPrecioDataAccess();
			this.tipoprecios= new ArrayList<TipoPrecio>();
			this.tipoprecio= new TipoPrecio();
			this.tipoprecioObject=new Object();
			this.tipopreciosObject=new ArrayList<Object>();
			
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
			
			this.tipoprecioDataAccess.setConnexionType(this.connexionType);
			this.tipoprecioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoPrecio getTipoPrecio() throws Exception {	
		TipoPrecioLogicAdditional.checkTipoPrecioToGet(tipoprecio,this.datosCliente,this.arrDatoGeneral);
		TipoPrecioLogicAdditional.updateTipoPrecioToGet(tipoprecio,this.arrDatoGeneral);
		
		return tipoprecio;
	}
		
	public void setTipoPrecio(TipoPrecio newTipoPrecio) {
		this.tipoprecio = newTipoPrecio;
	}
	
	public TipoPrecioDataAccess getTipoPrecioDataAccess() {
		return tipoprecioDataAccess;
	}
	
	public void setTipoPrecioDataAccess(TipoPrecioDataAccess newtipoprecioDataAccess) {
		this.tipoprecioDataAccess = newtipoprecioDataAccess;
	}
	
	public List<TipoPrecio> getTipoPrecios() throws Exception {		
		this.quitarTipoPreciosNulos();
		
		TipoPrecioLogicAdditional.checkTipoPrecioToGets(tipoprecios,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoPrecio tipoprecioLocal: tipoprecios ) {
			TipoPrecioLogicAdditional.updateTipoPrecioToGet(tipoprecioLocal,this.arrDatoGeneral);
		}
		
		return tipoprecios;
	}
	
	public void setTipoPrecios(List<TipoPrecio> newTipoPrecios) {
		this.tipoprecios = newTipoPrecios;
	}
	
	public Object getTipoPrecioObject() {	
		this.tipoprecioObject=this.tipoprecioDataAccess.getEntityObject();
		return this.tipoprecioObject;
	}
		
	public void setTipoPrecioObject(Object newTipoPrecioObject) {
		this.tipoprecioObject = newTipoPrecioObject;
	}
	
	public List<Object> getTipoPreciosObject() {		
		this.tipopreciosObject=this.tipoprecioDataAccess.getEntitiesObject();
		return this.tipopreciosObject;
	}
		
	public void setTipoPreciosObject(List<Object> newTipoPreciosObject) {
		this.tipopreciosObject = newTipoPreciosObject;
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
		
		if(this.tipoprecioDataAccess!=null) {
			this.tipoprecioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoprecioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoprecioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoprecio = new  TipoPrecio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprecio=tipoprecioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecio);
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
		tipoprecio = new  TipoPrecio();
		  		  
        try {
			
			tipoprecio=tipoprecioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoprecio = new  TipoPrecio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprecio=tipoprecioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecio);
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
		tipoprecio = new  TipoPrecio();
		  		  
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
		tipoprecio = new  TipoPrecio();
		  		  
        try {
			
			tipoprecio=tipoprecioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoprecio = new  TipoPrecio();
		  		  
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
		tipoprecio = new  TipoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoprecioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprecio = new  TipoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoprecioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprecio = new  TipoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoprecioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprecio = new  TipoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoprecioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprecio = new  TipoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoprecioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprecio = new  TipoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoprecioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprecios = new  ArrayList<TipoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecios=tipoprecioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrecio(tipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
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
		tipoprecios = new  ArrayList<TipoPrecio>();
		  		  
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
		tipoprecios = new  ArrayList<TipoPrecio>();
		  		  
        try {			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecios=tipoprecioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoPrecio(tipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoprecios = new  ArrayList<TipoPrecio>();
		  		  
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
		tipoprecios = new  ArrayList<TipoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecios=tipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrecio(tipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
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
		tipoprecios = new  ArrayList<TipoPrecio>();
		  		  
        try {
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecios=tipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrecio(tipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
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
		tipoprecios = new  ArrayList<TipoPrecio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecios=tipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrecio(tipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
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
		tipoprecios = new  ArrayList<TipoPrecio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecios=tipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrecio(tipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoprecio = new  TipoPrecio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecio=tipoprecioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrecio(tipoprecio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecio);
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
		tipoprecio = new  TipoPrecio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecio=tipoprecioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrecio(tipoprecio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprecios = new  ArrayList<TipoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecios=tipoprecioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrecio(tipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
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
		tipoprecios = new  ArrayList<TipoPrecio>();
		  		  
        try {
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecios=tipoprecioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrecio(tipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoPreciosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprecios = new  ArrayList<TipoPrecio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getTodosTipoPreciosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPrecio(tipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
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
	
	public  void  getTodosTipoPrecios(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprecios = new  ArrayList<TipoPrecio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPrecio(tipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoPrecio(TipoPrecio tipoprecio) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoprecio.getIsNew() || tipoprecio.getIsChanged()) { 
			this.invalidValues = tipoprecioValidator.getInvalidValues(tipoprecio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoprecio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoPrecio(List<TipoPrecio> TipoPrecios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoPrecio tipoprecioLocal:tipoprecios) {				
			estaValidadoObjeto=this.validarGuardarTipoPrecio(tipoprecioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoPrecio(List<TipoPrecio> TipoPrecios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPrecio(tipoprecios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoPrecio(TipoPrecio TipoPrecio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPrecio(tipoprecio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoPrecio tipoprecio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoprecio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoPrecioConstantesFunciones.getTipoPrecioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoprecio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoPrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoPrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoPrecioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-saveTipoPrecioWithConnection");connexion.begin();			
			
			TipoPrecioLogicAdditional.checkTipoPrecioToSave(this.tipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoPrecioLogicAdditional.updateTipoPrecioToSave(this.tipoprecio,this.arrDatoGeneral);
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprecio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoPrecio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPrecio(this.tipoprecio)) {
				TipoPrecioDataAccess.save(this.tipoprecio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoPrecioLogicAdditional.checkTipoPrecioToSaveAfter(this.tipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPrecio();
			
			connexion.commit();			
			
			if(this.tipoprecio.getIsDeleted()) {
				this.tipoprecio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoPrecio()throws Exception {	
		try {	
			
			TipoPrecioLogicAdditional.checkTipoPrecioToSave(this.tipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoPrecioLogicAdditional.updateTipoPrecioToSave(this.tipoprecio,this.arrDatoGeneral);
			
			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprecio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPrecio(this.tipoprecio)) {			
				TipoPrecioDataAccess.save(this.tipoprecio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoPrecioLogicAdditional.checkTipoPrecioToSaveAfter(this.tipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoprecio.getIsDeleted()) {
				this.tipoprecio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoPreciosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-saveTipoPreciosWithConnection");connexion.begin();			
			
			TipoPrecioLogicAdditional.checkTipoPrecioToSaves(tipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoPrecios();
			
			Boolean validadoTodosTipoPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPrecio tipoprecioLocal:tipoprecios) {		
				if(tipoprecioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoPrecioLogicAdditional.updateTipoPrecioToSave(tipoprecioLocal,this.arrDatoGeneral);
	        	
				TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprecioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPrecio(tipoprecioLocal)) {
					TipoPrecioDataAccess.save(tipoprecioLocal, connexion);				
				} else {
					validadoTodosTipoPrecio=false;
				}
			}
			
			if(!validadoTodosTipoPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoPrecioLogicAdditional.checkTipoPrecioToSavesAfter(tipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPrecios();
			
			connexion.commit();		
			
			this.quitarTipoPreciosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoPrecios()throws Exception {				
		 try {	
			TipoPrecioLogicAdditional.checkTipoPrecioToSaves(tipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPrecio tipoprecioLocal:tipoprecios) {				
				if(tipoprecioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoPrecioLogicAdditional.updateTipoPrecioToSave(tipoprecioLocal,this.arrDatoGeneral);
	        	
				TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprecioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPrecio(tipoprecioLocal)) {				
					TipoPrecioDataAccess.save(tipoprecioLocal, connexion);				
				} else {
					validadoTodosTipoPrecio=false;
				}
			}
			
			if(!validadoTodosTipoPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoPrecioLogicAdditional.checkTipoPrecioToSavesAfter(tipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoPreciosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPrecioParameterReturnGeneral procesarAccionTipoPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPrecio> tipoprecios,TipoPrecioParameterReturnGeneral tipoprecioParameterGeneral)throws Exception {
		 try {	
			TipoPrecioParameterReturnGeneral tipoprecioReturnGeneral=new TipoPrecioParameterReturnGeneral();
	
			TipoPrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprecios,tipoprecioParameterGeneral,tipoprecioReturnGeneral);
			
			return tipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPrecioParameterReturnGeneral procesarAccionTipoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPrecio> tipoprecios,TipoPrecioParameterReturnGeneral tipoprecioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-procesarAccionTipoPreciosWithConnection");connexion.begin();			
			
			TipoPrecioParameterReturnGeneral tipoprecioReturnGeneral=new TipoPrecioParameterReturnGeneral();
	
			TipoPrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprecios,tipoprecioParameterGeneral,tipoprecioReturnGeneral);
			
			this.connexion.commit();
			
			return tipoprecioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPrecioParameterReturnGeneral procesarEventosTipoPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPrecio> tipoprecios,TipoPrecio tipoprecio,TipoPrecioParameterReturnGeneral tipoprecioParameterGeneral,Boolean isEsNuevoTipoPrecio,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoPrecioParameterReturnGeneral tipoprecioReturnGeneral=new TipoPrecioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprecioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoPrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprecios,tipoprecio,tipoprecioParameterGeneral,tipoprecioReturnGeneral,isEsNuevoTipoPrecio,clases);
			
			return tipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoPrecioParameterReturnGeneral procesarEventosTipoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPrecio> tipoprecios,TipoPrecio tipoprecio,TipoPrecioParameterReturnGeneral tipoprecioParameterGeneral,Boolean isEsNuevoTipoPrecio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-procesarEventosTipoPreciosWithConnection");connexion.begin();			
			
			TipoPrecioParameterReturnGeneral tipoprecioReturnGeneral=new TipoPrecioParameterReturnGeneral();
	
			tipoprecioReturnGeneral.setTipoPrecio(tipoprecio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprecioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoPrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprecios,tipoprecio,tipoprecioParameterGeneral,tipoprecioReturnGeneral,isEsNuevoTipoPrecio,clases);
			
			this.connexion.commit();
			
			return tipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPrecioParameterReturnGeneral procesarImportacionTipoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoPrecioParameterReturnGeneral tipoprecioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-procesarImportacionTipoPreciosWithConnection");connexion.begin();			
			
			TipoPrecioParameterReturnGeneral tipoprecioReturnGeneral=new TipoPrecioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoprecios=new ArrayList<TipoPrecio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoprecio=new TipoPrecio();
				
				
				if(conColumnasBase) {this.tipoprecio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoprecio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoprecio.setcodigo(arrColumnas[iColumn++]);
				this.tipoprecio.setnombre(arrColumnas[iColumn++]);
				this.tipoprecio.setfecha_desde(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.tipoprecio.setfecha_hasta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.tipoprecio.setmonto(Double.parseDouble(arrColumnas[iColumn++]));
				this.tipoprecio.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.tipoprecio.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipoprecios.add(this.tipoprecio);
			}
			
			this.saveTipoPrecios();
			
			this.connexion.commit();
			
			tipoprecioReturnGeneral.setConRetornoEstaProcesado(true);
			tipoprecioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoPreciosEliminados() throws Exception {				
		
		List<TipoPrecio> tipopreciosAux= new ArrayList<TipoPrecio>();
		
		for(TipoPrecio tipoprecio:tipoprecios) {
			if(!tipoprecio.getIsDeleted()) {
				tipopreciosAux.add(tipoprecio);
			}
		}
		
		tipoprecios=tipopreciosAux;
	}
	
	public void quitarTipoPreciosNulos() throws Exception {				
		
		List<TipoPrecio> tipopreciosAux= new ArrayList<TipoPrecio>();
		
		for(TipoPrecio tipoprecio : this.tipoprecios) {
			if(tipoprecio==null) {
				tipopreciosAux.add(tipoprecio);
			}
		}
		
		//this.tipoprecios=tipopreciosAux;
		
		this.tipoprecios.removeAll(tipopreciosAux);
	}
	
	public void getSetVersionRowTipoPrecioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoprecio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoprecio.getIsDeleted() || (tipoprecio.getIsChanged()&&!tipoprecio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoprecioDataAccess.getSetVersionRowTipoPrecio(connexion,tipoprecio.getId());
				
				if(!tipoprecio.getVersionRow().equals(timestamp)) {	
					tipoprecio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoprecio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoPrecio()throws Exception {	
		
		if(tipoprecio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoprecio.getIsDeleted() || (tipoprecio.getIsChanged()&&!tipoprecio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoprecioDataAccess.getSetVersionRowTipoPrecio(connexion,tipoprecio.getId());
			
			try {							
				if(!tipoprecio.getVersionRow().equals(timestamp)) {	
					tipoprecio.setVersionRow(timestamp);
				}
				
				tipoprecio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoPreciosWithConnection()throws Exception {	
		if(tipoprecios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoPrecio tipoprecioAux:tipoprecios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoprecioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprecioAux.getIsDeleted() || (tipoprecioAux.getIsChanged()&&!tipoprecioAux.getIsNew())) {
						
						timestamp=tipoprecioDataAccess.getSetVersionRowTipoPrecio(connexion,tipoprecioAux.getId());
						
						if(!tipoprecio.getVersionRow().equals(timestamp)) {	
							tipoprecioAux.setVersionRow(timestamp);
						}
								
						tipoprecioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoPrecios()throws Exception {	
		if(tipoprecios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoPrecio tipoprecioAux:tipoprecios) {
					if(tipoprecioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprecioAux.getIsDeleted() || (tipoprecioAux.getIsChanged()&&!tipoprecioAux.getIsNew())) {
						
						timestamp=tipoprecioDataAccess.getSetVersionRowTipoPrecio(connexion,tipoprecioAux.getId());
						
						if(!tipoprecioAux.getVersionRow().equals(timestamp)) {	
							tipoprecioAux.setVersionRow(timestamp);
						}
						
													
						tipoprecioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoPrecioParameterReturnGeneral cargarCombosLoteForeignKeyTipoPrecioWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoPrecioParameterReturnGeneral  tipoprecioReturnGeneral =new TipoPrecioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoPrecioWithConnection");connexion.begin();
			
			tipoprecioReturnGeneral =new TipoPrecioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoprecioReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoprecioReturnGeneral;
	}
	
	public TipoPrecioParameterReturnGeneral cargarCombosLoteForeignKeyTipoPrecio(String finalQueryGlobalEmpresa) throws Exception {
		TipoPrecioParameterReturnGeneral  tipoprecioReturnGeneral =new TipoPrecioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoprecioReturnGeneral =new TipoPrecioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoprecioReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoprecioReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoPrecioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PrecioLogic precioLogic=new PrecioLogic();
			UtilidadTipoPrecioLogic utilidadtipoprecioLogic=new UtilidadTipoPrecioLogic();
			PedidoPuntoVentaLogic pedidopuntoventaLogic=new PedidoPuntoVentaLogic();
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic=new ParametroCarteraDefectoLogic();
			DescuentoTipoPrecioLogic descuentotipoprecioLogic=new DescuentoTipoPrecioLogic();
			PoliticasClienteLogic politicasclienteLogic=new PoliticasClienteLogic();
			ProformaLogic proformaLogic=new ProformaLogic();
			NotaCreditoSoliLogic notacreditosoliLogic=new NotaCreditoSoliLogic();
			ConsignacionLogic consignacionLogic=new ConsignacionLogic();
			PedidoExporLogic pedidoexporLogic=new PedidoExporLogic();
			ServicioClienteLogic servicioclienteLogic=new ServicioClienteLogic();
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
			GuiaRemisionLogic guiaremisionLogic=new GuiaRemisionLogic();
			ClienteLogic clienteLogic=new ClienteLogic();
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic=new NotaCreditoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoPrecioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Precio.class));
			classes.add(new Classe(UtilidadTipoPrecio.class));
			classes.add(new Classe(PedidoPuntoVenta.class));
			classes.add(new Classe(ParametroCarteraDefecto.class));
			classes.add(new Classe(DescuentoTipoPrecio.class));
			classes.add(new Classe(PoliticasCliente.class));
			classes.add(new Classe(Proforma.class));
			classes.add(new Classe(NotaCreditoSoli.class));
			classes.add(new Classe(Consignacion.class));
			classes.add(new Classe(PedidoExpor.class));
			classes.add(new Classe(ServicioCliente.class));
			classes.add(new Classe(FacturaPuntoVenta.class));
			classes.add(new Classe(GuiaRemision.class));
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(NotaCreditoPuntoVenta.class));
											
			

			precioLogic.setConnexion(this.getConnexion());
			precioLogic.setDatosCliente(this.datosCliente);
			precioLogic.setIsConRefrescarForeignKeys(true);

			utilidadtipoprecioLogic.setConnexion(this.getConnexion());
			utilidadtipoprecioLogic.setDatosCliente(this.datosCliente);
			utilidadtipoprecioLogic.setIsConRefrescarForeignKeys(true);

			pedidopuntoventaLogic.setConnexion(this.getConnexion());
			pedidopuntoventaLogic.setDatosCliente(this.datosCliente);
			pedidopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			parametrocarteradefectoLogic.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic.setDatosCliente(this.datosCliente);
			parametrocarteradefectoLogic.setIsConRefrescarForeignKeys(true);

			descuentotipoprecioLogic.setConnexion(this.getConnexion());
			descuentotipoprecioLogic.setDatosCliente(this.datosCliente);
			descuentotipoprecioLogic.setIsConRefrescarForeignKeys(true);

			politicasclienteLogic.setConnexion(this.getConnexion());
			politicasclienteLogic.setDatosCliente(this.datosCliente);
			politicasclienteLogic.setIsConRefrescarForeignKeys(true);

			proformaLogic.setConnexion(this.getConnexion());
			proformaLogic.setDatosCliente(this.datosCliente);
			proformaLogic.setIsConRefrescarForeignKeys(true);

			notacreditosoliLogic.setConnexion(this.getConnexion());
			notacreditosoliLogic.setDatosCliente(this.datosCliente);
			notacreditosoliLogic.setIsConRefrescarForeignKeys(true);

			consignacionLogic.setConnexion(this.getConnexion());
			consignacionLogic.setDatosCliente(this.datosCliente);
			consignacionLogic.setIsConRefrescarForeignKeys(true);

			pedidoexporLogic.setConnexion(this.getConnexion());
			pedidoexporLogic.setDatosCliente(this.datosCliente);
			pedidoexporLogic.setIsConRefrescarForeignKeys(true);

			servicioclienteLogic.setConnexion(this.getConnexion());
			servicioclienteLogic.setDatosCliente(this.datosCliente);
			servicioclienteLogic.setIsConRefrescarForeignKeys(true);

			facturapuntoventaLogic.setConnexion(this.getConnexion());
			facturapuntoventaLogic.setDatosCliente(this.datosCliente);
			facturapuntoventaLogic.setIsConRefrescarForeignKeys(true);

			guiaremisionLogic.setConnexion(this.getConnexion());
			guiaremisionLogic.setDatosCliente(this.datosCliente);
			guiaremisionLogic.setIsConRefrescarForeignKeys(true);

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			notacreditopuntoventaLogic.setConnexion(this.getConnexion());
			notacreditopuntoventaLogic.setDatosCliente(this.datosCliente);
			notacreditopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoPrecio tipoprecio:this.tipoprecios) {
				

				classes=new ArrayList<Classe>();
				classes=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);

				precioLogic.setPrecios(tipoprecio.precios);
				precioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=UtilidadTipoPrecioConstantesFunciones.getClassesForeignKeysOfUtilidadTipoPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);

				utilidadtipoprecioLogic.setUtilidadTipoPrecios(tipoprecio.utilidadtipoprecios);
				utilidadtipoprecioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidopuntoventaLogic.setPedidoPuntoVentas(tipoprecio.pedidopuntoventas);
				pedidopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocarteradefectoLogic.setParametroCarteraDefectos(tipoprecio.parametrocarteradefectos);
				parametrocarteradefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DescuentoTipoPrecioConstantesFunciones.getClassesForeignKeysOfDescuentoTipoPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);

				descuentotipoprecioLogic.setDescuentoTipoPrecios(tipoprecio.descuentotipoprecios);
				descuentotipoprecioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				politicasclienteLogic.setPoliticasClientes(tipoprecio.politicasclientes);
				politicasclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(new ArrayList<Classe>(),DeepLoadType.NONE);

				proformaLogic.setProformas(tipoprecio.proformas);
				proformaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditosoliLogic.setNotaCreditoSolis(tipoprecio.notacreditosolis);
				notacreditosoliLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				consignacionLogic.setConsignacions(tipoprecio.consignacions);
				consignacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoexporLogic.setPedidoExpors(tipoprecio.pedidoexpors);
				pedidoexporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ServicioClienteConstantesFunciones.getClassesForeignKeysOfServicioCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				servicioclienteLogic.setServicioClientes(tipoprecio.servicioclientes);
				servicioclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturapuntoventaLogic.setFacturaPuntoVentas(tipoprecio.facturapuntoventas);
				facturapuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GuiaRemisionConstantesFunciones.getClassesForeignKeysOfGuiaRemision(new ArrayList<Classe>(),DeepLoadType.NONE);

				guiaremisionLogic.setGuiaRemisions(tipoprecio.guiaremisions);
				guiaremisionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(tipoprecio.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(tipoprecio.notacreditopuntoventas);
				notacreditopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoPrecio tipoprecio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoPrecioLogicAdditional.updateTipoPrecioToGet(tipoprecio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprecio.setEmpresa(tipoprecioDataAccess.getEmpresa(connexion,tipoprecio));
		tipoprecio.setPrecios(tipoprecioDataAccess.getPrecios(connexion,tipoprecio));
		tipoprecio.setPoliticasClientes(tipoprecioDataAccess.getPoliticasClientes(connexion,tipoprecio));
		tipoprecio.setNotaCreditoSolis(tipoprecioDataAccess.getNotaCreditoSolis(connexion,tipoprecio));
		tipoprecio.setGuiaRemisions(tipoprecioDataAccess.getGuiaRemisions(connexion,tipoprecio));
		tipoprecio.setPedidoExpors(tipoprecioDataAccess.getPedidoExpors(connexion,tipoprecio));
		tipoprecio.setFacturaPuntoVentas(tipoprecioDataAccess.getFacturaPuntoVentas(connexion,tipoprecio));
		tipoprecio.setPedidoPuntoVentas(tipoprecioDataAccess.getPedidoPuntoVentas(connexion,tipoprecio));
		tipoprecio.setUtilidadTipoPrecios(tipoprecioDataAccess.getUtilidadTipoPrecios(connexion,tipoprecio));
		tipoprecio.setClientes(tipoprecioDataAccess.getClientes(connexion,tipoprecio));
		tipoprecio.setServicioClientes(tipoprecioDataAccess.getServicioClientes(connexion,tipoprecio));
		tipoprecio.setProformas(tipoprecioDataAccess.getProformas(connexion,tipoprecio));
		tipoprecio.setDescuentoTipoPrecios(tipoprecioDataAccess.getDescuentoTipoPrecios(connexion,tipoprecio));
		tipoprecio.setNotaCreditoPuntoVentas(tipoprecioDataAccess.getNotaCreditoPuntoVentas(connexion,tipoprecio));
		tipoprecio.setParametroCarteraDefectos(tipoprecioDataAccess.getParametroCarteraDefectos(connexion,tipoprecio));
		tipoprecio.setConsignacions(tipoprecioDataAccess.getConsignacions(connexion,tipoprecio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoprecio.setEmpresa(tipoprecioDataAccess.getEmpresa(connexion,tipoprecio));
				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setPrecios(tipoprecioDataAccess.getPrecios(connexion,tipoprecio));

				if(this.isConDeep) {
					PrecioLogic precioLogic= new PrecioLogic(this.connexion);
					precioLogic.setPrecios(tipoprecio.getPrecios());
					ArrayList<Classe> classesLocal=PrecioConstantesFunciones.getClassesForeignKeysOfPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);
					precioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PrecioConstantesFunciones.refrescarForeignKeysDescripcionesPrecio(precioLogic.getPrecios());
					tipoprecio.setPrecios(precioLogic.getPrecios());
				}

				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setPoliticasClientes(tipoprecioDataAccess.getPoliticasClientes(connexion,tipoprecio));

				if(this.isConDeep) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(this.connexion);
					politicasclienteLogic.setPoliticasClientes(tipoprecio.getPoliticasClientes());
					ArrayList<Classe> classesLocal=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					politicasclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(politicasclienteLogic.getPoliticasClientes());
					tipoprecio.setPoliticasClientes(politicasclienteLogic.getPoliticasClientes());
				}

				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setNotaCreditoSolis(tipoprecioDataAccess.getNotaCreditoSolis(connexion,tipoprecio));

				if(this.isConDeep) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(this.connexion);
					notacreditosoliLogic.setNotaCreditoSolis(tipoprecio.getNotaCreditoSolis());
					ArrayList<Classe> classesLocal=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditosoliLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(notacreditosoliLogic.getNotaCreditoSolis());
					tipoprecio.setNotaCreditoSolis(notacreditosoliLogic.getNotaCreditoSolis());
				}

				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setGuiaRemisions(tipoprecioDataAccess.getGuiaRemisions(connexion,tipoprecio));

				if(this.isConDeep) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(this.connexion);
					guiaremisionLogic.setGuiaRemisions(tipoprecio.getGuiaRemisions());
					ArrayList<Classe> classesLocal=GuiaRemisionConstantesFunciones.getClassesForeignKeysOfGuiaRemision(new ArrayList<Classe>(),DeepLoadType.NONE);
					guiaremisionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(guiaremisionLogic.getGuiaRemisions());
					tipoprecio.setGuiaRemisions(guiaremisionLogic.getGuiaRemisions());
				}

				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setPedidoExpors(tipoprecioDataAccess.getPedidoExpors(connexion,tipoprecio));

				if(this.isConDeep) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(this.connexion);
					pedidoexporLogic.setPedidoExpors(tipoprecio.getPedidoExpors());
					ArrayList<Classe> classesLocal=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoexporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(pedidoexporLogic.getPedidoExpors());
					tipoprecio.setPedidoExpors(pedidoexporLogic.getPedidoExpors());
				}

				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setFacturaPuntoVentas(tipoprecioDataAccess.getFacturaPuntoVentas(connexion,tipoprecio));

				if(this.isConDeep) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(this.connexion);
					facturapuntoventaLogic.setFacturaPuntoVentas(tipoprecio.getFacturaPuntoVentas());
					ArrayList<Classe> classesLocal=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturapuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(facturapuntoventaLogic.getFacturaPuntoVentas());
					tipoprecio.setFacturaPuntoVentas(facturapuntoventaLogic.getFacturaPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setPedidoPuntoVentas(tipoprecioDataAccess.getPedidoPuntoVentas(connexion,tipoprecio));

				if(this.isConDeep) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(this.connexion);
					pedidopuntoventaLogic.setPedidoPuntoVentas(tipoprecio.getPedidoPuntoVentas());
					ArrayList<Classe> classesLocal=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(pedidopuntoventaLogic.getPedidoPuntoVentas());
					tipoprecio.setPedidoPuntoVentas(pedidopuntoventaLogic.getPedidoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(UtilidadTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setUtilidadTipoPrecios(tipoprecioDataAccess.getUtilidadTipoPrecios(connexion,tipoprecio));

				if(this.isConDeep) {
					UtilidadTipoPrecioLogic utilidadtipoprecioLogic= new UtilidadTipoPrecioLogic(this.connexion);
					utilidadtipoprecioLogic.setUtilidadTipoPrecios(tipoprecio.getUtilidadTipoPrecios());
					ArrayList<Classe> classesLocal=UtilidadTipoPrecioConstantesFunciones.getClassesForeignKeysOfUtilidadTipoPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);
					utilidadtipoprecioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(utilidadtipoprecioLogic.getUtilidadTipoPrecios());
					tipoprecio.setUtilidadTipoPrecios(utilidadtipoprecioLogic.getUtilidadTipoPrecios());
				}

				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setClientes(tipoprecioDataAccess.getClientes(connexion,tipoprecio));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(tipoprecio.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					tipoprecio.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setServicioClientes(tipoprecioDataAccess.getServicioClientes(connexion,tipoprecio));

				if(this.isConDeep) {
					ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(this.connexion);
					servicioclienteLogic.setServicioClientes(tipoprecio.getServicioClientes());
					ArrayList<Classe> classesLocal=ServicioClienteConstantesFunciones.getClassesForeignKeysOfServicioCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					servicioclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ServicioClienteConstantesFunciones.refrescarForeignKeysDescripcionesServicioCliente(servicioclienteLogic.getServicioClientes());
					tipoprecio.setServicioClientes(servicioclienteLogic.getServicioClientes());
				}

				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setProformas(tipoprecioDataAccess.getProformas(connexion,tipoprecio));

				if(this.isConDeep) {
					ProformaLogic proformaLogic= new ProformaLogic(this.connexion);
					proformaLogic.setProformas(tipoprecio.getProformas());
					ArrayList<Classe> classesLocal=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(new ArrayList<Classe>(),DeepLoadType.NONE);
					proformaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(proformaLogic.getProformas());
					tipoprecio.setProformas(proformaLogic.getProformas());
				}

				continue;
			}

			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setDescuentoTipoPrecios(tipoprecioDataAccess.getDescuentoTipoPrecios(connexion,tipoprecio));

				if(this.isConDeep) {
					DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(this.connexion);
					descuentotipoprecioLogic.setDescuentoTipoPrecios(tipoprecio.getDescuentoTipoPrecios());
					ArrayList<Classe> classesLocal=DescuentoTipoPrecioConstantesFunciones.getClassesForeignKeysOfDescuentoTipoPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);
					descuentotipoprecioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(descuentotipoprecioLogic.getDescuentoTipoPrecios());
					tipoprecio.setDescuentoTipoPrecios(descuentotipoprecioLogic.getDescuentoTipoPrecios());
				}

				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setNotaCreditoPuntoVentas(tipoprecioDataAccess.getNotaCreditoPuntoVentas(connexion,tipoprecio));

				if(this.isConDeep) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(this.connexion);
					notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(tipoprecio.getNotaCreditoPuntoVentas());
					ArrayList<Classe> classesLocal=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
					tipoprecio.setNotaCreditoPuntoVentas(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setParametroCarteraDefectos(tipoprecioDataAccess.getParametroCarteraDefectos(connexion,tipoprecio));

				if(this.isConDeep) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(this.connexion);
					parametrocarteradefectoLogic.setParametroCarteraDefectos(tipoprecio.getParametroCarteraDefectos());
					ArrayList<Classe> classesLocal=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocarteradefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectoLogic.getParametroCarteraDefectos());
					tipoprecio.setParametroCarteraDefectos(parametrocarteradefectoLogic.getParametroCarteraDefectos());
				}

				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setConsignacions(tipoprecioDataAccess.getConsignacions(connexion,tipoprecio));

				if(this.isConDeep) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(this.connexion);
					consignacionLogic.setConsignacions(tipoprecio.getConsignacions());
					ArrayList<Classe> classesLocal=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					consignacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(consignacionLogic.getConsignacions());
					tipoprecio.setConsignacions(consignacionLogic.getConsignacions());
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
			tipoprecio.setEmpresa(tipoprecioDataAccess.getEmpresa(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Precio.class));
			tipoprecio.setPrecios(tipoprecioDataAccess.getPrecios(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			tipoprecio.setPoliticasClientes(tipoprecioDataAccess.getPoliticasClientes(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			tipoprecio.setNotaCreditoSolis(tipoprecioDataAccess.getNotaCreditoSolis(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GuiaRemision.class));
			tipoprecio.setGuiaRemisions(tipoprecioDataAccess.getGuiaRemisions(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			tipoprecio.setPedidoExpors(tipoprecioDataAccess.getPedidoExpors(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaPuntoVenta.class));
			tipoprecio.setFacturaPuntoVentas(tipoprecioDataAccess.getFacturaPuntoVentas(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoPuntoVenta.class));
			tipoprecio.setPedidoPuntoVentas(tipoprecioDataAccess.getPedidoPuntoVentas(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UtilidadTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UtilidadTipoPrecio.class));
			tipoprecio.setUtilidadTipoPrecios(tipoprecioDataAccess.getUtilidadTipoPrecios(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			tipoprecio.setClientes(tipoprecioDataAccess.getClientes(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioCliente.class));
			tipoprecio.setServicioClientes(tipoprecioDataAccess.getServicioClientes(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Proforma.class));
			tipoprecio.setProformas(tipoprecioDataAccess.getProformas(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DescuentoTipoPrecio.class));
			tipoprecio.setDescuentoTipoPrecios(tipoprecioDataAccess.getDescuentoTipoPrecios(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoPuntoVenta.class));
			tipoprecio.setNotaCreditoPuntoVentas(tipoprecioDataAccess.getNotaCreditoPuntoVentas(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			tipoprecio.setParametroCarteraDefectos(tipoprecioDataAccess.getParametroCarteraDefectos(connexion,tipoprecio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			tipoprecio.setConsignacions(tipoprecioDataAccess.getConsignacions(connexion,tipoprecio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprecio.setEmpresa(tipoprecioDataAccess.getEmpresa(connexion,tipoprecio));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoprecio.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoprecio.setPrecios(tipoprecioDataAccess.getPrecios(connexion,tipoprecio));

		for(Precio precio:tipoprecio.getPrecios()) {
			PrecioLogic precioLogic= new PrecioLogic(connexion);
			precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
		}

		tipoprecio.setPoliticasClientes(tipoprecioDataAccess.getPoliticasClientes(connexion,tipoprecio));

		for(PoliticasCliente politicascliente:tipoprecio.getPoliticasClientes()) {
			PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
			politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
		}

		tipoprecio.setNotaCreditoSolis(tipoprecioDataAccess.getNotaCreditoSolis(connexion,tipoprecio));

		for(NotaCreditoSoli notacreditosoli:tipoprecio.getNotaCreditoSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
		}

		tipoprecio.setGuiaRemisions(tipoprecioDataAccess.getGuiaRemisions(connexion,tipoprecio));

		for(GuiaRemision guiaremision:tipoprecio.getGuiaRemisions()) {
			GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
			guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
		}

		tipoprecio.setPedidoExpors(tipoprecioDataAccess.getPedidoExpors(connexion,tipoprecio));

		for(PedidoExpor pedidoexpor:tipoprecio.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
		}

		tipoprecio.setFacturaPuntoVentas(tipoprecioDataAccess.getFacturaPuntoVentas(connexion,tipoprecio));

		for(FacturaPuntoVenta facturapuntoventa:tipoprecio.getFacturaPuntoVentas()) {
			FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
			facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
		}

		tipoprecio.setPedidoPuntoVentas(tipoprecioDataAccess.getPedidoPuntoVentas(connexion,tipoprecio));

		for(PedidoPuntoVenta pedidopuntoventa:tipoprecio.getPedidoPuntoVentas()) {
			PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
			pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
		}

		tipoprecio.setUtilidadTipoPrecios(tipoprecioDataAccess.getUtilidadTipoPrecios(connexion,tipoprecio));

		for(UtilidadTipoPrecio utilidadtipoprecio:tipoprecio.getUtilidadTipoPrecios()) {
			UtilidadTipoPrecioLogic utilidadtipoprecioLogic= new UtilidadTipoPrecioLogic(connexion);
			utilidadtipoprecioLogic.deepLoad(utilidadtipoprecio,isDeep,deepLoadType,clases);
		}

		tipoprecio.setClientes(tipoprecioDataAccess.getClientes(connexion,tipoprecio));

		for(Cliente cliente:tipoprecio.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		tipoprecio.setServicioClientes(tipoprecioDataAccess.getServicioClientes(connexion,tipoprecio));

		for(ServicioCliente serviciocliente:tipoprecio.getServicioClientes()) {
			ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
			servicioclienteLogic.deepLoad(serviciocliente,isDeep,deepLoadType,clases);
		}

		tipoprecio.setProformas(tipoprecioDataAccess.getProformas(connexion,tipoprecio));

		for(Proforma proforma:tipoprecio.getProformas()) {
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
		}

		tipoprecio.setDescuentoTipoPrecios(tipoprecioDataAccess.getDescuentoTipoPrecios(connexion,tipoprecio));

		for(DescuentoTipoPrecio descuentotipoprecio:tipoprecio.getDescuentoTipoPrecios()) {
			DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(connexion);
			descuentotipoprecioLogic.deepLoad(descuentotipoprecio,isDeep,deepLoadType,clases);
		}

		tipoprecio.setNotaCreditoPuntoVentas(tipoprecioDataAccess.getNotaCreditoPuntoVentas(connexion,tipoprecio));

		for(NotaCreditoPuntoVenta notacreditopuntoventa:tipoprecio.getNotaCreditoPuntoVentas()) {
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
			notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
		}

		tipoprecio.setParametroCarteraDefectos(tipoprecioDataAccess.getParametroCarteraDefectos(connexion,tipoprecio));

		for(ParametroCarteraDefecto parametrocarteradefecto:tipoprecio.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}

		tipoprecio.setConsignacions(tipoprecioDataAccess.getConsignacions(connexion,tipoprecio));

		for(Consignacion consignacion:tipoprecio.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoprecio.setEmpresa(tipoprecioDataAccess.getEmpresa(connexion,tipoprecio));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoprecio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setPrecios(tipoprecioDataAccess.getPrecios(connexion,tipoprecio));

				for(Precio precio:tipoprecio.getPrecios()) {
					PrecioLogic precioLogic= new PrecioLogic(connexion);
					precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setPoliticasClientes(tipoprecioDataAccess.getPoliticasClientes(connexion,tipoprecio));

				for(PoliticasCliente politicascliente:tipoprecio.getPoliticasClientes()) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
					politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setNotaCreditoSolis(tipoprecioDataAccess.getNotaCreditoSolis(connexion,tipoprecio));

				for(NotaCreditoSoli notacreditosoli:tipoprecio.getNotaCreditoSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setGuiaRemisions(tipoprecioDataAccess.getGuiaRemisions(connexion,tipoprecio));

				for(GuiaRemision guiaremision:tipoprecio.getGuiaRemisions()) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
					guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setPedidoExpors(tipoprecioDataAccess.getPedidoExpors(connexion,tipoprecio));

				for(PedidoExpor pedidoexpor:tipoprecio.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setFacturaPuntoVentas(tipoprecioDataAccess.getFacturaPuntoVentas(connexion,tipoprecio));

				for(FacturaPuntoVenta facturapuntoventa:tipoprecio.getFacturaPuntoVentas()) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
					facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setPedidoPuntoVentas(tipoprecioDataAccess.getPedidoPuntoVentas(connexion,tipoprecio));

				for(PedidoPuntoVenta pedidopuntoventa:tipoprecio.getPedidoPuntoVentas()) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
					pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(UtilidadTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setUtilidadTipoPrecios(tipoprecioDataAccess.getUtilidadTipoPrecios(connexion,tipoprecio));

				for(UtilidadTipoPrecio utilidadtipoprecio:tipoprecio.getUtilidadTipoPrecios()) {
					UtilidadTipoPrecioLogic utilidadtipoprecioLogic= new UtilidadTipoPrecioLogic(connexion);
					utilidadtipoprecioLogic.deepLoad(utilidadtipoprecio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setClientes(tipoprecioDataAccess.getClientes(connexion,tipoprecio));

				for(Cliente cliente:tipoprecio.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setServicioClientes(tipoprecioDataAccess.getServicioClientes(connexion,tipoprecio));

				for(ServicioCliente serviciocliente:tipoprecio.getServicioClientes()) {
					ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
					servicioclienteLogic.deepLoad(serviciocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setProformas(tipoprecioDataAccess.getProformas(connexion,tipoprecio));

				for(Proforma proforma:tipoprecio.getProformas()) {
					ProformaLogic proformaLogic= new ProformaLogic(connexion);
					proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setDescuentoTipoPrecios(tipoprecioDataAccess.getDescuentoTipoPrecios(connexion,tipoprecio));

				for(DescuentoTipoPrecio descuentotipoprecio:tipoprecio.getDescuentoTipoPrecios()) {
					DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(connexion);
					descuentotipoprecioLogic.deepLoad(descuentotipoprecio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setNotaCreditoPuntoVentas(tipoprecioDataAccess.getNotaCreditoPuntoVentas(connexion,tipoprecio));

				for(NotaCreditoPuntoVenta notacreditopuntoventa:tipoprecio.getNotaCreditoPuntoVentas()) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
					notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setParametroCarteraDefectos(tipoprecioDataAccess.getParametroCarteraDefectos(connexion,tipoprecio));

				for(ParametroCarteraDefecto parametrocarteradefecto:tipoprecio.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprecio.setConsignacions(tipoprecioDataAccess.getConsignacions(connexion,tipoprecio));

				for(Consignacion consignacion:tipoprecio.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
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
			tipoprecio.setEmpresa(tipoprecioDataAccess.getEmpresa(connexion,tipoprecio));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoprecio.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Precio.class));
			tipoprecio.setPrecios(tipoprecioDataAccess.getPrecios(connexion,tipoprecio));

			for(Precio precio:tipoprecio.getPrecios()) {
				PrecioLogic precioLogic= new PrecioLogic(connexion);
				precioLogic.deepLoad(precio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			tipoprecio.setPoliticasClientes(tipoprecioDataAccess.getPoliticasClientes(connexion,tipoprecio));

			for(PoliticasCliente politicascliente:tipoprecio.getPoliticasClientes()) {
				PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
				politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			tipoprecio.setNotaCreditoSolis(tipoprecioDataAccess.getNotaCreditoSolis(connexion,tipoprecio));

			for(NotaCreditoSoli notacreditosoli:tipoprecio.getNotaCreditoSolis()) {
				NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
				notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GuiaRemision.class));
			tipoprecio.setGuiaRemisions(tipoprecioDataAccess.getGuiaRemisions(connexion,tipoprecio));

			for(GuiaRemision guiaremision:tipoprecio.getGuiaRemisions()) {
				GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
				guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			tipoprecio.setPedidoExpors(tipoprecioDataAccess.getPedidoExpors(connexion,tipoprecio));

			for(PedidoExpor pedidoexpor:tipoprecio.getPedidoExpors()) {
				PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
				pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaPuntoVenta.class));
			tipoprecio.setFacturaPuntoVentas(tipoprecioDataAccess.getFacturaPuntoVentas(connexion,tipoprecio));

			for(FacturaPuntoVenta facturapuntoventa:tipoprecio.getFacturaPuntoVentas()) {
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoPuntoVenta.class));
			tipoprecio.setPedidoPuntoVentas(tipoprecioDataAccess.getPedidoPuntoVentas(connexion,tipoprecio));

			for(PedidoPuntoVenta pedidopuntoventa:tipoprecio.getPedidoPuntoVentas()) {
				PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
				pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UtilidadTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UtilidadTipoPrecio.class));
			tipoprecio.setUtilidadTipoPrecios(tipoprecioDataAccess.getUtilidadTipoPrecios(connexion,tipoprecio));

			for(UtilidadTipoPrecio utilidadtipoprecio:tipoprecio.getUtilidadTipoPrecios()) {
				UtilidadTipoPrecioLogic utilidadtipoprecioLogic= new UtilidadTipoPrecioLogic(connexion);
				utilidadtipoprecioLogic.deepLoad(utilidadtipoprecio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			tipoprecio.setClientes(tipoprecioDataAccess.getClientes(connexion,tipoprecio));

			for(Cliente cliente:tipoprecio.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioCliente.class));
			tipoprecio.setServicioClientes(tipoprecioDataAccess.getServicioClientes(connexion,tipoprecio));

			for(ServicioCliente serviciocliente:tipoprecio.getServicioClientes()) {
				ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
				servicioclienteLogic.deepLoad(serviciocliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Proforma.class));
			tipoprecio.setProformas(tipoprecioDataAccess.getProformas(connexion,tipoprecio));

			for(Proforma proforma:tipoprecio.getProformas()) {
				ProformaLogic proformaLogic= new ProformaLogic(connexion);
				proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DescuentoTipoPrecio.class));
			tipoprecio.setDescuentoTipoPrecios(tipoprecioDataAccess.getDescuentoTipoPrecios(connexion,tipoprecio));

			for(DescuentoTipoPrecio descuentotipoprecio:tipoprecio.getDescuentoTipoPrecios()) {
				DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(connexion);
				descuentotipoprecioLogic.deepLoad(descuentotipoprecio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoPuntoVenta.class));
			tipoprecio.setNotaCreditoPuntoVentas(tipoprecioDataAccess.getNotaCreditoPuntoVentas(connexion,tipoprecio));

			for(NotaCreditoPuntoVenta notacreditopuntoventa:tipoprecio.getNotaCreditoPuntoVentas()) {
				NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
				notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			tipoprecio.setParametroCarteraDefectos(tipoprecioDataAccess.getParametroCarteraDefectos(connexion,tipoprecio));

			for(ParametroCarteraDefecto parametrocarteradefecto:tipoprecio.getParametroCarteraDefectos()) {
				ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
				parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			tipoprecio.setConsignacions(tipoprecioDataAccess.getConsignacions(connexion,tipoprecio));

			for(Consignacion consignacion:tipoprecio.getConsignacions()) {
				ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
				consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoPrecio tipoprecio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoPrecioLogicAdditional.updateTipoPrecioToSave(tipoprecio,this.arrDatoGeneral);
			
TipoPrecioDataAccess.save(tipoprecio, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoprecio.getEmpresa(),connexion);

		for(Precio precio:tipoprecio.getPrecios()) {
			precio.setid_tipo_precio(tipoprecio.getId());
			PrecioDataAccess.save(precio,connexion);
		}

		for(PoliticasCliente politicascliente:tipoprecio.getPoliticasClientes()) {
			politicascliente.setid_tipo_precio(tipoprecio.getId());
			PoliticasClienteDataAccess.save(politicascliente,connexion);
		}

		for(NotaCreditoSoli notacreditosoli:tipoprecio.getNotaCreditoSolis()) {
			notacreditosoli.setid_tipo_precio(tipoprecio.getId());
			NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
		}

		for(GuiaRemision guiaremision:tipoprecio.getGuiaRemisions()) {
			guiaremision.setid_tipo_precio(tipoprecio.getId());
			GuiaRemisionDataAccess.save(guiaremision,connexion);
		}

		for(PedidoExpor pedidoexpor:tipoprecio.getPedidoExpors()) {
			pedidoexpor.setid_tipo_precio(tipoprecio.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
		}

		for(FacturaPuntoVenta facturapuntoventa:tipoprecio.getFacturaPuntoVentas()) {
			facturapuntoventa.setid_tipo_precio(tipoprecio.getId());
			FacturaPuntoVentaDataAccess.save(facturapuntoventa,connexion);
		}

		for(PedidoPuntoVenta pedidopuntoventa:tipoprecio.getPedidoPuntoVentas()) {
			pedidopuntoventa.setid_tipo_precio(tipoprecio.getId());
			PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
		}

		for(UtilidadTipoPrecio utilidadtipoprecio:tipoprecio.getUtilidadTipoPrecios()) {
			utilidadtipoprecio.setid_tipo_precio(tipoprecio.getId());
			UtilidadTipoPrecioDataAccess.save(utilidadtipoprecio,connexion);
		}

		for(Cliente cliente:tipoprecio.getClientes()) {
			cliente.setid_tipo_precio(tipoprecio.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(ServicioCliente serviciocliente:tipoprecio.getServicioClientes()) {
			serviciocliente.setid_tipo_precio(tipoprecio.getId());
			ServicioClienteDataAccess.save(serviciocliente,connexion);
		}

		for(Proforma proforma:tipoprecio.getProformas()) {
			proforma.setid_tipo_precio(tipoprecio.getId());
			ProformaDataAccess.save(proforma,connexion);
		}

		for(DescuentoTipoPrecio descuentotipoprecio:tipoprecio.getDescuentoTipoPrecios()) {
			descuentotipoprecio.setid_tipo_precio(tipoprecio.getId());
			DescuentoTipoPrecioDataAccess.save(descuentotipoprecio,connexion);
		}

		for(NotaCreditoPuntoVenta notacreditopuntoventa:tipoprecio.getNotaCreditoPuntoVentas()) {
			notacreditopuntoventa.setid_tipo_precio(tipoprecio.getId());
			NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:tipoprecio.getParametroCarteraDefectos()) {
			parametrocarteradefecto.setid_tipo_precio(tipoprecio.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
		}

		for(Consignacion consignacion:tipoprecio.getConsignacions()) {
			consignacion.setid_tipo_precio(tipoprecio.getId());
			ConsignacionDataAccess.save(consignacion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoprecio.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Precio precio:tipoprecio.getPrecios()) {
					precio.setid_tipo_precio(tipoprecio.getId());
					PrecioDataAccess.save(precio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticasCliente politicascliente:tipoprecio.getPoliticasClientes()) {
					politicascliente.setid_tipo_precio(tipoprecio.getId());
					PoliticasClienteDataAccess.save(politicascliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoSoli notacreditosoli:tipoprecio.getNotaCreditoSolis()) {
					notacreditosoli.setid_tipo_precio(tipoprecio.getId());
					NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GuiaRemision guiaremision:tipoprecio.getGuiaRemisions()) {
					guiaremision.setid_tipo_precio(tipoprecio.getId());
					GuiaRemisionDataAccess.save(guiaremision,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:tipoprecio.getPedidoExpors()) {
					pedidoexpor.setid_tipo_precio(tipoprecio.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaPuntoVenta facturapuntoventa:tipoprecio.getFacturaPuntoVentas()) {
					facturapuntoventa.setid_tipo_precio(tipoprecio.getId());
					FacturaPuntoVentaDataAccess.save(facturapuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoPuntoVenta pedidopuntoventa:tipoprecio.getPedidoPuntoVentas()) {
					pedidopuntoventa.setid_tipo_precio(tipoprecio.getId());
					PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(UtilidadTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UtilidadTipoPrecio utilidadtipoprecio:tipoprecio.getUtilidadTipoPrecios()) {
					utilidadtipoprecio.setid_tipo_precio(tipoprecio.getId());
					UtilidadTipoPrecioDataAccess.save(utilidadtipoprecio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:tipoprecio.getClientes()) {
					cliente.setid_tipo_precio(tipoprecio.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioCliente serviciocliente:tipoprecio.getServicioClientes()) {
					serviciocliente.setid_tipo_precio(tipoprecio.getId());
					ServicioClienteDataAccess.save(serviciocliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Proforma proforma:tipoprecio.getProformas()) {
					proforma.setid_tipo_precio(tipoprecio.getId());
					ProformaDataAccess.save(proforma,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DescuentoTipoPrecio descuentotipoprecio:tipoprecio.getDescuentoTipoPrecios()) {
					descuentotipoprecio.setid_tipo_precio(tipoprecio.getId());
					DescuentoTipoPrecioDataAccess.save(descuentotipoprecio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoPuntoVenta notacreditopuntoventa:tipoprecio.getNotaCreditoPuntoVentas()) {
					notacreditopuntoventa.setid_tipo_precio(tipoprecio.getId());
					NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:tipoprecio.getParametroCarteraDefectos()) {
					parametrocarteradefecto.setid_tipo_precio(tipoprecio.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignacion consignacion:tipoprecio.getConsignacions()) {
					consignacion.setid_tipo_precio(tipoprecio.getId());
					ConsignacionDataAccess.save(consignacion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoprecio.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoprecio.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Precio precio:tipoprecio.getPrecios()) {
			PrecioLogic precioLogic= new PrecioLogic(connexion);
			precio.setid_tipo_precio(tipoprecio.getId());
			PrecioDataAccess.save(precio,connexion);
			precioLogic.deepSave(precio,isDeep,deepLoadType,clases);
		}

		for(PoliticasCliente politicascliente:tipoprecio.getPoliticasClientes()) {
			PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
			politicascliente.setid_tipo_precio(tipoprecio.getId());
			PoliticasClienteDataAccess.save(politicascliente,connexion);
			politicasclienteLogic.deepSave(politicascliente,isDeep,deepLoadType,clases);
		}

		for(NotaCreditoSoli notacreditosoli:tipoprecio.getNotaCreditoSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoli.setid_tipo_precio(tipoprecio.getId());
			NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
			notacreditosoliLogic.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
		}

		for(GuiaRemision guiaremision:tipoprecio.getGuiaRemisions()) {
			GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
			guiaremision.setid_tipo_precio(tipoprecio.getId());
			GuiaRemisionDataAccess.save(guiaremision,connexion);
			guiaremisionLogic.deepSave(guiaremision,isDeep,deepLoadType,clases);
		}

		for(PedidoExpor pedidoexpor:tipoprecio.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexpor.setid_tipo_precio(tipoprecio.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
			pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
		}

		for(FacturaPuntoVenta facturapuntoventa:tipoprecio.getFacturaPuntoVentas()) {
			FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
			facturapuntoventa.setid_tipo_precio(tipoprecio.getId());
			FacturaPuntoVentaDataAccess.save(facturapuntoventa,connexion);
			facturapuntoventaLogic.deepSave(facturapuntoventa,isDeep,deepLoadType,clases);
		}

		for(PedidoPuntoVenta pedidopuntoventa:tipoprecio.getPedidoPuntoVentas()) {
			PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
			pedidopuntoventa.setid_tipo_precio(tipoprecio.getId());
			PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
			pedidopuntoventaLogic.deepSave(pedidopuntoventa,isDeep,deepLoadType,clases);
		}

		for(UtilidadTipoPrecio utilidadtipoprecio:tipoprecio.getUtilidadTipoPrecios()) {
			UtilidadTipoPrecioLogic utilidadtipoprecioLogic= new UtilidadTipoPrecioLogic(connexion);
			utilidadtipoprecio.setid_tipo_precio(tipoprecio.getId());
			UtilidadTipoPrecioDataAccess.save(utilidadtipoprecio,connexion);
			utilidadtipoprecioLogic.deepSave(utilidadtipoprecio,isDeep,deepLoadType,clases);
		}

		for(Cliente cliente:tipoprecio.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_tipo_precio(tipoprecio.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(ServicioCliente serviciocliente:tipoprecio.getServicioClientes()) {
			ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
			serviciocliente.setid_tipo_precio(tipoprecio.getId());
			ServicioClienteDataAccess.save(serviciocliente,connexion);
			servicioclienteLogic.deepSave(serviciocliente,isDeep,deepLoadType,clases);
		}

		for(Proforma proforma:tipoprecio.getProformas()) {
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proforma.setid_tipo_precio(tipoprecio.getId());
			ProformaDataAccess.save(proforma,connexion);
			proformaLogic.deepSave(proforma,isDeep,deepLoadType,clases);
		}

		for(DescuentoTipoPrecio descuentotipoprecio:tipoprecio.getDescuentoTipoPrecios()) {
			DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(connexion);
			descuentotipoprecio.setid_tipo_precio(tipoprecio.getId());
			DescuentoTipoPrecioDataAccess.save(descuentotipoprecio,connexion);
			descuentotipoprecioLogic.deepSave(descuentotipoprecio,isDeep,deepLoadType,clases);
		}

		for(NotaCreditoPuntoVenta notacreditopuntoventa:tipoprecio.getNotaCreditoPuntoVentas()) {
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
			notacreditopuntoventa.setid_tipo_precio(tipoprecio.getId());
			NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
			notacreditopuntoventaLogic.deepSave(notacreditopuntoventa,isDeep,deepLoadType,clases);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:tipoprecio.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefecto.setid_tipo_precio(tipoprecio.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
			parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}

		for(Consignacion consignacion:tipoprecio.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacion.setid_tipo_precio(tipoprecio.getId());
			ConsignacionDataAccess.save(consignacion,connexion);
			consignacionLogic.deepSave(consignacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoprecio.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoprecio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Precio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Precio precio:tipoprecio.getPrecios()) {
					PrecioLogic precioLogic= new PrecioLogic(connexion);
					precio.setid_tipo_precio(tipoprecio.getId());
					PrecioDataAccess.save(precio,connexion);
					precioLogic.deepSave(precio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticasCliente politicascliente:tipoprecio.getPoliticasClientes()) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
					politicascliente.setid_tipo_precio(tipoprecio.getId());
					PoliticasClienteDataAccess.save(politicascliente,connexion);
					politicasclienteLogic.deepSave(politicascliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoSoli notacreditosoli:tipoprecio.getNotaCreditoSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoli.setid_tipo_precio(tipoprecio.getId());
					NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
					notacreditosoliLogic.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GuiaRemision guiaremision:tipoprecio.getGuiaRemisions()) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
					guiaremision.setid_tipo_precio(tipoprecio.getId());
					GuiaRemisionDataAccess.save(guiaremision,connexion);
					guiaremisionLogic.deepSave(guiaremision,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:tipoprecio.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexpor.setid_tipo_precio(tipoprecio.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
					pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaPuntoVenta facturapuntoventa:tipoprecio.getFacturaPuntoVentas()) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
					facturapuntoventa.setid_tipo_precio(tipoprecio.getId());
					FacturaPuntoVentaDataAccess.save(facturapuntoventa,connexion);
					facturapuntoventaLogic.deepSave(facturapuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoPuntoVenta pedidopuntoventa:tipoprecio.getPedidoPuntoVentas()) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
					pedidopuntoventa.setid_tipo_precio(tipoprecio.getId());
					PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
					pedidopuntoventaLogic.deepSave(pedidopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(UtilidadTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UtilidadTipoPrecio utilidadtipoprecio:tipoprecio.getUtilidadTipoPrecios()) {
					UtilidadTipoPrecioLogic utilidadtipoprecioLogic= new UtilidadTipoPrecioLogic(connexion);
					utilidadtipoprecio.setid_tipo_precio(tipoprecio.getId());
					UtilidadTipoPrecioDataAccess.save(utilidadtipoprecio,connexion);
					utilidadtipoprecioLogic.deepSave(utilidadtipoprecio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:tipoprecio.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_tipo_precio(tipoprecio.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioCliente serviciocliente:tipoprecio.getServicioClientes()) {
					ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
					serviciocliente.setid_tipo_precio(tipoprecio.getId());
					ServicioClienteDataAccess.save(serviciocliente,connexion);
					servicioclienteLogic.deepSave(serviciocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Proforma proforma:tipoprecio.getProformas()) {
					ProformaLogic proformaLogic= new ProformaLogic(connexion);
					proforma.setid_tipo_precio(tipoprecio.getId());
					ProformaDataAccess.save(proforma,connexion);
					proformaLogic.deepSave(proforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DescuentoTipoPrecio descuentotipoprecio:tipoprecio.getDescuentoTipoPrecios()) {
					DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(connexion);
					descuentotipoprecio.setid_tipo_precio(tipoprecio.getId());
					DescuentoTipoPrecioDataAccess.save(descuentotipoprecio,connexion);
					descuentotipoprecioLogic.deepSave(descuentotipoprecio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoPuntoVenta notacreditopuntoventa:tipoprecio.getNotaCreditoPuntoVentas()) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
					notacreditopuntoventa.setid_tipo_precio(tipoprecio.getId());
					NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
					notacreditopuntoventaLogic.deepSave(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:tipoprecio.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefecto.setid_tipo_precio(tipoprecio.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
					parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignacion consignacion:tipoprecio.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacion.setid_tipo_precio(tipoprecio.getId());
					ConsignacionDataAccess.save(consignacion,connexion);
					consignacionLogic.deepSave(consignacion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoPrecio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoprecio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(tipoprecio);
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
			this.deepLoad(this.tipoprecio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoPrecio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoprecios!=null) {
				for(TipoPrecio tipoprecio:tipoprecios) {
					this.deepLoad(tipoprecio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(tipoprecios);
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
			if(tipoprecios!=null) {
				for(TipoPrecio tipoprecio:tipoprecios) {
					this.deepLoad(tipoprecio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(tipoprecios);
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
			this.getNewConnexionToDeep(TipoPrecio.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoprecio,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoPrecio.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoprecios!=null) {
				for(TipoPrecio tipoprecio:tipoprecios) {
					this.deepSave(tipoprecio,isDeep,deepLoadType,clases);
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
			if(tipoprecios!=null) {
				for(TipoPrecio tipoprecio:tipoprecios) {
					this.deepSave(tipoprecio,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoPreciosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoPrecioConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPreciosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoPrecioConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoPreciosBusquedaPorFechaDesdeWithConnection(String sFinalQuery,Pagination pagination,Date fecha_desde)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaDesde= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaDesde.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_desde,TipoPrecioConstantesFunciones.FECHADESDE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaDesde);

			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaDesde","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPreciosBusquedaPorFechaDesde(String sFinalQuery,Pagination pagination,Date fecha_desde)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaDesde= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaDesde.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_desde,TipoPrecioConstantesFunciones.FECHADESDE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaDesde);

			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaDesde","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoPreciosBusquedaPorFechaHastaWithConnection(String sFinalQuery,Pagination pagination,Date fecha_hasta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHasta= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHasta.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_hasta,TipoPrecioConstantesFunciones.FECHAHASTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHasta);

			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaHasta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPreciosBusquedaPorFechaHasta(String sFinalQuery,Pagination pagination,Date fecha_hasta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHasta= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHasta.setParameterSelectionGeneralEqual(ParameterType.DATE,fecha_hasta,TipoPrecioConstantesFunciones.FECHAHASTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHasta);

			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaHasta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoPreciosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoPrecioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPreciosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoPrecioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoPreciosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoPrecioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPreciosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoPrecioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprecios=tipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrecio(this.tipoprecios);
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
			if(TipoPrecioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrecioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoPrecio tipoprecio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoPrecioConstantesFunciones.ISCONAUDITORIA) {
				if(tipoprecio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrecioDataAccess.TABLENAME, tipoprecio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPrecioLogic.registrarAuditoriaDetallesTipoPrecio(connexion,tipoprecio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoprecio.getIsDeleted()) {
					/*if(!tipoprecio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoPrecioDataAccess.TABLENAME, tipoprecio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoPrecioLogic.registrarAuditoriaDetallesTipoPrecio(connexion,tipoprecio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrecioDataAccess.TABLENAME, tipoprecio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoprecio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrecioDataAccess.TABLENAME, tipoprecio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPrecioLogic.registrarAuditoriaDetallesTipoPrecio(connexion,tipoprecio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoPrecio(Connexion connexion,TipoPrecio tipoprecio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoprecio.getIsNew()||!tipoprecio.getid_empresa().equals(tipoprecio.getTipoPrecioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprecio.getTipoPrecioOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoprecio.getTipoPrecioOriginal().getid_empresa().toString();
				}
				if(tipoprecio.getid_empresa()!=null)
				{
					strValorNuevo=tipoprecio.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrecioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoprecio.getIsNew()||!tipoprecio.getcodigo().equals(tipoprecio.getTipoPrecioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprecio.getTipoPrecioOriginal().getcodigo()!=null)
				{
					strValorActual=tipoprecio.getTipoPrecioOriginal().getcodigo();
				}
				if(tipoprecio.getcodigo()!=null)
				{
					strValorNuevo=tipoprecio.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrecioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoprecio.getIsNew()||!tipoprecio.getnombre().equals(tipoprecio.getTipoPrecioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprecio.getTipoPrecioOriginal().getnombre()!=null)
				{
					strValorActual=tipoprecio.getTipoPrecioOriginal().getnombre();
				}
				if(tipoprecio.getnombre()!=null)
				{
					strValorNuevo=tipoprecio.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrecioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipoprecio.getIsNew()||!tipoprecio.getfecha_desde().equals(tipoprecio.getTipoPrecioOriginal().getfecha_desde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprecio.getTipoPrecioOriginal().getfecha_desde()!=null)
				{
					strValorActual=tipoprecio.getTipoPrecioOriginal().getfecha_desde().toString();
				}
				if(tipoprecio.getfecha_desde()!=null)
				{
					strValorNuevo=tipoprecio.getfecha_desde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrecioConstantesFunciones.FECHADESDE,strValorActual,strValorNuevo);
			}	
			
			if(tipoprecio.getIsNew()||!tipoprecio.getfecha_hasta().equals(tipoprecio.getTipoPrecioOriginal().getfecha_hasta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprecio.getTipoPrecioOriginal().getfecha_hasta()!=null)
				{
					strValorActual=tipoprecio.getTipoPrecioOriginal().getfecha_hasta().toString();
				}
				if(tipoprecio.getfecha_hasta()!=null)
				{
					strValorNuevo=tipoprecio.getfecha_hasta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrecioConstantesFunciones.FECHAHASTA,strValorActual,strValorNuevo);
			}	
			
			if(tipoprecio.getIsNew()||!tipoprecio.getmonto().equals(tipoprecio.getTipoPrecioOriginal().getmonto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprecio.getTipoPrecioOriginal().getmonto()!=null)
				{
					strValorActual=tipoprecio.getTipoPrecioOriginal().getmonto().toString();
				}
				if(tipoprecio.getmonto()!=null)
				{
					strValorNuevo=tipoprecio.getmonto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrecioConstantesFunciones.MONTO,strValorActual,strValorNuevo);
			}	
			
			if(tipoprecio.getIsNew()||!tipoprecio.getesta_activo().equals(tipoprecio.getTipoPrecioOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprecio.getTipoPrecioOriginal().getesta_activo()!=null)
				{
					strValorActual=tipoprecio.getTipoPrecioOriginal().getesta_activo().toString();
				}
				if(tipoprecio.getesta_activo()!=null)
				{
					strValorNuevo=tipoprecio.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrecioConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(tipoprecio.getIsNew()||!tipoprecio.getdescripcion().equals(tipoprecio.getTipoPrecioOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprecio.getTipoPrecioOriginal().getdescripcion()!=null)
				{
					strValorActual=tipoprecio.getTipoPrecioOriginal().getdescripcion();
				}
				if(tipoprecio.getdescripcion()!=null)
				{
					strValorNuevo=tipoprecio.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrecioConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoPrecioRelacionesWithConnection(TipoPrecio tipoprecio,List<Precio> precios,List<PoliticasCliente> politicasclientes,List<NotaCreditoSoli> notacreditosolis,List<GuiaRemision> guiaremisions,List<PedidoExpor> pedidoexpors,List<FacturaPuntoVenta> facturapuntoventas,List<PedidoPuntoVenta> pedidopuntoventas,List<UtilidadTipoPrecio> utilidadtipoprecios,List<Cliente> clientes,List<ServicioCliente> servicioclientes,List<Proforma> proformas,List<DescuentoTipoPrecio> descuentotipoprecios,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<ParametroCarteraDefecto> parametrocarteradefectos,List<Consignacion> consignacions) throws Exception {

		if(!tipoprecio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoPrecioRelacionesBase(tipoprecio,precios,politicasclientes,notacreditosolis,guiaremisions,pedidoexpors,facturapuntoventas,pedidopuntoventas,utilidadtipoprecios,clientes,servicioclientes,proformas,descuentotipoprecios,notacreditopuntoventas,parametrocarteradefectos,consignacions,true);
		}
	}

	public void saveTipoPrecioRelaciones(TipoPrecio tipoprecio,List<Precio> precios,List<PoliticasCliente> politicasclientes,List<NotaCreditoSoli> notacreditosolis,List<GuiaRemision> guiaremisions,List<PedidoExpor> pedidoexpors,List<FacturaPuntoVenta> facturapuntoventas,List<PedidoPuntoVenta> pedidopuntoventas,List<UtilidadTipoPrecio> utilidadtipoprecios,List<Cliente> clientes,List<ServicioCliente> servicioclientes,List<Proforma> proformas,List<DescuentoTipoPrecio> descuentotipoprecios,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<ParametroCarteraDefecto> parametrocarteradefectos,List<Consignacion> consignacions)throws Exception {

		if(!tipoprecio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoPrecioRelacionesBase(tipoprecio,precios,politicasclientes,notacreditosolis,guiaremisions,pedidoexpors,facturapuntoventas,pedidopuntoventas,utilidadtipoprecios,clientes,servicioclientes,proformas,descuentotipoprecios,notacreditopuntoventas,parametrocarteradefectos,consignacions,false);
		}
	}

	public void saveTipoPrecioRelacionesBase(TipoPrecio tipoprecio,List<Precio> precios,List<PoliticasCliente> politicasclientes,List<NotaCreditoSoli> notacreditosolis,List<GuiaRemision> guiaremisions,List<PedidoExpor> pedidoexpors,List<FacturaPuntoVenta> facturapuntoventas,List<PedidoPuntoVenta> pedidopuntoventas,List<UtilidadTipoPrecio> utilidadtipoprecios,List<Cliente> clientes,List<ServicioCliente> servicioclientes,List<Proforma> proformas,List<DescuentoTipoPrecio> descuentotipoprecios,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<ParametroCarteraDefecto> parametrocarteradefectos,List<Consignacion> consignacions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoPrecio-saveRelacionesWithConnection");}
	
			tipoprecio.setPrecios(precios);
			tipoprecio.setPoliticasClientes(politicasclientes);
			tipoprecio.setNotaCreditoSolis(notacreditosolis);
			tipoprecio.setGuiaRemisions(guiaremisions);
			tipoprecio.setPedidoExpors(pedidoexpors);
			tipoprecio.setFacturaPuntoVentas(facturapuntoventas);
			tipoprecio.setPedidoPuntoVentas(pedidopuntoventas);
			tipoprecio.setUtilidadTipoPrecios(utilidadtipoprecios);
			tipoprecio.setClientes(clientes);
			tipoprecio.setServicioClientes(servicioclientes);
			tipoprecio.setProformas(proformas);
			tipoprecio.setDescuentoTipoPrecios(descuentotipoprecios);
			tipoprecio.setNotaCreditoPuntoVentas(notacreditopuntoventas);
			tipoprecio.setParametroCarteraDefectos(parametrocarteradefectos);
			tipoprecio.setConsignacions(consignacions);

			this.setTipoPrecio(tipoprecio);

			if(TipoPrecioLogicAdditional.validarSaveRelaciones(tipoprecio,this)) {

				TipoPrecioLogicAdditional.updateRelacionesToSave(tipoprecio,this);

				if((tipoprecio.getIsNew()||tipoprecio.getIsChanged())&&!tipoprecio.getIsDeleted()) {
					this.saveTipoPrecio();
					this.saveTipoPrecioRelacionesDetalles(precios,politicasclientes,notacreditosolis,guiaremisions,pedidoexpors,facturapuntoventas,pedidopuntoventas,utilidadtipoprecios,clientes,servicioclientes,proformas,descuentotipoprecios,notacreditopuntoventas,parametrocarteradefectos,consignacions);

				} else if(tipoprecio.getIsDeleted()) {
					this.saveTipoPrecioRelacionesDetalles(precios,politicasclientes,notacreditosolis,guiaremisions,pedidoexpors,facturapuntoventas,pedidopuntoventas,utilidadtipoprecios,clientes,servicioclientes,proformas,descuentotipoprecios,notacreditopuntoventas,parametrocarteradefectos,consignacions);
					this.saveTipoPrecio();
				}

				TipoPrecioLogicAdditional.updateRelacionesToSaveAfter(tipoprecio,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PrecioConstantesFunciones.InicializarGeneralEntityAuxiliaresPrecios(precios,true,true);
			PoliticasClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresPoliticasClientes(politicasclientes,true,true);
			NotaCreditoSoliConstantesFunciones.InicializarGeneralEntityAuxiliaresNotaCreditoSolis(notacreditosolis,true,true);
			GuiaRemisionConstantesFunciones.InicializarGeneralEntityAuxiliaresGuiaRemisions(guiaremisions,true,true);
			PedidoExporConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoExpors(pedidoexpors,true,true);
			FacturaPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturaPuntoVentas(facturapuntoventas,true,true);
			PedidoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoPuntoVentas(pedidopuntoventas,true,true);
			UtilidadTipoPrecioConstantesFunciones.InicializarGeneralEntityAuxiliaresUtilidadTipoPrecios(utilidadtipoprecios,true,true);
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			ServicioClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresServicioClientes(servicioclientes,true,true);
			ProformaConstantesFunciones.InicializarGeneralEntityAuxiliaresProformas(proformas,true,true);
			DescuentoTipoPrecioConstantesFunciones.InicializarGeneralEntityAuxiliaresDescuentoTipoPrecios(descuentotipoprecios,true,true);
			NotaCreditoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresNotaCreditoPuntoVentas(notacreditopuntoventas,true,true);
			ParametroCarteraDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCarteraDefectos(parametrocarteradefectos,true,true);
			ConsignacionConstantesFunciones.InicializarGeneralEntityAuxiliaresConsignacions(consignacions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoPrecioRelacionesDetalles(List<Precio> precios,List<PoliticasCliente> politicasclientes,List<NotaCreditoSoli> notacreditosolis,List<GuiaRemision> guiaremisions,List<PedidoExpor> pedidoexpors,List<FacturaPuntoVenta> facturapuntoventas,List<PedidoPuntoVenta> pedidopuntoventas,List<UtilidadTipoPrecio> utilidadtipoprecios,List<Cliente> clientes,List<ServicioCliente> servicioclientes,List<Proforma> proformas,List<DescuentoTipoPrecio> descuentotipoprecios,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<ParametroCarteraDefecto> parametrocarteradefectos,List<Consignacion> consignacions)throws Exception {
		try {
	

			Long idTipoPrecioActual=this.getTipoPrecio().getId();

			PrecioLogic precioLogic_Desde_TipoPrecio=new PrecioLogic();
			precioLogic_Desde_TipoPrecio.setPrecios(precios);

			precioLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			precioLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(Precio precio_Desde_TipoPrecio:precioLogic_Desde_TipoPrecio.getPrecios()) {
				precio_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);
			}

			precioLogic_Desde_TipoPrecio.savePrecios();

			PoliticasClienteLogic politicasclienteLogic_Desde_TipoPrecio=new PoliticasClienteLogic();
			politicasclienteLogic_Desde_TipoPrecio.setPoliticasClientes(politicasclientes);

			politicasclienteLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			politicasclienteLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(PoliticasCliente politicascliente_Desde_TipoPrecio:politicasclienteLogic_Desde_TipoPrecio.getPoliticasClientes()) {
				politicascliente_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);
			}

			politicasclienteLogic_Desde_TipoPrecio.savePoliticasClientes();

			NotaCreditoSoliLogic notacreditosoliLogic_Desde_TipoPrecio=new NotaCreditoSoliLogic();
			notacreditosoliLogic_Desde_TipoPrecio.setNotaCreditoSolis(notacreditosolis);

			notacreditosoliLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			notacreditosoliLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(NotaCreditoSoli notacreditosoli_Desde_TipoPrecio:notacreditosoliLogic_Desde_TipoPrecio.getNotaCreditoSolis()) {
				notacreditosoli_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);

				notacreditosoliLogic_Desde_TipoPrecio.setNotaCreditoSoli(notacreditosoli_Desde_TipoPrecio);
				notacreditosoliLogic_Desde_TipoPrecio.saveNotaCreditoSoli();

				Long idNotaCreditoSoliActual=notacreditosoli_Desde_TipoPrecio.getId();

				DetaNotaCreditoSoliLogic detanotacreditosoliLogic_Desde_NotaCreditoSoli=new DetaNotaCreditoSoliLogic();

				if(notacreditosoli_Desde_TipoPrecio.getDetaNotaCreditoSolis()==null){
					notacreditosoli_Desde_TipoPrecio.setDetaNotaCreditoSolis(new ArrayList<DetaNotaCreditoSoli>());
				}

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setDetaNotaCreditoSolis(notacreditosoli_Desde_TipoPrecio.getDetaNotaCreditoSolis());

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setConnexion(this.getConnexion());
				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setDatosCliente(this.datosCliente);

				for(DetaNotaCreditoSoli detanotacreditosoli_Desde_NotaCreditoSoli:detanotacreditosoliLogic_Desde_NotaCreditoSoli.getDetaNotaCreditoSolis()) {
					detanotacreditosoli_Desde_NotaCreditoSoli.setid_nota_credito_soli(idNotaCreditoSoliActual);
				}

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.saveDetaNotaCreditoSolis();
			}


			GuiaRemisionLogic guiaremisionLogic_Desde_TipoPrecio=new GuiaRemisionLogic();
			guiaremisionLogic_Desde_TipoPrecio.setGuiaRemisions(guiaremisions);

			guiaremisionLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			guiaremisionLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(GuiaRemision guiaremision_Desde_TipoPrecio:guiaremisionLogic_Desde_TipoPrecio.getGuiaRemisions()) {
				guiaremision_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);

				guiaremisionLogic_Desde_TipoPrecio.setGuiaRemision(guiaremision_Desde_TipoPrecio);
				guiaremisionLogic_Desde_TipoPrecio.saveGuiaRemision();

				Long idGuiaRemisionActual=guiaremision_Desde_TipoPrecio.getId();

				DetalleGuiaRemisionLogic detalleguiaremisionLogic_Desde_GuiaRemision=new DetalleGuiaRemisionLogic();

				if(guiaremision_Desde_TipoPrecio.getDetalleGuiaRemisions()==null){
					guiaremision_Desde_TipoPrecio.setDetalleGuiaRemisions(new ArrayList<DetalleGuiaRemision>());
				}

				detalleguiaremisionLogic_Desde_GuiaRemision.setDetalleGuiaRemisions(guiaremision_Desde_TipoPrecio.getDetalleGuiaRemisions());

				detalleguiaremisionLogic_Desde_GuiaRemision.setConnexion(this.getConnexion());
				detalleguiaremisionLogic_Desde_GuiaRemision.setDatosCliente(this.datosCliente);

				for(DetalleGuiaRemision detalleguiaremision_Desde_GuiaRemision:detalleguiaremisionLogic_Desde_GuiaRemision.getDetalleGuiaRemisions()) {
					detalleguiaremision_Desde_GuiaRemision.setid_guia_remision(idGuiaRemisionActual);
				}

				detalleguiaremisionLogic_Desde_GuiaRemision.saveDetalleGuiaRemisions();
			}


			PedidoExporLogic pedidoexporLogic_Desde_TipoPrecio=new PedidoExporLogic();
			pedidoexporLogic_Desde_TipoPrecio.setPedidoExpors(pedidoexpors);

			pedidoexporLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			pedidoexporLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(PedidoExpor pedidoexpor_Desde_TipoPrecio:pedidoexporLogic_Desde_TipoPrecio.getPedidoExpors()) {
				pedidoexpor_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);

				pedidoexporLogic_Desde_TipoPrecio.setPedidoExpor(pedidoexpor_Desde_TipoPrecio);
				pedidoexporLogic_Desde_TipoPrecio.savePedidoExpor();

				Long idPedidoExporActual=pedidoexpor_Desde_TipoPrecio.getId();

				DetallePedidoExporLogic detallepedidoexporLogic_Desde_PedidoExpor=new DetallePedidoExporLogic();

				if(pedidoexpor_Desde_TipoPrecio.getDetallePedidoExpors()==null){
					pedidoexpor_Desde_TipoPrecio.setDetallePedidoExpors(new ArrayList<DetallePedidoExpor>());
				}

				detallepedidoexporLogic_Desde_PedidoExpor.setDetallePedidoExpors(pedidoexpor_Desde_TipoPrecio.getDetallePedidoExpors());

				detallepedidoexporLogic_Desde_PedidoExpor.setConnexion(this.getConnexion());
				detallepedidoexporLogic_Desde_PedidoExpor.setDatosCliente(this.datosCliente);

				for(DetallePedidoExpor detallepedidoexpor_Desde_PedidoExpor:detallepedidoexporLogic_Desde_PedidoExpor.getDetallePedidoExpors()) {
					detallepedidoexpor_Desde_PedidoExpor.setid_pedido_expor(idPedidoExporActual);
				}

				detallepedidoexporLogic_Desde_PedidoExpor.saveDetallePedidoExpors();
			}


			FacturaPuntoVentaLogic facturapuntoventaLogic_Desde_TipoPrecio=new FacturaPuntoVentaLogic();
			facturapuntoventaLogic_Desde_TipoPrecio.setFacturaPuntoVentas(facturapuntoventas);

			facturapuntoventaLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			facturapuntoventaLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(FacturaPuntoVenta facturapuntoventa_Desde_TipoPrecio:facturapuntoventaLogic_Desde_TipoPrecio.getFacturaPuntoVentas()) {
				facturapuntoventa_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);

				facturapuntoventaLogic_Desde_TipoPrecio.setFacturaPuntoVenta(facturapuntoventa_Desde_TipoPrecio);
				facturapuntoventaLogic_Desde_TipoPrecio.saveFacturaPuntoVenta();

				Long idFacturaPuntoVentaActual=facturapuntoventa_Desde_TipoPrecio.getId();

				FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_FacturaPuntoVenta=new FormaPagoPuntoVentaLogic();

				if(facturapuntoventa_Desde_TipoPrecio.getFormaPagoPuntoVentas()==null){
					facturapuntoventa_Desde_TipoPrecio.setFormaPagoPuntoVentas(new ArrayList<FormaPagoPuntoVenta>());
				}

				formapagopuntoventaLogic_Desde_FacturaPuntoVenta.setFormaPagoPuntoVentas(facturapuntoventa_Desde_TipoPrecio.getFormaPagoPuntoVentas());

				formapagopuntoventaLogic_Desde_FacturaPuntoVenta.setConnexion(this.getConnexion());
				formapagopuntoventaLogic_Desde_FacturaPuntoVenta.setDatosCliente(this.datosCliente);

				for(FormaPagoPuntoVenta formapagopuntoventa_Desde_FacturaPuntoVenta:formapagopuntoventaLogic_Desde_FacturaPuntoVenta.getFormaPagoPuntoVentas()) {
					formapagopuntoventa_Desde_FacturaPuntoVenta.setid_factura_punto_venta(idFacturaPuntoVentaActual);
				}

				formapagopuntoventaLogic_Desde_FacturaPuntoVenta.saveFormaPagoPuntoVentas();

				DetalleFacturaPuntoVentaLogic detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta=new DetalleFacturaPuntoVentaLogic();

				if(facturapuntoventa_Desde_TipoPrecio.getDetalleFacturaPuntoVentas()==null){
					facturapuntoventa_Desde_TipoPrecio.setDetalleFacturaPuntoVentas(new ArrayList<DetalleFacturaPuntoVenta>());
				}

				detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.setDetalleFacturaPuntoVentas(facturapuntoventa_Desde_TipoPrecio.getDetalleFacturaPuntoVentas());

				detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.setConnexion(this.getConnexion());
				detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.setDatosCliente(this.datosCliente);

				for(DetalleFacturaPuntoVenta detallefacturapuntoventa_Desde_FacturaPuntoVenta:detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.getDetalleFacturaPuntoVentas()) {
					detallefacturapuntoventa_Desde_FacturaPuntoVenta.setid_factura_punto_venta(idFacturaPuntoVentaActual);
				}

				detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.saveDetalleFacturaPuntoVentas();
			}


			PedidoPuntoVentaLogic pedidopuntoventaLogic_Desde_TipoPrecio=new PedidoPuntoVentaLogic();
			pedidopuntoventaLogic_Desde_TipoPrecio.setPedidoPuntoVentas(pedidopuntoventas);

			pedidopuntoventaLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			pedidopuntoventaLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(PedidoPuntoVenta pedidopuntoventa_Desde_TipoPrecio:pedidopuntoventaLogic_Desde_TipoPrecio.getPedidoPuntoVentas()) {
				pedidopuntoventa_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);

				pedidopuntoventaLogic_Desde_TipoPrecio.setPedidoPuntoVenta(pedidopuntoventa_Desde_TipoPrecio);
				pedidopuntoventaLogic_Desde_TipoPrecio.savePedidoPuntoVenta();

				Long idPedidoPuntoVentaActual=pedidopuntoventa_Desde_TipoPrecio.getId();

				DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta=new DetallePedidoPuntoVentaLogic();

				if(pedidopuntoventa_Desde_TipoPrecio.getDetallePedidoPuntoVentas()==null){
					pedidopuntoventa_Desde_TipoPrecio.setDetallePedidoPuntoVentas(new ArrayList<DetallePedidoPuntoVenta>());
				}

				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setDetallePedidoPuntoVentas(pedidopuntoventa_Desde_TipoPrecio.getDetallePedidoPuntoVentas());

				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setConnexion(this.getConnexion());
				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setDatosCliente(this.datosCliente);

				for(DetallePedidoPuntoVenta detallepedidopuntoventa_Desde_PedidoPuntoVenta:detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.getDetallePedidoPuntoVentas()) {
					detallepedidopuntoventa_Desde_PedidoPuntoVenta.setid_pedido_punto_venta(idPedidoPuntoVentaActual);
				}

				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.saveDetallePedidoPuntoVentas();
			}


			UtilidadTipoPrecioLogic utilidadtipoprecioLogic_Desde_TipoPrecio=new UtilidadTipoPrecioLogic();
			utilidadtipoprecioLogic_Desde_TipoPrecio.setUtilidadTipoPrecios(utilidadtipoprecios);

			utilidadtipoprecioLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			utilidadtipoprecioLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(UtilidadTipoPrecio utilidadtipoprecio_Desde_TipoPrecio:utilidadtipoprecioLogic_Desde_TipoPrecio.getUtilidadTipoPrecios()) {
				utilidadtipoprecio_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);
			}

			utilidadtipoprecioLogic_Desde_TipoPrecio.saveUtilidadTipoPrecios();

			ClienteLogic clienteLogic_Desde_TipoPrecio=new ClienteLogic();
			clienteLogic_Desde_TipoPrecio.setClientes(clientes);

			clienteLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			clienteLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_TipoPrecio:clienteLogic_Desde_TipoPrecio.getClientes()) {
				cliente_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);

				clienteLogic_Desde_TipoPrecio.setCliente(cliente_Desde_TipoPrecio);
				clienteLogic_Desde_TipoPrecio.saveCliente();
			}


			ServicioClienteLogic servicioclienteLogic_Desde_TipoPrecio=new ServicioClienteLogic();
			servicioclienteLogic_Desde_TipoPrecio.setServicioClientes(servicioclientes);

			servicioclienteLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			servicioclienteLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(ServicioCliente serviciocliente_Desde_TipoPrecio:servicioclienteLogic_Desde_TipoPrecio.getServicioClientes()) {
				serviciocliente_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);
			}

			servicioclienteLogic_Desde_TipoPrecio.saveServicioClientes();

			ProformaLogic proformaLogic_Desde_TipoPrecio=new ProformaLogic();
			proformaLogic_Desde_TipoPrecio.setProformas(proformas);

			proformaLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			proformaLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(Proforma proforma_Desde_TipoPrecio:proformaLogic_Desde_TipoPrecio.getProformas()) {
				proforma_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);

				proformaLogic_Desde_TipoPrecio.setProforma(proforma_Desde_TipoPrecio);
				proformaLogic_Desde_TipoPrecio.saveProforma();
			}


			DescuentoTipoPrecioLogic descuentotipoprecioLogic_Desde_TipoPrecio=new DescuentoTipoPrecioLogic();
			descuentotipoprecioLogic_Desde_TipoPrecio.setDescuentoTipoPrecios(descuentotipoprecios);

			descuentotipoprecioLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			descuentotipoprecioLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(DescuentoTipoPrecio descuentotipoprecio_Desde_TipoPrecio:descuentotipoprecioLogic_Desde_TipoPrecio.getDescuentoTipoPrecios()) {
				descuentotipoprecio_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);
			}

			descuentotipoprecioLogic_Desde_TipoPrecio.saveDescuentoTipoPrecios();

			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic_Desde_TipoPrecio=new NotaCreditoPuntoVentaLogic();
			notacreditopuntoventaLogic_Desde_TipoPrecio.setNotaCreditoPuntoVentas(notacreditopuntoventas);

			notacreditopuntoventaLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			notacreditopuntoventaLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(NotaCreditoPuntoVenta notacreditopuntoventa_Desde_TipoPrecio:notacreditopuntoventaLogic_Desde_TipoPrecio.getNotaCreditoPuntoVentas()) {
				notacreditopuntoventa_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);

				notacreditopuntoventaLogic_Desde_TipoPrecio.setNotaCreditoPuntoVenta(notacreditopuntoventa_Desde_TipoPrecio);
				notacreditopuntoventaLogic_Desde_TipoPrecio.saveNotaCreditoPuntoVenta();
			}


			ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_TipoPrecio=new ParametroCarteraDefectoLogic();
			parametrocarteradefectoLogic_Desde_TipoPrecio.setParametroCarteraDefectos(parametrocarteradefectos);

			parametrocarteradefectoLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(ParametroCarteraDefecto parametrocarteradefecto_Desde_TipoPrecio:parametrocarteradefectoLogic_Desde_TipoPrecio.getParametroCarteraDefectos()) {
				parametrocarteradefecto_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);
			}

			parametrocarteradefectoLogic_Desde_TipoPrecio.saveParametroCarteraDefectos();

			ConsignacionLogic consignacionLogic_Desde_TipoPrecio=new ConsignacionLogic();
			consignacionLogic_Desde_TipoPrecio.setConsignacions(consignacions);

			consignacionLogic_Desde_TipoPrecio.setConnexion(this.getConnexion());
			consignacionLogic_Desde_TipoPrecio.setDatosCliente(this.datosCliente);

			for(Consignacion consignacion_Desde_TipoPrecio:consignacionLogic_Desde_TipoPrecio.getConsignacions()) {
				consignacion_Desde_TipoPrecio.setid_tipo_precio(idTipoPrecioActual);

				consignacionLogic_Desde_TipoPrecio.setConsignacion(consignacion_Desde_TipoPrecio);
				consignacionLogic_Desde_TipoPrecio.saveConsignacion();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPrecioConstantesFunciones.getClassesForeignKeysOfTipoPrecio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPrecioConstantesFunciones.getClassesRelationshipsOfTipoPrecio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
